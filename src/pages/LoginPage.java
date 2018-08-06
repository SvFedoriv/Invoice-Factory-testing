package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "login-form-email")
	WebElement emailField;
	
	@FindBy(id = "login-pass")
	WebElement passField;
	
	@FindBy(id = "login-form-btn")
	WebElement loginButton;
	
	@FindBy(xpath = "//p[contains(text(),'Invalid credentials.')]")
	WebElement alertInval;
	
	@FindBy(css = "#app   div.v-input__append-inner  i")
	WebElement visibility;
	
	@FindBy(className = "v-messages__message")
	List <WebElement> invalMess;
	
	public String invEmailMes = "The email field must be a valid email.";
	public String invPassMessMin = "The password field must be at least 6 characters.";
	public String invPassMessMax = "The password field may not be greater than 20 characters.";
	public String blankEmailMess = "The email field is required.";
	public String blankPassMess = "The password field is required.";
	
	public void fillInputs(String email, String pass) {
		emailField.clear();
		emailField.clear();
		emailField.sendKeys(email);
		
		passField.clear();
		passField.clear();
		passField.sendKeys(pass);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void submit() {
		loginButton.click();
	}
	
	public boolean invalidMess(int i, String s) {
		wait.until(ExpectedConditions.textToBePresentInElement(invalMess.get(i), s));
		return invalMess.get(i).getText().equals(s);
	}
	
	public boolean invCredenc() {
		wait.until(ExpectedConditions.visibilityOf(alertInval));
		return alertInval.isDisplayed();
	}
	
	public boolean passVisible() {
		visibility.click();
		String expectedText = "visibility";
		return visibility.getText().equals(expectedText);
	}
}
