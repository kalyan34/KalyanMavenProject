package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.pageobjects.LoginPage;

public class TC_001 extends TestBaseSetup {
	WebDriver driver;

	LoginPage loginPage;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void invalidUserLoginTest() throws InterruptedException {
		// Create object of LoginPage Class
		loginPage = new LoginPage(driver);

		// Pass invalid email
		loginPage.userLogin("kalyan", "chanda");
		String bodyText = driver.findElement(By.tagName("body")).getText();
		
		//Assert
		Assert.assertTrue(bodyText.contains("Can not find email"), "Error message not found on Login page!");
		Thread.sleep(6000);
	}

}
