package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
* Theory: Working with Static Tables in Selenium
 * ----------------------------------------------
         * 1. A static table has a fixed number of rows and columns during runtime.
 *    - Table structure and data do not change unless the page is reloaded or updated manually.
        *
        * 2. HTML Structure of a Table:
        *    - <table> : Defines the table element.
        *    - <thead> : Contains table header rows (<th> elements).
        *    - <tbody> : Contains table body rows (<tr> elements).
        *    - <tr> : Defines a table row.
        *    - <td> : Defines a table cell (data column).
        *
        * 3. Locating Table Data in Selenium:
        *    - Rows: Locate using XPath with <tr>.
        *    - Columns: Locate using XPath with <td> or <th>.
 *    - Example:
        *        //table[@class='table']/tbody/tr  -> All rows
        *        //table[@class='table']/tbody/tr[1]/td -> All columns in first row
        *
        * 4. Steps to Read a Static Table:
        *    a) Identify the table using an appropriate locator.
 *    b) Get all row elements into a List<WebElement>.
 *    c) Loop through each row and find its column (<td>) elements.
        *    d) Extract and print the text from each cell.
        *
        * 5. Key Points:
        *    - First row is often table header (<th>), not data.
        *    - Always skip the header if you only want data rows.
 *    - Static tables are easier to handle because their DOM doesn’t change dynamically.
       Get all rows: //table/tbody/tr
       Get all columns in a row: //table/tbody/tr[1]/td
       Get specific cell: //table/tbody/tr[2]/td[3]
 */

public class StaticTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

//for one single table
        int rows =driver.findElements(By.tagName("tr")).size();


        //multiple table in a webpage but want to count specific table rows
      int rows2 =  driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("Number of rows : "+ rows2);


        int columns = driver.findElements(By.xpath("//table[@name = 'BookTable']//th")).size();
//get number of columns from table
        int cols = driver.findElements(By.tagName("th")).size();
        System.out.println("No of columns "+ cols);
        System.out.println("No of columns "+columns);



        //read data from specific row /column
String bookname = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr[5]//td[1]")).getText();
        System.out.println(bookname);


        //read data from all rows and columns
//
//        for(int r = 2;r<=rows2;r++)
//        {
//            for(int c = 1; c<=columns;c++){
//
//
//                //for passing dynamic variables in xpath parameters this is the synatax variable surrounded by "+ variablename +"
//               String value =  driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+r+"]//td["+c+"]")).getText();
//                System.out.print(value+"\t");
//
//            }
//            System.out.println();
//        }


        //print book name whose author is Mukesh ( conditional based print)
//for (int r2 =2;r2<=rows2;r2++){
//    String authname = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+r2+"]//td[2]")).getText();
////    System.out.println(authname);
//
//
//    if(authname.equals("Mukesh")){
//        String bname = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr[\"+r2+\"]//td[1]")).getText();
//        System.out.println(bname + "\t" + authname);
//
//
//
//    }
//
//}

        int total = 0;

for(int r3 = 2;r3<=rows2;r3++){
    String price =driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+r3+"]//td[4]")).getText();
    total=total+Integer.parseInt(price);

}
        System.out.println("Sum : "+total);

driver.quit();


    }
}
