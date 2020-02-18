import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BrowserFactory;

public class LoginTest {
	@Test
	public void login() {
		WebDriver driver = BrowserFactory.getChromeDriver();
		// login test
		LoginPage loginPage = LoginPage.getLoginPage(driver);
		loginPage.open(LoginPage.URL1);
		loginPage.login("opensourcecms", "opensourcecms");
		Assert.assertEquals("https://s1.demo.opensourcecms.com/wordpress/wp-admin/", driver.getCurrentUrl());
		
		// save draft 
		String title = "This is title";
		String content = "This is the content";
		DashboardPage dashboardPage = DashboardPage.getDashboardPage(driver);
		dashboardPage.saveDraft(title, content);
		String actualTitle = dashboardPage.getDraftTitle();
		
		System.out.println(String.format("We are expecting %s but got %s", title, actualTitle));
		// verify
		Assert.assertEquals(title, actualTitle);

		// click on post menu
		dashboardPage.clickPostMenu();
		WebElement textDemo = driver.findElement(By.xpath("//*[text()='"+title+"']"));
		assertTrue(textDemo.isDisplayed());
	}
}
