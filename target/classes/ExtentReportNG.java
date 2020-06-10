package resources; 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG
{
	static ExtentReports extent;
	public static ExtentReports getObject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter esr=new ExtentSparkReporter(path);
		esr.config().setReportName("guru99 Automation");
		esr.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(esr);
		extent.setSystemInfo("Tester","Vandan");
		
		return extent;
	}
	
}
