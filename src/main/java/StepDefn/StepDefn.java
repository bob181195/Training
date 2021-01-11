package StepDefn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;

public class StepDefn {
	PO object = new PO();
	@Given("^user is able to login into application$")
	public void user_is_able_to_login_into_application() throws Throwable {
		object.login();
	}
}
