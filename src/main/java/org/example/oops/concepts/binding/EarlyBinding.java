package org.example.oops.concepts.binding;

public class EarlyBinding {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.calculate(5, 10);         // int version
        calc.calculate(5.5, 10.5);     // double version
    }
}
class Calculator
{

    void calculate(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }

    void calculate(double a, double b) {
        System.out.println("Sum: " + (a + b));
    }
}



//The method to call is resolved at compile time based on method signature — this is early binding.


/*Happens at compile-time.

Associated with method overloading or private/final/static methods.

Compiler knows exact method to call based on reference type. */