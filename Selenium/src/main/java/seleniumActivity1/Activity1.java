package seleniumActivity1;


import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		System.out.println("getTitle : "+driver.getTitle());
		System.out.println("getCurrentUrl : "+driver.getCurrentUrl());
		System.out.println("SysProperties : "+System.getProperties());
		System.out.println("Java Version : "+System.getProperty("java.version"));
		
		driver.close();

	}

}
