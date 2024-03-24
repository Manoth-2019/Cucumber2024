package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverInstance.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverInstance {

	@Before
	public void lancuh() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Downloads\\New folder (2)\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setBinary("E:\\Downloads\\New folder\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(option);
		driver.get("https://bookcart.azurewebsites.net/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@After("@cleanup")
	public void cleanup(Scenario scenario) {
		byte[] screenshotAs1 = driver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs1, "image/png", "picse");
		scenario.log("Before clean UP cart");
		 driver
				.findElement(By.xpath("//span[@class='mat-button-wrapper']/child::mat-icon[text()='shopping_cart']")).click();
		
		driver.findElement(By.xpath("//span[text()='Clear cart']")).click();
		String text = driver.findElement(By.xpath("//mat-card-title[@class='mat-card-title']")).getText();
		Assert.assertEquals(text, "Shopping cart is empty");
		byte[] screenshotAs2 = driver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs2, "image/png", "picse");
		scenario.log("Afetr clean UP cart");
	}

	@After
	public void Failure(Scenario scenario) {
		boolean failed = scenario.isFailed();
		if (failed) {
			byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "picture");
			scenario.log("Any failure");
		}
		driver.quit();
	}

}
