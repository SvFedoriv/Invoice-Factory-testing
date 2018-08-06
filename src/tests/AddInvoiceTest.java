package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddInvoicePage;

public class AddInvoiceTest extends InitTest{
	
	@Test (priority = 16)
	  public void addNewInvoice() {
		pages.BusinessListPage business = new pages.BusinessListPage(driver);
		pages.InvoicesListPage invoice = new  pages.InvoicesListPage(driver);
		
		business.gotoInvoice();
		invoice.addNewInv();
}
	
	@Test (priority = 17)
	  public void fillInvoiceForm() {
		pages.AddInvoicePage addInvoice = new pages.AddInvoicePage(driver);
		
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorClientMess));
		addInvoice.addOneFromList(0);
		addInvoice.addOneFromList(1);
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorBusinMess));
		addInvoice.addOneFromList(2);
		addInvoice.addInvNum(" ");
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorNumberMess1));
		addInvoice.addInvNum(AddInvoicePage.invoiceIncor);
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorNumberMess2));
		addInvoice.addInvNum(AddInvoicePage.invoiceCor);
		addInvoice.addSubmitDate();
		addInvoice.addDueDate();
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorBasisMess));
		addInvoice.fillBasis();
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorCurrencyMess));
		addInvoice.addOneFromList(3);
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorBankMess));
		addInvoice.addOneFromList(4);
  }
	
	@Test (priority = 18)
	  public void fillInvoiceContent() {
		pages.AddInvoicePage addInvoice = new pages.AddInvoicePage(driver);
		
		addInvoice.addContent();
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorServiceMess));
		addInvoice.fillService();
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorNoteMess));
		addInvoice.fillNote();
		addInvoice.addDays(" ");
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorDaysMess1));
		addInvoice.addDays(AddInvoicePage.invalEnter);
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorDaysMess2));
		addInvoice.addDays(AddInvoicePage.daysCor);
		Assert.assertTrue(addInvoice.isCorrectHours());
		addInvoice.addRate(" ");
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorRateMess1));
		addInvoice.addRate(AddInvoicePage.invalEnter);
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorRateMess2));
		addInvoice.addRate(AddInvoicePage.rateCor);
		Assert.assertTrue(addInvoice.isCorrectAmount());
		addInvoice.addDiscount(AddInvoicePage.invalEnter);
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorDiscount1));
		addInvoice.addDiscount(AddInvoicePage.discTaxIncor);
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorDiscount2));
		addInvoice.addDiscount(AddInvoicePage.discTaxCor);
		addInvoice.addTax(AddInvoicePage.invalEnter);
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorTaxMess1));
		addInvoice.addTax(AddInvoicePage.discTaxIncor);
		Assert.assertTrue(addInvoice.verifyError(0, AddInvoicePage.errorTaxMess2));
		addInvoice.addTax(AddInvoicePage.discTaxCor);
		
	}
	
	@Test (priority = 19)
	  public void saveNewInvoice() {
		pages.AddInvoicePage addInvoice = new pages.AddInvoicePage(driver);
		pages.InvoicesListPage invoice = new  pages.InvoicesListPage(driver);
		
		addInvoice.goBack();
		Assert.assertTrue(addInvoice.alertWarning());
		addInvoice.stayHere();
		addInvoice.saveChanges();
		Assert.assertTrue(addInvoice.isNoTitle());
		addInvoice.addTitle();
		addInvoice.saveChanges();
		Assert.assertTrue(invoice.isAdded());
	}

}
