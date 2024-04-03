package browser;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import baseClass.baseClass;
import data.TestData;

public class DifferentBrowsers extends baseClass{
	private static TestData TD = new TestData();
	
	// Private method to initialize the WebDriver
		public static void initializeDriver() throws InterruptedException {	    
		    // Create ChromeOptions for configuring the ChromeDriver
			if(TD.NameoftheBrowser == "Chrome") {
				ChromeOptions co = new ChromeOptions();	
			    // Uncomment the line below if you want to add a specific Chrome option
			    // co.addArguments("--remote-allow-origins=*");
			    // Add the "--incognito" argument to open Chrome in incognito mode
			    //co.addArguments("--incognito");
			    // Create a new ChromeDriver with the configured ChromeOptions
			    driver = new ChromeDriver(co);
			    // Maximize the browser window
			    driver.manage().window().maximize();
			    // Delete all cookies in the browser session
			    driver.manage().deleteAllCookies();
			}else if(TD.NameoftheBrowser == "FireFox"){	
				 // Launch Firefox
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			    // Delete all cookies in the browser session
			    driver.manage().deleteAllCookies();
			}else if(TD.NameoftheBrowser == "Edge") {
		        EdgeOptions edgeOptions = new EdgeOptions();
		        driver = new EdgeDriver(edgeOptions);
		        driver.manage().window().maximize();
			    // Delete all cookies in the browser session
			    driver.manage().deleteAllCookies();
			}
		    
		}
}
