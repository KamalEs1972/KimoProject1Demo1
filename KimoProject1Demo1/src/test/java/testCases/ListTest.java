package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListTest {

	private static final TimeUnit Second = null;

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "E:\\QE Automation\\Drivers//chromedriver.exe");
			
			ChromeDriver driver= new ChromeDriver();
			driver.get("https://www.yahoo.com/");
			//driver.manage().timeouts().implicitlyWait(10, Second);
			//List<WebElement> linkBtns = driver.findElements(By.xpath("//div[@class=\"D(f) Fxf(w) Jc(sb) Maw(940px) Mt(10px) Mend(10px)\"]"));
			List <WebElement> linkLists=driver.findElements(By.tagName("a"));
			
			System.out.println(linkLists.size());
			//for (WebElement link :linkBtns) {
				
				
		//	}
			
		//	System.out.println(linkBtns.toString());
		
		

	}

}
