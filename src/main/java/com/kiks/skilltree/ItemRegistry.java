package com.kiks.skilltree;

import com.kiks.skilltree.core.Rune;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, SkillTreeMod.MODID);

    public static void registerRuneItems(Map<String, Rune> runes) {
        runes.forEach((id, rune) ->
            ITEMS.register(id, () -> new RuneItem(new Item.Properties().stacksTo(64), rune))
        );
    }
}
