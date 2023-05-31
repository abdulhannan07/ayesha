package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	private  WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement submitBtn;
	
	@FindBy(linkText="Log out")
	WebElement LogoutBtn;
	
	public void enterUser(String username) {
		txtUserName.sendKeys(username);
	}
	
	public void enterPwd(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void submitBtn() {
		submitBtn.click();
	}
	
	public void logOut() {
		LogoutBtn.click();
	}
	
	

}
