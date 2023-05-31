package testcases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TC001_LoginTest extends BaseClass {
	
	@Test
	public void loginTest_TC001() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.enterUser(username);
		logger.info("entered username");
		lp.enterPwd(password);
		logger.info("entered password");
		lp.submitBtn();
		logger.info("pressed submit button");
		Thread.sleep(3000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("test case passed");
		}else {
			screenShot(driver, "TC001_loginTest");
			logger.info("test case failed");
			Assert.assertTrue(false);
		
	}}

	
	}


