package TestCases;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.pageobjects.LoginPage;
import com.pack.pageobjects.NewUsers;

public class TC_003And004 extends TestBaseSetup {
	WebDriver driver;

	Random r = new Random();
	int rand = r.nextInt(100);
	String emailAddress = "k" + rand + "@a.com";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}	

	@Test
	public void createNewAccountSuccessTest() throws InterruptedException {
		// Create object of LoginPage Class
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickCreateNewAccount();

		NewUsers newUsersPage = new NewUsers(driver);
		newUsersPage.CreateNewUser("kal", "ch", emailAddress, "pw", "pw");

		Assert.assertTrue(loginPage.validateSuccessfullAccountCreationMsg(), "Account creation failed!");
		Thread.sleep(5000);
	}

	@Test(dependsOnMethods = { "createNewAccountSuccessTest" })
	public void LoginWithNewAccountSuccessTest() throws InterruptedException {
		// Create object of LoginPage Class
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userLogin(emailAddress, "pw");

		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Logged in successfully"), "User did not login successfully!");
		Thread.sleep(5000);
	}

}
