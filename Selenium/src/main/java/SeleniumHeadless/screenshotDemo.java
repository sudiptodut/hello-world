package SeleniumHeadless;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Verify;
import com.google.common.base.VerifyException;

//import SUDIPTO.selfTest.testInt01;

public class screenshotDemo {
	static VerifyException verifyException = new VerifyException("Message");

	public static void main(String[] args) {
	    takeSnap();
	}

	public static void takeSnap() {
		//WebDriver driver = new FirefoxDriver();
		
		try{
			System.out.println("Begin validation");
			Verify.verify(false, "ValidationFailed", "p1");
			System.out.println("End validation");
		}catch(Throwable t) {
			System.out.println(verifyException.getMessage()+" :: "+t);
		}
		System.out.println("After validation");
		/*
		 * String fileName = System.currentTimeMillis() + "Test";
		 * driver.get("https://www.google.com");
		 * 
		 * File screenshot = ((RemoteWebDriver)
		 * driver).getScreenshotAs(OutputType.FILE); File outputFile = new
		 * File("LoggerScreenshots/" + fileName + ".png");
		 * System.out.println(outputFile.getAbsolutePath()); try {
		 * FileUtils.copyFile(screenshot, outputFile); } catch (IOException e) {
		 * e.printStackTrace(); }
		 * 
		 * driver.close();
		 */
	}

}

interface testInt02 {

	String scanInput(InputStream inputSource);

	void printOutput(String output);

	default void sample() {
		System.out.println("Sample Method in Abstract Class");
	}
}