package tasks;

import CreditCardPyament.BrainTreePayment;
import CreditCardPyament.CyberSourcePayment;
import CreditCardPyament.StripePayment;
import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.MyAccountPage;
import validations.MyAccountValidations;

public class MyAccountPageCreditCardTasks extends baseClass{
	
	private static MyAccountPage MAC= new MyAccountPage(driver);

    //--------------------------------BrainTree-----------------------------------------------------
	public static void creditCardBrainTreeFormView() throws Exception {
		if(Actionsss.countofElements(MAC.getBrainTree())) {
			logger.info("Credit card form is loaded");
		}else {
			MyAccountPageTasks.myAccoutView();
		}
	}
	
	public static void addNewBrainTree() throws Exception {
		creditCardBrainTreeFormView();
		if(Actionsss.countofElements(MAC.getBrainTree())) {
			Actionsss.CombinedClick(MAC.getaddNewCard());
			MyAccountValidations.verifyaddNewlinkClick();
		}else {
			logger.info("This is not a braintree");
			test.pass("BrainTree payment Method is currently Not in Activate Mode");
		}
	}
	
	public static void cancelButton() throws Exception {
		addNewBrainTree();
		if(Actionsss.countofElements(MAC.getBrainTree())) {
			Actionsss.CombinedClick(MAC.getclosebutton());
			MyAccountValidations.verifyuserClickedonMyAccount();
		}else {
			logger.info("This is not a braintree");
			
		}
	}
	
	public static void emptyForm() throws Exception {
		addNewBrainTree();
		if(Actionsss.countofElements(MAC.getBrainTree())) {
			Actionsss.CombinedClick(MAC.geteditsavebutton());
			Thread.sleep(2000);
			MyAccountValidations.verifyerrormessage();
		}else {
			logger.info("This is not a braintree");
			
		}
	}
	
	public static void cardNameEnter() throws Exception {
		addNewBrainTree();
		if(Actionsss.countofElements(MAC.getBrainTree())) {
			test.info("Entering card name for brain tree payment");
			BrainTreePayment.brainTreeCardHolderName();
			logger.info("Entered card name for brain tree payment");
			Actionsss.CombinedClick(MAC.geteditsavebutton());
			Thread.sleep(2000);
			MyAccountValidations.verifyerrormessage();
		}else {
			logger.info("This is not a braintree");
			
		}
	}
	
	
	public static void nameCardNumberEnter() throws Exception {
		
		addNewBrainTree();
		if(Actionsss.countofElements(MAC.getBrainTree())) {
			test.info("Entering card name for brain tree payment");
			BrainTreePayment.brainTreeCardHolderName();
			logger.info("Entered card name for brain tree payment");
			 test.info("Entering card number for brain tree payment ");
			 BrainTreePayment.brainTreeCardNumber();
			Actionsss.CombinedClick(MAC.geteditsavebutton());
			Thread.sleep(2000);
			MyAccountValidations.verifyerrormessage();
		}else {
			logger.info("This is not a braintree");
			
		}
		

	}
	
	public static void nameCardNumberaddCvvEnter() throws Exception {
		addNewBrainTree();
		if(Actionsss.countofElements(MAC.getBrainTree())) {
			test.info("Entering card name for brain tree payment");
			BrainTreePayment.brainTreeCardHolderName();
			logger.info("Entered card name for brain tree payment");
			 test.info("Entering card number for brain tree payment ");
			 BrainTreePayment.brainTreeCardNumber();
			logger.info("Entered card number for brain tree payment ");
			 test.info("Entering cvv for brain tree payment");
			 BrainTreePayment.brainTreeCvv();;
			Actionsss.CombinedClick(MAC.geteditsavebutton());
			Thread.sleep(2000);
			MyAccountValidations.verifyerrormessage();
		}else {
			logger.info("This is not a braintree");
			
		}
	}
		
		public static void validCreditCardDetails() throws Exception {
			addNewBrainTree();
			if(Actionsss.countofElements(MAC.getBrainTree())) {
				test.info("Entering card name for brain tree payment");
				BrainTreePayment.brainTreeCardHolderName();
				logger.info("Entered card name for brain tree payment");
				 test.info("Entering card number for brain tree payment ");
				 BrainTreePayment.brainTreeCardNumber();
				logger.info("Entered card number for brain tree payment ");
				 test.info("Entering cvv for brain tree payment");
				 BrainTreePayment.brainTreeCvv();;
				 BrainTreePayment.brainTreeExpDate();
				logger.info("Entered exp for brain tree payment");
				Actionsss.CombinedClick(MAC.geteditsavebutton());
				Thread.sleep(2000);
				MyAccountValidations.verifyuserClickedonMyAccount(); 
			}else {
				logger.info("This is not a braintree");
				
			}
		}
		
		public static void cardAlreadyExists() throws Exception {
			addNewBrainTree();
			if(Actionsss.countofElements(MAC.getBrainTree())) {
				test.info("Entering card name for brain tree payment");
				BrainTreePayment.brainTreeCardHolderName();
				logger.info("Entered card name for brain tree payment");
				 test.info("Entering card number for brain tree payment ");
				 BrainTreePayment.brainTreeCardNumber();
				logger.info("Entered card number for brain tree payment ");
				 test.info("Entering cvv for brain tree payment");
				 BrainTreePayment.brainTreeCvv();;
				 BrainTreePayment.brainTreeExpDate();
				logger.info("Entered exp for brain tree payment");
				Actionsss.CombinedClick(MAC.geteditsavebutton());
				Thread.sleep(4000);
				if(Actionsss.countofElements(MAC.getalreadyExistsError())) {
					MyAccountValidations.verifyalreadyerrormessage(); 
				}else {
					cardAlreadyExists();
				}
				
			}else {
				logger.info("This is not a braintree");
				
			}
		}
		
		
		public static void removeCard() throws Exception {
			if(Actionsss.countofElements(MAC.getBrainTree())) {
				Actionsss.randomElementFromListScrollIntoView(MAC.getremove());
				MyAccountValidations.remove();
			}else {
				logger.info("This is not a braintree");
				test.pass("BrainTree payment Method is currently Not in Activate Mode");
			}
		}
		public static void randomselectionofmakeAsadefault() throws Exception {
			if(Actionsss.countofElements(MAC.getBrainTree())) {
				Actionsss.randomselectionofmakeAsadefault(MAC.getmakeAsaDefault());
				MyAccountValidations.makeasaDefult();
			}else {
				logger.info("This is not a braintree");
				test.pass("BrainTree payment Method is currently Not in Activate Mode");
			}
		}

	
    //---------------------------------stripe---------------------------------------------
	public static void creditCardStripeFormView() throws Exception {
		if(Actionsss.countofElements(MAC.getstripeformlist())) {
			logger.info("stripe Credit card form is loaded");
		}else {
			MyAccountPageTasks.myAccoutView();
			if(Actionsss.countofElements(MAC.getstripelist()) && Actionsss.countofElements(MAC.getstripeformlist())) {
				Actionsss.CombinedClick(MAC.getstripe());
				MyAccountValidations.stripePage();
			}else {
				logger.info("This is not a stripe payment");
				test.pass("Stripe payment Method is currently Not in Activate Mode");
			}
		}
	}
	
	public static void stripeHomelink() throws Exception{
		creditCardStripeFormView();
		if(Actionsss.countofElements(MAC.getstripeformlist())){
			Actionsss.CombinedClick(MAC.gethomeLink());
			Thread.sleep(2000);
			MyAccountValidations.verifyClickOnLogo();		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void stripeMyAccountlink() throws Exception{
		creditCardStripeFormView();
		if(Actionsss.countofElements(MAC.getstripeformlist())){
			Actionsss.CombinedClick(MAC.getmyaccountlink());
			MyAccountValidations.verifyuserClickedonMyAccount();
		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void stripePaymentlink() throws Exception{
			if(Actionsss.countofElements(MAC.getpaymentsPage())) {
				logger.info("payments page is loaded");
			}else {
				creditCardStripeFormView();
				if(Actionsss.countofElements(MAC.getstripeformlist())) {
					Actionsss.CombinedClick(MAC.getpaymentlink());
					Thread.sleep(2000);
					MyAccountValidations.verifyvalidsubmit();
				}else {
					logger.info("This is not stripe payment");
				}
			}
	}
	
	public static void stripepaymentsHomelink() throws Exception{
		stripePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.CombinedClick(MAC.gethomeLink());
			Thread.sleep(2000);
			MyAccountValidations.verifyClickOnLogo();		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void stripepaymentMyAccountlink() throws Exception{
		stripePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.CombinedClick(MAC.getmyaccountlink());
			MyAccountValidations.verifyuserClickedonMyAccount();
		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void stripepaymentBacktomyaccountlink() throws Exception {
		stripePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.CombinedClick(MAC.geteditbacktomyaccount());
			Thread.sleep(2000);
			MyAccountValidations.verifyuserClickedonMyAccount();		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void removebutton() throws Exception {
		stripePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.randomElementFromListScrollIntoView(MAC.getremovebutton());
			Thread.sleep(2000);
			Actionsss.CombinedClick(MAC.getokbuttoncancelButton());
			MyAccountValidations.removeok();		
		}else{
			logger.info("This is not stripe payment");
		}

	}
	
	public static void removeandCaceldeletebutton() throws Exception {
		stripePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.randomElementFromListScrollIntoView(MAC.getremovebutton());
			Thread.sleep(2000);
			Actionsss.CombinedClick(MAC.getremovebuttoncancelButton());
			MyAccountValidations.removecancel();		
		}else{
			logger.info("This is not stripe payment");
		}

	}
	
	public static void cancelbtn() throws Exception {
		creditCardStripeFormView();
		if(Actionsss.countofElements(MAC.getpaymentPageHeader())){
		Actionsss.CombinedClick(MAC.geteditcancelbutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyvalidsubmit();		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	
	public static void stripeEmptyForm() throws Exception {
		creditCardStripeFormView();
		if(Actionsss.countofElements(MAC.getpaymentPageHeader())){
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.stripeEmptyForm();		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	
	public static void invalidCard() throws Exception {
		creditCardStripeFormView();
		if(Actionsss.countofElements(MAC.getstripeformlist())){
		//Actionsss.sendKeys(MAC.getstripeName(), TD.InputFieldData, TD.InputFieldName);
			StripePayment.stripeCardInvalidNumber();
		Thread.sleep(1000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.invalidCardForm();	
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void expdate()throws Exception  {
		creditCardStripeFormView();
		if(Actionsss.countofElements(MAC.getstripeformlist())){
		//Actionsss.sendKeys(MAC.getstripeName(), TD.InputFieldData, TD.InputFieldName);
			test.info("Entering card number for stripe payment");
			StripePayment.stripeCardNumber();
	 		Thread.sleep(1000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.emptyexpDate();	
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void cvv() throws Exception {
		creditCardStripeFormView();
		if(Actionsss.countofElements(MAC.getstripeformlist())){
		//Actionsss.sendKeys(MAC.getstripeName(), TD.InputFieldData, TD.InputFieldName);
			test.info("Entering card number for stripe payment");
			StripePayment.stripeCardNumber();
			test.info("Entering exp date for stripe payment");	
			StripePayment.stripeExpDate();
		
	 		Thread.sleep(1000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.EemptyCVV();	
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void zip()throws Exception  {
		creditCardStripeFormView();
		if(Actionsss.countofElements(MAC.getstripeformlist())){
		//Actionsss.sendKeys(MAC.getstripeName(), TD.InputFieldData, TD.InputFieldName);
			test.info("Entering card number for stripe payment");
			StripePayment.stripeCardNumber();
			test.info("Entering exp date for stripe payment");	
			StripePayment.stripeExpDate();
			test.info("Entering cvv for stripe payment");	
			StripePayment.stripeCvv();
	 		Thread.sleep(1000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.EmptyZip();	
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void validDetails() throws Exception {
		creditCardStripeFormView();

		if(Actionsss.countofElements(MAC.getstripeformlist())){
		//Actionsss.sendKeys(MAC.getstripeName(), TD.InputFieldData, TD.InputFieldName);
			test.info("Entering card number for stripe payment");
			StripePayment.stripeCardNumber();
			test.info("Entering exp date for stripe payment");	
			StripePayment.stripeExpDate();
			test.info("Entering cvv for stripe payment");	
			StripePayment.stripeCvv();
			test.info("Entering postal code for stripe payment");	
			StripePayment.stripePostalCode();		
	 		Thread.sleep(1000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyvalidsubmit();	
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void viewlink() throws Exception {
		MyAccountPageTasks.myAccoutView();
		if(Actionsss.countofElements(MAC.getviewlinklist())) {
			Actionsss.CombinedClick(MAC.getviewlink());
			MyAccountValidations.verifyvalidsubmit();	
		}else {
			logger.info("This is not a stripe payment");
			test.pass("View cards link is not visible because no cards avaliable");
		}
	}

	
	//---------------------------------cybersouce------------------------------------------------
	public static void creditCardCyberSourceFormView() throws Exception {
		if(Actionsss.countofElements(MAC.getCybersource())) {
			logger.info("Credit card form is loaded");
		}else {
			MyAccountPageTasks.myAccoutView();
			if(Actionsss.countofElements(MAC.getstripelist())) {	
			Actionsss.CombinedClick(MAC.getstripe());
			MyAccountValidations.cybersourcePage();
			}else {
				logger.info("This is not a stripe Cyber Source");
				test.pass("Cyber Source payment Method is currently Not in Activate Mode");
			}
		}
	}
	
	public static void cancelbtncybersource() throws Exception {
		creditCardCyberSourceFormView();
		if(Actionsss.countofElements(MAC.getCybersource())){
		Actionsss.CombinedClick(MAC.geteditcancelbutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyvalidsubmit();		
		}else{
			logger.info("This is not cybersource payment");
		}
	}
	
	public static void cyberSourceHomelink() throws Exception{
		creditCardCyberSourceFormView();
		if(Actionsss.countofElements(MAC.getCybersource())){
			Actionsss.CombinedClick(MAC.gethomeLink());
			Thread.sleep(2000);
			MyAccountValidations.verifyClickOnLogo();		
		}else{
			logger.info("This is not cybersource payment");
		}
	}
	
	public static void cyberSourceMyAccountlink() throws Exception{
		creditCardCyberSourceFormView();
		if(Actionsss.countofElements(MAC.getCybersource())){
			Actionsss.CombinedClick(MAC.getmyaccountlink());
			MyAccountValidations.verifyuserClickedonMyAccount();
		
		}else{
			logger.info("This is not cybersource payment");
		}
	}
	
	public static void cyberSourcePaymentlink() throws Exception{
			if(Actionsss.countofElements(MAC.getpaymentsPage())) {
				logger.info("payments page is loaded");
			}else {
				creditCardCyberSourceFormView();
				if(Actionsss.countofElements(MAC.getCybersource())) {
					Actionsss.CombinedClick(MAC.getpaymentlink());
					Thread.sleep(2000);
					MyAccountValidations.verifyvalidsubmit();
				}else {
					logger.info("This is not cybersource payment");
				}
			}
	}
	
	public static void cyberSourceEmptyForm() throws Exception {
		creditCardCyberSourceFormView();
		if(Actionsss.countofElements(MAC.getCybersource())){
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyemptyCybersourceform();		
		}else{
			logger.info("This is not cybersource payment");
		}
	}
	
	public static void cyberSourceNameForm() throws Exception {
		creditCardCyberSourceFormView();
		if(Actionsss.countofElements(MAC.getCybersource())){
		 test.info("Entering card name for cybersource payment");
		 CyberSourcePayment.cardName();
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(4000);
		MyAccountValidations.verifynameCybersourceform();		
		}else{
			logger.info("This is not cybersource payment");
		}
	}
	
	public static void cyberSourceNumberForm() throws Exception {
		creditCardCyberSourceFormView();
		if(Actionsss.countofElements(MAC.getCybersource())){
		 test.info("Entering card name for cybersource payment");
		 CyberSourcePayment.cardName();
		 test.info("Entering card number for cybersource payment");
		 CyberSourcePayment.cyberSourceCardNumber();
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.verifynumberCybersourceform();		
		}else{
			logger.info("This is not cybersource payment");
		}
	}
	
	public static void expdatecyberSource()throws Exception  {
		creditCardCyberSourceFormView();
		if(Actionsss.countofElements(MAC.getCybersource())){
		//Actionsss.sendKeys(MAC.getstripeName(), TD.InputFieldData, TD.InputFieldName);
			test.info("Entering card name for cybersource payment");
			 CyberSourcePayment.cardName();
			 test.info("Entering card number for cybersource payment");
			 CyberSourcePayment.cyberSourceCardNumber();
			 test.info("Entering exp month for cybersource payment");
			 CyberSourcePayment.cyberSourceExpMonthinMAC();
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(4000);
		MyAccountValidations.verifyExpCybersourceform();	
		}else{
			logger.info("This is not cybersource payment");
		}
	}
	
	
	public static void validDetailscyberSource() throws Exception {
		creditCardCyberSourceFormView();
		if(Actionsss.countofElements(MAC.getCybersource())){
		//Actionsss.sendKeys(MAC.getstripeName(), TD.InputFieldData, TD.InputFieldName);
			test.info("Entering card name for cybersource payment");
			 CyberSourcePayment.cardName();
			 test.info("Entering card number for cybersource payment");
			 CyberSourcePayment.cyberSourceCardNumber();
			 test.info("Entering exp month for cybersource payment");
			 CyberSourcePayment.cyberSourceExpMonthinMAC();
	         test.info("Entering exp year for cybersource payment");
	         CyberSourcePayment.cyberSourceExpYearinMAC();
  	
	 		Thread.sleep(1000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyvalidsubmit();	
		}else{
			logger.info("This is not cybersource payment");
		}
	}
	
	
	public static void invalidcyberSourceCard() throws Exception {
		creditCardStripeFormView();
		if(Actionsss.countofElements(MAC.getCybersource())){
		//Actionsss.sendKeys(MAC.getstripeName(), TD.InputFieldData, TD.InputFieldName);
			 test.info("Entering card name for cybersource payment");
			 CyberSourcePayment.cardName();
			test.info("Entering card number for cybersource payment");
			 CyberSourcePayment.invalidCard();
			 test.info("Entering exp month for cybersource payment");
			 CyberSourcePayment.cyberSourceExpMonthinMAC();
	         test.info("Entering exp year for cybersource payment");
	         CyberSourcePayment.cyberSourceExpYearinMAC(); 
		Thread.sleep(1000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyinvalidnumnerInput();	
		}else{
			logger.info("This is not cybersource payment");
		}
	}
	
	
	public static void CyberSourcepaymentsHomelink() throws Exception{
		cyberSourcePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.CombinedClick(MAC.gethomeLink());
			Thread.sleep(2000);
			MyAccountValidations.verifyClickOnLogo();		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void CyberSourcepaymentMyAccountlink() throws Exception{
		cyberSourcePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.CombinedClick(MAC.getmyaccountlink());
			MyAccountValidations.verifyuserClickedonMyAccount();
		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void CyberSourcepaymentBacktomyaccountlink() throws Exception {
		cyberSourcePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.CombinedClick(MAC.geteditbacktomyaccount());
			Thread.sleep(2000);
			MyAccountValidations.verifyuserClickedonMyAccount();		
		}else{
			logger.info("This is not stripe payment");
		}
	}
	
	public static void CyberSourceremovebutton() throws Exception {
		cyberSourcePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.randomElementFromListScrollIntoView(MAC.getremovebutton());
			Thread.sleep(2000);
			Actionsss.CombinedClick(MAC.getokbuttoncancelButton());
			MyAccountValidations.removeok();		
		}else{
			logger.info("This is not stripe payment");
		}

	}
	
	public static void CyberSourceremoveandCaceldeletebutton() throws Exception {
		cyberSourcePaymentlink();
		if(Actionsss.countofElements(MAC.getpaymentsPage())){
			Actionsss.randomElementFromListScrollIntoView(MAC.getremovebutton());
			Thread.sleep(2000);
			Actionsss.CombinedClick(MAC.getremovebuttoncancelButton());
			MyAccountValidations.removecancel();		
		}else{
			logger.info("This is not stripe payment");
		}

	}

	public static void viewCyberSourcelink() throws Exception {
		MyAccountPageTasks.myAccoutView();
		if(Actionsss.countofElements(MAC.getviewlinklist())) {
			Actionsss.CombinedClick(MAC.getviewlink());
			MyAccountValidations.verifyvalidsubmit();	
		}else {
			logger.info("This is not a cybersource payment");
			test.pass("View cards link is not visible because no cards avaliable");
		}
	}
	
	//-------------buyNow---------------
	public static void buyNowPayments() throws Exception {
		if(Actionsss.countofElements(MAC.getBrainTree()) ) {
			MyAccountPageCreditCardTasks.validCreditCardDetails();
		}else if(Actionsss.countofElements(MAC.getstripeformlist())) {
			MyAccountPageCreditCardTasks.validDetails();
		}else {
			logger.info("Brain tree or stripe is not activated");
		}
	}
	
}
