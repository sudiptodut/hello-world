package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
	WebDriver driver = new FirefoxDriver();

	@Test
	public void test1( ) {
		System.out.println("Page Title : "+driver.getTitle());
		String Atitle = driver.getTitle();
		assertEquals(Atitle, "Google");
		//System.out.println("Page Title found : "+assertEquals(driver.getTitle(), "Google"));
		
		WebElement hindiLink = driver.findElement(By.xpath("//a[.='हिन्दी']"));
		hindiLink.click();
		System.out.println("New Page Title : "+driver.getTitle());
	}
	

	@BeforeTest
	public void beforeTest() {
		driver.get("https://www.google.com");
	}

	@AfterTest
	public void afterTest() {
		//driver.close();
	}

}
