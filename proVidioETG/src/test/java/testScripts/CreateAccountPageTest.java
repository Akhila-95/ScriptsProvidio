package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.CheckOutPageTasks;
import tasks.CreateAccountPageTasks;

public class CreateAccountPageTest extends baseClass{
	
		
	@Test(groups = {"smoke","regression"})
    public void VerifingCreateAccountLinkInLoginPage() throws Exception {
		CreateAccountPageTasks.createAccountLink();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifingEmptyFormInCreateAccountPage() throws Exception {
		CreateAccountPageTasks.withoutEntringdetailsandcrateAccount();
    }
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnterFNameInCreatingAcc() throws Exception {
		CheckOutPageTasks.enterFName();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LNameInCreatingAcc() throws Exception {
		CheckOutPageTasks.enter_FName_LName();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_PhoneInCreatingAcc() throws Exception {
		CheckOutPageTasks.enter_FName_LName_Phone();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_Phone_EmailInCreatingAcc() throws Exception {
		CheckOutPageTasks.enter_FName_LName_Phone_Email();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_Phone_Email_CEmailInCreatingAcc() throws Exception {
		CheckOutPageTasks.enter_FName_LName_Phone_Email_CEmail();
	}
	
	//all field empty 
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagesEnter_FName_LName_Phone_Email_CEmail_PWDsInCreatingAcc() throws Exception {
		CheckOutPageTasks.enter_FName_LName_Phone_Email_CEmail_PWD();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageInvalidPhoneNumberInCreatingAccountPage() throws Exception {
		CreateAccountPageTasks.enteralldeailsandInvalidPhoneNumber();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageInvalidEmailInCreatingAccountPage() throws Exception {
		CreateAccountPageTasks.enteralldeailsandInvalidEmail();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageMailAlreadyExistsInCreatingAccountPage() throws Exception {
		CreateAccountPageTasks.enteralldeailsandAlreadyExistsEmail();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessageEMailMissMatchInCreatingAccountPage() throws Exception {
		CreateAccountPageTasks.enteralldeailsandMissMatchEmail();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagePasswordMissMatchInCreatingAccountPage() throws Exception {
		CreateAccountPageTasks.enteralldeailsandPasswordMissMatchEmail();
	}
	
	
	@Test(groups = {"regression"})
	public static void VerifyingErrorMessagePasswordStrengthInCreatingAccountPage() throws Exception {
		CreateAccountPageTasks.enteralldeailsandPasswordWeak();
	}
	
	@Test(groups = {"regression"})
	public static void VerifyingCrateAccountwithValidDetatisOnCreatingAccountPage() throws Exception {
		CreateAccountPageTasks.enterValidDetails();
	}
	

	@Test(groups = {"regression"})
	public static void VerifyingCreateAccountwithSpecialCharactersOnCreatingAccountPage() throws Exception {
		CreateAccountPageTasks.createAccountWithSpecialCharacters();
	}
	
}
