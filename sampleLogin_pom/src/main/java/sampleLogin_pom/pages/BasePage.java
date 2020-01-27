package sampleLogin_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;

	//Constructor
	public BasePage (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	//Wait Wrapper Method
	public void waitForVisibility(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}

	//Click Method
	public void click (By element) {
		waitForVisibility(element);
		driver.findElement(element).click();
	}

	//Write Text
	public void writeText(By element, String text) {
		waitForVisibility(element);
		driver.findElement(element).sendKeys(text);
	}

}
