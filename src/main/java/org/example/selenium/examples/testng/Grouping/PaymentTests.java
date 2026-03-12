package org.example.selenium.examples.testng.Grouping;

import org.testng.annotations.Test;

public class PaymentTests {

    @Test(priority = 1,groups = {"sanity","regression","functional"})
    void paymentRupees(){
        System.out.println("Payment-rupees");

    }
    @Test(priority = 2,groups = {"sanity","regression","functional"})
    void paymentdollars() {
        System.out.println("Payment-dollars");
    }


}
