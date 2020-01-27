package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
	WebDriver driver = new FirefoxDriver();

	/*
	 * @Test public void aSkipTest() throws SkipException { String condition
	 * ="Skip Test";
	 * 
	 * if(condition.equals("Skip Test")){ throw new
	 * SkipException("Skipping - This is not ready for testing "); } else {
	 * //Execute test case when conditions are satisfied } }
	 */
	@Test
	public void test1( ) {
		System.out.println("Page Title : "+driver.getTitle());
	}
	@Test 
	public void test2( )  {
		WebElement searchBox = driver.findElement(By.tagName("a"));
	}
	@Test (enabled=false)
	public void test3( ) {
		System.out.println("Not supposed to run");

	}
	@Test
	public void test4_skiptest() throws SkipException {
		String condition ="Skip Test";
		if(condition.equals("Skip Test")) {
			throw new SkipException("Skipping - This is not ready for testing "); 
		}

	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://www.google.com");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
