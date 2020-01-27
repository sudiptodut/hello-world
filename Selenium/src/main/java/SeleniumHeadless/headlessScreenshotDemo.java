package SeleniumHeadless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class headlessScreenshotDemo {
    public static void main(String [] args) {
	//Setup instances for Firefox driver and options
	FirefoxOptions firefoxOptions = new FirefoxOptions();
	//Set the option to run in headless mode
	firefoxOptions.setHeadless(true);
	WebDriver driver = new FirefoxDriver(firefoxOptions);
	WebDriverWait wait = new WebDriverWait(driver, 10);
	String fileName = System.currentTimeMillis() + "Test";

	//Open browser
	driver.get("http://www.google.com");

	//Perform operations
	//Enter search query
	WebElement queryBox = driver.findElement(By.name("q"));
	queryBox.sendKeys("Cheese", Keys.RETURN);
	//Wait till title is as expected
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("resultStats")));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ellip")));
	//Print out title
	String pageTitle = driver.getTitle();
	System.out.println("Title of the page is " + pageTitle);

	File screenshot = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
	File outputFile = new File("LoggerScreenshots/" + fileName + ".png");
	System.out.println(outputFile.getAbsolutePath());
	try {
	    FileUtils.copyFile(screenshot, outputFile);
	} catch (IOException e) {
	    e.printStackTrace();
	}

        //Close browser
        driver.quit();
    }
}