package browserStackPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserStackSetup {
	
		
		WebDriver driver;
		BrowserStackomePage objBrowserStackHomePage;
		BrowserStackSignUpPage objBrowserStackSignUpPage;

		@BeforeTest
		public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.browserstack.com/");
		}

		@Test(priority = 1)
		public void navigate_to_homepage_click_on_getstarted() {
		objBrowserStackHomePage = new BrowserStackomePage(driver);
		objBrowserStackHomePage.veryHeader();
		objBrowserStackHomePage.clickOnGetStarted();
		}

		@Test(priority = 2)
		public void enter_userDetails() {
		objBrowserStackSignUpPage = new BrowserStackSignUpPage(driver);
		objBrowserStackSignUpPage.veryHeader();
		objBrowserStackSignUpPage.enterFullName("seleniumpanda");
		objBrowserStackSignUpPage.enterBusinessEmail("seleniumpanda@gmail.com");
		objBrowserStackSignUpPage.enterPasswrod("Selenium@123");
		}
		@AfterTest
		
		public void aftertest() {
			driver.quit();
		}
		}


