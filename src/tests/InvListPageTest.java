package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddInvoicePage;

public class InvListPageTest extends InitTest {
	
		
	@Test (priority = 20)
	  public void prewierInvoice() {
		pages.InvoicesListPage invoice = new  pages.InvoicesListPage(driver);
		invoice.openContex(2);
		invoice.openPreview();
		Assert.assertTrue(invoice.isPreview());
		invoice.exitPreview();
	}
	
	@Test (priority = 21)
	  public void editInvoice() {
		pages.InvoicesListPage invoice = new  pages.InvoicesListPage(driver);
		pages.AddInvoicePage addInvoice = new pages.AddInvoicePage(driver);
		
		invoice.openContex(2);
		invoice.edit();
		addInvoice.addDiscount(AddInvoicePage.discTaxCor);
		addInvoice.addTax(AddInvoicePage.discTaxCor);
		addInvoice.saveChanges();
		addInvoice.isSaved();		
	}
	
	@Test (priority = 22)
	  public void selectBy() {
		pages.InvoicesListPage invoice = new  pages.InvoicesListPage(driver);
		
		invoice.chooseSelector(0, 1);
		Assert.assertTrue(invoice.isClient());
		invoice.reset();
		Assert.assertTrue(invoice.isReset());
		invoice.chooseSelector(0, 2);
		Assert.assertTrue(invoice.isNoClient());		
	}
	
	@Test (priority = 22)
	  public void delete() {
		pages.InvoicesListPage invoice = new  pages.InvoicesListPage(driver);
		
		invoice.findAdded();
		invoice.openContex(invoice.findAdded());
		invoice.deleteAdded();
		Assert.assertTrue(invoice.deleteWarn());
		invoice.deleteConfirm();
	}
}
