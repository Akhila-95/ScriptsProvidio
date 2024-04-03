package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.PaymentPageGiftCerificationTasks;

public class PaymentPageGiftCerificationTests extends baseClass{
	
	@Test
    public void VerifyingEmptyGiftInPaymentPage() throws Exception {       
    	PaymentPageGiftCerificationTasks.emptyGiftCardApply();
    }
    
    
    @Test 
    public void VerifyingInvalidGcErrorMsgInPaymentPage() throws Exception {       
    	PaymentPageGiftCerificationTasks.InvalidGcCode();
    }
    
    
    @Test 
    public void VerifyingInsufficientGcInPaymentPage() throws Exception {       
    	PaymentPageGiftCerificationTasks.insufficientGcCode();
    }
    
    @Test 
    public void VerifyingDifferentGcUserInPaymentPage() throws Exception {       
    	PaymentPageGiftCerificationTasks.gcBelongsToDifferentCustomer();
    }
    
    @Test 
    public void VerifyingRemoveGcInPaymentPage() throws Exception {       
    	PaymentPageGiftCerificationTasks.removeAppliedGc();
    }
    
    
    @Test
    public void VerifyingGiftCardsCheckBalanceEmptyInputInPaymentPage() throws Exception {
        
    	PaymentPageGiftCerificationTasks.emptycheckBalance();
    }
	
	
	@Test
    public void VerifyingGiftCardsCheckBalanceInvalidInputInPaymentPage() throws Exception {
        
		PaymentPageGiftCerificationTasks.invalidcheckBalance();
    }
	
	
	@Test
    public void VerifyingGiftCardsCheckBalanceInsufficientInputInPaymentPage() throws Exception {
        
		PaymentPageGiftCerificationTasks.insufficientcheckBalance();
    }

	@Test
    public void VerifyingGiftCardsCheckBalanceValidInputInPaymentPage() throws Exception {
        
		PaymentPageGiftCerificationTasks.validcheckBalance();
    }
    
    @Test 
    public void VerifyingSuccesMessageForValidGcApplied() throws Exception {       
    	PaymentPageGiftCerificationTasks.applyValidGc();
    }
    


}
