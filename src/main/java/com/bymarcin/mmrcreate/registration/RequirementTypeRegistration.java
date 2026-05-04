package com.bymarcin.mmrcreate.registration;

import com.bymarcin.mmrcreate.data.KineticComponent;
import com.bymarcin.mmrcreate.data.RequirementKinetic;
import com.bymarcin.mmrcreate.data.StressHolder;
import es.degrassi.mmreborn.ModularMachineryReborn;
import es.degrassi.mmreborn.api.crafting.requirement.IRequirement;
import es.degrassi.mmreborn.common.crafting.requirement.RequirementType;
import es.degrassi.mmreborn.common.machine.MachineComponent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static es.degrassi.mmreborn.ModularMachineryReborn.rootLC;

public class RequirementTypeRegistration {
    public static final DeferredRegister<RequirementType<? extends IRequirement<? extends MachineComponent<?>, ?>, ? extends MachineComponent<?>, ?>> MACHINE_REQUIREMENTS =
            DeferredRegister.create(RequirementType.REGISTRY_KEY, ModularMachineryReborn.MODID);

    public static final Supplier<RequirementType<RequirementKinetic, KineticComponent, StressHolder>> KINETIC =
            MACHINE_REQUIREMENTS.register(rootLC("kinetic"),
                    () -> RequirementType.inventory(RequirementKinetic.CODEC));

    public static void register(IEventBus bus) {
        MACHINE_REQUIREMENTS.register(bus);
    }
}
