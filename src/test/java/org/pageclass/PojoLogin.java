package org.pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reuseable.BaseClass;

public class PojoLogin extends BaseClass {
	
	public PojoLogin() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[text()='account']")
	private WebElement account;
	@FindBy(id="CustomerEmail")
	private WebElement useremail;
    @FindBy(id="CustomerPassword")
	private WebElement password;
	@FindBy(xpath = "//*[@id=\\\"customer_login\\\"]/button")
	private WebElement signin;
	
	
	public WebElement getAccount() {
		return account;
	}
	public void setAccount(WebElement account) {
		this.account = account;
	}
	
	public WebElement getUseremail() {
		return useremail;
	}
	public void setUseremail(WebElement useremail) {
		this.useremail = useremail;
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword(WebElement password) {
		this.password = password;
	}
	public WebElement getSignin() {
		return signin;
	}
	public void setSignin(WebElement signin) {
		this.signin = signin;
	}

}
