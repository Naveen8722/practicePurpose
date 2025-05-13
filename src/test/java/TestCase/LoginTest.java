package TestCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public WebDriver driver;
	LoginPage login;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            }
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://the-internet.herokuapp.com/login");
		
		}
	
	
	@Test
	public void login() throws InterruptedException, IOException {
		
		LoginPage login=new LoginPage(driver);
		Thread.sleep(2000);
		String name="tomsmith";
		String pwd="SuperSecretPassword!";
		
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0, 500)");
		    ArrayList<String> list=new ArrayList<>(driver.getWindowHandles());
		    
		    for(int i=0; i<list.size();i++) {
		    	System.out.println("windows " + list.get(i));
		    }
		login.login(name, pwd);
		Thread.sleep(2000);
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File("screenshot.png") );
	    
	   
		
	}
	

	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	
	
	
}
