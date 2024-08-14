package testcases;



import org.openqa.selenium.By;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadCredentialsXLSFile;


public class LogIn extends BaseTest {
	
	
	
	@Test (dataProvider = "credentials",dataProviderClass = ReadCredentialsXLSFile.class)
	public void LogInTest(String username , String password) throws InterruptedException  {
		
		driver.findElement(By.xpath(loc.getProperty("myaccount"))).click(); // Click on MyAccount Icon 
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("loginoption"))).click(); // Choose LogIn option 
		driver.findElement(By.xpath(loc.getProperty("usernameplaceholder"))).sendKeys(username); // Username Input 
		driver.findElement(By.xpath(loc.getProperty("passwordplaceholder"))).sendKeys(password); // Password Input 
		driver.findElement(By.xpath(loc.getProperty("loginbutton"))).click(); // Click on LogIn button 
		
		
		
		
	}
	
	@AfterMethod
	public void LogOut() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("myaccountloggedin"))).click(); // Click on MyAccount Icon 
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("logoutbutton"))).click(); // Click on LogOut button 
	}

}
