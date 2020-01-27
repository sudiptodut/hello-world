package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class activity2_6_b {
    // Create a new instance of the Firefox driver
    static WebDriver driver = new FirefoxDriver();
    //Create Wait driver
    static WebDriverWait wait = new WebDriverWait(driver, 15);

    public static void main(String[] args) {
        //Open browser
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
                
        //Print title of page and heading on page
        System.out.println("Page title is: " + driver.getTitle());

        checkboxTestMethod();
        textboxTestMethod();
        
        //Close the Browser
        driver.close();
    }

    public static void checkboxTestMethod() {
        //Find the checkbox
        WebElement checkbox = driver.findElement(By.cssSelector("#checkbox"));
        //Get the text for the checkbox
        String checkboxText = checkbox.getText();
        //Get button to toggle checkbox
        WebElement checkboxButton = driver.findElement(By.cssSelector("button"));

        //Click the checkbox
        checkbox.findElement(By.cssSelector("input")).click();
        //Click the button to remove the checkbox
        checkboxButton.click();
        //Wait till the message element is visible
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        //Get the text in the message element
        String message = driver.findElement(By.id("message")).getText();
        System.out.println(message);

        //Click the button to add new checkbox
        checkboxButton.click();
        //Wait till the checkbox element is visible
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        //Get the text in the message element
        message = driver.findElement(By.id("message")).getText();
        System.out.println(message);
        //Click the checkbox
        driver.findElement(By.cssSelector("#checkbox")).click();
    }

    public static void textboxTestMethod() {
        //Setup
        WebElement textField = driver.findElement(By.cssSelector("#input-example > input"));
        WebElement textFieldButton = driver.findElement(By.cssSelector("#input-example > button"));

        //Click button to enable text field
        textFieldButton.click();
        //Wait till the field is enabled
        wait.until(ExpectedConditions.elementToBeClickable(textField));
        //Get message
        String message = driver.findElement(By.id("message")).getText();

        System.out.println(message);
        
        //Enter text in the text field
        textField.sendKeys("This text field has been enabled");
        //Disable text field
        textFieldButton.click();
        //Wait till the message is displayed
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's disabled!"));

        //Get message
        message = driver.findElement(By.id("message")).getText();
        System.out.println(message);
    }
}