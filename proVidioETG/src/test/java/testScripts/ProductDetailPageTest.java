package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.ProductDetailPageTasks;

public class ProductDetailPageTest extends baseClass{
	
	// wishList
    @Test(groups = {"regression"})
    public void VerifingWishlistFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.wishList();
    }
    
    //attribute selection
    @Test(groups = {"regression"})
    public void VerifingAttriubuteSelectionFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.attributesSelection();
    }
    
	// add to cart
    @Test(groups = {"regression"})
    public void VerifingAddtoCartFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.addtoCart();
    }
    
	// bread crumbs
    @Test(groups = {"regression"})
    public void VerifingbreadCrumbsFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.breadCrumbs();
    }
    
	// next button caurosal
    @Test(groups = {"regression"})
    public void VerifingNextbuttonCaurosalFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.caursalNextbutton();
    }
    
	// preview button cauroasal
    @Test(groups = {"regression"})
    public void VerifingPreviewbuttonCaurosalFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.caursalPriewbutton();
    }
    
	// custom Input
    @Test(groups = {"regression"})
    public void VerifingCustomInputFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.CustomInput();
    }
    
 // custom Input
    @Test(groups = {"regression"})
    public void VerifingPowerReviewsPageByClickingOnWrite_A_Review() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.powerReviews();
    }
    
    
    
	// writeaReview
    @Test(groups = {"regression"})
    public void VerifingWriteaReviewFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.writeaReview();
    }
    
    //without entering details
    @Test(groups = {"regression"})
    public void VerifingWithoutEnteringDetailsandSubmitTheReivewFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.writeaReviewwithoutEnteringDetails();
    }
    
    //Entering rating
    @Test(groups = {"regression"})
    public void VerifingWithEnteringRatingandSubmitFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.writeaReviewwithRatingFieldFilled();
    }
    //entering rating and heading
    @Test(groups = {"regression"})
    public void VerifingWithEnteringRatingHeadingandSubmitFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.writeaReviewwithRatingandHeadingFieldsFilled();
    }
    //enteing rating, heading and comments
    @Test(groups = {"regression"})
    public void VerifingWithEnteringRatingHeadingcommentsandSubmitFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.writeaReviewwithRatingHeadingandCommentsFieldsFilled();
    }
    //entering rating, heading,comments and nickname
    @Test(groups = {"regression"})
    public void VerifingWithEnteringRatingHeadingcommentnicknamesandSubmitFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.writeaReviewwithRatingHeadingCommentsandnickNameFieldsFilled();
    }

  //entering rating, heading,comments and nickname
    @Test(groups = {"regression"})
    public void VerifingProductDetailsInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.ProductSpecifications();
    }
    
  //entering rating, heading,comments and nickname
    @Test(groups = {"regression"})
    public void VerifingProductRecommendationsInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.productRecommandations();
    }
    
    
    //-----------yopto Reviews -----------------------------
    
    @Test
    public void VerifyingYoptoReviesFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.YoptoReviewform();
    }
    @Test
    public void VerifyingYoptoReviesEmptyFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.emptyform();
    }
    @Test
    public void VerifyingYoptoReviesFormwithStarSelectionInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.formwithStarSelection();
    }
    @Test
    public void VerifyingYoptoReviesFormwithStarSelectionandTitleInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.formwithStarSelectionandTitle();
    }
    @Test
    public void VerifyingYoptoReviesFormwithStarSelection_Title_ContentInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.formwithStarSelection_Title_Content();
    }
    @Test
    public void VerifyingYoptoReviesFormwithStarSelection_Title_Content_UserNameInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.formwithStarSelection_Title_Content_UserName();
    }
    @Test
    public void VerifyingYoptoReviesValidDetailsandSubmitFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.formwithStarSelection_Title_Content_UserNameandEmail();
    }
    
    //-----------------------product filters -----------------------------------
    @Test
    public void VerifyingYoptoReviesFiltersInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.productReviewFilters();
    }
    
    @Test
    public void VerifyingYoptoReviesInvalidSearchInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.invalidsearchYotpofilters();
    }
    
    @Test
    public void VerifyingYoptoReviesValidSearchInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.searchYotpofilters();
    }
    
    @Test
    public void VerifyingYoptoReviesClearSearchInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.clearsearchYotpofilters();
    }
    
    @Test
    public void VerifyingYoptoReviesRatingFilterInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.selectRatings();
    }
    
    @Test
    public void VerifyingYoptoReviesRatingandImagesFilterInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.selectImages();
    }
    
    @Test
    public void VerifyingYoptoReviesFooterInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.reviewsFilterFooter();
    }
    
    @Test
    public void VerifyingYoptoReviesAskaQuestionFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.YoptoReviewAskaQuestionform();
    }
    
    @Test
    public void VerifyingYoptoReviesAskaQuestionEmptyFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.emptyformaskaQuestin();
    }
    
    @Test
    public void VerifyingYoptoReviesAskaQuestion_Question_FormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.emptyformaskaQuestin_Question();
    }
    
    @Test
    public void VerifyingYoptoReviesAskaQuestion_Question_UserName_FormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.emptyformaskaQuestin_Question_UserName();
    }
    
    @Test
    public void VerifyingYoptoReviesAskaQuestionValidDetailsFormInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.ValidDetialsofAskaQuestion();
    }
    

    @Test
    public void VerifyingRefreshInPDP_Page() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.pageRefreshInPDP();
    }
    
    @Test
    public void VerifyingShareLinkInPDP_Page() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.shareLink();
    }
    

    @Test
    public void VerifyingRecommendationsInPDP_Page() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.einsteinRecommendations();
    }
    
    @Test
    public void VerifyingCarouselsInRecommendationsInPDP_Page() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.carouselInEinsteinRecommendations();
    }
 

}
