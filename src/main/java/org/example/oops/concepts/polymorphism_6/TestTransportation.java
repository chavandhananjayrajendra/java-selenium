package org.example.oops.concepts.polymorphism_6;

public class TestTransportation {
    public static void main(String[] args) {
        Car c = new Car();
        Vehicle v = new Vehicle();

        Vehicle v1 = new Car();
        Plane p = new Plane();
       // Car c2 = (Car) new Vehicle();

        //Object red = new Car();
        castTest(v);
        castTest(c);
        castTest(p);
       // Object red1 =  new Vehicle();

    }
    private static void castTest(Vehicle vh){
        Car c2 = (Car) vh;
        c2.start();
     // vh.start();
       //prefer to use
        if(vh instanceof Car){

        }
    }
}
//while implementing downcasting is allowed if reference to the parent class is given.in such cases reference to parent methods through child objects can be created,in our case Car c2 = (Car) vh specifies that the object is from Vehicle only
