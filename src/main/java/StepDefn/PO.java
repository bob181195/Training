package StepDefn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class PO {
public void login() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	WebDriver driver;
Map<String, Object> prefs = new HashMap<String, Object>();
prefs.put("profile.default_content_setting_values.notifications", 2); 
ChromeOptions options = new ChromeOptions();
options.setExperimentalOption("prefs", prefs);
Properties prop=new Properties();
FileInputStream ip= new FileInputStream("src/config.properties");
prop.load(ip);
driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.get(prop.getProperty("URL"));
driver.findElement(By.id("number")).sendKeys(prop.getProperty("mobileNo"));
driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement title = driver.findElement(By.xpath("//*[@title='Telebu']"));
if(title.isDisplayed()) {
	System.out.println("inside the page");
}
}
}
