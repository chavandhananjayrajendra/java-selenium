package org.example.oops.concepts.constructor_this_2;

/**✅ 1. this to refer current class instance variable
*/
public class Student {
    String name;

    // Constructor parameter and instance variable are same
    public Student(String name) {
        this.name = name;  // ✅ resolves variable shadowing
    }

    public void show() {
        System.out.println("Student name: " + name);
    }

    public static void main(String[] args) {
        Student s = new Student("Dhananjay");
        s.show();  // Output: Student name: Dhananjay
    }
}
