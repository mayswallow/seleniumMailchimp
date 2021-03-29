package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		driver.get("https://login.mailchimp.com/signup/"); // Gå till webbsidan	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Random randomGenerator = new Random(); 
		int randomInt = randomGenerator.nextInt(1000);  
		sendKeys(driver, By.id("email"), ("email"+ randomInt +"@gmail.com"));
	}


	@Given("I have also entered {string}")
	public void i_have_also_entered(String username)  {
		System.out.println(username);
		
	if(username.equals("longUsername")) {			
			username = RandomStringUtils.randomAlphabetic(101);		
			sendKeys(driver, By.id("new_username"), (username));
		}
	
		else {
			username = RandomStringUtils.randomAlphabetic(20);
			sendKeys(driver, By.id("new_username"), (username));
		}
	}

	@And("I choose a {string}")
	public void i_choose_a(String password)  {
		sendKeys(driver, By.id("new_password"), (password));
		click(driver, By.id("onetrust-accept-btn-handler"));
	}


	@When("I press signup")
	public void i_press_signup() {
		click(driver, By.id("create-account"));
	}

	@Then("{string} should be signed in")
	public void username_should_be_signed_in(String username) {
		String longUsername = username;
		if(username.equals(longUsername)) {
			WebElement title = driver.findElement(By.className("invalid-error"));
			assertEquals("Enter a value less than 100 characters long", title.getText());
		}
		else {
			WebElement title = driver.findElement(By.tagName("h1"));
			assertEquals("Check your email", title.getText());
		}

		//Thread.sleep(4000);
		driver.quit();
	}

	private void click(WebDriver driver, By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}

	private void sendKeys(WebDriver driver, By by, String keys) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).sendKeys(keys);
		
	}
	
}
