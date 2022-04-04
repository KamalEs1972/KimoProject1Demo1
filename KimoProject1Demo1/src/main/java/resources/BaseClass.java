package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



import io.github.bonigarcia.wdm.WebDriverManager;
import kimoProject1.utility.ExtentManager;




public class BaseClass {

	public static Properties prop;
//	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	//public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		//return driver.get();
	//}
public static WebDriver driver;
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void beforeSuite() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
}

	
	//@BeforeSuite
//	public void loadConfig() {
//		
//
//		try {
//			prop = new Properties();
//			FileInputStream ip = new FileInputStream(
//					System.getProperty("user.dir") + "\\Configuration\\config.properties");
//			prop.load(ip);
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//}
//	public static WebDriver getDriver() {
//		// Get Driver from threadLocalmap
//		return driver.get();
//	}

	
		//public  WebDriver driver;
	//public Properties prop;
	@BeforeTest (groups = {"Smoke","Sanity","Regression"})
	public WebDriver initializeDriver() throws IOException 
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream(("user.dir") + "Configuration\\config.properties");
//System.getProperty("user.dir") + "\\Configuration\\config.properties");
prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	// System.setProperty("webdriver.chrome.driver", "E:\\QE Automation\\Drivers\\chromedriver.exe");
	WebDriverManager.chromedriver().setup();
	// Set Browser to ThreadLocalMap
			//	driver.set(new ChromeDriver());
	driver= new ChromeDriver();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	//System.setProperty("webdriver.gecko.driver", "E:\\QE Automation\\Drivers\\geckodriver.exe");
	WebDriverManager.firefoxdriver().setup();
		//driver.set(new FirefoxDriver());
	 driver= new FirefoxDriver();
	//firefox code
}


else if (browserName.equals("IE"))
//	WebDriverManager.iedriver().setup();
	//driver.set(new InternetExplorerDriver());
	//driver=new InternetExplorerDriver();
{
//	IE code
}
		driver.manage().window().maximize();
		actionDrivers.Action.implicitWait(driver, 10);
		actionDrivers.Action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
//		//Maximize the screen
//		getDriver().manage().window().maximize();
//		//Delete all the cookies
//		getDriver().manage().deleteAllCookies();
//		//Implicit TimeOuts
//		getDriver().manage().timeouts().implicitlyWait
//		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
//		//PageLoad TimeOuts
//		getDriver().manage().timeouts().pageLoadTimeout
//		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
//		//Launching the URL
//		getDriver().get(prop.getProperty("url"));
		return driver;
	}
//	@AfterSuite
//	public void afterSuite() {
//		ExtentManager.endReport();
//	}
	@AfterTest(groups = {"Smoke","Sanity","Regression"})
public void tearDown() {
	driver.quit();
}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
	@AfterSuite(groups = {"Smoke","Sanity","Regression"})
	public void afterSuite() {
		ExtentManager.endReport();
	}

	}
