package AutomtionSelenium.PracticeTask;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBase {

	WebDriver driver;
	
	@BeforeTest
	public void intiateDriver() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.navigate().to("https://www.facebook.com/");
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@AfterTest
	public void stopDriver(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();

	}
}
