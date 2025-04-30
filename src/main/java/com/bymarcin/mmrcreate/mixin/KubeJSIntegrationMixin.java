package com.bymarcin.mmrcreate.mixin;

import com.bymarcin.mmrcreate.data.KineticRequirementJS;
import es.degrassi.mmreborn.common.integration.kubejs.MachineRecipeBuilderJS;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({ MachineRecipeBuilderJS.class })
public abstract class KubeJSIntegrationMixin implements KineticRequirementJS {
}
