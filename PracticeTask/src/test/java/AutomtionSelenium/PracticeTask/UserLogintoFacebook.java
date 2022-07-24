package AutomtionSelenium.PracticeTask;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserLogintoFacebook extends TestBase {
	
	
	
	@DataProvider(name="testData")
	public static Object[][] userData(){

		return new Object[][] {
			{"tarek_kfsaten_abc@tfbnw.net","tarek@2020"},
			{"tarek_kfsaten_abc@tfbnw.net","tarek@3030"}         // wrong password
		};
	}
	
	
	
	
  @Test(dataProvider = "testData")
  public void Loginwithuser(String email,String password) {
	  
		
		WebElement emailtxt = driver.findElement(By.id("email"));
		emailtxt.sendKeys(email);
		
		
		WebElement passwordtxt = driver.findElement(By.id("pass"));
		passwordtxt.sendKeys(password);
		
		WebElement submitbutton = driver.findElement(By.name("login"));
		submitbutton.click();
		
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement AccountLoginlabel =  driver.findElement(By.partialLinkText("tarek eid test abc"));
		Assert.assertTrue(AccountLoginlabel.getAttribute("href")
				.contains("https://www.facebook.com/profile.php?id=100083348367499"));
		
		WebElement settingmenu = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]"));
		settingmenu.click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement logoutbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[5]/div/div[1]/div[2]"));
		logoutbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
		catch(Exception e){
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement passwordincorrectlabel =  driver.findElement(By.cssSelector("#loginform > div.clearfix._5466._44mg > div._9ay7"));
			Assert.assertTrue(passwordincorrectlabel.getText().contains("The password that you've entered is incorrect. "));
		}

		
  }
}
