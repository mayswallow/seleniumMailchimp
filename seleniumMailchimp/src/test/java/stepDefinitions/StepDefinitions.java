package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


		@Given("I have entered {string}")
		public void i_have_entered(String string) {
			driver.get("https://login.mailchimp.com/signup/"); // Gå till webbsidan	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   
		}
		
		@Given("I have also entered {string}")
		public void i_have_also_entered(String string) {
		 
		}
		
		@When("I press signup")
		public void i_press_signup() {
		   
		}
		
		@Then("i should be signed in")
		public void i_should_be_signed_in() {
		   
		}




}
