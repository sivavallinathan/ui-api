package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class SettlementConfigurationpage extends GenericWrappers {
	
	/*
	 * public SettlementConfigurationpage(RemoteWebDriver driver, ExtentTest test){
	 * this.driver = driver; this.test =test;
	 * System.out.println("This is Settlement configuration page"); }
	 */
	
	public SettlementConfigurationpage ClickSettmentHistIcon(){
		clickByXpath("//span[text()=' Settlement History']");
		return this;
	}
	
	public SettlementConfigurationpage ClickAddinstituion(){
		clickByLink("Add Institution Settlement Configuration");
		return this;
	}
	public SettlementConfigurationpage clickEditinstitution(){
		clickByXpath("//i[@title='Update institution data']");
		return this;
	}
	
	
	public SettlementConfigurationpage ClickGobutton(){
		clickByXpath("//button[@class='btn btn-default']");
		return this;
	}
	
	public SettlementConfigurationpage SelectDescInstitution(String data){
		selectXPATHVALUE("//select[@class='form-control ng-pristine ng-valid ng-touched'][1]", data);
		return this;
	}
	public SettlementConfigurationpage EnterDescInstitution(String data){
		enterById("description", data);
		return this;
	}
	
	public SettlementConfigurationpage Clickincompletesettlement(){
		clickByXpath("//span[text()='There are incomplete settlements']");
		return this;
	}
	public SettlementConfigurationpage Clickdeletesettlement(){
		clickByXpath("//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div/div/div[1]/div[3]/button");
		return this;
	}
	
	public SettlementConfigurationpage Clickdeleteinstitution(){
		clickByXpath("/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/app-institution-detail/div/div/div/div/div/div[1]/div/div[1]/div/button/i");
		return this;
	}
	public SettlementConfigurationpage EnterInstEnterUUID(String data){
		enterById("institutionId", data);
		return this;
	}
	
	public SettlementConfigurationpage EnterInstEnterTimezone(String data){
		enterByXpath("//label[text()='Time Zone']//following::input", data);
		return this;
	}
	
	
	public SettlementConfigurationpage EnterInstEnterDescr(String data){
		enterById("description", data);
		return this;
	}
	public SettlementConfigurationpage Entersearchpage(String data){
		enterByXpath("//input[@aria-label='search for users']", data);
		return this;
	}
	
	public SettlementConfigurationpage SelectRunHour(String data){
		selectIDVISIBLETEXT("settlementHour", data);
		return this;
	}
	
	public SettlementConfigurationpage SelectRunMinute(String data){
		selectIDVISIBLETEXT("settlementMinute", data);
		return this;
	}
	public SettlementConfigurationpage Selectinst(String data){
		 driver.findElementByXPath("//div[text()='"+data+"']").click();
		return this;
	}
	public SettlementConfigurationpage Refresh(){
		 driver.navigate().refresh();
		return this;
	}
	
	
	public SettlementConfigurationpage ClickAddSettlement() throws InterruptedException{
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Settlement Type")));
		w.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Settlement Type")));
		Thread.sleep(1000);
		clickByLink("Add Settlement Type");
		return this;
	}
	
	public SettlementConfigurationpage EnterSettlementName(String data){
		
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='settlementTypeName']")));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='settlementTypeName']")));
		
		enterByXpath("//input[@id='settlementTypeName']", data);
	  // enterById("settlementTypeName", data);
		return this;
	}
	public SettlementConfigurationpage EnterFtpName(String data){
		
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ftpUserName']")));
		enterByXpath("//input[@id='ftpUserName']", data);   
		//enterById("ftpUserName", data);
			return this;
		}
	public SettlementConfigurationpage EnterPrivateKey(String data){
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='ftpPrivateKey']")));
		enterByXpath("//textarea[@id='ftpPrivateKey']", data);  
		//enterById("ftpPrivateKey", data);
			return this;
		}
	public SettlementConfigurationpage EnterPassPhrase(String data){
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ftpPassword']")));
		enterByXpath("//input[@id='ftpPassword']", data);   
		//enterById("ftpPassword", data);
			return this;
		}
	public SettlementConfigurationpage ClickActive(){
		clickByXpath("//input[@id='enabled']"); 
		   //clickById("enabled");
			return this;
		}
	
	public SettlementConfigurationpage ClickSaveinstitution(){
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/app-institution-config-data/div/div/div/div/div/div[2]/footer/button[2]")));
		
		   clickByXpath("/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/app-institution-config-data/div/div/div/div/div/div[2]/footer/button[2]");
		   
			return this;
		}
	
	public SettlementConfigurationpage ClickSaveSettlement(){
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/div[2]/app-settlement-type-detail/div/div/div[2]/footer/button[2]")));
		   clickByXpath("/html/body/app-root/div/div[1]/div[2]/app-settlement-type-detail/div/div/div[2]/footer/button[2]");
		   w.until(ExpectedConditions.presenceOfElementLocated(By.className("progress-message")));
		   w.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div[1]/div[2]/app-settlement-type-detail/div/div/div[2]/footer/button")));
		  clickByXpath("/html/body/app-root/div/div[1]/div[2]/app-settlement-type-detail/div/div/div[2]/footer/button");
		  driver.findElementByXPath("/html/body/app-root/div/div[1]/div[2]/app-settlement-type-detail/div/div/div[1]/div[2]/app-inline-progress-notification/div/div/div[2]/span[2]").isDisplayed();
		   return this;
			
			
			
		}
	public SettlementConfigurationpage ClickCancel(){
		   clickByXpath("//button[@class='bb-btn bb-cancel-btn bb-btn-grey']");
			return this;
		}
	
	public SettlementConfigurationpage ClickClosesinstitutionsetting(){
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/app-institution-detail/div/div/button")));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/app-institution-detail/div/div/button")));
		   clickByXpath("/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/app-institution-detail/div/div/button");
			return this;
	}
	public SettlementConfigurationpage ClickClosesettlementsetting(){
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='bb-close rotated']")));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='bb-close rotated']")));
		   clickByXpath("//button[@class='bb-close rotated']");
			return this;
	}
	
	public SettlementConfigurationpage Finish(){
		if(!verifyTitle("Campus Cash Admin")){
			reportStep("The Test Case is not Validated", "FAIL");
		}else {
			reportStep("The Test Case is Validated", "PASS");
			}
		return this;
		  
	}
	
	public SettlementConfigurationpage stopsettlement() throws InterruptedException {
		clickByXpath("//div[text()='QA-University']");
		clickByXpath("//*[@id=\"accordion\"]/app-manual-settlement-accordion/div/div[1]/h4/span/i");
	    new Select(driver.findElement(By.id("settlementTypeName"))).selectByVisibleText("Bbone");
	    clickByXpath("//*[@id=\"startDate\"]/div/div/div/button/span");
		clickByXpath("//*[@id=\"startDate\"]/div/div[2]/table[1]/tbody/tr/td[1]/div/div[2]/button");
		  clickByXpath("//div[text()='Aug']");
		clickByXpath("//*[@id=\"startDate\"]/div/div[2]/table[2]/tbody/tr[5]/td[3]/div");
		clickByXpath("//*[@id=\"endDate\"]/div/div/div/button/span");
		clickByXpath("//*[@id=\"endDate\"]/div/div[2]/table[1]/tbody/tr/td[1]/div/div[2]/button");
		clickByXpath("//div[text()='Aug']");
		clickByXpath("//*[@id=\"endDate\"]/div/div[2]/table[2]/tbody/tr[5]/td[3]/div");
		clickByXpath("//button[@type='submit']");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Confirm']")));
		clickByXpath("//button[text()='Confirm']");
		
		
	    driver.navigate().refresh();
	    clickByXpath("//button[@class='btn btn-default']");
	    clickByXpath("/html/body/app-root/div/div[1]/div[1]/app-settlement-history/div/div/span/div[2]/app-history-listing/table/tbody/tr[2]/td[3]/div/a");
	   
	    
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Stop Retrying']")));
		 clickByXpath("//button[text()='Stop Retrying']");
		 
		 driver.navigate().refresh();
		 clickByXpath("//button[@class='btn btn-default']"); 
	    String status=driver.findElementByXPath(".//table[@class='search-results']/tbody/tr[2]/td[3]").getText();
	    if(status.equalsIgnoreCase("Stopped")) {
	    	reportStep("The settlement is stopped successfully", "PASS");
	    }
	    else {
			reportStep("The settlement cannot be stopped", "FAIL");
			}
		return this;	    
	    
		
	}
	
	
	public SettlementConfigurationpage settlementdateerror()  {
		clickByXpath("//div[text()='QA-University']");
		clickByXpath("//*[@id=\"accordion\"]/app-manual-settlement-accordion/div/div[1]/h4/span/i");
	    new Select(driver.findElement(By.id("settlementTypeName"))).selectByVisibleText("Bbone");
	    clickByXpath("//*[@id=\"startDate\"]/div/div/div/button/span");
		clickByXpath("//*[@id=\"startDate\"]/div/div[2]/table[1]/tbody/tr/td[1]/div/div[2]/button");
		  clickByXpath("//div[text()='Aug']");
		clickByXpath("//*[@id=\"startDate\"]/div/div[2]/table[2]/tbody/tr[5]/td[3]/div");
		clickByXpath("//*[@id=\"endDate\"]/div/div/div/button/span");
		clickByXpath("//*[@id=\"endDate\"]/div/div[2]/table[1]/tbody/tr/td[1]/div/div[2]/button");
		clickByXpath("//div[text()='Aug']");
		clickByXpath("//*[@id=\"endDate\"]/div/div[2]/table[2]/tbody/tr[5]/td[2]/div");
		clickByXpath("//button[@type='submit']");
		
	    if(driver.findElementByXPath("//p[text()='Start date must not be bigger than end date']").isDisplayed()) {
	    	reportStep("The Date validation is done successfully", "PASS");
	    }
	    else {
			reportStep("The Date validation is not successful", "FAIL");
			}
		return this;	    
	    
		
	}
}


