package org.example.oops.concepts.abstraction_5;

class Super2 extends Super {

Super2(int sckm){
    super(sckm);
}

    @Override
    public void getPrice() {
        //getSckm();
        super.getSckm(); //optional but if  name conflict is there user has to use it for better understanding
        

    }
}
