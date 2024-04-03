package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.GiftCertificatePage;
import validations.FooterValidation;
import validations.GiftCertificateValidation;

public class GiftCertificatePageTasks extends baseClass{
	
	private static final GiftCertificatePage giftCertificate=new GiftCertificatePage(driver);
	
	
	private static final String frndsName="friends name";
	private static final String fromName="Gift certificate from name";
	private static final String friendsMail="mail ";
	
	
	public static void giftCertificatePage() throws Exception {
		if(Actionsss.elementSize(giftCertificate.getGiftCertificatePageList())) {
			logger.info("Gift certificate page loaded");
		}else {
			Actionsss.CombinedClick(giftCertificate.getGiftRegistry());
		}
	}
	
	public static void getAllErrorMsgsInGiftCard() throws Exception {
		 giftCertificatePage();
		 Actionsss.CombinedClick(giftCertificate.getAddToCart());		 		 
		 FooterValidation.allErrorMsgsInGiftCard();
	}
	
	public static void gettheErrorsFromName_Recipients_confirmRecipientEMail() throws Exception {
		giftCertificatePage();
		Actionsss.sendKeys(giftCertificate.getGiftCardFriendsNameElement(),fakeFirstName,fname);
        Actionsss.CombinedClick(giftCertificate.getAddToCart());        
        GiftCertificateValidation.errorsFromName_Recipients_confirmRecipientEMail();
	}
	
	public static void getErrorsRecipientEmailAndConfirmEmail() throws Exception {
		giftCertificatePage();
		Actionsss.sendKeys(giftCertificate.getGiftCardFriendsNameElement(),fakeFirstName,fname);		
		Actionsss.sendKeys(giftCertificate.getGiftCardFromName(), fakelastName, fromName);
        Actionsss.javascriptClick(giftCertificate.getAddToCart());
        Thread.sleep(1000);
        GiftCertificateValidation.errorsRecipientEmailAndConfirmEmail();
	}
	
	public static void getErrorOfConfirmMail() throws Exception {
		giftCertificatePage();
		Actionsss.sendKeys(giftCertificate.getGiftCardFriendsNameElement(),fakeEmail,fname);		
		Actionsss.sendKeys(giftCertificate.getGiftCardFromName(), fakelastName, fromName);		
		Actionsss.sendKeys(giftCertificate.getGiftCardfriendsMail(), fakeEmail, friendsMail);
        Actionsss.CombinedClick(giftCertificate.getAddToCart());
        
        GiftCertificateValidation.errorsForConfirmMail();
	}
	

	public static void giftCertificateForm() throws Exception {
		giftCertificatePage();
		Actionsss.click(giftCertificate.getGiftCertificateAmount());
		
		Actionsss.selectByOptions(giftCertificate.getgiftCertificateAmountDropDown());		
		Actionsss.sendKeys(giftCertificate.getGiftCardFriendsNameElement(), fakeFirstName,frndsName);		
		Actionsss.sendKeys(giftCertificate.getGiftCardFromName(), fakelastName, fromName);		
		Actionsss.sendKeys(giftCertificate.getGiftCardfriendsMail(), fakeEmail, friendsMail);		
		Actionsss.sendKeys(giftCertificate.getgiftCardConfirmFriendsMail(), fakeEmail, friendsMail);
		
		Actionsss.CombinedClick(giftCertificate.getAddToCart());
			
		GiftCertificateValidation.validatingGiftCardAddtoCart();
		Thread.sleep(3000);
	}
}
