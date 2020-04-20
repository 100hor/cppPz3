package com.nure.model;

public class Phone implements Comparable<Phone> {

    private final String manufacturer;
    private final String model;
    private final float price;


    public Phone(String manufacturer, String model, float price) {
        if (price < 0) throw new RuntimeException("Price must be positive");
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public float getPrice() {
        return price;
    }

    public void makeCall() throws InterruptedException {
        System.out.println("Call is started");
        Thread.sleep(1000);
        System.out.println("Call is finished");
    }


    @Override
    public String toString() {
        return "Phone{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Phone otherPhone) {
        if (price == otherPhone.price)
            return 0;
        return (price > otherPhone.price) ? 1 : -1;
    }
}
