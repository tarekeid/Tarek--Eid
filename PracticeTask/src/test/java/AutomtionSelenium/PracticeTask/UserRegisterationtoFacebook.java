package AutomtionSelenium.PracticeTask;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegisterationtoFacebook extends TestBase {
	
	Select selectoptions;
	
	
  @Test
  public void CreateNewuser() {
	  
		WebElement createnewaccountbtn =  driver.findElement(By.partialLinkText("Create New Account"));
		createnewaccountbtn.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys("Tarek");
		

		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.sendKeys("Eid");
		
		
		WebElement email = driver.findElement(By.name("reg_email__"));
		email.sendKeys("tarek_kfsaten_abc@tfbnw.net");
		
		WebElement emailconfirmation = driver.findElement(By.name("reg_email_confirmation__"));
		emailconfirmation.sendKeys("tarek_kfsaten_abc@tfbnw.net");
		
		
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		password.sendKeys("tarek@2020");
		
		WebElement dayslist =driver.findElement(By.id("day"));
		selectoptions = new Select(dayslist);
		selectoptions.selectByValue("24");		
		
		
		WebElement monthlist =driver.findElement(By.id("month"));
			selectoptions = new Select(monthlist);
			selectoptions.selectByValue("3");
		
			
		WebElement yearslist =driver.findElement(By.id("year"));
			selectoptions = new Select(yearslist);
			selectoptions.selectByValue("1994");
			
		
		WebElement check1 =driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input"));
		check1.click();	
		
		
		
		WebElement signupbutton = driver.findElement(By.name("websubmit"));
		signupbutton.click();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement AccountLoginlabel =  driver.findElement(By.partialLinkText("tarek eid test abc"));
		Assert.assertTrue(AccountLoginlabel.getAttribute("href")
				.contains("https://www.facebook.com/profile.php?id=100083348367499"));

		WebElement settingmenu = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]"));
		settingmenu.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement logoutbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[5]/div/div[1]/div[2]"));
		logoutbtn.click();
		
  }
}
