package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	private WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Mahesh akoju/eclipse-workspace/Selenium/chromedriver_win32/chromedriver.exe");
		driver = (WebDriver) new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       // driver.manage().window().maximize();
       // driver.manage().deleteAllCookies();
                
		driver.get("https://www.google.co.in/");
		//driver.get("https://www.facebook.com/");
		System.out.println("Before method executed");
		
		List<WebElement> allLInks = driver.findElements(By.tagName("a"));
		List<WebElement> linksURL = driver.findElements(By.tagName("href"));
		
		
		
		int urlsCount = linksURL.size();
		System.out.println("URL s are as follows:"+urlsCount);
		for(int j =0;j<urlsCount;j++) {
			System.out.println("all URLlinks ::::"+linksURL.get(j).getText());
		}
		System.out.println(allLInks.size());
		
		for(int i =0;i<allLInks.size();i++) {
			
		System.out.println("all links ::::"+allLInks.get(i).getText());
		}
	}
	
	@Test(priority =2)
	public void titleTest() {
		String title =driver.getTitle();
		if("Google".equals(title)) {
			//Assert.assertEquals("Google",title, "it is Matching");
			System.out.println("title is mathcing ::"+title);
	}
		
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
