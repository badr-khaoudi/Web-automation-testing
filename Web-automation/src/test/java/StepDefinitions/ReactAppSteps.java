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
import io.cucumber.java.en.When;

public class ReactAppSteps {

	WebDriver driver=null;
	String image= "C:\\Users\\BADR\\Pictures\\communciation.png";
	String link= "https://www.google.com/";
	String document="C:\\Users\\BADR\\Documents\\1811498_KHAOUDI_BADR_infos.pdf";

	@Given("testing the react app")
	public void browser_is_open() {
		System.out.println("Inside Step -Browser is open");
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver1.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		System.setProperty("webdriver.chrome.whitelistedIps", "");
	}
	
	@And("user is on the loginPage of the react app")
	public void user_is_on_login_page() {
		driver.navigate().to("https://testserver.inspheris.net/#!/");
	}
	
	@When("user enters the username & the password to the react app")
	public void user_enters_username_and_password() throws AWTException {
		Robot robot=new Robot();
		StringSelection stringSelection=new StringSelection("user2-v4dev");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.setAutoDelay(1000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		

		
		StringSelection stringSelection1=new StringSelection("4AX4hVH9bW4+");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);
		robot.setAutoDelay(1000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(1000);
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
}
