package wrappers;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
	public static ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testDescription, category, authors;

	public void reportStep(String desc, String status, boolean bSnap) {
		

		if(bSnap && !status.equalsIgnoreCase("INFO") && !status.equalsIgnoreCase("PASS")){
			long snapNumber = 100000l;
			
			try {
				snapNumber= takeSnap();
			} catch (Exception e) {
				e.printStackTrace();
			}
			desc = desc+test.
					addScreenCapture("./../reports/images/"+snapNumber+".jpg");
		}
		
		
		if(status.equalsIgnoreCase("PASS")){
			test.log(LogStatus.PASS, desc);
		}else if(status.equalsIgnoreCase("PASS/TakeScreenshot")){
			test.log(LogStatus.PASS, desc);
		}else if(status.equalsIgnoreCase("FAIL")){
			test.log(LogStatus.FAIL, desc);
			throw new RuntimeException("FAILED");
		}else if(status.equalsIgnoreCase("WARN")){
			test.log(LogStatus.WARNING, desc);
		}else if(status.equalsIgnoreCase("INFO")){
			test.log(LogStatus.INFO, desc);
		}
	
	}
	
	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	public abstract long takeSnap();
	

	public static ExtentReports startResult(){
		extent = new ExtentReports("./extentreport/report.html", false);
		extent.loadConfig(new File("./src/test/resources/extent-config.xml"));
		return extent;
	}

	public static ExtentTest startTestCase(String testCaseName, String testDescription){
		test = extent.startTest(testCaseName, testDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}

	public void endTestcase(){
		extent.endTest(test);
	}

	
	
}
