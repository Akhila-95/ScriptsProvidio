package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.CreateAccountPageTasks;
import tasks.WishlistPageTasks;

public class WishlistPageTests extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
    public static void VerifyingProductsinWishList() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.WhislistView();
    }
	
	//home
	@Test(groups = {"regression"})
    public static void VerifyingHomeLinkinWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.homeLink();
    }
	
	//custom input
	@Test(groups = {"regression"})
    public static void VerifyingCustomInputinWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.customInput();
    }
	
	//remove product
	@Test(groups = {"regression"})
    public static void VerifyingRemoveFromWishListinWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.removeProduct();
    }
	
	//edit link
	@Test(groups = {"regression"})
    public static void VerifyingEditLinkinWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.editLink();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingEditClosebuttoninWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.editCloseBtn();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingEditpopupAttributesinWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.editAttributes();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingEditpopupUpdateButtoninWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.updatebutton();
    }
	
	//attributes selection
	@Test(groups = {"regression"})
    public static void VerifyingselectAttributesLinkinWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.selectAttributesLink();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingselectAttributesClosebuttoninWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.selectAttributesCloseBtn();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingselectAttributespopupAttributesinWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.selectAttributesAttributes();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingselectAttributespopupUpdateButtoninWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.selectAttributesupdatebutton();
    }
	
	//addtocart
	@Test(groups = {"regression"})
    public static void VerifyingAddtocartButtoninWishListPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		WishlistPageTasks.AddtoCartbutton();
    }
	
	//login
	@Test(groups = {"regression"})
    public void VerifyingLoginFailureWithIncorrectCredentialsInWishListPage()throws Exception {
		WishlistPageTasks.loginFailureWithIncorrectCredentials();
    }
  
    @Test(groups = {"regression"})
    public void VerifyingLoginFailureWithEmptyEmailAndPasswordInWishListPage()throws Exception {
    	WishlistPageTasks.loginFailureWithEmptyEmailAndPassword();
    }

    @Test(groups = {"regression"})
    public void VerifyingLoginFailureWithInvalidEmailFormatInWishListPage()throws Exception {
    	WishlistPageTasks.loginFailureWithInvalidEmailFormat();
    }
    @Test(groups = {"regression"})
    public void VerifyingLoginFailureWithEmptyEmailInWishListPage()throws Exception {
    	WishlistPageTasks.verifyLoginFailureWithEmptyEmail();
    }
  
    @Test(groups = {"regression"})
    public void VerifyingLoginFailureWithEmptyPasswordInWishListPage()throws Exception {
    	WishlistPageTasks.loginFailureWithEmptyPassword();
    }

    @Test(groups = {"smoke","regression"})
    public void VerifyingLoginWithValidCredentialsInWishListPage()throws Exception {
    	WishlistPageTasks.verifyThatuserLogin();
    }
    
    
    
	//forgot password
	@Test(groups = {"regression"})
    public void VerifingForgotPasswordLinkInWishListPage() throws Exception {
		WishlistPageTasks.forgotpassword();
    }
	
	@Test(groups = {"regression"})
    public void VerifingEmptyEmailInPOPUPForgotPasswordInWishListPage() throws Exception {
		WishlistPageTasks.emptyemailforgotpassword();
    }
	
	@Test(groups = {"regression"})
    public void VerifingInvaidEmailInPOPUPForgotPasswordInWishListPage() throws Exception {
		WishlistPageTasks.InvalidEmailforgotpassword();
    }
	
	@Test(groups = {"regression"})
    public void VerifingValidEmailInPOPUPForgotPasswordInWishListPage() throws Exception {
		WishlistPageTasks.ValidEmailforgotpassword();
    }
	
	
	//-------------create account
	
	
	@Test(groups = {"smoke","regression"})
    public void VerifingCreateAccountLinkInWishListPage() throws Exception {
		WishlistPageTasks.createAccountLink();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifingEmptyFormInWishListPage() throws Exception {
		WishlistPageTasks.withoutEntringdetailsandcrateAccount();
    }
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnterFNameInCreatingAccOnWishListPage() throws Exception {
		WishlistPageTasks.enterFName();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LNameInCreatingAccOnWishListPage() throws Exception {
		WishlistPageTasks.enter_FName_LName();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_PhoneInCreatingAccOnWishListPage() throws Exception {
		WishlistPageTasks.enter_FName_LName_Phone();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_Phone_EmailInCreatingAccOnWishListPage() throws Exception {
		WishlistPageTasks.enter_FName_LName_Phone_Email();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_Phone_Email_CEmailInCreatingAccOnWishListPage() throws Exception {
		WishlistPageTasks.enter_FName_LName_Phone_Email_CEmail();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_Phone_Email_CEmail_PWDsInCreatingAccOnWishListPage() throws Exception {
		WishlistPageTasks.enter_FName_LName_Phone_Email_CEmail_PWD();
	}
	
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageInvalidPhoneNumberInWishListPage() throws Exception {
		WishlistPageTasks.enteralldeailsandInvalidPhoneNumber();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageInvalidEmailInWishListPage() throws Exception {
		WishlistPageTasks.enteralldeailsandInvalidEmail();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageMailAlreadyExistsInWishListPage() throws Exception {
		WishlistPageTasks.enteralldeailsandAlreadyExistsEmail();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageEMailMissMatchInWishListPage() throws Exception {
		WishlistPageTasks.enteralldeailsandMissMatchEmail();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagePasswordMissMatchInWishListPage() throws Exception {
		CreateAccountPageTasks.enteralldeailsandPasswordMissMatchEmail();
	}
	
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagePasswordStrengthInWishListPage() throws Exception {
		WishlistPageTasks.enteralldeailsandPasswordWeak();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingCrateAccountwithValidDetatisInWishListPage() throws Exception {
		WishlistPageTasks.enterValidDetails();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingMoreButtonClickInWishlist() throws Exception {
		WishlistPageTasks.moreButtonInWishList();
	}
	
	
	

}
