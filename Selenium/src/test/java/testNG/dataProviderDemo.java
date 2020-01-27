package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class dataProviderDemo {
	WebDriver driver;
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
	    return new Object[][] { { "tomsmith", "SuperSecretPassword!" }, { "tomsmith11", "SuperSecretPassword!" }};
	}


	@Test(dataProvider = "Authentication")
	public void logintoApp(String userName, String password) {
		Reporter.log("Test case started | ");
		driver.findElement(By.cssSelector("input#username")).sendKeys(userName);
		Reporter.log("Entered username as "+userName);
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
		Reporter.log("Entered password as "+password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.log("Clicked Login button");
		Reporter.log("Test case ended");

	}
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/login");

		//Print title of Login Page
		Reporter.log("Saved Login Page heading as " + driver.getTitle());

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		Reporter.log("Browser closed");
	}

}
