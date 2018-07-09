package com.zq.learn.energyservice.entity;

public class PointValue {
    private Double value;
    private int quality;

    public PointValue() {
    }

    public PointValue(Double value, int quality) {
        this.value = value;
        this.quality = quality;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
