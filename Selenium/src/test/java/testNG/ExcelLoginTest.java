package testNG;

import java.io.IOException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
 
public class ExcelLoginTest {
	
    WebDriver driver;
    WebDriverWait wait;
    //Logger Log;
    String filePath = System.getProperty("user.dir") + "/Resource/ReadExcel.xlsx";
	 
    @DataProvider
    public String[][] getExcelData() throws IOException {
	ReadExcel read = new ReadExcel();
	//Log.info("Reading values from Excel Sheet");
	return read.getCellData(filePath, "Sheet1");
    }
	 
    @BeforeTest
    public void beforeTest() {
	//Log = LogManager.getLogger(ExcelLoginTest.class);
	Reporter.log("Stating Test");
	driver = new FirefoxDriver();
	driver.get("https://the-internet.herokuapp.com/login");
	Reporter.log("Browser Open");
        wait = new WebDriverWait(driver, 20);
    }
	 
    @Test(dataProvider = "getExcelData")
    public void testLogin(String Username, String Password) throws InterruptedException {
	//Log.info("Starting Test Case");
	driver.findElement(By.id("username")).sendKeys(Username);
	//Log.info("Entered Username");
	driver.findElement(By.id("password")).sendKeys(Password);
	//Log.info("Entered Password");
	driver.findElement(By.tagName("button")).click();
	//Log.info("Logging in");
		
	String invalidLogin = driver.findElement(By.id("flash")).getText();
		 
	if(invalidLogin.contains("invalid")) {
	    Reporter.log("Login Failed");
	} else {
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".example > h2")));
	    String heading = driver.findElement(By.cssSelector(".example > h2")).getText();
	    Assert.assertEquals(heading, "Secure Area");
	    Reporter.log("Login successful");
	}
    }
	
    @AfterMethod
    public void afterMethod() {
	Reporter.log("Ending Test Case");
	driver.navigate().back();
    }
	 
    @AfterTest
    public void afterTest() {
	//Log.info("Ending Test");
	driver.close();
	Reporter.log("Browser Closed");
    }
}