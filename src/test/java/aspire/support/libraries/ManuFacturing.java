package aspire.support.libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import aspire.common.drive.BaseDriverClass;

public class ManuFacturing extends BaseDriverClass {

	/*
	 * locators list
	 */
	@FindBy(css = "button[class=\"btn btn-primary o_list_button_add\"]")
	public static WebElement manufacturingCreate;

	@FindBy(xpath = "//label[text()=\"Product\"]/ancestor::tbody/tr[5]//input[@class=\"o_input ui-autocomplete-input\"]")
	public static WebElement manufactoringProduct;

	@FindBy(xpath = "(//a[@class=\"dropdown-item ui-menu-item-wrapper\"])[1]")
	public static WebElement firstProductDrodpwonValue;

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

	@FindBy(xpath = "//span[@class=\"o_field_char o_field_widget o_quick_editable o_readonly_modifier\"]")
	public static WebElement manuFacturingReferenceNumber;

	/*
	 * local variables
	 */
	public final double manufactoringQuantityValue = 15.00;
	public String manufacturingReference;

	public ManuFacturing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createManuFacturingOrder(String itemName) {
		Assert.assertTrue(clickElement(manufacturingCreate));
		Assert.assertTrue(setValue(manufactoringProduct, itemName));
		hardWait(5000);
		Assert.assertTrue(clickElement(driver.findElement(By.xpath("//a[text()=\"" + itemName + "\"]"))));
		Assert.assertTrue(clickElement(manufactoringConfirm));
		hardWait(5000);
		Assert.assertTrue(setValue(manufactoringQuantity, manufactoringQuantityValue));
		Assert.assertTrue(clickElement(manufactoringMarkAsDone));
		Assert.assertTrue(clickElement(markAsDoneConfirmationOK));
		setPropertyValues("manuFacturingReferenceNumber", getText(manuFacturingReferenceNumber));
		setPropertyValues("manufactoringQuantityValue", String.valueOf(manufactoringQuantityValue));
	}

}
