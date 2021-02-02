package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pagebase {
protected static WebElement element =null;
protected final By byAddGroup = By.xpath("//ul[@class='list-group header float-right ng-star-inserted']/li[1]");
protected final By byNewGroup = By.xpath("//div[@class='contacts-list']/div[1]");
protected final By byGroupName = By.xpath("//input[@placeholder='Group Subject']");
protected final By byAddParticipants = By.xpath("//*[text()[contains(.,'Add Participants')]]");

public void clickAddGroup(WebDriver driver) throws Exception{
	element=driver.findElement(byAddGroup);
	element.click();
	
}

public void clickNewGroup(WebDriver driver) throws Exception{
	element=driver.findElement(byNewGroup);
	element.click();
	
}
public void typeGroupName(WebDriver driver,String strGroupName) throws Exception{
	element=driver.findElement(byGroupName);
	element.sendKeys(strGroupName);
	
}






}
