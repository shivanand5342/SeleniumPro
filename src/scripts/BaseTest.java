package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import generic.AutoConstants;

public abstract class BaseTest implements AutoConstants {

	public WebDriver driver;
	@Parameters({"Browser"})
	@BeforeClass
	public void preCondition(String browser) {
		if(browser.equals("Chrome")) {
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver = new ChromeDriver(ops);
		}
		else if(browser.equals("IE")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
			
	}
	
	@AfterClass
	public void postCondition() {
		driver.close();
	}
}
