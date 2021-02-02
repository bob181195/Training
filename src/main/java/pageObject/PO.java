package pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class PO {
	
	WebDriver driver;
	private Properties prop;
	public  PO(){
		try {
		prop = new Properties();
		 InputStream input = new FileInputStream("src/config.properties");
		prop.load(input);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void notifications() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2); 
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	}
	
	
	static ExtentTest test;
static ExtentReports report;
@BeforeClass
public static void startTest()
{
report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
test = report.startTest("ExtentDemo");
}
	
public void login() throws IOException {
    // Write code here that turns the phrase above into concrete actions
notifications();
driver.manage().window().maximize();
driver.get(prop.getProperty("URL"));
driver.findElement(By.id("number")).sendKeys(prop.getProperty("mobileNo"));
driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement title = driver.findElement(By.xpath("//*[@title='Telebu']"));
if(title.isDisplayed())
{
test.log(LogStatus.PASS, "Navigated to the specified URL");
}
else
{
test.log(LogStatus.FAIL, "Test Failed");
}
}


public void create_group() throws InterruptedException {
	Thread.sleep(3000);
	WebElement addgroup = driver.findElement(By.xpath("//ul[@class='list-group header float-right ng-star-inserted']/li[1]"));
	addgroup.click();
	WebElement newGrp = driver.findElement(By.xpath("//div[@class='contacts-list']/div[1]"));
	newGrp.click();
	WebElement grpName = driver.findElement(By.xpath("//input[@placeholder='Group Subject']"));
	grpName.sendKeys(prop.getProperty("groupName"));
	WebElement addParticipants = driver.findElement(By.xpath("//*[text()[contains(.,'Add Participants')]]"));
	addParticipants.click();
	WebElement addContacts = driver.findElement(By.xpath("//input[@placeholder='Search Contacts']"));
	addContacts.sendKeys(prop.getProperty("participant"));
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
	WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Search Names']"));
	searchbox.sendKeys(prop.getProperty("groupName"));
	WebElement name = driver.findElement(By.xpath("//div[@name='Message Item']"));
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='Message Item']")));
	name.click();
	WebElement message = driver.findElement(By.xpath("//textarea[@name='message']"));
	for(int i=0;i<=4;i++) {
	message.sendKeys(prop.getProperty("message"));
	WebElement send = driver.findElement(By.xpath("//div[@class='footer-chat p-relative ng-star-inserted']/img[2]"));
	send.click();
	}
}

public void logout() {
	WebElement image = driver.findElement(By.xpath("//*[@class='rounded-circle c-pointer ng-star-inserted']"));
	if(image.isDisplayed()) {
		image.click();
		WebElement logout = driver.findElement(By.xpath("(//li[@class='dropdown-item'])[2]"));
		logout.click();
	}
	driver.close();
}
}
