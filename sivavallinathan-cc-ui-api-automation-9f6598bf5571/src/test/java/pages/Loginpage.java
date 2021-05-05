package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class Loginpage extends GenericWrappers {
	/*
	 * public Loginpage(RemoteWebDriver driver, ExtentTest test){ this.driver =
	 * driver; this.test =test; System.out.println("Login Page is loaded"); }
	 */

	public Loginpage enterUserName(String data,String data1) throws InterruptedException{
		enterById("i0116", data);
		clickById("idSIButton9");
		enterByIdPassword("i0118", data1);
		Thread.sleep(3000);
		clickById("idSIButton9");
		Thread.sleep(3000);
		clickById("idSIButton9");
		return this;
	}
	
	public Loginpage next(){
		
		clickById("idSIButton9");
		return this;
		
	}
	
	/*
	 * public Loginpage enterPassword(String data){
	 * 
	 * 
	 * 
	 * return this; }
	 */
	
	public Loginpage clickSubmit() throws InterruptedException{
		clickById("idSIButton9");
		return  this;
		
	} 

	
	
}
