import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lesson12DataProvider extends Lesson12BaseClass {
	
	
	@Test(dataProvider = "credentials",dataProviderClass = DataProviderSauceDemo.class )// aici mentiona
	public void LoginTest(String username, String password) {
		
			
			driver.get("https://www.saucedemo.com");
			 driver.manage().window().maximize();
			 driver.findElement(By.xpath("//*[@id=\"user-name\"]")).click();
			 driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
			 driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
			 driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

}
