package com.bymarcin.mmrcreate.registration;

import net.neoforged.bus.api.IEventBus;

public class Registration {
    public static void register(final IEventBus bus) {
        RequirementTypeRegistration.register(bus);
        BlockRegistration.register(bus);
        EntityRegistration.register(bus);
        ComponentRegistration.register(bus);
    }
}
