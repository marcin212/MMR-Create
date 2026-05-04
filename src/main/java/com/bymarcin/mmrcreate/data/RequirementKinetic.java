package com.bymarcin.mmrcreate.data;

import com.bymarcin.mmrcreate.registration.ComponentRegistration;
import com.bymarcin.mmrcreate.registration.RequirementTypeRegistration;
import com.google.gson.JsonObject;
import es.degrassi.mmreborn.api.codec.NamedCodec;
import es.degrassi.mmreborn.api.crafting.CraftingResult;
import es.degrassi.mmreborn.api.crafting.ICraftingContext;
import es.degrassi.mmreborn.api.crafting.requirement.IRequirement;
import es.degrassi.mmreborn.api.crafting.requirement.IRequirementList;
import es.degrassi.mmreborn.common.crafting.ComponentType;
import es.degrassi.mmreborn.common.crafting.requirement.PositionedRequirement;
import es.degrassi.mmreborn.common.crafting.requirement.RequirementType;
import es.degrassi.mmreborn.common.machine.IOType;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;


public class RequirementKinetic implements IRequirement<KineticComponent, StressHolder> {
    public static final NamedCodec<RequirementKinetic> CODEC =
            NamedCodec.record(instance -> instance.group(
                            NamedCodec.longRange(0, Long.MAX_VALUE).fieldOf("rmp").forGetter(RequirementKinetic::getRmp),
                            NamedCodec.longRange(0, Long.MAX_VALUE).fieldOf("stress").forGetter(RequirementKinetic::getStress),
                            NamedCodec.enumCodec(IOType.class).fieldOf("mode").forGetter(IRequirement::getMode),
                            PositionedRequirement.POSITION_CODEC.optionalFieldOf("position", new PositionedRequirement(0, 0)).forGetter(IRequirement::getPosition)
                    ).apply(instance, RequirementKinetic::new),
                    "RequirementKinetic");

    private final IOType mode;
    private final PositionedRequirement position;
    private final long stress;
    private final long rpm;
    private final StressHolder requiredStress;

    public RequirementKinetic(long rmp,long stress, IOType mode, PositionedRequirement position) {
        this.rpm = rmp;
        this.stress = stress;
        this.mode = mode;
        this.position = position;
        requiredStress = new StressHolder(false, rpm, stress);
    }

    public long getRmp() {
        return rpm;
    }

    public long getStress() {
        return stress;
    }

    public StressHolder getRequiredStress() {
        return requiredStress;
    }

    @Override
    public RequirementType<? extends IRequirement<KineticComponent, StressHolder>, KineticComponent, StressHolder> getType() {
        return RequirementTypeRegistration.KINETIC.get();
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentRegistration.COMPONENT_KINETIC.get();
    }

    @Override
    public IOType getMode() {
        return mode;
    }

    @Override
    public boolean test(KineticComponent component, ICraftingContext context) {
        return !getMode().isInput() || component.getContainerProvider() != null && component.getContainerProvider().getStress() >= stress;
    }

    @Override
    public void gatherRequirements(IRequirementList<KineticComponent> list) {
        if(getMode().isInput()) {
            list.processEachTick((k, context) -> test(k, context) ? CraftingResult.success() : CraftingResult.error(Component.translatable("modular_machinery_reborn_create.requirment.insufficient_stress")));
        } else {
            list.processOnStart((k, context)-> {
                if(k.getContainerProvider() != null) k.getContainerProvider().setRpm(rpm).setStress(stress).setProducing(true);
                return CraftingResult.success();
            });
            list.processOnEnd((k, context)-> {
                if(k.getContainerProvider() != null) k.getContainerProvider().setProducing(false);
                return CraftingResult.success();
            });
        }
    }

    @Override
    public PositionedRequirement getPosition() {
        return position;
    }

    @Override
    public @NotNull Component getMissingComponentErrorMessage(IOType ioType) {
        return Component.translatable(String.format("modular_machinery_reborn_create.component.missing.kinetic.%s", ioType.name().toLowerCase()));
    }

    @Override
    public boolean isComponentValid(KineticComponent m, ICraftingContext context) {
        return getMode() == m.getIOType();
    }

    @Override
    public JsonObject asJson() {
        var a = IRequirement.super.asJson();
        a.addProperty("stress", getStress());
        a.addProperty("rpm", getRmp());
        return a;
    }
}
