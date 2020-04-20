package com.nure.model;

public class MobilePhone extends Phone {

    private final float screenDiagonal;
    private final float batteryCapacity;

    public MobilePhone(String manufacturer, String model, float price, float screenDiagonal, float batteryCapacity) {
        super(manufacturer, model, price);
        if (screenDiagonal <= 0 && batteryCapacity <= 0) throw new RuntimeException("Values must be positive");
        this.screenDiagonal = screenDiagonal;
        this.batteryCapacity = batteryCapacity;
    }

    public float getScreenDiagonal() {
        return screenDiagonal;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String toString() {
        return "MobilePhone{" + super.toString() +
                "screenDiagonal=" + screenDiagonal +
                ", batteryCapacity=" + batteryCapacity +
                '}';
    }
}
