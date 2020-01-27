package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class activity2_2 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		
		String pageTitle = driver.getTitle();
		System.out.println("Title of the page is " + pageTitle);
		if (pageTitle.contains("Google"))
			System.out.println("Expected title found");
		
		
		WebElement queryBox = driver.findElement(By.name("q"));
		boolean qbEnabled = queryBox.isDisplayed();
		System.out.println("Query Box displayed : "+qbEnabled);
		
		queryBox.sendKeys("Cheese");
		
		WebElement searchButton = driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']"));
		boolean sbEnabled = searchButton.isDisplayed();
		System.out.println("Google search button displayed : "+sbEnabled);
		
		searchButton.click();
		
		driver.close();

	}

}
