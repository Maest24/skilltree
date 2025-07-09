package com.kiks.skilltree;

import com.kiks.skilltree.core.SkillTreeProvider;
import com.kiks.skilltree.core.ISkillTreeData;
import com.kiks.skilltree.core.SkillTreeMod;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.CapabilityToken;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.capabilities.AttachCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capability;

@Mod.EventBusSubscriber(modid = SkillTreeMod.MODID)
public class CapabilityHandler {

    public static Capability<ISkillTreeData> SKILL_TREE_CAP;

    @SubscribeEvent
    public static void registerCaps(RegisterCapabilitiesEvent event) {
        SKILL_TREE_CAP = event.register(
            ISkillTreeData.class,
            new CapabilityToken<>() {}
        );
    }

    @SubscribeEvent
    public static void attachCaps(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Entity) {
            event.addCapability(
                new ResourceLocation(SkillTreeMod.MODID, "skilltree_data"),
                new SkillTreeProvider()
            );
        }
    }
}
