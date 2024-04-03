package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import baseClass.baseClass;
import functionality.Actionsss;
import functionality.Waits;
import pageObjects.WishlistPage;

public class WishListPageValidations extends baseClass{
	
	private static WishlistPage WLP = new WishlistPage(driver);
	
	public static void verifyheader() {
		test.info("Verify WishList click");
		if(Actionsss.countofElements(WLP.getwishlistHeader())) {
			test.pass("Successfully Clicked on the whislist icon and Navigated to the Wishlist page");
			logger.info("Successfully Clicked on the whislist icon and Navigated to the Wishlist page");
		}else {
			test.fail("No error messages are displayed for first name.");
			logger.info("No error messages are displayed for first name.");
		}	
	}
	
	public static void verifyHomeLink() {
		test.info("Verify home link");
		if(!Actionsss.countofElements(WLP.getwishlistHeader())) {
			test.pass("Successfully Clicked on the home link and Navigated to the Home page");
			logger.info("Successfully Clicked on the home link and Navigated to the Home page");
		}else {
			test.fail("No error messages are displayed for first name.");
			logger.info("No error messages are displayed for first name.");
		}	
	}
	
	public static void verifyeditlink() {
		test.info("Verify edit link");
		if(Actionsss.countofElements(WLP.geteditpopup())) {
			test.pass("Successfully Clicked on the edit link and Displayed the edit pop up window");
			logger.info("Successfully Clicked on the edit link and Displayed the edit pop up window");
		}else {
			test.fail("No error messages are displayed for first name.");
			logger.info("No error messages are displayed for first name.");
		}	
	}
	
	public static void verifyAttributesSelection() {
		test.info("verify attributes selection in edit page");
    	WebElement Previewbutton = driver.findElement(By.xpath("//button[contains(@class, 'update-cart')]"));
    	if (Previewbutton.isEnabled()) {
    	    logger.info("Successfully Selected the attributes and Update button is Enable");
    	    test.pass("Successfully Selected the attributes and Update button is Enable");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyeditclosebtn() {
		test.info("Verify edit pop up closed");
		if(!Actionsss.countofElements(WLP.geteditpopup())) {
			test.pass("Successfully Clicked on the pop up close button and pop up window is closed");
			logger.info("Successfully Clicked on the pop up close button and pop up window is closed");
		}else {
			test.fail("No error messages are displayed for first name.");
			logger.info("No error messages are displayed for first name.");
		}	
	}
	
	public static void verifyeditupdatebtn() {
		test.info("Verify edit pop up update button");
		if(!Actionsss.countofElements(WLP.geteditpopup())) {
			test.pass("Successfully Clicked on the pop up update button and pop up window is closed");
			logger.info("Successfully Clicked on the pop up update button and pop up window is closed");
		}else {
			test.fail("No error messages are displayed for first name.");
			logger.info("No error messages are displayed for first name.");
		}	
	}
	
	//attribues selction
	public static void verifyattribuespopuplink() {
		test.info("Verify edit link");
		if(Actionsss.countofElements(WLP.geteditpopup())) {
			test.pass("Successfully Clicked on the Select Attribues link and Displayed the Select Attribues pop up window");
			logger.info("Successfully Clicked on the edit link and Displayed the Select Attribues pop up window");
		}else {
			test.fail("No error messages are displayed for first name.");
			logger.info("No error messages are displayed for first name.");
		}	
	}
	
	
	public static void validatingProductisAddtoCart() {
		   test.info("Validating product is add to the cart");
		    	
		    	Wait<WebDriver> wait = Waits.createFluentWait(driver);
		        // Wait for the success alert to be visible
		       WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
		        // Get the text of the alert
		   
		       //WebElement addToCart = driver.findElement(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']"));
		        String actualAddToCart = addToCart.getText();
		        // Expected alert text
		        String expectedAddToCart = "Product added to cart";
		        if (actualAddToCart.equals(expectedAddToCart)) {
		            // Success message is displayed
		        	test.pass("Product added to cart from WishList and Successfully displayed the Pop up message");
		            logger.info("Product is  added to cart from WishList and Successfully displayed the Pop up message");
		            // Perform actions or assertions here for the success case
		        }else {
		            // Success message is not as expected
		        	test.fail("Product is not added to cart");
		            logger.info("Product is not added to cart");
		            // Perform actions or assertions here for the failure case		         
		          }		          
		}
	
	public static void createAccountPageValidationwishList() {
		test.info("Verify the create account pagination");
		if(Actionsss.countofElements(WLP.getSelectcreateAccountActive())) {
			test.pass("Successfully navigated to Create Account page");
			logger.info("Successfully navigated to Create Account page");
		}else {
			test.fail("Not navigated to Create Account page");
			logger.info("Not navigated to Create Account page");
		}
	}
	
	public static void moreButtonClickInWishList() throws InterruptedException {	
		test.info("Verify the click of more button in wishlist");
		if(Actionsss.validateClick(WLP.getMoreButtonInWishlist())) {
			Thread.sleep(2000);
			test.pass("Successfully more button is clicked in wishlist page");
			logger.info("Successfully more button is clicked in wishlist page");
		}else {
			test.fail("More button is not clicked in wishlist page");
			logger.info("More button is not clicked in wishlist page");
		}
	}	
}
