package com.bymarcin.mmrcreate;

import com.bymarcin.mmrcreate.integration.EmiKineticComponent;
import com.bymarcin.mmrcreate.integration.JeiKineticComponent;
import com.bymarcin.mmrcreate.registration.BlockRegistration;
import com.bymarcin.mmrcreate.registration.Registration;
import com.bymarcin.mmrcreate.registration.RequirementTypeRegistration;
import com.simibubi.create.api.stress.BlockStressValues;
import com.simibubi.create.foundation.data.CreateRegistrate;
import es.degrassi.mmreborn.api.integration.emi.RegisterEmiComponentEvent;
import es.degrassi.mmreborn.api.integration.jei.RegisterJeiComponentEvent;
import es.degrassi.mmreborn.client.ModularMachineryRebornClient;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Mod(MMRCreate.MODID)
public class MMRCreate {
    public static final String MODID = "mmrcreate";
    //private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MMRCreate.MODID).defaultCreativeTab("all_items").build();

    public MMRCreate(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        REGISTRATE.registerEventListeners(modEventBus);
        Registration.register(modEventBus);
        //NeoForge.EVENT_BUS.register(this);


        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // TINY
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get(), () -> Config.tinySlowSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get(), () -> Config.tinyMediumSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get(), () -> Config.tinyFastSpeedInputStressImpact);

        // SMALL
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get(), () -> Config.smallSlowSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get(), () -> Config.smallMediumSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get(), () -> Config.smallFastSpeedInputStressImpact);

        // NORMAL
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get(), () -> Config.normalSlowSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get(), () -> Config.normalMediumSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get(), () -> Config.normalFastSpeedInputStressImpact);

        // REINFORCED
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get(), () -> Config.reinforcedSlowSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get(), () -> Config.reinforcedMediumSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get(), () -> Config.reinforcedFastSpeedInputStressImpact);

        // BIG
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get(), () -> Config.bigSlowSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get(), () -> Config.bigMediumSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get(), () -> Config.bigFastSpeedInputStressImpact);

        // HUGE
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get(), () -> Config.hugeSlowSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get(), () -> Config.hugeMediumSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get(), () -> Config.hugeFastSpeedInputStressImpact);

        // LUDICROUS
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get(), () -> Config.ludicrousSlowSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get(), () -> Config.ludicrousMediumSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get(), () -> Config.ludicrousFastSpeedInputStressImpact);

        // VACUUM
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get(), () -> Config.vacuumSlowSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get(), () -> Config.vacuumMediumSpeedInputStressImpact);
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get(), () -> Config.vacuumFastSpeedInputStressImpact);

    }


    @Contract("_ -> new")
    public static @NotNull ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerJeiComponents(final RegisterJeiComponentEvent event) {
            event.register(RequirementTypeRegistration.KINETIC.get(), JeiKineticComponent::new);
        }

        @SubscribeEvent
        public static void registerEmiComponents(final RegisterEmiComponentEvent event) {
            event.register(RequirementTypeRegistration.KINETIC.get(), EmiKineticComponent::new);
        }

        @SubscribeEvent
        public static void registerBlockColors(final RegisterColorHandlersEvent.Block event) {
            event.register(ModularMachineryRebornClient::blockColor,
                    // TINY
                    BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get(),

                    // SMALL
                    BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get(),

                    // NORMAL
                    BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get(),

                    // REINFORCED
                    BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get(),

                    // BIG
                    BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get(),

                    // HUGE
                    BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get(),

                    // LUDICROUS
                    BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get(),

                    // VACUUM
                    BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get(),
                    BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get(),

                    //OUTPUT
                    BlockRegistration.KINETIC_OUTPUT_HATCH.get()
            );
        }

        @SubscribeEvent
        public static void registerItemColors(final RegisterColorHandlersEvent.Item event) {
            event.register(ModularMachineryRebornClient::itemColor,
                    // TINY
                    BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get().asItem(),

                    // SMALL
                    BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get().asItem(),

                    // NORMAL
                    BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get().asItem(),

                    // REINFORCED
                    BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get().asItem(),

                    // BIG
                    BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get().asItem(),

                    // HUGE
                    BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get().asItem(),

                    // LUDICROUS
                    BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get().asItem(),

                    // VACUUM
                    BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get().asItem(),
                    BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get().asItem(),

                    //OUTPUT
                    BlockRegistration.KINETIC_OUTPUT_HATCH.get().asItem()
            );
        }
    }
}
