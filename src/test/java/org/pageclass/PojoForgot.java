package org.pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reuseable.BaseClass;

public class PojoForgot  extends BaseClass{
	
	public PojoForgot() {
		PageFactory.initElements(driver, this);
			
	}
	@FindBy(xpath ="//*[@id=\"customer_login\"]/a[1]")
	private WebElement forgotpassword;
	@FindBy(id="RecoverEmail")
	private WebElement email;
	@FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[1]/form/button")
	private WebElement submit;
	
	public WebElement getForgotpassword() {
		return forgotpassword;
	}
	public void setForgotpassword(WebElement forgotpassword) {
		this.forgotpassword = forgotpassword;
	}
	public WebElement getEmail() {
		return email;
	}
	public void setEmail(WebElement email) {
		this.email = email;
	}
	public WebElement getSubmit() {
		return submit;
	}
	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

}
