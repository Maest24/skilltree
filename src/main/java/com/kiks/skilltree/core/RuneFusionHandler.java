package com.kiks.skilltree.core;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraftforge.registries.ForgeRegistries;
import com.kiks.skilltree.SkillTreeMod;

public class RuneFusionHandler {
    public static boolean fuse(Player player, String runeId, int level) {
        int count = 0;
        for (ItemStack s : player.inventory.items) {
            if (s.getItem() instanceof RuneItem ri && ri.getRune().getId().equals(runeId) && ri.getRune().getLevel() == level) {
                count++;
            }
        }
        if (count < 3) return false;
        int toRemove = 3;
        for (ItemStack s : player.inventory.items) {
            if (toRemove > 0 && s.getItem() instanceof RuneItem ri && ri.getRune().getId().equals(runeId) && ri.getRune().getLevel() == level) {
                s.shrink(1); toRemove--;
            }
        }
        String targetId = runeId + "_" + (level + 1);
        var newItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(SkillTreeMod.MODID, targetId));
        player.addItem(new ItemStack(newItem));
        player.level.playSound(null, player.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1, 1);
        player.level.addParticle(ParticleTypes.ENCHANT, player.getX(), player.getY() + 1, player.getZ(), 0, 0.5, 0);
        return true;
    }
}