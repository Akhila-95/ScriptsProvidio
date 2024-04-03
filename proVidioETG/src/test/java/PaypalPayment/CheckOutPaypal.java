package PaypalPayment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.OrderPageDetails;
import pageObjects.PaymentPage;
import pageObjects.homepage;
import tasks.PaymentPageTasks;
import validations.OrderDetailsPageValidation;
import validations.PaymentPageValidation;

public class CheckOutPaypal extends baseClass{

	private static final PaymentPage paymentPage = new PaymentPage(driver);
	private static homepage homePage = new homepage(driver);
	private static OrderPageDetails  orderPage = new OrderPageDetails(driver);
	
	public static void paypalFromCheckout() throws InterruptedException, Exception {
		
		Actionsss.scrollWindowsByPixel(500);
		 test.info("Verifying payment with checkout paypal");
		if(Actionsss.elementSize(paymentPage.getBrainPaypalAcc())) {	 
			
    		test.info("Brain tree payment integration is activated");    		   
    		Actionsss.javascriptClick(paymentPage.getBrainTreePaypalButton());
    		Thread.sleep(7000);
				logger.info("A click to Enter into paypal");
				if(Actionsss.elementSize(paymentPage.getSelectPaypalAccountLabelList())) {
					String rahulNayak=TestData.rahulNayakPaypalUserName;
					String pushpaAccount=TestData.pushpaPaypalUserName;
					if(Actionsss.displayElement(paymentPage.getSelectPaypalAccountLabel())) {
						test.info("User is logged in as register");
						
						Actionsss.CombinedClick(paymentPage.getpaypalDropDown());
						int countOfAddedPaypalAcc=Actionsss.getSizeOfList(paymentPage.getStoredPaypalAccountList());
						logger.info(countOfAddedPaypalAcc);
						Thread.sleep(3000);
						String each1="";
						for(WebElement each:paymentPage.getStoredPaypalAccountList()) {
							String text= Actionsss.getTextOfElement(each);
							each1=text;
							logger.info(each1);
						}
							int expectedPaypalAddedCount=2;
							if(countOfAddedPaypalAcc==expectedPaypalAddedCount){
								test.pass("Payapl Accounts are already added ,no new account to add so randomly selecting the saved account");
								Actionsss.randomElementFromListForShippingMethod(paymentPage.getStoredPaypalAccountList());
								Thread.sleep(3000);
						    	Actionsss.scrollWindowsByPixel(200);
						    	Actionsss.click(paymentPage.getReviewOrderBtn());
							}else if(countOfAddedPaypalAcc<2) {
								logger.info(rahulNayak);
								logger.info(pushpaAccount);
								logger.info("sdfs");
								if(each1.equals(rahulNayak)) {
									logger.info("sdfsss");
									Actionsss.CombinedClick(paymentPage.getNewPaypalAccount());
									Thread.sleep(2000);	  
									Actionsss.CombinedClick(paymentPage.getBrainTreePaypalButton2());
									Thread.sleep(5000);
									PaypalMethod.paypalPopupWithPushpaAccount();
								}else if (each1.equals(pushpaAccount)) {
									logger.info("sdfsssssssss");
									Actionsss.CombinedClick(paymentPage.getNewPaypalAccount());
									Thread.sleep(2000);
									//brainTreeAfterClick();
									Actionsss.CombinedClick(paymentPage.getBrainTreePaypalButton2());
									Thread.sleep(5000);
									PaypalMethod.paypalPopupWithRahulNayakAccount();
								}						
				    	logger.info("Clicked on paypal button");	
				    	Thread.sleep(1000);
						}
				    	
				    	
					}else if(Actionsss.elementSize(paymentPage.getSavePaypalAccountList())){
						if(Actionsss.displayElement(paymentPage.getSavePaypalAccount())) {
							test.info("User is logged in as register and don't have saved accounts");
							if(Actionsss.enabledElement(paymentPage.getSavePaypalAccount())) {
								test.pass("By default save paypal account is enabled in registered user");
								logger.info("By default save paypal account is enabled in registered user");
							}else {
								test.fail("Save paypal account is not enabled by default");
								logger.info("Save paypal account is not enabled by default");
							}
							//brainTreeAfterClick();
							Actionsss.CombinedClick(paymentPage.getBrainTreePaypalButton2());
							Thread.sleep(8000);
							PaypalMethod.paypalPopupWithRahulNayakAccount();
						}
					}
					else {
						test.info("User is logged-in as guest");
						//brainTreeAfterClick();
						Actionsss.CombinedClick(paymentPage.getBrainTreePaypalButton2());
						Thread.sleep(8000);
						PaypalMethod.paypalPopupWithRahulNayakAccount();
					}
					
				}
				if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
					if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
					logger.info("Salesforce payment activated");			
					Thread.sleep(8000);		
					OrderDetailsPageValidation.paymentInOrderConfirmationPage();
					OrderDetailsPageValidation.validatePlacetheOrderPage();
					OrderDetailsPageValidation.orderNumberAndOrderDate();
					Actionsss.click(homePage.clickOnLogo());
					}
				}
				else if(Actionsss.elementSize(paymentPage.getSelectPlaceOrderBtnList())) {	
					logger.info("Other paymnet activated");
					logger.info("Place order page is loaded");
					Actionsss.scrollWindowsByPixel(500);
					Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
					Thread.sleep(8000);
					PaymentPageValidation.VerifiedThatPlaceOrderClick();
					Thread.sleep(1000);
					OrderDetailsPageValidation.paymentInOrderConfirmationPage();
					OrderDetailsPageValidation.validatePlacetheOrderPage();
					OrderDetailsPageValidation.orderNumberAndOrderDate();
					Actionsss.click(homePage.clickOnLogo());
				}
			
    		
    	}else if(Actionsss.elementSize(paymentPage.getSalesforcePaypalList())) {	 
    	
    		test.info("salesoforce payment integration is activated");  
		    Thread.sleep(1000);
		    PaypalMethod.salesforcePaypalCheckout();
		    logger.info("Clicked on paypal button after clicking on paypal icon");
		    Thread.sleep(8000);
		    PaypalMethod.paypalPopupWithRahulNayakAccount();
	    	logger.info("Clicked on paypal button");
	    	Thread.sleep(1000);
			if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
				if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
				logger.info("Salesforce payment activated");			
				Thread.sleep(8000);		
				OrderDetailsPageValidation.paymentInOrderConfirmationPage();
				OrderDetailsPageValidation.validatePlacetheOrderPage();
				OrderDetailsPageValidation.orderNumberAndOrderDate();
				Actionsss.click(homePage.clickOnLogo());
				}
			}
			else if(Actionsss.elementSize(paymentPage.getSelectPlaceOrderBtnList())) {	
				logger.info("Other paymnet activated");
				logger.info("Place order page is loaded");
				Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
				Thread.sleep(8000);
				PaymentPageValidation.VerifiedThatPlaceOrderClick();
				Thread.sleep(1000);
				OrderDetailsPageValidation.paymentInOrderConfirmationPage();
				OrderDetailsPageValidation.validatePlacetheOrderPage();
				OrderDetailsPageValidation.orderNumberAndOrderDate();
				Actionsss.click(homePage.clickOnLogo());
			}
	    	
    	}else {
    		test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
        	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
    	}
	  }



//After the paypal button click
public static void brainTreeAfterClick() throws InterruptedException {
    WebElement parentDiv= driver.findElement(By.xpath("//a[contains(@class, 'paypal-tab active')]"));               
    WebElement regPaypalCheckoutText=parentDiv.findElement(By.xpath("//label[contains(text(),'Select a PayPal account')]"));
    if(regPaypalCheckoutText.isDisplayed()) {                	 
   	  
   	 
    }else { 
        JavascriptExecutor js = (JavascriptExecutor) driver;  
        WebElement paypalCheckout=driver.findElement(By.xpath("//div[@class='js_braintree_paypal_billing_button']")); 
        if(paypalCheckout.isDisplayed()) {
       	   js.executeScript("arguments[0].click();", paypalCheckout);                	
           Thread.sleep(1000);
        	if(paypalCheckout.isDisplayed()) {
        		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  paypalCheckout);
        		paypalCheckout.click();
            }
        }	                 
     }    
}

//SalesForce paypal payment page
	public static void salesforcePaypalCheckout() throws Exception {
	    WebElement parentDiv= driver.findElement(By.xpath("//div[contains(@class,'sfpp-payment-method-header-paypal')]"));
	    Thread.sleep(4000);
	    WebElement paypalCheckout=parentDiv.findElement(By.xpath("//div[contains(text(),'Pay with PayPal')]"));
	    
	    Actionsss.javascriptClick(paypalCheckout);
	   
	    Thread.sleep(3000);
	   // paypalCheckout.click();
	   // Thread.sleep(10000);
	    List<WebElement> salesforcePaypalCheckout=parentDiv.findElements(By.xpath("//div[contains(@class,'paypal-buttons-context-iframe paypal-buttons-label-paypal')]"));  
	    if(salesforcePaypalCheckout.size()>0) {
	        WebElement salesforcePaypalCheckout1=parentDiv.findElement(By.xpath("(//iframe[@title='PayPal'])[2]"));
	      if(salesforcePaypalCheckout1.isDisplayed()) {
	    	  	 Thread.sleep(3000);
	        	 Actionsss.click(salesforcePaypalCheckout1);
	        	 System.out.println("First click");
	      }if(salesforcePaypalCheckout1.isDisplayed()) {    
	    	  	Actionsss.javascriptClick(salesforcePaypalCheckout1);        
	      }        	
    }
  }
}
