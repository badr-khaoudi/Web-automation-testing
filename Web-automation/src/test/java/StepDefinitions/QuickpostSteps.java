package StepDefinitions;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuickpostSteps {
	
	WebDriver driver=null;
	String image= "C:\\Users\\BADR\\Pictures\\communciation.png";
	String link= "https://www.google.com/";
	String document="C:\\Users\\BADR\\Documents\\1811498_KHAOUDI_BADR_infos.pdf";

	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step -Browser is open");
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver1.exe");
		System.setProperty("webdriver.chrome.whitelistedIps", "");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	}
	
	@And("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://sysadmin.inspheris.net/");
	}
	
	@When("user enters username and password")
	public void user_enters_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("user2");
		driver.findElement(By.id("password")).sendKeys("HGTj5h52Buv?");
	}
		
	@When("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.name("f")).submit();
	}
	
	@Then("user on home page")
	public void home_page() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	@When("clicks on add content button")
	public void clicks_on_add_content_button() {
		driver.findElement(By.xpath("//div[@class='btn btn-default dropdown-toggle create']")).click();
	}
	
	@When("clicks on add quickpost button")
	public void clicks_on_add_quickpost_button() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@ng-click='$root.openCreateQuickpostPopup()']")).click();
	}
	
	@Then("user on quickpost form")
	public void quickpost_form() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	@When("selects community content type button")
	public void choosing_community_content() {
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@ng-click='selectCommunity()']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@ng-click=\"toggleCommSelection(community)\"]")).click();
		
	}
	
	@When("selected community content")
	public void selecting_community_content() {
		driver.findElement(By.xpath("//div[@ng-click=\"closeThisDialog({flag: 'ok', data: commSelection})\"]")).click();
	}
	
	@When("filling text area")
	public void text_area() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("mainContent")).sendKeys("badr test");
	}
	
	@Then("adding a new picture")
	public void adding_picture() throws AWTException {
		
		driver.findElement(By.xpath("//div[@ng-click='addImageGallery()']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Robot robot=new Robot();
		
		driver.findElement(By.xpath("//div[@ng-model='imgFiles']")).click();
		
		StringSelection stringSelection=new StringSelection(image);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@ng-click=\"closeThisDialog('ok')\"]")).click();
		
	}
	
	@Then("adding a new document")
	public void adding_document() throws AWTException {
		
		driver.findElement(By.xpath("//div[@ng-click=\"addDocGallery()\"]")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Robot robot=new Robot();
		
		driver.findElement(By.xpath("//div[@ng-model=\"logoFiles\"]")).click();
		
		StringSelection stringSelection=new StringSelection(document);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@ng-click=\"closeThisDialog('ok')\"]")).click();
	}
	
	@Then("adding a new external link")
	public void adding_external_link() {
		driver.findElement(By.xpath("//div[@ng-click=\"addLinkEmbed()\"]")).click();
		driver.findElement(By.xpath("//div[@ng-click=\"$ctrl.onClick($index)\"]")).click();
		driver.findElement(By.xpath("//input[@ng-model=\"linkEmbed\"]")).sendKeys(link);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@ng-click=\"done()\"]")).submit();
	}
	
	@Then("submitting the quickpost")
	public void submit_quickpost() {
		driver.findElement(By.xpath("//button[@ng-click='publishShortArt(caHashTag)']")).click();
		driver.close();
		driver.quit();
	}
	
	 @Then("logout")
	 public void logout() {
		 driver.close();
		 driver.quit();
	 }
}
