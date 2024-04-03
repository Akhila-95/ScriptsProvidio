package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.MyAccountPage;
import validations.MyAccountValidations;

public class MyAccountPageAddressBookTasks extends baseClass{
	private static MyAccountPage MAC= new MyAccountPage(driver);
	
	//address book view 
		public static void addressBookView() throws Exception {
			if(Actionsss.countofElements(MAC.getaddressbookHeader())) {
				logger.info("address book page is already loaded");
			}else {
				MyAccountPageTasks.myAccoutView();
				Actionsss.CombinedClick(MAC.getElementviewAddressBookLink());
				MyAccountValidations.verifyAddressbookpage();
			}
		}
		
		public static void addressbookhomelink() throws Exception {
			addressBookView();
			Actionsss.CombinedClick(MAC.gethomeLink());
			Thread.sleep(2000);
			MyAccountValidations.verifyClickOnLogo();
		}
		
		public static void addressbookedit() throws Exception {
			addressBookView();
			Actionsss.CombinedClick(MAC.getmyaccountlink());
			Thread.sleep(2000);
			MyAccountValidations.verifyuserClickedonMyAccount();
		}

		
		public static void addressbookbacktomyaccountlink() throws Exception {
			addressBookView();
			Actionsss.CombinedClick(MAC.geteditbacktomyaccount());
			Thread.sleep(2000);;
			MyAccountValidations.verifyuserClickedonMyAccount();
		}
		
		
		public static void removebutton() throws Exception {
			addressBookView();
			Actionsss.randomElementFromListScrollIntoView(MAC.getremovebutton());
			Thread.sleep(2000);
			Actionsss.CombinedClick(MAC.getokbuttoncancelButton());
			MyAccountValidations.addressDeletebutton();
		}
		
		public static void removeandCaceldeletebutton() throws Exception {
			addressBookView();
			Actionsss.randomElementFromListScrollIntoView(MAC.getremovebutton());
			Thread.sleep(2000);
			Actionsss.CombinedClick(MAC.getremovebuttoncancelButton());
			MyAccountValidations.addressDeletebutton();
		}

		
		public static void makedefault() throws Exception {
			addressBookView();
			Actionsss.randomElementFromListScrollIntoView(MAC.getmakeAsDefaultLink());
			Thread.sleep(2000);;
			MyAccountValidations.makeasDefault();
		}
		
		
		

}
