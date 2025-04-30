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
            .validBlocks(BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW)
            .register();

    public static void register(final IEventBus bus) {
    }
}
