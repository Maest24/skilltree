package com.kiks.skilltree.core;

import java.util.List;

public interface ISkillTreeData {
    List<NodeSlot> getSlots();
    void addSlot(NodeSlot slot);
}
