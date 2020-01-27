package Activity2;

import java.util.ArrayList;
import java.util.List;

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

public class activity2_9 {
	// Create a new instance of the Firefox driver
	static WebDriver driver = new FirefoxDriver();
	// Create Wait driver
	static WebDriverWait wait = new WebDriverWait(driver, 5);

	public static void main(String[] args) throws InterruptedException {
		
		//Open browser
		driver.get("https://fuscdrmsmc212-fa-ext.us.oracle.com/crmUI/faces/FuseOverview");
		WebElement we = driver.findElement(By.xpath("//div[contains(@id,'sub1:expression::cc')]"));
		System.out.println("Element found : "+we.isEnabled()+" : "+we.isDisplayed());
		ArrayList<WebElement> rows = (ArrayList<WebElement>) we.findElements(By.tagName("textarea"));
        rows.get(1).sendKeys("test");
		//we.sendKeys("test");
		/*//Print title of page and heading on page
		System.out.println("Page title is: " + driver.getTitle());

		List<WebElement> selectables = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		System.out.println("Count of selectables : "+selectables.size());
		

		//Initialize Actions Object
		Actions builder = new Actions(driver);

		//Use that object to setup actions sequence
		
		 * Action actionsToPerform = builder.moveToElement(driver.findElement(By.xpath(
		 * "//ol[@id='selectable']/li[1]"))) .clickAndHold()
		 * .moveToElement(driver.findElement(By.xpath("//ol[@id='selectable']/li[4]")))
		 * .release() .build();
		 
		Action actionsToPerform = builder.moveToElement(driver.findElement(By.xpath("//ol[@id='selectable']/li[1]")))
				.keyDown(Keys.CONTROL)
				.click()
				.moveToElement(driver.findElement(By.xpath("//ol[@id='selectable']/li[4]")))
				.click()
				.keyUp(Keys.CONTROL)
				.build();
		actionsToPerform.perform();

		for (int i=1;i<=selectables.size();i++) {
			if (driver.findElement(By.xpath("//ol[@id='selectable']/li["+i+"]")).getAttribute("class").contains("selected")) {
				System.out.println("Item : "+i+" : is selected, has text : "+driver.findElement(By.xpath("//ol[@id='selectable']/li["+i+"]")).getText());
			}
			
		}
		

		//Close the Browser
		//driver.close();*/
	}


}