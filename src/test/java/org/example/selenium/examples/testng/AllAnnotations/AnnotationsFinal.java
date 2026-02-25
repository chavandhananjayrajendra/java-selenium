package org.example.selenium.examples.testng.AllAnnotations;

import org.testng.annotations.*;

public class AnnotationsFinal {

    @BeforeSuite
    void bs(){

        System.out.println("Before Suite method");
    }
    @AfterSuite
    void as(){

        System.out.println("After Suite");


    }
    @BeforeTest
    void bt(){

        System.out.println("Before Test");
    }

    @AfterTest
    void at(){

        System.out.println("After Test");
    }
    @BeforeClass
    void bc(){

        System.out.println("This is before Class Method");
    }

    @AfterClass
    void ac(){
        System.out.println("This is after Class method");
    }
    @BeforeMethod
    void bm(){
        System.out.println("Before Method");
    }
    @AfterMethod
    void am(){
        System.out.println("After Method");
    }

    @Test
    void tm1(){
        System.out.println("Test Method 1");
    }

    @Test(priority = 2)
    void tm2(){
        System.out.println("Test Method 2");
    }

}
