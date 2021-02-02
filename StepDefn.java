package StepDefn;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import pageObject.pagebase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObject.PO;


public class StepDefn {
	PO object = new PO();
	pagebase objPageBase = new pagebase();
	public WebDriver driver=null;
	
	@Given("^user is able to login into application$")
	public void user_is_able_to_login_into_application() throws Throwable {
		objPageBase.clickAddGroup(driver);	
	}
	
	@Then("^user is able to create group$")
	public void user_is_able_to_create_group() throws Throwable {
		objPageBase.clickAddGroup(driver);
	}

	@Then("^user is able to send message to added participants ([^\"]*) $")
	public void user_is_able_to_send_message_to_added_participants(String groupName) throws Throwable {
		objPageBase.typeGroupName(driver, groupName); // getting value from feature file
	}

	@Then("^user should logout from the application\\.$")
	public void user_should_logout_from_the_application() throws Throwable {
		//object.logout();
	    
	}

}
