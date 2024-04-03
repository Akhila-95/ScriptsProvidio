package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.homepage;

public class CLPpageValidation extends baseClass{
	private static homepage homePage = new homepage(driver);

	public static void verifyClpLink() {
		test.info("Verify whether the user is able to click on the ClP link on the MainMenu");
		if(Actionsss.countofElements(homePage.getCLPpageValidation())) {
			logger.info("Successfully clicked on the " +TestData.Selcted_Clp_Name+" ClP link on the MainMenu and Navigated to the " +TestData.Selcted_Clp_Name+" CLP page");
			test.pass("Successfully clicked on the " +TestData.Selcted_Clp_Name+" ClP link on the MainMenu and Navigated to the " +TestData.Selcted_Clp_Name+" CLP page");
		}else {
			test.fail("failed to click on the clp link");
		}
	}
	
 	public static void verifyPLPProductClick() {
 		test.info("Verify weather the user is able to click product link on CLP page");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement pdpPage = driver.findElement(By.xpath("//div[contains(@class, 'product-detail product')]"));
     	
     	if (pdpPage.isDisplayed()) {
     	    logger.info("Successfully clicked in the Product link on CLP page and Navigated to the Product detail page");
     	    test.pass("Successfully clicked in the Product link on CLP page and Navigated to the Product detail page");
     	}else {
     		test.fail("Click failed");
     	}
 	}
}
