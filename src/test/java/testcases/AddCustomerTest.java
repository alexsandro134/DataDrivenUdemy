package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class AddCustomerTest extends TestBase{

	@Test(dataProvider = "getData")
	public void addCustomer(String fn, String ln, String postcode, String alerttext) {
		
		driver.findElement(By.xpath(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(fn);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(ln);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postcode);
		driver.findElement(By.xpath(OR.getProperty("addBtn"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
	}

	@DataProvider
	public Object[][] getData() {
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
}
