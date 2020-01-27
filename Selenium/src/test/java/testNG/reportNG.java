package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Reporter;
import org.testng.SkipException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class reportNG{
    WebDriver driver;
	
    @Test
    public void testCase1() {
		//This test case will pass
		String title = driver.getTitle();
		Reporter.log("Title is: " + title);
    }
	
    @Test
    public void testCase2() {
		//This test case will Fail
		driver.findElement(By.tagName("a"));
		Reporter.log("Element Found");
    }
	
    @Test(enabled = false)
    public void testCase3() {
		//This test will be skipped
    	Reporter.log("This page title will not be printed: " + driver.getTitle());
    }
	
    @Test
    public void testCase4() {
    	//This test will be skipped and will be be shown as skipped
    	Reporter.log("Test skipped with Exception");
    	throw new SkipException("Skipping test case");
    }

    @BeforeTest
    public void beforeMethod() {
		//Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
			
		//Open the browser
		driver.get("https://www.google.com");
		Reporter.log("Test Started");
    }

    @AfterTest
    public void afterMethod() {
    	//Close the browser
    	driver.close();
    	Reporter.log("Test Completed");
    }
}