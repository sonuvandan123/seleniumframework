package framework.frameworkbuilding;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class VerifyTitle extends Base
{
	WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));

	}
	
	@Test
	public void getHeadingOfCourses() throws IOException
	{
	    LandingPage landingPage=new LandingPage(driver);
		Assert.assertEquals(landingPage.getcourseTitle().getText(),"FEATURE COURSES");
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
