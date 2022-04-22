package aspire.support.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aspire.common.drive.BaseDriverClass;

public class LoginToApplication extends BaseDriverClass {
	@FindBy(xpath = "//input[@id=\"login\"]")
	public static WebElement userName;

	@FindBy(xpath = "//input[@id=\"password\"]")
	public static WebElement password;

	@FindBy(css = "button[class='btn btn-primary btn-block']")
	public static WebElement logIn;

	public LoginToApplication(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userNameValue) {
		try {
			waitForElementVisibility(10, userName);
			setValue(userName, userNameValue);
		} catch (Exception e) {
			System.err.println(e.getMessage() + ", error occured at : " + this.getClass());
		}

	}

	public void enterPassword(String passwordValue) {
		try {
			waitForElementVisibility(10, password);
			setValue(password, passwordValue);
		} catch (Exception e) {
			System.err.println(e.getMessage() + ", error occured at : " + this.getClass());
		}
	}

	public void clickLogIn() {
		try {
			waitForElementVisibility(10, logIn);
			clickElement(logIn);
		} catch (Exception e) {
			System.err.println(e.getMessage() + ", error occured at : " + this.getClass());
		}
	}
}
