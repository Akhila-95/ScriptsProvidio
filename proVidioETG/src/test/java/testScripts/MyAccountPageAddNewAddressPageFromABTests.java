package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageAddNewAddressPageFromABTasks;

public class MyAccountPageAddNewAddressPageFromABTests extends baseClass{
	
	//add new address page form the address book
		@Test(groups = {"regression"})
	    public void VerifyingAddNewAddressPageViewFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.addNewAddressPageView();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingAddressBookLinkInAddNewAddressPageFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.addNewAddressAddressBooklink();
	    }
		
		//home
		@Test(groups = {"regression"})
	    public void VerifingHomePageLinkAddNewAddressPageFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.addNewAddresshomelink();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingMyAccountLinkInAddNewAddressPageFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.addNewAddressmyaccount();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingCancelButtonAddNewAddressPageFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.addNewAddresscancellink();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifingBackToMyAccountAddNewAddressPageFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.addNewAddressbacktomyaccountlink();
	    }
		
		
		//Add new address form from address book
		@Test(groups = {"regression"})
	    public void VerifyingAddNewAddressPageEmptyFormFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.emptyform();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingAddNewAddressPageAddressTitleErrorFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.firstNameError();
	    }
		
		
		@Test(groups = {"regression"})
	    public void VerifyingAddNewAddressPageFirstNameErrorFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.firstNameError();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingAddNewAddressPageLastNameErrorFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.lastNameError();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingAddNewAddressPageAddress1FromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.addressError();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingAddNewAddressPagePhoneErrorFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.phoneNumberError();
	    }
		
		@Test(groups = {"regression"})
	    public void VerifyingAddNewAddressPageAddressTitleAlreadyExistsErrorFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.addressTitleAlreadyExits();
	    }
		
		
		@Test(groups = {"regression"})
	    public void VerifyingAddNewAddressPageValidDetailsFromAddressBookInMyAccountPage() throws Exception {
	        
			MyAccountPageAddNewAddressPageFromABTasks.validDetals();
	    }
		

}
