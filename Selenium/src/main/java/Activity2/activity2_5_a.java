package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.util.List;


public class activity2_5_a {
	

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://testingpool.com/wp-content/uploads/2015/08/DemoApplication.html");
		
		WebElement numberDropDown = driver.findElement(By.name("number"));
		Select numberSelect = new Select(numberDropDown);
		
		numberSelect.selectByVisibleText("2");
		System.out.println("Current selected option : "+numberSelect.getFirstSelectedOption().getText());
		
		numberSelect.selectByIndex(3);
		System.out.println("Current selected option : "+numberSelect.getFirstSelectedOption().getText());
		
		numberSelect.selectByValue("four");
		System.out.println("Current selected option : "+numberSelect.getFirstSelectedOption().getText());
		
		
		List<WebElement> allValues = numberSelect.getOptions();
		System.out.println("item Count : "+allValues.size());
		
		for (int i=0;i<allValues.size();i++) {
			System.out.println("Value # "+i+" : "+allValues.get(i).getText());
		}
		
		
		
		//driver.close();

	}

}
