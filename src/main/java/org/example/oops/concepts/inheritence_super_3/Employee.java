package org.example.oops.concepts.inheritence_super_3;


/**
 * ✅ Child class that inherits from Person
 * Uses `super` to call parent constructor
 */
public class Employee extends Person {
    int salary;

    // Constructor of Employee
    public Employee(String name, int age, int salary) {
        super(name, age);  // ✅ calls Person's constructor
        this.salary = salary;
    }

    // Overridden display method
    @Override
    public void display() {
        super.display();  // ✅ calls Person's display method
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Dhananjay", 26, 70000);
        emp.display();
    }
}
