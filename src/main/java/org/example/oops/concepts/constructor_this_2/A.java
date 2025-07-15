
/**
 *
 *this keyword use cases in different manner
 Use Case	                Code Syntax	            Purpose
 Refer instance variable	this.name = name;	Resolve shadowing
 Call another constructor	this(...);	        Constructor chaining
 Call current method	    this.method();	    Avoid redundancy
 Pass current object	    someMethod(this);	Use current reference
 */

package org.example.oops.concepts.constructor_this_2;

/**
 ✅ 4. this to pass current object as argument


 */

public class A {
    void show(A obj) {
        System.out.println("Object received: " + obj);
    }

    void call() {
        show(this);  // ✅ passing current object as argument
    }

    public static void main(String[] args) {
        A a = new A();
        a.call();  // Output: Object received: A@<hashcode>
    }
}
