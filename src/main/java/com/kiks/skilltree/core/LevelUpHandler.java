package com.kiks.skilltree.core;

import com.kiks.skilltree.CapabilityHandler;
import com.kiks.skilltree.SkillTreeMod;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class LevelUpHandler {

    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // Initialize skill tree data
    }

    @SubscribeEvent
    public void onPlayerLevelUp(PlayerEvent.PlayerLevelChangeEvent ev) {
        int lvl = ev.getNewLevel();
        Player player = ev.getPlayer();
        player.sendMessage(Component.literal("Nouveau slot débloqué au niveau " + lvl), player.getUUID());
        player.playSound(SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);
    }
}
