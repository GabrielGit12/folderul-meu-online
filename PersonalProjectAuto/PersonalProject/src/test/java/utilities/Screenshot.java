package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import base.BaseTest;


public class Screenshot extends BaseTest {
	
	
public void getScreenshot() throws IOException{
		
		
		Date currentDate = new Date();
		String screenshotFileName = currentDate.toString().replace(":", "-").replace(" ", "-").replace("-EET-2024", "");	
		System.out.println("Current date in old format: " + currentDate);
		File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //face screenshot
		System.out.println("Current date in new format: " + screenshotFileName);
		Files.copy(screenshotFile1, new File("C:\\Users\\HP\\eclipse-workspace\\PersonalProject\\src\\test\\resources\\screenshot\\" + screenshotFileName + ".png")); //salveaza fisieerul
		
		
}

}
