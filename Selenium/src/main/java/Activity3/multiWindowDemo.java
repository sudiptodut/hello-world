package Activity3;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.code.Type.CapturedType;

public class multiWindowDemo {

	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		//Open browser
		driver.get("https://robots.liberari.com/windows/");

		//Print title of page and heading on page
		System.out.println("Page title is: " + driver.getTitle());

		//Get parent window handle
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentWindow);

		//Find link to open new tab and click it
		driver.findElement(By.linkText("Click Me!")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		driver.findElement(By.xpath("//a[@id='launcher']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));

		//Get Window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles);

		/*
		 * Iterator<String> test = allWindowHandles.iterator(); while
		 * (test.hasNext()==true) { Thread.sleep(3000);
		 * System.out.println("New Tab Title is: " + driver.getTitle()); test.next(); }
		 */
		Iterator<String> iter = allWindowHandles.iterator();
		while (iter.hasNext()==true) {
			String secndWindow = iter.next();
			driver.switchTo().window(secndWindow);
			Thread.sleep(3000);
			System.out.println("New Tab Title is: " +driver.getTitle());
			System.out.println("New Tab heading is: " +driver.findElement(By.tagName("h1")).getText());
		}
		
		driver.close();
		
		
		
		Set<String> captureWindowHandles = driver.getWindowHandles();
		Iterator<String> iterate = captureWindowHandles.iterator();
		String tab1 = iterate.next();
		boolean tab2 = iter.hasNext();


		/*
		 * //Loop through each handle for (String handle : driver.getWindowHandles()) {
		 * driver.switchTo().window(handle); }
		 * 
		 * //Print the handle of the current window
		 * System.out.println(driver.getWindowHandle());
		 * 
		 * //Wait for page to load completely
		 * wait.until(ExpectedConditions.titleIs("New Tab!"));
		 * 
		 * //Print New Tab Title System.out.println("New Tab Title is: "
		 * +driver.getTitle());
		 * 
		 * //Get heading on new page String newTabText =
		 * driver.findElement(By.tagName("h1")).getText();
		 * System.out.println("New tab heading is: " + newTabText);
		 * 
		 * 
		 * //Close the browser driver.quit();
		 */
	}
}