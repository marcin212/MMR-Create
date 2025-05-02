package com.bymarcin.mmrcreate.blockentity;

import com.bymarcin.mmrcreate.data.KineticComponent;
import com.bymarcin.mmrcreate.data.StressHolder;
import com.bymarcin.mmrcreate.data.StressHolderObserver;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import es.degrassi.mmreborn.api.controller.ControllerAccessible;
import es.degrassi.mmreborn.common.data.Config;
import es.degrassi.mmreborn.common.entity.MachineControllerEntity;
import es.degrassi.mmreborn.common.entity.base.ColorableMachineEntity;
import es.degrassi.mmreborn.common.entity.base.MachineComponentEntity;
import es.degrassi.mmreborn.common.machine.IOType;
import es.degrassi.mmreborn.common.manager.crafting.MachineStatus;
import es.degrassi.mmreborn.common.network.server.SUpdateMachineColorPacket;
import es.degrassi.mmreborn.common.util.IEntitySynchronizable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KineticOutputHatchEntity extends GeneratingKineticBlockEntity implements MachineComponentEntity<KineticComponent>, ColorableMachineEntity, IEntitySynchronizable, ControllerAccessible {
    private final StressHolder stress = new StressHolder();
    private final StressHolderObserver stressObserver = new StressHolderObserver(stress);
    private int casingColor = Config.machineColor;
    private boolean requestModelUpdate = false;
    private BlockPos controllerPos;

    // This timout is used so that the Create network is not updated if the next recipe starts within the timeout period. (prevents network updates between same recipes)
    private int currentProducingChangeTimeout = 0;
    private static final int PRODUCING_CHANGE_TIMEOUT = 10;


    private static final String REQUEST_UPDATE_KEY = "requestModelUpdate";
    private static final String CASING_COLOR = "casingColor";
    private static final String CONTROLLER_POS_KEY = "controllerPos";


    public KineticOutputHatchEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public int getMachineColor() {
        return casingColor;
    }

    @Override
    public float getGeneratedSpeed() {
        return stress.isProducing() ? stress.getRpm() : 0;
    }

    public float calculateAddedStressCapacity() {
        float capacity = stress.isProducing() ? (float) stress.getStress()/stress.getRpm() : 0;
        this.lastCapacityProvided = capacity;
        return capacity;
    }


    @Override
    public void setMachineColor(int newColor) {
        setChanged();
        this.casingColor = newColor;
        setRequestModelUpdate(true);
        triggerEvent(1, 0);
        this.markForUpdate();
        if (getLevel() instanceof ServerLevel l) {
            PacketDistributor.sendToPlayersTrackingChunk(l, new ChunkPos(getBlockPos()),
                    new SUpdateMachineColorPacket(newColor, getBlockPos()));
        }
    }

    @Override
    public @Nullable KineticComponent provideComponent() {
        return new KineticComponent(stress, IOType.OUTPUT);
    }

    @Override
    public void tick() {
        if(getLevel() != null && getLevel().getGameTime() % 10 == 0) {
            MachineControllerEntity controller = getController();
            if(controller==null || controller.isRemoved() || controller.getStatus() != MachineStatus.RUNNING) {
                stress.setProducing(false);
            }
        }
        boolean isChangedGeneration = stressObserver.isChanged();
        if(isChangedGeneration) {
            ++currentProducingChangeTimeout;
        }
        if(currentProducingChangeTimeout > PRODUCING_CHANGE_TIMEOUT && isChangedGeneration) {
            stressObserver.refresh();
            currentProducingChangeTimeout = 0;
            updateGeneratedRotation();
        }
        super.tick();
    }

    @Override
    protected void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        super.write(compound, registries, clientPacket);
        compound.putInt(CASING_COLOR, casingColor);
        compound.putBoolean(REQUEST_UPDATE_KEY, requestModelUpdate);
        if(controllerPos != null) {
            compound.putLong(CONTROLLER_POS_KEY, controllerPos.asLong());
        }
        stress.write(compound);
        stressObserver.write(compound);

    }


    @Override
    protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        super.read(compound, registries, clientPacket);

        if (compound.contains(CASING_COLOR)) {
            casingColor = compound.getInt(CASING_COLOR);
        }

        if(compound.contains(CONTROLLER_POS_KEY)) {
            controllerPos = BlockPos.of(compound.getLong(CONTROLLER_POS_KEY));
        }

        requestModelUpdate = compound.contains(REQUEST_UPDATE_KEY) && compound.getBoolean(REQUEST_UPDATE_KEY);
        stress.read(compound);
        stressObserver.read(compound);

    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            if (getLevel() != null && getLevel().isClientSide())
                scheduleRenderUpdate();
            return true;
        }
        return false;
    }

    public void scheduleRenderUpdate() {
        if (getLevel() != null) {
            if (getLevel().isClientSide()) {
                getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 1 << 3);
            } else {
                getLevel().blockEvent(getBlockPos(), getBlockState().getBlock(), 1, 0);
            }
        }
    }

    @Override
    public void setRequestModelUpdate(boolean request) {
        requestModelUpdate = request;
    }

    @Override
    public boolean isRequestModelUpdate() {
        return requestModelUpdate;
    }

    public void markForUpdate() {
        if (requestModelUpdate) requestModelDataUpdate();
        setRequestModelUpdate(false);
        if (getLevel() != null) {
            getLevel().setBlockAndUpdate(getBlockPos(), getBlockState());
        }
        setChanged();
    }

    @Override
    public void handleUpdateTag(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider lookupProvider) {
        read(tag, lookupProvider, false);
    }

    @Override
    public BlockPos getControllerPos() {
        return controllerPos;
    }

    @Override
    public void setControllerPos(BlockPos pos) {
        this.controllerPos = pos;
    }
}
