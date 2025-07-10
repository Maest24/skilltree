package com.kiks.skilltree;

import com.kiks.skilltree.core.Rune;
import net.minecraft.world.item.Item;

public class RuneItem extends Item {
    private final Rune rune;

    public RuneItem(Properties properties, Rune rune) {
        super(properties);
        this.rune = rune;
    }

    public Rune getRune() {
        return rune;
    }
}
