package Activity3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity3_4 {
    public static void main(String[] args) {
        //Create WebDriver instance
        WebDriver driver = new FirefoxDriver();
        //Open browser
        driver.get("https://robots.liberari.com/iframes/");
        
        //Print title of the page
        System.out.println("Title of the page is: " + driver.getTitle());
        
        //Switch to first iFrame on the page
        driver.switchTo().frame(0);
        //Perform operation on the first frame
        WebElement frameHeading1 = driver.findElement(By.tagName("h1"));
        System.out.println(frameHeading1.getText());
        //Click button in iFrame 1
        driver.findElement(By.cssSelector("button")).click();
        
        //Switch back to parent page
        driver.switchTo().defaultContent();
        
        //Switch to second iFrame on the page
        driver.switchTo().frame(1);
        //Perform operation on the first frame
        WebElement frameHeading2 = driver.findElement(By.tagName("h1"));
        System.out.println(frameHeading2.getText());
        //Click button in iFrame 2
        WebElement frame1Button = driver.findElement(By.xpath("//button[@id=\"actionButton\"]"));
        System.out.println("color of button in frame1:"+driver.findElement(By.cssSelector("button")).getCssValue("background-color"));
        
        //Switch back to parent page
        driver.switchTo().defaultContent();
        //Close browser
        driver.close();
    }
}