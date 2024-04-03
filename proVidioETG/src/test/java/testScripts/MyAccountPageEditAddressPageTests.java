package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageEditAddressPageTasks;

public class MyAccountPageEditAddressPageTests extends baseClass{

	//edit address page from the address book
	@Test(groups = {"regression"})
    public void VerifyingEditAddressAddressBookLInkInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.editAddressAddressBooklink();
    }
	
	//home
	@Test(groups = {"regression"})
    public void VerifingeditAddressEditAddressHomeInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.editAddresshomelink();
    }
	
	@Test(groups = {"regression"})
    public void VerifingeditAddressEditAddressMyAccountlinkInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.editAddressedit();
    }
	
	@Test(groups = {"regression"})
    public void VerifingeditAddressEditAddressCancelInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.editAddresscancellink();
    }
	
	@Test(groups = {"regression"})
    public void VerifingeditAddressEditAddressBackToMyAccountInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.editAddressbacktomyaccountlink();
    }
	
	
	//edit address form from the address book
	@Test(groups = {"regression"})
    public void VerifyingEditAddressPageEmptyFormInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.emptyform();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingEditAddressPageFirstNameErrorInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.firstNameError();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingEditAddressPageLastNameErrorInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.lastNameError();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingEditAddressPageAddress1InMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.addressError();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingEditAddressPagePhoneErrorInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.phoneNumberError();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingEditAddressPageValidDetailsInMyAccountPage() throws Exception {
        
		MyAccountPageEditAddressPageTasks.validDetals();
    }
}
