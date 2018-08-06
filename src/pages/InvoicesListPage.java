package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InvoicesListPage extends PageObject {

	public InvoicesListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "home-page-user")
	WebElement userName;
	
	@FindBy(id = "nav-bar-business")
	WebElement businessBut;
	
	@FindBy(css = "label[for='filter-client']")
	WebElement selectClient;
	
	@FindBy(css = "input[aria-label='Select status']")
	WebElement selectStatus;
	
//	@FindBy(css = "div[class='v-menu__content menuable__content__active'] div.v-list__tile__title")
//	List<WebElement> selectList;
	
	@FindBy(id = "add-new-invoice")
	WebElement addInvoice;
	
	@FindBy(css = "strong[id*='inv-num']")
	List<WebElement> invoiceNum;
	
	@FindBy(css = "div[class='v-menu__activator'] button[id*='context']")
	List<WebElement> contex;
	
	@FindBy(css = "div[class*='active'] a[id*='context-preview']")
	WebElement preview;
	
	@FindBy(css = "div.v-toolbar__title:not(*.invoices-brand-name)")
	WebElement previewTitle;
	
	@FindBy(css = "a[class*='v-btn--active'] .v-btn__content")
	WebElement exitPreviewButt;
	
	@FindBy(css = "div[class*='active'] a[id*='context-edit'")
	WebElement editButt;
	
	@FindBy(css = "div.v-select__slot label.v-label")
	List<WebElement> selects;
	
	@FindBy(css = "div[class*='v-menu__content '] .v-list__tile__title")
	List<WebElement> selectElements;
	
	@FindBy(css = "div.v-select__slot div.v-select__selection")
	WebElement clientSelected;
	
	@FindBy(css = "strong[id*='inv-client']")
	List<WebElement> clientNames;
	
	@FindBy(css = "#app > div.application--wrap > main > div > div > div:nth-child(2) > div > div:nth-child(3) > div > div > div > div")
	WebElement noInvoiceMess;
	
	@FindBy(id = "filter-reset")
	WebElement resetButt;
	
	@FindBy(css = "div[class*='active'] [id*='context-delete']")
	WebElement deleteButt;
	
	@FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active div.v-card__text.primary--text.text-xs-center")
	WebElement deleteAlert;
	
	@FindBy(css = "button[id='context-download-dialog-yes']")
	List<WebElement> deleteConfirmButt;
	
	@FindBy(id = "navbar-logout")
	WebElement navigBar;
	
	@FindBy(id = "navbar-logout-btn")
	WebElement logoutButt;
	
	int invoiceAdded = -10;
	
	public boolean isLogined() {
		wait.until(ExpectedConditions.visibilityOf(userName));
		String name = "Svitlana";
		return userName.getText().equals(name);
	}
	
	public void enterBusiness() {
		businessBut.click();
	}
	
	public void addNewInv() {
		addInvoice.click();
	}
	
	public boolean isAdded() {
		String number = "";
		for(int i = 0; i < invoiceNum.size(); i++) {
			number = invoiceNum.get(i).getText();
			if(number.equals(AddInvoicePage.invoiceCor)) {
				break;
			}
		}
		return number.equals(AddInvoicePage.invoiceCor);
	}
	
	public void openContex(int i) {
		contex.get(i).click();
	}
	
	public void openPreview() {
		preview.click();
	}
	
	public boolean isPreview() {
		String title = "Preview Invoice";
		return previewTitle.getText().equals(title);
	}
	
	public void exitPreview() {
		exitPreviewButt.click();
	}
	
	public void edit() {
		editButt.click();
	}
	
	public void chooseSelector(int a, int b) {
		Action openSelector = builder
				.moveToElement(selects.get(a))
				.click()
				.build();
		openSelector.perform();
		Action addSelector = builder
				.moveToElement(selectElements.get(b))
				.click()
				.build();
		addSelector.perform();
	}
	
	public boolean isClient() {
		String client = clientSelected.getText();
		String actualName = "";
		boolean isSelected = true;
		for(int i = 0; i < clientNames.size(); i++) {
			actualName = clientNames.get(i).getText();
			if(!actualName.equals(client)) {
				isSelected = false;
				break;
			}
		}
		return isSelected;
	}
	
	public boolean isNoClient() {
		String expectedMess = "There are no invoices!";
		wait.until(ExpectedConditions.visibilityOf(noInvoiceMess));
		return noInvoiceMess.getText().equals(expectedMess);
	}
	
	public void reset() {
		resetButt.click();
	}
	
	public boolean isReset() {
		String expectedMess = "Select client";
		return selects.get(0).getText().equals(expectedMess);
	}
	
	public int findAdded() {
		String number = "";
		for(int i = 0; i < invoiceNum.size(); i++) {
			number = invoiceNum.get(i).getText();
			invoiceAdded = i;
			if(number.equals(AddInvoicePage.invoiceCor)) {
				break;
			}
		}
		return invoiceAdded;
	}
	
	public void deleteAdded() {
		deleteButt.click();
	}
	
	public boolean deleteWarn() {
		String expectMess = "If you delete this invoice, you won't be able to undo it!" ;
		return deleteAlert.getText().equals(expectMess);
	}
	
	public void deleteConfirm () {
		deleteConfirmButt.get(invoiceAdded).click();
	}
	
	public void logout(int a, int b) {
		Action openBar = builder
				.moveToElement(navigBar)
				.click()
				.build();
		openBar.perform();
		Action logoutC = builder
				.moveToElement(logoutButt)
				.click()
				.build();
		logoutC.perform();
	}
}
