package Activity3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class activity3_3 {

    public static void main(String[] args) {
    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();
        
    //Open browser
    driver.get("https://robots.liberari.com/windows/");
        
    //Print title of page and heading on page
    System.out.println("Page title is: " + driver.getTitle());
        
    //Get parent window handle
    String parentWindow = driver.getWindowHandle();
    System.out.println("Parent Window: " + parentWindow);
        
    //Find link to open new tab and click it
    driver.findElement(By.linkText("Click Me!")).click();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    
    //Get Window handles
    Set<String> allWindowHandles = driver.getWindowHandles();
    System.out.println("All Window Handles : "+allWindowHandles);
    
    //Loop through each handle
    for (String handle : driver.getWindowHandles()) {
        driver.switchTo().window(handle);
    }
    
    //Print the handle of the current window
    System.out.println("Second Window Handle : "+driver.getWindowHandle());
    
    //Wait for page to load completely
    wait.until(ExpectedConditions.titleIs("New Tab!"));
    
    //Print New Tab Title
    System.out.println("New Tab Title is: " + driver.getTitle());
        
    //Get heading on new page
    String newTabText = driver.findElement(By.tagName("h1")).getText();
    System.out.println("New tab heading is: " + newTabText);
    
    
    driver.findElement(By.linkText("Open Another One!")).click();
    wait.until(ExpectedConditions.numberOfWindowsToBe(3));
    
    //Get Window handles
    allWindowHandles = driver.getWindowHandles();
    System.out.println("All Window Handles : "+allWindowHandles);
    
    //Loop through each handle
    for (String handle : driver.getWindowHandles()) {
        driver.switchTo().window(handle);
    }
    
    //Print the handle of the current window
    System.out.println("Third Window Handle : "+driver.getWindowHandle());
    
    //Wait for page to load completely
    wait.until(ExpectedConditions.titleIs("Another New Tab!"));
    
    //Print New Tab Title
    System.out.println("New Tab Title is: " + driver.getTitle());
        
    //Get heading on new page
    newTabText = driver.findElement(By.tagName("h1")).getText();
    System.out.println("New tab heading is: " + newTabText);
        
    //Close the browser
    driver.quit();
    }
}