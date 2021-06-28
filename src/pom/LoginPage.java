package pom;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	//1. Declaration
	@FindBy(id="email")
	private WebElement unTextBox;
	
	@FindBy(id="pass")
	private WebElement pwTextBox;
	
	@FindBy(xpath="//*[@name='login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[contains(text(), 'The email address or mobile number you entered is')]")
	private WebElement errorMessage;
	
	//2. Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//3. Utilization
	public void login(String un, String pw) {
	unTextBox.sendKeys(un);
	pwTextBox.sendKeys(pw);
	loginButton.click();
	}
	
	public void verifyErrorMessage(WebDriver driver, SoftAssert a) {
		try {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		a.assertTrue(errorMessage.isDisplayed(), "Error Message not displayed");
		Reporter.log("Error message is displayed",true);
		}catch(TimeoutException e) {
			Reporter.log("Error message is not displayed",true);
			a.fail();
		}
	}
}
