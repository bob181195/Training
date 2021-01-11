package StepDefn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PO {
public void login() {
    // Write code here that turns the phrase above into concrete actions
	WebDriver driver;
Map<String, Object> prefs = new HashMap<String, Object>();
prefs.put("profile.default_content_setting_values.notifications", 2); 
ChromeOptions options = new ChromeOptions();
options.setExperimentalOption("prefs", prefs);
 driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://ping.telebu.com/login");
driver.findElement(By.id("number")).sendKeys("9010358767");
driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement title = driver.findElement(By.xpath("//*[@title='Telebu']"));
if(title.isDisplayed()) {
	System.out.println("inside the page");
}
}
}
