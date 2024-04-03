package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import baseClass.baseClass;
import data.TestData;
import functionality.Waits;

public class MiniCartValidation extends baseClass{
	private static  TestData TD  = new TestData();
	//Home page banner and clp validation
 	public static void VerifiedThatMinicartBtnClick() {
 		test.info("Verify weather the user is able to click Mini-Cart");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement miniCartPage = driver.findElement(By.xpath("//h1[contains(text(), 'Your shopping cart')]"));
     	
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the MiniCart And Displayed the MiniCart pop up");
     	    test.pass("Successfully Clicked on the MiniCart And Displayed the MiniCart pop up");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	//View cart btn in mini cart
 	public static void VerifiedThatViewcartBtnClick() throws InterruptedException {
 		test.info("Verify weather the user is able to click View-Cart");
 		Thread.sleep(3000);
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement miniCartPage = driver.findElement(By.xpath("//div[@class='col-sm-7 col-md-8']"));
     
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the ViewCart and Navigated to the View Cart page");
     	    test.pass("Successfully Clicked on the ViewCart and Navigated to the View Cart page");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	//View cart btn in mini cart
 	public static void VerifiedThatCheckOutBtnClick() {
 		test.info("Verify weather the user is able to click CheckOut Btn");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement miniCartPage = driver.findElement(By.xpath("//div[@class='col-sm-7']"));
     	
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the CheckOut Btn and Navigated to the Checkout page");
     	    test.pass("Successfully Clicked on the CheckOut Btn and Navigated to the Checkout page");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	public static void removeproductformminicartValidation() {
 	   test.info("Verify weather the user is able to romove product from Minicart");
 	   
 	   Wait<WebDriver> wait = Waits.createFluentWait(driver);
        // Wait for the success alert to be visible
        WebElement removeproduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Product Removed from cart']")));
        // Get the text of the alert
        String removeproductfromcart = removeproduct.getText();
        // Expected alert text
        String expectedAddToCart = "Product Removed from cart";
        
        if (removeproductfromcart.equals(expectedAddToCart)) {
            // Success message is displayed
        	   test.pass("Successfully product is removed from the Mini-Cart and Pop up Message is Displayed");
            logger.info("Successfully product is removed from the Mini-Cart and Pop up Message is Displayed");
            // Perform actions or assertions here for the success case
        }else {
            // Success message is not as expected
        	   test.fail("product is not removed from the cart");
            logger.info("product is not removed from the cart");
            //System.out.println("The product is not added to cart because it should show: " + expectedAddToCart + " but found: " + actualAddToCart);
            // Perform actions or assertions here for the failure case
         
          }
    }
 	
 	//Home page banner and clp validation
 	 	public static void VerifingCloseMinicartBtnClick() {
 	 		test.info("Verify Mini-Cart Close button click");
 	 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
 	     	WebElement miniCartPage = driver.findElement(By.xpath("//h1[contains(text(), 'Your shopping cart')]"));
 	     	
 	     	if (!miniCartPage.isDisplayed()) {
 	     	    logger.info("Successfully Clicked on the Close btn in MiniCart and MiniCart is Closed");
 	     	    test.pass("Successfully Clicked on the Close btn in MiniCart and MiniCart is Closed");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
 	 	
 		//estimated cost in minicart
 	 	public static void VerifingTheEstimatedCost() {
 	 		test.info("Verifying estimated cost in mini cart");	
 	 		logger.info(TestData.expectedTotalCostInMinicart);
 	 		logger.info(TestData.estimatedTotalInMiniCart);
 	     	if (TestData.expectedTotalCostInMinicart==TestData.estimatedTotalInMiniCart) {
 	     	    logger.info("Succesfully the expected and estimated cost are same expected cost is " +TestData.expectedTotalCostInMinicart + " and estimated cost is " + TestData.estimatedTotalInMiniCart  );
 	     	    test.pass("Succesfully the expected and estimated cost are same expected cost is " +TestData.expectedTotalCostInMinicart + " and estimated cost is " + TestData.estimatedTotalInMiniCart);
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}

}
