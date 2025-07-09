package com.kiks.skilltree;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SkillTreeMod.MODID)
public class SkillTreeMod {
    public static final String MODID = "skilltree";

    public SkillTreeMod() {
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CapabilityHandler.register();
        ModEventBusSubscriber.register();
    }
}
