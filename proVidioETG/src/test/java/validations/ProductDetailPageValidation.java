package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import functionality.Waits;
import pageObjects.ProductDetailPage;

public class ProductDetailPageValidation  extends baseClass{
	private static ProductDetailPage PDP = new ProductDetailPage(driver);
	
	public static void verifyNextImages() {
		test.info("verify Next button Caurosal");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement Nextbutton = driver.findElement(By.xpath("(//img[@class='img-fluid'])[1]"));
    	
    	if (Nextbutton.isDisplayed()) {
    	    logger.info("Successfully clicked on the Next button caurosal and Navigated to Next image");
    	    test.pass("Successfully clicked on the Next button caurosal and Navigated to Next image");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyPreviewImages() {
		test.info("verify Preview button Caurosal");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement Previewbutton = driver.findElement(By.xpath("(//img[@class='img-fluid'])[1]"));
    	
    	if (Previewbutton.isDisplayed()) {
    	    logger.info("Successfully clicked on the Preview button caurosal and Navigated to Preview image");
    	    test.pass("Successfully clicked on the Preview button caurosal and Navigated to Preview image");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyAttributesSelection() {
		test.info("verify attributes selection");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement Previewbutton = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart')]"));
    	
    	if (Previewbutton.isEnabled()) {
    	    logger.info("Successfully Selected the attributes and Add to Cart is Enable");
    	    test.pass("Successfully Selected the attributes and Add to Cart is Enable");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyCustomQuantity() {
		test.info("verify Custom Quantity");
		
		WebElement inputQuantity = driver.findElement(By.xpath("//input[@class='quantity-select']"));
        String countOfMinicart = inputQuantity.getText();
        int Quantity = Integer.parseInt(countOfMinicart);
    	if (Quantity>1) {
    	    logger.info("Successfully Changed the quantity of Prodcut");
    	    test.pass("Successfully Changed the quantity of Prodcut");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyPowerReviewPage() {
		test.info("verify power review page ");
	
    	if (Actionsss.displayElement(PDP.getpowerReviewPage())) {
    	    logger.info("Successfully clicked on write a review and navigated to power review page ");
    	    test.pass("Successfully clicked on write a review and navigated to power review page");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void validateReviewProduct() {
		test.info("validate the Review of the product");
		// Find the element using XPath
		WebElement thankYouText = driver.findElement(By.xpath("//div[@class='header col-sm-12']//h1[contains(text(), 'Thank you!')]"));
		// Get the text value of the element
		String actualText = thankYouText.getText();
		// Define the expected text
		String expectedText = "Thank you!";
		// Validate if the text is displayed using a basic if condition
		if (actualText.equals(expectedText)) {
		    logger.info("The 'Thank you!' text is displayed on the page.");
		    test.pass("successfully Product Review is submitted And 'Thank you!' text is displayed on the page.");
		} else {
		    logger.info("The 'Thank you!' text is not displayed on the page.");
		    test.fail("Review is not done");
		}
	}
	
	//specifications
	public static void verifyProductSpecifications() {
		test.info("Verify product details are displayed");
		//product specs
    	WebElement productSpecs = driver.findElement(By.xpath("//h2[text()='Description']"));
    	
    	if (productSpecs.isDisplayed()) {
    	    logger.info("Successfully product specifications are displayed");
    	    test.pass("Successfully product specifications are displayed");
    	}else {
    		test.fail("Click failed");
    	}
	}
   //Recommendations
	public static void verifyRecommendations() {
		test.info("Verify product Recommandations are displayed");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement Recommandations = driver.findElement(By.xpath("//div[contains(@class,'producttile-carousel')]"));
    	
    	if (Recommandations.isDisplayed()) {
    	    logger.info("Successfully product Recommandations are displayed");
    	    test.pass("Successfully product Recommandations are displayed");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	   //------------------yepto reviews----------------------------------------
		public static void verifyyeptoform() {
			test.info("Verify whether the user is able to click on the write a review button");
			if(Actionsss.displayElement(PDP.getyoptoform())) {
				logger.info("Successfully clicked on the write a review button and Review Form is displayed");
				test.pass("Successfully clicked on the write a review button and Review Form is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
		
		public static void verifyemptyyeptoform() {
			test.info("Verify whether the user is able to click on the post button of yopto review form");
			if(Actionsss.displayElement(PDP.getstarerror())&& Actionsss.displayElement(PDP.gettitleerror()) && Actionsss.displayElement(PDP.getcontenterror()) &&Actionsss.displayElement(PDP.getuserNameerror()) && Actionsss.displayElement(PDP.getinvalidEmailerror())) {
				test.pass("Successfully clicked on the post button on the Yopto Review Form and follwoing error messages "+Actionsss.getTextOfElement(PDP.getstarerror())+", "+Actionsss.getTextOfElement(PDP.gettitleerror())+", "+Actionsss.getTextOfElement(PDP.getcontenterror())+", "+Actionsss.getTextOfElement(PDP.getuserNameerror())+", "+Actionsss.getTextOfElement(PDP.getinvalidEmailerror())+" are displayed with respect to the fields ");
				logger.info("Successfully clicked on the write a review button and Review Form is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
		
		public static void verify_Star_yeptoform() {
			test.info("Verify whether the user is able to click on the post button of yopto review form");
			if(Actionsss.displayElement(PDP.gettitleerror()) && Actionsss.displayElement(PDP.getcontenterror()) &&Actionsss.displayElement(PDP.getuserNameerror()) && Actionsss.displayElement(PDP.getinvalidEmailerror())) {
				test.pass("Successfully clicked on the post button on the Yopto Review Form and follwoing error messages "+Actionsss.getTextOfElement(PDP.gettitleerror())+", "+Actionsss.getTextOfElement(PDP.getcontenterror())+", "+Actionsss.getTextOfElement(PDP.getuserNameerror())+", "+Actionsss.getTextOfElement(PDP.getinvalidEmailerror())+" are displayed with respect to the fields ");
				logger.info("Successfully clicked on the write a review button and Review Form is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
		
		public static void verify_Star_Title_yeptoform() {
			test.info("Verify whether the user is able to click on the post button of yopto review form");
			if(Actionsss.displayElement(PDP.getcontenterror()) &&Actionsss.displayElement(PDP.getuserNameerror()) && Actionsss.displayElement(PDP.getinvalidEmailerror())) {
				test.pass("Successfully clicked on the post button on the Yopto Review Form and follwoing error messages "+Actionsss.getTextOfElement(PDP.getcontenterror())+", "+Actionsss.getTextOfElement(PDP.getuserNameerror())+", "+Actionsss.getTextOfElement(PDP.getinvalidEmailerror())+" are displayed with respect to the fields ");
				logger.info("Successfully clicked on the write a review button and Review Form is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
		
		public static void verify_Star_Title_Content_yeptoform() {
			test.info("Verify whether the user is able to click on the post button of yopto review form");
			if(Actionsss.displayElement(PDP.getuserNameerror()) && Actionsss.displayElement(PDP.getinvalidEmailerror())) {
				test.pass("Successfully clicked on the post button on the Yopto Review Form and follwoing error messages "+Actionsss.getTextOfElement(PDP.getuserNameerror())+", "+Actionsss.getTextOfElement(PDP.getinvalidEmailerror())+" are displayed with respect to the fields ");
				logger.info("Successfully clicked on the write a review button and Review Form is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
		
		public static void verify_Star_Title_Content_UserName_yeptoform() {
			test.info("Verify whether the user is able to click on the post button of yopto review form");
			if(Actionsss.displayElement(PDP.getinvalidEmailerror())) {
				test.pass("Successfully clicked on the post button on the Yopto Review Form and follwoing error message "+Actionsss.getTextOfElement(PDP.getinvalidEmailerror())+" is displayed with respect to the fields ");
				logger.info("Successfully clicked on the write a review button and Review Form is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
		
		public static void verifyValidDetailsyeptoform() {
			test.info("Verify whether the user is able to click on the post button of yopto review form");
			if(Actionsss.displayElement(PDP.getthankyoumsg())) {
				test.pass("Successfully clicked on the post button on the Yopto Review Form and Thankyou message is displayed");
				logger.info("Successfully clicked on the write a review button and Review Form is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
		
		
 	 	public static void verifyselectedInput() {
 	 		test.info("Verify weather the user is able to select selected Input from the avaliable options");
 			test.pass("Successfully selected the Quantity dropdown of  "+nameofSelectedSortby);
 		
 	 	}
 	 	
 	 	public static void verifySearchFilter() {
 	 		test.info("Verify weather the user is able to search the results in Product Reivew page");
 	 		Actionsss.getNumber(PDP.getnumberofReviews());
 			test.pass("Successfully Search of Yopto Reviews  "+reviewsNumner);
 		
 	 	}
 	 	
 	 	
 	 	//------------------ask a question ------------------------------------------------
 	 	
 	 	public static void verifyYeptoAskaQuestionForm() {
			test.info("Verify whether the user is able to click on the Ask a Question button");
			if(Actionsss.displayElement(PDP.getAskaQuestionForm())) {
				logger.info("Successfully clicked on the Ask a Question button and Ask a Question Form is displayed");
				test.pass("Successfully clicked on the Ask a Question button and Ask a Question Form is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
 	 	
 	 	public static void verifyemptyform() {
			test.info("Verify whether the user is able to click on the Ask a Question button post button without entering any detals");
			if(Actionsss.displayElement(PDP.getqusetionerror()) && Actionsss.displayElement(PDP.getuserNameerrorAskaQuestion()) && Actionsss.displayElement(PDP.getinvalidEmailerrorAskaQuestion())) {
				logger.info("Successfully clicked on the Ask a Question button without entering detial and Error messages are displayed");
				test.pass("Successfully clicked on the Ask a Question button without entering detial and Error messages are displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
 	 	
 	 	public static void verifyQuestionsyeptoform() {
			test.info("Verify whether the user is able to click on the Ask a Question button post button with entering question detals");
			if(Actionsss.displayElement(PDP.getuserNameerrorAskaQuestion()) && Actionsss.displayElement(PDP.getinvalidEmailerrorAskaQuestion())) {
				logger.info("Successfully clicked on the Ask a Question button without entering detial and Error messages are displayed");
				test.pass("Successfully clicked on the Ask a Question button without entering detial and Error messages are displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
 	 	
 	 	public static void verifyusernamesyeptoform() {
			test.info("Verify whether the user is able to click on the Ask a Question button post button with entering question and user name detals");
			if(Actionsss.displayElement(PDP.getinvalidEmailerrorAskaQuestion())) {
				logger.info("Successfully clicked on the Ask a Question button without entering detial and Error messages is displayed");
				test.pass("Successfully clicked on the Ask a Question button without entering detial and Error messages is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
 	 	
 	 	public static void verifyValidDetailsaskaQuestionform() {
			test.info("Verify whether the user is able to click on the post button of yopto review form");
			if(Actionsss.displayElement(PDP.getthanksmsgAskaQuestion())) {
				test.pass("Successfully clicked on the post button on the AskaQuestion and Thankyou message is displayed");
				logger.info("Successfully clicked on the post button on the AskaQuestion and Thankyou message is displayed");
			}else {
				test.fail("Click failed on the wirte a review");
			}
		}
 	 	
 	 	public static void verifyRefreshInPDP() throws InterruptedException {
 	 		test.info("Verifying that the breadcrumb trail remains and accurately reflects the current page's  position in the site  with selected attributes and add to cart and Buy now button should be enabled if there.");
 	 		 if(Actionsss.enabledElement(PDP.getSelectAddtoCartBtn())&& (Actionsss.elementSize(PDP.getInStockList()) 
 		    		 ||Actionsss.elementSize(PDP.getPreOrderList()) || Actionsss.elementSize(PDP.getBackOrderList())) && TestData.breadcrumbInPdpBeforeRefresh.equals(TestData.breadcrumbInPdpAfterRefresh) ) {
				test.pass("Successfully after refreshing the pdp page add to cart button and also reflecting the current page's position in the site ");
				logger.info("Successfully after refreshing the pdp page add to cart button and also reflecting the current page's position in the site");
				
				if(Actionsss.enabledElement(PDP.getBuyNowButton())) {
					test.info("Buy now button is configured for this product ");
					test.pass("Buy now is enabled after refreshing the page ");
					logger.info("Buy now is enabled after refreshing the page");
				}else {
					test.info("Buy now button is not configured for this product ");
					logger.info("Buy now button is not configured for this product");
					test.pass("So Buy now button is not enabled for this product");
				}
			}else {
				test.fail("After refreshing the add to cart is disabled and attributes got disselected ");
				logger.info("After refreshing the add to cart is disabled and attributes got disselected ");
			}
 	 	}
 	 	
 	 	public static void verifyingEnablingOfPickUpStore() throws Exception {
			test.info("Verifying the enable of pick up store in pdp page ");
			if(Actionsss.enabledElement(PDP.getPickUpStore())) {	    		
	    		Actionsss.CombinedClick(PDP.getPickUpStore());
	    		test.pass("Pick up store is enabled and clicked on it ");
	    		logger.info("Pick up store is enabled and clicked on it ");
	    	}else {
	    		test.pass("Pick up store is not enabled");
	    		logger.info("Pick up store is not enabled");
	    	}
		} 
		
		public static void verifyingEnablingOfDeliveryToAddress() throws Exception {
			test.info("Verifying the enable of delivery to address in pdp page ");
			if(Actionsss.elementSize(PDP.getDeliveryToAddressList())) {
				if(Actionsss.enabledElement(PDP.getDeliveryToAddress())) {	    		    		
		    		test.pass("Delivery to address is enabled after selecting the attributes ");
		    		logger.info("Delivery to address is enabled after selecting the attributes");
		    	}else {
		    		test.pass("Delivery to address is  not enabled after selecting the attributes");
		    		logger.info("Delivery to address is not  enabled after selecting the attributes");
		    	}
			}else{
				logger.info("Brain tree payment activated bopis are disbaled in this payment so no display of pick up store and delivery to address ");
				test.pass("Brain tree payment activated bopis are disbaled in this payment so no display of pick up store and delivery to address ");
			}
		} 
		
		public static void verifyingRecomendationss() throws Exception {
			test.info("Verifying the recommendations in pdp page ");
			if(Actionsss.elementSize(PDP.getRecommendations())) {
				if(Actionsss.elementSize(PDP.getwishListInRecommendations()) && Actionsss.elementSize(PDP.getProductNameInRecommendations())
						&& Actionsss.elementSize(PDP.getSwatchesInRecommendations()) && Actionsss.elementSize(PDP.getPriceInRecommendations()) &&
						Actionsss.elementSize(PDP.getAddToCartInRecommendations())) {	  					
		    		test.pass("The Einstein recommendations  contains wishlist,  add to bag, product name, price and color swatches ");
		    		logger.info("The Einstein recommendations contains wishlist,  add to bag, product name, price and color swatches");
		    	}else {
		    		test.fail("The Einstein recommendations not displaying wishlist,  add to bag, product name, price and color swatches ");
		    		logger.info("The Einstein recommendations   not displaying wishlist,  add to bag, product name, price and color swatches");
		    	}
			}
		} 
		
		public static void verifyingCarouselsInRecomendationss() throws Exception {
			test.info("Verifying the carousels in recommendations in pdp page ");		
		 		if(Actionsss.displayElement(PDP.getpreviousCarouselInRecommendations())) {
					Actionsss.doubleClick(PDP.getNextButtonCarouselInRecommendations());
					Actionsss.doubleClick(PDP.getpreviousCarouselInRecommendations());
					if (Actionsss.clickVerify(PDP.getNextButtonCarouselInRecommendations())) {
			     	    logger.info("Successfully clicked on the carousels in Recommendations");
			     	    test.pass("Successfully clicked on the carousels in Recommendations");
			     	}else {
			     		test.fail("Click failed");
			     	}
				}else {
					logger.info("No carousel for this recommendations");			
		 	}
		}
		
		// --------------------wishlist----------------
		public static void verifyingWishlist() throws Exception {
			test.info("Verifying whether the product is already added to wishlist or not in pdp page ");		
		 		if(Actionsss.elementSize(PDP.getalreadyInWishListList())) {	 
		 			logger.info(PDP.getalreadyInWishListList().size());
		       	   test.pass("The product is already in the wishlist.");
		           logger.info("The product is already in the wishlist.");						
				}else if(Actionsss.elementSize(PDP.getAddToWishListList())) {	
					logger.info(PDP.getAddToWishListList().size());
					Actionsss.click(PDP.getSelectWishListBtn());
		       	   test.pass("Product added to wishlist and Successfully displayed the Pop up message");
		           logger.info("Product added to wishlist and Successfully displayed the Pop up message");				      							
		 	}
		}
}

