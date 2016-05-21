package Demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakeSnap {
	
	WebDriver driver ;
	
	@BeforeTest
	public void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
	}
	
	@Test(priority=1)
	public void failTest() throws IOException{
		try {
		driver.findElement(By.id("Superman")).sendKeys("India");
		}
		
		catch (Exception e){
			System.out.println("Control now is in Catch Block");
			getScreenshot();
		}
		
				
		
	}
	
	@Test(priority=0)
	public void testSomethingElse(){
		//some code 
	}
	public void getScreenshot() throws IOException{
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("C:\\Selenium8\\SeleniumGrab.jpg"));
	}
	
	

}
