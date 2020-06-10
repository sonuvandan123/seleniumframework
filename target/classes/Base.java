package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
   public  WebDriver driver;
   public Properties prop;
	public WebDriver initializeDriver() throws IOException {

		prop= new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\vandan mishra\\Selenium\\pro1\\frameworkbuilding\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\seleniumrelatedstuff\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\seleniumrelatedstuff\\firefoxdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	public String takeScreenShotOnTestFailure(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file= ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png"; 
		FileUtils.copyFile(file,new File(destination));
		return destination;
	}
	
}
