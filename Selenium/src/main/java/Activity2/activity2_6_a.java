package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.List;


public class activity2_6_a {
	

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		System.out.println("Page title : "+driver.getTitle());
		
		WebElement startButton = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
		long test1 = System.currentTimeMillis();
		startButton.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish")));
		long test2 = System.currentTimeMillis();
		
		System.out.println("Time Taken : "+(test2-test1)+" seconds");
		
		WebElement finishText = driver.findElement(By.id("finish"));
		System.out.println("Text appears : "+finishText.getText());
		
		
		driver.close();

	}

}
