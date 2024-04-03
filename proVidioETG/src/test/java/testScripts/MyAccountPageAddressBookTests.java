package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageAddressBookTasks;

public class MyAccountPageAddressBookTests extends baseClass{
	
	//view address book page test cases
	@Test(groups = {"regression"})
    public void VerifyingViewAddressBookInMyAccountPage() throws Exception {
        
		MyAccountPageAddressBookTasks.addressBookView();
    }
	
	//home
	@Test(groups = {"regression"})
    public void VerifingAddressBookHomeInMyAccountPage() throws Exception {
        
		MyAccountPageAddressBookTasks.addressbookhomelink();
    }
	
	@Test(groups = {"regression"})
    public void VerifingAddressBookMyAccountlinkInMyAccountPage() throws Exception {
        
		MyAccountPageAddressBookTasks.addressbookedit();
    }
	
	@Test(groups = {"regression"})
    public void VerifingAddressBookBackToMyAccountInMyAccountPage() throws Exception {
        
		MyAccountPageAddressBookTasks.addressbookbacktomyaccountlink();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingRemoveAddressCancelButtonEditAddressPageInMyAccountPage() throws Exception {
        
		MyAccountPageAddressBookTasks.removeandCaceldeletebutton();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingDeleteOneAddressformAddressBookPageInMyAccountPage() throws Exception {
        
		MyAccountPageAddressBookTasks.removebutton();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingMakeOneAddressAsaDefaultAddressInAddressBookPageInMyAccountPage() throws Exception {
        
		MyAccountPageAddressBookTasks.makedefault();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingEditAddressPageInMyAccountPage() throws Exception {
        
		MyAccountPageAddressBookTasks.addressbookedit();
    }

}
