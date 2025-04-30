package com.bymarcin.mmrcreate.integration;

import com.bymarcin.mmrcreate.data.KineticComponent;
import com.bymarcin.mmrcreate.data.RequirementKinetic;
import com.bymarcin.mmrcreate.data.StressHolder;
import com.google.common.collect.Lists;
import com.simibubi.create.AllBlocks;
import dev.emi.emi.api.stack.EmiStack;
import es.degrassi.mmreborn.api.crafting.requirement.RecipeRequirement;
import es.degrassi.mmreborn.client.requirement.ItemRendering;
import es.degrassi.mmreborn.common.crafting.requirement.emi.EmiComponent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EmiKineticComponent extends EmiComponent<StressHolder, RecipeRequirement<KineticComponent, RequirementKinetic>> implements ItemRendering {
    private int width = 16, height = 16;

    public EmiKineticComponent(RecipeRequirement<KineticComponent, RequirementKinetic> requirement) {
        super(requirement, 0, 0);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public @NotNull List<StressHolder> ingredients() {
        return Lists.newArrayList(requirement.requirement().getRequiredStress().copy());
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY) {
        super.render(graphics, mouseX, mouseY);
        drawStack(graphics, 0, 0, -1);
    }

    @Override
    public @Nullable ResourceLocation texture() {
        return null;
    }

    @Override
    public @NotNull List<Component> getTooltip() {
        return List.of(Component.translatable("modular_machinery_reborn_create.jei.required_stress_capacity", requirement.requirement().getStress()));
    }

    @Override
    public @NotNull EmiStack getStack() {
        return EmiStack.of(AllBlocks.COGWHEEL.get().asItem());
    }
}
