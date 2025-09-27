package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatePicker {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");
driver.manage().window().maximize();

//switch to frame
driver.switchTo().frame(0);


////Method 1: using sendkeys()
//        driver.findElement(By.xpath(" //input[@id='datepicker']")).sendKeys("09/18/2025");   //mm//yy//yyyy
//

        //method 2: using date picker

        String month = "October";
        String year = "2023";
        String date = "20";

        driver.findElement(By.xpath(" //input[@id='datepicker']")).click();   //opens date picker

//Select month & year
        while (true){


            String currentMonth = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();   //to get actual month from the website
        String currentYear = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();   //to get actual year from the website
if(currentMonth.equals(month) && currentYear.equals(year)){
    break;
}

//driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();  //next button

            driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();  //previous date  button




        }


        //select the date

          driver.findElement(By.xpath("table[@class ='ui-datepicker-calendar']//a[text()='"+date+"']")).click();

        }





    }

