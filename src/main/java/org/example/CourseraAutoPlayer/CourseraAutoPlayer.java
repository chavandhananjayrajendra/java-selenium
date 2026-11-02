package org.example.CourseraAutoPlayer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CourseraAutoPlayer {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Keeps browser logged in
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open Coursera
        driver.get("https://www.coursera.org/");

        System.out.println("Login manually within 60 seconds...");
        Thread.sleep(60000);

        // Open your course manually before automation starts
        System.out.println("Open the course page...");
        Thread.sleep(30000);

        while (true) {

            try {

                // Play video if paused
                try {
                    WebElement playButton = wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    By.cssSelector("button[aria-label='Play']")
                            )
                    );

                    playButton.click();

                } catch (Exception ignored) {
                }

                // Set playback speed to 2x
                try {

                    WebElement settings = wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    By.cssSelector("button[aria-label='Settings']")
                            )
                    );

                    settings.click();

                    Thread.sleep(1000);

                    List<WebElement> menuItems =
                            driver.findElements(By.xpath("//span[contains(text(),'Playback speed')]"));

                    if (!menuItems.isEmpty()) {

                        menuItems.get(0).click();

                        Thread.sleep(1000);

                        WebElement speed2x = driver.findElement(
                                By.xpath("//span[contains(text(),'2x')]")
                        );

                        speed2x.click();
                    }

                } catch (Exception ignored) {
                }

                System.out.println("Waiting for video completion...");

                // Simple wait (example 8 mins)
                Thread.sleep(8 * 60 * 1000);

                // Click next item
                try {

                    WebElement nextButton = wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    By.xpath("//button[contains(.,'Go to next item')]")
                            )
                    );

                    nextButton.click();

                    System.out.println("Moved to next lesson");

                } catch (Exception e) {

                    System.out.println("Next button not found.");
                    break;
                }

                Thread.sleep(5000);

            } catch (Exception e) {

                e.printStackTrace();
                break;
            }
        }

        driver.quit();
    }
}