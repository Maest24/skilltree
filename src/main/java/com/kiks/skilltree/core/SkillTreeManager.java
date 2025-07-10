package com.kiks.skilltree.core;

import com.google.gson.Gson;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.resources.ResourceLocation;
import com.kiks.skilltree.ItemRegistry;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SkillTreeManager {
    private static final Map<String, Rune> runes = new HashMap<>();

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
            ItemRegistry.registerRuneItems(runes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static NodeSlot getSlotForLevel(int level) {
        if (level == 5)   return new NodeSlot(Rarity.COMMUN);
        if (level == 10)  return new NodeSlot(Rarity.RARE);
        if (level == 20)  return new NodeSlot(Rarity.EPIQUE);
        if (level == 40)  return new NodeSlot(Rarity.LEGENDAIRE);
        return null;
    }
}
