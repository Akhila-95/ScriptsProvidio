package tasks;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.MyAccountPage;
import validations.MyAccountValidations;

public class MyAccountPageEditProileTasks extends baseClass{
	
	private static MyAccountPage MAC= new MyAccountPage(driver);
	private static TestData TD = new TestData();

	
	//edit profile
		public static void editporfileView() throws Exception {
			if(Actionsss.countofElements(MAC.geteditProfileHeader())) {
				logger.info("Eidt page is already loaded");
			}else {
				MyAccountPageTasks.myAccoutView();
				Actionsss.CombinedClick(MAC.getElementeditProfileLink());
				MyAccountValidations.verifyeditprofile();
			}
		}
		
		public static void homelink() throws Exception {
			editporfileView();
			Actionsss.CombinedClick(MAC.gethomeLink());
			MyAccountValidations.verifyClickOnLogo();
		}
		
		public static void myAccountedit() throws Exception {
			editporfileView();
			Actionsss.CombinedClick(MAC.getmyaccountlink());
			MyAccountValidations.verifyuserClickedonMyAccount();
		}
		
		public static void cancellink() throws Exception {
			editporfileView();
			Actionsss.CombinedClick(MAC.geteditcancelbutton());
			MyAccountValidations.verifyuserClickedonMyAccount();
		}
		
		public static void backtomyaccountlink() throws Exception {
			editporfileView();
			Actionsss.CombinedClick(MAC.geteditbacktomyaccount());
			MyAccountValidations.verifyuserClickedonMyAccount();
		}
		
		public static void editPorfileEmptyForm() throws Exception {
			editporfileView();
			Actionsss.clearText(MAC.geteditfirstName());
			Thread.sleep(1000);
	        Actionsss.clearText(MAC.geteditlastName());
	        Thread.sleep(1000);
	        Actionsss.clearText(MAC.geteditphone());
	        Thread.sleep(1000);
	        Actionsss.clearText(MAC.geteditemail());
	        Thread.sleep(1000);
	        Actionsss.clearText(MAC.geteditconformemail());
	        Thread.sleep(1000);
	        Actionsss.clearText(MAC.geteditpassword());
	        Thread.sleep(1000);
	        Actionsss.CombinedClick(MAC.geteditsavebutton());
	        Thread.sleep(2000);
	        MyAccountValidations.verifyeditprofileemptyfields();
		}
		
		public static void invalidPhone() throws Exception {
			editporfileView();
			Actionsss.sendKeys(MAC.geteditfirstName(), TD.FirstName_MAP_EditProfile_IP_Data,TD.FirstName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditlastName(), TD.LastName_MAP_EditProfile_IP_Data,TD.LastName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditphone(), TD.Invalid_phone_MAP_EditProfile_IP_Data,TD.phone_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditemail(), TD.Valid_Email_MAP_EditProfile_Data,TD.Email_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditconformemail(), TD.Valid_Email_MAP_EditProfile_Data,TD.ConfirmEmail_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditpassword(), TD.Different_PWD_MAP_EditProfile_Data,TD.Password_MAP_EditProfile_IP_FieldName);
		    Thread.sleep(1000);
	        Actionsss.CombinedClick(MAC.geteditsavebutton());
	        Thread.sleep(2000);
	        MyAccountValidations.verifyeditprofileInvalidPhone();
		}
		
		public static void invalidEmail() throws Exception {
			editporfileView();
			Actionsss.sendKeys(MAC.geteditfirstName(), TD.FirstName_MAP_EditProfile_IP_Data,TD.FirstName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditlastName(), TD.LastName_MAP_EditProfile_IP_Data,TD.LastName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditphone(), TD.phone_MAP_EditProfile_IP_Data,TD.phone_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditemail(), TD.Invalid_Email_MAP_EditProfile_IP_Data,TD.Email_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditconformemail(), TD.Valid_Email_MAP_EditProfile_Data,TD.ConfirmEmail_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditpassword(), TD.Different_PWD_MAP_EditProfile_Data,TD.Password_MAP_EditProfile_IP_FieldName);
		    Thread.sleep(1000);
	        Actionsss.CombinedClick(MAC.geteditsavebutton());
	        Thread.sleep(2000);
	        MyAccountValidations.verifyeditprofileInvalidEmail();
		}
		
		public static void emailMissMatch() throws Exception {
			editporfileView();
			Actionsss.sendKeys(MAC.geteditfirstName(), TD.FirstName_MAP_EditProfile_IP_Data,TD.FirstName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditlastName(), TD.LastName_MAP_EditProfile_IP_Data,TD.LastName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditphone(), TD.phone_MAP_EditProfile_IP_Data,TD.phone_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditemail(), TD.Valid_Email_MAP_EditProfile_Data,TD.Email_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditconformemail(), TD.Different_Email_MAP_EditProfile_IP_Data,TD.ConfirmEmail_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditpassword(), TD.Different_PWD_MAP_EditProfile_Data,TD.Password_MAP_EditProfile_IP_FieldName);
		    Thread.sleep(1000);
	        Actionsss.CombinedClick(MAC.geteditsavebutton());
	        Thread.sleep(2000);
	        MyAccountValidations.MissmatchMail();
	  }
		
		public static void pwdmissmatch() throws Exception {
			editporfileView();
			Actionsss.sendKeys(MAC.geteditfirstName(), TD.FirstName_MAP_EditProfile_IP_Data,TD.FirstName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditlastName(), TD.LastName_MAP_EditProfile_IP_Data,TD.LastName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditphone(), TD.phone_MAP_EditProfile_IP_Data,TD.phone_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditemail(), TD.Valid_Email_MAP_EditProfile_Data,TD.Email_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditconformemail(), TD.Valid_Email_MAP_EditProfile_Data,TD.ConfirmEmail_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditpassword(), TD.Different_PWD_MAP_EditProfile_Data,TD.Password_MAP_EditProfile_IP_FieldName);
		    Thread.sleep(1000);
	        Actionsss.CombinedClick(MAC.geteditsavebutton());
	        Thread.sleep(2000);
	        MyAccountValidations.MissPWDEMail();
	  }
		
		public static void validDetails() throws Exception {
			editporfileView();
			Actionsss.sendKeys(MAC.geteditfirstName(), TD.FirstName_MAP_EditProfile_IP_Data,TD.FirstName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditlastName(), TD.LastName_MAP_EditProfile_IP_Data,TD.LastName_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditphone(), TD.phone_MAP_EditProfile_IP_Data,TD.phone_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditemail(), TD.Valid_Email_MAP_EditProfile_Data,TD.Email_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditconformemail(), TD.Valid_Email_MAP_EditProfile_Data,TD.ConfirmEmail_MAP_EditProfile_IP_FieldName);
		    Actionsss.sendKeys(MAC.geteditpassword(), TD.Valid_PWD_MAP_EditProfile_Data,TD.Password_MAP_EditProfile_IP_FieldName);
		    Thread.sleep(1000);
	        Actionsss.CombinedClick(MAC.geteditsavebutton());
	        Thread.sleep(2000);
	        MyAccountValidations.verifyuserClickedonMyAccount();
	  }

}
