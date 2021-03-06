package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriveCreator {


	public WebDriver createBrowser(String browser) {
		WebDriver driver;
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver(); // Starta Chrome
		} 
		else if (browser.equals("edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Selenium\\msedgedriver.exe");
			driver = new EdgeDriver(); // Starta Edge
		}
		else {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver(); // Starta Firefox
		}

		return driver;

	}
}

