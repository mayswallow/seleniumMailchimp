package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
			public void i_have_entered_my(String string) {
				driver.get("https://login.mailchimp.com/signup/"); // Gå till webbsidan	
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//click(driver, By.id("onetrust-accept-btn-handler"));
				WebElement emailInput = driver.findElement(By.id("email"));
				 emailInput.sendKeys("anna@bonnit.se"); //Skriver in e-post i sökfältet
			}

		
		@Given("I have also entered {string}")
		public void i_have_also_entered(String string)  {
			 WebElement usernameInput = driver.findElement(By.id("new_username"));
			 usernameInput.sendKeys("mayswallow"); //Skriver in användarnamn i sökfältet
			 
		}
		
		@Given("Choose {string}")
			public void choose(String string)  {
			 WebElement passwordInput = driver.findElement(By.id("new_password"));
			 passwordInput.sendKeys("NYTTlosenord!2"); //Skriver in lösenord
			}
		
		
		@When("I press signup")
		public void i_press_signup() {
		   
		}
		
		@Then("i should be signed in")
		public void i_should_be_signed_in() {
			//driver.quit();
		}

		/*private void click(WebDriver driver, By by) {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		}*/
}
