package com.bymarcin.mmrcreate.data;

import com.bymarcin.mmrcreate.registration.ComponentRegistration;
import com.google.gson.JsonObject;
import es.degrassi.mmreborn.common.crafting.ComponentType;
import es.degrassi.mmreborn.common.machine.IOType;
import es.degrassi.mmreborn.common.machine.MachineComponent;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KineticComponent extends MachineComponent<StressHolder> {
    private final StressHolder stress;

    public KineticComponent(StressHolder stress, IOType ioType) {
        super(ioType);
        this.stress = stress;
    }

    @Override
    public @NotNull ComponentType getComponentType() {
        return ComponentRegistration.COMPONENT_KINETIC.get();
    }

    @Override
    public @Nullable StressHolder getContainerProvider() {
        return stress;
    }

    @Override
    public @NotNull JsonObject asJson() {
        JsonObject sup = super.asJson();
        sup.addProperty("stress", stress.getStress());
        return sup;
    }

    @Override
    public @NotNull CompoundTag asTag(HolderLookup.@NotNull Provider provider) {
        CompoundTag sup = super.asTag(provider);
        sup.putLong("stress", stress.getStress());
        return sup;
    }

    @Override
    public <C extends MachineComponent<?>> boolean canMerge(@NotNull C c) {
        KineticComponent comp = (KineticComponent) c;
        if (c == this) return false;
        return comp.getIOType() == getIOType() &&
                (getIOType().isInput() || comp.stress.equals(stress));
    }

    @Override
    public <C extends MachineComponent<?>> @NotNull C merge(@NotNull C c) {
        KineticComponent comp = (KineticComponent) c;
        //noinspection unchecked
        return (C) new KineticComponent(new StressHolder(stress.isProducing(), stress.getRpm(), stress.getStress()) {
            @Override
            public long getStress() {
                return getIOType().isInput()?
                    comp.stress.getStress() + stress.getStress():
                    stress.getStress();
            }

            @Override
            public StressHolder setStress(long s) {
                comp.stress.setStress(s);
                stress.setStress(s);
                return super.setStress(s);
            }


            @Override
            public StressHolder setRpm(long rpm) {
                comp.stress.setRpm(rpm);
                stress.setRpm(rpm);
                return super.setRpm(rpm);
            }

            @Override
            public StressHolder setProducing(boolean producing) {
                comp.stress.setProducing(producing);
                stress.setProducing(producing);
                return super.setProducing(producing);
            }
        }, getIOType());
    }

    @Override
    public int compareTo(@NotNull MachineComponent<StressHolder> o) {
        StressHolder one = getContainerProvider();
        StressHolder two = o.getContainerProvider();
        if (one == two) return 0;
        if (one == null) return -1;
        if (two == null) return 1;
        return Long.compare(one.getStress(), two.getStress());
    }
}
