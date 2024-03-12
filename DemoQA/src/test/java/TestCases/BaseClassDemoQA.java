package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.qameta.allure.Step;


public class BaseClassDemoQA {
	public static WebDriver driver;
	String Url = "https://demoqa.com/";
	// JavascriptExecutor js= (JavascriptExecutor)driver;
	public static Logger log = LogManager.getLogger(BaseClassDemoQA.class.getName());

	public void getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		try {
			log.info("Taking screenshot of faild test");
		File ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//TakesScreenshot ts = (TakesScreenshot)driver;
		//File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\src\\test\\java\\TestReports\\"+testCaseName+".png";
		FileUtils.copyFile(ts, new File(dest));
		}
		catch(IOException e) {
			log.error("Causing exception in taking screenshot");
			System.out.println(e.getMessage());
		}
	}
	 @Step("Before suite - Basic setup")
	 @BeforeSuite(description="calling url")
	  public void setUp() throws Exception {
		 log.info("Setting propertyies");
		  System.setProperty("webdriver.chrome.driver", "../DemoQA/src/test/java/Resources/chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  log.info("Navigating to App url");
		  driver.get(Url);
		  Thread.sleep(100);
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
		  
	  }
	  @Step("After suite - Teardown")
	  @AfterSuite(description="quiting browser")
	  public void tearDown() throws Exception {
		  Thread.sleep(5000);
		  log.info("In tearDown");
		  driver.quit();
	  }
	  
}
