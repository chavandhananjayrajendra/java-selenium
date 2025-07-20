package org.example.oops.concepts.oopsneed_01;

//✅ Code is organized and reusable
//
//✅ Easy to manage multiple employees
//
//✅ Data is bundled with behavior → Encapsulation
//
//✅ You can easily add new types (like Manager, Intern) using Inheritance
//
//✅ Method overriding possible → Polymorphism
// OOP style: Data + Behavior = Class
public class WithOOP {
    String name;
    int age;
    String department;

    // Constructor
    public WithOOP(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Method (Behavior)
    public void printDetails() {
        System.out.println(name + " is " + age + " years old and works in " + department);
    }

    public static void main(String[] args) {
        // ✅ Object creation (real-world entity)
        WithOOP emp1 = new WithOOP("Dhananjay", 22, "AT");
        WithOOP emp2 = new WithOOP("Aditya", 22, "DEV");

        // ✅ Behavior through method
        emp1.printDetails();
        emp2.printDetails();
    }

}


