package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.HomePageTasks;
import tasks.MiniCartPageTasks;

public class MiniCartPageTests extends baseClass{

	@Test(groups = {"smoke", "regression"})
    public void VerifingViewCartBtnClickInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.ViewCartbtnClick();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifingCheckOutBtnClickInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.checkOutBtnClick();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifingCallToActionOfPaypalInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.callToActionOfPaypal();
    }
	
	@Test(groups = {"regression"})
    public void VerifingRemoveBtnInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.removeFromMinicart();
    }
	
	@Test(groups = {"regression"})
    public void VerifingCustomInputInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.CustomInput();
    }
	
	@Test(groups = {"regression"})
    public void VerifingCloseBtnInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.closeMiniCart();
    }
	
	@Test(groups = {"regression"})
    public void VerifingEstimatedCostInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.estimatedCostInMiniCart();
    }
	
	@Test(groups = {"regression"})
    public void VerifingRemovalOfGiftCertificateFromInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.removeGiftCertificateFromMiniCart();
    }
	
}
