package com.kiks.skilltree;

import com.kiks.skilltree.core.LevelUpHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = SkillTreeMod.MODID)
public class ModEventBusSubscriber {
    public static void register() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(LevelUpHandler::onCommonSetup);
        MinecraftForge.EVENT_BUS.register(new LevelUpHandler());
    }
}