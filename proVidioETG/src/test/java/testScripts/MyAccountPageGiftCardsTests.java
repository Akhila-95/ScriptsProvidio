package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageGiftCardsTasks;

public class MyAccountPageGiftCardsTests extends baseClass{
	
	@Test(groups = {"regression"})
    public void VerifyingGiftCardsBlockViewInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.giftCardView();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingGiftCardsEmptyInputInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.emptyaddtoAccount();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingGiftCardsInvalidInputInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.invalidaddtoAccount();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingGiftCardsInsufficientInputInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.insufficientaddtoAccount();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingGiftCardBelongstoDifferentCustomerInputInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.differentUseraddtoAccount();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingGiftCardsValidInputInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.validaddtoAccount();
    }
	
	//--------------check balance -------------------------------------
	

	@Test(groups = {"regression"})
    public void VerifyingGiftCardsCheckBalanceEmptyInputInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.emptycheckBalance();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingGiftCardsCheckBalanceInvalidInputInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.invalidcheckBalance();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingGiftCardsCheckBalanceInsufficientInputInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.insufficientcheckBalance();
    }

	@Test(groups = {"regression"})
    public void VerifyingGiftCardsCheckBalanceValidInputInMyAccountPage() throws Exception {
        
		MyAccountPageGiftCardsTasks.validcheckBalance();
    }
}
