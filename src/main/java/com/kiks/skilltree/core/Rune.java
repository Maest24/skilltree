package com.kiks.skilltree.core;

import java.util.List;

public class Rune {
    private String id;
    private String name;
    private Rarity rarity;
    private int level;
    private int minPlayerLevel;
    private List<Effect> effects;
    private Requirements requirements;

    public String getId() { return id; }
    public Rarity getRarity() { return rarity; }
    public int getLevel() { return level; }
    public List<Effect> getEffects() { return effects; }

    public static class Effect {
        private String stat;
        private double modifier;
        public String getStat() { return stat; }
        public double getModifier() { return modifier; }
    }

    public static class Requirements {
        private List<String> parentRunes;
        public List<String> getParentRunes() { return parentRunes; }
    }
}