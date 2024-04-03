package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageChangePasswordTasks;

public class MyAccountPageChangePasswordTests extends baseClass{
	
	//change password tests cases 
		@Test(groups = {"regression"})
	    public void VerifyingChangePasswordPageInMyAccountPage() throws Exception {
	        
			MyAccountPageChangePasswordTasks.changePWDpageView();
	    }
		
		//home
		@Test(groups = {"regression"})
	    public void VerifingchangePwdHomeInMyAccountPage() throws Exception {
	        
			MyAccountPageChangePasswordTasks.changePwdhomelink();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingchangePwdMyAccountlinkInMyAccountPage() throws Exception {
	        
			MyAccountPageChangePasswordTasks.changePwdedit();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingchangePwdCancelInMyAccountPage() throws Exception {
	        
			MyAccountPageChangePasswordTasks.changePwdcancellink();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingchangePwdBackToMyAccountInMyAccountPage() throws Exception {
	        
			MyAccountPageChangePasswordTasks.changePwdbacktomyaccountlink();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingChangePasswordEmptyFormInMyAccountPage() throws Exception {
	        
			MyAccountPageChangePasswordTasks.emptyForm();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingChangePasswordpassworddoesnotMatchwithCurrentUserInMyAccountPage() throws Exception {
	        
			MyAccountPageChangePasswordTasks.passworddoesnotMatchwithCurrentUser();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingChangechangepwdmissmatchInMyAccountPage() throws Exception {
	        
			MyAccountPageChangePasswordTasks.changepwdmissmatch();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingChangevalidPasswordInMyAccountPage() throws Exception {
	        
			MyAccountPageChangePasswordTasks.validPassword();
	    }
		
		

}
