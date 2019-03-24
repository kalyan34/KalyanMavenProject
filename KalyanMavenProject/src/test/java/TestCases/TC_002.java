package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.pageobjects.LoginPage;
import com.pack.pageobjects.NewUsers;

public class TC_002 extends TestBaseSetup {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void createNewAccountFailTest() throws InterruptedException {
		// Create object of LoginPage Class
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickCreateNewAccount();

		NewUsers newUsersPage = new NewUsers(driver);
		newUsersPage.CreateNewUser("", "ch", "k@o1.com", "pw", "pw");

		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Firstname can't be blank"), "Error message not found on NewUsers page!");
		Thread.sleep(5000);
	}

}
