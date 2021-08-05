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

public class EditingSteps {
	
	WebDriver driver=null;
	String image= "C:\\Users\\BADR\\Pictures\\Capture.png";
	String document="C:\\Users\\BADR\\Documents\\1811498_KHAOUDI_BADR_infos.pdf";

	@Given("Editing a quickpost")
	public void browser_is_open() {
		System.out.println("Inside Step -Browser is open");
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver1.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	}
	
	@And("user is on a login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://sysadmin.inspheris.net/");
	}
	
	@When("user enters both username and password")
	public void user_enters_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("user2");
		driver.findElement(By.id("password")).sendKeys("HGTj5h52Buv?");
	}
		
	@When("clicks on a login button")
	public void clicks_on_login_button() {
		driver.findElement(By.name("f")).submit();
	}
	
	@Then("user on a home page")
	public void home_page() {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	}
	
	@When("user clicks on editing a quickpost with text only")
	public void editing() {
		
		driver.findElement(By.xpath("//div[@ng-click=\"$root.editArticle(feed)\"]")).click();
		driver.findElement(By.xpath("//textarea[@ng-model=\"quickpostData.quickpostDesc\"]")).sendKeys("edited");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@ng-click=\"publishShortArt(caHashTag)\"]")).click();
	}
	
	@When("user clicks on editing a quickpost with an image")
	public void edition_Image() throws AWTException {
		driver.findElement(By.xpath("//div[@ng-click=\"$root.editArticle(feed)\"]")).click();
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
		driver.findElement(By.xpath("//button[@ng-click=\"closeThisDialog('ok')\"]")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@ng-click=\"publishShortArt(caHashTag)\"]")).click();
		
	}
	
	@When("user clicks on editing a quickpost with an folder")
	public void editin_folder() throws AWTException {
		
		driver.findElement(By.xpath("//div[@ng-click=\"$root.editArticle(feed)\"]")).click();
		driver.findElement(By.xpath("//div[@ng-click=\"addDocGallery()\"]")).click();
		driver.findElement(By.xpath("//button[@ng-click=\"closeThisDialog('ok')\"]")).click();
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
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@ng-click=\"publishShortArt(caHashTag)\"]")).click();
		
	}
	
	@Then("Confirm editing an article")
	public void submitting_article_form() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@ng-click=\"publishShortArt(caHashTag)\"]")).click();
		driver.close();
		driver.quit();
	}
	

}
