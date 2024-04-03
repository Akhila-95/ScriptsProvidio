package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageCreditCardTasks;

public class MyAccountPageCreditCardTests extends baseClass{
	
	//----------------------Brain Tree-------------------------------------------------
	
	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.addNewBrainTree();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardCancelButtonInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cancelButton();
    }

	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardEmptyFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.emptyForm();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardEnterNameFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cardNameEnter();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardEnterNameandNumberFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.nameCardNumberEnter();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardEnterNameNumberandCvvFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.nameCardNumberaddCvvEnter();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardValidDetailsFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.validCreditCardDetails();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardAlreadyHaveCreditCardInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cardAlreadyExists();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardRemoveCreditCardInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.removeCard();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingBrainTreeCreditCardMakeAsaDefaultCreditCardInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.randomselectionofmakeAsadefault();
    }
	
	//------------------------------------Stripe-------------------------------------------------------------------------
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardFormPageInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.creditCardStripeFormView();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardFormPageCancelBtnInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cancelbtn();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardFormPageHomeLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.stripeHomelink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardFormPageMyAccountLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.stripeMyAccountlink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardFormPagePaymentLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.stripePaymentlink();
    }

	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardEmptyFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.stripeEmptyForm();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardInvalidCardNumberInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.invalidCard();
    }
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardExpDateErrorInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.expdate();
    }
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardCVVErrorInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cvv();
    }
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardPostalCodeErrorInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.zip();
    }
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardValidDeatilsAndSubmitFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.validDetails();
    }
	
	
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardPaymentlPageHomeLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.stripepaymentsHomelink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardPaymentlPageHomeMyAccountLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.stripepaymentMyAccountlink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardPaymentlPageBackToMyAccountLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.stripepaymentBacktomyaccountlink();
    }

	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardPaymentlPageRemovePOPUPCancelbtnLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.removeandCaceldeletebutton();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardPaymentlPageRemovePOPUPOKbtnLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.removebutton();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingStripeCreditCardViewLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.viewlink();
    }
	
	//------------------------- Cybersourece -------------------------------------------------------
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardFormPageInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.creditCardCyberSourceFormView();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardFormPageCancelBtnInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cancelbtncybersource();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardFormPageHomeLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cyberSourceHomelink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardFormPageMyAccountLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cyberSourceMyAccountlink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardFormPagePaymentLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cyberSourcePaymentlink();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardEmptyFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cyberSourceEmptyForm();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardNameInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cyberSourceNameForm();
    }
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardNumberInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.cyberSourceNumberForm();
    }
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardExpDateInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.expdatecyberSource();
    }

	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardValidDeatilsAndSubmitFormInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.validDetailscyberSource();
    }

	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardInvalidCardNumberInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.invalidcyberSourceCard();
    }
	
	
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardPaymentlPageHomeLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.CyberSourcepaymentsHomelink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardPaymentlPageHomeMyAccountLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.CyberSourcepaymentMyAccountlink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardPaymentlPageBackToMyAccountLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.CyberSourcepaymentBacktomyaccountlink();
    }

	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardPaymentlPageRemovePOPUPCancelbtnLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.CyberSourceremoveandCaceldeletebutton();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardPaymentlPageRemovePOPUPOKbtnLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.CyberSourceremovebutton();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCyberSourceCreditCardViewLinkInkInMyAccountPage() throws Exception {
		MyAccountPageCreditCardTasks.viewCyberSourcelink();
    }
}
