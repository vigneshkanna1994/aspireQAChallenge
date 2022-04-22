package aspire.pom.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import aspire.common.drive.BaseDriverClass;
import aspire.support.libraries.Inventory;

public class Demo2 {

	public static void main(String[] args) throws Exception {
//		File file = new File("/var/www/html/config.properties");
//
//		Properties prop = new Properties();
//
//		try (InputStream in = new FileInputStream(file)) {
//			if (in == null) {
//				throw new FileNotFoundException();
//			}
//			prop.load(in);
//			prop.setProperty("key", "value");
//
//			OutputStream out = new FileOutputStream(file);
//			prop.store(out, "some comment");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		printProperties(prop);
		Properties objectProperties = new Properties();
		FileInputStream objectFis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\prerequisites.properties");
		objectProperties.load(objectFis);
		objectProperties.setProperty("aaaaa", "aaabbb");
		File file = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\prerequisites.properties");
		OutputStream out = new FileOutputStream(file);
		objectProperties.store(out, null);
	}

}
