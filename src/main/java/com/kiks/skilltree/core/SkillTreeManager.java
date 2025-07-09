package com.kiks.skilltree.core;

import com.google.gson.Gson;
import com.kiks.skilltree.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SkillTreeManager {
    private static final Map<String, Rune> runes = new HashMap<>();
    private static final List<Rune> sortedRunes = new ArrayList<>();

    public static void init() {
        loadRunes();
    }

    public static void loadRunes() {
        try {
            IResourceManager rm = Minecraft.getInstance().getResourceManager();
            Collection<ResourceLocation> list = rm.listResources(
                "skilltree/runes", path -> path.endsWith(".json")
            );
            Gson gson = new Gson();
            for (ResourceLocation rl : list) {
                Rune r = gson.fromJson(
                    new InputStreamReader(rm.getResource(rl).getInputStream()),
                    Rune.class
                );
                runes.put(r.getId(), r);
            }
            sortedRunes.clear();
            sortedRunes.addAll(runes.values());
            sortedRunes.sort(Comparator
                .comparing(Rune::getRarity)
                .thenComparing(Rune::getLevel)
                .thenComparing(Rune::getId)
            );
            ItemRegistry.registerRuneItems(runes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean tryFuse(Player player, String runeId, int level) {
        return RuneFusionHandler.fuse(player, runeId, level);
    }

    public static NodeSlot getSlotForLevel(int level) {
        switch (level) {
            case 5: return new NodeSlot(Rarity.COMMUN);
            case 10: return new NodeSlot(Rarity.RARE);
            case 20: return new NodeSlot(Rarity.EPIQUE);
            case 40: return new NodeSlot(Rarity.LEGENDAIRE);
            default: return null;
        }
    }
}