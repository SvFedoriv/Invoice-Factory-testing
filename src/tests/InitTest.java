package tests;

import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class InitTest {
	static WebDriver driver;
  
  @BeforeSuite
  public void SetUp() {
	  driver = new ChromeDriver();
	  driver.get(Util.URL);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
//  @AfterTest
//	public void cleanUp(){
//		driver.manage().deleteAllCookies();
//	}
  
  @AfterSuite
  public void tearDown() {
	  driver.close();
  }

}
