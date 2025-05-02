package com.bymarcin.mmrcreate.data;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;

import java.util.Objects;

public class StressHolder {
    private long stress = 0;
    private boolean producing = false;
    private long rpm = 0;//only used when producing output;

    public StressHolder() {
    }

    public StressHolder(boolean producing, long rpm, long stress) {
        this.producing = producing;
        this.rpm = rpm;
        this.stress = stress;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StressHolder that)) return false;
        return getStress() == that.getStress() && isProducing() == that.isProducing() && getRpm() == that.getRpm();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStress(), isProducing(), getRpm());
    }

    public StressHolder setProducing(boolean producing) {
        this.producing = producing;
        return this;
    }

    public boolean isProducing() {
        return producing && rpm > 0 && stress > 0;
    }

    public StressHolder setRpm(long rpm) {
        this.rpm = rpm;
        return this;
    }

    public long getRpm() {
        return rpm;
    }

    public StressHolder copy() {
        return new StressHolder(producing, rpm, stress);
    }

    public StressHolder setStress(long stress) {
        this.stress = stress;
        return this;
    }

    public long getStress() {
        return stress;
    }

    public void write(CompoundTag tag) {
        tag.putLong("stress", stress);
        tag.putLong("rpm", rpm);
        tag.putBoolean("producing", producing);
    }

    public void read(CompoundTag tag) {
        if (tag.contains("stress")) {
            stress = tag.getLong("stress");
        }
        if (tag.contains("rpm")) {
            rpm = tag.getLong("rpm");
        }
        if (tag.contains("producing")) {
            producing = tag.getBoolean("producing");
        }
    }
}
