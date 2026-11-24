package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pageclass.PojoForgot;
import org.pageclass.PojoLogin;
import org.reuseable.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition  extends BaseClass {
	
	
	@When("user has to click the account button")
	public void userHasToClickTheAccountButton() {
		PojoLogin p=new PojoLogin();
	    p.getAccount().click();
	}
	@When("User has to enter the valid email and vaild password")
	public void userHasToEnterTheValidEmailAndVaildPassword() {
		PojoLogin p=new PojoLogin();
		p.getUseremail().sendKeys("syedafrith122@gmail.com");
		p.getPassword().sendKeys("12345");
	}
	@When("User has to click the sign in button")
	public void userHasToClickTheSignInButton() {
		WebElement w1 = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/button"));
		jsClick(w1);
	}
	@Then("Verify that user has to reached homepage and close the browser")
	public void verifyThatUserHasToReachedHomepageAndCloseTheBrowser() {
	    
	}
	@When("User has to enter the valid {string} and invaild {string}")
	public void userHasToEnterTheValidAndInvaild(String user, String pass) {
		PojoLogin p=new PojoLogin();
		p.getUseremail().sendKeys(user);
		p.getPassword().sendKeys(pass);
	}
//---------------------------------------------------------------------------------------------------------
	@When("user has to click the account button for forgotpassword")
	public void userHasToClickTheAccountButtonForForgotpassword() {
		PojoLogin p=new PojoLogin();
	    p.getAccount().click();
	}
	
	@When("User has to click the forgot password")
	public void userHasToClickTheForgotPassword() {
		PojoForgot p=new PojoForgot();
		p.getForgotpassword().click();
	    
	}
	@When("User has to enter the registered email")
	public void userHasToEnterTheRegisteredEmail() {
		PojoForgot p=new PojoForgot();
		p.getEmail().sendKeys("syedafrith122@gami.com");
	}
	@When("User has to click submit button")
	public void userHasToClickSubmitButton() {
		PojoForgot p=new PojoForgot();
	
	   
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
