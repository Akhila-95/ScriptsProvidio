package validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import baseClass.baseClass;
import functionality.Actionsss;
import functionality.Waits;
import pageObjects.ProductDetailPage;
import pageObjects.ProductListingPage;



public class ProductListingPageValidations extends baseClass{
	private static ProductListingPage PLP = new ProductListingPage(driver);
	private static ProductDetailPage PDP = new ProductDetailPage(driver);
	//Home page banner and clp validation
	public static void verifyPLPResetBtn() {
		test.info("Verify whether the user is able to click reset button");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement resetBtn = driver.findElement(By.xpath("//button[@class = 'reset btn p-0']"));
    	
    	if (!resetBtn.isDisplayed()) {
    	    logger.info("Successfully clicked in the reset btn");
    	    test.pass("Successfully clicked in the reset btn");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	//
	public static void verifyBreadCrumbs() {
		test.info("Verify whether the user is able to click bread crambs link");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement ClpPage = driver.findElement(By.xpath("//div[contains(@id, 'cat-landing')]"));
    	
    	if (ClpPage.isDisplayed()) {
    	    logger.info("Successfully clicked on the bread crumbs and Navigated to the CLP");
    	    test.pass("Successfully clicked on the bread crumbs and Navigated to the CLP");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	//validation pop up add ot wishlist, 
	   public static void popUpProductisAddtoWishList() {
		   test.info("Verify weather the user is able to click wishlist");
		   // Create a FluentWait for dynamic element wait
		   Wait<WebDriver> wait = Waits.createFluentWait(driver);
	       // Wait for the success alert to be visible
	       WebElement addTowishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() ='The product has been added to your wishlist.']")));
	       // Get the text of the alert   
	       String actualAddToCart = addTowishList.getText();
	       logger.info(actualAddToCart);
	       // Expected alert text
	       String expectedAddToCart = "The product has been added to your wishlist.";
	       // Check if the actual alert text matches the expected text
	       if (actualAddToCart.equals(expectedAddToCart)) {
	           // Success message is displayed
	       	   test.pass("Product added to wishlist and Successfully displayed the Pop up message");
	           logger.info("Product added to wishlist and Successfully displayed the Pop up message");
	           // Perform actions or assertions here for the success case
	       } else {
	           // Success message is not as expected
	       	   test.fail("Product is not added to wishlist");
	           logger.info("Product is not added to wishlist");
	       }
	   }
	   
   
   //remove from wishlist
   public static void popUpProductisRemoveWishList() {
	   test.info("Verify whether the user is able to click Remove from wishlist");
	   try {
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = Waits.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement removewishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() ='The product has been removed from your wishlist.']")));
       // Get the text of the alert   
       String actualremove = removewishList.getText();
       logger.info(actualremove);
       // Expected alert text
       String expectedremove = "The product has been removed from your wishlist.";
       // Check if the actual alert text matches the expected text
       if (actualremove.equals(expectedremove)) {
           // Success message is displayed
       	   test.pass("Successfully Product is Removed From wishlist and Successfully displayed the Pop up message");
           logger.info("Successfully Product is Removed From wishlist and Successfully displayed the Pop up message");
           // Perform actions or assertions here for the success case
       } else {
           // Success message is not as expected
       	   test.fail("Product is not remove from wishlist");
           logger.info("Product is not remove from wishlist");
       }
	   }catch(Exception e) {
		   logger.info(e);
	   }
   }
   
 //validation pop up add to cart
   public static void popUpProductisAddtoCart() {
	   test.info("Verify whether the user is able to click Addtocart");
	   try {
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = Waits.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement addTowishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() ='Successfully added to your cart.']")));
       // Get the text of the alert   
       String actualAddToCart = addTowishList.getText();
       logger.info(actualAddToCart);
       // Expected alert text
       String expectedAddToCart = "Successfully added to your cart.";
       // Check if the actual alert text matches the expected text
       if (actualAddToCart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass("Product added to Cart and Successfully displayed the Pop up message");
           logger.info("Product is added to added to the cart and Successfully displayed the Pop up message");
           // Perform actions or assertions here for the success case
       } else {
           // Success message is not as expected
       	   test.fail("Product is not added to wishlist");
           logger.info("Product is not added to wishlist");
       }
	   }catch(Exception e) {
		   logger.info(e);
	   }
   }
   
 //Home page banner and clp validation
 	public static void verifyPLPProductClick() {
 		test.info("Verify whether the user is able to click product link");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement pdpPage = driver.findElement(By.xpath("//div[contains(@class, 'product-detail product')]"));
     	
     	if (pdpPage.isDisplayed()) {
     	    logger.info("Successfully clicked in the Product link and Navigated to the Product detail page");
     	    test.pass("Successfully clicked in the Product link and Navigated to the Product detail page");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	//Home page banner and clp validation
 	 	public static void verifyPLPQuickshopClick() {
 	 		test.info("verify That Plp Quickshop link");
 	 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
 	     	WebElement Quickshop = driver.findElement(By.xpath("//div[contains(@class, 'product-quickview')]"));
 	     	
 	     	if (Quickshop.isDisplayed()) {
 	     	    logger.info("Successfully clicked in the Quickshop link and Modal window is Displayed");
 	     	    test.pass("Successfully clicked in the Quickshop link and Modal window is Displayed");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
 	 	
 	// add to cart validation in quick shop
 	 	public static void validatingProductisAddtoCart() {
 		   test.info("Verify whether the user is able to add the product to the cart");
 		   try {
 		   List<WebElement> Stocksize = driver.findElements(By.xpath("//div[contains(text(), 'This item is currently not available')]"));
 			test.info("Verify that the product is avaliable");
 		    // Check if the element is present
 		    if (Stocksize.size() > 0) {
 		    	logger.info("Product is  not avaliable");
 		    }else {
 		    	
 		    	Wait<WebDriver> wait = Waits.createFluentWait(driver);
 		        // Wait for the success alert to be visible
 		        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
 		        // Get the text of the alert
 		        String actualAddToCart = addToCart.getText();
 		        // Expected alert text
 		        String expectedAddToCart = "Product added to cart";
 		        if (actualAddToCart.equals(expectedAddToCart)) {
 		            // Success message is displayed
 		        	test.pass("Product added to cart and Successfully displayed the Pop up message");
 		            logger.info("Product is  added to cart and Successfully displayed the Pop up message");
 		            // Perform actions or assertions here for the success case
 		        }else {
 		            // Success message is not as expected
 		        	test.fail("Product is not added to cart");
 		            logger.info("Product is not added to cart");
 		            // Perform actions or assertions here for the failure case
 		         
 		          }
 		    }  
 		    }catch(Exception e) {
 		    	logger.info(e);
 		    }
 		    
 	   }
 	 	
 	 	public static void verifySortby() {
 	 		test.info("Verify whether the user is able to select Sortby fuctionality from the avaliable options");
 			test.pass("Successfully selected the SortBy of "+nameofSelectedSortby);
 		
 	 	}
 	 	
 	 	
	 	public static void verifyHidefilters() {
	 	    test.info("Verify whether the user is able to Click on the Hide filter button");
	 	    if (Actionsss.getSizeOfList(ProductListingPage.gettotalFilterlist())==0) {
	 	        logger.info("Successfully user is clicked on the hide filters and Not dispaing the filter section");
	 	        test.pass("Successfully user is clicked on the hide filters and Not dispaing the filter section");
	 	    } else {
	 	        test.fail("Click failed");
	 	    }
	 	}
	 	
	 	public static void verifyShowfilters() {
	 	    test.info("Verify whether the user is able to Click on the Show filter button");
	 	    if (Actionsss.getSizeOfList(ProductListingPage.gettotalFilterlist())>0) {
	 	        logger.info("Successfully user is clicked on the Show filters and  dispaing the filter section");
	 	        test.pass("Successfully user is clicked on the Show filters and  dispaing the filter section");
	 	    } else {
	 	        test.fail("Click failed");
	 	    }
	 	}
 	 	
	 	
	 	public static void verifyCollapseInPLP() throws InterruptedException {
	 		test.info("Verifying whether the user is able to click on the collapse in filters in PLP page");
	 		if(Actionsss.clickVerify(PLP.getexpandAndCollapse())) {
	 			logger.info("Successfully user is clicked on the collapse in filters in PLP page");
	 	        test.pass("Successfully user is clicked on the  collapse in filters in PLP page");
	 	    } else {
	 	        test.fail("Click failed");
	 	    }
	 	}
	 	
	 	public static void verifyExpandInPLP() throws InterruptedException {
	 		test.info("Verifying whether the user is able to click on the expand in filters in PLP page");
	 		if(Actionsss.clickVerify(PLP.getexpandAndCollapse())) {
	 			logger.info("Successfully user is clicked on the expand in filters in PLP page");
	 	        test.pass("Successfully user is clicked on the expand in filters in PLP page");
	 	    } else {
	 	        test.fail("Click failed");
	 	    }
	 	}
	 	
	 	public static void verifyDefaultAsBestMatchesInPLP() throws InterruptedException {
	 		test.info("Verifying whether the user is able to see BEST MATCHES as default in PLP page");
	 		if(Actionsss.displayElement(PLP.getBestMatchesFilters())) {
	 			logger.info("Successfully verified that the user is able to see BEST MATCHES as default in PLP page");
	 	        test.pass("Successfully verified that the user is able to see BEST MATCHES as default in PLP page");
	 	    } else {
	 	        test.fail("Click failed");
	 	    }
	 	}
	
	
}
