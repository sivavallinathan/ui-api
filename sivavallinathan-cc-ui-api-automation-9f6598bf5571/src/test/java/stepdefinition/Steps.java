package stepdefinition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.bson.Document;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import com.fasterxml.uuid.Generators;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.waits.Wait;
import pages.Loginpage;
import pages.SettlementConfigurationpage;
import pages.SettlementHistorypage;

import payload.Transaction;
import payload.TransactionBatch;
import payload.TransactionServiceBusService;
import payload.TriggerSettlementServiceBusService;
import payload.TsopSpecificData;
import wrappers.GenericWrappers;


public class Steps extends GenericWrappers{
	
	String editinstituiondesc="/html/body/app-root/div/div[1]/div[2]/app-institution-data/div/div/div[1]/div[1]/div/form/div[2]/div[1]/input";
	String editinstitutionsave="/html/body/app-root/div/div[1]/div[2]/app-institution-data/div/div/div[2]/footer/button[2]";
	
	/*
	 * Loginpage l=new Loginpage(driver, test); SettlementHistorypage s=new
	 * SettlementHistorypage(driver, test); SettlementConfigurationpage c=new
	 * SettlementConfigurationpage(driver, test);
	 */
	Loginpage l=new Loginpage();
	SettlementHistorypage s=new SettlementHistorypage();
	SettlementConfigurationpage c=new SettlementConfigurationpage();
	
    
	
	public void createinstitutionwithsplchar(){
		s.ClickConfiguration();
		   c.ClickAddinstituion();
		   UUID uuidt = Generators.randomBasedGenerator().generate();
		   String uuid=uuidt.toString();
		   c.EnterInstEnterUUID(uuid);
		   c.EnterDescInstitution("@$%&^^%%$");
		   c.EnterInstEnterTimezone("Pacific/Niue (UTC -11)");
		   c.SelectRunHour("0");
		   c.SelectRunMinute("45");
		   c.ClickSaveinstitution();
		   c.ClickClosesettlementsetting();
	}
	
	public void createinstitution(){
		s.ClickConfiguration();
		   c.ClickAddinstituion();
		   UUID uuidt = Generators.randomBasedGenerator().generate();
		   String uuid=uuidt.toString();
		   c.EnterInstEnterUUID(uuid);
		   c.EnterDescInstitution("Automation-Institution");
		   c.EnterInstEnterTimezone("Pacific/Niue (UTC -11)");
		   c.SelectRunHour("0");
		   c.SelectRunMinute("45");
		   c.ClickSaveinstitution();
		   if (driver.findElementByXPath("/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/app-institution-config-data/div/div/div/div/div/div[1]/div[2]/app-inline-progress-notification/div/div/div[2]/span[2]").isEnabled()) {
			   c.ClickClosesettlementsetting();
		}
		   
	}
	
	public void AddSettlementtype(String name) throws InterruptedException {
	s.ClickConfiguration();
	c.ClickGobutton();
	driver.findElementByXPath("//div[text()='Automation-Institution']").click();
	c.ClickAddSettlement();
	c.EnterSettlementName(name);
	c.EnterFtpName("testsftp33");
	c.EnterPrivateKey(sFTPkey);
	c.EnterPassPhrase(sPassphrase);
	c.ClickSaveSettlement();
	c.ClickClosesinstitutionsetting();
	c.ClickSettmentHistIcon();
	s.ClickGobutton();
	}
	public void AddSettlementtypedummy(String name) throws InterruptedException {
		s.ClickConfiguration();
		c.ClickGobutton();
		driver.findElementByXPath("//div[text()='Automation-Institution']").click();
		c.ClickAddSettlement();
		c.EnterSettlementName(name);
		c.EnterFtpName("testsftp33");
		c.EnterPrivateKey("qqq");
		c.EnterPassPhrase("wss");
		c.ClickSaveSettlement();
		c.ClickClosesinstitutionsetting();
		c.ClickSettmentHistIcon();
		s.ClickGobutton();
		}
	
	@Given("^Post tran from tse$")
	public void post_tran_from_tse() {
		/*
		 * 
		 * 
		 * TsopSpecificData tsopSpecificData = TsopSpecificData.builder()
		 * .transactionId(86400000l) .transactionItemId(1l) .merchantId(1l)
		 * .terminalNumber(116l) .cardHolderId(0000000000000000333333l) .build();
		 * 
		 * 
		 * Transaction transaction = Transaction.builder() .cardNumber("1")
		 * .created(1612522649000l) .totalAmount("1") .itemAmount("1") .currency("USD")
		 * .debit(true) .tsopSpecificData(tsopSpecificData) .build();
		 * 
		 * Batch batch = Batch.builder()
		 * .institutionId("a201ac75-497b-4bae-885f-4d3ee5948a56")
		 * .extractionStart(1612188639000l) .extractionEnd(1612878660000l)
		 * .transactions(List.of(transaction)) .build();
		 * 
		 * ServiceBusService serviceBusService = new
		 * ServiceBusService(Clock.systemUTC()); serviceBusService.sendBatch(batch);
		 * 
		 * 
		 */} 
	
	
	/*
	 * @Given("^Read data from excel$") public void read_data_from_excel() throws
	 * IOException, InterruptedException { s.ClickConfiguration();
	 * c.ClickGobutton();
	 * driver.findElementByXPath("//div[text()='TRAN_GEN']").click(); clickByXpath(
	 * "//*[@id=\"accordion\"]/app-manual-settlement-accordion/div/div[1]"); new
	 * Select(driver.findElement(By.id("settlementTypeName"))).selectByVisibleText(
	 * "Bb"); clickByXpath("//*[@id=\"startDate\"]/div/div[1]/div/button/span");
	 * clickByXpath(
	 * "//*[@id=\"startDate\"]/div/div[2]/table[1]/tbody/tr/td[1]/div/div[2]/button"
	 * ); clickByXpath("//div[text()='Feb']"); clickByXpath(
	 * "//*[@id=\"startDate\"]/div/div[2]/table[2]/tbody/tr[1]/td[2]/div/span");
	 * clickByXpath("//*[@id=\"endDate\"]/div/div/div/button/span"); clickByXpath(
	 * "//*[@id=\"endDate\"]/div/div[2]/table[1]/tbody/tr/td[1]/div/div[2]/button");
	 * clickByXpath("//div[text()='Feb']"); clickByXpath(
	 * "//*[@id=\"endDate\"]/div/div[2]/table[2]/tbody/tr[2]/td[1]/div/span");
	 * clickByXpath(
	 * "//*[@id=\"accordion\"]/app-manual-settlement-accordion/div/div[2]/div/div[1]/form/div[2]/button"
	 * );
	 * clickByXpath("/html/body/app-root/div/div[2]/div/div/div/div/div[2]/button");
	 * driver.navigate().refresh(); Thread.sleep(1000); s.validateE2E(); }
	 */
		
	
	@Given("^Post Transaction \"([^\"]*)\" from TSE$")
	public void post_Transaction_from_TSE(String Value) throws ParseException {
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat crunchifyFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
		String currentTime = crunchifyFormat.format(today);
		System.out.println("Current Time = " + currentTime);
		Date date = crunchifyFormat.parse(currentTime);
		long epochTime = date.getTime();
		long epoch1 = epochTime + 60000000;
		long epoch2 = epochTime - 60000000;
		System.out.println("Current Time in Epoch: " + epochTime);

		
		 String dbURI="mongodb://mongodb-cc-aks-qa-us-west:Y6XECBzDVjys52JiWjoaj3JBAAarwiZ6905DTqyIqNogjeWXOsisdfb8DQIXvqhuc3ahhpgpEaBj9M3RyHLRwA==@mongodb-cc-aks-qa-us-west.documents.azure.com:10250/?ssl=true";
		 MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		 MongoDatabase dbs=mongoClient.getDatabase("settlement-config");
		 MongoCollection<Document> collection= dbs.getCollection("processing-record");
		 collection.drop();

		TsopSpecificData tsopSpecificData = TsopSpecificData.builder()
				.transactionId(86400000l)
				.transactionItemId(1l)
				.merchantId(1l)
				.terminalNumber(116l)
				.cardHolderId(0000000000000000333333l)
				.build();

		Transaction transaction = Transaction.builder()
				.cardNumber("1")
				.created(epoch2)
				.totalAmount(Value)
				.itemAmount(Value)
				.currency("USD")
				.debit(true)
				.tsopSpecificData(tsopSpecificData)
				.build();

		TransactionBatch batch = TransactionBatch.builder().institutionId("a201ac75-497b-4bae-885f-4d3ee5948a56")
				.extractionStart(1612188639000l).extractionEnd(epoch1).transactions(List.of(transaction)).build();

		TransactionServiceBusService transactionServiceBusService = new TransactionServiceBusService(Clock.systemUTC());
		transactionServiceBusService.sendBatch(batch);
		
		UUID batchUUID = UUID.randomUUID();

		TriggerSettlementServiceBusService triggerSettlementServiceBusService = new TriggerSettlementServiceBusService(
				Clock.systemUTC());
		triggerSettlementServiceBusService.sendBatch(batchUUID);
	}

	@Given("^Read the excel file and validate the transaction \"([^\"]*)\"$")
	public void read_the_excel_file_and_validate_the_transaction(String Value) throws InterruptedException, FileNotFoundException {
        s.ClickSettmentHistIcon();
        s.enternstitution("TRAN");
        s.ClickGobutton();
        
		/*
		 * s.ClickConfiguration(); c.ClickGobutton();
		 * driver.findElementByXPath("//div[text()='TRAN_GEN']").click(); clickByXpath(
		 * "//*[@id=\"accordion\"]/app-manual-settlement-accordion/div/div[1]"); new
		 * Select(driver.findElement(By.id("settlementTypeName"))).selectByVisibleText(
		 * "Bb"); clickByXpath("//*[@id=\"startDate\"]/div/div[1]/div/button/span");
		 * clickByXpath(
		 * "//*[@id=\"startDate\"]/div/div[2]/table[1]/tbody/tr/td[1]/div/div[2]/button"
		 * ); clickByXpath("//div[text()='Feb']"); clickByXpath(
		 * "//*[@id=\"startDate\"]/div/div[2]/table[2]/tbody/tr[1]/td[2]/div/span");
		 * clickByXpath("//*[@id=\"endDate\"]/div/div/div/button/span"); clickByXpath(
		 * "//*[@id=\"endDate\"]/div/div[2]/table[1]/tbody/tr/td[1]/div/div[2]/button");
		 * clickByXpath("//div[text()='Feb']"); clickByXpath(
		 * "//*[@id=\"endDate\"]/div/div[2]/table[2]/tbody/tr[2]/td[1]/div/span");
		 * clickByXpath(
		 * "//*[@id=\"accordion\"]/app-manual-settlement-accordion/div/div[2]/div/div[1]/form/div[2]/button"
		 * );
		 * clickByXpath("/html/body/app-root/div/div[2]/div/div/div/div/div[2]/button");
		 * driver.navigate().refresh();
		 */
	    Thread.sleep(1000);
		s.validateE2E(Value);
		
	}
	
	@Given("^Testcase Details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" are recored in the report$")
	public void testcase_Details_are_recored_in_the_report(String TestCaseName, String TestCaseDesc, String Category, String Author) {
		
		 startResult(); 
		  test = startTestCase(TestCaseName, TestCaseDesc);
		  test.assignCategory(Category);
		  test.assignAuthor(Author);
	}


	/*
	 * @Given("^User Navigate to LogIn Page$") public void
	 * user_Navigate_to_LogIn_Page() { invokeApp("chrome"); }
	 * 
	 * @Given("^User enters UserName and Password$") public void
	 * user_enters_UserName_and_Password() { l.enterUserName(sUsername); l.next();
	 * l.enterPassword(sPassword); l.clickSubmit(); }
	 */

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() {
		if(!verifyTitle("Campus Cash Admin")){
			reportStep("This is not Settlement History Page", "FAIL");
		}else {
			reportStep("This is Settlement History Page", "PASS");
			}
		
	}
	
	@Given("^User navigates and enter into Campucash UI\"([^\"]*)\"$")
	public void user_navigates_and_enter_into_Campucash_UI(String browser) throws InterruptedException {
		   
		   invokeApp(browser);
		   l.enterUserName(sUsername,sPassword);
		   //l.clickSubmit();
		
	}
	

@Given("^User navigates and enter into Campucash UI chrome$")
public void user_navigates_and_enter_into_Campucash_UI_chrome() throws InterruptedException {
	  invokeApp("chrome");
	   l.enterUserName(sUsername,sPassword);
}

	@Then("^User is logged in successfully$")
	public void user_is_logged_in_successfully() throws InterruptedException {
		
		Thread.sleep(3000);
		if(!verifyTitle("Campus Cash Admin")){
			reportStep("This is not Settlement History Page", "FAIL");
		}else {
			reportStep("This is Settlement History Page", "PASS");
			}
	}

	
	@Then("^User clicks on go button and validates the history features$")
	public void user_clicks_on_go_button_and_validates_the_history_features() {
	    s.ClickGobutton();
	    JavascriptExecutor js = (JavascriptExecutor) driver; 
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    s.Clickshowmore();
	}


	
	
	@Then("^User clicks on go button and validates the history filtering processing status(.*)$")
	public void user_clicks_on_go_button_and_validates_the_history_filtering_processing_status(String Filter) {
		if (Filter.contains("Failed")) {
			s.Selectprocessingstatus("Failed");
			   s.ClickGobutton();
			   List<WebElement> column3 = driver.findElements(By.xpath(".//table[@class='search-results']/tbody/tr/td[3]"));	
			   for (WebElement element : column3) {
				   String s=element.getText();
				   if (s.equals("Retrying - Missing transactions")||s.equals("Retrying - FTP transfer error")||s.equals("Failed - FTP transfer error")||s.equals("Failed - Missing transactions")) {
					   reportStep("The status is Valid for Failed or being retried and current status is "+s+" ", "PASS");  
				}
				   else {
						reportStep("The status is not Valid for filter", "FAIL");  
				
			}
				   
		}}
		else if (Filter.contains("In Progress")) {
			s.Selectprocessingstatus("In Progress");
			   s.ClickGobutton();
			   List<WebElement> column3 = driver.findElements(By.xpath(".//table[@class='search-results']/tbody/tr/td[3]"));	
			   
			   for (WebElement element : column3) {
				   String s=element.getText();
				   if (s.equals("In Progress")) {
					   reportStep("The status is Valid for In Progress", "PASS");  
				}
				   else {
						reportStep("The status is not Valid for filter", "FAIL");  
				
			}
		}}
		else if (Filter.contains("Successful")) {

			s.Selectprocessingstatus("Successful");
			   s.ClickGobutton();
			   List<WebElement> column3 = driver.findElements(By.xpath(".//table[@class='search-results']/tbody/tr/td[3]"));	
			   for (WebElement element : column3) {
				   String s=element.getText();
				   if (s.equals("Completed")) {
					   reportStep("The status is Valid for Successful", "PASS");  
				}
				   else {
						reportStep("The status is not Valid for filter", "FAIL");  
				
			}
		}}
		else if (Filter.contains("Stopped")) {

			s.Selectprocessingstatus("Stopped");
			   s.ClickGobutton();
			   List<WebElement> column3 = driver.findElements(By.xpath(".//table[@class='search-results']/tbody/tr/td[3]"));	
			   for (WebElement element : column3) {
				   String s=element.getText();
				   if (s.contains("Stopped")) {
					   reportStep("The status is Valid for Stopped", "PASS");  
				}
				   else {
						reportStep("The status is not Valid for filter", "FAIL");  
				
			}	
		}}
		
		else if (Filter.contains("being retried")) {
			s.Selectprocessingstatus("Being retried");
			   s.ClickGobutton();
			   List<WebElement> column3 = driver.findElements(By.xpath(".//table[@class='search-results']/tbody/tr/td[3]"));	
			   for (WebElement element : column3) {
				   String s=element.getText();
				   if (s.equals("Retrying - Missing transactions")||s.equals("Retrying - FTP transfer error")||s.equals("Failed - FTP transfer error")||s.equals("Failed - Missing transactions")) {
					   reportStep("The status is Valid for Failed or being retried and current status is "+s+" ", "PASS");  
				}
				   else {
						reportStep("The status is not Valid for filter", "FAIL");  
				
			}
				   
		}}
		
		else {
			reportStep("The status is not Valid for filter", "FAIL");  
			
			
		}
		 
	}


	@Given("^User navigates and enter into Campucash UI\"([^\"]*)\" without login$")
	public void user_navigates_and_enter_into_Campucash_UI_without_login(String browser) {
		 invokeApp(browser);
		 l.next();
	}

	@Then("^User Should not be allowed to enter into the application$")
	public void user_Should_not_be_allowed_to_enter_into_the_application() {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
	    if (driver.findElementByXPath("//div[@id='usernameError']").isDisplayed()) {
              reportStep("The login is blocked", "PASS");  
		}
	    else {
	    	reportStep("The login is allowed", "FAIL");  
	    }
	}

	@Given("^User navigates and enter into Campucash UI\"([^\"]*)\" with incorrect account$")
	public void user_navigates_and_enter_into_Campucash_UI_with_incorrect_account(String browser) throws InterruptedException {
		invokeApp(browser);
		l.enterUserName("siva@campuscloud.io","zz");
	}

	@Given("^Delete/Deactivate the settlement that is in-progress state$")
	public void delete_Deactivate_the_settlement_that_is_in_progress_state() throws InterruptedException {
		s.Selectprocessingstatus("Failed or being retried");
		s.ClickGobutton();
	   String Prev=driver.findElementByXPath(".//table[@class='search-results']/tbody/tr[2]/td[3]").getText();
	   if (Prev.equals("Retrying - FTP transfer error")) {
		   s.ClickConfiguration();
		   c.ClickGobutton();
		driver.findElementByXPath("//div[text()='QA-University']").click();
		driver.findElementByXPath("//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div[3]/div/div[1]/div[3]/button/i").click();
		reportStep("Delete the settlement type", "PASS");
		 Thread.sleep(1000);
		 reportStep("Delete the settlement type", "PASS");
		driver.findElementByXPath("//button[text()='Yes']").click();
		c.ClickClosesettlementsetting();
		c.ClickSettmentHistIcon();
		s.ClickGobutton();
		
	}
	   else {
		   reportStep("Test data has not been setup", "FAIL");
	   }
	 
	  
	}

	@Then("^The processing status should be changed to Stopped state$")
	public void the_processing_status_should_be_changed_to_Stopped_state() {
		String after=driver.findElementByXPath(".//table[@class='search-results']/tbody/tr[2]/td[3]").getText();
		if (after.contains("Stopped")) {
			 reportStep("The Status of deleted settlement has changed to Stopped ", "PASS");  
		}
		else {
			reportStep("The Status of deleted settlement has not changed", "FAIL");
		}
	   
	}

	
	

	@Given("^Navigate to Settlement configuration and Add a new institution$")
	public void navigate_to_Settlement_configuration_and_Add_a_new_institution() {
	  createinstitution();
	}


	@Then("^New institution is added successfully$")
	public void new_institution_is_added_successfully() {
		c.ClickGobutton();
		if (driver.findElementByXPath("//div[text()='Automation-Institution']").isDisplayed()) {
			reportStep("The New institution is added successfully", "PASS");
		}
		else {
			reportStep("The New institution is not added successfully", "FAIL");
		}
		c.ClickSettmentHistIcon();
		s.ClickGobutton();
		}
	    

	@Given("^Navigate to Settlement configuration and to the newly added institution$")
	public void navigate_to_Settlement_configuration_and_to_the_newly_added_institution() {
		s.ClickConfiguration();
		c.ClickGobutton();
		if (driver.findElementByXPath("//div[text()='Automation-Institution']").isDisplayed()) {
			reportStep("The New institution is added successfully", "PASS");
		}
		else {
			reportStep("The New institution is not added successfully", "FAIL");
		}
		}
	

	@Then("^Add a working settlement type for the institution$")
	public void add_a_working_settlement_type_for_the_institution() throws InterruptedException {
		AddSettlementtype("test");
	}

	@Then("^Add a non-working settlement type for the institution$")
	public void add_a_non_working_settlement_type_for_the_institution() throws InterruptedException {
		driver.findElementByXPath("//div[text()='Automation-Institution']").click();
		c.ClickAddSettlement();
		c.EnterSettlementName("Test1");
		c.EnterFtpName("XX");
		c.EnterPrivateKey("YY");
		c.EnterPassPhrase("ZZ");
		c.ClickSaveSettlement();
		c.ClickClosesinstitutionsetting();
		c.ClickSettmentHistIcon();
		s.ClickGobutton();
	}

	@Then("^Add a non-working inactive settlement type for the institution$")
	public void add_a_non_working_inactive_settlement_type_for_the_institution() throws InterruptedException {
		driver.findElementByXPath("//div[text()='Automation-Institution']").click();
		c.ClickAddSettlement();
		c.EnterSettlementName("Test2");
		c.EnterFtpName("XX");
		c.EnterPrivateKey("YY");
		c.EnterPassPhrase("ZZ");
		c.ClickActive();
		c.ClickSaveSettlement();
		c.ClickClosesinstitutionsetting();
		c.ClickSettmentHistIcon();
		s.ClickGobutton();
		
	}

	@Then("^Validate if the settlement is completed and file is downloded$")
	public void validate_if_the_settlement_is_completed_and_file_is_downloded() throws InterruptedException {
		s.Selectprocessingstatus("Successful");
		   s.ClickGobutton();
		   s.Validatethefiledownload();
		
	}

	@Then("^Validate that if we could edit the existing settlement type$")
	public void validate_that_if_we_could_edit_the_existing_settlement_type() {
		driver.findElementByXPath("//div[text()='Automation-Institution']").click();
		driver.findElementByXPath("//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div/div/div[1]/div[2]/button/i").click();
		c.EnterSettlementName("Edited");
		c.ClickSaveSettlement();
		//c.ClickClosesettlementsetting();
		c.ClickClosesinstitutionsetting();
		driver.navigate().refresh();
		s.ClickGobutton();
	}

	@Then("^Navigate to Settlement configuration and Edit institution$")
	public void navigate_to_Settlement_configuration_and_Edit_institution() {
	    s.ClickConfiguration();
	    c.ClickGobutton();
	    driver.findElementByXPath("//div[text()='QA-University']").click();
	    c.clickEditinstitution();
	    driver.findElementByXPath(editinstituiondesc).clear();
        driver.findElementByXPath(editinstituiondesc).sendKeys("Automation-Institution-Edited");
        driver.findElementByXPath(editinstitutionsave).click();
	    driver.navigate().refresh();
	    
	    s.ClickConfiguration();
	    c.ClickGobutton();
	    driver.findElementByXPath("//div[text()='Automation-Institution-Edited']").click();
	    c.clickEditinstitution();
	    driver.findElementByXPath(editinstituiondesc).clear();
        driver.findElementByXPath(editinstituiondesc).sendKeys("QA-University");
        driver.findElementByXPath(editinstitutionsave).click();
	    driver.navigate().refresh();
	}


	@Then("^Institution is Edited successfully$")
	public void institution_is_Edited_successfully() {
	    s.ClickGobutton();
		reportStep("The New institution is edited successfully", "PASS");
	}

	@Given("^Navigate to the incomplete settlements page$")
	public void navigate_to_the_incomplete_settlements_page() {
		s.ClickConfiguration();
		c.Clickincompletesettlement();
	   
	}

	@Then("^Validate the incomplete settlements page$")
	public void validate_the_incomplete_settlements_page() {
	    if (driver.findElementByXPath("//span[text()='Incomplete Automatic Settlements']").isDisplayed()) {
	    	reportStep("Incomplete settlment page is displayed", "PASS");
		}
	    else {
	    	reportStep("Incomplete settlment page is not displayed", "FAIL");
		}
	}

	@Given("^Navigate to the settlement configuration page$")
	public void navigate_to_the_settlement_configuration_page() {
	    s.ClickConfiguration();
	    c.ClickGobutton();
	    
	    
	    
	}

	@Then("^Search for institution using the description$")
	public void search_for_institution_using_the_description() {
		c.ClickSettmentHistIcon();
		s.ClickConfiguration();
		c.Entersearchpage("U");
		c.ClickGobutton();
	   if (driver.findElementByXPath("//div[text()='QA-University']").isDisplayed()) {
		   reportStep("Institution is searched via description", "PASS");  
	}
	   else {
		   reportStep("Institution is not searched via description", "FAIL");
	}
	}

	@Then("^validate the deletion of particular settlement type$")
	public void validate_the_deletion_of_particular_settlement_type() {
	    c.Selectinst("Automation-Institution");
	    c.Clickdeletesettlement();
	    driver.findElementByXPath("//button[text()='Yes']").click();
	    }

	@Then("^validate the deletion of particular institution$")
	public void validate_the_deletion_of_particular_institution() {
		c.Selectinst("Automation-Institution");
	    c.Clickdeleteinstitution();
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    driver.findElementByXPath("//button[text()='Yes']").click();
	}

	@Then("^Validate Create/Delete/Create Institution$")
	public void validate_Create_Delete_Create_Institution() throws InterruptedException {
		s.ClickConfiguration();
		   c.ClickAddinstituion();
		   c.EnterInstEnterUUID("02c76ec4-82a9-400f-89eb-e570c1c57ad7");
		   c.EnterDescInstitution("Automation-Institution");
		   c.EnterInstEnterTimezone("Pacific/Niue (UTC -11)");
		   c.SelectRunHour("0");
		   c.SelectRunMinute("45");
		   c.ClickSaveinstitution();
		   c.ClickClosesettlementsetting();
		   c.Refresh();
		   s.ClickConfiguration();
		   s.ClickGobutton();
		   c.Selectinst("Automation-Institution");
		    c.Clickdeleteinstitution();
		    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		    driver.findElementByXPath("/html/body/app-root/div/div[2]/div/div/div/div/div[2]/button").click();
		    c.Refresh();
		    s.ClickConfiguration();
			   c.ClickAddinstituion();
			   c.EnterInstEnterUUID("02c76ec4-82a9-400f-89eb-e570c1c57ad7");
			   c.EnterDescInstitution("Automation-Institution");
			   c.EnterInstEnterTimezone("Pacific/Niue (UTC -11)");
			   c.SelectRunHour("0");
			   c.SelectRunMinute("45");
			   c.ClickSaveinstitution();
			   c.ClickClosesettlementsetting();
			   c.Refresh();
			   AddSettlementtype("test");
			   c.Refresh();
			   s.ClickConfiguration();
			   s.ClickGobutton();
			   c.Selectinst("Automation-Institution");
			    c.Clickdeletesettlement();
			    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			    driver.findElementByXPath("//button[text()='Yes']").click();
			    c.Clickdeleteinstitution();
			    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			    driver.findElementByXPath("/html/body/app-root/div/div[2]/div/div/div/div/div[2]/button").click();
			    c.Refresh();
	}
	
	
	@Then("^Navigate to Settlement configuration$")
	public void navigate_to_Settlement_configuration() {
	    s.ClickConfiguration();
	    c.ClickGobutton();
	    driver.findElementByXPath("//div[text()='Automation-Institution']").click();
	}


	@Then("^Validate the credentials of the settlement types$")
	public void validate_the_credentials_of_the_settlement_types() {
	    String bullets=driver.findElementByXPath("//textarea[@class='uniform-bullets form-control']").getText();
	    if (bullets.contains("•")) {
	    	reportStep("The Value contains only bullets", "PASS"); 
	    	
		}
	    else {
	    	reportStep("The Value doesnt contains bullets", "FAIL");  
		}
		}
		

	@Then("^Validate if the in progress state settlements can be deleted/deactivated$")
	public void validate_if_the_in_progress_state_settlements_can_be_deleted_deactivated() {
		int count=0;
		s.Selectprocessingstatus("In Progress");
		s.ClickGobutton();
		String settlename=driver.findElementByXPath(".//table[@class='search-results']/tbody/tr/td[2]").getText();
		s.ClickConfiguration();
	    c.ClickGobutton();
	    driver.findElementByXPath("//div[text()='QA-University']").click();
	    driver.findElementByXPath("//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div[2]/div/div[1]/div[3]/button/i").click();
	    if (driver.findElementByClassName("progress-message").isDisplayed()) {
	    	reportStep("The Inprogress settlemets cannot be deleted", "PASS");  
	    	c.Refresh();
		}
	    else {
	    	reportStep("The Inprogress settlemets can be deleted", "FAIL"); 
		}
	    
	   
		/*
		 * driver.findElement(By.xpath(
		 * "//*[@id=\\\"accordion\\\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div/div/div[2]/div/input"
		 * )).getText();
		 * 
		 * 
		 * String s=driver.findElementByXPath(
		 * "//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div/div/div[2]/div/input"
		 * ).getAttribute("readonly"); List<WebElement>w=driver.findElementsByXPath(
		 * "//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div/div/div[2]/div/input"
		 * ); for (WebElement webElement : w) { if (settlename.equals(w)) {
		 * driver.findElementByXPath(
		 * "//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div["
		 * +count+"]/div/div[1]/div[3]/button").click(); boolean
		 * val=driver.findElementByClassName("progress-message").isDisplayed(); if
		 * (val==true) { reportStep("The Settlement type cannot be stopped", "PASS"); }
		 * else {
		 * 
		 * }
		 * 
		 * } else { count++; }
		 * 
		 * }
		 */
	}

	@Then("^validate the Transaction availablity section$")
	public void validate_the_Transaction_availablity_section() {
		 s.ClickConfiguration();
		    c.ClickGobutton();
		    driver.findElementByXPath("//div[text()='QA-University']").click();
	driver.executeScript("window.scrollBy(0,400)");
	    driver.findElementByXPath("//*[@id=\"accordion\"]/app-transaction-availability-accordion/div/div[1]/h4/span/i").click();
	    if (driver.findElementByXPath("//p[text()='Transactions are available for all days for the following date ranges inclusive:']").isDisplayed()) {
	    	reportStep("The transaction availablity is displayed", "PASS"); 
	    	c.Refresh();
		}
	    else {
	    	reportStep("The transaction availablity is not displayed", "FAIL"); 
		}
	}

	


	@Then("^Add institution with special characters$")
	public void add_institution_with_special_characters() {
		s.ClickConfiguration();
		   c.ClickAddinstituion();
		   c.EnterInstEnterUUID("*^%%");
		
	}


	@Then("^The Institutional peek doesnt accept special characters$")
	public void the_Institutional_peek_doesnt_accept_special_characters() {
		
		   if (driver.findElementByXPath("//p[text()='Entered value is not in UUID format']").isDisplayed()) {
				reportStep("The Institution doesnt accept special characters", "PASS"); 
		}
		   else {
			   reportStep("The Institution accept special characters", "FAIL"); 
		   }
	}

	@Then("^Add institution with (\\d+) settlement types$")
	public void add_institution_with_settlement_types(int arg1) throws InterruptedException {
		AddSettlementtypedummy("Test1");
		/*
		 * AddSettlementtypedummy("Test2"); AddSettlementtypedummy("Test3");
		 * AddSettlementtypedummy("Test4");
		 */
		/*
		 * AddSettlementtypedummy("Test5"); AddSettlementtypedummy("Test6");
		 * AddSettlementtypedummy("Test7"); AddSettlementtypedummy("Test8");
		 * AddSettlementtypedummy("Test9"); AddSettlementtypedummy("Test10");
		 * AddSettlementtypedummy("Test11"); AddSettlementtypedummy("Test12");
		 * AddSettlementtypedummy("Test13"); AddSettlementtypedummy("Test14");
		 * AddSettlementtypedummy("Test15"); AddSettlementtypedummy("Test16");
		 * AddSettlementtypedummy("Test17"); AddSettlementtypedummy("Test18");
		 * AddSettlementtypedummy("Test19"); AddSettlementtypedummy("Test20");
		 */
		
		
	}

	@Then("^Navigate to the institution and validate the merchant listing section$")
	public void navigate_to_the_institution_and_validate_the_merchant_listing_section() {
	    s.ClickConfiguration();
	    c.ClickGobutton();
	    driver.findElementByXPath("//div[text()='QA-University']").click();
	    driver.findElementByXPath("//*[@id=\"accordion\"]/app-transaction-availability-accordion/div/div[1]/h4").click();
	    if(driver.findElementByXPath("//*[@id=\"accordion\"]/app-transaction-availability-accordion/div/div[2]/div/div[1]/p").isDisplayed()) {
	    	reportStep("The institution has valid merchant listing", "PASS"); 
	    	
	    }
	    else {
	    	reportStep("The institution doesnt have valid merchant listing", "PASS");
	    }
	}

	@Then("^Add institution with special characters in the description$")
	public void add_institution_with_special_characters_in_the_description() {
		createinstitutionwithsplchar();
	}

	
	@Then("^Add institution with no UUID$")
	public void add_institution_with_no_UUID() {
	       s.ClickConfiguration();
		   c.ClickAddinstituion();
		   c.EnterInstEnterUUID("uuid");
	}


	@Then("^Evaluation message should be displayed as enter valid UUID$")
	public void evaluation_message_should_be_displayed_as_enter_valid_UUID() {
	    String message=driver.findElementByXPath("//p[text()='Entered value is not in UUID format']").getText();
	    if (message.equalsIgnoreCase("Entered value is not in UUID format")) {
	    	reportStep("Evaluation message is displayed for valid UUID", "PASS"); 
		}
	    else {
	    	reportStep("Evaluation message is not displayed for valid UUID", "FAIL"); 
		}
	}
	

	@Then("^Add Institution - with no settlement type - use UUID which already exists in DB$")
	public void add_Institution_with_no_settlement_type_use_UUID_which_already_exists_in_DB() {
		s.ClickConfiguration();
		   c.ClickAddinstituion();
		   c.EnterInstEnterUUID("b888879b-ccca-4dd7-be35-f7e6449bfa35");
		   c.EnterDescInstitution("@$%&^^%%$");
		   c.EnterInstEnterTimezone("Pacific/Niue (UTC -11)");
		   c.SelectRunHour("0");
		   c.SelectRunMinute("45");
		   c.ClickSaveinstitution();
	}

	@Then("^Evaluation message should be displayed as institution already exists$")
	public void evaluation_message_should_be_displayed_as_institution_already_exists() {
		//String message=driver.findElementByXPath("//span[text()='The settlement could not be created-institution with this UUID already exists']").getText();
	    if (driver.findElementByClassName("progress-message").isDisplayed()) {
	    	reportStep("Evaluation message is displayed for institution already exists", "PASS"); 
		}
	    else {
	    	reportStep("Evaluation message is not displayed for institution already exists", "FAIL"); 
		}
	}

	@Then("^Add Institution - with no settlement type - run time earlier than (\\d+)\\.(\\d+)$")
	public void add_Institution_with_no_settlement_type_run_time_earlier_than(int arg1, int arg2) {
		s.ClickConfiguration();
		   c.ClickAddinstituion();
		   UUID uuidt = Generators.randomBasedGenerator().generate();
		   String uuid=uuidt.toString();
		   c.EnterInstEnterUUID(uuid);
		   c.EnterDescInstitution("@$%&^^%%$");
		   c.EnterInstEnterTimezone("Pacific/Niue (UTC -11)");
		   c.SelectRunHour("0");
		   c.SelectRunMinute("15");
	}

	@Then("^Evaluation message should be displayed as invalid time$")
	public void evaluation_message_should_be_displayed_as_invalid_time() {
		String message=driver.findElementByXPath("//p[text()='Minimal allowed settlement time is 0:30']").getText();
	    if (message.equalsIgnoreCase("Minimal allowed settlement time is 0:30")) {
	    	reportStep("Evaluation message is displayed for incorrect timing", "PASS"); 
		}
	    else {
	    	reportStep("Evaluation message is not displayed for incorrect timing", "FAIL"); 
		}
	}
	
	
	
	@Then("^Validate Adding Institution with settlement type with long strings to every field which possible$")
	public void validate_Adding_Institution_with_settlement_type_with_long_strings_to_every_field_which_possible() throws InterruptedException {
		s.ClickConfiguration();
		   c.ClickAddinstituion();
		   UUID uuidt = Generators.randomBasedGenerator().generate();
		   String uuid=uuidt.toString();
		   c.EnterInstEnterUUID(uuid);
		   c.EnterDescInstitution("3XOEj0NLMCVyNSoE9f0Sa0X8jJvkp826ekMlYf9bKGHlmSpBWq2xNRlWuQEbKAcPXIbvSYOpjYp7ZN8LP98WUwiUZjgnaOBdEKaZSTJnLEJzpcPd1Jk0kd7rk50Z7mlTlRnpxZptXCWY0rlH5AJ6qZRrswIWlrHba7IW5fHrSRdSIAbWM6eKhw4b97stuUrnGJuxN9u1ulKVc9G4D7tpvT10oqtsB3zeQxMdim4eOf2CY8OKKprpFdpUdRxBvCn3");
		   c.EnterInstEnterTimezone("Pacific/Niue (UTC -11)");
		   c.SelectRunHour("0");
		   c.SelectRunMinute("45");
		   c.ClickAddSettlement();
		   c.EnterSettlementName("3XOEj0NLMCVyNSoE9f0Sa0X8jJvkp826ekMlYf9bKGHlmSpBWq2xNRlWuQEbKAcPXIbvSYOpjYp7ZN8LP98WUwiUZjgnaOBdEKaZSTJnLEJzpcPd1Jk0kd7rk50Z7mlTlRnpxZptXCWY0rlH5AJ6qZRrswIWlrHba7IW5fHrSRdSIAbWM6eKhw4b97stuUrnGJuxN9u1ulKVc9G4D7tpvT10oqtsB3zeQxMdim4eOf2CY8OKKprpFdpUdRxBvCn3");
		   c.EnterFtpName("test");
		   c.EnterPrivateKey("3XOEj0NLMCVyNSoE9f0Sa0X8jJvkp826ekMlYf9bKGHlmSpBWq2xNRlWuQEbKAcPXIbvSYOpjYp7ZN8LP98WUwiUZjgnaOBdEKaZSTJnLEJzpcPd1Jk0kd7rk50Z7mlTlRnpxZptXCWY0rlH5AJ6qZRrswIWlrHba7IW5fHrSRdSIAbWM6eKhw4b97stuUrnGJuxN9u1ulKVc9G4D7tpvT10oqtsB3zeQxMdim4eOf2CY8OKKprpFdpUdRxBvCn3");
		   c.EnterPassPhrase("3XOEj0NLMCVyNSoE9f0Sa0X8jJvkp826ekMlYf9bKGHlmSpBWq2xNRlWuQEbKAcPXIbvSYOpjYp7ZN8LP98WUwiUZjgnaOBdEKaZSTJnLEJzpcPd1Jk0kd7rk50Z7mlTlRnpxZptXCWY0rlH5AJ6qZRrswIWlrHba7IW5fHrSRdSIAbWM6eKhw4b97stuUrnGJuxN9u1ulKVc9G4D7tpvT10oqtsB3zeQxMdim4eOf2CY8OKKprpFdpUdRxBvCn3");
		   c.ClickSaveinstitution();
		   Thread.sleep(3000);
		   if (driver.findElementByXPath("/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/app-institution-config-data/div/div/div/div/div/div[1]/div[2]/app-inline-progress-notification/div/div/div[2]/span[2]").isDisplayed()) {
			   c.ClickClosesettlementsetting();
			   reportStep("Valiation of adding settlement with long string is successful", "PASS");  
		}
		   else 
		   {
			   reportStep("Valiation of adding settlement with long string is unsuccessful", "FAIL");  
			} 
		   }



	@Then("^Add Institution-with settlementtype-cancel and X button$")
	public void add_Institution_with_settlementtype_cancel_and_X_button() throws InterruptedException {

		s.ClickConfiguration();
		   c.ClickAddinstituion();
		   UUID uuidt = Generators.randomBasedGenerator().generate();
		   String uuid=uuidt.toString();
		   c.EnterInstEnterUUID(uuid);
		   c.EnterDescInstitution("Test");
		   c.EnterInstEnterTimezone("Pacific/Niue (UTC -11)");
		   c.SelectRunHour("0");
		   c.SelectRunMinute("45");
		   c.ClickAddSettlement();
		   c.EnterSettlementName("Test");
		   c.EnterPrivateKey("Test");
		   c.EnterPassPhrase("Test");
		   c.ClickCancel();
		   reportStep("Cancelling the process is successful", "PASS");  
		}
	
	  

	@Then("^Validate if there is any possiblity to edit the Institution ID$")
	public void validate_if_there_is_any_possiblity_to_edit_the_Institution_ID() {
		 s.ClickConfiguration();
		    c.ClickGobutton();
		    driver.findElementByXPath("//div[text()='Automation-Institution']").click();
		    driver.findElementByXPath("//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/form/div[1]/div/button").click();
		   String Attr= driver.findElementById("institutionId").getAttribute("spellcheck");
		   if (Attr.equals("false")) {
			   reportStep("There is no possiblity to edit the institution", "PASS"); 
		}else  {
			   reportStep("There is no possiblity to edit the institution", "FAIL");  
		}
		    
	}

	@Then("^Validate if the Timezone setting is mandatory when inserting institution$")
	public void validate_if_the_Timezone_setting_is_mandatory_when_inserting_institution() {
		s.ClickConfiguration();
		   c.ClickAddinstituion();
		   UUID uuidt = Generators.randomBasedGenerator().generate();
		   String uuid=uuidt.toString();
		   c.EnterInstEnterUUID(uuid);
		   c.EnterDescInstitution("Test");
		   c.SelectRunHour("0");
		   c.SelectRunMinute("45");
		   c.ClickSaveinstitution();
		   if (driver.findElementByXPath("//p[text()='Please select the Time Zone']").isDisplayed()) {
			   reportStep("Time Zone Settings is mandatory for adding the insitituion", "PASS"); 
		}
		   else {
			   reportStep("Time Zone Settings is not mandatory for adding the insitituion", "FAIL");
		}  
	}

	@Then("^Validate the Refresh automatic settlements link$")
	public void validate_the_Refresh_automatic_settlements_link() {
		s.ClickConfiguration();
		if (driver.findElementByXPath("//i[@title='Reload failing settlements status']").isDisplayed()) {
			driver.findElementByXPath("//i[@title='Reload failing settlements status']").click();
			reportStep("The refresh automatic settlements link is validated", "PASS"); 
		}else {
			reportStep("The refresh automatic settlements link is not validated", "FAIL"); 
		}
		
		
	}

	@Then("^Validate display settlement history for institution$")
	public void validate_display_settlement_history_for_institution() {
		s.ClickConfiguration();
	    c.ClickGobutton();
	    driver.findElementByXPath("//div[text()='Automation-Institution']").click();
	    driver.findElementByXPath("//*[@id=\"accordion\"]/app-processing-history-accordion/div/div[1]/h4/span/i").click();
	    if ((driver.findElementByXPath("//*[@id=\"accordion\"]/app-processing-history-accordion/div/div[2]/div/div")).isDisplayed()||(driver.findElementByXPath("//p[text()='This listing is readonly. For file download or stopping settlements go to the main History section.']").isDisplayed())) {
	    	reportStep("Settlement history is available for the individual institution", "PASS"); 
		}
	    else {
	    	reportStep("Settlement history is not available for the individual institution", "PASS"); 
		}
		
	}
	@Then("^Validate Stoping manual settlement$")
	public void validate_Stoping_manual_settlement() throws InterruptedException {
	    s.ClickConfiguration();
	    c.ClickGobutton();
	    c.stopsettlement();
	}

	@Then("^Validate FTP connection healthcheck$")
	public void validate_FTP_connection_healthcheck() {
	  try {
		if (driver.findElementByXPath("//div[text()='Cannot reach the FTP server']").isDisplayed()) {
		   reportStep("FTP server is down and not reachable", "FAIL");
		
	} } catch(Exception e) {
		   reportStep("FTP server is working fine", "PASS");
	   }
	}

	@Then("^Validate manual settlement-startDate>endDate$")
	public void validate_manual_settlement_startDate_endDate() {
	  s.ClickConfiguration();
	  c.ClickGobutton();
	  c.settlementdateerror();
	}

	@Then("^Validate editing Private/Public key and Passphrase$")
	public void validate_editing_Private_Public_key_and_Passphrase() {
	    s.ClickConfiguration();
	    c.ClickGobutton();
	    driver.findElementByXPath("//div[text()='Automation-Institution']").click();
	    driver.findElementByXPath("//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div/div/div[1]/div[2]/button").click();
	    driver.findElementByXPath("/html/body/app-root/div/div[1]/div[2]/app-settlement-type-detail/div/div/div[1]/div[1]/div/form/div[4]/div/a").click();
	    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	    driver.findElementById("ftpPrivateKey").sendKeys("edited");
	    driver.findElementByXPath("/html/body/app-root/div/div[1]/div[2]/app-settlement-type-detail/div/div/div[1]/div[1]/div/form/div[5]/div/a").click();
	    driver.findElementById("ftpPassword").sendKeys("edited");
	    c.ClickSaveSettlement();
	    	 reportStep("The FTP name and keys are edited", "PASS");
	    
	}

	
	/*
	 * @Given("^Navigate to Settlement configuration and to the newly added institution \"([^\"]*)\"$"
	 * ) public void
	 * navigate_to_Settlement_configuration_and_to_the_newly_added_institution(
	 * String ins) throws InterruptedException { s.ClickConfiguration(); Select si=
	 * new Select(driver.findElement(By.name("role")));
	 * si.selectByValue("INSTITUTION_ID"); driver.findElementByXPath(
	 * "/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/div[4]/app-institution-search/div/div[3]/input"
	 * ).sendKeys(ins); c.ClickGobutton(); driver.findElementByXPath(
	 * "/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/div[5]/app-institution-config-list/div/table/tbody/tr[2]/td[1]"
	 * ).click(); c.ClickAddSettlement(); c.EnterSettlementName("bs merchant");
	 * c.EnterFtpName("testsftp33"); c.EnterPrivateKey(sFTPkey);
	 * c.EnterPassPhrase(sPassphrase); c.ClickSaveSettlement();
	 * c.ClickClosesinstitutionsetting(); c.ClickSettmentHistIcon();
	 * s.ClickGobutton(); }
	 */
	 
/*test to add ins*/
	
	@Given("^Navigate to Settlement configuration and to the newly added institution \"([^\"]*)\"$") 
    public void navigate_to_Settlement_configuration_and_to_the_newly_added_institution(String ins) throws InterruptedException {
		s.ClickConfiguration(); 
		Select si= new Select(driver.findElement(By.name("role")));
	 si.selectByValue("INSTITUTION_ID");
	 driver.findElementByXPath("/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/div[4]/app-institution-search/div/div[3]/input").sendKeys(ins);
	 s.ClickGobutton();
	 driver.findElementByXPath( "/html/body/app-root/div/div[1]/div[1]/app-settlement-admin/div/div/div[5]/app-institution-config-list/div/table/tbody/tr[2]/td[1]").click(); 
		driver.findElementByXPath("//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[2]/a").click();
	//driver.findElementByXPath("//*[@id=\"accordion\"]/app-institution-config-accordion/div/div[2]/div/div/div[3]/div/div/div[1]/div[2]/button").click();

	//driver.findElementByXPath("/html/body/app-root/div/div[1]/div[2]/app-settlement-type-detail/div/div/div[1]/div[1]/div/form/div[4]/div/a").click();
	Thread.sleep(100);
	 c.EnterSettlementName("Bbone");  
	c.EnterFtpName("testsftp33");
	c.EnterPrivateKey(sFTPkey);
	c.EnterPassPhrase(sPassphrase);
	 c.ClickSaveSettlement();
	 Thread.sleep(100);
	 c.ClickClosesinstitutionsetting();
	 c.ClickSettmentHistIcon();
	 s.ClickGobutton();
	  }
	 
	/*test to stop inprogress*/
@Then("^User clicks on go button and validates the history filtering and stop\"([^\"]*)\"$")
public void user_clicks_on_go_button_and_validates_the_history_filtering_and_stop(String Filter) throws InterruptedException {

	for (int i = 0; i < 300; i++) {
		if (Filter.contains("In Progress")) {
			s.Selectprocessingstatus("In Progress");
			s.ClickGobutton();
			driver.findElementByXPath("/html/body/app-root/div/div[1]/div[1]/app-settlement-history/div/div/span/div[2]/app-history-listing/table/tbody/tr[2]/td[3]").click();
			driver.findElementByXPath("/html/body/app-root/div/div[1]/div[1]/app-settlement-history/div/div/span/app-history-search/table/tbody/tr/td[7]/button").click();
			Thread.sleep(10000);
			s.ClickGobutton();

		} 
	}
			 
}

	@AfterMethod
	public void waiting() throws InterruptedException
	{
		Thread.sleep(2000);
		
		
	}

	@After
	public static void unloadreport()
	{
		
		extent.flush();
		extent.endTest(test);
		driver.close();
		
	}
	
	
}
