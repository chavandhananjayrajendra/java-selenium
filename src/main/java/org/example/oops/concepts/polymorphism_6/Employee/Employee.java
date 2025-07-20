package org.example.oops.concepts.polymorphism_6.Employee;

// ✅ Superclass - General employee with hours and rate
public class Employee {
    int hours;
    double rate;

    // Constructor chaining
    public Employee() {
        this(10, 100); // default values
    }

    public Employee(int hours, double rate) {
        this.hours = hours;
        this.rate = rate;
    }

    // ✅ Method to calculate salary (can be overridden)
    public double calculateSalary() {
        return hours * rate;
    }

    public void displayDetails() {
        System.out.println("Hours: " + hours + ", Rate: " + rate);
    }

    // ✅ Subclass - Salesperson is a specialized Employee
    static class Salesperson extends Employee {
        double sales;

        // Constructor chaining within Salesperson
        public Salesperson() {
            this(1000); // default sales
        }

        public Salesperson(double sales) {
            this(10, 100, sales);
        }

        // Constructor using super to call parent class constructor
        public Salesperson(int hours, double rate, double sales) {
            super(hours, rate); // super() for parent constructor
            this.sales = sales;
        }

        // ✅ Overriding method from Employee → Runtime Polymorphism
        @Override
        public double calculateSalary() {
            return (hours * rate) + (sales / 100);
        }

        public double getSales() {
            return sales;
        }
    }
}
