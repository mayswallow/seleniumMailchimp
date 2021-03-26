package stepDefinitions;

import java.util.concurrent.TimeUnit;

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
				sendKeys(driver, By.id("email"), (email));
			}

		
		@Given("I have also entered {string}")
		public void i_have_also_entered(String username)  {
		sendKeys(driver, By.id("new_username"), (username));
		}
		
		@And("I choose a {string}")
			public void i_choose_a(String password)  {
			sendKeys(driver, By.id("new_password"), (password));
			click(driver, By.id("onetrust-accept-btn-handler"));
			}
		
		
		@When("I press signup")
		public void i_press_signup() {
		   
		}
		
		@Then("i should be signed in")
		public void i_should_be_signed_in() {
			//driver.quit();
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
