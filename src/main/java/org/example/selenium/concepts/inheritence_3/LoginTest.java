package org.example.selenium.concepts.inheritence_3;


/**
 * ✅ Inherits from BaseTest and reuses browser setup
 */
public class LoginTest extends BaseTest {

    public void runTest() {
        launchBrowser("https://example.com");  // inherited method
        System.out.println("Login test steps go here...");
        tearDown();  // inherited method
    }

    public static void main(String[] args) {
        LoginTest test = new LoginTest();
        test.runTest();
    }
}
