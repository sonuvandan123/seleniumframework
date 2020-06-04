package framework.frameworkbuilding;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class VerifyTitle extends Base
{
	@Test
	public void getHeadingOfCourses() throws IOException
	{
		driver=initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		LandingPage landingPage=new LandingPage(driver);
		Assert.assertEquals(landingPage.getcourseTitle().getText(),"FEATURED COURSES");
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
