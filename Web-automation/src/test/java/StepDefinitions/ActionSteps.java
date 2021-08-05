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

public class ActionSteps {
	
	WebDriver driver=null;
	String image= "C:\\Users\\BADR\\Pictures\\communciation.png";
	String link= "https://www.google.com/";
	String document="C:\\Users\\BADR\\Documents\\1811498_KHAOUDI_BADR_infos.pdf";

	@Given("Doing a random actions to contents")
	public void browser_is_open() {
		System.out.println("Inside Step -Browser is open");
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver1.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	}
	
	@And("user is on the loginPage")
	public void user_is_on_login_page() {
		driver.navigate().to("https://sysadmin.inspheris.net/");
	}
	
	@When("user enters the username & the password")
	public void user_enters_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("user2");
		driver.findElement(By.id("password")).sendKeys("HGTj5h52Buv?");
	}
		
	@When("clicks on the loginButton")
	public void clicks_on_login_button() {
		driver.findElement(By.name("f")).submit();
	}
	
	@Then("user on homePage")
	public void home_page() {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	}
	
	@When("user likes a content")
	public void liking_content() {
		driver.findElement(By.xpath("//div[@ng-click=\"addLike(tpl_feedid);\"]")).click();
	}
	
	@When("user comments content with text only")
	public void commenting_content_text() {
		
		driver.findElement(By.xpath("//div[@ng-click=\"showCommentBox(feed,showFullComments)\"]")).click();
		driver.findElement(By.xpath("//textarea[@ng-model=\"commentData.text\"]")).sendKeys("test commenting with text only");
		driver.findElement(By.xpath("//div[@ng-click=\"addComment(feedindex, feed.uid);\"]")).click();
	}
	
	@When("user comments content with an image")
	public void commenting_content_image() throws AWTException {
		
		driver.findElement(By.xpath("//div[@ng-click=\"showCommentBox(feed,showFullComments)\"]")).click();
		driver.findElement(By.xpath("//textarea[@ng-model=\"commentData.text\"]")).sendKeys("test commenting with an image");
		driver.findElement(By.xpath("//div[@ng-click=\"addImageGallery()\"]")).click();

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
		
		driver.findElement(By.xpath("//div[@ng-click=\"addComment(feedindex, feed.uid);\"]")).click();		
		
	}
	
	@When("user comments content with a document")
	public void commenting_content_document() throws AWTException {
		
		driver.findElement(By.xpath("//div[@ng-click=\"showCommentBox(feed,showFullComments)\"]")).click();
		driver.findElement(By.xpath("//textarea[@ng-model=\"commentData.text\"]")).sendKeys("test commenting with a document");
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
		
		driver.findElement(By.xpath("//div[@ng-click=\"addComment(feedindex, feed.uid);\"]")).click();		
		
	}	
	
	@When("user comments content with a link")
	public void commenting_content_link() {
		
		driver.findElement(By.xpath("//div[@ng-click=\"showCommentBox(feed,showFullComments)\"]")).click();
		driver.findElement(By.xpath("//textarea[@ng-model=\"commentData.text\"]")).sendKeys("test commenting with a document");
		
		driver.findElement(By.xpath("//div[@ng-click=\"addLinkEmbed()\"]")).click();
		driver.findElement(By.xpath("div[@ng-click=\"$ctrl.onClick($index)\"]")).click();
		driver.findElement(By.xpath("//input[@ng-model=\"linkEmbed\"]")).sendKeys(link);
		driver.findElement(By.xpath("//div[@class=\"ins_btn_ctext\"]")).click();
		
		driver.findElement(By.xpath("//div[@ng-click=\"addComment(feedindex, feed.uid);\"]")).click();	
	}
			

}
