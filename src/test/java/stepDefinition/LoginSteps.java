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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	WebDriverWait wait;

	@Given("User navigate to the hotel login Page")
	public void userloginpage() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Downloads\\New folder (2)\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setBinary("E:\\Downloads\\New folder\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(option);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(20));
	}

	/*
	 * @Given("User enter the username as yours mail-id") public void
	 * user_enter_the_username_as_yours_mail_id() { driver.navigate().refresh();
	 * WebElement element = driver.findElement(By.name("username")); wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(20));
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
	 * element.sendKeys("Admin");
	 * 
	 * }
	 * 
	 * @Given("User enter the password as admin123") public void
	 * user_enter_the_password_as_sakthi123() throws Exception { WebElement element
	 * = driver.findElement(By.name("password")); wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(20));
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
	 * element.sendKeys("admin123");
	 * 
	 * }
	 */

	@When("User click login button")
	public void user_click_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("the login should be success")
	public void the_login_should_be_success() throws Exception {
		// driver.navigate().refresh();
		String text = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")));
		Assert.assertEquals(text, "Dashboard");
		driver.findElement(By.xpath("//div[@class='oxd-topbar-header-userarea']")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li/child::a[text()='Logout']")).click();
		driver.quit();
	}

	/*
	 * @Given("User enter the username as yours mail-id2") public void
	 * userEnterTheUsernameAsYoursMailId2() { driver.navigate().refresh();
	 * WebElement element = driver.findElement(By.name("username")); wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(20));
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
	 * element.sendKeys("Admin"); }
	 * 
	 * @Given("User enter the password as admin12") public void
	 * userEnterThePasswordAsZxcvbnm() { WebElement element =
	 * driver.findElement(By.name("password")); wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(20));
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
	 * element.sendKeys("admin12"); }
	 */

	@Then("the login should be fail")
	public void theLoginShouldBeFail() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String text = driver
				.findElement(
						By.xpath("//div[@class='orangehrm-login-form']/child::div//p[text()='Invalid credentials']"))
				.getText();
		Assert.assertEquals(text, "Invalid credentials");
		driver.quit();
	}

	@Given("User enter the username as yours {string}")
	public void userEnterTheUsernameAsYours(String username) {
		driver.navigate().refresh();
		WebElement element = driver.findElement(By.name("username"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		element.sendKeys(username);
	}

	@Given("User enter the password as {string}")
	public void userEnterThePasswordAs(String password) {
		WebElement element = driver.findElement(By.name("password"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		element.sendKeys(password);
	}

}
