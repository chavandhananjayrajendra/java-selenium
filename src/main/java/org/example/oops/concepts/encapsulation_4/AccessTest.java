package org.example.oops.concepts.encapsulation_4;

public class AccessTest {
    public static void main(String[] args) {
        Public p1 = new Public();
        p1.color = "Red";
        p1.model = "Swift";
        System.out.println(p1);
        p1.CostOfPurchase = 7654;
        Public p2 = new Public("Black","BMW",1,5000);
        System.out.println(p2);
        Default def = new Default();


    }
}
