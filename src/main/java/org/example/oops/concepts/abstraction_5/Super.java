package org.example.oops.concepts.abstraction_5;

public  abstract class Super {
    private int sckm ;

     Super() {
         this.sckm= 0;
    }
    Super(int sckm){
         this.sckm = sckm;
    }

    public int getSckm() {
        return this.sckm;
    }

    public abstract void getPrice();



}
