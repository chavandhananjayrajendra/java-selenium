package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");



        //select particular checkbox by xPath
        WebElement chkbox = driver.findElement(By.xpath("//input[@id='sunday']"));
        System.out.println("before selection : " + chkbox.isSelected());

//        driver.findElement(By.xpath("//input[@id='sunday']")).click();
        System.out.println("after selection : " + chkbox.isSelected());



        //capturing  all checkboxes

        List<WebElement> chkboxes = driver.findElements(By.xpath("//input[@class = 'form-check-input' and @type = 'checkbox']"));
     System.out.println("Total Number of checkboxes : "+chkboxes.size());


////     //selecting all checkboxes
////
////        for( int i = 0; i<chkboxes.size();i++){
////            chkboxes.get(i).click();
////        }
////
////        for( WebElement chk: chkboxes){
////            chk.click();
////        }
//
//
//
//        //selecting last three checkboxes : (total number of checkboxes- how many  checkboxes u want to select)= starting index
//        //7-3 = 4 starting index
//
//        for(int i = 4;i<chkboxes.size();i++){
//            chkboxes.get(i).click();
//        }
//
//
//        //selecting first 3 checkboxes
//        for(int i = 0; i<3; i++){
//chkboxes.get(i).click();
//        }
//

        //select/unselect checkboxes

//        for(WebElement chkbox1 : chkboxes){
//            if(chkbox1.isSelected()){
//                chkbox1.click();
//            }
//            else {
//                chkbox1.click();
//            }
//        }
//
//Thread.sleep(5000);
//
//        for(WebElement chkbox1 : chkboxes){
//            if(chkbox1.isSelected()){
//                chkbox1.click();
//            }
//            else {
//                chkbox1.click();
//            }
//        }


//select specific checkboxes randomly
//        for(int i = 0;i<chkboxes.size();i++){
//            if(i ==1 || i==3 || i ==7){
//                chkboxes.get(i).click();
//            }
//        }



        // select checkbox based on the value
String weekname = "Saturday";
        switch (weekname){
            case "Sunday" : driver.findElement(By.xpath("//*[@id=\"sunday\"]")).click();
            break;
            case "Monday" : driver.findElement(By.xpath("//*[@id=\"monday\"]")).click();
            break;
            case "Tuesday" : driver.findElement(By.xpath("//*[@id=\"tuesday\"]")).click();
            break;
            case "Wednesday" : driver.findElement(By.xpath("//*[@id=\"wednesday\"]")).click();
            break;
            case "Thursday" : driver.findElement(By.xpath("//*[@id=\"thursday\"]")).click();
            break;
            case "Friday" : driver.findElement(By.xpath("//*[@id=\"friday\"]")).click();
            break;
            case "Saturday" : driver.findElement(By.xpath("//*[@id=\"saturday\"]")).click();
            break;
            case "default" :
                System.out.println("invalid date");




        }




    }
}
