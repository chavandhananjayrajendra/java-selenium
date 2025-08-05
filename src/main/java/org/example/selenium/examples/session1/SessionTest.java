package org.example.selenium.examples.session1;

public class SessionTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    BaseTest b1 = new BaseTest();
    b1.setup();
        System.out.println("Test 1 is done");
    }
}
