package org.example.oops.concepts.encapsulation_4.Package2;


import org.example.oops.concepts.encapsulation_4.gettersetter.Public;

public class GetterTest {
    public static void main(String[] args) {
        Public p4 = new Public("red", "wagonour", 1, 2222);
        p4.setColor("green");
        System.out.printf("%s %s",p4.getColor(),p4.getModel());

    }


}
