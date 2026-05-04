package com.bymarcin.mmrcreate.registration;

import com.bymarcin.mmrcreate.MMRCreate;
import com.bymarcin.mmrcreate.data.StressHolder;
import es.degrassi.mmreborn.common.crafting.ComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static es.degrassi.mmreborn.ModularMachineryReborn.rootLC;

public class ComponentRegistration {
    public static final DeferredRegister<ComponentType<?>> MACHINE_COMPONENTS = DeferredRegister.create(ComponentType.REGISTRY_KEY, MMRCreate.MODID);

    public static final Supplier<ComponentType<StressHolder>> COMPONENT_KINETIC = MACHINE_COMPONENTS.register(rootLC("kinetic"), ComponentType::create);

    public static void register(final IEventBus bus) {
        MACHINE_COMPONENTS.register(bus);
    }
}
