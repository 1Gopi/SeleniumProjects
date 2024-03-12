package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQAHomePageObj {
	private WebDriver driver = null;
	
	public DemoQAHomePageObj(WebDriver driver) {
		this.driver = driver;
	
		System.out.println("InHome Obj constructor");
		PageFactory.initElements(driver,this);
		System.out.println("After page Factory initElements");
	}
	
	//Ui Objects of HomePage/Dashboard page
	
	@FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]")
	private WebElement Elements;
	
	@FindBy(xpath = "//div[@class='home-body']//div[2]//div[1]//div[2]//*[name()='svg']")
	private WebElement Forms;
	
	@FindBy(xpath="//div[3]//div[1]//div[2]//*[name()='svg']")
	private WebElement AlertsFramesWindows;
	
	@FindBy(xpath="//*[name()='path' and contains(@d,'M13 13v8h8')]")
	private WebElement Widgets;
	
	@FindBy(xpath="//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[5]/div[1]")
	private WebElement Interactions;
	
	@FindBy(xpath="//*[name()='path' and contains(@d,'M169 57v43')]")
	private WebElement BookStoreApp;
	
	@FindBy(xpath="//img[@alt='Selenium Online Training']")
	private WebElement JoinNow;
	
	//Interaction methods for above elements
	public void clickElements() {
		try {
		WebDriverWait wt2 = new WebDriverWait(driver,Duration.ofMillis(30));
		wt2.until(ExpectedConditions.visibilityOf(Elements));
		}
		catch(Exception e){
			System.out.println("WebDriver Wait execption for Element click" +e.getMessage());
		}
		//js.executeScript("arguments[0].click();", Elements);
		Elements.click();
	}
	
	public void clickForms() {
		Forms.click();
	}
	
	public void clickAlertsFramesWindows() {
		AlertsFramesWindows.click();
	}
	public void clickWidgets() {
		Widgets.click();
	}
	
	public void clickInteractions() {
		Interactions.click();
	}
	
	public void clickBookStoreApp() {
		BookStoreApp.click();
	}
	
	public void clickJoinNow() {
		JoinNow.click();
	}
	
	
	
}
