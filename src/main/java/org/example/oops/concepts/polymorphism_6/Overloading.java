package org.example.oops.concepts.polymorphism_6;

public class Overloading {
    public int sum(int a ,int b){
        return a+b;
    }
    public static int sum(int a, int b, int c, int d){
        return a+b+c+d;
    }
    public String sum(String a,String b){
        return a + b;
    }

    public static void main(String[] args) {
        Overloading o1 = new Overloading();
        System.out.println(o1.sum(23,24));
        System.out.println(Overloading.sum(3,4,5,6));
        System.out.println(o1.sum("Dhananjay", " Saku"));

    }

}
