package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.util.List;


public class activity2_5_b {
	

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://testingpool.com/wp-content/uploads/2015/08/DemoApplication.html");
		
		WebElement numberDropDown = driver.findElement(By.name("Week"));
		Select numberSelect = new Select(numberDropDown);
		
		List<WebElement> allSelectedValues = numberSelect.getAllSelectedOptions();
		for (int i=0;i<allSelectedValues.size();i++) {
			System.out.println("Value # "+i+" : "+allSelectedValues.get(i).getText());
		}
		
		System.out.println("Is multi select? : "+numberSelect.isMultiple());
		
		numberSelect.selectByVisibleText("Monday");
		
		allSelectedValues = numberSelect.getAllSelectedOptions();
		for (int i=0;i<allSelectedValues.size();i++) {
			System.out.println("Value # "+i+" : "+allSelectedValues.get(i).getText());
		}
		
		numberSelect.selectByIndex(1);
		allSelectedValues = numberSelect.getAllSelectedOptions();
		for (int i=0;i<allSelectedValues.size();i++) {
			System.out.println("Value # "+i+" : "+allSelectedValues.get(i).getText());
		}
		
		numberSelect.deselectByValue("Wed");
		allSelectedValues = numberSelect.getAllSelectedOptions();
		for (int i=0;i<allSelectedValues.size();i++) {
			System.out.println("Value # "+i+" : "+allSelectedValues.get(i).getText());
		}
		
		
		
		driver.close();

	}

}
