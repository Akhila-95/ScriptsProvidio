package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import baseClass.baseClass;
import functionality.Actionsss;
import functionality.Waits;
import pageObjects.GiftCertificatePage;

public class GiftCertificateValidation extends baseClass{

private static final GiftCertificatePage giftCertificate=new GiftCertificatePage(driver);

	public static void errorsFromName_Recipients_confirmRecipientEMail() throws Exception {
		test.info("Verify the error for Errors FromName ,Recipients mail, confirm Recipient EMail in gift card");
		Thread.sleep(2000);
		logger.info(Actionsss.getTextOfElement(giftCertificate.getRecipientConfirmEmailError()));
        if(Actionsss.displayElement(giftCertificate.getFromNameError()) || Actionsss.displayElement(giftCertificate.getRecipientEmailError()) || Actionsss.displayElement(giftCertificate.getRecipientConfirmEmailError())) {
        	test.pass("Error message is displayed as " +Actionsss.getTextOfElement(giftCertificate.getFromNameError()) + "and" +Actionsss.getTextOfElement(giftCertificate.getRecipientEmailError()) + "and " +Actionsss.getTextOfElement(giftCertificate.getRecipientConfirmEmailError()));       	
        	logger.info("Error message is displayed as " +Actionsss.getTextOfElement(giftCertificate.getFromNameError()) + "and" +Actionsss.getTextOfElement(giftCertificate.getRecipientEmailError()) + "and " +Actionsss.getTextOfElement(giftCertificate.getRecipientConfirmEmailError()));       	
        }else {
        	test.fail("Error message are not  displayed ");
        	logger.info("Error message are not  displayed  ");
        }
	}
	
	public static void errorsRecipientEmailAndConfirmEmail() {
		test.info("Verify the error for Recipients mail, confirm Recipient EMail in gift card"); 
		if(Actionsss.displayElement(giftCertificate.getRecipientEmailError()) &&Actionsss.displayElement(giftCertificate.getRecipientConfirmEmailError())) {
			test.pass("Error message is displayed as " +Actionsss.getTextOfElement(giftCertificate.getRecipientEmailError() )+ " and" +Actionsss.getTextOfElement(giftCertificate.getRecipientConfirmEmailError()));       	
        	logger.info("Error message is displayed as " +Actionsss.getTextOfElement(giftCertificate.getRecipientEmailError() )+ " and" +Actionsss.getTextOfElement(giftCertificate.getRecipientConfirmEmailError()));
        }else {
        	test.fail("Error message are not  displayed  ");
        	logger.info("Error message are not  displayed  " );
        }
	}
	
	public static void errorsForConfirmMail() throws InterruptedException {
		test.info("Verify the error for confirm Recipient EMail in gift card"); 
		Thread.sleep(1000);
		if(Actionsss.displayElement(giftCertificate.getRecipientConfirmEmailError())) {
			test.pass("Error message is displayed as " +Actionsss.getTextOfElement(giftCertificate.getRecipientConfirmEmailError()));  
			logger.info("Error message is displayed as " +Actionsss.getTextOfElement(giftCertificate.getRecipientConfirmEmailError()));  
		}else {
			test.fail("Error message is not  displayed  ");
        	logger.info("Error message is not  displayed  " );
		}
	}
	
	   public static void validatingGiftCardAddtoCart() {
		   
		   test.info("Verify that user is able to add the gift cerificate to the cart");
		   
		    Wait<WebDriver> wait = Waits.createFluentWait(driver);
	       // Wait for the success alert to be visible
	       WebElement gifcartAddtoCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
	       // Get the text of the alert
	       String actualAddToCart = gifcartAddtoCart.getText();
	       // Expected alert text
	       String expectedAddToCart = "Gift Certificate added to cart";
	       if (actualAddToCart.equals(expectedAddToCart)) {
	           // Success message is displayed
	       	   test.pass("Successfully Gift Certificate is added to cart");
	           logger.info("Gift Certificate added to cart");
	           // Perform actions or assertions here for the success case
	       }else {
	           // Success message is not as expected
	       	   test.fail("Gift Certificate not added to cart");
	           logger.info("Gift Certificate not added to cart");
	           //System.out.println("The product is not added to cart because it should show: " + expectedAddToCart + " but found: " + actualAddToCart);
	           // Perform actions or assertions here for the failure case
	        
	         }
	   }
}
