package GiftCerificatePayment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.PaymentPage;
import tasks.PaymentPageTasks;

public class GiftCertificateInCombination extends baseClass{

	private static final PaymentPage paymentPage = new PaymentPage(driver);
	
	 public static void giftCodesForCombination() throws Exception{
		 
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
	        // Provided data
	        String[] data =TestData.GiftCerificateCodeCombination;

	      
	        for (String gcCodes :data) {        
		        Actionsss.scrollWindowsByPixel(500);
		        Actionsss.javascriptClick(paymentPage.getGiftcertificateInput());
		        // Iterate over the array and print each data
	        	logger.info(gcCodes);
	        	//Thread.sleep(2000);	        	
	        	Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),gcCodes, gcCodes+"gift code");				
	            Thread.sleep(1000);

               Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());
               logger.info("Apply button is selected");
               Thread.sleep(2000);
               	 int sizeOfGc = Actionsss.getSizeOfList(paymentPage.getsuccessGiftCodeRedemptionMsgList()); 
               	 logger.info(sizeOfGc);
               	    	
					if(Actionsss.elementSize(paymentPage.getInsufficientGiftCodeBalError())) {
						logger.info("Insufficent funds in this " +gcCodes + " gift card" );
						Actionsss.clearText(paymentPage.getGiftcertificateInput());
					}else if(Actionsss.elementSize(paymentPage.getGcBelongsToDifferentCustomerError())){
						logger.info("This " + gcCodes + "Gift Card belongs to different customer ");
						Actionsss.clearText(paymentPage.getGiftcertificateInput());
					}else if (Actionsss.elementSize(paymentPage.getInvalidGcError())){
						logger.info("This " + gcCodes + "is invalid gift code");
						Actionsss.clearText(paymentPage.getGiftcertificateInput());
					}else if(sizeOfGc==1) {
						 String gcRedeemedMsg= Actionsss.getTextOfElement(paymentPage.getsuccessGiftCodeRedemptionMsg());				
						// Define a regular expression pattern to match uppercase letters
					        Pattern pattern = Pattern.compile("[A-Z]+");
					        // Create a matcher with the input text
					        Matcher matcher = pattern.matcher(gcRedeemedMsg);
					        // Find the first match
					        if (matcher.find()) {
					            // Extract the matched uppercase letters
					            String uppercaseLetters = matcher.group();
					            // Print the result
					            System.out.println("Uppercase letters: " + uppercaseLetters);
					            gcCodeRedeemed=uppercaseLetters;
					        }
					        
	                    logger.info("Gift certificate codes are applied");
	                    test.info("Gift certificate codes are applied");	                    
	                    break;	
	                    
	              }if (gcCodes.equals(data[data.length - 1])) {
	                  logger.info("Last iteration completed");
	                  test.info("No balance in Gift certificates ");
	              }
				      
	        } 
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No element to redeem the Gift code");
	  }
	} 
}
