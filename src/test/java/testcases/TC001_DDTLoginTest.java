package testcases;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelLibrary;

public class TC001_DDTLoginTest extends BaseClass {
	
	ExcelLibrary ex=new ExcelLibrary();
	
	
	@Test(dataProvider="DDTExcel")
	public void DDT_LoginTestTC001(String us, String pw) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.enterUser(us);
		logger.info("entered username");
		lp.enterPwd(pw);
		logger.info("entered password");
		lp.submitBtn();
		logger.info("pressed submit button");
		Thread.sleep(2000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("test case failed");
			System.out.println("test case failed");
		}
		
		else {
			lp.logOut();
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("test case passed");
			System.out.println("test case passed");
			
		}
	}
	
	
	@DataProvider(name="DDTExcel")
	public Object [][]dataExcel(){{
		return new Object  [][] {
			
			{(ex.excelLib("Sheet1", 0, 0)),ex.excelLib("Sheet1", 0, 1)},
			{(ex.excelLib("Sheet1", 1, 0)),ex.excelLib("Sheet1", 1, 1)},
			{(ex.excelLib("Sheet1", 2, 0)),ex.excelLib("Sheet1", 2, 1)},
			{(ex.excelLib("Sheet1", 3, 0)),ex.excelLib("Sheet1", 3, 1)},
			{(ex.excelLib("Sheet1", 4, 0)),ex.excelLib("Sheet1", 4, 1)},
			{(ex.excelLib("Sheet1", 5, 0)),ex.excelLib("Sheet1", 5, 1)},
			
		
		
		};}
		
		}}
	
	


