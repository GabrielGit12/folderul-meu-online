package testcases;



import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import utilities.Screenshot;

public class MainPage extends Screenshot {
	
	
	
	
	@BeforeTest
	public void Titlecheck() throws IOException {
		
		String expectedTitle = "Alza.cz – rychlý a pohodlný nákup odkudkoliv | Alza.cz";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title is the same");
			
	}
	
	
	
	
	@BeforeMethod
	
public void OrderTest () {
		System.out.println("Test case is starting");
	}
	
	
	@AfterMethod
	public void Screenshot() throws IOException {
		//getScreenshot(); // takes a screenshot after every @Test
		System.out.println("Test Case is finished");
	}
	
	@AfterTest
	public void BackToMainPage() {
		driver.navigate().to("https://alza.cz");
	}
	
	
	
	@Test (priority = 1)
	public void ChooseProduct() throws IOException, InterruptedException {
	
		driver.findElement(By.cssSelector(loc.getProperty("languagebutton"))).click(); // Click on language Icon 
		
		driver.findElement(By.cssSelector(loc.getProperty("selectEnglanguage"))).click(); // Select English language 
		
		driver.findElement(By.cssSelector(loc.getProperty("confirmlanguagebutton"))).click(); // Confirm English language 
		
		WebElement PcLaptop = driver.findElement(By.cssSelector(loc.getProperty("pclaptopcategorybutton"))); //Mouse hover over the PC/Laptop Category 
		Actions mouseHover = new Actions(driver);
		mouseHover.clickAndHold(PcLaptop);
		mouseHover.perform();
		
		driver.findElement(By.linkText(loc.getProperty("accesroriesbutton"))).click(); // Click on Accessories button 
		SoftAssert softAssert = new SoftAssert();
		String expectedTitle1 = "Computer & Laptop Accessories | Alza.cz";
		String actualTitle1 = driver.getTitle();
		softAssert.assertEquals(actualTitle1, expectedTitle1); // Soft Assert 
		
		driver.findElement(By.cssSelector(loc.getProperty("laptopcategorybutton"))).click(); // Click on Laptop button 
		
		driver.findElement(By.cssSelector(loc.getProperty("orderstatusradiobutton"))).click(); // Click on radio button 
		
		driver.findElement(By.cssSelector(loc.getProperty("brandscheckbox"))).click(); // Select check-box
		String expectedTitle2 = "Laptop Accessories | Alza.cz";
		String actualTitle2 = driver.getTitle();
		softAssert.assertEquals(actualTitle2, expectedTitle2); // Soft Assert
		
		driver.findElement(By.cssSelector(loc.getProperty("micecatselect"))).click(); // Click on Mice button 
		
		driver.findElement(By.partialLinkText(loc.getProperty("lowtohighsort"))).click(); // Filter price sort from Low to High 
		Thread.sleep(2000);
		
		WebElement Scroll = driver.findElement(By.id(loc.getProperty("scrollitemspage"))); // Scroll Down to see list of items and be able to choose another product 
		Actions PageScroll = new Actions(driver);
		PageScroll.moveToElement(Scroll);
		PageScroll.perform();
		driver.getCurrentUrl();
		String UrlbeforeSelectItem = driver.getCurrentUrl(); // Stock Current Url to use for Navigate method later
		System.out.println(UrlbeforeSelectItem); // Print Current Url 
		String expectedTitle3 = "Computer Mice | Mice | Alza.cz";
		String actualTitle3 = driver.getTitle();
		softAssert.assertEquals(actualTitle3, expectedTitle3); // Soft Assert
		
		driver.findElement(By.id(loc.getProperty("Item1"))).click(); // Choose Item 
		String expectedTitle4 = "C-TECH WM-07 Black  - Mouse | Alza.cz";
		String actualTitle4 = driver.getTitle();
		softAssert.assertEquals(actualTitle4, expectedTitle4);
		
		driver.navigate().to(UrlbeforeSelectItem); // Navigate method to get back to products page and choose other product 
		
		WebElement Scroll1 = driver.findElement(By.id(loc.getProperty("scrollitemspage"))); // Scroll Down to see list of items and be able to choose another product 
		Actions PageScroll1 = new Actions(driver);
		PageScroll1.moveToElement(Scroll1);
		PageScroll1.perform();
		driver.findElement(By.id(loc.getProperty("item2"))).click(); // Choose a different product 
		WebElement Scroll2 = driver.findElement(By.xpath(loc.getProperty("scrollproductpage"))); // Scroll down in product page 
		Actions PageScroll2 = new Actions(driver);
		PageScroll2.moveToElement(Scroll2);
		PageScroll2.perform();
		String expectedTitle5 = "C-TECH WM-01R Red  - Mouse | Alza.cz";
		String actualTitle5 = driver.getTitle();
		softAssert.assertEquals(actualTitle5, expectedTitle5);
		softAssert.assertAll(); // Soft Assert of previous 5 asserts mentioned in this Test
		
	}
	@Test(priority = 2)	
	public void Cart() throws IOException, InterruptedException {
			
		driver.findElement(By.linkText(loc.getProperty("addtocartbutton"))).click();// Click Add to Cart button 
		driver.findElement(By.xpath(loc.getProperty("checkoutbutton"))).click(); // Click proceed to checkout button 
		driver.findElement(By.xpath(loc.getProperty("confirmcheckoutbutton"))).click(); // Click continue button 
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("deliveryoptionselect"))).click(); // Select Delivery Option
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("selectcity"))).click(); //Chose city where to deliver
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("confirmcity"))).click(); //Confirm chosen city 
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("paymentoptionselect"))).click(); // Select Payment method 
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("continuebutton"))).click(); // Click continue button after payment and delivery are selected
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("closepopupwindow"))).click(); //Close pop-up window 
		
	}
		
		@Test(priority = 3, dataProvider = "PersonalData") 
		
		public void PersonalData(String mailaddress , String name , String address , String city , String postcode , String phoneno) {
			
			driver.findElement(By.xpath(loc.getProperty("emailplaceholder"))).clear(); // Clear Email address placeholder
			driver.findElement(By.xpath(loc.getProperty("emailplaceholder"))).sendKeys(mailaddress); // Email address Input
			driver.findElement(By.xpath(loc.getProperty("nameplaceholder"))).sendKeys(name); //Name Input 
			driver.findElement(By.xpath(loc.getProperty("addressplaceholder"))).sendKeys(address); // Address Input
			driver.findElement(By.xpath(loc.getProperty("addressplaceholder"))).sendKeys(Keys.ARROW_DOWN); // Select address from drop-down list
			driver.findElement(By.xpath(loc.getProperty("addressplaceholder"))).sendKeys(Keys.ENTER); // Confirms selected address 
			driver.findElement(By.xpath(loc.getProperty("cityplaceholder"))).sendKeys(city); //City name Input 
			driver.findElement(By.xpath(loc.getProperty("cityplaceholder"))).sendKeys(Keys.ARROW_DOWN); // Select city from drop-down list 
			driver.findElement(By.xpath(loc.getProperty("cityplaceholder"))).sendKeys(Keys.ENTER); // Confirms selected city 
			driver.findElement(By.xpath(loc.getProperty("postcodeplaceholder"))).sendKeys(postcode); // Post-code Input 
			driver.findElement(By.xpath(loc.getProperty("phonenoplaceholder"))).sendKeys(phoneno); // Phone number Input  
			//driver.findElement(By.xpath("//*[@id=\"order3-footer-container\"]/div[1]/a[2]")).click(); // Place an actual order
			
			
		}
		
		@DataProvider(name = "PersonalData")
		public Object[][] providerDataSet() {
			return new Object[][] {
					{"test@email.com", "Test Name","na zlate stoce 1862","Ceske Budejovice","37005","777554787" }

			};

			
}
		
}
