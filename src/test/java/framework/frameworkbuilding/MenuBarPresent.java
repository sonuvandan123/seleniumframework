package framework.frameworkbuilding;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class MenuBarPresent extends Base
{
    @Test
    public void isPresentMenuBar() throws IOException
    {
    	driver=initializeDriver();
    	driver.get(prop.getProperty("url"));
    	LandingPage landingPage=new LandingPage(driver);
    	Assert.assertTrue(landingPage.getMenuBar().isDisplayed());
    }
    @AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
