package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class BankManagerLoginTest extends TestBase{

	@Test
	public void loginAsBankManager() throws InterruptedException{
		
		log.debug("=========== Start loginTest ===========");
		driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn"))));
		
		log.debug("=========== Successful loginTest ===========");
		Assert.fail("Login not successful");
	}
}
