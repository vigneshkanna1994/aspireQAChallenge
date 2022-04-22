package aspire.pom.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import aspire.common.drive.BaseDriverClass;
import aspire.support.libraries.Inventory;
import aspire.support.libraries.LoginToApplication;
import aspire.support.libraries.ManuFacturing;

public class QA_Development_Challenge_Page extends BaseDriverClass {
	static WebDriver driver;

	@FindBy(xpath = "//div[text()=\"Inventory\"]/parent::a")
	public static WebElement invetoryIcon;

	@FindBy(css = "button[title=\"Products\"]>span")
	public static WebElement inventory_ProductsMenu;

	@FindBy(xpath = "//a[contains(@class,\"dropdown-item\")][text()=\"Products\"]")
	public static WebElement productOption;

	@FindBy(xpath = "//a[@title=\"Home menu\"]")
	public static WebElement appHomePageLauncher;

	@FindBy(xpath = "//div[text()=\"Manufacturing\"]/parent::a")
	public static WebElement manufactoringIcon;

	@FindBy(css = "button[class=\"btn btn-primary o_list_button_add\"]")
	public static WebElement manufacturingCreate;

	@FindBy(xpath = "//label[text()=\"Product\"]/ancestor::tbody/tr[5]//input[@class=\"o_input ui-autocomplete-input\"]")
	public static WebElement manufactoringProduct;

	@FindBy(xpath = "(//input[@name=\"product_qty\"])[1]")
	public static WebElement manufactoringProductQty;

	@FindBy(css = "button[name=\"action_confirm\"]")
	public static WebElement manufactoringConfirm;

	@FindBy(xpath = "//*[text()=\"Quantity\"]/parent::td/following-sibling::td//input")
	public static WebElement manufactoringQuantity;

	@FindBy(css = "button[class=\"btn btn-primary\"][name=\"button_mark_done\"]")
	public static WebElement manufactoringMarkAsDone;

	@FindBy(xpath = "//span[text()=\"Ok\"]/parent::button[@class=\"btn btn-primary\"]")
	public static WebElement markAsDoneConfirmationOK;

	@FindBy(css = "button[class=\"btn btn-primary o_form_button_save\"]")
	public static WebElement manufactoringOrdersSave;

	@FindBy(xpath = "//*[text()=\"Manufacturing Orders\"]/parent::li")
	public static WebElement manufactoringHomeMenu;

	@FindBy(xpath = "//span[text()=\"Manufacturing Orders\"]/parent::div/following-sibling::i[@title=\"Remove\"]")
	public static WebElement manufactoringOrdersRemove;

	@FindBy(xpath = "//input[@title=\"Search for records\"]")
	public static WebElement manufactoringSearchRecord;

	@FindBy(xpath = "//em[text()=\"Product\"]/following-sibling::strong")
	public static WebElement manufactoringSearchDropDownProductResult;

	@FindBy(css = "i[class=\"o_searchview_icon fa fa-search\"]")
	public static WebElement manufactoringSearchIcon;

	@FindBy(css = "td[name=\"name\"]")
	public static WebElement manufactoringSearchRecordReference;

	@FindBy(css = "div[name=\"date_planned_start\"]")
	public static WebElement manufactoringSearchRecordScheduledDate;

	@FindBy(css = "td[name=\"product_id\"]")
	public static WebElement manufactoringSearchRecordProduct;

	@FindBy(css = "td[name=\"product_qty\"]")
	public static WebElement manufactoringSearchRecordQuantity;

	@FindBy(xpath = "//*[@name=\"state\"]")
	public static WebElement manufactoringSearchRecordState;

	/*
	 * local variables
	 * 
	 */
	public final String productNameKey = "inventoryProductName";
	public final String manufactoringReferenceKey = "manuFacturingReferenceNumber";
	public final String status = "Done";
	public final String day = "Today";
	public final String quantityKey = "manufactoringQuantityValue";

	public QA_Development_Challenge_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean logIntoAspire(String userNameValue, String passwordValue) {

		try {
			LoginToApplication objectLoginToApplication = new LoginToApplication(driver);
			objectLoginToApplication.enterUserName(userNameValue);
			objectLoginToApplication.enterPassword(passwordValue);
			objectLoginToApplication.clickLogIn();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage() + ", error occured at : " + this.getClass());
			return false;
		}
	}

	public boolean createNewInvetoryProduct() {
		try {
			clickElement(inventory_ProductsMenu);
			clickElement(productOption);
			pageLoadWait(5);
			Inventory objectInventory = new Inventory(driver);
			objectInventory.createProduct();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage() + ", error occured at : " + this.getClass());
			return false;
		}
	}

	public boolean updateQuantity() {
		try {
			Inventory objectInventory = new Inventory(driver);
			hardWait(5000);
			objectInventory.updateQuantity();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage() + ", error occured at : " + this.getClass());
			return false;
		}
	}

	public boolean createManufacturingItem() {
		try {
			clickElement(manufactoringIcon);
			clickElement(manufacturingCreate);
			ManuFacturing objectManuFacturing = new ManuFacturing(driver);
			objectManuFacturing.createManuFacturingOrder(getPropertyValues(productNameKey));
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage() + ", error occured at : " + this.getClass());
			return false;
		}
	}

	public boolean validateManufacturingOrderItem() {
		try {
			hardWait(5000);
			Assert.assertTrue(clickElement(manufactoringHomeMenu));
			Assert.assertTrue(clickElement(manufactoringOrdersRemove));
			Assert.assertTrue(setValue(manufactoringSearchRecord, getPropertyValues(productNameKey)));
			Assert.assertTrue(clickElement(manufactoringSearchDropDownProductResult));
			Assert.assertTrue(clickElement(manufactoringSearchIcon));
			Assert.assertTrue(getText(manufactoringSearchRecordScheduledDate).equalsIgnoreCase(day));
			Assert.assertTrue(
					getText(manufactoringSearchRecordProduct).equalsIgnoreCase(getPropertyValues(productNameKey)));
			Assert.assertTrue(getText(manufactoringSearchRecordQuantity).contains(getPropertyValues(quantityKey)));
			Assert.assertTrue(getText(manufactoringSearchRecordState).equalsIgnoreCase(status));
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage() + ", error occured at : " + this.getClass());
			return false;
		}
	}
}
