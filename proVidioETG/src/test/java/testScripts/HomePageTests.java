package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.HomePageTasks;

public class HomePageTests extends baseClass{
	
    @Test
    public void VerifingSearchFunctionalityInHomePage() throws Exception {
    	HomePageTasks.searchAProduct();
    }
    
    @Test
    public void VerifingWishListLinkInHomePage() throws Exception {
    	HomePageTasks.verifyThatWishlist();
    }

	// Test method to verify mega menu selection
    @Test
    public void VerifingMegaMenuSelectionInHomePage() throws InterruptedException {
        // Call the randommenu method from homePageTasks class
        HomePageTasks.randomMegaMenu();
    }
    
	// Test method to verify mega menu selection
    @Test
    public void VerifingMegaMenuCLPSelectionInHomePage() throws Exception {
        // Call the randommenu method from homePageTasks class
        HomePageTasks.clpPageLoading();
    }


    
    //signIn link
    @Test
    public void VerifingSignInLinkInHomePage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
  
    	HomePageTasks.verifyThatSignInLink();
    }
    @Test
    public void VerifingUserLoginInHomePage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	HomePageTasks.verifyThatuserLogin();
    }
    @Test
    public void VerifingUserLogOutInHomePage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	HomePageTasks.verifyThatuserLogOut();
    }
    
    @Test
    public void VerifingMIniCartBtnClickInHomePage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	HomePageTasks.miniCartBtnClick();
    }
    
    
    @Test
    public void VerifingBacktoTopBtnClickInHomePage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	HomePageTasks.backtoTopBtn();
    }
    
    
    @Test
    public void VerifingslickCarousalInHomePage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	HomePageTasks.slickCarousal();
    }

    
    @Test
    public void VerifingVideowithtextbannerInHomePage() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	HomePageTasks.Videowithtextbanner();
    }
    
    
}
