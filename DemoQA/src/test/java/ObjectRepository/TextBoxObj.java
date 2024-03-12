package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TextBoxObj {
	
	WebDriver driver;
	public TextBoxObj(WebDriver driver) {
		this.driver = driver;
	}
	
	private By TextBox = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
	private By Name = By.xpath("//input[@id='userName']");
	private By Email = By.xpath("//input[@id='userEmail']");
	private By CurrentAddress = By.xpath("//textarea[@id='currentAddress']");
	private By PermanentAddress = By.xpath("//textarea[@id='permanentAddress']");
	private By Submit = By.xpath("//button[@id='submit']");
	private By nameSubmit = By.xpath("//p[@id='name']");
	private By emailSubmit = By.xpath("//p[@id='email']");
	private By currentSubmit = By.xpath("//p[@id='currentAddress']");
	private By PermanentSubmit = By.xpath("//p[@id='permanentAddress']");
	private By responseBox = By.xpath("//div[@class='border col-md-12 col-sm-12']");
	
	private String name;
	private String email;
	private String CurrentAdd;
	private String PermanentAdd;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public void name(String nametext) {
		name = nametext;
		WebDriverWait wt1 = new WebDriverWait(driver,Duration.ofMillis(50));
		wt1.until(ExpectedConditions.elementToBeClickable(Name)).clear();
		//driver.findElement(Name).clear();
		driver.findElement(Name).sendKeys(nametext);
	}
	
	public void textBoxClick() {
		if(driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/elements")) {
		driver.findElement(TextBox).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		js.executeScript("window.scrollBy(0,400);");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	public void email(String emailtxt) {
		email=emailtxt;
		WebDriverWait wt2 = new WebDriverWait(driver,Duration.ofMillis(50));
		wt2.until(ExpectedConditions.elementToBeClickable(Email)).clear();
		driver.findElement(Email).sendKeys(emailtxt);
	}

	public void currentAdd(String CurrentAddtxt) {
		CurrentAdd = CurrentAddtxt;
		WebDriverWait wt3 = new WebDriverWait(driver,Duration.ofMillis(50));
		wt3.until(ExpectedConditions.elementToBeClickable(CurrentAddress)).clear();
		driver.findElement(CurrentAddress).sendKeys(CurrentAddtxt);
	}
	
	public void PermanentAdd(String PermanentAddtxt) {
		PermanentAdd = PermanentAddtxt;
		WebDriverWait wt4 = new WebDriverWait(driver,Duration.ofMillis(50));
		wt4.until(ExpectedConditions.elementToBeClickable(PermanentAddress)).clear();
		driver.findElement(PermanentAddress).sendKeys(PermanentAddtxt);
	}

	public void SubmitForm() {
		//WebDriverWait wt6 = new WebDriverWait(driver,Duration.ofMillis(50));
		//wt6.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0']")));
		//driver.switchTo().activeElement();
		//driver.findElement(By.xpath("//*[name()='iframe' and @id='google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0']")).click();
		//driver.switchTo().frame(0);
		
		//js.executeScript("document.getElementByxpath(\"//button[@id='submit']\").scrollIntoView();");
		
		WebDriverWait wt5 = new WebDriverWait(driver,Duration.ofMillis(50));
		wt5.until(ExpectedConditions.elementToBeClickable(Submit)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ValidateResponse();
	}

	public void ValidateResponse() {
		WebDriverWait wt6 = new WebDriverWait(driver,Duration.ofMillis(60));
		wt6.until(ExpectedConditions.visibilityOfElementLocated(responseBox));
		
		String name1 = driver.findElement(nameSubmit).getText();
		String Email1 = driver.findElement(emailSubmit).getText();
		String CurrentAddress1 = driver.findElement(currentSubmit).getText();
		String PermanentAddress1 = driver.findElement(PermanentSubmit).getText();
		String[] Name = name1.split(":");
		String[] Email = Email1.split(":");
		String[] CurrentAddress = CurrentAddress1.split(":");
		String[] PermanentAddress = PermanentAddress1.split(":");
		System.out.println("Name Validation with data");
		Assert.assertEquals(name, Name[1]);
		System.out.println("Email Validation with data");
		Assert.assertEquals(email,Email[1]);
		System.out.println("Current Address Validation with data");
		Assert.assertEquals(CurrentAdd, CurrentAddress[1]);
		System.out.println("Permanent Address Validation with data");
		Assert.assertEquals(PermanentAdd, PermanentAddress[1]);
		
	}

}
