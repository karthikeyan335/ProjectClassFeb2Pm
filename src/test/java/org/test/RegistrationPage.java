package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class RegistrationPage extends BaseClass {
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//a[@role='button'])[2]")
	private WebElement createBtn;
	
	@FindBy(name="firstname")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="websubmit")
	private WebElement signUp;
	
	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSignUp() {
		return signUp;
	}

}
