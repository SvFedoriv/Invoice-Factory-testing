package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddInvoicePage extends PageObject {

	public AddInvoicePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "inv-form-save-btn")
	WebElement saveButt;
	
	@FindBy(className = "v-select__selections")
	List<WebElement> selectLists;
	
	@FindBy(css = "div[class='v-menu__content menuable__content__active'] div.v-list__tile__title")
	List<WebElement> activeList;
	
	@FindBy(className = "v-messages__message")
	List<WebElement> errorMessages;
	
	@FindBy(id = "inv-form-number")
	WebElement invoiceField;
	
	@FindBy(id = "inv-form-date-submitted")
	WebElement dateSubmitted;
	
	@FindBy(css = "button[class*='accent']")
	WebElement todayDate;
	
	@FindBy(id = "inv-form-date-ok-submitted")
	WebElement dateSubmit;
	
	@FindBy(id = "inv-form-date-duedate")
	WebElement dueDate;
	
	@FindBy(css = "button[class*='floating']")
	List<WebElement> dates;
	
	@FindBy(id = "inv-form-date-ok-duedate")
	WebElement  okDueDate;
	
	@FindBy(id = "inv-form-basis")
	WebElement basisField;
	
	@FindBy(id = "add-content-btn")
	WebElement addContentButt;
	
	@FindBy(id = "inv-form-service-0")
	WebElement serviceField;
	
	@FindBy(id = "inv-form-note-0")
	WebElement noteField;
	
	@FindBy(id = "inv-form-days-0")
	WebElement daysForm;
	
	@FindBy(id = "inv-form-hours-0")
	WebElement hoursForm;
	
	@FindBy(id = "inv-form-rate-0")
	WebElement rateForm;
	
	@FindBy(id = "inv-form-amount-0")
	WebElement amountForm;
	
	@FindBy(id = "inv-form-discount")
	WebElement discountForm;
	
	@FindBy(id = "inv-form-tax")
	WebElement taxForm;
	
	@FindBy(id = "inv-form-back-btn")
	WebElement backButt;
	
	@FindBy(css = "div[class*= 'inovice-dialog'] div.v-card__title")
	WebElement dialogWindow;
	
	@FindBy(css = "div[class*= 'inovice-dialog'] div.v-btn__content")
	List<WebElement> answerButt;
	
	@FindBy(css = "div[class*='v-snack'] p.body-2")
	WebElement warningAlert;
	
	@FindBy(id = "click-to-enter")
	WebElement title;
	
	@FindBy(id = "invoice-title-content")
	WebElement titleField;
	
	@FindBy(css = "div[class*='v-alert']")
	WebElement successAlert;
	
	public static String errorClientMess = "The client field is required.";
	public static String errorBusinMess = "The business field is required.";
	public static String errorNumberMess1 = "The Invoice number field is required.";
	public static String errorNumberMess2 = "The Invoice number field may contain alpha-numeric characters as well as dashes and underscores.";
	public static String errorBasisMess = "The Basis field is required.";
	public static String errorCurrencyMess = "The currency field is required.";
	public static String errorBankMess = "The bank field is required.";
	public static String errorServiceMess = "The service field is required.";
	public static String errorNoteMess = "The note field is required.";
	public static String errorDaysMess1 = "The days field is required.";
	public static String errorDaysMess2 = "The days field must be numeric and may contain  decimal points.";
	public static String errorRateMess1 = "The rate field is required.";
	public static String errorRateMess2 = "The rate field must be numeric and may contain  decimal points.";
	public static String errorDiscount1 = "The discount field must be 0 or more.";
	public static String errorDiscount2 = "The discount field must be 100 or less.";
	public static String errorTaxMess1 = "The tax field must be 0 or more.";
	public static String errorTaxMess2 = "The tax field must be 100 or less.";
	public static String alertMess = "Are you sure you want to discard this changes?";
	public static String titleMess = "The title field is required.";
	public static String savedMess = "Invoice is successfully saved.";
	
	public static String invoiceIncor = "2018/08/34";
	public static String invoiceCor = "2018_08_34";
	public static String invalEnter = "v";
	public static String daysCor = "3";
	public static String rateCor = "200";
	public static String discTaxIncor = "101";
	public static String discTaxCor = "100";
	int days = Integer.parseInt(daysCor);
	int rate = Integer.parseInt(rateCor);
	int hours = days * 8;
	int amount = hours * rate;
	
	public void addOneFromList(int i) {
		Action openClients = builder
				.moveToElement(selectLists.get(i))
				.click()
				.build();
		openClients.perform();
		Action addClient = builder
				.moveToElement(activeList.get(0))
				.click()
				.build();
		addClient.perform();
	}
	
	public boolean verifyError (int i, String s){
		saveButt.click();
		wait.until(ExpectedConditions.textToBePresentInElement(errorMessages.get(i), s));
		String errorMes = errorMessages.get(i).getText();
		return errorMes.equals(s);
	}
	
	public void addInvNum(String s) {
		invoiceField.clear();
		invoiceField.clear();
		invoiceField.sendKeys(s);
	}
	
	public void addSubmitDate() {
		dateSubmitted.click();
		todayDate.click();
		dateSubmit.click();
	}
	
	public void addDueDate() {
		dueDate.click();
		dates.get(28).click();
		okDueDate.click();
	}
	
	public void fillBasis() {
		basisField.sendKeys("Bilo je nesto...");
	}
	
	public void addContent() {
		addContentButt.click();
	}
	
	public void fillService() {
		serviceField.sendKeys("Na nivou");
	}
	
	public void fillNote() {
		noteField.sendKeys("Da ne zaboravim");
	}
	
	public void addDays(String s) {
		daysForm.sendKeys(Keys.BACK_SPACE);
		daysForm.clear();
		daysForm.sendKeys(s);
	}
	
	public boolean isCorrectHours() {
		int actualHours = Integer.parseInt(hoursForm.getAttribute("value"));
		return actualHours == hours;
	}
	
	public void addRate(String s) {
		rateForm.sendKeys(Keys.BACK_SPACE);
		rateForm.clear();
		rateForm.sendKeys(s);
	}
	
	public boolean isCorrectAmount() {
		
		int actualAmount = Integer.parseInt(amountForm.getAttribute("value").replaceAll ("\\D", "")) / 100;
		return actualAmount == amount;
	}
	
	public void addDiscount(String s) {
		discountForm.sendKeys(Keys.BACK_SPACE);
		discountForm.clear();
		discountForm.sendKeys(s);
	}
	
	public void addTax(String s) {
		taxForm.sendKeys(Keys.BACK_SPACE);
		taxForm.clear();
		taxForm.sendKeys(s);
	}
	
	public void goBack() {
		backButt.click();
	}
	
	public boolean alertWarning() {
		return dialogWindow.getText().equals(alertMess);
	}
	
	public void stayHere() {
		answerButt.get(0).click();
	}
	
	public void saveChanges() {
		saveButt.click();
	}
	
	public boolean isNoTitle() {
		wait.until(ExpectedConditions.visibilityOf(warningAlert));
		return warningAlert.getText().equals(titleMess);
	}
	
	public void addTitle() {
		Action clickTitle = builder
				.moveToElement(title)
				.click()
				.build();
		clickTitle.perform();
		Action newTitle = builder
				.moveToElement(titleField)
				.sendKeys("Title")
				.build();
		newTitle.perform();
		
	}
	
	public boolean isSaved() {
		wait.until(ExpectedConditions.visibilityOf(successAlert));
		return successAlert.getText().equals(savedMess);
	}
}
