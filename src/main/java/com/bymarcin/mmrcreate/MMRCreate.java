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
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(MMRCreate.MODID)
public class MMRCreate {
    public static final String MODID = "mmrcreate";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MMRCreate.MODID);

    public MMRCreate(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        REGISTRATE.registerEventListeners(modEventBus);
        Registration.register(modEventBus);
        //NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        BlockStressValues.IMPACTS.register(BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get(), () -> Config.tinySlowSpeedInputStressImpact);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
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
            event.register(ModularMachineryRebornClient::blockColor, BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get());
        }

        @SubscribeEvent
        public static void registerItemColors(final RegisterColorHandlersEvent.Item event) {
            event.register(ModularMachineryRebornClient::itemColor, BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get().asItem());
        }
    }
}
