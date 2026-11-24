package org.stepdefinition;

import org.reuseable.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	
	@Before
	public void precondition() {
     launchBrowser();
     launchUrl("https://www.plumdeluxe.com/");
	}
	@After
	public void postcondition() {
     // driver.close();
	}

}
	
	

