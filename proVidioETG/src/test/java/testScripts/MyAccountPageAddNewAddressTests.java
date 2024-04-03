package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageAddNewAddressTasks;

public class MyAccountPageAddNewAddressTests extends baseClass{
	
	//add new address form my account page
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPageViewInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.addnewaddressPageView();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPageAddressBookLInkInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.addNewAddressAddressBooklink();
    }
	
	//home
	@Test(groups = {"regression"})
    public void VerifingAddNewAddressPageHomeInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.addNewAddresshomelink();
    }
	
	@Test(groups = {"regression"})
    public void VerifingAddNewAddressPageMyAccountlinkInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.addNewAddressmyaccount();
    }
	
	@Test(groups = {"regression"})
    public void VerifingAddNewAddressPageCancelInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.addNewAddresscancellink();
    }
	
	@Test(groups = {"regression"})
    public void VerifingAddNewAddressPageBackToMyAccountInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.addNewAddressbacktomyaccountlink();
    }
	
	
	//Add new address form from address book
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPageEmptyFormInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.emptyform();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPageAddressTitleErrorInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.firstNameError();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPageFirstNameErrorInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.firstNameError();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPageLastNameErrorInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.lastNameError();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPageAddress1InMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.addressError();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPagePhoneErrorInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.phoneNumberError();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPageAddressTitleAlreadyExistsErrorInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.addressTitleAlreadyExits();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingAddNewAddressPageValidDetailsInMyAccountPage() throws Exception {
        
		MyAccountPageAddNewAddressTasks.validDetals();
    }

}
