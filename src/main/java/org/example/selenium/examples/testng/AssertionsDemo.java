package org.example.selenium.examples.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
@Test
    void testTitle(){
     String exp_title = "Opencart";
     String act_title = "Openshot";
//     if(exp_title.equals(act_title)){
//         System.out.println("Test Passed");
//     }
//     else {
//         System.out.println("Test Failed");
//     }

//    Assert.assertEquals(exp_title,act_title);



    //to use assertions with conditional statement
    if(exp_title.equals(act_title)){
        System.out.println("Test passed");
        Assert.assertTrue(true);
    }
    else {
        System.out.println("Test failed");
        Assert.assertTrue(false);
    }

    }
}
