package org.example.selenium.examples.testng.dependencyMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DePendencyMethods {


    @Test(priority = 1)
    void openapp(){

        Assert.assertTrue(true);
    }

    @Test(priority = 2,dependsOnMethods = {"openapp"})
    void login(){
        Assert.assertTrue(true);
    }

    @Test(priority = 3,dependsOnMethods = {"login"})
    void search(){
        Assert.assertTrue(false);
    }
    @Test(priority = 4,dependsOnMethods = {"login","search"})
    void advsearch(){
        Assert.assertTrue(true);
    }


}
