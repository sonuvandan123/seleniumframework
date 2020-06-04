package framework.frameworkbuilding;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base 
{
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName,String password) throws IOException
	{
		
		LandingPage landingPage=new LandingPage(driver);
		landingPage.getLogin().click();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmail().sendKeys(userName);;
		loginPage.getPassword().sendKeys(password);
		loginPage.getloginButton().click();
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
