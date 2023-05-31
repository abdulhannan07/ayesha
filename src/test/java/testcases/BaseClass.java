package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ReadConfiguration;

public class BaseClass {
	//verified everything is correct
	public Logger logger;

	ReadConfiguration rd=new ReadConfiguration();

	public WebDriver driver;
	public String baseUrl=rd.Url();
	public String username=rd.User();
	public String password=rd.passWord();
	
	@BeforeClass
	public void startBrow() {
		
		logger=Logger.getLogger("Automation Project");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//Log4j//log4j.properties");
		
		System.setProperty("webdriver.gecko.driver", rd.firefoxP());
		driver=new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", rd.chromeP());
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		logger.info("entered url");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeBrow() {
		driver.quit();
		logger.info("close driver");
	}
	
	public void screenShot(WebDriver driver, String testname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"//Screenshots//"+testname+".png");
		FileUtils.copyFile(source, destination);
	}
	
	public boolean isAlertPresent() {
	try {
		driver.switchTo().alert();
		return true;
	}catch
		(NoAlertPresentException e){
		return false;
	}
	}

}
