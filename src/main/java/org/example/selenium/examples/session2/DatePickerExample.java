package org.example.selenium.examples.session2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;



//this will work for the date greater than current  date -,........
public class DatePickerExample {
    public static void main(String[] args) throws InterruptedException {

        // Setup driver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/datepicker/");

        // Switch to frame because datepicker is inside iframe
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Open datepicker
        driver.findElement(By.id("datepicker")).click();

        // Target date (You can change this dynamically)
        String targetDate = "25-December-2025";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        LocalDate td = LocalDate.parse(targetDate, formatter);

        String targetMonthYear = td.getMonth().name().substring(0, 1).toUpperCase()
                + td.getMonth().name().substring(1).toLowerCase() + " " + td.getYear();

        while (true) {
            // Get current month-year displayed
            String currentMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();

            // If month and year match, break
            if (currentMonthYear.equalsIgnoreCase(targetMonthYear)) {
                break;
            }

            // If target date is in future → click next arrow
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        // Select the day
        driver.findElement(By.xpath("//a[text()='" + td.getDayOfMonth() + "']")).click();

        Thread.sleep(2000);
        driver.quit();
    }
}

