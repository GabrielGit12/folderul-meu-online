import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lesson12BaseClass  {
	
	
	
	
	
	public static WebDriver driver = null;
	

	@BeforeSuite
	public void launchBrowser() {
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		
	}
		@AfterSuite
	public void closeBrowser() throws InterruptedException{	
			Thread.sleep(5000);
		driver.close();
		
		}

}
