package com.pack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	//Page URL
	private static String PAGE_URL="https://irf.mtc.ca.gov/login";
	
	//Locators
	@FindBy(css = "#email")
	WebElement username;
	
	@FindBy(css = "#password")
	WebElement password;
	
	@FindBy(css = "#new_account > input[type=\"submit\"]")
	WebElement loginbtn;
	
	@FindBy(css = "#new_account > a:nth-child(3)")
	WebElement createNewAccount;
	
	@FindBy(css = "#page_footer > ul > li:nth-child(3) > a")
	WebElement contactus;
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;	
		 driver.get(PAGE_URL);
		 
	     //Initialize Elements using PageFactory
	     PageFactory.initElements(driver, this);
	}
	
	//Login Method
	public void userLogin(String username, String password)
	{
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		clickLogin();
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
	
	public void clickCreateNewAccount()
	{
		createNewAccount.click();
	}
	
	public boolean validateSuccessfullAccountCreationMsg()
	{
		String bodyText = driver.findElement(By.tagName("body")).getText();
		
		if (bodyText.contains("Login user was successfully created"))
		{
			return true;
		}
		else
		{
			return false;
			
		}
	}
	
	public boolean isContactUsLinkDisplayed()
	{
		return contactus.isDisplayed();
	}
		
	
	
}

