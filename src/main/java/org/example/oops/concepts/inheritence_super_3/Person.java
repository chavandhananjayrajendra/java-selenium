package org.example.oops.concepts.inheritence_super_3;


/**
 * ✅ Parent class with common fields and constructor
 */
public class Person {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor called");
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
