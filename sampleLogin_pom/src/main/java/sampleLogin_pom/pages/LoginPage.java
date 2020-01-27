package sampleLogin_pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Page Variables
	String URL = "https://the-internet.herokuapp.com/login";
	
	//Web Elements
	public By UserNameField = By.cssSelector("input#username");
	public By PasswordField = By.cssSelector("input#password");
	public By LoginButton = By.xpath("//button[@type='submit']");
	
	//Page Methods
	public LoginPage goToPage() {
		driver.get(this.URL);
		return this;
	}
	
	public LoginPage setTextValue(By element,String text) {
		writeText(element, text);
		return this;
	}
	
	public void clickLogin() {
		click(LoginButton);
	}
	

}
