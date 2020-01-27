package sampleLogin_pom.tests;

import org.testng.annotations.BeforeClass;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		//Initialize WebDriver
		driver = new FirefoxDriver();
		
		//Maximize the Window
		driver.manage().window().maximize();

	}
	
	@AfterClass
	public void tesrDown() {
		driver.quit();
	}
}
