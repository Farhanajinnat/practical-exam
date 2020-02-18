package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static final String URL1 = "https://s1.demo.opensourcecms.com/wordpress/wp-login.php";
	
	public static LoginPage getLoginPage(WebDriver driver) {
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		page.setWebDriver(driver);
		return page;
	}

	private WebDriver drive;
	
	@FindBy(how = How.ID, using = "user_login")
	WebElement userNameField;
	
	@FindBy(how = How.ID, using = "user_pass")
	WebElement passwordField;
	
	@FindBy(how = How.ID, using = "wp-submit")
	WebElement submitButton;
	
	private void setWebDriver(WebDriver driver) {
		this.drive = driver;
	}
	
	public void open(String url) {
		drive.get(url);
	}
	
	public void login(String username, String password) {
		try {
			Thread.sleep(1000);
			userNameField.sendKeys(username);
			Thread.sleep(1000);
			passwordField.sendKeys(password);
			Thread.sleep(1000);
			submitButton.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
}
