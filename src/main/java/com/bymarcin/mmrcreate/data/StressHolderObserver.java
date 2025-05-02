package com.bymarcin.mmrcreate.data;

import net.minecraft.nbt.CompoundTag;

public class StressHolderObserver {
    private final StressHolder stress;
    private StressHolder oldStress;

    public StressHolderObserver(StressHolder stress) {
        this.stress = stress;
        this.oldStress = stress.copy();
    }

    public boolean isChanged() {
        return !stress.equals(oldStress);
    }

    public void refresh() {
        oldStress = stress.copy();
    }

    public void write(CompoundTag tag) {
        CompoundTag oldStressTag = new CompoundTag();
        oldStress.write(oldStressTag);
        tag.put("oldStress", oldStressTag);
    }

    public void read(CompoundTag tag) {
        if (tag.contains("oldStress")) {
            oldStress.read(tag.getCompound("oldStress"));
        }
    }
}
