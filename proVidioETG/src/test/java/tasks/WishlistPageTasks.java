package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.CheckOutPage;
import pageObjects.CreateAccountPage;
import pageObjects.LogoutPage;
import pageObjects.WishlistPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.CheckOutPageValidation;
import validations.CreateAccountValidation;
import validations.LoginValidation;
import validations.ProductDetailPageValidation;
import validations.WishListPageValidations;

public class WishlistPageTasks extends baseClass{
	private static final  TestData TD = new TestData();
	private static homepage homePage = new homepage(driver);
	private static WishlistPage WLP = new WishlistPage(driver);
	private static final loginPage lp = new loginPage(driver);
	private static final  LoginValidation lv = new LoginValidation();
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final  LogoutPage lop = new LogoutPage(driver);
	
	private static Faker faker = new Faker();
	static String randomFirstName = faker.name().firstName(); 
    static String NewnameforCreateAccount = randomFirstName + "upendra@gmail.com";

	private static final CreateAccountPage CAP = new CreateAccountPage(driver);
	
	private static final String CustomInputWL="Custom Input In WishList";
	
	public static void wishlistValue() throws Exception {
        //WebElement productCountInwishlist = driver.findElement(By.xpath("(//span[@class='wishlistCount'])[1]"));
        String countOfwishlist = Actionsss.getTextOfElement(WLP.getWishlistCount());
        Thread.sleep(2000);
        int minicartProductCountValue = Integer.parseInt(countOfwishlist);
        if(minicartProductCountValue>4) {
        	logger.info("Products are avaliable in wishlist");
        }else {
        	
        	ProductListingPageTasks.addToWishListOf15MoreProducts();
    	 /*   Actionsss.CombinedClick(homePage.clickOnLogo());
    		Thread.sleep(2000);
        	ProductListingPageTasks.addToWishList();*/
        	//wishlistValue();
        }
	}
	
	public static void WhislistView() throws Exception {

		if(Actionsss.countofElements(WLP.getwishlistHeader())) {
			logger.info("wishlist page is already loaded");
		}else {			
			wishlistValue();
			Thread.sleep(2000);
		    Actionsss.CombinedClick(homePage.getWishListLink());
		    Thread.sleep(3000);
		    WishListPageValidations.verifyheader();
		}
	}
	
	public static void homeLink() throws Exception {
		WhislistView();
		Thread.sleep(2000);
	    Actionsss.CombinedClick(WLP.getHomelink());
	    Thread.sleep(3000);
	    WishListPageValidations.verifyHomeLink();
	}
	
	public static void loginCheck() throws InterruptedException, Exception {
 		Actionsss.CombinedClick(homePage.clickOnLogo());
 		if(Actionsss.elementSize(lop.getHoverMyAccountList())) {							
			logger.info("user logged in");
		}else if(Actionsss.displayElement(lp.clickSign())) {
			 Actionsss.click(lp.clickSign());
			 LoginPageTasks.verifyThatuserLogin();	 			    
		}
 	}
	
	//custom input
	public static void customInput() throws Exception {
		
		updatebutton();
		if(Actionsss.countofElements(WLP.getselectInputlist())) {
			Actionsss.CombinedClick(WLP.getSelectdropdownInput());
			Thread.sleep(3000);
			Actionsss.randomElementFromListfordropdown(WLP.getSelectCustomInputlist());
			ProductDetailPageValidation.verifyselectedInput();
		}else{
			Thread.sleep(2000);
			Actionsss.randomElementFromListSendKeys(WLP.getSelectcustomInput(), 3, CustomInputWL);
		}

	}
	
	
	//remove product
	public static void removeProduct() throws Exception {
		WhislistView();
		Thread.sleep(2000);
		test.info("Verify product reomove form the wishlist");
		Actionsss.randomElementFromListScrollIntoView(WLP.getSelectremoveBtn());
	    Thread.sleep(3000);
	    test.pass("Successfully product is reomove form the wishlist");
	    
	}
	
	//edit the product
	public static void editLink() throws Exception {
		if(Actionsss.countofElements(WLP.geteditpopup())) {
			logger.info("edit pop up is already loaded");
		}else {
			WhislistView();
			Thread.sleep(2000);
		    Actionsss.randomElementFromListScrollIntoView(WLP.getSelecteditlink());
		    Thread.sleep(1000);
		    WishListPageValidations.verifyeditlink();
		}
	}
	
	public static void editCloseBtn() throws Exception {
		editLink();
		Actionsss.CombinedClick(WLP.getcloseBtn());
		WishListPageValidations.verifyeditclosebtn();
	}
	
	public static void editAttributes() throws Exception {
		editLink();
		allAttributesSelection.quickshopallAttributes();
		WishListPageValidations.verifyAttributesSelection();
		Actionsss.CombinedClick(WLP.getcloseBtn());
	}
	
	public static void updatebutton() throws Exception {
		editLink();
		allAttributesSelection.selectTheAttributesInQuickShop();
		Thread.sleep(2000);
		Actionsss.CombinedClick(WLP.getupdateBtn());
		WishListPageValidations.verifyeditupdatebtn();
	}
	
	//attriubutes selection
	public static void selectAttributesLink() throws Exception {
		if(Actionsss.countofElements(WLP.geteditpopup())) {
			logger.info("attribures pop up is already loaded");
		}else {
			WhislistView();
			Thread.sleep(2000);
		    Actionsss.randomElementFromListScrollIntoView(WLP.getSelectselectAttributesBtn());
		    Thread.sleep(1000);
		    WishListPageValidations.verifyattribuespopuplink();
		}
	}
	
	public static void selectAttributesCloseBtn() throws Exception {
		selectAttributesLink();
		Actionsss.CombinedClick(WLP.getcloseBtn());
		WishListPageValidations.verifyeditclosebtn();
	}
	
	public static void selectAttributesAttributes() throws Exception {
		selectAttributesLink();
		allAttributesSelection.quickshopallAttributes();
		WishListPageValidations.verifyAttributesSelection();
		Thread.sleep(2000);;
		//Actionsss.CombinedClick(WLP.getcloseBtn());
	}
	
	public static void selectAttributesupdatebutton() throws Exception {
		selectAttributesLink();
		allAttributesSelection.quickshopallAttributes();
		Thread.sleep(3000);
		Actionsss.CombinedClick(WLP.getupdateBtn());
		WishListPageValidations.verifyeditupdatebtn();
	}
	
	
	//add to cart
	public static void AddtoCartbutton() throws Exception {
		WhislistView();
		Actionsss.randomElementFromListScrollIntoView(WLP.getSelectaddtoCartBtn());
		//Thread.sleep(2000);
		WishListPageValidations.validatingProductisAddtoCart();
	}
	
   //login
	
	public static void wishlistLoginView() throws Exception {
		if(Actionsss.countofElements(WLP.getwishlistHeader())) {
			logger.info("wishlist page is already loaded");
			
			if(Actionsss.countofElements(lp.clickSignList())) {
				logger.info("User not logged in");									
			}else {
				logger.info("user logged in");
				LogOutTasks.verifyLogout();
				Thread.sleep(2000);
			}
				
		}else {
			
			if(Actionsss.countofElements(lp.clickSignList())) {
				logger.info("User not logged in");
				wishlistValue();
				Thread.sleep(2000);
			    Actionsss.CombinedClick(homePage.getWishListLink());
			    Thread.sleep(3000);
			    WishListPageValidations.verifyheader();					 
									
			}else {
				logger.info("user logged in");
				LogOutTasks.verifyLogout();
				Thread.sleep(2000);
				if(Actionsss.displayElement(lp.clickSign())) {
					wishlistValue();
					Thread.sleep(2000);
				    Actionsss.CombinedClick(homePage.getWishListLink());
				    Thread.sleep(3000);
				    WishListPageValidations.verifyheader();					   
				}
			}
		}
		
	}
	
	 public static void loginFailureWithIncorrectCredentials() throws Exception {
		 wishlistLoginView();
	    	 test.info("Verify with invalid credentials");
	         // Enter invalid email and valid password
	          Actionsss.sendKeys(lp.getEmail(), TD.Invalid_UserName_Login_IP_Data,TD.UserName_Login_IP_FieldName);        
	          Actionsss.sendKeys(lp.getPassword(), TD.Invalid_Passowrd_Login_IP_Data, TD.Passowrd_Login_IP_FieldName);
	         // Click the login button
	          Actionsss.CombinedClick(lp.btnLogin);
	          Thread.sleep(2000);

	         // Validate invalid login scenario       
	          lv.invalidLoginError();
	        
	    }
	  
	    
	    public static void loginFailureWithEmptyEmailAndPassword() throws Exception {
	    	 wishlistLoginView();
	    	 test.info("Verify login failure with empty email and password");
	         // Click the login button
	         Actionsss.click(lp.btnLogin);
	         // Validate empty email and password login scenario   
	         lv.emptyMailAndPwd();
	    }

	  
	    public static void loginFailureWithInvalidEmailFormat() throws Exception {
	    	wishlistLoginView();
	    	test.info("Verify login failure with invalid email format");
	        // Enter an email with an invalid format
	        Actionsss.sendKeys(lp.getEmail(), TD.Invalid_EmailFormat_Login_IP_Data,TD.UserName_Login_IP_FieldName);        
	        // Provide a valid password
	        Actionsss.sendKeys(lp.getPassword(), TD.Invalid_Passowrd_Login_IP_Data,TD.Passowrd_Login_IP_FieldName);
	        
	        // Click the login button
	        Actionsss.CombinedClick(lp.btnLogin);

	        // Validate invalid email format login scenario  
	        lv.invalidEmailFormat();
	    }
	    
	   
	    public static void verifyLoginFailureWithEmptyEmail() throws Exception {
	    	
	    	wishlistLoginView();     
	    	 test.info("Verify login failure with empty email");

		        // Provide an empty email
		        Actionsss.sendKeys(lp.getEmail(), TD.Empty_UserName_Login_IP_Data,TD.UserName_Login_IP_FieldName);	      
		        // Enter a valid password
		        Actionsss.sendKeys(lp.getPassword(), TD.Empty_PWD_Login_IP_Data,TD.Passowrd_Login_IP_FieldName);
		      
		        // Click the login button
		        Actionsss.CombinedClick(lp.btnLogin);

		        // Validate login failure with empty email scenario       
		        lv.loginFailureWithEmptyEmail();
	    }

		
	    public static void loginFailureWithEmptyPassword() throws Exception {
	    	wishlistLoginView();
	    	test.info("Verify login failure with empty password");
	        // Enter a valid email
	        Actionsss.sendKeys(lp.getEmail(), TD.Valid_UserName_Login_IP_Data,TD.UserName_Login_IP_FieldName);        
	        // Provide an empty password
	        Actionsss.sendKeys(lp.getPassword(), TD.Empty_PWD_Login_IP_Data,TD.Passowrd_Login_IP_FieldName);
	       
	        // Click the login button
	        Actionsss.CombinedClick(lp.btnLogin);

	        // Validate login failure with empty password scenario   
	        lv.loginFailureWithEmptyPassword();
	    }
	    
	   
	    public static void verifyThatuserLogin() throws Exception {
	    	wishlistLoginView();
	    	test.info("Verify with valid credentials");
	        // Enter valid email and password
	        Actionsss.sendKeys(lp.getEmail(), TD.Valid_UserName_Login_IP_Data,TD.UserName_Login_IP_FieldName);      
	        Actionsss.sendKeys(lp.getPassword(), TD.Valid_PWD_Login_IP_Data,TD.Passowrd_Login_IP_FieldName);      

	        // Click the login button
	        Actionsss.CombinedClick(lp.btnLogin);

		    // Verify the result of clicking on the "Gift Card" link
	        lv.positiveValidation();
	        
	    }
    
	//forgot password
	public static void forgotpwdView() throws Exception {
		if(Actionsss.countofElements(CP.getforgotPasswordHeader())) {
			logger.info("pop up displayed");
		}else {
			wishlistLoginView();
			Thread.sleep(2000);
			Actionsss.CombinedClick(CP.getforgotPassword());
			Thread.sleep(2000);
		}
	}
	
	public static void forgotpassword() throws Exception {
		forgotpwdView();
		Thread.sleep(2000);
		CheckOutPageValidation.VerifyforgotpasswordPOPUP();
	}
	
	public static void emptyemailforgotpassword() throws Exception {
		forgotpwdView();
		Thread.sleep(2000);
		Actionsss.CombinedClick(CP.getforgotpasswordSendBtn());
		CheckOutPageValidation.VerifyemptyEmailforgotpasswordPOPUP();
	}
	
	public static void InvalidEmailforgotpassword() throws Exception {
		forgotpwdView();
		Thread.sleep(1000);
		CP.getforgotpasswordEmailhardcodeinvalid();
		//Actionsss.sendKeys(CP.getforgotpasswordEmail(), "Invalid", mail);
		Actionsss.CombinedClick(CP.getforgotpasswordSendBtn());
		CheckOutPageValidation.VerifyinvalidEmailforgotpasswordPOPUPWL();
	}
	
	public static void ValidEmailforgotpassword() throws Exception {
		forgotpwdView();
		Thread.sleep(1000);
		CP.getforgotpasswordEmailhardcodevalid();
		//Actionsss.sendKeys(CP.getforgotpasswordEmail(), name, mail);
		Actionsss.CombinedClick(CP.getforgotpasswordSendBtn());
		Thread.sleep(2000);
		Actionsss.CombinedClick(CP.getforgotpasswordLoginBtn());
		
		CheckOutPageValidation.VerifyforgotpasswordPOPUPLogin();
	}
	
	//create account
	public static void createAccPage() throws Exception {
		
		if(Actionsss.countofElements(CAP.getCreateAccountActive())) {
			logger.info("Create account already loaded");		
		}else {
			if(Actionsss.countofElements(lp.clickSignList())) {
				logger.info("User not logged in");
				 WhislistView();					 
				 Actionsss.CombinedClick(CAP.getCreateAccountLink());
				 WishListPageValidations.createAccountPageValidationwishList();  
				
			}else {
				logger.info("user logged in");
				LogOutTasks.verifyLogout();
				Thread.sleep(2000);
				if(Actionsss.displayElement(lp.clickSign())) {
					 WhislistView();					 
					 Actionsss.CombinedClick(CAP.getCreateAccountLink());
					 WishListPageValidations.createAccountPageValidationwishList();   
				}
			}
		}
	}
	
	public static void createAccountLink() throws Exception {
		createAccPage();
	}
	
	public static void withoutEntringdetailsandcrateAccount() throws Exception {
		createAccPage();
		Actionsss.CombinedClick(CAP.getCreateAccountButton());
		Thread.sleep(2000);
		CreateAccountValidation.validateAllErrors();
	}
		
	public static void enterFName() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(2000);
	    CreateAccountValidation.validateFNameAllErrors();		
	}
	
	public static void enter_FName_LName() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validateLNameAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone() throws Exception{
		createAccPage();
		Actionsss.scrollWindowsByPixel(-1000);
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validatePhoneAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone_Email() throws Exception{
		createAccPage();
		Actionsss.scrollWindowsByPixel(-1000);
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getEmail(), TD.Email_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validateEmailAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone_Email_CEmail() throws Exception{
		createAccPage();
		Actionsss.scrollWindowsByPixel(-1000);
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getEmail(), TD.Email_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data,TD.ConfirmEmail_WishList_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validateCEmailAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone_Email_CEmail_PWD()throws Exception {
		createAccPage();
		Actionsss.scrollWindowsByPixel(-1000);
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getEmail(), TD.Email_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data,TD.ConfirmEmail_WishList_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_WishList_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validatePWdAllErrors();
		
	}
	
		//invalid phone number
		public static void enteralldeailsandInvalidPhoneNumber() throws Exception {
			createAccPage();
			Actionsss.scrollWindowsByPixel(-1000);
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.Invalidphone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_WishList_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.phoneNumber();
		}
		
		//invalid email
		public static void enteralldeailsandInvalidEmail() throws Exception {
			createAccPage();
			Actionsss.scrollWindowsByPixel(-1000);
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.InvalidEamil_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.InvalidEamil_CA_IP_Data,TD.ConfirmEmail_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_WishList_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.emailFormat();
		}
		
		
		//already exists mail error
		public static void enteralldeailsandAlreadyExistsEmail() throws Exception {
			createAccPage();
			Actionsss.scrollWindowsByPixel(-1000);
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_WishList_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.alreadyExistsMail();
		}
		
		//Miss match mail error
		public static void enteralldeailsandMissMatchEmail() throws Exception {
			createAccPage();
			Actionsss.scrollWindowsByPixel(-1000);
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.DifferentEmail_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_WishList_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.MissmatchMail();
		}
		
		//password miss mactch
		public static void enteralldeailsandPasswordMissMatchEmail() throws Exception {
			createAccPage();
			Actionsss.scrollWindowsByPixel(-1000);
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.DifferentEmail_CA_IP_Data,TD.ConfirmEmail_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.DifferentPWD_CA_IP_Data,TD.ConfirmPassword_WishList_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.MissPWDMail();
		}
		
		//password strength
		public static void enteralldeailsandPasswordWeak() throws Exception {
			createAccPage();
			Actionsss.scrollWindowsByPixel(-1000);
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.WeakPWD_CA_IP_Data,TD.Password_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.WeakPWD_CA_IP_Data,TD.ConfirmPassword_WishList_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.passwordStrengthError();
		}
		
		//create account with valid detals
		public static void enterValidDetails() throws Exception {
			createAccPage();
			Actionsss.scrollWindowsByPixel(-1000);
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.Email_WL_CA_IP_Data,TD.Email_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.ConfirmEmail_WL_CA_IP_Data,TD.ConfirmEmail_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_WishList_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_WishList_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(5000);
		    CreateAccountValidation.accountPageTitle();
		}
		
		public static void moreButtonInWishList() throws Exception {
			loginCheck();
			Thread.sleep(2000);
			String countOfwishlist = Actionsss.getTextOfElement(WLP.getWishlistCount());
	        Thread.sleep(2000);
	        int minicartProductCountValue = Integer.parseInt(countOfwishlist);
	        if(minicartProductCountValue>15) {
	        	logger.info("Already Wishlist have more then 15 prodcuts ");
	        }else {
	        	ProductListingPageTasks.addToWishListOf15MoreProducts();
	        }			
			Actionsss.CombinedClick(homePage.getWishListLink());
		    Thread.sleep(3000);
		    Actionsss.scrollIntoViewCenter(WLP.getMoreButtonInWishlist());
		    Thread.sleep(1000);		 	    
		    WishListPageValidations.moreButtonClickInWishList();
		}
}
