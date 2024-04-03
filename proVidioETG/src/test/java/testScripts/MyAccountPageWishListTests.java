package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageWishListTasks;
import tasks.WishlistPageTasks;

public class MyAccountPageWishListTests extends baseClass{
	
	@Test(groups = {"regression"})
    public void VerifyingReoveFuctionalityOnWishListInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.removebtninMyAccount();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingViewLinkOnWishListInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.WishListviewLink();
    }

	@Test(groups = {"regression"})
    public void VerifyingFacebookLinkOnWishlistInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.facebooklink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingTwitterLinkOnWishlistInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.twitterklink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingPintersetsLinkOnWishlistInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.pintresterlink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingGmailLinkOnWishlistInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.gmaillink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingCopyLinkOnWishlistInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.copylink();
    }
	
	
	@Test(groups = {"regression"})
    public void VerifyingHomeLinkOnWishlistPageInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.wishlisthomelink();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingMyAccountLinkOnWishlistPageInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.wishlistmyaccount();
    }
	
	@Test(groups = {"regression"})
    public void VerifyingBackToMyAccountLinkOnWishlistPageInMyAccountPage() throws Exception {
		MyAccountPageWishListTasks.wishlistbacktomyaccountlink();
    }
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//custom input
	@Test(groups = {"regression"})
    public static void VerifyingCustomInputOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.customInput();
    }
	
	//remove product
	@Test(groups = {"regression"})
    public static void VerifyingRemoveFromWishListOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.removeProduct();
    }
	
	//edit link
	@Test(groups = {"regression"})
    public static void VerifyingEditLinkOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.editLink();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingEditClosebuttonOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.editCloseBtn();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingEditpopupAttributesOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.editAttributes();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingEditpopupUpdateButtonOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.updatebutton();
    }
	
	//attributes selection
	@Test(groups = {"regression"})
    public static void VerifyingselectAttributesLinkOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.selectAttributesLink();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingselectAttributesClosebuttonOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.selectAttributesCloseBtn();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingselectAttributespopupAttributesOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.selectAttributesAttributes();
    }
	
	@Test(groups = {"regression"})
    public static void VerifyingselectAttributespopupUpdateButtonOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.selectAttributesupdatebutton();
    }
	
	//addtocart
	@Test(groups = {"regression"})
    public static void VerifyingAddtocartButtonOnWishListPageInMyAccountPage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MyAccountPageWishListTasks.AddtoCartbutton();
    }
	
}
