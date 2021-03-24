package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {
	
	private WebDriver driver;
	
	 		
	    @Given("I use {string}")
		public void i_use(String browser) {
			DriveCreator creator = new DriveCreator(); 
			driver = creator.createBrowser(browser);
		 
		}
	    

		@Given("I have entered {int} into the calculator")
		public void i_have_entered_into_the_calculator(Integer first) {
		
			driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php"); // Gå till webbsidan	
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			sendKeys(driver, By.name("n01"), Integer.toString(first));
		}
		
		
		@Given("I have also entered {int} into the calculator")
		public void i_have_also_entered_into_the_calculator(Integer second) {
			sendKeys(driver, By.cssSelector("input[name=n02]"), Integer.toString(second));
		}
		
		private void sendKeys(WebDriver driver, By by, String keys) {
			new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(by));
			driver.findElement(by).sendKeys(keys);
			}
		
		
		@When("I press add")
		public void i_press_add() {
		click(driver, By.cssSelector("input[type=button]"));
			
		}
		
		@Then("the result should be {int} on the screen")
		public void the_result_should_be_on_the_screen(Integer int1) {
			driver.quit();
		}
		
		private void click(WebDriver driver, By by) {
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		}
	
}
