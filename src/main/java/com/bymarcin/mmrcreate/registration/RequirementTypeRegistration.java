package com.bymarcin.mmrcreate.registration;

import com.bymarcin.mmrcreate.data.RequirementKinetic;
import es.degrassi.mmreborn.ModularMachineryReborn;
import es.degrassi.mmreborn.api.crafting.requirement.IRequirement;
import es.degrassi.mmreborn.common.crafting.requirement.RequirementType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static es.degrassi.mmreborn.ModularMachineryReborn.rootLC;

public class RequirementTypeRegistration {
    public static final DeferredRegister<RequirementType<? extends IRequirement<?>>> MACHINE_REQUIREMENTS =
            DeferredRegister.create(RequirementType.REGISTRY_KEY, ModularMachineryReborn.MODID);

    public static final Supplier<RequirementType<RequirementKinetic>> KINETIC =
            MACHINE_REQUIREMENTS.register(rootLC("kinetic"),
                    () -> RequirementType.inventory(RequirementKinetic.CODEC));

    public static void register(IEventBus bus) {
        MACHINE_REQUIREMENTS.register(bus);
    }
}
