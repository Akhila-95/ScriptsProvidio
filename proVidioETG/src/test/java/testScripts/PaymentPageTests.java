package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.PaymentPageTasks;

public class PaymentPageTests extends baseClass{

	@Test
	public  void VerifyingTheCustomerInfoInPaymntPage() throws InterruptedException, Exception {
		PaymentPageTasks.getCutomerInfoInPaymentPage();
	}
	
	@Test
	public void VerifyingPaginationOfProductsInPaymentPage() throws Exception {
		PaymentPageTasks.paginationOfProductsInPaymentPage();
	}
	
	

	@Test// 
	public void VerifyingOrderSummaryDisplayInPaymentPage() throws Exception {
		PaymentPageTasks.getOrderSummary();
	}
	
	@Test// 
	public void VerifyingPaymentInfoDisplayInPaymentPage() throws Exception {
		PaymentPageTasks.getPaymentForm();
	}
	
	@Test// 
	public void VerifyingEtgLogoDisplayInPaymentPage() throws Exception {
		PaymentPageTasks.getEtgLogo();
	}
	
	@Test// 
	public void VerifyingCharacterLimitInBillingAddressForAddress1And2InPaymentPage() throws Exception {
		PaymentPageTasks.characterLimitInBillingAddress();
	}
	
	@Test// 
	public void VerifyingEtgLogoClickInPaymentPage() throws Exception {
		PaymentPageTasks.clickLogo();
	}
	
	@Test// 
	public void VerifyingBackToCartInPaymentPage() throws Exception {
		PaymentPageTasks.getBackToCart();
	}
	
	@Test// 
	public void VerifyingShippigDetailsInfoInPaymentPage() throws Exception {
		PaymentPageTasks.getshippingInfo();
	}
	
	@Test
	public static void VerifyingGiftMessageInPaymentPage() throws Exception {
		PaymentPageTasks.editGiftMessageInCop2();
	}
	@Test
	public static void VerifyingEditCustomerInfoFromPaymentPage() throws Exception {
		PaymentPageTasks.editCustomerInfoFromCop3();
	}
	
	@Test
	public static void VerifyingEditShippingAddressFromPaymentPage() throws Exception {
		PaymentPageTasks.editShippindAddressFromPaymentPage();
	}
	
	
	@Test
	public static void VerifyingUpdateBillingAddressInPaymentPage() throws Exception {
		PaymentPageTasks.updateBillingAddress();
	}
	
	@Test
	public static void VerifyingAddNewBillingAddressInPaymentPage() throws Exception {
		PaymentPageTasks.addNewBillingAddress();
	}
	
	
	@Test
	public static void VerifyingBillingPhoneNumberError() throws Exception {
		PaymentPageTasks.billingPhoneNumber();
	}
	
	//payment
    @Test
    public void VerifyingAllTheErrorsInCreditCard() throws Exception {
        
    	PaymentPageTasks.allErrorsInCreditCard();
    }
    
    @Test
    public void VerifyingCvvAndExpErrorInCreditCard() throws Exception {
        
    	PaymentPageTasks.CreditCardCvvAndExpErrorMessage();
    }
    
    @Test
    public void VerifyingCvvErrorInCreditCard() throws Exception {
        
    	PaymentPageTasks.CreditCardCvvErrorMessage();
    }
    
    @Test
    public void VerifyingCreditcardNumberInValidError() throws Exception {
        
    	PaymentPageTasks.creditcardNumberInValidError() ;
    }
    
    @Test
    public void VerifyingCreditCardExpDateInValid() throws Exception {
        
    	PaymentPageTasks.creditCardExpDateInValid();
    }
    
    @Test
    public void VerifyingCreditCardNumberInCompleteError() throws Exception {
        
    	PaymentPageTasks.creditCardNumberInCompleteError();
    }
    
    @Test
    public void VerifyingCreditCardInCompleteExpYearError() throws Exception {
        
    	PaymentPageTasks.creditCardInCompleteExpYearError();
    }
    
    @Test
    public void VerifyingCreditCardInCompleteCvvError() throws Exception {
        
    	PaymentPageTasks.creditCardInCompleteCvvError();
    }
    
    @Test
    public void VerifyingCreditcardWithValidDetails() throws Exception {
        
    	PaymentPageTasks.creditCardWithValidDetails();
    }
    
    
    @Test
    public void VerifyingAddnewCreditCardInPaymentPage() throws Exception {       
    	//PaymentPageTasks.addNewCreditCard();
    }
    
    
    //-------------------Reg user -------------------------------

    @Test
    public void VerifyingRegUserUpdateShippingAddressFromPaymentPageandPlaceOrder() throws Exception {       
    	PaymentPageTasks.ShippingUpdateforReg();
    }
    
    @Test
    public void VerifyingRegUserAddNewShippingAddressFromPaymentPagePlaceOrder() throws Exception {       
    	PaymentPageTasks.ShippingAddNewAddressforReg();
    }
    
    @Test
    public void VerifyingRegUserSelectExistingShippingAddressFromPaymentPagePlaceOrder() throws Exception {       
    	PaymentPageTasks.ShippingSelectaAddressforReg();
    }
    
    @Test
    public void VerifyingRegUserSelectExistingBillingAddressFromPaymentPage() throws Exception {       
    	PaymentPageTasks.BillingSelectaAddressforReg();
    }
    
}
