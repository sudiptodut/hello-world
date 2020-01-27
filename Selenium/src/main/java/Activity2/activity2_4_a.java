package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class activity2_4_a {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://the-internet.herokuapp.com/tables");
		
		List<WebElement> colList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println("Column Count : "+colList.size());
		
		List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Row Count : "+rowList.size());
		
		List<WebElement> thirdRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));
		System.out.println("Total element in 3rd Row : "+thirdRow.size());
		
		
		for (int i=1;i<=thirdRow.size();i++) {
			//WebElement test = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td["+i+"]"));
			System.out.println("Content of 3rd row : "+i+" column :"+driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td["+i+"]")).getText());
		}
		
		
		driver.close();

	}

}
