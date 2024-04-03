package tasks;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.CheckOutPageValidation;
import validations.CreateAccountValidation;

public class CheckOutPageTasks extends baseClass{
	private static final  TestData TD = new TestData();
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static homepage homePage = new homepage(driver);
	private static final loginPage lp = new loginPage(driver);
	
	public static void CheckOutPageLoaded() throws Exception {
     	List<WebElement> guestCheckout = driver.findElements(By.xpath("//div[@data-customer-type='guest']"));
     	List<WebElement> CheckoutPage = driver.findElements(By.xpath("//div[@class='col-sm-7']"));
     	if (guestCheckout.size()>0 &&CheckoutPage.size()>0) {
     	    logger.info("Guest checkout page is already loaded");
     	}else {
    	    Actionsss.CombinedClick(homePage.clickOnLogo());
    		Thread.sleep(2000);
			if(Actionsss.countofElements(lp.clickSignList())) {
				logger.info("User not logged in");
	     		ViewCartPageTasks.viewCartpage();
	    		Actionsss.click(VCP.getSelectcheckOutBtn());
			}else {
				logger.info("user logged in");
				LogOutTasks.verifyLogout();
				if(Actionsss.countofElements(lp.clickSignList())) {
		     		ViewCartPageTasks.viewCartpage();
		    		Actionsss.click(VCP.getSelectcheckOutBtn());
				}
			}
     	}
	}
	
	public static void CheckOutPageLoadedRegisterUser() throws Exception {
     	List<WebElement> guestCheckout = driver.findElements(By.xpath("//div[@data-customer-type='guest']"));
     	List<WebElement> CheckoutPage = driver.findElements(By.xpath("//div[@class='col-sm-7']"));
     	if (guestCheckout.size()>0 &&CheckoutPage.size()>0) {
     	    logger.info("Guest checkout page is already loaded");
     	}else {
	     		ViewCartPageTasks.viewCartpage();
	     		noDisplayOfShippingMethodAndNoShippingCostAndSalesTaxForGiftCertificate();
     	}
	}
	public static void noDisplayOfShippingMethodAndNoShippingCostAndSalesTaxForGiftCertificate() throws Exception {		
		
		List<WebElement> gcInCart= driver.findElements(By.xpath("//div[contains(@class,'card product-info gift-certificate uuid')]"));
		List<WebElement> normalProductsInCart= driver.findElements(By.xpath("//div[contains(@class,'card product-info  ')]"));
		logger.info(gcInCart.size());
		logger.info(normalProductsInCart.size());
		int countOfAllProducts=gcInCart.size()+normalProductsInCart.size();
		int count=0;
		double actualShippingCost=0.00;
		double actualSalesTax=0.00;
		for(WebElement each :gcInCart) {	
			if(Actionsss.displayElement(each)) {	
				count++;		
			}
		}
		logger.info("Gc in cart " +count);
		if(countOfAllProducts==count) {
			logger.info("shiping cost and  sales tax are 0.00");
			//-----------------shipping cost----------------------
			String shippingCostValue=Actionsss.getTextOfElement(VCP.getShippingCostInCart());
			String textWithoutDollar2 = shippingCostValue.replace("$", "");
			double expectedShippingCost= Double.parseDouble(textWithoutDollar2);
			logger.info(actualShippingCost);
			logger.info(expectedShippingCost);
			//---------------sales tax----------------------
			String salesTaxValue=Actionsss.getTextOfElement(VCP.getsalesTaxInCart());	
		    String textWithoutDollar3 = salesTaxValue.replace("$", "");
		    double expectedSalesTax= Double.parseDouble(textWithoutDollar3);
			if(actualShippingCost==expectedShippingCost && actualSalesTax==expectedSalesTax && !Actionsss.elementSize(VCP.getShippingMethodFormList())) {
				logger.info("Shipping method should not display and Shipping cost and sales tax are 0.00 as only gift certificate in cart");
				test.pass("Shipping method should not display and Shipping cost and sales tax are 0.00 as only gift certificate in cart");
			}else {
				logger.info("Shipping method are displaying , Shipping cost and sales tax are not 0.00 though gift certificate in cart");
				test.fail(" Shipping method are displaying ,Shipping cost and sales tax are not  0.00 as though gift certificate in cart");
			}
			
		}else {
			logger.info("Cart contains normal products and gift certificate or normal prodcuts.");
		}
		ViewCartPageTasks.checkOutBtnClickinViewCart();
	}

	public static void logo() throws Exception {
		CheckOutPageLoaded();
		Actionsss.CombinedClick(homePage.clickOnLogo());
		Thread.sleep(2000);
		CheckOutPageValidation.verifyClickOnLogo();
	}
	
	public static void backtoCart() throws Exception {
		CheckOutPageLoaded();
		Actionsss.CombinedClick(CP.getSelectbacktoCartLink());
		Thread.sleep(2000);
		CheckOutPageValidation.verifyClickOnBacktoCart();
	}
	
	//Product link
	public static void productLink() throws Exception {
		CheckOutPageLoaded();
		Actionsss.randomElementFromListScrollIntoView(CP.getProductLink());
		Thread.sleep(2000);
		CheckOutPageValidation.verifyCheckoutProductClick();
	}
	
	
	//login 
	public static void emptyEmailandPassword() throws Exception {
		CheckOutPageLoaded();
		Actionsss.CombinedClick(CP.getSelectclickBtnLogin());
		Thread.sleep(2000);
		CheckOutPageValidation.verifyEmptyEmailandEmptyPassword();
	}
	
	public static void invalidEmailandemptyPassword() throws Exception {
		CheckOutPageLoaded();
		Thread.sleep(2000);
		Actionsss.sendKeys(CP.getEmail(), TD.Invalid_Email_Login_IP_Data, TD.UserName_Checkout_Login_IP_FieldName);
		Actionsss.CombinedClick(CP.getSelectclickBtnLogin());
		Thread.sleep(2000);
		CheckOutPageValidation.verifyInvalidEmailandEmptyPassword();
	}
	
	public static void InvalidEmailandInvalidPassword() throws Exception {
		CheckOutPageLoaded();
		Thread.sleep(2000);
		Actionsss.sendKeys(CP.getEmail(), TD.Invalid_Email_Login_IP_Data, TD.UserName_Checkout_Login_IP_FieldName);
		Actionsss.sendKeys(CP.getPassword(), TD.Invalid_Passowrd_Login_IP_Data, TD.Passowrd_Checkout_Login_IP_FieldName);
		Actionsss.CombinedClick(CP.getSelectclickBtnLogin());
		Thread.sleep(2000);
		CheckOutPageValidation.verifyInvalidEmailandInvalidPassword();
	}
	
	public static void emptyEmailandInvalidPassword() throws Exception {
		CheckOutPageLoaded();
		Thread.sleep(2000);
		Actionsss.clearText(CP.getEmail());
		Actionsss.sendKeys(CP.getPassword(), TD.Invalid_Passowrd_Login_IP_Data, TD.Passowrd_Checkout_Login_IP_FieldName);
		Actionsss.CombinedClick(CP.getSelectclickBtnLogin());
		Thread.sleep(2000);
		CheckOutPageValidation.verifyemptyEmailandInvalidPassword();
	}
	
	public static void ValidEmailandPassword() throws Exception {
		CheckOutPageLoaded();
		Thread.sleep(2000);
		Actionsss.sendKeys(CP.getEmail(),TD.Valid_UserName_Login_IP_Data, TD.UserName_Checkout_Login_IP_FieldName);
		Actionsss.sendKeys(CP.getPassword(), TD.Valid_PWD_Login_IP_Data, TD.Passowrd_Checkout_Login_IP_FieldName);
		Actionsss.CombinedClick(CP.getSelectclickBtnLogin());
		Thread.sleep(5000);
		CheckOutPageValidation.VerifyValidEmailandPasswordInput();
		Thread.sleep(2000);
		Actionsss.CombinedClick(homePage.clickOnLogo());
		Thread.sleep(2000);
	}
	

	//forgot password
	public static void forgotpwdView() throws Exception {
		if(Actionsss.countofElements(CP.getforgotPasswordHeader())) {
			logger.info("pop up displayed");
		}else {
			CheckOutPageLoaded();
			Thread.sleep(2000);
			Actionsss.CombinedClick(CP.getforgotPassword());
		}
	}
	
	public static void forgotpassword() throws Exception {
		forgotpwdView();
		CheckOutPageValidation.VerifyforgotpasswordPOPUP();
	}
	
	public static void emptyemailforgotpassword() throws Exception {
		forgotpwdView();
		Actionsss.CombinedClick(CP.getforgotpasswordSendBtn());
		Thread.sleep(2000);
		CheckOutPageValidation.VerifyemptyEmailforgotpasswordPOPUP();
	}
	
	public static void InvalidEmailforgotpassword() throws Exception {
		forgotpwdView();
		Thread.sleep(1000);
		CP.getforgotpasswordEmailhardcodeinvalid();
		//Actionsss.sendKeys(CP.getforgotpasswordEmail(), "Invalid", Email);
		Actionsss.CombinedClick(CP.getforgotpasswordSendBtn());
		Thread.sleep(4000);
		CheckOutPageValidation.VerifyinvalidEmailforgotpasswordPOPUP();
	}
	
	public static void ValidEmailforgotpassword() throws Exception {
		forgotpwdView();
		Thread.sleep(1000);
		CP.getforgotpasswordEmailhardcodevalid();
		//Actionsss.sendKeys(CP.getforgotpasswordEmail(), name, Email);
		Actionsss.CombinedClick(CP.getforgotpasswordSendBtn());
		Thread.sleep(2000);
		Actionsss.CombinedClick(CP.getforgotpasswordLoginBtn());
		CheckOutPageValidation.VerifyforgotpasswordPOPUPLogin();
	}
	
	public static void ValidEmailforgotpasswordAndCloseThePopUp() throws Exception {
		forgotpwdView();
		Thread.sleep(1000);
		CP.getforgotpasswordEmailhardcodevalid();
		//Actionsss.sendKeys(CP.getforgotpasswordEmail(), name, Email);
		Actionsss.CombinedClick(CP.getforgotpasswordSendBtn());
		Thread.sleep(4000);
		Actionsss.CombinedClick(CP.getforgotpasswordLoginBtn());		
		Actionsss.CombinedClick(CP.getCloseForgotPassword());
		CheckOutPageValidation.VerifyforgotpasswordPOPUPLogin();
	}
	
	
	//signup
	//link
	public static void signUpLink() throws Exception {
		CheckOutPageLoaded();
		Thread.sleep(2000);
		Actionsss.CombinedClick(CP.getCreatesingUPLinktLink());
		CheckOutPageValidation.VerifySingUpLink();
	}
    //page view
	public static void createAccPage() throws Exception {
		if(Actionsss.countofElements(CP.getsignUpHeaders())) {
			logger.info("Create account already loaded");		
		}else {
			if(Actionsss.displayElement(lp.clickSign())) {
				logger.info("user not logged in");
				signUpLink();
			}else {
				logger.info("user logged in");
				LogOutTasks.verifyLogout();
				if(Actionsss.displayElement(lp.clickSign())) {
					signUpLink();
				}
			}
	   }
	}
	
	//all empty 
	public static void withoutEntringdetailsandcrateAccount() throws Exception {
		createAccPage();
		Actionsss.CombinedClick(CP.getCreateAccountButton());
		CreateAccountValidation.validateAllErrors();
	}
	
	public static void enterFName() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    Thread.sleep(2000);
	    CreateAccountValidation.validateFNameAllErrors();
		
	}
	
	public static void helpCenter() throws Exception {
		CheckOutPageLoaded();
		if(Actionsss.elementSize(CP.getNeedHelpList())) {
			Actionsss.click(CP.getNeedHelp());
			
			Alert alert = driver.switchTo().alert();        
	        String alertText = alert.getText();
	        logger.info("Alert Text: " + alertText);
	     //   String expectedText="Your postal code is incomplete.";
	        alert.accept(); 
			// Get the current window handle
	        String mainWindowHandle = driver.getWindowHandle();

	        // Perform actions that open new windows or tabs on the website

	        // Get all window handles
	        Set<String> allWindowHandles = driver.getWindowHandles();

	        // Iterate through all window handles
	        for (String handle : allWindowHandles) {
	            // Switch to the desired window
	            driver.switchTo().window(handle);

	            // Check if this is the window you want to close
	            if (!handle.equals(mainWindowHandle)) {
	                // Close the window
	                driver.close();
	            }
	        }

	        // Switch back to the main window
	        driver.switchTo().window(mainWindowHandle);
	        logger.info("Clicked on help center and closed ");

		}
	}
	
	public static void enter_FName_LName() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validateLNameAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone() throws Exception{
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validatePhoneAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone_Email() throws Exception{
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.Email_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validateEmailAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone_Email_CEmail() throws Exception{
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.Email_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data,TD.ConfirmEmail_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validateCEmailAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone_Email_CEmail_PWD()throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.Email_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data,TD.ConfirmEmail_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreatePassword(), TD.Password_CA_IP_Data,TD.Password_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validatePWdAllErrors();
		
	}
	//invalid phone number
	public static void enteralldeailsandInvalidPhoneNumber() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.Invalidphone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreatePassword(), TD.Password_CA_IP_Data,TD.Password_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    CreateAccountValidation.phoneNumber();
	}
	
	//invalid email
	public static void enteralldeailsandInvalidEmail() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.InvalidEamil_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmEmail(), TD.InvalidEamil_CA_IP_Data,TD.ConfirmEmail_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreatePassword(), TD.Password_CA_IP_Data,TD.Password_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    CreateAccountValidation.emailFormat();
	}
	
	
	//already exists mail error
	public static void enteralldeailsandAlreadyExistsEmail() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.FirstName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreatePassword(), TD.Password_CA_IP_Data,TD.Password_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    CreateAccountValidation.alreadyExistsMail();
	}
	
	//Miss match mail error
	public static void enteralldeailsandMissMatchEmail() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.DifferentEmail_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreatePassword(), TD.Password_CA_IP_Data,TD.Password_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    CreateAccountValidation.MissmatchMail();
	}
	
	//password miss mactch
	public static void enteralldeailsandPasswordMissMatchEmail() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.Email_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data,TD.ConfirmEmail_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreatePassword(), TD.Password_CA_IP_Data,TD.Password_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmPassword(), TD.DifferentPWD_CA_IP_Data,TD.ConfirmPassword_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    CreateAccountValidation.MissPWDMail();
	}
	
	//password strength
	public static void enteralldeailsandPasswordWeak() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(),TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.Email_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data,TD.ConfirmEmail_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreatePassword(), TD.WeakPWD_CA_IP_Data,TD.Password_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmPassword(), TD.WeakPWD_CA_IP_Data,TD.ConfirmPassword_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    CreateAccountValidation.passwordStrengthError();
	}
	
	//create account with valid detals
	public static void enterValidDetails() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getPhone(), TD.phone_CA_IP_Data,TD.phone_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreateEmail(), TD.Email_CP_CA_IP_Data,TD.Email_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmEmail(), TD.ConfirmEmail_CP_CA_IP_Data,TD.ConfirmEmail_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getCreatePassword(), TD.Password_CA_IP_Data,TD.Password_Checkout_CA_IP_FieldName);
	    Actionsss.sendKeys(CP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_Checkout_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CheckOutPageValidation.VerifyValidEmailandPasswordInput();
//	    Actionsss.CombinedClick(homePage.clickOnLogo());
//		Thread.sleep(2000);
	}
	
	

	
	//guest login
	public static void guestCheckoutbtn() throws Exception {
		CheckOutPageLoaded();
		Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());
		Thread.sleep(1000);
		CheckOutPageValidation.verifyClickOnGuestCheckoutBtn();
	}
	
	public static void emptyMail() throws Exception {
		CheckOutPageLoaded();
		Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());
		Thread.sleep(1000);
		Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
		CheckOutPageValidation.verifyemptyEmail();
	}
	
	public static void invaidMail() throws Exception {
		CheckOutPageLoaded();
		Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());
		Thread.sleep(1000);
		Actionsss.sendKeys(CP.getSelectGuestEmailInput(), TD.Invalid_Email_Login_IP_Data, TD.Guest_Email_Checkout_Login_IP_FieldName);
		Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
		CheckOutPageValidation.verifyInvaidEmail();
	}
	
	public static void GuestMailCheckOut() throws Exception {
		CheckOutPageLoaded();
		Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());
		Thread.sleep(1000);
		Actionsss.sendKeys(CP.getSelectGuestEmailInput(), TD.Guest_Email_Checkout_Login_IP_Data, TD.Guest_Email_Checkout_Login_IP_FieldName);
		Thread.sleep(1000);
		Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
		CheckOutPageValidation.VerifiedThatGuestLogin();
//		Thread.sleep(2000);
//		Actionsss.CombinedClick(homePage.clickOnLogo());
//		Thread.sleep(2000);
	}

	public static void CheckOutPageLoadedReg() throws Exception {
     	List<WebElement> guestCheckout = driver.findElements(By.xpath("//div[@data-customer-type='guest']"));
     	List<WebElement> CheckoutPage = driver.findElements(By.xpath("//div[@class='col-sm-7']"));
     	if (guestCheckout.size()>0 &&CheckoutPage.size()>0) {
     	    logger.info("Guest checkout page is already loaded");
     	}else {
     		ViewCartPageTasks.viewCartpage();
    		Actionsss.CombinedClick(VCP.getSelectcheckOutBtn());
     	}
	}
	public static void GuestMailCheckOutReg() throws Exception {
		CheckOutPageLoadedReg();
		guestCheckout();
	}
	public static void guestCheckout() throws Exception {
		if(Actionsss.elementSize(CP. getSelectGuestCheckoutBtnList())) {	
			test.info("User logged in as guest");
			Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());		
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(), TD.Guest_Email_Checkout_Login_IP_Data, TD.Guest_Email_Checkout_Login_IP_FieldName);		
			Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
			CheckOutPageValidation.VerifiedThatGuestLogin();
		}else {
			test.info("User logged in as registered");
		}
	}
}
