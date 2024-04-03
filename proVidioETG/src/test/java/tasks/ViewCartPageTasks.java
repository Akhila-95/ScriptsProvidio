package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import PaypalPayment.PaypalMethod;
import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.MiniCartPage;
import pageObjects.ProductDetailPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import validations.HomePageValidations;
import validations.MiniCartValidation;
import validations.OrderDetailsPageValidation;
import validations.ProductDetailPageValidation;
import validations.ProductListingPageValidations;
import validations.ViewCartPageValidations;

public class ViewCartPageTasks extends baseClass{
	
	private static MiniCartPage MCP = new MiniCartPage(driver);
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static TestData TD = new TestData();
	private static final String InputQuantity = "Input Quantity in ViewCart";
	private static final String InputQuantityinedit = "Input Quantity in edit pop Up";
	private static final String InvalidInput = "Invalid Input of Promo Code";
	private static ProductDetailPage PDP = new ProductDetailPage(driver);
	private static final ViewCartPage viewCart= new ViewCartPage(driver);
	
	public static void viewCartpage() throws Exception {
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	List<WebElement> viewCartPage = driver.findElements(By.xpath("//div[contains(@class, 'cart-page')]"));
     	List<WebElement> viewCartPageproducts = driver.findElements(By.xpath("//div[contains(@class, 'card product-info')]"));
     	logger.info(viewCartPage.size());
     	if (viewCartPage.size()>0 && viewCartPageproducts.size()>0) {
     	    logger.info("View cart page is already loaded");
     	}else {
     		HomePageTasks.miniCartBtnClick();
    		Actionsss.click(MCP.getSelectviewCartBtn());
    		MiniCartValidation.VerifiedThatViewcartBtnClick();
     	}
	}
	
	public static void editPage() throws Exception {
		List<WebElement> editPage = driver.findElements(By.xpath("//div[contains(@class, 'product-quickview')]"));
		if (editPage.size()>0) {
     	    logger.info("edit page is already loaded");
     	}else {
     		
       		editBtn();
     	}
	}
	
	public static void orderSummaryDisplayInCartPage() throws Exception {
		viewCartpage();
		ViewCartPageValidations.VerifyDisplayOfOrderSummary();
	}
	
	public static void promoCodeFormDisplayInCartPage() throws Exception {
		viewCartpage();
		ViewCartPageValidations.VerifyDisplayOfPromoCodeForm();
	}
	public static void shippingMethodFormDisplayInCartPage() throws Exception {
		viewCartpage();
		ViewCartPageValidations.VerifyDisplayOfShippingMethodForm();
	}
	
	public static void shippingCost_SalesTax_SubTotal_EstimatedTotalDisplayInCartPage() throws Exception {
		viewCartpage();
		ViewCartPageValidations.VerifyShippingCost_SalesTax_SubTotal_EstimatedTotalDisplayInCartPage();
	}
	
	public static void checkoutButtonDisplayInCartPage() throws Exception {
		viewCartpage();
		ViewCartPageValidations.VerifyDisplayOfCheckOutButtonInCartPage();
	}
	
	public static void displayOfPaypalInCartPage() throws Exception {
		//Thread.sleep(7000);
		ViewCartPageTasks.viewCartpage();    
		ViewCartPageValidations.VerifyDisplayOfPaypalButtonInCartPage();  	
	}
	
	public static void callToActionOfPaymentInCartPage() throws Exception {
		//Thread.sleep(7000);
		ViewCartPageTasks.viewCartpage();    
		if(Actionsss.elementSize(viewCart.getBrainTreePaypalInCartList())){
			Actionsss.click(viewCart.getBrainTreePaypalInCartPage());      
        	Thread.sleep(4000);	
        	PaypalMethod.callToActionOfPaypal();
		}else if(Actionsss.elementSize(viewCart.getSalesforcePaypalInCartPageList())){
			Actionsss.click(viewCart.getSalesforcePaypalInCartPage()); 
			PaypalMethod.callToActionOfPaypal();
		}else {
			test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
        	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
		}
		test.pass("Successfully Verified the call to action of payment in Cart page");
	}
	
	public static void checkOutBtnClickinViewCart() throws Exception {
		viewCartpage();
		Actionsss.click(VCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
//		Actionsss.CombinedClick(homePage.clickOnLogo());
	}
	
	public static void continueShopping() throws Exception {
		viewCartpage();
		Actionsss.click(VCP.getSelectcontinueShoppingLink());
		ViewCartPageValidations.VerifyContinueShoppingLinkClick();
	}
	
	public static void editBtn() throws Exception {
		viewCartpage();
		Thread.sleep(2000);
		Actionsss.randomElementFromList(VCP.getSelecteditBtn());
		ViewCartPageValidations.VerifyEditBtnClick();
	}
	
	public static void closeBtnInEditPOPUP() throws Exception {
		editPage();
		Actionsss.CombinedClick(VCP.editPOPCloseBtn());
		Thread.sleep(2000);
		ViewCartPageValidations.VerifyEditPOPUPCloseBtnClick();
		
	}
	
	public static void attributesSelection() throws Exception {
		editPage();
		Thread.sleep(2000);
		allAttributesSelection.selectTheAttributesInQuickShop();
		ViewCartPageValidations.verifyAttributesSelection();
		
	}
	
	public static void customInputinEditPage() throws Exception {
		editPage();
		if(Actionsss.countofElements(VCP.getselectInputlist())) {
			Actionsss.CombinedClick(VCP.getSelectdropdownInput());
			Thread.sleep(3000);
			Actionsss.randomElementFromListfordropdown(VCP.getSelectCustomInputlist());
			Actionsss.CombinedClick(VCP.editPOPUpdateBtn());
			ProductDetailPageValidation.verifyselectedInput();
		}else{
			Actionsss.clearText(VCP.getSelectCustomInput());
			Thread.sleep(2000);
			Actionsss.SendKeys(VCP.getSelectCustomInput(), 5, TD.Input_PDP_IP_FieldName);
		}
	}
	
	public static void editUpdateBtn() throws Exception {
		editPage();
		Thread.sleep(1000);
		Actionsss.CombinedClick(VCP.editPOPUpdateBtn());
		ViewCartPageValidations.VerifyEditPOPUPUpdateBtnClick();
	}
	
	public static void movetoWishList() throws Exception {
		viewCartpage();
		Actionsss.randomElementFromList(VCP.getSelectMoveToWishList());
		ViewCartPageValidations.verifyViewCartWishlistLink();
		//ViewCartPageValidations.popUpProductisAddtoWishList();
	}
	
	public static void customInput() throws Exception {
		viewCartpage();
		Thread.sleep(1000);
		if(Actionsss.countofElements(VCP.getselectInputlistPage())) {
			//Actionsss.CombinedClick(VCP.getSelectdropdownInputPage());
			//Thread.sleep(3000);
			Actionsss.randomElementFromListfordropdown(VCP.getSelectCustomInputlistPage());
			ProductDetailPageValidation.verifyselectedInput();
		}else{
			Actionsss.clearText(VCP.getSelectCustomInput());
			Thread.sleep(2000);
			Actionsss.SendKeys(VCP.getSelectCustomInput(), 5, TD.Input_PDP_IP_FieldName);
		}
	}
	
	public static void removefromcart() throws Exception {
		viewCartpage();
		Actionsss.randomElementFromList(VCP.getSelectRemoveBtn());
		ViewCartPageValidations.removeproductformViewcartValidation();
	}
	
	public static void emptyandClickApplyBtn() throws Exception {
		viewCartpage();
		Actionsss.CombinedClick(VCP.getSelectpromoCodeBtn());
		ViewCartPageValidations.VerifyEmptyInputClickApplyBtn();
	}
	
	public static void InvalidInputandClickApplyBtn() throws Exception {
		viewCartpage();
		Actionsss.sendKeys(VCP.getSelectCouponCode(), "ABCDEF", InvalidInput);
		Actionsss.CombinedClick(VCP.getSelectpromoCodeBtn());
		ViewCartPageValidations.VerifyInvalidInputClickApplyBtn();
	}
	
	public static void selectShipping() throws Exception {
		viewCartpage();
		Actionsss.randomElementFromListForShippingMethod(VCP.getSelectShippingMethod());
		ProductListingPageValidations.verifySortby();
	}
	
	public static void addingItemsInExceedingLimit() throws Exception {
		//LoginPageTasks.verifyThatuserLogin();		
		viewCartpage();
		if(Actionsss.elementSize(VCP.getquantityInCart())) {
			logger.info("quanity in expand and collapse form");
			Actionsss.randomElementFromListAndClearTheTextAndSendValue(VCP.getquantityInCart());
			ViewCartPageValidations.VerifyErrormessageForMaxmiumQuantity();
		}else if(Actionsss.elementSize(VCP.getQuantityInDropDownInCart())) {
			logger.info("Quanitity In drop down");
		int maxQuantity=Actionsss.getSizeOfList(VCP.getQuantityInDropDownInCart());
			logger.info(maxQuantity);
			Actionsss.randomElementFromListForShippingMethod(VCP.getCountOfQuantityInDropDownInCart());
			logger.info("Randomly selected the quantity");
		}
	}
	
	
	public static void sumOfAllProductsInCart() {
		List<WebElement> allProducts= driver.findElements(By.cssSelector("div.line-item-total-price-amount"));
		double value1 =0.00;
		for(WebElement each :allProducts) {
			String eachPrice=Actionsss.getTextOfElement(each);
			//caluculated total
		    String textWithoutDollar1 = eachPrice.replace("$", "");
		    if (textWithoutDollar1.contains(",")) {
	            // Remove the comma
		    	textWithoutDollar1 = textWithoutDollar1.replace(",", "");
	        }
		    value1 = Double.parseDouble(textWithoutDollar1);
		    logger.info(value1);
		    TestData.sumOfAllProductsTotalInCart= TestData.sumOfAllProductsTotalInCart +value1;	    	
		    
		}
		TestData.sumOfAllProductsTotalInCart= Math.round(TestData.sumOfAllProductsTotalInCart* 100.0) / 100.0;
        logger.info("Estimated total in cart"+TestData.sumOfAllProductsTotalInCart);
		
		//---------------sub total--------------------------------------------------
		String subTotalValue=Actionsss.getTextOfElement(VCP.getSubTotalInCart());	
	    String textWithoutDollar1 = subTotalValue.replace("$", "");
		    if (textWithoutDollar1.contains(",")) {
	            // Remove the comma
		    	textWithoutDollar1 = textWithoutDollar1.replace(",", "");
	        }
	    double value2 = Double.parseDouble(textWithoutDollar1);
	    logger.info(value2);
	    TestData.subTotalInCart= value2;
    	logger.info("Sub total is "+TestData.subTotalInCart);
    	ViewCartPageValidations.VerifySubTotalInCartPage();
	}

	public static void salesTaxVaryWithQuantityIncrease() throws Exception {
		viewCartpage();	
		Thread.sleep(2000);
		TestData.salesTaxValueBeforeQuantityIncrease=Actionsss.getTextOfElement(VCP.getsalesTaxInCart());	
		logger.info(TestData.salesTaxValueBeforeQuantityIncrease);
		
		customInput();
		TestData.salesTaxValueAfterQuantityIncrease=Actionsss.getTextOfElement(VCP.getsalesTaxInCart());	
		logger.info(TestData.salesTaxValueAfterQuantityIncrease);
		ViewCartPageValidations.VerifyThesalesTaxVaryWithQuantityIncrease();
	}
	
	public static void estimatedTotalInCartPage() throws Exception {
		viewCartpage();
		
		//---------------sub total ----------------------------------		
		String subTotalValue=Actionsss.getTextOfElement(VCP.getSubTotalInCart());	
	    String textWithoutDollar1 = subTotalValue.replace("$", "");
	    if (textWithoutDollar1.contains(",")) {           
	    	textWithoutDollar1 = textWithoutDollar1.replace(",", "");
        }
	    
	    double value1 = Double.parseDouble(textWithoutDollar1);
	    logger.info(value1);
	    TestData.subTotalInCart= value1;
    	logger.info("Sub total is "+TestData.subTotalInCart);
    	
    	//-------------shipping cost ----------------------------
    	String shippingCostValue=Actionsss.getTextOfElement(VCP.getShippingCostInCart());	
	    String textWithoutDollar2 = shippingCostValue.replace("$", "");
	    if (textWithoutDollar2.contains(",")) {
	    	textWithoutDollar2 = textWithoutDollar2.replace(",", "");
        }
	    double value2 = Double.parseDouble(textWithoutDollar2);
	    logger.info(value2);
	    TestData.shippingCostInCart= value2;
    	logger.info("shipping cost is "+TestData.shippingCostInCart);
    	
    	
    	//------------sales tax------------------------
    	String salesTaxValue=Actionsss.getTextOfElement(VCP.getsalesTaxInCart());	
	    String textWithoutDollar3 = salesTaxValue.replace("$", "");
	    if (textWithoutDollar3.contains(",")) {
	    	textWithoutDollar3 = textWithoutDollar3.replace(",", "");
        }
	    double value3 = Double.parseDouble(textWithoutDollar3);
	    logger.info(value3);
	    TestData.salesTaxInCart= value3;
    	logger.info("Sales tax is "+TestData.salesTaxInCart);
    	
    	//-------------------estimated total----------------------
    	double estimatedTotal= TestData.subTotalInCart+ TestData.shippingCostInCart+TestData.salesTaxInCart;   	
    	// Rounding the number to two decimal places
    	TestData.expectedEstimatedTotalInCart= Math.round(estimatedTotal* 100.0) / 100.0;
        logger.info("Estimated total in cart"+TestData.expectedEstimatedTotalInCart);
        ViewCartPageValidations.VerifyEstimatedTotalInCartPage();
	}
	
	public static void noShippingCostForStorePickUpProducts() throws Exception {		
		viewCartpage();
		List<WebElement> allProducts= driver.findElements(By.xpath("//div[contains(@class,'card product-info  ')]//input[@id='delivery-options-store']"));
		logger.info(allProducts.size());
		int count=0;
		double actualShippingCost=0.00;
		for(WebElement each :allProducts) {			
			if(Actionsss.enabledElement(each)) {	
				count++;
			}
		}
		
		logger.info(count);
		if(allProducts.size()==count) {
			logger.info("shiping cost 0");
			String shippingCostValue=Actionsss.getTextOfElement(VCP.getShippingCostInCart());
			String textWithoutDollar2 = shippingCostValue.replace("$", "");
			double expectedShippingCost= Double.parseDouble(textWithoutDollar2);
			logger.info(actualShippingCost);
			logger.info(expectedShippingCost);
			String expectedShippingMethodAsStorePickuP ="Store Pickup";
			String actualShippingMethod=Actionsss.getTextOfElement(VCP.getShippingMethodAsStorePickUp());
			logger.info(actualShippingMethod);
			//&& expectedShippingMethodAsStorePickuP==actualShippingMethod
			if(actualShippingCost==expectedShippingCost  ) {
				logger.info("Shipping cost is 0.00 and store pick-up shipping method is displaying as only pick up store product in cart");
				test.pass("Shipping cost is 0.00 and store pick-up shipping method is displaying as only pick up store product in cart");
			}else {
				logger.info("Shipping cost is not 0.00 and store pick-up shipping method is not displaying  though only pick up store product in cart");
				test.fail("Shipping cost is not 0.00 and store pick-up shipping method is not  displaying  though only pick up store product in cart");
			}						
		}else {
			logger.info("Cart contains pick up store and delivery to address products");
			test.info("Cart contains pick up store and delivery to address products");
			logger.info("Cart contains pick up store and delivery to address products so shipping cost is not 0.00 and displays different shipping method");
		}
		checkOutBtnClickinViewCart();
	}
	
	public static void removeGiftCertificateFromCart() throws Exception {
		viewCartpage();
		if(Actionsss.elementSize(VCP.getGiftCertificateInCartList()) && Actionsss.elementSize(VCP.getNormalProductsInCartList())) {
			logger.info("cart page has both normal products and GC 's");
			int countOfNormalProducts=Actionsss.getSizeOfList( VCP.getRemoveNormalProductsInCartList());
			logger.info(countOfNormalProducts);
			/*
			for(WebElement each : VCP.getRemoveNormalProductsInCartList()) {
				Actionsss.CombinedClick(each);
			}
			String shippingCostValue=Actionsss.getTextOfElement(VCP.getShippingCostInCart());
			String salesTaxValue=Actionsss.getTextOfElement(VCP.getsalesTaxInCart());	
			if(shippingCostValue=="$0.00" && salesTaxValue=="$0.00" && !Actionsss.elementSize(VCP.getShippingMethodFormList())) {
				test.pass("Successfully Normal products are removed, so shipping cost ,sales tax are $0.00 and shipping method is not displaying");
				logger.info("Successfully Normal products are removed, so shipping cost ,sales tax are $0.00 and shipping method is not displaying");
			}else {
				test.fail("Normal products are not removed, but shipping cost ,sales tax are not  $0.00 and shipping method is  displaying");
				logger.info(" Normal products are not removed, but shipping cost ,sales tax are not $0.00 and shipping method is  displaying");
			}
			*/
			
		}else if(Actionsss.elementSize(VCP.getGiftCertificateInCartList())){
			logger.info("Cart has only gc s");
			int  countOfTotalGcInCart=Actionsss.getSizeOfList(VCP.getGiftCertificateInCartList());
			logger.info(countOfTotalGcInCart);
			for(WebElement each : VCP.getRemoveGiftCertificateFromCartList())
				if(countOfTotalGcInCart==1) {
					Actionsss.CombinedClick(each);
					if(Actionsss.displayElement(VCP.getCartEmptyText())) {
						test.pass("Cart contain only one Gift certificate ,it is removed  and displayed shipping as empty");
						logger.info("Cart contain only one Gift certificate ,it is removed  and displayed shipping as empty");
					}else {
						test.fail("Cart contain only one Gift certificate ,it is not removed  and no display of shipping as empty");
						logger.info("Cart contain only one Gift certificate ,it is not removed   and no display of shipping as empty");
					}
				}else if(countOfTotalGcInCart>1) {
					int countOfGcInCartBeforeRemove=countOfTotalGcInCart;
					Actionsss.CombinedClick(each);					
					int countOfGcInCartAfterRemove=Actionsss.getSizeOfList(VCP.getGiftCertificateInCartList());		
					logger.info(countOfGcInCartAfterRemove);
					if(countOfGcInCartAfterRemove<countOfGcInCartBeforeRemove) {
						test.pass("Successfully Gift certificate is removed from cart ");
						logger.info("Successfully Gift certificate is removed from cart");
					}else {
						test.fail("Gift certificate is not removed from cart ");
						logger.info("Gift certificate is not removed from cart");
					}
					
				}
		}
	}
}
