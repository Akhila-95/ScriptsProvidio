package tasks;


import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.CheckOutPageValidation;
import validations.LoginValidation;

public class LoginPageTasks extends baseClass {

	private static final loginPage lp = new loginPage(driver);
	private static final  LoginValidation lv = new LoginValidation();
	private static homepage homePage = new homepage(driver);
	private static TestData TD = new TestData();
	private static CheckOutPage CP = new CheckOutPage(driver);
	
	
	public static void loginPageView() throws Exception {
			
			if(Actionsss.elementSize(lp.getLoginPageList())) {
				logger.info("Login page already loaded");
			}else {
				if(Actionsss.countofElements(lp.clickSignList())) {
					logger.info("User not logged in");
					 Actionsss.CombinedClick(lp.clickSign());					 
										
				}else {
					logger.info("user logged in");
					LogOutTasks.verifyLogout();
					Thread.sleep(2000);
					if(Actionsss.displayElement(lp.clickSign())) {
						 Actionsss.CombinedClick(lp.clickSign());					   
					}
				}
			}
		}
	
    public static void loginFailureWithIncorrectCredentials() throws Exception {
    	loginPageView();
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
    	 Actionsss.CombinedClick(homePage.clickOnLogo());
    	loginPageView();
    	 test.info("Verify login failure with empty email and password");
         // Click the login button
         Actionsss.click(lp.btnLogin);
         // Validate empty email and password login scenario   
         lv.emptyMailAndPwd();
    }

  
    public static void loginFailureWithInvalidEmailFormat() throws Exception {
    	loginPageView();
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
    	
    	 loginPageView();     
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
    	loginPageView();
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
    	loginPageView();
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
  			loginPageView();
  			Thread.sleep(2000);
  			Actionsss.CombinedClick(CP.getforgotPassword());
  			Thread.sleep(2000);
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
  		Thread.sleep(2000);
  		Actionsss.CombinedClick(CP.getforgotpasswordLoginBtn());
  		CheckOutPageValidation.VerifyforgotpasswordPOPUPLogin();
  		Actionsss.CombinedClick(CP.getCloseForgotPassword());
  	}
  
  	//------------check order---------------------------------------
  	public static void checkOrderEmptyFields() throws Exception {
  		loginPageView();
  		Actionsss.CombinedClick(lp.getCheckStatusBtn());
  		lv.checkOrderEmptyFieldError();  		
  	}
  	
  	public static void validDetailsIncheckOrder() throws Exception {
  		loginPageView();
  		Actionsss.sendKeys(lp.getOrderNumber(), TestData.orderNumberForCheckOrder, "order number");
  		Actionsss.sendKeys(lp.getOrderEmail(), TD.orderEmailForCheckOrder, "order email");
  		Actionsss.sendKeys(lp.getBillingZipCodeOfOrder(), TD.orderBillingZipForCheckOrder, "order billing zip code"); 		
  		Actionsss.CombinedClick(lp.getCheckStatusBtn());
  		lv.paginationOfCheckOrder();	
  				
  	} 
  	
  	public static void invalidEmailIncheckOrder() throws Exception {
  		loginPageView();
  		Actionsss.sendKeys(lp.getOrderNumber(), TestData.orderNumberForCheckOrder, "order number");
  		Actionsss.sendKeys(lp.getOrderEmail(), TD.invalidOrderEmailForCheckOrder, "in-valid order email");
  		Actionsss.sendKeys(lp.getBillingZipCodeOfOrder(), TD.orderBillingZipForCheckOrder, "order billing zip code"); 		
  		Actionsss.CombinedClick(lp.getCheckStatusBtn());
  		lv.invalidErrorMessageInCheckOrder();		
  	} 
  	
  	public static void incompleteEmailIncheckOrder() throws Exception {
  		loginPageView();
  		Actionsss.sendKeys(lp.getOrderNumber(), TestData.orderNumberForCheckOrder, "order number");
  		Actionsss.sendKeys(lp.getOrderEmail(), TD.inCompleteOrderEmailForCheckOrder, "incomplete order email");
  		Actionsss.sendKeys(lp.getBillingZipCodeOfOrder(), TD.orderBillingZipForCheckOrder, "order billing zip code"); 		
  		Actionsss.CombinedClick(lp.getCheckStatusBtn());
  		lv.inCompleteErrorMessageInCheckOrder();		
  	} 
  	
  	public static void inCorrectBillingZipCodeIncheckOrder() throws Exception {
  		loginPageView();
  		Actionsss.sendKeys(lp.getOrderNumber(), TestData.orderNumberForCheckOrder, "order number");
  		Actionsss.sendKeys(lp.getOrderEmail(), TD.inCompleteOrderEmailForCheckOrder, "incomplete order email");
  		Actionsss.sendKeys(lp.getBillingZipCodeOfOrder(), TD.inCorrectBillingZipCodeInCheckOrder, "order billing zip code"); 		
  		Actionsss.CombinedClick(lp.getCheckStatusBtn());
  		lv.inCorrectBillingZipCodeErrorMessageInCheckOrder();		
  	} 

}
