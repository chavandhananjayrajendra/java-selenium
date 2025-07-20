package org.example.oops.concepts.binding;


class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class LateBinding {
    public static void main(String[] args) {
        Animal animal = new Dog();  // Upcasting

//to show late binding for parent method
     if(animal instanceof Dog){
         Dog d = (Dog) animal;
         d.makeSound();
     }
        animal.makeSound();         // Late binding at runtime
    }
}

//Binding Type	Instruction Used	Method Type	Resolution Time
//Early Binding	invokestatic, invokespecial	static, final, private, constructor	Compile-time
//Late Binding	invokevirtual	instance (non-final, non-static)	Runtime



//Upcasting is the process of casting a subclass object to a superclass reference.
//It is safe, implicit, and requires no special syntax.


//Downcasting is the process of casting a superclass reference back to a subclass.
//It is explicit, not type-safe without checks, and can throw ClassCastException.