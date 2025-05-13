package TestCase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoingPageJunit {
	public WebDriver driver;
	LoginPage login;
	
	
	@BeforeEach
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://the-internet.herokuapp.com/login");
		
		}
	
	
	@Test
	public void login() throws InterruptedException {
		
		LoginPage login=new LoginPage(driver);
		Thread.sleep(2000);
		String name="tomsmith";
		String pwd="SuperSecretPassword!";
		

		login.login(name, pwd);
		Thread.sleep(2000);
	}
	

	@AfterEach
	public void teardown() {
		driver.close();
	}
	

}
