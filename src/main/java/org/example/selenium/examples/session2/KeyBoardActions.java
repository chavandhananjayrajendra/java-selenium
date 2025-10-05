package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


//KeyBoard Actions are implemented through --->Action Class

//KeyDown()--->Press the key
//KeyUp()--->Relese the Key

//Ctrl+Shift+A
//act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform(); // same order should be followed while relesing the key
//Ex.Enter
//act.KeyDown(Keys.ENTER).KeyUp(Keys.ENTER)

public class KeyBoardActions {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("DHANANJAY");
        Actions act=new Actions (driver);
        //Ctrl+A  ->>>Selects the text

        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp (Keys.CONTROL).perform();


        //CTRL+C copy the text into clipboard
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp (Keys.CONTROL).perform();

        //TAB shift to 2nd box

        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //CTRL+V paste the text
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp (Keys.CONTROL).perform();



    }}
