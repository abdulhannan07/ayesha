package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration {
	
	public Properties pro;
	
	public ReadConfiguration() {
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//Configurations//config.properties");
			pro=new Properties();
			pro.load(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String Url () {
		String baseUrl =pro.getProperty("baseurl");
		return baseUrl ;
		
	}
	
	public String User () {
		String userName =pro.getProperty("username");
		return userName  ;
		
	}
	
	public String passWord () {
		String pwd =pro.getProperty("password");
		return pwd ;
		
	}
	
	public String chromeP () {
		String chrome =pro.getProperty("chromepath");
		return chrome  ;
		
	}
	
	public String firefoxP () {
		String firefox =pro.getProperty("firefoxpath");
		return firefox ;
		
	}

}
