package com.bymarcin.mmrcreate.data;

import net.minecraft.nbt.CompoundTag;

public class StressHolder {
    private long stress = 0;

    public StressHolder() {
    }

    public StressHolder(long stress) {
        this.stress = stress;
    }

    public StressHolder copy() {
        return new StressHolder(stress);
    }

    public void setStress(long stress) {
        this.stress = stress;
    }

    public long getStress() {
        return stress;
    }

    public void write(CompoundTag tag) {
        tag.putLong("stress", stress);
    }

    public void read(CompoundTag tag) {
        if (tag.contains("stress")) {
            tag = tag.getCompound("stress");
        }
    }
}
