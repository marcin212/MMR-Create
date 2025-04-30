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
import es.degrassi.mmreborn.common.crafting.modifier.RecipeModifier;
import es.degrassi.mmreborn.common.crafting.requirement.PositionedRequirement;
import es.degrassi.mmreborn.common.crafting.requirement.RequirementType;
import es.degrassi.mmreborn.common.machine.IOType;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RequirementKinetic implements IRequirement<KineticComponent> {
    public static final NamedCodec<RequirementKinetic> CODEC =
            NamedCodec.record(instance -> instance.group(
                            NamedCodec.longRange(0, Long.MAX_VALUE).fieldOf("stress").forGetter(RequirementKinetic::getStress),
                            NamedCodec.enumCodec(IOType.class).fieldOf("mode").forGetter(IRequirement::getMode),
                            PositionedRequirement.POSITION_CODEC.optionalFieldOf("position", new PositionedRequirement(0, 0)).forGetter(IRequirement::getPosition)
                    ).apply(instance, RequirementKinetic::new),
                    "RequirementKinetic");

    private final IOType mode;
    private final PositionedRequirement position;
    private final long stress;
    private final StressHolder requiredStress;

    public RequirementKinetic(long stress, IOType mode, PositionedRequirement position) {
        this.mode = mode;
        this.stress = stress;
        this.position = position;
        requiredStress = new StressHolder(stress);
    }

    public long getStress() {
        return stress;
    }

    public StressHolder getRequiredStress() {
        return requiredStress;
    }

    @Override
    public RequirementType<? extends IRequirement<KineticComponent>> getType() {
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
        return component.getContainerProvider() != null && component.getContainerProvider().getStress() >= stress;
    }

    @Override
    public void gatherRequirements(IRequirementList<KineticComponent> list) {
        list.processOnStart((k, context)-> test(k, context) ? CraftingResult.success() : CraftingResult.error(Component.translatable("modular_machinery_reborn_create.requirment.insufficient_stress")));
        list.processEachTick((k, context)-> test(k, context) ? CraftingResult.success() : CraftingResult.error(Component.translatable("modular_machinery_reborn_create.requirment.insufficient_stress")));
    }

    @Override
    public PositionedRequirement getPosition() {
        return null;
    }

    @Override
    public IRequirement<KineticComponent> deepCopyModified(List<RecipeModifier> modifiers) {
        return new RequirementKinetic(stress, mode, position);
    }

    @Override
    public IRequirement<KineticComponent> deepCopy() {
        return new RequirementKinetic(stress, mode, position);
    }

    @Override
    public @NotNull Component getMissingComponentErrorMessage(IOType ioType) {
        return Component.translatable(String.format("modular_machinery_reborn_create.component.missing.kinetic.%s", ioType.name().toLowerCase()));
    }

    @Override
    public boolean isComponentValid(KineticComponent m, ICraftingContext context) {
        return getMode().isInput();
    }

    @Override
    public JsonObject asJson() {
        var a=  IRequirement.super.asJson();
        a.addProperty("stress", getStress());
        return a;
    }
}
