package org.example.selenium.concepts.classobject_1;


/**
 * ✅ OBJECT CREATION IN SELENIUM PROJECT
 * Shows how to use object of BaseTest to run test cases.
 */
public class LoginTest {
    public static void main(String[] args) {

        // ✅ Creating object of BaseTest class
        BaseTest test = new BaseTest();

        // ✅ Calling methods using object
        test.openBrowser();
        System.out.println("Browser launched successfully.");
        test.closeBrowser();
        System.out.println("Test complete.");
    }
}
