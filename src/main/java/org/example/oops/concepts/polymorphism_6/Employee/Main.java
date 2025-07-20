package org.example.oops.concepts.polymorphism_6.Employee;


/**
 *
 */
//"Polymorphism in Java enables objects to be treated as instances of their parent type, but still execute child-class-specific behavior. This leads to dynamic method dispatch, which is a key to extensibility and flexibility in code.
//
//Java achieves polymorphism in two ways — method overloading at compile time, and method overriding at runtime. The JVM decides at runtime which method to invoke based on the actual object instance, not the reference type. This is particularly useful when using parent references to hold child objects."


public class Main {
    public static void main(String[] args) {

        // ✅ 1. Normal object of parent class
        Employee dhanya = new Employee(15, 100);
        // Static binding (compile-time polymorphism doesn't apply here)
        dhanya.displayDetails();
        System.out.println("Salary of Dhanya: " + dhanya.calculateSalary());

        System.out.println();

        // ✅ 2. Object of child class
        Salesperson shriraj = new Salesperson(20, 200, 2000);
        // Method not overridden: displayDetails() → inherited from Employee
        shriraj.displayDetails();
        // Overridden method → dynamic dispatch (runtime polymorphism)
        System.out.println("Salary of Shriraj: " + shriraj.calculateSalary());
        System.out.println("Sales of Shriraj: " + shriraj.getSales());

        System.out.println();

        // ✅ 3. Parent reference → Child object (runtime polymorphism)
        Employee adi = new Salesperson(25, 200, 3000);
        // Although reference is of type Employee,
        // Java will call Salesperson's overridden method
        adi.displayDetails();
        System.out.println("Salary of Adi: " + adi.calculateSalary()); // dynamic method dispatch

        // 🔁 To access methods specific to Salesperson (like getSales),
        // we need to downcast
        if (adi instanceof Salesperson) {
            Salesperson adiCast = (Salesperson) adi;
            System.out.println("Sales of Adi: " + adiCast.getSales());
        }

        System.out.println();

        // ❌ Compile-time error: cannot assign parent to child directly
        // Salesperson tanmay = new Employee(); // Not allowed

        // ✅ Summary:
        // - Method overriding enables polymorphism.
        // - Object behavior is determined by the actual instance (Salesperson),
        //   not the reference type (Employee).
        // - This is the foundation of **runtime polymorphism**.
    }
}
