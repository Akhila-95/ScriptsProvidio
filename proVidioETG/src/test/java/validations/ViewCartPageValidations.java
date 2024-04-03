package validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import PaypalPayment.PaypalMethod;
import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import functionality.Waits;
import pageObjects.ViewCartPage;

public class ViewCartPageValidations extends baseClass{
	private static ViewCartPage VCP = new ViewCartPage(driver);
        //continue shopping btn
	 	public static void VerifyContinueShoppingLinkClick() {
	 		test.info("Verify Continue Shopping Link");
	 		List<WebElement> viewCartPage = driver.findElements(By.xpath("//div[@class='col-sm-7 col-md-8']"));
	     	if (viewCartPage.size()<1) {
	     	    logger.info("Successfully Clicked on the Continue Shopping Link");
	     	    test.pass("Successfully Clicked on the Continue Shopping Link");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
	 	//edit button
	 	public static void VerifyEditBtnClick() {
	 		test.info("Verify Edit button click");
	 		WebElement editPOP = driver.findElement(By.xpath("//div[contains(@class, 'product-quickview')]"));
	     	if (editPOP.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the Edit button");
	     	    test.pass("Successfully Clicked on the Edit button");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
	 	//edit button
	 	public static void VerifyEditPOPUPCloseBtnClick() {
	 		test.info("Verify Edit Pop up close button click");
	 		WebElement editPOP = driver.findElement(By.xpath("//div[contains(@class, 'product-quickview')]"));
	     	if (!editPOP.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the Edit Pop up close button");
	     	    test.pass("Successfully Clicked on the Edit Pop up close button");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
	 	//edit button
	 	public static void VerifyEditPOPUPUpdateBtnClick() {
	 		test.info("Verify Edit Pop up Update button click");
	 		WebElement editPOP = driver.findElement(By.xpath("//div[contains(@class, 'product-quickview')]"));
	     	if (!editPOP.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the Edit Pop up Update button");
	     	    test.pass("Successfully Clicked on the Edit Pop up Update button");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
	 	//attributes in edit page
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
	 	
	 	public static void removeproductformViewcartValidation() {
	  	   test.info("Verify product is romoved from ViewCart");
	  	   
	  	   Wait<WebDriver> wait = Waits.createFluentWait(driver);
	         // Wait for the success alert to be visible
	         WebElement removeproduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Product Removed from cart']")));
	         // Get the text of the alert
	         String removeproductfromcart = removeproduct.getText();
	         // Expected alert text
	         String expectedAddToCart = "Product Removed from cart";
	         
	         if (removeproductfromcart.equals(expectedAddToCart)) {
	             // Success message is displayed
	         	   test.pass("Successfully product is removed from the View-Cart and Pop up Message is Displayed");
	             logger.info("Successfully product is removed from the View-Cart and Pop up Message is Displayed");
	             // Perform actions or assertions here for the success case
	         }else {
	             // Success message is not as expected
	         	   test.fail("product is not removed from the cart");
	             logger.info("product is not removed from the cart");
	             //System.out.println("The product is not added to cart because it should show: " + expectedAddToCart + " but found: " + actualAddToCart);
	             // Perform actions or assertions here for the failure case
	          
	           }
	     }
	 	

		//validation pop up add ot wishlist, //div[text() ='The product has been added to your wishlist.']
	   public static void popUpProductisAddtoWishList() {
		   test.info("Verify product is added to the wishlist");
		   // Create a FluentWait for dynamic element wait
		   Wait<WebDriver> wait = Waits.createFluentWait(driver);
	       // Wait for the success alert to be visible
	       WebElement addTowishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'add-to-basket-alert')]")));
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
	   
	 //Home page my fav link
		public static void verifyViewCartWishlistLink() {
			test.info("verify Wishlist Link ");

			List<WebElement> guest = driver.findElements(By.xpath("//div[@class='user mr-3 d-none d-lg-block']//span[@class='user-message']"));
			if(guest.size()>0) {
				logger.info("guest");
			// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
	    	WebElement wishListHeader = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	    	
	    	if (wishListHeader.isDisplayed()) {
	    	    logger.info("Successfully clicked on the Wishlist Link and Navigated to the Wishlist Page");
	    	    test.pass("Successfully clicked on the Wishlist Link and Navigated to the Wishlist Page");
	    	}else {
	    		test.fail("Click failed");
	    	}
			}else {
				logger.info("register");
			}
		}
		
		//empty and click on apply button
	 	public static void VerifyEmptyInputClickApplyBtn() {
	 		test.info("Verify Empty Input and Click on Apply button");
	 		WebElement emptyError = driver.findElement(By.xpath("//span[@id='missingCouponCode']"));
	     	if (emptyError.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the Apply button and DisPlayedError message missing Coupon Code");
	     	    test.pass("Successfully Clicked on the Apply button and DisPlayedError message missing Coupon Code");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
	 	//input dummy text and click on apply button
	 	public static void VerifyInvalidInputClickApplyBtn() {
	 		test.info("Verify Invalid Input and Click on Apply button");
	 		WebElement InvalidError = driver.findElement(By.xpath("//span[@id='invalidCouponCode']"));
	     	if (InvalidError.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the Apply button and DisPlayedError message invalid Coupon Code");
	     	    test.pass("Successfully Clicked on the Apply button and DisPlayedError message invalid Coupon Code");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
		//exceed quantity limit
	 	public static void VerifyErrormessageForMaxmiumQuantity() {
	 		test.info("Verifying the error message for exceeding the increase in quantity in cart ");
	 		
	     	if (Actionsss.displayElement(VCP.getMaximiumQuantityError())) {
	     	    logger.info("Error message is displayed when quantity exceeded than available and moving to previous selected value and the errro message is "+ Actionsss.getTextOfElement(VCP.getMaximiumQuantityError()));
	     	    test.pass("Error message is displayed when quantity exceeded than available and moving to previous selected value " +Actionsss.getTextOfElement(VCP.getMaximiumQuantityError()));
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}

	 	//display of order summary
	 	public static void VerifyDisplayOfOrderSummary() {
	 		test.info("Verifying the display of order summary in cart page");	 		
	     	if (Actionsss.displayElement(VCP.getOrderSummary())) {
	     	    logger.info("Order summary is displayed in cart page");
	     	    test.pass("Order summary is displayed in cart page");
	     	}else {
	     		test.fail("Order summary is not displayed in cart page");
	     		logger.info("Order summary is not displayed in cart page");
	     	}
	 	}	 
	 	
	 	//display of order summary
	 	public static void VerifyDisplayOfPromoCodeForm() {
	 		test.info("Verifying the display of promo code form in cart page");	 		
	     	if (Actionsss.displayElement(VCP.getPromoCodeForm())) {
	     	    logger.info("Promo code form is displayed in cart page");
	     	    test.pass("Promo code form is displayed in cart page");
	     	}else {
	     		test.fail("Promo code form is not displayed in cart page");
	     		logger.info("Promo code form is not displayed in cart page");
	     	}
	 	}
	 	
	 	//display of order summary
	 	public static void VerifyDisplayOfShippingMethodForm() {
	 		test.info("Verifying the display of shipping method  in cart page");	 		
	     	if (Actionsss.displayElement(VCP.getShippingMethodForm())) {
	     	    logger.info("Shipping methods are displayed in cart page");
	     	    test.pass("Shipping methods are displayed in cart page");
	     	}else {
	     		test.fail("Shipping methods are not displayed in cart page");
	     		logger.info("Shipping methods are not displayed in cart page");
	     	}
	 	}
	 	
	 	//display of order summary
	 	public static void VerifyShippingCost_SalesTax_SubTotal_EstimatedTotalDisplayInCartPage() {
	 		test.info("Verifying the display of shippingCost, SalesTax, SubTotal and EstimatedTotal in cart page");	 		
	     	if (Actionsss.displayElement(VCP.getSubTotalLabelInCart()) && Actionsss.displayElement(VCP.getsalesTaxLabelInCart()) && Actionsss.displayElement(VCP.getShippingCostLabelInCart()) && Actionsss.displayElement(VCP.getEstimatedTotalInCartInCart()))	 {
	     	    logger.info("ShippingCost, SalesTax, SubTotal and EstimatedTotal are Displayed in cart page");
	     	    test.pass("ShippingCost, SalesTax, SubTotal and EstimatedTotal are Displayed in cart page");
	     	}else {
	     		test.fail("ShippingCost, SalesTax, SubTotal and EstimatedTotal are not Displayed in cart page");
	     		logger.info("ShippingCost, SalesTax, SubTotal and EstimatedTotal are not Displayed in cart page");
	     	}
	 	}	
	 	

	 	//display of order summary
	 	public static void VerifyDisplayOfCheckOutButtonInCartPage() {
	 		test.info("Verifying the display of check out button in cart page");	 		
	     	if (Actionsss.displayElement(VCP.getSelectcheckOutBtn()))	 {
	     	    logger.info("Check out button is Displayed in cart page");
	     	    test.pass("Check out button is Displayed in cart page");
	     	}else {
	     		test.fail("Check out button is not Displayed in cart page");
	     		logger.info("Check out button is not Displayed in cart page");
	     	}
	 	}	
	 
	 
	 	
		//display of order summary
	 	public static void VerifyDisplayOfPaypalButtonInCartPage() throws Exception {
	 		test.info("Verifying the display of paypal button in cart page");	 		
	     	if (Actionsss.elementSize(VCP.getBrainTreePaypalInCartList())){
	     		test.info("Brain tree is activated");
	     		if(Actionsss.displayElement(VCP.getBrainTreePaypalInCartPage())) {		     	   
	     			test.pass("Paypal button is displayed in cart page");
	     			logger.info("Paypal button is  displayed in cart page");		     	  
	     		}else {
	     			test.fail("Paypal button is not displayed in cart page");
	     			logger.info("Paypal button is not displayed in cart page");
	     		}
     		}else if(Actionsss.elementSize(VCP.getSalesforcePaypalInCartPageList())) {
     			test.info("Salesforce is activated");
     			if(Actionsss.displayElement(VCP.getSalesforcePaypalInCartPage())) {
		     		test.pass("Paypal button is Displayed in cart page");
		     		logger.info("Paypal button is Displayed in cart page");		     		
     			}else {
	     			test.fail("Paypal button is not displayed in cart page");
	     			logger.info("Paypal button is not displayed in cart page");
	     		}   		
	     	}else {	     		
	            	test.info("Cybersouce OR stripe OR Adyen payment integration  is activated so, No paypal for cybersouce, stripe and Adyen");
	            	test.pass("No paypal integration for cybersource ,Adyen and stripe , choose another integration to display the paypal button in cart page");	           
	     	}
	 	}	
	 	
	 	//display of order summary
	 	public static void VerifyEstimatedTotalInCartPage() {
	 		test.info("Verifying the estimated total  in cart page");
	 		String value1 =Actionsss.getTextOfElement(VCP.getEstimatedTotalInCartInCart());
	 		String textWithoutDollar1 = value1.replace("$", "");
	 		 if (textWithoutDollar1.contains(",")) {
	             // Remove the comma
	 			textWithoutDollar1 = textWithoutDollar1.replace(",", "");
	         }
		    double actualEstimatedPrice  = Double.parseDouble(textWithoutDollar1);
		    logger.info(actualEstimatedPrice);
		    logger.info(TestData.expectedEstimatedTotalInCart);		    
	     	if(TestData.expectedEstimatedTotalInCart ==actualEstimatedPrice)	 {
	     	    logger.info("Calculated the estimated total the expected total is " +TestData.expectedEstimatedTotalInCart +" and actual estimated total is " + actualEstimatedPrice);
	     	    test.pass("Calculated the estimated total the expected total is " +TestData.expectedEstimatedTotalInCart +" and actual estimated total is " + actualEstimatedPrice);
	     	}else {
	     		test.fail("Calculated the estimated total the expected total is  " +TestData.expectedEstimatedTotalInCart +" and actual estimated total is " + actualEstimatedPrice +"are not same");
	     		logger.info("Calculated the estimated total the expected total is " +TestData.expectedEstimatedTotalInCart +" and actual estimated total is" + actualEstimatedPrice +"are not same");
	     	}
	 	}	
	 	
		//display of order summary
	 	public static void VerifySubTotalInCartPage() {
	 		test.info("Verifying the sub-total  in cart page");
	 		String subTotalValue=Actionsss.getTextOfElement(VCP.getSubTotalInCart());	
		    String textWithoutDollar1 = subTotalValue.replace("$", "");
		    if (textWithoutDollar1.contains(",")) {
	            // Remove the comma
		    	textWithoutDollar1 = textWithoutDollar1.replace(",", "");
	        }
		    double value1 = Double.parseDouble(textWithoutDollar1);
		    logger.info(value1);
		    TestData.subTotalInCart= value1;
	    	logger.info("Sub total is "+TestData.subTotalInCart);
		    logger.info(TestData.subTotalInCart);
		    logger.info(TestData.sumOfAllProductsTotalInCart);		    
	     	if(TestData.sumOfAllProductsTotalInCart ==TestData.subTotalInCart)	 {
	     	    logger.info("Calculated the sub total is " +TestData.sumOfAllProductsTotalInCart +" and actual sub total is " + TestData.subTotalInCart);
	     	    test.pass("Calculated the sub total is " +TestData.sumOfAllProductsTotalInCart +" and actual sub total is " + TestData.subTotalInCart);
	     	}else {
	     		test.fail("Calculated the sub total  is  " +TestData.sumOfAllProductsTotalInCart +" and sub total  is " + TestData.subTotalInCart +"are not same");
	     		logger.info("Calculated the sub total is " +TestData.sumOfAllProductsTotalInCart +" and sub total  is" + TestData.subTotalInCart +"are not same");
	     	}
	 	}	
	 	
	 	//display of order summary
	 	public static void VerifyThesalesTaxVaryWithQuantityIncrease() {
	 		test.info("Verifying the vary in sales tax by increasing the quantity of product in cart page");
	 			    
	     	if(!(TestData.salesTaxValueBeforeQuantityIncrease ==TestData.salesTaxValueAfterQuantityIncrease))	 {
	     	    logger.info("Sales tax varied by increasing the quantity of products tax before increase in qunatity is  " +TestData.salesTaxValueBeforeQuantityIncrease +" and after increase in quantity " + TestData.salesTaxValueAfterQuantityIncrease);
	     	    test.pass("Sales tax varied by increasing the quantity of products tax before increase in qunatity is  " +TestData.salesTaxValueBeforeQuantityIncrease +" and after increase in quantity " + TestData.salesTaxValueAfterQuantityIncrease);
	     	}else {
	     		test.fail("Sales tax is not varied by increasing the quantity of products tax before increase in qunatity is  " +TestData.salesTaxValueBeforeQuantityIncrease +" and after increase in quantity " + TestData.salesTaxValueAfterQuantityIncrease);
	     		logger.info("Sales tax is not varied by increasing the quantity of products tax before increase in qunatity is  " +TestData.salesTaxValueBeforeQuantityIncrease +" and after increase in quantity " + TestData.salesTaxValueAfterQuantityIncrease);
	     	}
	 	}	
	 	
	 	
}




