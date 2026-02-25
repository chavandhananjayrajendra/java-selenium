package org.example.selenium.examples.testng.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {
@Test
    void test_hardassertions(){

    System.out.println("testing....");
    System.out.println("testing.....");

    Assert.assertEquals(1,2);//hard assertions

    System.out.println("Testing...");
    System.out.println("Testing...");
}

@Test

    void test_softassertions(){


    System.out.println("testing....");
    System.out.println("testing.....");
    SoftAssert sa = new SoftAssert();


    sa.assertEquals(1,2);//soft assertions

    System.out.println("Testing...");
    System.out.println("Testing...");


    sa.assertAll();



}

}
