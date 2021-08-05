package StepDefinitions;

import static org.junit.Assert.assertEquals;

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

public class ArticleSteps {

	WebDriver driver=null;
	String image= "C:\\Users\\BADR\\Pictures\\communciation.png";
	String document="C:\\Users\\BADR\\Documents\\1811498_KHAOUDI_BADR_infos.pdf";

	@Given("Adding an article")
	public void browser_is_open() {
		System.out.println("Inside Step -Browser is open");
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver1.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	}
	
	@And("user is on the login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://sysadmin.inspheris.net/");
	}
	
	@When("user enters the username and the password")
	public void user_enters_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("user2");
		driver.findElement(By.id("password")).sendKeys("HGTj5h52Buv?");
	}
		
	@When("clicks on the login button")
	public void clicks_on_login_button() {
		driver.findElement(By.name("f")).submit();
	}
	
	@Then("user on the home page")
	public void home_page() {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	}
	
	@When("clicks on the add content button")
	public void clicks_on_add_content_button() {
		driver.findElement(By.xpath("//div[@class='btn btn-default dropdown-toggle create']")).click();
	}
	
	@When("clicks on the add new content")
	public void clicks_on_add_new_content() {
		driver.findElement(By.xpath("//div[@class='noti_li']")).click();
	}
	
	@When("clicks on add article")
	public void clicks_on_add_article() {
		driver.findElement(By.xpath("//a[@class='navwitc_a']")).click();
	}
	
	@When("add the article title & subtitle")
	public void add_article_title_subtitle() {
		driver.findElement(By.xpath("//input[@ng-model='headingBlock.title']")).sendKeys("test adding a new article");
		driver.findElement(By.xpath("//input[@ng-model='headingBlock.subTitle']")).sendKeys("test adding a new article subtitle");
		
	}
	
	@When("add the community content")
	public void add_community_content() {
		driver.findElement(By.xpath("//div[@class=\"ins_btn_licon width100 ng-scope\"]")).click();
		driver.findElement(By.xpath("//div[@ng-click=\"toggleCommSelection(community)\"]")).click();
		driver.findElement(By.xpath("//div[@ng-click=\"closeThisDialog({flag: 'ok', data: commSelection})\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"btn btn-default ng-binding\"]")).click();
		driver.findElement(By.xpath("//label[@for='cctbsel0_1']")).click();
		driver.findElement(By.xpath("//button[@class=\"btn btn-default ng-binding\"]")).click();
	}
	
	@When("add article text content")
	public void add_article_text_content() throws AWTException {
		
		Robot robot=new Robot();
		StringSelection stringSelection=new StringSelection("test article text content");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
	@When("add a document to the article")
	public void adding_a_document() throws AWTException {
		driver.findElement(By.xpath("//a[@once-text=\"'Documents' | translate\"]")).click();
		driver.findElement(By.xpath("//div[@ng-model=\"logoFiles\"]")).click();
		Robot robot=new Robot();
		
		StringSelection stringSelection=new StringSelection(document);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(1000);
		
		driver.findElement(By.xpath("//button[@ng-click=\"closeThisDialog('ok')\"]")).click();
		
	}
	
	@Then("submitting the article form")
	public void submitting_article_form() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@ng-click=\"publishArticle('publish')\"]")).click();
	}
	
}