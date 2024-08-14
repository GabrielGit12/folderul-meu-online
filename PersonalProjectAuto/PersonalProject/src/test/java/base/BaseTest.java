package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	
public static WebDriver driver = null;
	
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr1;
	public static FileReader fr2;

	@BeforeSuite
public void SetUp() throws IOException {
		
		
		if(driver==null) {
			FileReader fr1 = new FileReader("C:\\Users\\HP\\eclipse-workspace\\PersonalProject\\src\\test\\resources\\configfiles\\config.properties");
			FileReader fr2 = new FileReader("C:\\Users\\HP\\eclipse-workspace\\PersonalProject\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr1);
			loc.load(fr2);

			
		} if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.cssSelector("a[class = 'btnx cookies-info__button js-cookies-info-accept']")).click();

		} else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.cssSelector("a[class = 'btnx cookies-info__button js-cookies-info-accept']")).click();

		}

	}
	
	
	
		@AfterSuite
	public void closeBrowser() throws InterruptedException{	
			 Thread.sleep(5000);
		driver.close();
		
		

}
}
