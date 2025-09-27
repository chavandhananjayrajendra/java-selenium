package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;



/*
 select dropdowns---


 select class

 */

public class SelectDropDown {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\bakup//chromedriver-win64 latest//chromedriver-win64//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement contryEle =  driver.findElement(By.xpath("//select[@id='country']"));

        //special type of class used when u see Select tagname is there on the page
        Select country = new Select(contryEle);

//select tag necessary in html to use these methods
        //select option from dropdown

        //selectByVisibleText()
        //selectByValue()
        //selectByIndex()

        country.selectByVisibleText("France");  //select france from dropdown//innertext
        country.selectByValue("japan");  //value  attribute start from lowercase

       country.selectByIndex(2); //count manually
        //
        //value of a particular option element
        // visible Text embedded in the tag

        // their names may or may not be same based on the use-case and need
        //both are different

        //by using one of them u can select dropdown
        List<WebElement> options = country.getOptions();
        System.out.println("Total no of options available in drop down :  "+ options.size());

//        for(int i = 0; i<options.size();i++){
//            System.out.println(options.get(i).getText());
//
//
//            //getoptions()----returns all options from the dropdown as a WebElement
//        }
//
        for(WebElement opn: options){
            System.out.println(opn.getText());
        }

    }
}
