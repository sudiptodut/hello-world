package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class activity2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		
		String pageTitle = driver.getTitle();
		System.out.println("Title of the page is " + pageTitle);
		if (pageTitle.contains("Google"))
			System.out.println("Expected title found");
		
		
		WebElement queryBox = driver.findElement(By.name("q"));
		boolean qbEnabled = queryBox.isEnabled();
		System.out.println("Query Box Enabled : "+qbEnabled+" : "+queryBox.getText());
		
		queryBox.sendKeys("Cheese");
		Thread.sleep(3000);
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@class='gNO89b']"));
		boolean sbEnabled = searchButton.isEnabled();
		System.out.println("Google search button Enabled : "+sbEnabled+" : "+searchButton.getText());
		
		searchButton.click();
		
		driver.close();

	}

}
