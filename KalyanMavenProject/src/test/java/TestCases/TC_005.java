package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.pageobjects.LoginPage;

public class TC_005 extends TestBaseSetup {
	WebDriver driver;
	LoginPage loginPage;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test()
	public void VerifyContactUsLink() throws InterruptedException {
		// Create object of LoginPage Class
		loginPage = new LoginPage(driver);

		WebElement anchor = driver.findElement(By.linkText("Contact Us"));
		String href = anchor.getAttribute("href");
		Assert.assertTrue(href.startsWith("mailto:"), "Contact us link is invalid!");
		Thread.sleep(5000);
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}
