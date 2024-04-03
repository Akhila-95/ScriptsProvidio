package tasks;

import org.openqa.selenium.Keys;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.CreateAccountPage;
import pageObjects.loginPage;
import validations.CreateAccountValidation;

public class CreateAccountPageTasks extends baseClass{

	private static final CreateAccountPage CAP = new CreateAccountPage(driver);
	private static final loginPage lp = new loginPage(driver);
	private static final  TestData TD = new TestData();
	
	public static void createAccPage() throws Exception {
		
		if(Actionsss.countofElements(CAP.getCreateAccountActive())) {
			logger.info("Create account already loaded");		
		}else {
			if(Actionsss.countofElements(lp.clickSignList())) {
				logger.info("User not logged in");
				 Actionsss.CombinedClick(lp.clickSign());					 
				 Actionsss.CombinedClick(CAP.getCreateAccountLink());
				 CreateAccountValidation.createAccountPageValidation();  
				
			}else {
				logger.info("user logged in");
				LogOutTasks.verifyLogout();
				Thread.sleep(2000);
				if(Actionsss.displayElement(lp.clickSign())) {
					 Actionsss.CombinedClick(lp.clickSign());					 
					 Actionsss.CombinedClick(CAP.getCreateAccountLink());
					 CreateAccountValidation.createAccountPageValidation();  
				}
			}
		}
	}
	
	public static void createAccountLink() throws Exception {
		createAccPage();
	}
	

	//all empty 
	public static void withoutEntringdetailsandcrateAccount() throws Exception {
		createAccPage();
		Actionsss.CombinedClick(CAP.getCreateAccountButton());
		Thread.sleep(2000);
		CreateAccountValidation.validateAllErrors();
	}
		
	public static void enterFName() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(2000);
	    CreateAccountValidation.validateFNameAllErrors();
		
	}
	
	public static void enter_FName_LName() throws Exception {
		createAccPage();
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validateLNameAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone() throws Exception{
		createAccPage();
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validatePhoneAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone_Email() throws Exception{
		createAccPage();
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getEmail(), TD.Email_CA_IP_Data,TD.Email_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validateEmailAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone_Email_CEmail() throws Exception{
		createAccPage();
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getEmail(), TD.Email_CA_IP_Data,TD.Email_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data,TD.ConfirmEmail_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validateCEmailAllErrors();
		
	}
	
	public static void enter_FName_LName_Phone_Email_CEmail_PWD()throws Exception {
		createAccPage();
		Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getEmail(), TD.Email_CA_IP_Data,TD.Email_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data,TD.ConfirmEmail_CA_IP_FieldName);
	    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_CA_IP_FieldName);
	    Thread.sleep(2000);
	    Actionsss.CombinedClick(CAP.getCreateAccountButton());
	    Thread.sleep(5000);
	    CreateAccountValidation.validatePWdAllErrors();
		
	}
	
		//invalid phone number
		public static void enteralldeailsandInvalidPhoneNumber() throws Exception {
			createAccPage();
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.Invalidphone_CA_IP_Data,TD.phone_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.phoneNumber();
		}
		
		//invalid email
		public static void enteralldeailsandInvalidEmail() throws Exception {
			createAccPage();
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.InvalidEamil_CA_IP_Data,TD.Email_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.InvalidEamil_CA_IP_Data,TD.ConfirmEmail_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.emailFormat();
		}
		
		
		//already exists mail error
		public static void enteralldeailsandAlreadyExistsEmail() throws Exception {
			createAccPage();
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.alreadyExistsMail();
		}
		
		//Miss match mail error
		public static void enteralldeailsandMissMatchEmail() throws Exception {
			createAccPage();
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.DifferentEmail_CA_IP_Data,TD.Email_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.MissmatchMail();
		}
		
		//password miss mactch
		public static void enteralldeailsandPasswordMissMatchEmail() throws Exception {
			createAccPage();
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.DifferentEmail_CA_IP_Data,TD.ConfirmEmail_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.DifferentPWD_CA_IP_Data,TD.ConfirmPassword_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.MissPWDMail();
		}
		
		//password strength
		public static void enteralldeailsandPasswordWeak() throws Exception {
			createAccPage();
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,TD.FirstName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.Email_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.AlreadyExistsEmail_CA_IP_Data,TD.ConfirmEmail_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.WeakPWD_CA_IP_Data,TD.Password_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.WeakPWD_CA_IP_Data,TD.ConfirmPassword_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(2000);
		    CreateAccountValidation.passwordStrengthError();
		}
		
		//create account with valid detals
		public static void enterValidDetails() throws Exception {
			createAccPage();
			Actionsss.sendKeys(CAP.getFirstName(), TD.FirstName_CA_IP_Data,  TD.FirstName_CA_IP_Data + TD.FirstName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getLastName(), TD.LastName_CA_IP_Data,TD.LastName_CA_IP_Data + TD.LastName_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_Data  + TD.phone_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.Email_CA_IP_Data,TD.Email_CA_IP_Data + TD.Email_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data, TD.ConfirmEmail_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(5000);
		    CreateAccountValidation.accountPageTitle();
		}
		
		
		//create account with valid detals
		public static void createAccountWithSpecialCharacters() throws Exception {
			createAccPage();
			Actionsss.sendKeys(CAP.getFirstName(), (Keys.chord(Keys.SHIFT, "@")),TD.FirstName_CA_IP_FieldNameForSpecialCharacters);	
			Actionsss.sendKeys(CAP.getLastName(), (Keys.chord(Keys.SHIFT, "@")),TD.LastName_CA_IP_FieldNameForSpecialCharacters);			    
		    Actionsss.sendKeys(CAP.getPhone(), TD.phone_CA_IP_Data,TD.phone_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getEmail(), TD.Email_CA_IP_Data_SpecialChar,TD.Email_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmEmail(), TD.ConfirmEmail_CA_IP_Data_SpecialChar,TD.ConfirmEmail_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getPassword(), TD.Password_CA_IP_Data,TD.Password_CA_IP_FieldName);
		    Actionsss.sendKeys(CAP.getConfirmPassword(), TD.ConfirmPassword_CA_IP_Data,TD.ConfirmPassword_CA_IP_FieldName);
		    Thread.sleep(2000);
		    Actionsss.CombinedClick(CAP.getCreateAccountButton());
		    Thread.sleep(5000);
		    CreateAccountValidation.accountPageTitle();
		}

}
