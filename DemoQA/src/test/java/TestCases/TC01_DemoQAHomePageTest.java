package TestCases;

import java.time.Duration;
import java.time.LocalTime;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ObjectRepository.DemoQAHomePageObj;
import io.qameta.allure.Step;

public class TC01_DemoQAHomePageTest extends BaseClassDemoQA {

	
	@Step("Elements Option Click Test")
	@Test(priority=1)
	public void Elements() throws Exception {
		
		ThreadContext.put("TestClass", this.getClass().getName());
		log.info("This log message will include the TC01 class name.");
		
		log.info("clicking on Elements option");
		System.out.println("calling the element click method");
		LocalTime currentTime = LocalTime.now();
		//String formattedTime = currentTime.format();

        // Print the formatted time to the console
        System.out.println("Current time: " + currentTime);
        DemoQAHomePageObj HomepageObj = new DemoQAHomePageObj(driver);
        Thread.sleep(5000);
        log.info("Time currently  " +currentTime);
		HomepageObj.clickElements();
		
	}
}
