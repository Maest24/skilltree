package com.kiks.skilltree.core;

public class NodeSlot {
    private Rarity rarity;
    private Rune equipped;

    public NodeSlot(Rarity rarity) { this.rarity = rarity; }
    public boolean equip(Rune rune) {
        if (rune.getRarity() == rarity) {
            this.equipped = rune;
            return true;
        }
        return false;
    }
    public Rune getEquipped() { return equipped; }
}