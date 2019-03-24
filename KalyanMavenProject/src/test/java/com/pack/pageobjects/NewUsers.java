package com.pack.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUsers {
	
	WebDriver driver;
	
	//Locators
	@FindBy(css ="#login_user_FirstName")
	WebElement firstname;
	
	@FindBy(css = "#login_user_LastName")
	WebElement lastname;
	
	@FindBy(css = "#login_user_Email")
	WebElement email;
	
	@FindBy(css = "#login_user_password")
	WebElement password;
	
	@FindBy(css = "#login_user_password_confirmation")
	WebElement confpassword;
	
	@FindBy(css = "#new_login_user > table > tbody > tr:nth-child(6) > td:nth-child(2) > input")
	WebElement createNewUser;
	
	//Constructor
	public NewUsers(WebDriver driver)
	{
		this.driver = driver;			 
	     //Initialize Elements using PageFactory
	     PageFactory.initElements(driver, this);
	}
	
	//Login Method
	public void CreateNewUser(String firstname, String lastname, String email, String password, String confPassword)
	{
		this.firstname.sendKeys(firstname);
		this.lastname.sendKeys(lastname);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.confpassword.sendKeys(confPassword);
		createNewUser.click();
		
	}
}
