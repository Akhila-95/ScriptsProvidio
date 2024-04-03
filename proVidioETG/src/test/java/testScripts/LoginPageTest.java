package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.LoginPageTasks;

public class LoginPageTest extends baseClass {

	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithIncorrectCredentials()throws Exception {
		  LoginPageTasks.loginFailureWithIncorrectCredentials();
	    }
	  
	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithEmptyEmailAndPassword()throws Exception {
		  LoginPageTasks.loginFailureWithEmptyEmailAndPassword();
	    }

	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithInvalidEmailFormat()throws Exception {
		  LoginPageTasks.loginFailureWithInvalidEmailFormat();
	    }
	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithEmptyEmail()throws Exception {
		  LoginPageTasks.verifyLoginFailureWithEmptyEmail();
	    }
	  
	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithEmptyPassword()throws Exception {
		  LoginPageTasks.loginFailureWithEmptyPassword();
	    }

	  @Test(groups = {"smoke","regression"})
	    public void VerifyingLoginWithValidCredentials()throws Exception {
		  LoginPageTasks.verifyThatuserLogin();
	    }
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingforgotpasswordInLoginPage()throws Exception {
		  LoginPageTasks.forgotpassword();
	    }
	  
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingemptyemailforgotpasswordInLoginPage()throws Exception {
		  LoginPageTasks.emptyemailforgotpassword();
	    }
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingInvalidEmailforgotpasswordInLoginPage()throws Exception {
		  LoginPageTasks.InvalidEmailforgotpassword();
	    }
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingValidEmailforgotpasswordInLoginPage()throws Exception {
		  LoginPageTasks.ValidEmailforgotpassword();
	    }
	  
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingValidEmailforgotpasswordAndCloseThePopUpInLoginPage()throws Exception {
		  LoginPageTasks.ValidEmailforgotpasswordAndCloseThePopUp();
	    }
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingEmptyFieldErrorInCheckOrder()throws Exception {
		  LoginPageTasks.checkOrderEmptyFields();
	    }
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingCheckOrderWithValidDetails()throws Exception {
		  LoginPageTasks.validDetailsIncheckOrder();
	    }
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingErrorMessageForInvalidEmail()throws Exception {
		  LoginPageTasks.invalidEmailIncheckOrder();
	    }
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingErrorMessageForInCompleteEmail()throws Exception {
		  LoginPageTasks.incompleteEmailIncheckOrder();
	    }
	  
	  @Test(groups = {"smoke","regression"})
	    public void VerifyingErroorMessageForInCorrectBillingZipCode()throws Exception {
		  LoginPageTasks.inCorrectBillingZipCodeIncheckOrder();
	    }
}
