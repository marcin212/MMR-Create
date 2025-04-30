package com.bymarcin.mmrcreate.registration;

import com.bymarcin.mmrcreate.MMRCreate;
import com.bymarcin.mmrcreate.blockentity.KineticInputHatchEntity;
import com.bymarcin.mmrcreate.render.KineticHatchVisual;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.neoforged.bus.api.IEventBus;

public class EntityRegistration {

    public static final BlockEntityEntry<KineticInputHatchEntity> KINETIC_INPUT_HATCH = MMRCreate.REGISTRATE
            .blockEntity("kinetic_hatch_input", KineticInputHatchEntity::new)
            .visual(() -> KineticHatchVisual::new, false)
            .validBlocks(
                    // TINY
                    BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW,
                    BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM,
                    BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST,

                    // SMALL
                    BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW,
                    BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM,
                    BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST,

                    // NORMAL
                    BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW,
                    BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM,
                    BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST,

                    // REINFORCED
                    BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW,
                    BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM,
                    BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST,

                    // BIG
                    BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW,
                    BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM,
                    BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST,

                    // HUGE
                    BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW,
                    BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM,
                    BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST,

                    // LUDICROUS
                    BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW,
                    BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM,
                    BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST,

                    // VACUUM
                    BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW,
                    BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM,
                    BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST
            )
            .register();

    public static void register(final IEventBus bus) {
    }
}
