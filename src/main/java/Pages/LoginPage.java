package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver driver) {
		ldriver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='username']")
	
	private WebElement username;
	
	
	
	@FindBy(xpath="//input[@name='password']")
	
	private WebElement password;
	
	
	@FindBy(xpath="//button[@class='radius']")

	private WebElement submit;
	
	
	
	
	public void login(String name, String pwd) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	    
	    wait.until(ExpectedConditions.visibilityOf(username));
	    username.sendKeys(name);

	    wait.until(ExpectedConditions.visibilityOf(password));
	    password.sendKeys(pwd);

	    wait.until(ExpectedConditions.elementToBeClickable(submit));
	    submit.click();
	}
	
	
	
	
	

}
