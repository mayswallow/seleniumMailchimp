package stepDefinitions;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class GooglesearchTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	DriveCreator creator = new DriveCreator();  
	driver = creator.createBrowser("chrome");
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void googlesearch() {
    driver.get("https://www.google.com/");
    driver.manage().window().setSize(new Dimension(1382, 886));
    driver.findElement(By.name("q")).sendKeys("Hejsan google");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    
    assertThat(driver.findElement(By.cssSelector(".hlcw0c:nth-child(1) > .g:nth-child(1) .LC20lb")).getText(), is("Google Assistent – Appar på Google Play"));
    driver.close();
  }
}
