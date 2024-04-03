package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;

public class FooterSectionValidation extends baseClass{
	
	//Home page gift card validation
	public static void verifyFooterGiftCardLink() {
		test.info("verify Gift-Card link");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement GiftCardHeader = driver.findElement(By.xpath("//div[contains(@class, 'page-title d-none')]"));
    	
    	if (GiftCardHeader.isDisplayed()) {
    	    logger.info("Successfully clicked on the GiftCard Link and Navigated to the Gift Card Page");
    	    test.pass("Successfully clicked on the GiftCard Link and Navigated to the Gift Card Page");
    	}else {
    		test.fail("Click failed");
    	}
	}

}
