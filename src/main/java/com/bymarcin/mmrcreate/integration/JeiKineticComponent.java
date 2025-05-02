package com.bymarcin.mmrcreate.integration;

import com.bymarcin.mmrcreate.data.KineticComponent;
import com.bymarcin.mmrcreate.data.RequirementKinetic;
import com.bymarcin.mmrcreate.data.StressHolder;
import com.google.common.collect.Lists;
import com.simibubi.create.AllBlocks;
import es.degrassi.mmreborn.api.crafting.requirement.RecipeRequirement;
import es.degrassi.mmreborn.common.crafting.MachineRecipe;
import es.degrassi.mmreborn.common.crafting.requirement.jei.JeiComponent;
import es.degrassi.mmreborn.common.integration.jei.category.MMRRecipeCategory;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JeiKineticComponent extends JeiComponent<StressHolder, RecipeRequirement<KineticComponent, RequirementKinetic>> {

    public JeiKineticComponent(RecipeRequirement<KineticComponent, RequirementKinetic> requirement) {
        super(requirement, 0, 0);
    }

    @Override
    public int getWidth() {
        return 16;
    }

    @Override
    public int getHeight() {
        return 16;
    }

    @Override
    public @NotNull List<StressHolder> ingredients() {
        return Lists.newArrayList(requirement.requirement().getRequiredStress().copy());
    }

    @Override
    public void setRecipe(@NotNull MMRRecipeCategory category, IRecipeLayoutBuilder builder, @NotNull MachineRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, getPosition().x(), getPosition().y())
                .addItemStack(AllBlocks.COGWHEEL.asStack())
                .addRichTooltipCallback((view, tooltip) -> {
                    tooltip.clear();
                    if (requirement.requirement().getMode().isInput()) {
                        tooltip.add(Component.translatable("modular_machinery_reborn_create.jei.required_stress_capacity", requirement.requirement().getStress()));
                    } else {
                        tooltip.add(Component.translatable("modular_machinery_reborn_create.jei.produce_stress_capacity", requirement.requirement().getStress()));
                    }
                });
    }
}
