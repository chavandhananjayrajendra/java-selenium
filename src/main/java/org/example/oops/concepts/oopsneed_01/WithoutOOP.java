package org.example.oops.concepts.oopsneed_01;

//No structure
//
//Hard to manage multiple employees
//
//Code repetition if you add more fields
// Procedural-style code


//why oop needed?
//---to implement parameters based on the number of employees---
//-- use only required detail as per domain -> abstraction ---
//---private variables can be accessed in c++/not in java as pointer concept is absent in java
//
//
//----binding---when a method is called on an object compiler implicityly passes object reference as first parameter to that method.
//assume u doing
//employee.displaydetails()--- is this called when a method is called object employee is passed on that
//
//
////activation:
//step 1 : memory allocation in heap
//step 2 : object creation with variables (undefined-js || 0-java ||garbage value-c++)
//step 3 : initialization of values through constructor if provided
//
////inheritance
////polymorphism
//
////
//inheritence---is a relationship
public class WithoutOOP {
    public static void main(String[] args) {
        String name = "Alice";
        int age = 30;
        String dept = "IT";

        printEmployee(name, age, dept);
    }

    static void printEmployee(String name, int age, String dept) {
        System.out.println(name + " is " + age + " years old and works in " + dept);
    }
}
