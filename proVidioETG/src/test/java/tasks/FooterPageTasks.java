package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.FooterPage;
import validations.FooterValidation;

public class FooterPageTasks extends baseClass {

	private static final FooterPage fp = new FooterPage(driver);
	
	public static void resourceFooterLinks() throws Exception {

		Actionsss.scrollIntoViewCenter(fp.getResourceFooter() );
		
		Thread.sleep(1000);
		
		Actionsss.scrollWindowsByPixel(1000);
			
		getResourcesLinksFromFooter();
	}
	
	public static void displayOfComponentsInFooter() throws Exception {
		
		validEmailInSignUpBoxInFooter();
		primaryCategory();
		displayOfSecondaryCategories();
		contactUsAndBackToTop();
		socialMediaIcons();
	}
	
	public static void displayOfSecondaryCategories() {
		test.info("Verifying the display of secondary categories");
		int shopCategoryCount= 7;
		int rescourcesCount =5;
		int getCustomerServiceList=4;
		int aboutCount=4;
		if(Actionsss.getSizeOfList(fp.getShopCategoryList())==shopCategoryCount  && Actionsss.getSizeOfList(fp.getresourcesList())== rescourcesCount
				&& Actionsss.getSizeOfList(fp.getCustomerServiceList()) ==getCustomerServiceList  && Actionsss.getSizeOfList(fp.getAboutList()) ==aboutCount){
			test.pass("All primary categories are displayed in footer section");
			logger.info("All primary categories are displayed in footer section");
		}else {
			test.pass("All primary categories are not displayed in footer section");
			logger.info("All primary categories are not  displayed in footer section");
		}
	}
	
	public static void primaryCategory() throws Exception {
		test.info("Verifying the display of primary categories in footer section");
		int primaryCategoriec= 4;
		if(Actionsss.getSizeOfList(fp.getPrimaryCategory())==primaryCategoriec) {
			test.pass("Successfully four primary categories are displayed in footer section");
			logger.info("Successfully four primary categories are displayed in footer section");
		}else {
			test.fail("Primary categories are not displayed in footer section");
			logger.info("Primary categories are not displayed in footer section");
		}
	}
	
	public static void contactUsAndBackToTop() {
		test.info("Verifying the display of contact us and back to top in footer section");
		if(Actionsss.displayElement(fp.getSelectcontactusLink()) && Actionsss.displayElement(fp.getBackToTop())) {
			test.pass("Successfully contact us and back to top buttons are displayed in footer section");
			logger.info("Successfully contact us and back to top buttons are displayed in footer section");
		}else {
			test.fail("Contact us and back to top buttons are not displayed in footer section");
			logger.info("Contact us and back to top buttons are not displayed in footer section");
		}
	}
	
	public static void socialMediaIcons() {
		test.info("Verifying the display of social media icons in footer section");
		if(Actionsss.displayElement(fp.getfacebookLink()) && Actionsss.displayElement(fp.gettwitterLink()) && Actionsss.displayElement(fp.getInstagramLink())
				&& Actionsss.displayElement(fp.getpinterestLink())) {
			test.pass("Successfully  facebook, twitter, pinterest and instagram displayed in footer section");
			logger.info("Successfully  facebook, twitter, pinterest and instagram displayed in footer section");
		}else {
			test.fail(" Facebook, twitter, pinterest and instagram are not displayed in footer section");
			logger.info(" Facebook, twitter, pinterest and instagram are not sdisplayed in footer section");
		}
	}
	
	
	public static void validEmailInSignUpBoxInFooter() throws Exception {
		Actionsss.scrollIntoViewCenter(fp.getResourceFooter() );
		if(Actionsss.displayElement(fp.getSubscribeSignUp())) {
			test.info("Verifying the display of email sign up in footer");
			
			Actionsss.sendKeys(fp.getSubscribeSignUpInput(), fakeEmail, "friend email ");		
			Actionsss.javascriptClick(fp.getSubscribeButton());
			
			//Thread.sleep(3000);
			FooterValidation.validatingSubscriptionSuccessPoPuP();
		}else{
			test.fail("Email sign up is not dispalyed in footer");
		}
	}
	
	public static void withoutEnteringEmailInSignupBoxInFooter() throws Exception {
		
		test.info("Verifying the error message Without entering the email in email sign up in footer");
		
		Actionsss.javascriptClick(fp.getSubscribeButton());
		
		FooterValidation.validatingSubscriptionSignUpError();
	}
	
	public static void invalidEmailInEmailSignUpBox() throws Exception {
		
		test.info("Enter invalid email in sign up box in footer");
		
		Actionsss.sendKeys(fp.getSubscribeSignUpInput(), "akhilagmail", "invalid email ");		
		Actionsss.javascriptClick(fp.getSubscribeButton());
		
		FooterValidation.validatingSubscriptionSignUpError();
	}
	
	
	
	public static void getResourcesLinksFromFooter() throws Exception {
		
		Actionsss.selectByOptions(fp.getResourceFooterList());
		
		if(selectedLinkText.equals("Check Order")) {
			
			test.info("Verify the Navigation to check Order page from footer link");
			
			if(Actionsss.displayElement(fp.getCheckOrder())) {
				
				test.pass("Navigated to check Order page ");
			}

			
		}else if (selectedLinkText.equals("Account")) {
			
			test.info("Verify the navigation of login page from footer link");
			
			 LoginPageTasks.verifyThatuserLogin();
			 
		}else if(selectedLinkText.equals("Wishlist")) {
			
			test.info("Verify the navigation of wishlist from footer links ");
			
			Actionsss.displayElement(fp.getWishListPage());
						
			Thread.sleep(1000);
			
			if(Actionsss.elementSize(fp.getWishListPageEmptyList())) {				
				test.info("No products in wishlist");				
			}else {				
				test.info("Have Products in wishlist");			
			}
			
		}else if(selectedLinkText.equals("Gift Registry")) {			
			test.info("Verify the navigation of gift certificate page ");	  
			GiftCertificatePageTasks.giftCertificateForm();			
		}else if(selectedLinkText.equals("Brands Test")) {			
			test.info("Verify the Navigation to A-Z brand page from footer link");			
			Thread.sleep(1000);			
			if(Actionsss.displayElement(fp.getAzBrands())) {
			
				test.info(" Navigated to A-Z brand page from footer link");
			}			
		}
	}
}
