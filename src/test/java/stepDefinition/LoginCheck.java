package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginCheck {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("I am navigate to the login page")
	public void iAmNavigateToTheLoginPage() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Downloads\\New folder (2)\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setBinary("E:\\Downloads\\New folder\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(option);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(20));
	    
	}
	@Given("I am enter the {string} and {string}")
	public void iAmEnterTheAnd(String username, String password) {
		
		  driver.navigate().refresh(); WebElement element =
		  driver.findElement(By.name("username")); wait = new WebDriverWait(driver,
		  Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		  element.sendKeys(username); 
		
		  WebElement element1 = driver.findElement(By.name("password")); 
		  wait = new
		  WebDriverWait(driver, Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		  element1.sendKeys(password); }
		 

	    
	
	@When("click the login button")
	public void clickTheLoginButton() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String text = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")));
		Assert.assertEquals(text, "Dashboard");
		driver.findElement(By.xpath("//div[@class='oxd-topbar-header-userarea']")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li/child::a[text()='Logout']")).click();
		driver.quit();
	    
	}


}
