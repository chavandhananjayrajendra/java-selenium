package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseClasss;
import com.automation.pages.LoginPage;
import com.automation.utilities.ExcelReader;

public class LoginTest extends BaseClasss {

    // DataProvider reads Excel data
    @DataProvider(name = "LoginData")
    public Object[][] loginData() throws Exception {

        return ExcelReader.getTestData("LoginData");
    }

    // Same test executes for every Excel row
    @Test(dataProvider = "LoginData")
    public void verify_login(String testCaseID, String username, String password, String expectedResult) {

        // Create LoginPage object
        LoginPage lp = new LoginPage(driver);

        // Perform login using Excel data
        lp.login(username, password);

        // Capture actual result
        String actualMessage = lp.getMessage();

        // Validate expected result
        if (expectedResult.equalsIgnoreCase("PASS")) {

            Assert.assertTrue(
                    actualMessage.contains("You logged into a secure area!"),
                    "Login should be successful"
            );

        } else {

            Assert.assertTrue(
                    actualMessage.contains("invalid"),
                    "Login should fail with an invalid credentials message"
            );
        }

        System.out.println("Username: " + username);
        System.out.println("Expected: " + expectedResult);
        System.out.println("Actual Message: " + actualMessage);
    }
}
