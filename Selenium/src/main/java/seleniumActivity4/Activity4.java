package seleniumActivity4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		//Open a browser with https://the-internet.herokuapp.com/login
		driver.get("https://the-internet.herokuapp.com/login");

		//Get the title of the page using driver.getTitle() and print out the title.
		String browserTitle = driver.getTitle();
		System.out.println("Page Title : "+browserTitle);
		
		//Also use findElement() with tagName() to find and print the text in the h2 tag
		WebElement h2element = driver.findElement(By.tagName("h2"));
		String h2text = h2element.getText();
		System.out.println("H2 Text : "+h2text);
		
		//Use findElement() with id() to find the text fields - username and password
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		
		//Use WebElement.sendKeys() to type in those text fields.
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		//password.submit();
		
		//Also find the Login button on the page and click() it.
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();
		
		
		//After logging in, use findElement() with tagName() to get the text of the h2 tag on the page and print it.
		WebElement h2element2 = driver.findElement(By.tagName("h2"));
		String h2text2 = h2element2.getText();
		System.out.println("H2(2) Text : "+h2text2);
		
		//Next, click() the logout button
		WebElement logoutButton = driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']"));
		logoutButton.click();
		
		//Finally, close() the browser.
		driver.close();

	}

}
