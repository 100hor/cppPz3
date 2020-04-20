package com.nure.model;

public class SmartPhone extends MobilePhone {

    private final ScreenType screenType;
    private final boolean TouchIdPresence;


    public SmartPhone(String manufacturer, String model, float price, float screenDiagonal, float batteryCapacity, ScreenType screenType, boolean touchIdPresence) {
        super(manufacturer, model, price, screenDiagonal, batteryCapacity);
        this.screenType = screenType;
        TouchIdPresence = touchIdPresence;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public boolean isTouchIdPresence() {
        return TouchIdPresence;
    }

    @Override
    public String toString() {
        return "SmartPhone{" + super.toString() +
                "screenType=" + screenType +
                ", TouchIdPresence=" + TouchIdPresence +
                '}';
    }

    public enum ScreenType{
        LCD, TFT, IPS, AMOLED, POLED, QLED
    }


}
