package com.nure.model;

public class PushButtonPhone extends MobilePhone{


    private final KeyboardType keyboardType;
    private final BodyType bodyType;


    public PushButtonPhone(String manufacturer, String model, float price, float screenDiagonal, float batteryCapacity, KeyboardType keyboardType, BodyType bodyType) {
        super(manufacturer, model, price, screenDiagonal, batteryCapacity);
        this.keyboardType = keyboardType;
        this.bodyType = bodyType;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }


    @Override
    public String toString() {
        return "PushButtonPhone{" + super.toString() +
                "keyboardType=" + keyboardType +
                ", bodyType=" + bodyType +
                '}';
    }

    public enum BodyType{
        STANDARD, COT, INDOOR_KEYBOARD
    }

    public enum KeyboardType{
        QWERTY, THREE_BY_FOUR
    }





}
