package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageEditProileTasks;

public class MyAccountPageEditProileTests extends baseClass{
	
	//edit profile test cases 
		@Test(groups = {"regression"})
	    public void VerifingEditprofilelinkInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.editporfileView();
	    }
		
		//home link
		@Test(groups = {"regression"})
	    public void VerifingEditprofileHomeInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.homelink();
	    }
		//myaccount link
		@Test(groups = {"regression"})
	    public void VerifingEditprofileMyAccountlinkInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.myAccountedit();
	    }
		
		//cancel button
		@Test(groups = {"regression"})
	    public void VerifingEditprofileCancelInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.cancellink();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingEditprofileBackToMyAccountInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.backtomyaccountlink();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingEditprofileEmptyFormInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.editPorfileEmptyForm();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingEditprofileInvalidPhoneNumberInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.invalidPhone();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingEditprofileInvalidEmailInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.invalidEmail();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingEditprofileEmailMissMatchInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.emailMissMatch();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingEditprofilePWDmissMatchInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.pwdmissmatch();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingEditprofileValidDetalsInMyAccountPage() throws Exception {
	        
			MyAccountPageEditProileTasks.validDetails();
	    }
		

}
