package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class activity2_3 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		
		String pageTitle = driver.getTitle();
		System.out.println("Title of the page is " + pageTitle);
		if (pageTitle.contains("Selenium Easy - Checkbox demo for automation using selenium"))
			System.out.println("Expected title found");
		
		
		WebElement checkBox = driver.findElement(By.id("isAgeSelected"));
		checkBox.click();
		boolean cbEnabled = checkBox.isSelected();
		System.out.println("Check Box selected : "+cbEnabled);
		
		driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		
		WebElement radioButton = driver.findElement(By.xpath("//input[@name='optradio'][@value='Male']"));
		radioButton.click();
		boolean rbEnabled = radioButton.isSelected();
		System.out.println("Male Radio button is selected : "+rbEnabled);
		
		
		driver.close();

	}

}
