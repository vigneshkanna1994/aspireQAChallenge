/*
 * Author: Vigneshkanna A
 * Test Scenario to be covered:
 * 1. Login to web application
 * 2. Navigate to `Inventory` feature
 * 3. From the top-menu bar, select `Products -> Products` item, then create a new product
 * 4. Update the quantity of new product is more than 10
 * 5. From top-left page, click on `Application` icon
 * 6. Navigate to `Manufacturing` feature, then create a new Manufacturing Order item
 *    for the created Product on step #3
 * 7. Update the status of new Orders to “Done” successfully
 * 8. Validate the new Manufacturing Order is created with corrected information.
 */

package aspire.pom.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import aspire.common.drive.BaseDriverClass;
import aspire.pom.pages.QA_Development_Challenge_Page;

public class QA_Development_Challenge_Test extends BaseDriverClass {
	// Launch the Browser
	@BeforeTest
	public void launchBrowser() {
		Assert.assertTrue(launchBrowser("chrome"), this.getClass() + "- Not able to launch the browser");
		maximizeWindow();
	}

	/*
	 * Navigate to the Application url- https://aspireapp.odoo.com
	 */
	@Test(priority = 0)
	public void navigateToAspireApp() throws Exception {
		Assert.assertTrue(launchUrl(getPropertyValues("applicationUrl")),
				this.getClass() + "- Not able to launch the url");
		pageLoadWait(10);
	}

	/*
	 * 1. Login to web application
	 */
	@Test(priority = 1)
	public void login_To_The_Application() {
		QA_Development_Challenge_Page objectQA_Development_Challenge_Page = new QA_Development_Challenge_Page(driver);
		Assert.assertTrue(objectQA_Development_Challenge_Page.logIntoAspire(getPropertyValues("aspireAppUserName"),
				getPropertyValues("aspireAppPassword")));

	}

	/*
	 * 2. Navigate to `Inventory` feature
	 */
	@Test(priority = 2)
	public void navigat_To_Inventory() {
		QA_Development_Challenge_Page objectQA_Development_Challenge_Page = new QA_Development_Challenge_Page(driver);
		Assert.assertTrue(clickElement(QA_Development_Challenge_Page.invetoryIcon));
	}

	/*
	 * 3. From the top-menu bar, select `Products -> Products` item, then create a
	 * new product
	 */
	@Test(priority = 3)
	public void create_New_Inventory_Product() {
		QA_Development_Challenge_Page objectQA_Development_Challenge_Page = new QA_Development_Challenge_Page(driver);
		Assert.assertTrue(objectQA_Development_Challenge_Page.createNewInvetoryProduct());
	}

	/*
	 * 4. Update the quantity of new product is more than 10
	 * 
	 */
	@Test(priority = 4)
	public void inventory_Product_Update_Quantity() {
		QA_Development_Challenge_Page objectQA_Development_Challenge_Page = new QA_Development_Challenge_Page(driver);
		Assert.assertTrue(objectQA_Development_Challenge_Page.updateQuantity());
	}

	/*
	 * 5. From top-left page, click on `Application` icon
	 * 
	 */
	@Test(priority = 5)
	public void navigate_To_Home_Page() {
		QA_Development_Challenge_Page objectQA_Development_Challenge_Page = new QA_Development_Challenge_Page(driver);
		Assert.assertTrue(clickElement(objectQA_Development_Challenge_Page.appHomePageLauncher));
	}

	/*
	 * 6. Navigate to `Manufacturing` feature, then create a new Manufacturing Order
	 * item for the created Product. ----------------------------------------------
	 * 7. Update the status of new Orders to “Done” successfully.
	 */
	@Test(priority = 6)
	public void create_new_manufacturing_item_with_done_status() {
		QA_Development_Challenge_Page objectQA_Development_Challenge_Page = new QA_Development_Challenge_Page(driver);
		Assert.assertTrue(objectQA_Development_Challenge_Page.createManufacturingItem());
	}

	@Test(priority = 7)
	public void validate_manufacturing_order() {
		QA_Development_Challenge_Page objectQA_Development_Challenge_Page = new QA_Development_Challenge_Page(driver);
		Assert.assertTrue(objectQA_Development_Challenge_Page.validateManufacturingOrderItem());
	}

	@AfterTest
	public void closeTheBrowser() {
		driver.close();
		driver.quit();
	}
}
