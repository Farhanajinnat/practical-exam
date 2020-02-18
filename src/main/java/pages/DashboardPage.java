package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	public static DashboardPage getDashboardPage(WebDriver driver) {
		DashboardPage page = PageFactory.initElements(driver, DashboardPage.class);
		page.setDriver(driver);
		return page;
	}

	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "title")
	WebElement titleElement;
	
	@FindBy(how = How.ID, using = "content")
	WebElement contentElement;
	
	@FindBy(how = How.ID, using = "save-post")
	WebElement buttonElement;
	
	@FindBy(how = How.CLASS_NAME, using = "draft-title")
	public WebElement draftTitlElement;

	@FindBy(how = How.ID, using = "menu-posts")
	WebElement menupostsElement;

	private void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open(String url) {
		driver.get(url);
	}
	
	public void saveDraft(String title, String content) {
		try {
			Thread.sleep(1000);
			titleElement.sendKeys(title);
			Thread.sleep(1000);
			contentElement.sendKeys(content);
			Thread.sleep(1000);
			buttonElement.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickPostMenu(){
		menupostsElement.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	public String getDraftTitle() {
		WebElement anchorTagValue = draftTitlElement.findElement(By.tagName("a"));
		return anchorTagValue.getText();
	}
}
