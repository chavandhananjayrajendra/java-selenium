package org.example.oops.concepts.abstraction_5;



public class TestAbstraction {
    public static void main(String[] args) {
        //Vehicle veh = new Vehicle(2);
        Car car = new Car();
        car.commute();
        car.makeStartSound();
    }
}