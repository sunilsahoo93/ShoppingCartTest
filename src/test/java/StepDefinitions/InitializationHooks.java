package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class InitializationHooks {

	public static Scenario sc;

	public static WebDriver driver;

	@Before
	public void setBrowserDriver(Scenario scenario) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		}
	
	@After
	public void closeBrowser() {
		driver.close();
		System.out.println("Browser closed successfully");
	}

	}
