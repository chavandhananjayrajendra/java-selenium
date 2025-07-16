package org.example.oops.concepts.encapsulation_4;

public class Public {
    public String color;
    public  String model;
    private double fuellevel;
    long CostOfPurchase;
public Public(){

}

    @Override
    public String toString() {
        return "Public{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", fuellevel=" + fuellevel +
                ", costOfPurchase=" + costOfPurchase +
                '}';
    }

    private long costOfPurchase;

    public Public(String color, String model, double fuellevel, long costOfPurchase) {
        this.color = color;
        this.model = model;
        this.fuellevel = fuellevel;
        this.costOfPurchase = costOfPurchase;
    }
}
