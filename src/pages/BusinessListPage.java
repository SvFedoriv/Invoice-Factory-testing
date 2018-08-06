package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusinessListPage extends PageObject {

	public BusinessListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
		@FindBy(id = "add-new-business")
		WebElement addBusinessBut;
		
		@FindBy(id = "expand-business-details")
		List<WebElement> viewDetails;
		
		@FindBy(css = "strong[id*='business-name']")
		List<WebElement> businessName;
		
		@FindBy(css = "a[id*='business-edit-btn']")
		WebElement editButt;
		
		@FindBy(css = "button[id*='context-delete']")
		WebElement deleteButt;
		
		@FindBy(css = "strong[id*='business-address']")
		WebElement adress;
		
		@FindBy(id = "close-business-details")
		WebElement closeButt;
		
		@FindBy(id = "nav-bar-invoices")
		WebElement invoiceButt;
		
		@FindBy(css = "#app  div.v-card__text.primary--text.text-xs-center")
		WebElement deleteAlert;
		
		@FindBy(css = "button[id*='dialog-yes']")
		WebElement deleteYes;
		
		public void addNewBusiness() {
			wait.until(ExpectedConditions.elementToBeClickable(addBusinessBut));
			addBusinessBut.click();
		}
		
		int toEdit = 1;
		
		public boolean isAdded() {
			String name = "";
			for (int i = 0; i < businessName.size(); i++) {
				name = businessName.get(i).getText();
				if (name.equals(AddBusinessPage.businessName)) {
					break;
				}
			}
			System.out.println(name.equals(AddBusinessPage.businessName));
			return name.equals(AddBusinessPage.businessName);
		}
		
		public boolean deleteBusiness() {
			String expectedMess = "If you delete this business, you won't be able to undo it!";
			viewDetails.get(viewDetails.size() - 1).click();
			deleteButt.click();
			String alertMess = deleteAlert.getText();
//			System.out.println(alertMess);
			deleteYes.click();
			return alertMess.equals(expectedMess);
		}
		
		public boolean isDeleted() {
			boolean isNotPresent = true;
			for (int i = 0; i < businessName.size(); i++) {
				String name = businessName.get(i).getText();
				if (name.equals(AddBusinessPage.businessName)) {
					isNotPresent = false;
					break;
				}
				System.out.println(isNotPresent);
			}
			return isNotPresent;			
		}
	
		public void editButtClick() {
			viewDetails.get(toEdit).click();
			wait.until(ExpectedConditions.elementToBeClickable(editButt));
			editButt.click();
		}
		
		public boolean isEdited() {
			viewDetails.get(toEdit).click();
			String presentStreet = adress.getText();
			return presentStreet.equals(AddBusinessPage.street);
		}
		
		public void gotoInvoice() {
			invoiceButt.click();
		}
}
