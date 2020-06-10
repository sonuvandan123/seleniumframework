package framework.frameworkbuilding;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base 
{
	WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver initializes");
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName,String password) throws IOException
	{
		System.out.println("basepagenAVMERHOT**********************");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to url");
		LandingPage landingPage=new LandingPage(driver);
		landingPage.getLogin().click();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmail().sendKeys(userName);;
		loginPage.getPassword().sendKeys(password);
		loginPage.getloginButton().click();
		log.info("moved to login page");

	}
	@DataProvider
	public Object[][] getData()
	{
		// row stands for how many different data test should run
		//column stands for how many values per test
		Object[][] data=new Object[2][2];
		
		data[0][0]="vandan@gmail.com";
		data[0][1]="password";
		
		data[1][0]="mishra@gmail.com";
		data[1][1]="passwordmishra";
		return data;
	}
	
	 @AfterTest
	 public void closeDriver()
	 { 
		 driver.close(); 
	 }
	 
}
