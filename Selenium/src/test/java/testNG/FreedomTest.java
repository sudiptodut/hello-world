package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FreedomTest {
	WebDriver driver = new FirefoxDriver();

	@Test
	public void test1( ) throws InterruptedException {
		
		/*
		 * WebElement table =
		 * driver.findElement(By.xpath("//div[contains(@id,'pt1:ATT1:_ATTp:ATTt1::db')]"
		 * )); table.sendKeys(Keys.PAGE_UP);
		 */
		driver.findElement(By.xpath("//input[contains(@id,'selectOneChoice5::content')]")).isDisplayed();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		System.out.println("Scroll 100_1");
		String id = "pt1:_FOr1:0:_FOSritemNode_tools_application_composer:0:_FOTsr1:0:ft1:AP2:r2:0:pt1:ATT1:_ATTp:ATTt1::db";
					//pt1:_FOr1:1:_FOSritemNode_tools_application_composer:0:_FOTsr1:0:ft1:AP2:r2:0:pt1:ATT1:_ATTp:ATTt1::db
		jse.executeScript("document.getElementById("+id+").scrollBy(0,100)", "");
		Thread.sleep(2000);
		System.out.println("Scroll 100_2");
		jse.executeScript("document.getElementById("+id+").scrollBy(0,100)", "");
		Thread.sleep(2000);
		System.out.println("Scroll 100_3");
		jse.executeScript("document.getElementById("+id+").scrollBy(0,100)", "");
		Thread.sleep(2000);
		   
	}
	

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driver.get("https://fuscdrmsmc211-fa-ext.us.oracle.com/crmUI/faces/FuseWelcome");
		Thread.sleep(90000);
	}

	@AfterTest
	public void afterTest() {
		//driver.close();
	}

}
