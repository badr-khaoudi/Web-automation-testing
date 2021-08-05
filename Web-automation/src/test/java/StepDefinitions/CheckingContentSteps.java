package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckingContentSteps {
	
	WebDriver driver=null;
	
	@Given("Checking content")
	public void browser_is_open() {
		System.out.println("Inside Step -Browser is open");
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver1.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	}
	
	@And("user is on login page checking feature")
	public void user_is_on_login_page() {
		driver.navigate().to("https://sysadmin.inspheris.net/");
	}
	
	@When("user enters username and password checking feature")
	public void user_enters_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("user2");
		driver.findElement(By.id("password")).sendKeys("HGTj5h52Buv?");
	}
		
	@When("clicks on login button checking feature")
	public void clicks_on_login_button() {
		driver.findElement(By.name("f")).submit();
	}
	
	@Then("user on home page checking feature")
	public void home_page() {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	}
	
	
	@When("user checks an image")
	public void checking_image() {
		driver.findElement(By.xpath("//div[@ng-click=\"$root.showGalleryPopup(datalist, gallerytype, {selectedIndex: $index, other: other,selectedUid:datalist[$index].uid}, $event)\"]")).click();
		driver.findElement(By.xpath("//a[@ng-click=\"fullscreenImageSingle()\"]")).click();
	}
	
	@When("user checks a document")
	public void checking_document() {
		driver.findElement(By.xpath("//div[@ng-if=\"::!$ctrl.yammerVignette\"]")).click();
		driver.findElement(By.id("presentationMode")).click();
	}
	
	@When("user checks an external link")
	public void checking_external_link() {
		driver.findElement(By.xpath("//div[@ng-if=\"mediaGalleryFiles[0].thumbnail_url\"]")).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@style=\"float:left;height:93px;\"]")).click();
	}
	
	 @Then("checking logout")
	 public void logout() {
		 driver.close();
		 driver.quit();
	 }
}
