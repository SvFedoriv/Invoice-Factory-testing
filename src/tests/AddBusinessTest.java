package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddBusinessPage;

public class AddBusinessTest extends InitTest{
	
	@Test (priority = 11)
	  public void enterBusinessPage() {
			pages.InvoicesListPage invoice = new  pages.InvoicesListPage(driver);
			pages.BusinessListPage business = new pages.BusinessListPage(driver);
			
			invoice.enterBusiness();
			business.addNewBusiness();
	  }
	
	@Test (priority = 12)
	  public void addNewBusiness() {
			pages.AddBusinessPage addBusiness = new pages.AddBusinessPage(driver);
			
			Assert.assertTrue(addBusiness.incorBuisInfo(0, AddBusinessPage.errorNameMess));
			addBusiness.addName();
			Assert.assertTrue(addBusiness.incorBuisInfo(0, AddBusinessPage.errorCountryMess));
			addBusiness.addCountry();
			Assert.assertTrue(addBusiness.incorBuisInfo(0, AddBusinessPage.errorCityMess));
			addBusiness.addCity();
			Assert.assertTrue(addBusiness.incorBuisInfo(0, AddBusinessPage.errorStreetMess));
			addBusiness.addStreet();
			Assert.assertTrue(addBusiness.incorBuisInfo(0, AddBusinessPage.errorZipMess));
			addBusiness.addZip();
			Assert.assertTrue(addBusiness.incorBuisInfo(0, AddBusinessPage.errorNumberMess));
			addBusiness.addRegNum();
	  }
	
	@Test (priority = 13)
	  public void addNewAccount() {
		pages.AddBusinessPage addBusiness = new pages.AddBusinessPage(driver);
		
		addBusiness.addAccount();
		Assert.assertTrue(addBusiness.incorBankInfo(0, AddBusinessPage.errorNameBankMess));
		addBusiness.addBankName();
		Assert.assertTrue(addBusiness.incorBankInfo(0, AddBusinessPage.errorAccountMess));
		addBusiness.addAccNum();
		Assert.assertTrue(addBusiness.incorBankInfo(0, AddBusinessPage.errorSwiftMess));
		addBusiness.addSwift();
		Assert.assertTrue(addBusiness.incorBankInfo(0, AddBusinessPage.errorPaymentMess));
		addBusiness.addInstruction();
		Assert.assertTrue(addBusiness.incorBankInfo(0, AddBusinessPage.errorCurrencyMess));
		addBusiness.addCurrency();
		addBusiness.addBank();
	}
	
	
}
