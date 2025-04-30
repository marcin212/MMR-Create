package com.bymarcin.mmrcreate.registration;

import com.bymarcin.mmrcreate.MMRCreate;
import com.bymarcin.mmrcreate.block.BlockKineticInputHatch;
import com.bymarcin.mmrcreate.blockentity.KineticInputHatchEntity;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;

public class BlockRegistration {
    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_TINY_SLOW = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_tiny_slow", p-> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.SLOW, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_YELLOW))
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
            .simpleItem()
            .register();

    public static void register(final IEventBus bus) {

    }
}
