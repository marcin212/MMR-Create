package com.bymarcin.mmrcreate.registration;

import com.bymarcin.mmrcreate.MMRCreate;
import com.bymarcin.mmrcreate.block.BlockKineticInputHatch;
import com.bymarcin.mmrcreate.block.BlockKineticOutputHatch;
import com.bymarcin.mmrcreate.blockentity.KineticInputHatchEntity;
import com.bymarcin.mmrcreate.blockentity.KineticOutputHatchEntity;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.neoforged.bus.api.IEventBus;

public class BlockRegistration {
    //TINY
    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_TINY_SLOW = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_tiny_slow", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.SLOW, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_TINY_MEDIUM = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_tiny_medium", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.MEDIUM, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_TINY_FAST = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_tiny_fast", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.FAST, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    // SMALL
    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_SMALL_SLOW = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_small_slow", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.SLOW, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_SMALL_MEDIUM = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_small_medium", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.MEDIUM, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_SMALL_FAST = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_small_fast", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.FAST, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    // NORMAL
    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_NORMAL_SLOW = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_normal_slow", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.SLOW, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_NORMAL_MEDIUM = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_normal_medium", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.MEDIUM, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_NORMAL_FAST = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_normal_fast", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.FAST, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    // REINFORCED
    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_REINFORCED_SLOW = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_reinforced_slow", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.SLOW, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_REINFORCED_MEDIUM = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_reinforced_medium", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.MEDIUM, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_REINFORCED_FAST = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_reinforced_fast", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.FAST, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    // BIG
    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_BIG_SLOW = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_big_slow", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.SLOW, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_BIG_MEDIUM = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_big_medium", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.MEDIUM, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_BIG_FAST = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_big_fast", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.FAST, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    // HUGE
    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_HUGE_SLOW = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_huge_slow", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.SLOW, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_HUGE_MEDIUM = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_huge_medium", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.MEDIUM, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_HUGE_FAST = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_huge_fast", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.FAST, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    // LUDICROUS
    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_LUDICROUS_SLOW = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_ludicrous_slow", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.SLOW, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_ludicrous_medium", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.MEDIUM, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_LUDICROUS_FAST = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_ludicrous_fast", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.FAST, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    // VACUUM
    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_VACUUM_SLOW = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_vacuum_slow", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.SLOW, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_VACUUM_MEDIUM = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_vacuum_medium", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.MEDIUM, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticInputHatch<KineticInputHatchEntity>> KINETIC_INPUT_HATCH_VACUUM_FAST = MMRCreate.REGISTRATE
            .block("kinetic_input_hatch_vacuum_fast", p -> new BlockKineticInputHatch<>(p, IRotate.SpeedLevel.FAST, KineticInputHatchEntity.class, EntityRegistration.KINETIC_INPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();

    public static final BlockEntry<BlockKineticOutputHatch<KineticOutputHatchEntity>> KINETIC_OUTPUT_HATCH = MMRCreate.REGISTRATE
            .block("kinetic_output_hatch", p -> new BlockKineticOutputHatch<>(p, KineticOutputHatchEntity.class, EntityRegistration.KINETIC_OUTPUT_HATCH))
            .initialProperties(SharedProperties::stone)
            .simpleItem()
            .register();


    public static void register(final IEventBus bus) {

    }
}
