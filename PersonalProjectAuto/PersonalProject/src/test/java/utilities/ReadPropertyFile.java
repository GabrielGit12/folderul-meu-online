<<<<<<< HEAD
package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:\\Users\\HP\\eclipse-workspace\\PersonalProject\\src\\test\\resources\\configfiles\\config.properties");
		
		Properties p = new Properties();
		p.load(fr);
		
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("testurl"));

		
	}
	

}
=======
package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:\\Users\\HP\\eclipse-workspace\\PersonalProject\\src\\test\\resources\\configfiles\\config.properties");
		
		Properties p = new Properties();
		p.load(fr);
		
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("testurl"));

		
	}
	

}
>>>>>>> f63c67cf5bfeb8ff39e957ab23b93d403171eeed
