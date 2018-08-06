package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BusinessListTest extends InitTest{
  
	
	
	@Test (priority = 14)
	  public void isAdded() {
		pages.AddBusinessPage addBusiness = new pages.AddBusinessPage(driver);
		pages.BusinessListPage business = new pages.BusinessListPage(driver);
		
		addBusiness.saveBusiness();
		Assert.assertTrue(business.isAdded());
		business.deleteBusiness();
		Assert.assertTrue(business.isDeleted());
	}
	
	@Test (priority = 15)
	  public void editBusiness() {
		pages.BusinessListPage business = new pages.BusinessListPage(driver);
		pages.AddBusinessPage addBusiness = new pages.AddBusinessPage(driver);
		
		business.editButtClick();
		addBusiness.addStreet();
		addBusiness.saveBusiness();
		Assert.assertTrue(business.isEdited());
		}
}
