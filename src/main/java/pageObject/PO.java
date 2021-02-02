package pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class PO extends pagebase {
	WebDriver driver;/*

	private static Properties prop;
   static{
       InputStream is = null;
       try {
           prop = new Properties();
           is = ClassLoader.class.getResourceAsStream("src/config.properties");
           prop.load(is);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    
   public static String getPropertyValue(String key){
       return prop.getProperty(key);
       }
   */
	
	
	public void notifications() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2); 
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	}
	
	
public void login() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	 Properties prop = new Properties();
	FileInputStream ip= new FileInputStream("src/config.properties");
	prop.load(ip);
notifications();
driver.manage().window().maximize();
driver.get(prop.getProperty("URL"));
System.out.println(uname);
//driver.findElement(By.id("number")).sendKeys(prop.getProperty("mobileNo"));
driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement title = driver.findElement(By.xpath("//*[@title='Telebu']"));
if(title.isDisplayed()) {
	System.out.println("inside the page");
}
}

public void create_group() throws InterruptedException {
	Thread.sleep(3000);
	WebElement addgroup = driver.findElement(By.xpath("//ul[@class='list-group header float-right ng-star-inserted']/li[1]"));
	addgroup.click();
	WebElement newGrp = driver.findElement(By.xpath("//div[@class='contacts-list']/div[1]"));
	newGrp.click();
	WebElement grpName = driver.findElement(By.xpath("//input[@placeholder='Group Subject']"));
	grpName.sendKeys("Automation");
	WebElement addParticipants = driver.findElement(By.xpath("//*[text()[contains(.,'Add Participants')]]"));
	addParticipants.click();
	WebElement addContacts = driver.findElement(By.xpath("//input[@placeholder='Search Contacts']"));
	addContacts.sendKeys("Bhusa Ganesh");
	Thread.sleep(2000);
	WebElement checkBox = driver.findElement(By.xpath("//i[@class='helper']"));
	checkBox.click();
	WebElement SelectedContatcs = driver.findElement(By.xpath("(//li[@class='nav-item'])[2]"));
	SelectedContatcs.click();
	WebElement AddSelectedParticipants = driver.findElement(By.xpath("//span[text()[contains(.,'Add Participants')]]"));
	AddSelectedParticipants.click();
	WebElement createGrup = driver.findElement(By.xpath("//button[text()[contains(.,'Create Group')]]"));
	createGrup.click();
	
}

public void send_message() throws IOException, InterruptedException {
	Thread.sleep(5000);
	 Properties prop = new Properties();
	FileInputStream ip= new FileInputStream("src/config.properties");
	prop.load(ip);
	WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Search Names']"));
	searchbox.sendKeys(prop.getProperty("name"));
	WebElement name = driver.findElement(By.xpath("//div[@name='Message Item']"));
	name.click();
	WebElement message = driver.findElement(By.xpath("//textarea[@name='message']"));
	message.sendKeys(prop.getProperty("message"));
	WebElement send = driver.findElement(By.xpath("//div[@class='footer-chat p-relative ng-star-inserted']/img[2]"));
	send.click();
}

public void logout() {
	WebElement image = driver.findElement(By.xpath("//*[@class='rounded-circle c-pointer ng-star-inserted']"));
	if(image.isDisplayed()) {
		image.click();
		WebElement logout = driver.findElement(By.xpath("(//li[@class='dropdown-item'])[2]"));
		logout.click();
	}
}
}
