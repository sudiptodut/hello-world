package Activity3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity3_5 {
	public static void main(String[] args) {
		//Create WebDriver instance
		WebDriver driver = new FirefoxDriver();
		//Open browser
		driver.get("https://robots.liberari.com/iframeception/");

		//Print title of the page
		System.out.println("Title of the page is: " + driver.getTitle());

		//Switch to first iFrame on the page
		driver.switchTo().frame(0);
		//Perform operation on the first frame
		WebElement frameHeading1 = driver.findElement(By.tagName("h1"));
		System.out.println("1st Frame Heading : "+frameHeading1.getText());
		

		//Switch to first nested iFrame on the page
		driver.switchTo().frame(0);
		frameHeading1 = driver.findElement(By.tagName("h1"));
		System.out.println("2nd Frame Heading : "+frameHeading1.getText());

		//Switch to second nested iFrame on the page
		driver.switchTo().frame(0);
		frameHeading1 = driver.findElement(By.tagName("h1"));
		System.out.println("3rd Frame Heading : "+frameHeading1.getText());
		System.out.println("Button text in 3rd frame"+driver.findElement(By.cssSelector("button")).getText());

		driver.switchTo().defaultContent();
		
		//Close browser
		driver.close();
	}
}