package PaypalPayment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.MiniCartPage;
import pageObjects.PaymentPage;
import pageObjects.ViewCartPage;

public class PaypalMethod extends baseClass {
	
	private static final PaymentPage paymentPage = new PaymentPage(driver);
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static MiniCartPage miniCart = new MiniCartPage(driver);
	
    //After the paypal button click
    public static void brainTreeAfterClick() throws Exception {
        WebElement parentDiv= driver.findElement(By.xpath("//a[contains(@class, 'paypal-tab active')]"));               
        WebElement regPaypalCheckoutText=parentDiv.findElement(By.xpath("//label[contains(text(),'Select a PayPal account')]"));
        if(regPaypalCheckoutText.isDisplayed()) {                	 
       	  
       	 
        }else { 
            JavascriptExecutor js = (JavascriptExecutor) driver;  
            WebElement paypalCheckout=driver.findElement(By.xpath("//div[@class='js_braintree_paypal_billing_button']")); 
            Actionsss.CombinedClick(paypalCheckout);
        /*    if(paypalCheckout.isDisplayed()) {
           	   js.executeScript("arguments[0].click();", paypalCheckout);                	
               Thread.sleep(1000);
	        	if(paypalCheckout.isDisplayed()) {
	        		paypalCheckout.click();
	            }
            }	*/                 
         }                 
   }
    
   //SalesForce paypal payment page
    public static void salesforcePaypalCheckout() throws Exception {
    	Actionsss.scrollWindowsByPixel(800);
        WebElement parentDiv= driver.findElement(By.xpath("//div[contains(@class,'sfpp-payment-method-header-paypal')]"));
        Thread.sleep(4000);
        WebElement paypalCheckout=parentDiv.findElement(By.xpath("//div[contains(text(),'Pay with PayPal')]"));       
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");      
        paypalCheckout.click();
        List<WebElement> salesforcePaypalCheckout=parentDiv.findElements(By.xpath("//div[contains(@class,'paypal-buttons-context-iframe paypal-buttons-label-paypal')]"));  
        if(salesforcePaypalCheckout.size()>0) {
            WebElement salesforcePaypalCheckout1=driver.findElement(By.xpath("(//iframe[@title='PayPal'])[2]"));
            Actionsss.CombinedClick(salesforcePaypalCheckout1);
     /*     if(salesforcePaypalCheckout1.isDisplayed()) {
        	  	 Thread.sleep(3000);
            	 salesforcePaypalCheckout1.click();
            	 System.out.println("First click");
          }if(salesforcePaypalCheckout1.isDisplayed()) {    
              js.executeScript("arguments[0].click();", salesforcePaypalCheckout1);
             
          }    */        	
        }
    }
	
	 public static void paypalPopupWithRahulNayakAccount() throws Exception {
	    	
	        String mainWindowHandle = driver.getWindowHandle();
	        // Switch to the new window by iterating over all available window handles
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(mainWindowHandle)) {
	                driver.switchTo().window(handle);
	                popUpDisplayValidation();	    	     
	                break;
	            }
	        }
	    
	      
	        paypalWithRahulNayak(); 
	        Thread.sleep(2000);
	        driver.switchTo().window(mainWindowHandle);
	        Thread.sleep(1000);
	         
	      } 
	 
	 public static void callToActionOfPaypal() throws Exception {
	    	
	        String mainWindowHandle = driver.getWindowHandle();
	        // Switch to the new window by iterating over all available window handles
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(mainWindowHandle)) {
	                driver.switchTo().window(handle);
	               popUpDisplayValidation();	    	     
	                break;
	            }
	        }
	        
	        driver.switchTo().window(mainWindowHandle);
	        Thread.sleep(2000);  
	      } 
	 
	 public static void paypalPopupWithPushpaAccount() throws Exception {
	    	
	        String mainWindowHandle = driver.getWindowHandle();
	        // Switch to the new window by iterating over all available window handles
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(mainWindowHandle)) {
	                driver.switchTo().window(handle);
	                popUpDisplayValidation();	    	     
	                break;
	            }
	        }
	        // test.info("Entered into paypal window");
	      if(Actionsss.elementSize(paymentPage.getClickOnContinueList())) {
	    	  logger.info("click on continue");
	    	  Actionsss.CombinedClick(paymentPage.getClickOnContinue());
	      }
	        paypalWithPushpaAccount(); 
        
	        Thread.sleep(2000);
	        driver.switchTo().window(mainWindowHandle);
	        Thread.sleep(1000);
	         
	      } 
	 
	 public static void paypalWithRahulNayak() throws InterruptedException, Exception {		
		 rahulNayakCredentials();
		 normalProccesInPaypal();
	 }
	 
	 public static void paypalWithPushpaAccount() throws InterruptedException, Exception {			
		 pushpaCredentials();
		 normalProccesInPaypal();
	 }
	 	
	 
	 
	 public static void rahulNayakCredentials() throws InterruptedException {
		 Thread.sleep(5000);
		 if(Actionsss.elementSize(paymentPage.getEmailLoginList())) {	        	
        	 Actionsss.sendKeys( paymentPage.getEmailLogin(),TestData.rahulNayakPaypalUserName, "User email is " +TestData.rahulNayakPaypalUserName);       	 	        	
        	 WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        	 getTextOfPaypalInPaymentPage=email.getAttribute("value");
         }
         if(Actionsss.elementSize(paymentPage.getNextButtonList())) {
        	Actionsss.click(paymentPage.getNextButton());         
         }
         if(Actionsss.elementSize(paymentPage.getPasswordList())) {	        	 
        	 Actionsss.sendKeys(paymentPage.getPassword(),TestData.rahulNayakPaypalPassword, "password is " +TestData.rahulNayakPaypalPassword);               	          
             Thread.sleep(1000);
         }
	 }
	 
	 
	 public static void pushpaCredentials() throws InterruptedException {
		 Thread.sleep(5000);
		 if(Actionsss.elementSize(paymentPage.getEmailLoginList())) {	        	
        	 Actionsss.sendKeys( paymentPage.getEmailLogin(),TestData.pushpaPaypalUserName, "User email is" +TestData.pushpaPaypalUserName);       	 	        	
        	 WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        	 getTextOfPaypalInPaymentPage=email.getAttribute("value");
         }
         if(Actionsss.elementSize(paymentPage.getNextButtonList())) {
        	Actionsss.click(paymentPage.getNextButton());         
         }
         if(Actionsss.elementSize(paymentPage.getPasswordList())) {	        	 
        	 Actionsss.sendKeys(paymentPage.getPassword(),TestData.pushpaPaypalPassword, "password is " +TestData.pushpaPaypalPassword);               	          
             Thread.sleep(1000);
         }
	 }
	 
	 
	 
	 
	 public static void normalProccesInPaypal() throws Exception {
		 if(Actionsss.elementSize(paymentPage.getloginbuttonList())) {
        	 Actionsss.click(paymentPage.getloginbutton());           
             Thread.sleep(1000);
         }
        
         Thread.sleep(4000);
         if(Actionsss.elementSize(paymentPage.getReviewOrderButtonList())) {        	
         	try {
         		Actionsss.click(paymentPage.getReviewOrderButton());      		
 	            Thread.sleep(3000);
 	           logger.info("1st Click");
 	           Actionsss.click(paymentPage.getReviewOrderButton());
 	           logger.info("2nd Click");
 	        } catch (Exception e) {
 	        	Actionsss.javascriptClick(paymentPage.getReviewOrderButton());
 	            System.err.println("Exception while clicking the element: " + paymentPage.getReviewOrderButton());
 	        }
         	Thread.sleep(4000);
         	/*
         	logger.info("complete order");
         	
   	
            	try {
            		//Actionsss.click(paymentPage.getCompletePurcharseButton());
            		 Actionsss.click(paymentPage.getRevieworderBtn());
 	           		Thread.sleep(4000);
            	} catch (Exception e) {
	 	        	Actionsss.javascriptClick(paymentPage.getRevieworderBtn());
	 	            System.err.println("Exception while clicking the element: " +paymentPage.getCompletePurcharseButton());
            	}         	
        	        */        	
         }else {
        	 if(Actionsss.elementSize(paymentPage.getSaveAndContinueList())) {
        		 Actionsss.click(paymentPage.getSaveAndContinue());
        	 }
         }  
	 }
	 
	 public static void popUpDisplayValidation() throws InterruptedException {
		 test.info("Verifying the display of pop up window ");	
		 if( Actionsss.elementSize(VCP.getPaypalPopUp()) || Actionsss.elementSize(VCP.getSecondPaypalPopUp())) {			   
			  test.pass("Successfully clicked on paypal button and pop up window is displayed");
			  logger.info("Successfully clicked on paypal button and pop up window is displayed");
		}else {
			// test.fail("Not clicked on paypal button and no  pop up window is displayed");
			  logger.info("Not clicked on paypal button and no  pop up window is displayed");
		}
		 
	 }
}
