package aspire.common.drive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriverClass {
	public static WebDriver driver;

	public static String getPropertyValues(String key) {
		try {
			Properties objectProperties = new Properties();
			FileInputStream objectFis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\prerequisites.properties");
			objectProperties.load(objectFis);
			return objectProperties.getProperty(key);
		} catch (Exception e) {
			System.err.println("error occured at due to " + ", " + e.getMessage());
			return null;
		}

	}

	public void setPropertyValues(String key, String value) {
		try {
			Properties objectProperties = new Properties();
			FileInputStream objectFis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\prerequisites.properties");
			objectProperties.load(objectFis);
			objectProperties.setProperty(key, value);
			File file = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\prerequisites.properties");
			OutputStream out = new FileOutputStream(file);
			objectProperties.store(out, null);
		} catch (Exception e) {
			System.err.println("error occured at due to " + ", " + e.getMessage());
		}
	}

	public static boolean launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + getPropertyValues("chromeDriver"));
				driver = new ChromeDriver();
				return true;
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + getPropertyValues("firefoxDriver"));
				driver = new FirefoxDriver();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println(browserName + " : Not Launched " + e.getMessage());
			return false;
		}

	}

	public WebElement waitForElementVisibility(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time = 10);
		WebElement waitedEle = wait.until(ExpectedConditions.visibilityOf(element));
		return waitedEle;
	}

	public boolean launchUrl(String url) throws Exception {
		try {
			driver.get(url);
			return true;
		} catch (Exception e) {
			System.err.println(this.getClass() + ": Not able navigate to " + url + ", " + e.getMessage());
			return false;
		}
	}

	public boolean maximizeWindow() {
		try {
			driver.manage().window().maximize();
			return true;
		} catch (Exception e) {
			System.err.println("failed at " + this.getClass() + " due to " + ", " + e.getMessage());
			return false;
		}
	}

	public boolean pageLoadWait(int wait) {
		try {
			driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			System.err.println("failed at " + this.getClass() + " due to " + ", " + e.getMessage());
			return false;
		}
	}

	public boolean clickElement(WebElement element) {
		try {
			waitForElementVisibility(10, element);
			element.click();
			pageLoadWait(5);
			return true;
		} catch (Exception e) {
			System.err.println("failed at " + this.getClass() + " due to " + ", " + e.getMessage());
			return false;
		}
	}

	public boolean setValue(WebElement element, Object value) {
		try {
			waitForElementVisibility(10, element);
			element.clear();
			element.sendKeys(value.toString());
			return true;
		} catch (Exception e) {
			System.err.println("failed at " + this.getClass() + " due to " + ", " + e.getMessage());
			return false;
		}
	}

	public String getText(WebElement element) {
		try {
			waitForElementVisibility(10, element);
			return element.getText();
		} catch (Exception e) {
			System.err.println("failed at " + this.getClass() + " due to " + ", " + e.getMessage());
			return "not valid text";
		}
	}

	public boolean hardWait(int wait) {
		try {
			Thread.sleep(wait);
			return true;
		} catch (Exception e) {
			System.err.println("failed at " + this.getClass() + " due to " + ", " + e.getMessage());
			return false;
		}
	}

	public String getRadomString(int length) {
		String charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer randomString = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char ch = charList.charAt(random.nextInt(charList.length()));
			randomString.append(ch);
		}
		return randomString.toString();
	}
}
