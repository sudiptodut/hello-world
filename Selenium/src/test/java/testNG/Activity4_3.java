package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity4_3 {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 5);

	@Test
	public void testValidLogin( ) {
		uiLogin("tomsmith","SuperSecretPassword!","//i[@class='icon-2x icon-signout']");
	}
	
	@Test
	public void testInValidLogin( ) {
		uiLogin("tomsmith11","SuperSecretPassword!","//div[contains(text(),'invalid')]");	
	}

	public void uiLogin(String userId, String pwd, String xPath) {
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(userId);
		System.out.println("UserName Field : "+userName.getAttribute("value"));
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(pwd);
		System.out.println("Password Field : "+passWord.getAttribute("value"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath(xPath))));
		assertTrue(driver.findElement(By.xpath(xPath)).isDisplayed());
	}
	

	@BeforeMethod
	public void beforeTest() throws InterruptedException {
		//Thread.sleep(2000);
		driver.get("https://the-internet.herokuapp.com/login");
	}

	@AfterMethod
	public void afterTest() {
		//driver.close();
	}

}
