package Activity2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class activity2_7 {
	// Create a new instance of the Firefox driver
	static WebDriver driver = new FirefoxDriver();
	//Create Wait driver
	static WebDriverWait wait = new WebDriverWait(driver, 5);

	public static void main(String[] args) throws InterruptedException {
		//Open browser
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");

		//Print title of page and heading on page
		System.out.println("Page title is: " + driver.getTitle());

		//WebElement dblClickBtn = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		WebElement dblClickBtn = driver.findElement(By.xpath("//button[text()=\"Double-Click Me To See Alert\"]"));
		WebElement rightClickMe = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

		//Initialize Actions Object
		Actions builder = new Actions(driver);

		//Use that object to setup actions sequence
		Action actionsToPerform = builder.doubleClick(dblClickBtn).build();
		actionsToPerform.perform();

		wait.until(ExpectedConditions.alertIsPresent());

		//Switch the focus to alert pop up
		Alert alert = driver.switchTo().alert();

		String alertText;
		getAlert(alert);

		/*
		 * actionsToPerform = builder.contextClick(rightClickMe).build();
		 * actionsToPerform.perform();
		 * 
		 * WebElement delLabel =
		 * driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
		 * delLabel.click();
		 */

		Action performContextClick = builder.contextClick(rightClickMe)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.pause(500)
				.sendKeys(Keys.RETURN)
				.build();
		performContextClick.perform();


		getAlert(alert);

		//Close the Browser
		driver.close();
	}

	public static void getAlert(Alert alert) throws InterruptedException {
		//Get text in the alert box and print it
		/*
		 * String alertText = alert.getText(); Thread.sleep(2000);
		 * 
		 * System.out.println("Alert Popup : "+alertText);
		 * 
		 * alert.accept();
		 */

		//Switch to alert window
		Alert contextClickAlert = driver.switchTo().alert();
		//Get text in the alert box and print it
		String alertText = contextClickAlert.getText();
		System.out.println("Alert text is: " + alertText);
		//Close the popup
		Thread.sleep(3000);
		contextClickAlert.accept();

	}


}