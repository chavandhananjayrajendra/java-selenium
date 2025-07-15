package org.example.oops.concepts.constructor_this_2;

/**
 ✅ 3. this to call current class method

 */
public class Employee {
    void greet() {
        System.out.println("Welcome Dhananjay!");
    }

    void login() {
        this.greet();  // ✅ calls greet() of same class
        System.out.println("This is the use of this keyboard to call method of a same class");
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.login();

    }
}

