package com.bymarcin.mmrcreate.block;

import com.bymarcin.mmrcreate.blockentity.KineticOutputHatchEntity;
import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import es.degrassi.mmreborn.common.block.BlockDynamicColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlockKineticOutputHatch<T extends KineticOutputHatchEntity> extends DirectionalKineticBlock implements IBE<T>, BlockDynamicColor {
    private final Class<T> tClass;
    private final BlockEntityEntry<? extends T> blockEntityType;

    public BlockKineticOutputHatch(Properties properties, Class<T> tClass, BlockEntityEntry<? extends T> entityType) {
        super(properties);
        this.tClass = tClass;
        this.blockEntityType = entityType;
    }

    @Override
    public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, worldIn, pos, oldState, isMoving);
        if (worldIn.isClientSide())
            return;
        if (!worldIn.getBlockTicks()
                .hasScheduledTick(pos, this))
            worldIn.scheduleTick(pos, this, 1);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        withBlockEntityDo(level, pos, (e)->{
            e.updateGeneratedRotation();
        });
    }

    @Override
    public Class<T> getBlockEntityClass() {
        return tClass;
    }

    @Override
    public BlockEntityType<? extends T> getBlockEntityType() {
        return blockEntityType.get();
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(FACING).getAxis();
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING).getOpposite();
    }
}
