package com.bymarcin.mmrcreate.data;

import es.degrassi.mmreborn.api.crafting.requirement.RecipeRequirement;
import es.degrassi.mmreborn.common.crafting.requirement.PositionedRequirement;
import es.degrassi.mmreborn.common.integration.kubejs.MachineRecipeBuilderJS;
import es.degrassi.mmreborn.common.integration.kubejs.RecipeJSBuilder;
import es.degrassi.mmreborn.common.machine.IOType;

public interface KineticRequirementJS extends RecipeJSBuilder {
    default MachineRecipeBuilderJS requireKinetic(long stress) {
        return addRequirement(new RecipeRequirement<>(new RequirementKinetic(stress, IOType.INPUT, new PositionedRequirement(0, 0))));
    }

    default MachineRecipeBuilderJS requireKinetic(long stress, int x, int y) {
        return addRequirement(new RecipeRequirement<>(new RequirementKinetic(stress, IOType.INPUT, new PositionedRequirement(x, y))));
    }
}
