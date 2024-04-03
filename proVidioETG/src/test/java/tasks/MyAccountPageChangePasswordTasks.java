package tasks;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.MyAccountPage;
import validations.MyAccountValidations;

public class MyAccountPageChangePasswordTasks extends baseClass{
	
	private static MyAccountPage MAC= new MyAccountPage(driver);
	private static TestData TD = new TestData();

	//change passwrod tasks
	public static void changePWDpageView() throws Exception {
		if(Actionsss.countofElements(MAC.getchangePWDHeader())) {
			logger.info("Change password page is already loaded");
		}else {
			MyAccountPageTasks.myAccoutView();
			Actionsss.CombinedClick(MAC.getElementchangePasswordLink());
			MyAccountValidations.verifychangepasswordpage();
		}
	}
	
	public static void changePwdhomelink() throws Exception {
		changePWDpageView();
		Actionsss.CombinedClick(MAC.gethomeLink());
		MyAccountValidations.verifyClickOnLogo();
	}
	
	public static void changePwdedit() throws Exception {
		changePWDpageView();
		Actionsss.CombinedClick(MAC.getmyaccountlink());
		MyAccountValidations.verifyuserClickedonMyAccount();
	}
	
	public static void changePwdcancellink() throws Exception {
		changePWDpageView();
		Actionsss.CombinedClick(MAC.geteditcancelbutton());
		MyAccountValidations.verifyuserClickedonMyAccount();
	}
	
	public static void changePwdbacktomyaccountlink() throws Exception {
		changePWDpageView();
		Actionsss.CombinedClick(MAC.geteditbacktomyaccount());
		MyAccountValidations.verifyuserClickedonMyAccount();
	}
	
	public static void emptyForm() throws Exception {
		changePWDpageView();
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		MyAccountValidations.verifychagepasswordemptyfields();
	}
	
	public static void passworddoesnotMatchwithCurrentUser() throws Exception {
		changePWDpageView();
		Actionsss.sendKeys(MAC.setcurrentPassword(), TD.Different_CurrentPWD_MAP_IP_Data,TD.CurrentPWD_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.setnewPassword(), TD.Valid_NewCurrentPWD_MAP_IP_Data,TD.NewCurrentPWD_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.setnewPasswordConfirm(), TD.Valid_ConformCurrentPWD_MAP_IP_Data,TD.ConformCurrentPWD_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		 Thread.sleep(2000);
		MyAccountValidations.MissPWDeMailchange();
	}
	
	public static void changepwdmissmatch() throws Exception {
		changePWDpageView();
		Actionsss.sendKeys(MAC.setcurrentPassword(), TD.Valid_NewCurrentPWD_MAP_IP_Data,TD.CurrentPWD_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.setnewPassword(), TD.Different_CurrentPWD_MAP_IP_Data,TD.NewCurrentPWD_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.setnewPasswordConfirm(), TD.Valid_ConformCurrentPWD_MAP_IP_Data,TD.ConformCurrentPWD_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		 Thread.sleep(2000);
		MyAccountValidations.missmatchpwd();
	}
	
	public static void validPassword() throws Exception {
		changePWDpageView();
		Actionsss.sendKeys(MAC.setcurrentPassword(), TD.Valid_NewCurrentPWD_MAP_IP_Data,TD.CurrentPWD_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.setnewPassword(), TD.Valid_NewCurrentPWD_MAP_IP_Data,TD.NewCurrentPWD_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.setnewPasswordConfirm(), TD.Valid_ConformCurrentPWD_MAP_IP_Data,TD.ConformCurrentPWD_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		 Thread.sleep(2000);
		MyAccountValidations.verifyuserClickedonMyAccount();
	}


}
