package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddBusinessPage extends PageObject {

	public AddBusinessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "business-form-name")
	WebElement businesNameField;
	
	@FindBy(id = "business-form-country")
	WebElement countriesField;
	
	@FindBy(xpath = "//span[contains(text(), 'Serbia']")
	WebElement choosenCountry;
	
	@FindBy(css = "span[class='v-list__tile__mask']")
	List<WebElement> countryList;
	
	@FindBy(className = "v-list__tile__title")
	List<WebElement> selectBankPage;
	
	@FindBy(id = "business-form-city")
	WebElement cityField;
	
	@FindBy(id = "business-form-street")
	WebElement streetField;
	
	@FindBy(id = "business-form-zip")
	WebElement zipField;
	
	@FindBy(id = "business-form-reg-num")
	WebElement regNumField;
	
	@FindBy(css = "div[class='v-messages__message']")
	List<WebElement> errorMessage;
	
	@FindBy(id = "business-form-add-bank-btn")
	WebElement addBankButt;
	
	@FindBy(id = "bank-dialog-name")
	WebElement bankField;
	
	@FindBy(id = "bank-dialog-num")
	WebElement accountField;
	
	@FindBy(id = "bank-dialog-swf-num")
	WebElement swiftField;
	
	@FindBy(id = "bank-dialog-pay-inst")
	WebElement instrField;
	
	@FindBy(css = "label[for='bank-dialog-currency']")
	WebElement currencyField;
	
	@FindBy(id = "bank-dialog-add-bank")
	WebElement addBankConfirm;
	
	@FindBy(id = "business-form-save-btn")
	WebElement saveButt;
	
	public static String errorNameMess = "The name field is required.";
	public static String errorCountryMess = "The countries field is required.";
	public static String errorCityMess = "The city field is required.";
	public static String errorStreetMess = "The street field is required.";
	public static String errorZipMess = "The zip field is required.";
	public static String errorNumberMess = "The registry number field is required.";
	
	public static String errorNameBankMess = "The bank name field is required.";
	public static String errorAccountMess = "The account number field is required.";
	public static String errorSwiftMess = "The swift number field is required.";
	public static String errorPaymentMess = "The payment instructions field is required.";
	public static String errorCurrencyMess = "The currency field is required.";
		
	public static String businessName = "Went-To-Sunrise Inc";
	public static String city = "Kraljevo";
	public static String street = "Cara Lazara";
	public static String zip = "36000";
	public static String regNum = "06";
	
	public static String bankName = "Addico Bank";
	public static String account = "43543598976";
	public static String swift = "HAABRSBG";
	public static String payment = "Conference payments should be processed via standard bank transfer procedure.";
	
	public boolean incorBuisInfo(int i, String s) {
		saveButt.click();
		wait.until(ExpectedConditions.textToBePresentInElement(errorMessage.get(i), s));
		String errorMes = errorMessage.get(i).getText();
		return errorMes.equals(s);
	}
	
	public void addName() {
		businesNameField.sendKeys(businessName);
	}
	
	public void addCountry() {
		Action country = builder
		.moveToElement(countriesField)
		.click()
		.sendKeys("serbia")
		.build();
		country.perform();
		Action choose = builder
		.moveToElement(countryList.get(0))
		.click()
		.build();
		choose.perform();		
	}
	
	public void addCity() {
		cityField.sendKeys(city);
	}
	
	public void addStreet() {
		streetField.clear();
		streetField.clear();
		streetField.sendKeys(street);
	}
	
	public void addZip() {
		zipField.sendKeys(zip);
	}
	
	public void addRegNum() {
		regNumField.sendKeys(regNum);
	}
	
	public void addAccount() {
		addBankButt.click();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean incorBankInfo(int i, String s) {
		addBankConfirm.click();
		wait.until(ExpectedConditions.textToBePresentInElement(errorMessage.get(i), s));
		String errorMes = errorMessage.get(i).getText();
		return errorMes.equals(s);
	}
	
	public void addBankName() {
		bankField.sendKeys(bankName);
	}
	
	public void addAccNum() {
		accountField.sendKeys(account);
	}
	
	public void addSwift() {
		swiftField.sendKeys(swift);
	}
	
	public void addInstruction() {
		instrField.sendKeys(payment);
	}
	
	public void addCurrency() {
		Action currency = builder
				.moveToElement(currencyField)
				.click()
				.moveToElement(selectBankPage.get(0))
				.click()
				.build();
				currency.perform();		
	}
	
	public void addBank() {
		addBankConfirm.click();
	}
	
	public void saveBusiness() {
		saveButt.click();
	}
}
