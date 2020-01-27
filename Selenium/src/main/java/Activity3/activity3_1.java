package Activity3;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.Alert;


public class activity3_1 {
	// Create a new instance of the Firefox driver
	static WebDriver driver = new FirefoxDriver();
	//Create Wait driver
	static WebDriverWait wait = new WebDriverWait(driver, 5);

	public static void main(String[] args) throws InterruptedException {
		//Open browser
		driver.get("https://robots.liberari.com/jsalerts/");

		//Print title of page and heading on page
		System.out.println("Page title is: " + driver.getTitle());

		WebElement confirmButton = driver.findElement(By.cssSelector("button#confirm"));
		confirmButton.click();
		
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		
		WebElement promptButton = driver.findElement(By.cssSelector("button#prompt"));
		promptButton.click();
		driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(1000);
		driver.switchTo().alert().sendKeys("Awesome!");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		

		//Close the Browser
		driver.close();
	}


}