package rsacademy.ExtenedReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportLearning {
	@Test
 public  void  ExtentreportMethod () throws Exception { 
		//Basic information about reports
			
	 //report
	 ExtentReports extentreport =new ExtentReports();
     //String path = System.getProperty("user.dir") + "//reports//Extentreport.html";
     File file =new File ("report.html");
     //report style - 2 way we can pass file ( direct or string )
	 ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
	 //provide the extentreport  - style of the project 
	 extentreport.attachReporter(sparkReporter);
	 
	  //create test only we use Extent Test class- we write logs or pass all 
	 // 5 types  of  Status in extent report 
	 ExtentTest  test1  =  extentreport.createTest("testp 1") ;
	 test1.pass("This is Pass ");
	 ExtentTest  test2  =  extentreport.createTest("Test  2") ;
	 test2.log(Status.FAIL, "This is Failed ");	 
 extentreport.createTest("Test  3")
                                    .skip("This test skipped");
 extentreport.createTest("Test  4")
                            .info("Giving info ");
 extentreport.createTest("Test  5")
                           .warning("This is for warning test ");
 
 //HIghligh msg
 extentreport.createTest("Test  6")
 .info(MarkupHelper.createLabel("This is hightlight msg", ExtentColor.RED));
 
 //Exception- throwable is a master class in java 
try {
	int i = 5/0; 
}
catch(Exception e ) {
	 extentreport
	 .createTest("Exception Test - 1")
.info(e);
	
}
Throwable t = new RuntimeException ("This is a custom exception");
extentreport
.createTest("Exception Test- 2")
.fail(t);
	
	 //Create report we have to use flush at the end then only will create report file
	 extentreport.flush();
	 //Direct open without click on report html 
	 Desktop.getDesktop().browse(new File ("report.html").toURI());
	 	 
 }
	@Test
	 public  void  Screenshotmethod  () throws Exception { 
		ExtentReports extentreport =new ExtentReports();	     
	     File file =new File ("report.html");	    
		 ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);	
		 extentreport.attachReporter(sparkReporter);
		 extentreport
		 .createTest("screenshot test 1", "this is for attaching the screenshot to the report" )
		 .info("This is info msg");
		 //Log level and Test level - to attach 
		 extentreport .createTest("screenshot test 1", "this is for attaching the screenshot to the report" )
		 .info("This is info msg");
		 
		 
		 
		 
		 
		 extentreport.flush();
		 //Direct open without click on report html 
		 Desktop.getDesktop().browse(new File ("report.html").toURI());
}
	
}


