package org.example.selenium.examples.session2;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws Exception {

        //broken link->a link which does not have any resource in the server
//        resource in the server->can be identified through status codes.
        //if the status code is >=400 it indicates the link is broken
        //if status code <400,that means the link is not a broken link



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");

        // capture all links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());

        int brokenCount = 0;

        for (WebElement link : links) {

            String hrefValue = link.getAttribute("href");

            if (hrefValue == null || hrefValue.isEmpty()) {
                continue;
            }

            URL url = new URL(hrefValue);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode >= 400) {
                System.out.println("Broken link: " + hrefValue + " -> " + responseCode);
                brokenCount++;
            }
        }

        System.out.println("Total broken links: " + brokenCount);

        driver.quit();
    }
}
