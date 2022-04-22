package aspire.pom.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import aspire.common.drive.BaseDriverClass;

public class Demo extends BaseDriverClass {

	@Test
	public static void test1() throws InterruptedException {
		Assert.assertTrue(launchBrowser("firefox"));
		Thread.sleep(5000);

	}
}
