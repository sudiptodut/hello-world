package Activity2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import java.util.List;


public class activity2_4_b {


	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://the-internet.herokuapp.com/tables");
		
		List<WebElement> colList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println("Column Count : "+colList.size());
		
		List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Row Count : "+rowList.size());
		
		//List<WebElement> thirdRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));
		//System.out.println("Total element in 3rd Row : "+thirdRow.size());
		for (int i=1;i<=rowList.size();i++) {
			System.out.println("Row content : "+i+" : "+driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]")).getText());
		}
		
		for (int i=1;i<=colList.size();i++) {
			WebElement cellContent = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th["+i+"]"));
			System.out.println("Content of Header row : "+i+" column :"+cellContent.getText());
			if (cellContent.getText().equals("First Name")) {
				System.out.println("Sorting with First Name Ascending");
				cellContent.click();
			}
		}
		
		for (int i=1;i<=rowList.size();i++) {
			System.out.println("Row content : "+i+" : "+driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]")).getText());
		}
		//driver.close();

	}

}
