package org.example.selenium.examples.session1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 *
 *1. child::
 * Description: Selects all direct child elements of the current node.
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //div[@id='main']/child::h1
 * Finds the <h1> that is a direct child of <div id="main">.
 *------------------------------------------------
 * 2. parent::
 * Description: Selects the parent of the current node.
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //input[@id='email']/parent::div
 * Finds the <div> that is the parent of the email input.
 *------------------------------------
 * 3. following::
 * Description: Selects all elements in the document after the current node.
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //label[text()='Email']/following::input[1]
 * Finds the first input that comes after the "Email" label.
 *------------------------------------------------------------------------
 * 4. preceding::
 * Description: Selects all nodes before the current node in the document.
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //input[@id='password']/preceding::label[1]
 * Finds the label before the password input.
 *---------------------------------------------------
 * 5. following-sibling::
 * Description: Selects all siblings after the current node.
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //li[1]/following-sibling::li
 * Gets all list items after the first <li>.
 *
 * 6. preceding-sibling::
 * Description: Selects all siblings before the current node.
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //li[3]/preceding-sibling::li
 * Gets all <li> elements before the 3rd one.
 *
 * 7. ancestor::
 * Description: Selects all ancestors (parent, grandparent, etc.).
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //input[@id='email']/ancestor::form
 * Finds the <form> that wraps the email input.
 *
 * 8. descendant::
 * Description: Selects all descendants (children, grandchildren).
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //div[@id='main']/descendant::input
 * Finds all input fields inside <div id="main">.
 *
 * 9. self::
 * Description: Selects the current node itself.
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //input[@id='email']/self::input
 * Refers to the input node itself.
 *
 * 10. descendant-or-self::
 * Description: Selects the current node and all of its descendants.
 *
 * Example:
 *
 * xpath
 * Copy
 * Edit
 * //div[@id='main']/descendant-or-self::*
 * Selects everything inside and including <div id="main">.
 *
 ✅ following::
 Selects ALL nodes (of any level or type) that appear after the current node in the entire document.

 Not limited to the same parent.

 Example:

 xpath
 Copy
 Edit
 //label[text()='Email']/following::input[1]
 🔹 This selects the first <input> element after the <label> "Email", regardless of nesting or parent-child relationship.

 ✅ following-sibling::
 Selects only sibling elements that come after the current node — they must share the same parent.

 It won’t go deep or across different branches.

 Example:

 xpath
 Copy
 Edit
 //li[1]/following-sibling::li
 🔹 This selects all <li> elements that are siblings after the first <li> — i.e., with the same parent <ul> or <ol>.


 *
 *
 */
public class XpathAxesTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chava\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\chava\\Downloads\\JavaSelenium\\index.html");

        // parent:: - get the parent div of the email input

        WebElement parent = driver.findElement(By.xpath("//input[@id='email']/parent::*"));
        System.out.println("Parent tag of email input: " + parent.getTagName());


        // child:: - get the first child input under personalInfo
        WebElement child = driver.findElement(By.xpath("//div[@id='personalInfo']/child::label[1]"));
        System.out.println("First child under personalInfo: " + child.getText());

        // ancestor:: - find ancestor div of phone input
        WebElement ancestor = driver.findElement(By.xpath("//input[@id='phone']/ancestor::div[@id='contactSection']"));
        System.out.println("Ancestor div ID: " + ancestor.getAttribute("id"));


        // descendant:: - all inputs under preferences section
        int descendantCount = driver.findElements(By.xpath("//div[@id='preferences']/descendant::input")).size();
        System.out.println("Total inputs in Preferences section: " + descendantCount);



        // following-sibling:: - get Reset button after Submit
        WebElement followingSibling = driver.findElement(By.xpath("//button[@id='submitBtn']/following-sibling::button"));
        System.out.println("Following sibling of Submit: " + followingSibling.getText());




        // preceding-sibling:: - get Submit button before Reset
        WebElement precedingSibling = driver.findElement(By.xpath("//button[@id='resetBtn']/preceding-sibling::button"));
        System.out.println("Preceding sibling of Reset: " + precedingSibling.getText());

        // following:: - element after lastName input
        WebElement following = driver.findElement(By.xpath("//input[@id='lastName']/following::input[1]"));
        System.out.println("Following input of Last Name: " + following.getAttribute("id"));

        // preceding:: - element before phone input
        WebElement preceding = driver.findElement(By.xpath("//input[@id='phone']/preceding::input[@id='email']"));
        System.out.println("Preceding input of Phone: " + preceding.getAttribute("id"));
    }
}
