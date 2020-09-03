package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	private String propertyPath = ".\\src\\main\\resources\\properties\\ProjectProperty.properties";
	
	//constrator
	
	public Base () {
	
		try {
			BufferedReader reader;
			reader = new BufferedReader (new FileReader(propertyPath));
		
		properties = new Properties ();
		try {
			properties.load(reader);
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		logger = logger.getLogger("Loggerfile");
		PropertyConfigurator.configure(".\\src\\main\\resources\\properties\\log4j.properties");
		
		
	}
		
		// get browser name 
		
		public static String getBrowserName() {
			
			String browserName = properties.getProperty("browserName");
			return browserName;
		
		
		}
		
		// get url 
		
		public static String getURL () {
			String url = properties.getProperty("url");
			return url;
			
		}
		
		
		// get pageload
		
		public static Long pageLoadTime() {
			
		String pageloadtime = properties.getProperty("pageloadtime");
	
		return Long.parseLong(pageloadtime);
		
		}
		
		
		// get implicitwaittime 
		
		public static Long implicitWaitTime () {
			String implicitwait = properties.getProperty("implicitwait");
			return Long.parseLong(implicitwait);
		}
		
		//get userName
		
		public static String getUserName() {
			String userName = properties.getProperty("userName");
			return userName;
			
		}
		
		
		//get passowrd 
		
		
		public static String getPassword () {
			String password = properties.getProperty("password");
			return password;
		}

		
       public static void initializedriver () {
    	   
    	 if (Base.getBrowserName().equalsIgnoreCase("chrome")) {
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();
    	 
       }else if (Base.getBrowserName().equalsIgnoreCase("ie")) {
    	   WebDriverManager.chromedriver().setup();
    	   driver = new InternetExplorerDriver();
    	   
       }else if (Base.getBrowserName().equalsIgnoreCase("ff")) {   
    	   WebDriverManager.chromedriver().setup();
    	   driver = new FirefoxDriver();
    	   
       }else {
    	   
    	   WebDriverManager.chromedriver().setup();
      	 driver = new ChromeDriver();
       
    	    }
    	 
    	 driver.manage().window().maximize();
    	 driver.manage().deleteAllCookies();
    	 driver.manage().timeouts().pageLoadTimeout(Base.pageLoadTime(), TimeUnit.SECONDS);
    	 driver.manage().timeouts().implicitlyWait(Base.implicitWaitTime(), TimeUnit.SECONDS);
    	 driver.get(Base.getURL());
    	 
    	 
       }
    	 
    	public static void tearDown() {
    		
    		driver.close();
    		driver.quit();
    		
    		
    		
    	} 
    	 
	}
       


