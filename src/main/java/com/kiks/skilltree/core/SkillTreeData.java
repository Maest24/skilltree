package com.kiks.skilltree.core;

import net.minecraft.nbt.CompoundTag;

public class SkillTreeData implements ISkillTreeData {

    // Exemple de données — à adapter selon ton arbre réel
    private int unlockedSlots = 0;

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("UnlockedSlots", unlockedSlots);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.unlockedSlots = nbt.getInt("UnlockedSlots");
    }

    public int getUnlockedSlots() {
        return unlockedSlots;
    }

    public void setUnlockedSlots(int slots) {
        this.unlockedSlots = slots;
    }

    public void incrementUnlockedSlots() {
        this.unlockedSlots++;
    }
}