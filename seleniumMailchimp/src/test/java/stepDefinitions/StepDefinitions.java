package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	private WebDriver driver;

	@Given("I have used {string} as browser")
	public void i_have_used_as_browser(String browser) {
		DriveCreator creator = new DriveCreator(); 
		driver = creator.createBrowser(browser);
	}

	@Given("I have entered my {string}")
	public void i_have_entered_my(String email) {
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if(email.equals("email")) {	
			Random randomGenerator = new Random(); 
			int randomInt = randomGenerator.nextInt(1000);  
			sendKeys(driver, By.id("email"), ("epost"+ randomInt +"@hotbrev.com")); //Slumpar e-postadress

		}		
		else if (email.equals("")) {
			sendKeys(driver, By.id("email"), ("")); //Tom input f�r e-post
		}
	}

	@Given("I have also entered {string}")
	public void i_have_also_entered(String username)  {
		if(username.equals("longUsername")) {			
			username = RandomStringUtils.randomAlphabetic(101);	//Slumpar anv�ndare med 101 tecken
			sendKeys(driver, By.id("new_username"), (username));
		}

		else if (username.equals("mayswallow")) {
			sendKeys(driver, By.id("new_username"), (username)); //Befintlig anv�ndare
		}

		else {
			username = RandomStringUtils.randomAlphabetic(20); //Slumpar anv�ndare med 20 tecken
			sendKeys(driver, By.id("new_username"), (username)); 
		}
	}

	@And("I choose a password")
	public void i_choose_a_password()  {
		sendKeys(driver, By.id("new_password"), ("Losenord-NYTT1")); //Skickar in ett fungerande l�senord
		click(driver, By.id("onetrust-accept-btn-handler")); //Klickar p� coockies consent
	}

	@When("I press signup")
	public void i_press_signup() {
		click(driver, By.id("create-account")); //Klickar p� sign up-knappen
	}

	@Then("{string} will be verified")
	public void username_will_be_verified(String username) {
		if(username.equals("username")) {
			assertEquals("Check your email", driver.findElement(By.tagName("H1")).getAttribute("innerHTML")); //Korrekt och signed up
		}
		else if (username.equals("longUsername")) {
			assertEquals("Enter a value less than 100 characters long", driver.findElement(By.cssSelector(".invalid-error")).getText()); //F�r l�ngt anv�ndarnamn
		}

		else if (username.equals("mayswallow")) {
			assertEquals("Please check your entry and try again.", driver.findElement(By.id("av-flash-block")).getText()); //Befintligt anv�ndarnamn
		}

		else {
			assertEquals("Please enter a value", driver.findElement(By.cssSelector(".invalid-error")).getText()); //Assert p� det tomma e-postf�ltet
		}

		driver.quit();
	}

	private void click(WebDriver driver, By by) {
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}

	private void sendKeys(WebDriver driver, By by, String keys) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).sendKeys(keys);
	}
}
