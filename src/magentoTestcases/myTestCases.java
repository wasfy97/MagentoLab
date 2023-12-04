package magentoTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class myTestCases extends Parameters {
	
	SoftAssert softassert = new SoftAssert ();
	
	@BeforeTest
	public void myBefore() {
		
		driver.get(TheWebSite);
		
	}
	
	@Test(priority = 1)
	public void SignupTestCase() throws InterruptedException {
		
		driver.get(SignupPage);
		WebElement firstNameInput = driver.findElement(By.id("firstname"));
		WebElement lastNameInput = driver.findElement(By.id("lastname"));
		WebElement emailInput = driver.findElement(By.id("email_address"));
		WebElement passwordlnput = driver.findElement(By.id("password"));
		WebElement confirmPasswordInput = driver.findElement(By.id("password-confirmation"));
		WebElement signUpButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailInput.sendKeys(Email);
		passwordlnput.sendKeys(password);
		confirmPasswordInput.sendKeys(password);
		signUpButton.click();
		Thread.sleep(2000);
		
	   String  WelcomeMsg = driver.findElement(By.xpath("//div[@class='panel header']")).getText();
	   
	   softassert.assertEquals(WelcomeMsg.contains ("Welcome"), true,"validation the signup process");
	   softassert.assertAll();
	}
	
	@Test(priority = 2)
	public void LogoutTestCase() throws InterruptedException {
		driver.get(LogoutPage);	
		Thread.sleep(7000);
		
		 softassert.assertEquals(driver.getCurrentUrl(), TheWebSite,"validation of the website url after the logout process");
		 softassert.assertAll();
		

	}
	
	@Test(priority = 3)
	public void LoginTestCase() {
		driver.get(LogoinPage);	
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement LoginButton = driver.findElement(By.id("send2"));
		
		emailInput.sendKeys(Email);
		passwordInput.sendKeys(password);
		LoginButton.click();
		
		String  Information = driver.findElement(By.xpath("//div[@class='column main']")).getText();
		String  Collaps = driver.findElement(By.xpath("//div[@id='block-collapsible-nav']")).getText();
		String  Address = driver.findElement(By.xpath("//div[@class='block block-dashboard-addresses']")).getText();

	    softassert.assertEquals(Information.contains("Account"),true ,"validation the Sign in process (validation  the Information)");
	    softassert.assertEquals(Collaps.contains("Orders"),true ,"validation the Sign in process (validation  the Collaps)");
	    softassert.assertEquals(Address.contains("Address"),true ,"validation the Sign in process (validation  the Address)");

		   
		softassert.assertAll();
		
	}
	
	
	@AfterTest
	public void myAfterTest () { 
		
		
	}
	
	

}