package rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Data.GetWebDriver;
import rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{

	ExtentTest test;
	WebDriver driver;
	ExtentReports ex = new ExtentReporterNG().getReportObject();
	
	ThreadLocal<ExtentTest> threadTest = new ThreadLocal<>();
	
	@Override		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		ex.flush();
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult arg0) {					
        // TODO Auto-generated method stub				
    	threadTest.get().fail(arg0.getThrowable());
    	
    	try {
			driver = (WebDriver) arg0.getTestClass().getRealClass().getField("driver").get(arg0.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	//GetWebDriver.getDriver()
    	String filepath = null;
		try {
			filepath = getScreenshot(arg0.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadTest.get().addScreenCaptureFromPath(filepath, arg0.getMethod().getMethodName());
    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub	
        		test = ex.createTest(arg0.getMethod().getMethodName());
        		threadTest.set(test);
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub			
    	threadTest.get().log(Status.PASS, "Test Passed");
        		
    }		

}
