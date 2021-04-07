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
			int randomInt = randomGenerator.nextInt(1000); //Random siffra innan @
			sendKeys(driver, By.id("email"), ("epost"+ randomInt +"@hotbrev.com")); //Slumpar e-postadress
		}	

		else if (email.equals("")) {
			sendKeys(driver, By.id("email"), ("")); //Tom input för e-post
		}
	}

	@Given("I have also entered {string}")
	public void i_have_also_entered(String username)  {
		if(username.equals("longUsername")) {			
			username = RandomStringUtils.randomAlphabetic(101);	//Slumpar användare med 101 tecken
			sendKeys(driver, By.id("new_username"), (username));
		}

		else if (username.equals("mayswallow")) {
			sendKeys(driver, By.id("new_username"), (username)); //Befintlig användare
		}

		else {
			username = RandomStringUtils.randomAlphabetic(20); //Slumpar användare med 20 tecken
			sendKeys(driver, By.id("new_username"), (username)); 
		}
	}

	@And("I choose a password")
	public void i_choose_a_password()  {
		sendKeys(driver, By.id("new_password"), ("Losenord-NYTT1")); //Skickar in ett fungerande lösenord
		click(driver, By.id("onetrust-accept-btn-handler")); //Klickar på coockies consent
	}

	@When("I press signup")
	public void i_press_signup() {
		click(driver, By.id("create-account")); //Klickar på sign up
	}

	@Then("{string} will be verified")
	public void username_will_be_verified(String username) {
		String expected = "";
		String actual = "";
		
		if(username.equals("username")) { //Korrekt och signed up
			expected = "Check your email";
			actual = driver.findElement(By.tagName("H1")).getAttribute("innerHTML"); 
		}

		else if (username.equals("longUsername")) { //För långt användarnamn
			expected = "Enter a value less than 100 characters long";
			actual = driver.findElement(By.cssSelector(".invalid-error")).getText(); 
		}

		else if (username.equals("mayswallow")) { //Befintligt användarnamn
			expected = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";
			actual = driver.findElement(By.cssSelector(".invalid-error")).getText(); 
		}

		else { //Tomt e-postfält
			expected = "Please enter a value";
			actual = driver.findElement(By.cssSelector(".invalid-error")).getText(); 
		}
		
		assertEquals(expected, actual);
		driver.quit();
	}

	private void click(WebDriver driver, By by) {
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(by)); //Väntar in valt element (5 sek) tills det går att klicka på.
		driver.findElement(by).click();
	}

	private void sendKeys(WebDriver driver, By by, String keys) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(by)); //Väntar in valt element (5 sek) tills du kan skicka in ett värde.
		driver.findElement(by).sendKeys(keys);
	}
}
