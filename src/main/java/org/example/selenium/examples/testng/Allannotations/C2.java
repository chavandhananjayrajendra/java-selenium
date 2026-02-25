package org.example.selenium.examples.testng.Allannotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {
    @Test
    void xyz(){
        System.out.println("this is xyz from C2");
    }
    @AfterTest
    void at(){
        System.out.println("this is after test method");
    }


}
