

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CancelOrder {
	
	
	WebDriver driver = new ChromeDriver();
	@Test 
	public void CancelPlacedOrder () throws InterruptedException {
	driver.get("https://olx.ro");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"hydrate-root\"]/header/div/div/div[2]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("g.boghi001@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Testaccount1234");
	driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/form/button[2]")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[2]/ul/li[9]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"body-container\"]/div/div/div/div/div/div[3]/div/div/div[2]/div[2]/div[2]/div/button[2]/div/div[1]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[9]/div/div/div/div/div[6]/label")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[9]/div/div/div/div/div[8]/button[2]/div/div")).click();
	
	
	

}
	
}
