package org.example.oops.concepts.classobject_1;



/**
 * ✅ Object Creation and Accessing Members
 * This class shows how to create objects and use class variables/methods.
 */
public class MainApp {
    public static void main(String[] args) {

        // ✅ Creating first object of Employee class
        Employee emp1 = new Employee(); // Object created in heap memory
        emp1.name = "Dhananjay";
        emp1.salary = 60000;
        emp1.displayInfo();  // Method call using object

        System.out.println("--------------------");

        // ✅ Creating another object
        Employee emp2 = new Employee();
        emp2.name = "Aman";
        emp2.salary = 55000;
        emp2.displayInfo();  // Separate copy of variables
    }
}
