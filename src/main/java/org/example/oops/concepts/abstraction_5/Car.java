package org.example.oops.concepts.abstraction_5;



public class Car extends Vehicle {
    private int noOfDoors;

    public Car() {
        super(4);
    }

    @Override
    public void getSetGo() {
        System.out.println("going to place..");
    }

    @Override
    public void makeStartSound() {
        System.out.println("Vroommm.....");
    }
}