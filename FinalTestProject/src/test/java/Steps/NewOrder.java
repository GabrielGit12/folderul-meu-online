package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewOrder  {
	
	
	WebDriver driver = new ChromeDriver();
	
	@Given("user is on main page")
	public void user_is_on_main_page() throws InterruptedException {
		driver.get("https://olx.ro");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		System.out.println("Accessed test address");
	}

	
	@And("User login into personal account")
	public void User_login_into_personal_account() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"hydrate-root\"]/header/div/div/div[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("g.boghi001@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Testaccount1234");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/form/button[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"client-root\"]/header/div/a")).click();
		Thread.sleep(2000);
		System.out.println("Logged-in");
	}
	
	
	@And("User chose a product")
	public void User_chose_a_product() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"searchmain-container\"]/div[2]/div/div/div/a[18]/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.css-qfzx1y")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div[2]/div[2]/section/div[1]/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/main/section[3]/div/section[1]/div[2]/label/label")).click();
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/main/section[3]/div/section[2]/div[2]/div/div[1]/div/div/div/input")).sendKeys("Testname");
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/main/section[3]/div/section[2]/div[2]/div/div[2]/div/div/div/input")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/main/section[3]/div/section[2]/div[2]/div/div[3]/div/div/div/input")).sendKeys("g.boghi001@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/main/section[3]/div/section[2]/div[2]/div/div[4]/div/div/div/input")).sendKeys("721234567");
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/main/section[3]/div/section[2]/div[2]/div/div[5]/div/div/div/input")).sendKeys("bucuresti");
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/main/section[3]/div/section[2]/div[2]/div/div[6]/div[1]/div/div/input")).sendKeys("bucuresti");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div/dl/button")).click();
		

}
	@When("User click button Continuă")
	public void User_click_button_Continuă () throws InterruptedException {
		
	driver.findElement(By.xpath("//*[@id=\"PageFooter\"]/button")).click();
	Thread.sleep(4000);
		
	}
	
	@Then("User click button Plaseaza Comanda")
	public void User_click_button_Plaseaza_Comanda () {
		
		driver.findElement(By.xpath("//*[@id=\"PageFooter\"]/button/span/span")).click();
	}
	
}
