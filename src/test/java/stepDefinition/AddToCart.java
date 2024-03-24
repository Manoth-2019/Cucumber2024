package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import driverInstance.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart extends DriverInstance {

	@Given("Users enter the {string} and {string}")
	public void usersEnterTheAnd(String username, String password) {
		driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-button mat-button-base n')]"))
				.click();
		driver.findElement(By.xpath("//input[@data-placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@data-placeholder='Password']")).sendKeys(password);
	}

	@When("Users click the login button")
	public void usersClickTheLoginButton() {
		driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-r')]")).click();

	}

	@When("Users Search the {string}")
	public void usersSearchThe(String bookname) {
		driver.findElement(By.xpath("//input[@placeholder='Search books or authors']")).sendKeys(bookname);
		driver.findElement(By.xpath("//span[@class='mat-option-text']")).click();

	}

	@When("add to the cart in book")
	public void addToTheCartInBook() {
		WebElement element = driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		WebElement snack = driver.findElement(By.tagName("snack-bar-container"));
		wait.until(ExpectedConditions.visibilityOf(snack));
		wait.until(ExpectedConditions.invisibilityOf(snack));

	}

	@Then("Users check the validation the book is add to cart or not")
	public void usersCheckTheValidationTheBookIsAddToCartOrNot() {
		String text = driver.findElement(By.id("mat-badge-content-0")).getText();
		Assert.assertEquals(Integer.parseInt(text) > 0, true);
		

	}

}
