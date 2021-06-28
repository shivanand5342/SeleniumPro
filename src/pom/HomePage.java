package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Declaration
	@FindBy(xpath="(//i[@class='hu5pjgll lzf7d6o1'])[2]")
	private WebElement accountTab;
	
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logOut;
	
	@FindBy(xpath="(//span[text()='Log Out'])[1]")
	private WebElement logOutPopUp;
	
	//Initialization
    public HomePage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    //Utilization
    public void logout() {
    	accountTab.click();
    	logOut.click();
    	logOutPopUp.click();
    }
}
