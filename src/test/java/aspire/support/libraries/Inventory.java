package aspire.support.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aspire.common.drive.BaseDriverClass;

public class Inventory extends BaseDriverClass {

	/*
	 * Locator list
	 */
	@FindBy(css = "button[title=\"Create record\"]")
	public static WebElement productCreate;

	@FindBy(xpath = "//div[@role=\"radiogroup\"]/following-sibling::input[contains(@id,\"o_field_input\")]")
	public static WebElement productName;

	@FindBy(css = "button[class=\"btn btn-primary o_form_button_save\"]")
	public static WebElement newInventoryProductSave;

	@FindBy(xpath = "//button[@name=\"action_update_quantity_on_hand\"]")
	public static WebElement newInventoryProductUpdateQuantity;

	@FindBy(css = "button[class=\"btn btn-primary o_list_button_add\"]")
	public static WebElement productUpdateQuantityCreate;

	@FindBy(xpath = "//input[@name=\"inventory_quantity\"]")
	public static WebElement productUpdateQuantityCountedQuanity;

	@FindBy(css = "button[class=\"btn btn-primary o_list_button_save\"]")
	public static WebElement updateQuantityProductSave;

	/*
	 * Variable Declarations
	 */
	public final String productNameValue = "cheeseBurgerOrdering " + getRadomString(5);
	public final int countedQuantityValue = 15;

	public Inventory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createProduct() {
		clickElement(productCreate);
		setPropertyValues("inventoryProductName", productNameValue);
		setValue(productName, getPropertyValues("inventoryProductName"));
		clickElement(newInventoryProductSave);
	}

	public void updateQuantity() {
		clickElement(newInventoryProductUpdateQuantity);
		clickElement(productUpdateQuantityCreate);
		setValue(productUpdateQuantityCountedQuanity, countedQuantityValue);
		clickElement(updateQuantityProductSave);
		hardWait(5000);
	}
}
