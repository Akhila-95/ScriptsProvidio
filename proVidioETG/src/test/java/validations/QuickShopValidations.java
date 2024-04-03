package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.QuickShopPage;

public class QuickShopValidations extends baseClass{
	
	private static QuickShopPage QSP = new QuickShopPage(driver);
	public static void VerifiyQuickShopPOpUp() {
		test.info("Verify whether the user is able to click QuickShop button");
 		WebElement quickPOP = driver.findElement(By.xpath("//div[contains(@class, 'product-quickview')]"));
     	if (quickPOP.isDisplayed()) {
     	    logger.info("Successfully Clicked on the QuickShop button and displayed the Modal pop up of QuickShop");
     	    test.pass("Successfully Clicked on the QuickShop button and displayed the Modal pop up of QuickShop");
     	}else {
     		test.fail("Click failed");
     	}
 	}
	
	public static void VerifiyQuickShopPOpUpClosed() {
		test.info("Verify whether the user is able to click QuickShop Close button ");
 		WebElement quickPOP = driver.findElement(By.xpath("//div[contains(@class, 'product-quickview')]"));
     	if (!quickPOP.isDisplayed()) {
     	    logger.info("Successfully Clicked on the QuickShop Close button and Closed the Modal pop up of QuickShop");
     	    test.pass("Successfully Clicked on the QuickShop Close button and Closed the Modal pop up of QuickShop");
     	}else {
     		test.fail("Click failed");
     	}
 	}
	
	//full details link
 	public static void verifyQuickshopFullDetailsLinkClick() {
 		test.info("Verify whether the user is able to click Quickshop Full Details Link");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement pdpPage = driver.findElement(By.xpath("//div[contains(@class, 'product-detail product')]"));
     	
     	if (pdpPage.isDisplayed()) {
     	    logger.info("Successfully clicked on the Quickshop Full Details Link and Navigated to the Product detail page");
     	    test.pass("Successfully clicked on the Quickshop Full Details Link and Navigated to the Product detail page");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	public static void verifyCarouselsClickInQuickShop() throws Exception {
 		test.info("Verify whether the user is able to click on the carousels in Quickshop ");
 		
 		if(Actionsss.displayElement(QSP.getNextButtonInCarouselQuickShop())) {
			Actionsss.doubleClick(QSP.getNextButtonInCarouselQuickShop());
			Actionsss.doubleClick(QSP.getPrevoiusButtonInCarouselQuickShop());
				if (Actionsss.clickVerify(QSP.getNextButtonInCarouselQuickShop())) {
		     	    logger.info("Successfully clicked on the carousels in Quickshop");
		     	    test.pass("Successfully clicked on the carousels in Quickshop");
		     	    Actionsss.CombinedClick(QSP.getSelectQuickShopCloseBtn());
		     	}else {
		     		test.fail("Click failed");
		     	}
		}else {
			logger.info("No carousel for this product");
		}
     	
 	}
 	
 	public static void verifyAttributesSelection() {
		test.info("verifyVerify whether the user is able to select the attributes in QuickShop page");
    	WebElement Previewbutton = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart')]"));
    	if (Previewbutton.isEnabled()) {
    	    logger.info("Successfully Selected the attributes and QuickShop add-to-cart button is Enable");
    	    test.pass("Successfully Selected the attributes and QuickShop add-to-cart button is Enable");
    	}else {
    		test.fail("Click failed");
    	}
	}

}
