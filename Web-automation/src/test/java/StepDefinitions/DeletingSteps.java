package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeletingSteps {

	WebDriver driver=null;
	String image= "C:\\Users\\BADR\\Pictures\\communciation.png";

	@Given("Deleting a quickpost")
	public void browser_is_open() {
		System.out.println("Inside Step -Browser is open");
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver1.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	}
	
	@And("user is on a loginpage")
	public void user_is_on_login_page() {
		driver.navigate().to("https://sysadmin.inspheris.net/");
	}
	
	@When("user enters both username & password")
	public void user_enters_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("user2");
		driver.findElement(By.id("password")).sendKeys("HGTj5h52Buv?");
	}
		
	@When("clicks on a loginbutton")
	public void clicks_on_login_button() {
		driver.findElement(By.name("f")).submit();
	}
	
	@Then("user on a homepage")
	public void home_page() {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	}
	
	@When("user clicks on deleting a quickpost")
	public void deleting() {
		driver.findElement(By.xpath("//div[@ng-click=\"deleteFeed();\"]")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@ng-click=\"closeThisDialog('ok')\"]")).click();
	}
	
	@Then("Confirm deleting a quickpost")
	public void submitting_article_form() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@ng-click=\"closeThisDialog('ok')\"]")).click();
		driver.close();
		driver.quit();
	}
	
	@And("Showing reports path")
	public void showing_path() {
		String path = System.getProperty("/test output/PdfReport/TestsReport.pdf");
		System.out.println(path);
	}
}
