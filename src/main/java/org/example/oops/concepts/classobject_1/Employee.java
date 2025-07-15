package org.example.oops.concepts.classobject_1;



/**
 * ✅ CLASS & OBJECT IN JAVA
 * A class is a blueprint for creating objects (real-world entities).
 * An object is an instance of a class.
 */
public class Employee {

    // ✅ Instance variables (each object gets its own copy)
    String name;
    int salary;

    // ✅ Method to display employee details
    public void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}
