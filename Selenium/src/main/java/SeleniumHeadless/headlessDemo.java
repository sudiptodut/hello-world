package SeleniumHeadless;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class headlessDemo {
	public static void main(String [] args) {
		//Setup instances for Firefox driver and options
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		//Set the option to run in headless mode
		firefoxOptions.setHeadless(true);
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Open browser
		driver.get("http://www.google.com");

		//Perform operations
		//Enter search query
		WebElement queryBox = driver.findElement(By.name("q"));
		queryBox.sendKeys("Cheese", Keys.RETURN);
		//Wait till title is as expected
		wait.until(ExpectedConditions.titleContains("Cheese"));
		//Print out title
		String pageTitle = driver.getTitle();
		System.out.println("Title of the page is " + pageTitle);

		//Close browser
		driver.quit();
		
	}
}