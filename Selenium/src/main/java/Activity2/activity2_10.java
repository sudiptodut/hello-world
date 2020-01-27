package Activity2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class activity2_10 {
	// Create a new instance of the Firefox driver
	static WebDriver driver = new FirefoxDriver();
	//Create Wait driver
	static WebDriverWait wait = new WebDriverWait(driver, 5);

	public static void main(String[] args) throws InterruptedException {
		//Open browser
		driver.get("https://www.demoqa.com/droppable/");

		//Print title of page and heading on page
		System.out.println("Page title is: " + driver.getTitle());

		List<WebElement> draggable = driver.findElements(By.id("draggable"));
		System.out.println("Size : "+draggable.size());
		System.out.println("Elements : "+draggable.toString());
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		System.out.println("Droppable text before drop: "+droppable.getText());

		//Initialize Actions Object
		Actions builder = new Actions(driver);

		//Use that object to setup actions sequence
		/*
		 * Action actionsToPerform = builder.moveToElement(driver.findElement(By.xpath(
		 * "//ol[@id='selectable']/li[1]"))) .clickAndHold()
		 * .moveToElement(driver.findElement(By.xpath("//ol[@id='selectable']/li[4]")))
		 * .release() .build();
		 */
		Action actionsToPerform = builder.moveToElement(draggable.get(0))
				.dragAndDrop(draggable.get(0), droppable)
				.build();
		actionsToPerform.perform();
		
		System.out.println("Droppable text after drop: "+droppable.getText());
		

		//Close the Browser
		//driver.close();
	}


}