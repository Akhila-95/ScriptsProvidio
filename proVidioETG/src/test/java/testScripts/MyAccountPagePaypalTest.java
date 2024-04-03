package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPagePaypalTasks;

public class MyAccountPagePaypalTest  extends baseClass{

	
	
	@Test
	public static void VerifyingTheDisplayOfPaypalSectionAndAddNewButton_Etc_InMyAccountInBrainTree() throws Exception {
		MyAccountPagePaypalTasks.displayOfPaypalSectionAddNewButtonInMyAccount();
	}
	
	@Test
	public static void VerifyingTheAddingOfPaypalInMyAccountInBrainTree() throws Exception {
		MyAccountPagePaypalTasks.addPaypalInMyAccount();
	}
	
	@Test
	public static void VerifyingTheRemovalOfPaypalAccountInMyAccountInBrainTree() throws Exception {
		MyAccountPagePaypalTasks.removePaypalAccountIfAdded();
	}
	
	@Test
	public static void VerifyingTheMakeDefaultPaymentOfPaypalAccountInMyAccountInBrainTree() throws Exception {
		MyAccountPagePaypalTasks.makeDefaultPayment();
	}
}
