package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;


public class SettlementHistorypage extends GenericWrappers {

	/*
	 * public SettlementHistorypage(RemoteWebDriver driver, ExtentTest test){
	 * this.driver = driver; this.test =test;
	 * System.out.println("Settlement History Page is loaded");
	 * 
	 * }
	 */
	public SettlementHistorypage ClickSettmentHistIcon(){
		clickByXpath("/html/body/app-root/div/nav/a[1]");
		return this;
	}
	
	public SettlementHistorypage ClickMissingsettlement(){
		clickByXpath("/html/body/app-root/div/nav/a[2]");
		return  this;
	}
	
	public SettlementHistorypage ClickConfiguration(){
		clickByXpath("/html/body/app-root/div/nav/a[3]");
		return  this;
	}
	public SettlementHistorypage ClickLogout(String data){
		clickByXpath("/html/body/app-root/div/nav/a[4]");
		return this;
	}
	
	public SettlementHistorypage Selectprocessingstatus(String data){
		selectIDVISIBLETEXT("processing-status", data);
		return this;
	}
	
	public SettlementHistorypage SelectAutoManual(String data){
		selectIDVISIBLETEXT("settlement-type", data);
		return this;
	}
	
	public SettlementHistorypage SelectSettletype(String data){
		selectIDVISIBLETEXT("settlement-name", data);
		return this;
	}
	public SettlementHistorypage enternstitution(String data){
		enterById("institution", data);
		return this;
	}
	public SettlementHistorypage ClickInstitution(){
		clickById("institution");
		return this;
	}
	
	public SettlementHistorypage ClickGobutton(){
		clickByXpath("//button[@class='btn btn-default']");
		return this;
	}
	
	public SettlementHistorypage ClickCompleted(){
		clickByXpath("//span[text()='Completed']");
		return this;
	}
	public SettlementHistorypage Clickshowmore(){
		clickByXpath("//button[@class='bb-btn bb-cancel-btn bb-btn-grey']");
		return this;
	}
	
	public SettlementHistorypage Validatethefiledownload() throws InterruptedException{
		driver.findElementByXPath(".//table[@class='search-results']/tbody/tr[2]/td[3]").click();
		String Actualconfirmation="Do you want to download settlement file for institution";
		WebDriverWait w=new WebDriverWait(driver,60);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("sharedConfirmDialogMessage")));
		String Obtainedconfirmation=driver.findElementById("sharedConfirmDialogMessage").getText();
		driver.findElementByXPath("//button[text()='Download file']").click();
		if (Obtainedconfirmation.contains(Actualconfirmation)) {
			reportStep("The File has been selected and ready for download", "PASS");
			String[] value=Obtainedconfirmation.split(" ");
			int len=value.length;
			String val =value[len-1];
			int len1=val.length();
			String a=val.substring(0, len1-1);
			driver.get("file:///C:/Users/SPalaniappan/Downloads/");
			Thread.sleep(1000);
			
			driver.findElementById("dateColumnHeader").click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+a+"')]")));
			
			if (driver.findElementByXPath("//a[contains(text(),'"+a+"')]").isDisplayed()) {
				reportStep("The file has been downloaded successfully", "PASS");
			}
			else {
				reportStep("The file is not downloaded", "FAIL");
			}
	}
		return this;
	}
	
	
	public SettlementHistorypage validateE2E(String Value) throws FileNotFoundException, InterruptedException {
		Thread.sleep(5000);
		driver.findElementByXPath(".//table[@class='search-results']/tbody/tr[2]/td[3]").click();
		WebDriverWait w=new WebDriverWait(driver,60);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("sharedConfirmDialogMessage")));
		String conftxt=driver.findElementById("sharedConfirmDialogMessage").getText();
		String[] contxt=conftxt.split(" ");
		int len=contxt.length;
		String val =contxt[len-1];
		int len1=val.length();
		String filename=val.substring(0, len1-1);
		driver.findElementByXPath("/html/body/app-root/div/div[2]/div/div/div/div/div[2]/button").click();
		Thread.sleep(5000);
		FileInputStream fis=new FileInputStream(new File("C:/Users/SPalaniappan/Downloads/"+filename+""));  
		Scanner sc = new Scanner(new File("C:/Users/SPalaniappan/Downloads/"+filename+""));  
		sc.useDelimiter(",");   //sets the delimiter pattern 
		List<String> list = new ArrayList<>();
		while (sc.hasNext())  //returns a boolean value  
		{ 
		String cs=sc.next();
		list.add(cs);
		}
		if (list.contains(Value)) {
			reportStep("The transaction posted from TSE is sent to OLS", "PASS");
		}
		else {
			reportStep("The transaction posted from TSE is not sent to OLS", "FAIL");
		}
		sc.close();  //closes the scanner  
		return this;
	}
	} 
		
		 
		
	

