package org.example.oops.concepts.constructor_this_2;

/**
 ✅ 2. this() to call another constructor in same class

 */

public class Course {
    String name;
    int duration;

    public Course() {
        this("Java", 30);  // ✅ calls 2nd constructor
        System.out.println("Default constructor called");
    }

    public Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
        System.out.println("Parameterized constructor: " + name + " - " + duration + " days");
    }

    public static void main(String[] args) {
        Course c = new Course();
        // Output:
        // Parameterized constructor: Java - 30 days
        // Default constructor called
    }
}
