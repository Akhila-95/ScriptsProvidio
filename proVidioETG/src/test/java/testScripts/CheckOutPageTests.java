package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.CheckOutPageTasks;

public class CheckOutPageTests extends baseClass{
	
	
	@Test(groups = {"regression"})
    public void VerifingClickonLogoInCheckOutPage() throws Exception {
		CheckOutPageTasks.logo();
    }
	
	@Test(groups = {"regression"})
    public void VerifingClickonBacktoCartInCheckOutPage() throws Exception {
		CheckOutPageTasks.backtoCart();
    }
	
	//product link
	@Test(groups = {"regression"})
    public void VerifingProductlinkInCheckOutPage() throws Exception {
		CheckOutPageTasks.productLink();
    }

	//---------------login------------------------------------------------------
	//empty mail and password
	@Test(groups = {"regression"})
    public void VerifingEmptyEmailandPasswordInCheckOutPage() throws Exception {
		CheckOutPageTasks.emptyEmailandPassword();
    }
	
	//invalid mail and empty password
	@Test(groups = {"regression"})
    public void VerifingInvalidEmailandEmptyPasswordInCheckOutPage() throws Exception {
		CheckOutPageTasks.invalidEmailandemptyPassword();
    }
	
	//invalid mail and password
	@Test(groups = {"regression"})
    public void VerifingInvalidEmailandInvalidPasswordInCheckOutPage() throws Exception {
		CheckOutPageTasks.InvalidEmailandInvalidPassword();
    }
	
	//empty mail and invalid password
	@Test(groups = {"regression"})
    public void VerifingemptyEmailandInvalidPasswordInCheckOutPage() throws Exception {
		CheckOutPageTasks.emptyEmailandInvalidPassword();
    }
	
	//login with valid inputs
	@Test(groups = {"regression"})
    public void VerifingValidEmailandPasswordInCheckOutPage() throws Exception {
		CheckOutPageTasks.ValidEmailandPassword();
    }
	
	//login with valid inputs
	@Test(groups = {"regression"})
    public void VerifingValidEmailandPasswordInCheckOutPageCloseThePopUp() throws Exception {
		CheckOutPageTasks.ValidEmailforgotpasswordAndCloseThePopUp();
    }
	
	//------------------forgot password------------------------------------------
	@Test(groups = {"regression"})
    public void VerifingForgotPasswordLinkInCheckOutPage() throws Exception {
		CheckOutPageTasks.forgotpassword();
    }
	
	@Test(groups = {"regression"})
    public void VerifingEmptyEmailInPOPUPForgotPasswordInCheckOutPage() throws Exception {
		CheckOutPageTasks.emptyemailforgotpassword();
    }
	
	@Test(groups = {"regression"})
    public void VerifingInvaidEmailInPOPUPForgotPasswordInCheckOutPage() throws Exception {
		CheckOutPageTasks.InvalidEmailforgotpassword();
    }
	
	@Test(groups = {"regression"})
    public void VerifingValidEmailInPOPUPForgotPasswordInCheckOutPage() throws Exception {
		CheckOutPageTasks.ValidEmailforgotpassword();
    }
	
	//------------------------sing up-----------------------------------------------
	@Test(groups = {"regression"})
    public void VerifingSignUpLinkInCheckOutPage() throws Exception {
		CheckOutPageTasks.signUpLink();
    }
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesWithoutEnteringAnyDetailsInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.withoutEntringdetailsandcrateAccount();
	}
	
	 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnterFNameInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enterFName();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LNameInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enter_FName_LName();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_PhoneInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enter_FName_LName_Phone();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_Phone_EmailInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enter_FName_LName_Phone_Email();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_Phone_Email_CEmailInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enter_FName_LName_Phone_Email_CEmail();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_Phone_Email_CEmail_PWDsInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enter_FName_LName_Phone_Email_CEmail_PWD();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageInvalidPhoneNumberInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enteralldeailsandInvalidPhoneNumber();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageInvalidEmailInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enteralldeailsandInvalidEmail();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageMailAlreadyExistsInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enteralldeailsandAlreadyExistsEmail();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageEMailMissMatchInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enteralldeailsandMissMatchEmail();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagePasswordMissMatchInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enteralldeailsandPasswordMissMatchEmail();
	}
	
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagePasswordStrengthInCreatingAccOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enteralldeailsandPasswordWeak();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingCrateAccountwithValidDetatisOnCheckOutpage() throws Exception {
		CheckOutPageTasks.enterValidDetails();
	}
	
	
	//guest login
	@Test(groups = {"regression"})
    public void VerifingClickonGuestCheckoutBtnInCheckOutPage() throws Exception {
		CheckOutPageTasks.guestCheckoutbtn();
    }
    
    @Test(groups = {"regression"})
    public void VerifingEmptyEmailInputandClickonContinueAsGuestBtnInCheckOutPage() throws Exception {
		CheckOutPageTasks.emptyMail();
    }
    
    @Test(groups = {"regression"})
    public void VerifingInvaidEmailInputandClickonContinueAsGuestBtnInCheckOutPage() throws Exception {
		CheckOutPageTasks.invaidMail();
    }
    
	@Test(groups = {"smoke", "regression"})
    public void VerifingGuestLoginFuncitonalityInCheckOutPage() throws Exception {
		CheckOutPageTasks.GuestMailCheckOut();
    }

	//----------------help center------------------------
	@Test(groups = {"smoke", "regression"})
    public void VerifingThePaginationOfHelpCenterInCheckOutPage() throws Exception {
		CheckOutPageTasks.helpCenter();
    }

}
