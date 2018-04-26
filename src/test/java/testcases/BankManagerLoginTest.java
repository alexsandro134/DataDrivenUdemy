package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class BankManagerLoginTest extends TestBase{

	@Test
	public void loginAsBankManager() throws InterruptedException{
		System.setProperty("org.uncommons.reportng.escape-output","false");
		log.debug("=========== Start loginTest ===========");
		driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn"))));
		
		log.debug("=========== Successful loginTest ===========");
		Reporter.log("LoginTest successful");
		Reporter.log("<a target=\"_blank\" href=\"E:\\Wallpapers\\wallhaven-16687.jpg\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"E:\\Wallpapers\\wallhaven-16687.jpg\"><img src=\"E:\\Wallpapers\\wallhaven-16687.jpg\" height=200 width=200></img></a>");
	}
}
