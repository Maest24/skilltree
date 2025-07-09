package com.kiks.skilltree;

import com.kiks.skilltree.core.ISkillTreeData;
import com.kiks.skilltree.core.SkillTreeData;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SkillTreeMod.MODID)
public class SkillTreeProvider implements ICapabilitySerializable<CompoundTag> {
    private final ISkillTreeData instance = new SkillTreeData();

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return CapabilityHandler.SKILL_TREE_CAP.orEmpty(cap, LazyOptional.of(() -> instance));
    }

    @Override
    public CompoundTag serializeNBT() {
        return instance.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        instance.deserializeNBT(nbt);
    }
}
