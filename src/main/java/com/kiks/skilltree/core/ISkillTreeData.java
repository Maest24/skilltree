package com.kiks.skilltree.core;

import net.minecraft.nbt.CompoundTag;

public interface ISkillTreeData {
    CompoundTag serializeNBT();
    void deserializeNBT(CompoundTag nbt);
}