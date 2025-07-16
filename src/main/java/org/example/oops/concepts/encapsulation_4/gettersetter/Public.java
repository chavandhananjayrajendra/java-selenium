package org.example.oops.concepts.encapsulation_4.gettersetter;

public class Public {
    private  String color;
    private   String model;
    private double fuelLevel;
    private  long costOfPurchase;

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public long getCostOfPurchase() {
        return costOfPurchase;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setCostOfPurchase(long costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    public Public(String color, String model, double fuelLevel, long costOfPurchase) {
        this.color = color;
        this.model = model;
        this.fuelLevel = fuelLevel;
        this.costOfPurchase = costOfPurchase;
    }
}
