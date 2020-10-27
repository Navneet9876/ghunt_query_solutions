package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFunction {
	
	
	public WebDriver driver;
	
	String browser = Constant.BROWSER;
	
	public WebDriver openBrowser ()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Navneet\\eclipse-workspace\\1.0\\src\\test\\java\\driver\\chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		
		return driver;
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
}
