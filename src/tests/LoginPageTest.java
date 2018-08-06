package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends InitTest{
	@Test (priority = 0)
  public void invalidEmailInc() {
	  pages.LoginPage login = new pages.LoginPage(driver);
	  login.fillInputs("s_fedorivukr.net", "123467");
	  login.submit();
	  Assert.assertTrue(login.invalidMess(0, login.invEmailMes));
  }
	
	@Test (priority = 1)
	public void invalidEmailCor() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  login.fillInputs("s_fedorivukr.net", Util.PASSWORD);
		  login.submit();
		  Assert.assertTrue(login.invalidMess(0, login.invEmailMes));
	  }
	
	@Test (priority = 2)
	public void invalidPassInc() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  login.fillInputs("1" + Util.EMAIL, "12345");
		  login.submit();
		  Assert.assertTrue(login.invalidMess(0, login.invPassMessMin));
	  }
	
	@Test (priority = 3)
	public void invalidPassCor() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  login.fillInputs(Util.EMAIL, "12345678901234567890a");
		  login.submit();
		  Assert.assertTrue(login.invalidMess(0, login.invPassMessMax));
	  }
	
	@Test (priority = 4)
	public void incorrBoth() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  login.fillInputs(Util.EMAIL + "s", Util.PASSWORD.toUpperCase());
		  login.submit();
		  Assert.assertTrue(login.invCredenc());
	  }
	
	@Test (priority = 5)
	public void incorrPass() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  login.fillInputs(Util.EMAIL, Util.PASSWORD + "4");
		  login.submit();
		  Assert.assertTrue(login.invCredenc());
	  }
	
	@Test (priority = 6)
	public void incorrEmail() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  login.fillInputs("1234@gmail.com", Util.PASSWORD);
		  login.submit();
		  Assert.assertTrue(login.invCredenc());
	  }
	
	@Test (priority = 7)
	public void blankBoth() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  login.fillInputs(" ", " ");
		  login.submit();
		  Assert.assertTrue(login.invalidMess(0, login.blankEmailMess));
	  }
	
	@Test (priority = 8)
	public void blankEmail() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  login.fillInputs(" ", Util.PASSWORD);
		  login.submit();
		  Assert.assertTrue(login.invalidMess(0, login.blankEmailMess));
	  }
	
	@Test (priority = 9)
	public void blankPass() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  login.fillInputs(Util.EMAIL, " ");
		  login.submit();
		  Assert.assertTrue(login.invalidMess(0, login.blankPassMess));
	  }
	
	@Test (priority = 10)
	public void login() {
		  pages.LoginPage login = new pages.LoginPage(driver);
		  pages.InvoicesListPage invoice = new pages.InvoicesListPage(driver);
		  login.fillInputs(Util.EMAIL, Util.PASSWORD);
		  Assert.assertTrue(login.passVisible());
		  login.submit();
		  Assert.assertTrue(invoice.isLogined());
	  }
	
	
}
