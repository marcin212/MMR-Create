package com.bymarcin.mmrcreate.blockentity;

import com.bymarcin.mmrcreate.data.KineticComponent;
import com.bymarcin.mmrcreate.data.StressHolder;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import es.degrassi.mmreborn.common.data.Config;
import es.degrassi.mmreborn.common.entity.base.ColorableMachineEntity;
import es.degrassi.mmreborn.common.entity.base.MachineComponentEntity;
import es.degrassi.mmreborn.common.machine.IOType;
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

public class KineticInputHatchEntity extends KineticBlockEntity implements MachineComponentEntity<KineticComponent>, ColorableMachineEntity, IEntitySynchronizable {
    private final StressHolder stress = new StressHolder();
    private int casingColor = Config.machineColor;
    private boolean requestModelUpdate = false;
    private boolean inStructure = false;


    private static final String REQUEST_UPDATE_KEY = "requestModelUpdate";
    private static final String IN_STRUCTURE_KEY = "inStructure";
    private static final String CASING_COLOR = "casingColor";

    public KineticInputHatchEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);

    }

    @Override
    public void onSpeedChanged(float previousSpeed) {
        super.onSpeedChanged(previousSpeed);
        int sufficientSpeedLevel = 0;
        if( getBlockState().getBlock() instanceof IRotate rotate) {
            sufficientSpeedLevel = getSpeed() >= rotate.getMinimumRequiredSpeedLevel().getSpeedValue()? 1 : 0;
        }
        stress.setStress((long) (getSpeed() * lastStressApplied * sufficientSpeedLevel));
    }

    @Override
    public @Nullable KineticComponent provideComponent() {
        return new KineticComponent(stress, IOType.INPUT);
    }

    @Override
    protected void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        super.write(compound, registries, clientPacket);
        compound.putInt(CASING_COLOR, casingColor);
        compound.putBoolean(REQUEST_UPDATE_KEY, requestModelUpdate);
        compound.putBoolean(IN_STRUCTURE_KEY, inStructure);
        stress.write(compound);
    }


    @Override
    protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        super.read(compound, registries, clientPacket);

        if (compound.contains(CASING_COLOR)) {
            casingColor = compound.getInt(CASING_COLOR);
        }

        requestModelUpdate = compound.contains(REQUEST_UPDATE_KEY) && compound.getBoolean(REQUEST_UPDATE_KEY);
        inStructure = compound.contains(IN_STRUCTURE_KEY) && compound.getBoolean(IN_STRUCTURE_KEY);
        stress.read(compound);
    }

    @Override
    public int getMachineColor() {
        return casingColor;
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
        if(getLevel() != null) {
            getLevel().setBlockAndUpdate(getBlockPos(), getBlockState());
        }
        setChanged();
    }

    @Override
    public void handleUpdateTag(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider lookupProvider) {
        read(tag, lookupProvider, false);
    }

}
