package org.example.oops.concepts.polymorphism_6;

public class Overriding {
    public static void main(String[] args) {

       //Child class method calling
        Hitman Rohit = new Hitman();
      Rohit.lovecricket();

      //child class method calling
      KIng Kohli = new KIng();
      Kohli.lovecricket();

      //Parent class method calling
      Cricket c = new Cricket();
      c.lovecricket();


    }
}
