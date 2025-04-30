package com.bymarcin.mmrcreate.block;

import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.foundation.block.IBE;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import es.degrassi.mmreborn.common.block.BlockDynamicColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlockKineticInputHatch<T extends BlockEntity> extends DirectionalKineticBlock implements IBE<T>, BlockDynamicColor, IRotate {
    private final SpeedLevel speedLevel;
    private final Class<T> tClass;
    private final BlockEntityEntry<? extends T> blockEntityType;

    public BlockKineticInputHatch(Properties properties, SpeedLevel speedLevel, Class<T> tClass, BlockEntityEntry<? extends T> entityType) {
        super(properties);
        this.speedLevel = speedLevel;
        this.tClass = tClass;
        this.blockEntityType = entityType;
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(FACING).getAxis();
    }

    @Override
    public SpeedLevel getMinimumRequiredSpeedLevel() {
        return speedLevel;
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING).getOpposite();
    }

    @Override
    public Class<T> getBlockEntityClass() {
        return tClass;
    }

    @Override
    public BlockEntityType<? extends T> getBlockEntityType() {
        return blockEntityType.get();
    }
}
