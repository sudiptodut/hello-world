package seleniumActivity3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.inject.Key;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException {
	// Create a new instance of the Firefox driver
	WebDriver driver = new FirefoxDriver();
		
	//Open the page with the form
	driver.get("https://www.toolsqa.com/automation-practice-form/");
		
	//Get the title of the page
	System.out.println("Page title is: " + driver.getTitle());
		
	//Find firstname input box and type string in it
	WebElement firstName = driver.findElement(By.name("firstname"));
	firstName.sendKeys(Keys.SHIFT,"Sashi");

	//Find lastname input box and type string in it
	WebElement lastName = driver.findElement(By.id("lastname"));
	lastName.sendKeys("Mithra");
		
	//Stop the execution for 3 seconds to see the text entered.
	//This is not recommended during actual testing
	Thread.sleep(3000);
	//Close the browser
	driver.close();
	}
}