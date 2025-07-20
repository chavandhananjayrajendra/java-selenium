package org.example.oops.concepts.polymorphism_6.Employee;

// ✅ Subclass - Salesperson is a specialized Employee
class Salesperson extends Employee {
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
