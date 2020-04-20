package com.nure.model;


public class OfficePhone extends Phone {


    private final HandSetType handSetType;
    private final boolean answeringMachinePresence;


    public OfficePhone(String manufacturer, String model, float price, HandSetType handSetType, boolean answeringMachinePresence) {
        super(manufacturer, model, price);
        this.handSetType = handSetType;
        this.answeringMachinePresence = answeringMachinePresence;
    }

    public HandSetType getHandSetType() {
        return handSetType;
    }

    public boolean isAnsweringMachinePresence() {
        return answeringMachinePresence;
    }

    public enum HandSetType{
        WIRELESS, MIXED, WIRED
    }

    @Override
    public String toString() {
        return "OfficePhone{" + super.toString() +
                "handSetType=" + handSetType +
                ", answeringMachinePresence=" + answeringMachinePresence +
                '}';
    }
}
