package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import PaypalPayment.PaypalMethod;
import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.MiniCartPage;
import pageObjects.homepage;
import validations.MiniCartValidation;
import validations.ProductDetailPageValidation;


public class MiniCartPageTasks extends baseClass{
	private static MiniCartPage MCP = new MiniCartPage(driver);
	private static homepage homePage = new homepage(driver);
	private static  TestData TD  = new TestData();
	private static MiniCartPage miniCart = new MiniCartPage(driver);
	
	public static void miniCartValue() throws Exception {
		Thread.sleep(3000);
		WebElement productCountInCart = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
        String countOfMinicart = productCountInCart.getText();
        int minicartProductCountValue = Integer.parseInt(countOfMinicart);
        if(minicartProductCountValue>0) {
        	logger.info("Products are avaliable");
        }else {
        	ProductDetailPageTasks.addtoCart();
        }
	}
	
	public static void minicartClick() throws Exception {
     List<WebElement> miniCartPage = driver.findElements(By.xpath("//h1[contains(text(), 'Your shopping cart')]"));
     	
     	if (miniCartPage.size()>0) {
     		logger.info("Mini cart is already there");
     	}else {
     		HomePageTasks.miniCartBtnClick();
     		
     	}
		
	}
	
	public static void callToActionOfPaypal() throws Exception {
		HomePageTasks.miniCartBtnClick();
		test.info("Verifying the call to action of payment in mini cart");
		if(Actionsss.elementSize(miniCart.getSalesforcePaypalInMiniCartList())) {
 			Actionsss.CombinedClick(miniCart.getSalesforcePaypalInMiniCart());	
 			PaypalMethod.callToActionOfPaypal();
 		}else if(Actionsss.elementSize(miniCart.getBrainTreePaypalInMiniCartList())){
 			Actionsss.click(miniCart.getBrainTreePaypalInMiniCart());
 			PaypalMethod.callToActionOfPaypal();
 		}else {
 			test.info("Cybersouce payment OR stripe payment or Adyen payment integration  is activated so, No paypal for cybersouce,Adyen and stripe");
        	test.pass("No paypal integration for cybersource and stripe  and Adyen payment , choose another integration");
 		}
		
		test.pass("Successfully Verified the call to action of payment in mini cart");
	}
	
	public static void ViewCartbtnClick() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.CombinedClick(MCP.getSelectviewCartBtn());
		MiniCartValidation.VerifiedThatViewcartBtnClick();
	}
	
	public static void checkOutBtnClick() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.CombinedClick(MCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		Actionsss.click(homePage.clickOnLogo());
	}
	
	public static void checkOutBtnClickRegUser() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.CombinedClick(MCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
	}
	
	//remove from the minicart
	public static void removeFromMinicart() throws Exception {
		minicartClick();
		Actionsss.randomElementFromList(MCP.getSelectRemoveBtn());
		MiniCartValidation.removeproductformminicartValidation();
	}
	
	//custom input
	public static void CustomInput() throws Exception{		
		minicartClick();
		if(Actionsss.countofElements(MCP.getselectInputlist())) {
			Actionsss.CombinedClick(MCP.getSelectdropdownInput());
			Thread.sleep(3000);
			Actionsss.randomElementFromListfordropdown(MCP.getSelectCustomInputlist());
			ProductDetailPageValidation.verifyselectedInput();
		}else{
			Actionsss.clearText(MCP.getSelectCustomInput());
			Thread.sleep(2000);
			Actionsss.SendKeys(MCP.getSelectCustomInput(), 5, TD.Input_PDP_IP_FieldName);
		}

	}
	
	public static void closeMiniCart() throws Exception{		
		minicartClick();
		Actionsss.CombinedClick(MCP.getSelectcloseMiniCart());
		Thread.sleep(2000);
		MiniCartValidation.VerifingCloseMinicartBtnClick();
	}
	
	public static void removeGiftCertificateFromMiniCart() throws Exception {
		String countBeforeAddIntoCountInString= Actionsss.getTextOfElement(MCP.getMiniCartCount());
		int countBeforeAddIntoCountInInt= Integer.parseInt(countBeforeAddIntoCountInString);
		logger.info(countBeforeAddIntoCountInInt);
		GiftCertificatePageTasks.giftCertificateForm();	
		String countAfterAddIntoCountInString= Actionsss.getTextOfElement(MCP.getMiniCartCount());
		int countAfterAddIntoCountInInt= Integer.parseInt(countAfterAddIntoCountInString);
		logger.info(countAfterAddIntoCountInInt);
		Actionsss.CombinedClick(homePage.getMiniCartLink());
    	Thread.sleep(2000);
    	MiniCartValidation.VerifiedThatMinicartBtnClick();
        Thread.sleep(3000);
		Actionsss.CombinedClick(MCP.getRemoveProductFromMiniCart());
		String countAfterRemoveFromCountInString= Actionsss.getTextOfElement(MCP.getMiniCartCount());
		int countAfterRemoveCountInInt= Integer.parseInt(countAfterRemoveFromCountInString);
		logger.info(countAfterRemoveCountInInt);
		test.info("Verfiying the removal of product from cart");
		if(countBeforeAddIntoCountInInt==countAfterRemoveCountInInt) {
			logger.info("product is removed from cart");
			test.pass("Succesfully product is removed from cart");
		}else {
			logger.info("product is not removed from cart");
			test.fail("product is not removed from cart");
		}
	}
	
	public static void estimatedCostInMiniCart() throws Exception{	
		//LoginPageTasks.verifyThatuserLogin();		
		minicartClick();
		List<WebElement> allProducts= driver.findElements(By.cssSelector("div.line-item-total-price-amount"));
		for(WebElement each :allProducts) {
			String eachPrice=Actionsss.getTextOfElement(each);
			//caluculated total
			// Check if the string contains a comma
	        if (eachPrice.contains(",")) {
	            // Remove the comma
	        	eachPrice = eachPrice.replace(",", "");
	        }

			
		    String textWithoutDollar1 = eachPrice.replace("$", "");
		    double value1 = Double.parseDouble(textWithoutDollar1);
		    logger.info(value1);
		    TestData.expectedTotalCostInMinicart= TestData.expectedTotalCostInMinicart +value1;
	    	logger.info("Expected cost is "+TestData.expectedTotalCostInMinicart);	
		}
		// estimated total
    	String text=Actionsss.getTextOfElement(MCP.getEstimatedTotal());
    	// Check if the string contains a comma
        if (text.contains(",")) {
            // Remove the comma
        	text = text.replace(",", "");
        }

    	String textWithoutDollar2 = text.replace("$", "");
    	TestData.estimatedTotalInMiniCart = Double.parseDouble(textWithoutDollar2);
    	logger.info("Estimated cost is "+TestData.estimatedTotalInMiniCart);
		MiniCartValidation.VerifingTheEstimatedCost();
	}
}
