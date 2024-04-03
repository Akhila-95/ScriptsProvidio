package tasks;


import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.FindAStorePage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDetailPage;
import pageObjects.homepage;
import validations.FindAStoreValidation;
import validations.HomePageValidations;
import validations.ProductDetailPageValidation;
import validations.ProductListingPageValidations;
import validations.WriteaReviewValidation;

public class ProductDetailPageTasks extends baseClass{
	
	private static TestData TD = new TestData();
	private static ProductDetailPage PDP = new ProductDetailPage(driver);
	private static homepage homePage = new homepage(driver);
	private static final FindAStorePage findStore = new FindAStorePage(driver);
	private static MyAccountPage MAC= new MyAccountPage(driver);
	public static void PdppageVeiw() throws Exception {
		List<WebElement> pdpPage = driver.findElements(By.xpath("//div[contains(@class, 'product-detail product')]"));
     	if (pdpPage.size()>0) {
     	    logger.info("Successfully Product detail page is loaded");
     	}else {
     		ProductListingPageTasks.productclick();
     	}
	}
	
	
	
	public static void writePowerReviewpage() throws Exception {
		
		Thread.sleep(2000);
		if(Actionsss.elementSize(PDP.getReviewButtonlist())) {
			test.pass("Power Reviews is currently Not in Activate Mode");
		}else {
     	if (Actionsss.elementSize(PDP.getpowerReviewformlist())) {
     	    logger.info("Successfully write a review page is loaded");
     	}else {
     		PdppageVeiw();
    		Thread.sleep(2000);
    	    Actionsss.CombinedClick(PDP.getSelectWriteaReviewLink());
    	    Thread.sleep(3000);
     	}
	   }
	}
	

	//wishList in pdp
	public static  void wishList() throws Exception {
		//PdppageVeiw();
		 LoginPageTasks.verifyThatuserLogin();
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/floral-sheath-dress/25591911M.html?lang=en_US");	
		ProductDetailPageValidation.verifyingWishlist();
	}
	
	//attibutes selection
	public static  void attributesSelection() throws Exception {
		PdppageVeiw();
		allAttributesSelection.selectTheAttributesInPdp();
		Thread.sleep(1000);
		ProductDetailPageValidation.verifyAttributesSelection();
	}
	
	//attibutes selection
	public static  void pickUpStoreSelectionInPdp() throws Exception {
		PdppageVeiw();
		allAttributesSelection.pickInStoreInPdp();
		Thread.sleep(1000);
		
	}
	/*
	//addtocart in pdp
	public static  void addtoCart() throws Exception {
		ProductListingPageTasks.productclick();
		allAttributesSelection.selectTheAttributesInPdp();
		
		int xCoord = 100;
        int yCoord = 200;
		
		Actions actions = new Actions(driver);
        // Perform a click anywhere on the page
		actions.moveByOffset(xCoord, yCoord).click().perform();
        
		Actionsss.CombinedClick(PDP.getSelectAddtoCartBtn());
		ProductListingPageValidations.validatingProductisAddtoCart();
		Thread.sleep(2000);
	}*/
	
	//addtocart in pdp
	public static  void addtoCart() throws Exception {
		ProductListingPageTasks.productclick();
		allAttributesSelection.selectTheAttributesInPdp();		
		Thread.sleep(2000);
	}
	//bread crambs
	public static void breadCrumbs() throws Exception{		
		PdppageVeiw();
		Thread.sleep(2000);
		Actionsss.CombinedClick(PDP.getSelectbreadCrumbLink());
		Thread.sleep(2000);
		ProductListingPageValidations.verifyBreadCrumbs();
	}
	
	//next button
	public static void caursalNextbutton() throws Exception{		
		PdppageVeiw();
		Actionsss.CombinedClick(PDP.getSelectCarasolRight());
		Thread.sleep(2000);
		ProductDetailPageValidation.verifyNextImages();
	}
	//next button
	public static void caursalPriewbutton() throws Exception{		
		PdppageVeiw();
		Actionsss.CombinedClick(PDP.getSelectCarasolLift());
		Thread.sleep(2000);
		ProductDetailPageValidation.verifyPreviewImages();
	}
	
	//custom input
	public static void CustomInput() throws Exception{		
		PdppageVeiw();
		if(Actionsss.countofElements(PDP.getselectInputlist())) {
			Actionsss.CombinedClick(PDP.getSelectdropdownInput());
			Thread.sleep(3000);
			Actionsss.randomElementFromListfordropdown(PDP.getSelectCustomInputlist());
			ProductDetailPageValidation.verifyselectedInput();
		}else{
			Actionsss.clearText(PDP.getSelectCustomInput());
			Thread.sleep(2000);
			Actionsss.SendKeys(PDP.getSelectCustomInput(), 5, TD.Input_PDP_IP_FieldName);
		}


	}
	
	//--------yopto reviews ---------------------------------------
	
		public static void YoptoReviewform() throws Exception{		
			PdppageVeiw();
			if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
				if(Actionsss.countofElements(PDP.getReviewyoptoform())) {
					logger.info("successfully displyed the form of yopto reviews");
				}else {
					Actionsss.scrollIntoCenterView(PDP.clickOnReviewButton());
					Thread.sleep(2000); 
					Actionsss.CombinedClick(PDP.clickOnReviewButton());
					Thread.sleep(2000); 
					ProductDetailPageValidation.verifyyeptoform();
				}
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
				test.pass("Yopto Reviews is currently Not in Activate Mode");
			}
	    }
		
		public static void emptyform() throws Exception {
			YoptoReviewform();
			if(Actionsss.countofElements(PDP.getReviewyoptoform())) {
				Thread.sleep(2000); 
				Actionsss.CombinedClick(PDP.clickOnReviewpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verifyemptyyeptoform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void formwithStarSelection() throws Exception {
			YoptoReviewform();
			if(Actionsss.countofElements(PDP.getReviewyoptoform())) {
				Thread.sleep(2000); 
				Actionsss.randomElementFromList(PDP.getclickOnReviewStar());
				Thread.sleep(2000); 
				Actionsss.CombinedClick(PDP.clickOnReviewpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verify_Star_yeptoform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void formwithStarSelectionandTitle() throws Exception {
			YoptoReviewform();
			if(Actionsss.countofElements(PDP.getReviewyoptoform())) {
				Actionsss.randomElementFromList(PDP.getclickOnReviewStar());
				Actionsss.sendKeys(PDP.getsendReviewtitle(),TD.Title_Yopto_RP_IP_Data,TD.Title_Yopto_RP_IP_FieldName);
				Thread.sleep(2000); 
				Actionsss.CombinedClick(PDP.clickOnReviewpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verify_Star_Title_yeptoform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void formwithStarSelection_Title_Content() throws Exception {
			YoptoReviewform();
			if(Actionsss.countofElements(PDP.getReviewyoptoform())) {
				Actionsss.randomElementFromList(PDP.getclickOnReviewStar());
				Actionsss.sendKeys(PDP.getsendReviewtitle(),TD.Title_Yopto_RP_IP_Data,TD.Title_Yopto_RP_IP_FieldName);
				Actionsss.sendKeys(PDP.getsendReviewdescription(),TD.Review_Yopto_RP_IP_Data,TD.Review_Yopto_RP_IP_FieldName);
				Thread.sleep(2000); 
				Actionsss.CombinedClick(PDP.clickOnReviewpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verify_Star_Title_Content_yeptoform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void formwithStarSelection_Title_Content_UserName() throws Exception {
			YoptoReviewform();
			if(Actionsss.countofElements(PDP.getReviewyoptoform())) {
				Actionsss.randomElementFromList(PDP.getclickOnReviewStar());
				Actionsss.sendKeys(PDP.getsendReviewtitle(),TD.Title_Yopto_RP_IP_Data,TD.Title_Yopto_RP_IP_FieldName);
				Actionsss.sendKeys(PDP.getsendReviewdescription(),TD.Review_Yopto_RP_IP_Data,TD.Review_Yopto_RP_IP_FieldName);
				Actionsss.sendKeys(PDP.getsendReviewUserName(),TD.UserName_Yopto_RP_IP_Data,TD.UserName_Yopto_RP_IP_FieldName);
				Thread.sleep(2000); 
				Actionsss.CombinedClick(PDP.clickOnReviewpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verify_Star_Title_Content_UserName_yeptoform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void formwithStarSelection_Title_Content_UserNameandEmail() throws Exception {
			YoptoReviewform();
			if(Actionsss.countofElements(PDP.getReviewyoptoform())) {
				Actionsss.randomElementFromList(PDP.getclickOnReviewStar());
				Actionsss.sendKeys(PDP.getsendReviewtitle(),TD.Title_Yopto_RP_IP_Data,TD.Title_Yopto_RP_IP_FieldName);
				Actionsss.sendKeys(PDP.getsendReviewdescription(),TD.Review_Yopto_RP_IP_Data,TD.Review_Yopto_RP_IP_FieldName);
				Actionsss.sendKeys(PDP.getsendReviewUserName(),TD.UserName_Yopto_RP_IP_Data,TD.UserName_Yopto_RP_IP_FieldName);
				Actionsss.sendKeys(PDP.getsendReviewEmail(),TD.UserEmail_Yopto_RP_IP_Data,TD.UserEmail_Yopto_RP_IP_FieldName);
				Thread.sleep(2000); 
				Actionsss.CombinedClick(PDP.clickOnReviewpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verifyValidDetailsyeptoform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		
		//Review filters
		public static void productReviewFilters() throws Exception {
			List<WebElement> pdpPage = driver.findElements(By.xpath("//div[contains(@class, 'product-detail product')]"));
	     	if (pdpPage.size()>0) {
			    logger.info("pdp page is already loaded");
	     	}else {
	     		Actionsss.sendKeys(homePage.getSearchElement(),TD.Search_Home_Page_IP_Data_Reviews, TD.Search_Home_Page_IP_FieldName);
				test.info("Verify Search Input of " + TD.Search_Home_Page_IP_Data_Reviews);
				Thread.sleep(2000);
				Actionsss.randomElementFromList(homePage.getClickOnSearchedProduct());
				Thread.sleep(4000);
				HomePageValidations.verifyPLPProductClick();
	     	}
		}
	
		public static void searchYotpofilters() throws Exception {
			productReviewFilters();
			if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
				Actionsss.sendKeysandEnter(PDP.getfiltersSearch(),TD.Search_Review_Yopto_RP_IP_Data, TD.Search_Yopto_RP_IP_FieldName );
				test.info("Verify Search Input of " + TD.Search_Review_Yopto_RP_IP_Data);
				Thread.sleep(2000);
				ProductDetailPageValidation.verifySearchFilter();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void clearsearchYotpofilters() throws Exception {
			productReviewFilters();
			if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
				Actionsss.sendKeysandEnter(PDP.getfiltersSearch(),TD.Search_Review_Yopto_RP_IP_Data, TD.Search_Yopto_RP_IP_FieldName );
				test.info("Verify Search Input of " + TD.Search_Review_Yopto_RP_IP_Data);
				Thread.sleep(2000);
				ProductDetailPageValidation.verifySearchFilter();
				Thread.sleep(2000);
				Actionsss.CombinedClick(PDP.getclearFilter());
				Thread.sleep(2000);
				ProductDetailPageValidation.verifySearchFilter();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}		
		
		public static void invalidsearchYotpofilters() throws Exception {
			productReviewFilters();
			if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
				Actionsss.sendKeysandEnter(PDP.getfiltersSearch(),TD.InValid_Search_Review_Yopto_RP_IP_Data, TD.Search_Yopto_RP_IP_FieldName );
				test.info("Verify Search Input of " + TD.InValid_Search_Review_Yopto_RP_IP_Data);
				Thread.sleep(2000);
				ProductDetailPageValidation.verifySearchFilter();

			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void selectRatings() throws Exception {
			productReviewFilters();
			if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
				Actionsss.CombinedClick(PDP.getRatingFilter());
				Thread.sleep(2000);
				Actionsss.randomElementFromList(PDP.getRatingFilterValue());
				Thread.sleep(2000);
				ProductDetailPageValidation.verifySearchFilter();

			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
	
		public static void selectImages() throws Exception {
			productReviewFilters();
			if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
				Actionsss.CombinedClick(PDP.getRatingFilter());
				Thread.sleep(2000);
				Actionsss.randomElementFromList(PDP.getRatingFilterValue());
				Thread.sleep(2000);
				ProductDetailPageValidation.verifySearchFilter();
				Thread.sleep(2000);
				Actionsss.CombinedClick(PDP.getImageFilter());
				Actionsss.randomElementFromList(PDP.getImageFilterValue());
				ProductDetailPageValidation.verifySearchFilter();

			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void reviewsFilterFooter() throws Exception {
			productReviewFilters();
			test.info("Verifying the share link of yotpt reives");
			if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
				if(Actionsss.countofElements(PDP.getfooterFilter())) {
					test.pass("Successfully displayed the share link of yotpo reviews");
				}

			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		
		public static void YoptoReviewAskaQuestionform() throws Exception{		
			productReviewFilters();
			if(Actionsss.countofElements(PDP.getAskaQuestionbtnlist())) {
				if(Actionsss.countofElements(PDP.getAskaQuestionFormlist())) {
					logger.info("successfully displyed the form of aks a question");
				}else {
					Actionsss.scrollIntoCenterView(PDP.getAskaQuestion());
					Thread.sleep(2000); 
					Actionsss.CombinedClick(PDP.getAskaQuestion());
					Thread.sleep(2000); 
					ProductDetailPageValidation.verifyYeptoAskaQuestionForm();
				}
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
				test.pass("Yopto Reviews is currently Not in Activate Mode");
			}
	    }
		
		public static void emptyformaskaQuestin() throws Exception {
			YoptoReviewAskaQuestionform();
			if(Actionsss.countofElements(PDP.getAskaQuestionbtnlist())) {
				Thread.sleep(2000); 
				Actionsss.CombinedClick(PDP.getAskaQuestionpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verifyemptyform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void emptyformaskaQuestin_Question() throws Exception {
			YoptoReviewAskaQuestionform();
			if(Actionsss.countofElements(PDP.getAskaQuestionbtnlist())) {
				Thread.sleep(2000); 
				Actionsss.sendKeys(PDP.getAskaQuestioninput(),TD.Comment_RP_IP_Data,TD.Question_Yopto_RP_IP_FieldName);
				Actionsss.CombinedClick(PDP.getAskaQuestionpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verifyQuestionsyeptoform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		
		public static void emptyformaskaQuestin_Question_UserName() throws Exception {
			YoptoReviewAskaQuestionform();
			if(Actionsss.countofElements(PDP.getAskaQuestionbtnlist())) {
				Thread.sleep(2000); 
				Actionsss.sendKeys(PDP.getAskaQuestioninput(),TD.Comment_RP_IP_Data,TD.Question_Yopto_RP_IP_FieldName);
				Actionsss.sendKeys(PDP.getAskaQuestionUsername(),TD.UserName_Yopto_RP_IP_Data,TD.UserName_Yopto_RP_IP_FieldName);
				Actionsss.CombinedClick(PDP.getAskaQuestionpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verifyusernamesyeptoform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		public static void ValidDetialsofAskaQuestion() throws Exception {
			YoptoReviewAskaQuestionform();
			if(Actionsss.countofElements(PDP.getAskaQuestionbtnlist())) {
				Thread.sleep(2000); 
				Actionsss.sendKeys(PDP.getAskaQuestioninput(),TD.Comment_RP_IP_Data,TD.Question_Yopto_RP_IP_FieldName);
				Actionsss.sendKeys(PDP.getAskaQuestionUsername(),TD.UserName_Yopto_RP_IP_Data,TD.UserName_Yopto_RP_IP_FieldName);
				Actionsss.sendKeys(PDP.getAskaQuestionEmail(),TD.UserEmail_Yopto_RP_IP_Data,TD.UserEmail_Yopto_RP_IP_FieldName);
				Actionsss.CombinedClick(PDP.getAskaQuestionpost());
				Thread.sleep(2000); 
				ProductDetailPageValidation.verifyValidDetailsaskaQuestionform();
			}else {
				logger.info("Yopto Reviews is currently Not in Activate Mode");
			}
		}
		
		
		
	
	
	//----------write a raview-------------------------------------------
		

	public static void powerReviews() throws Exception	{
		writePowerReviewpage();
		ProductDetailPageValidation.verifyPowerReviewPage();
	}
		
	public static void writeaReview() throws Exception{	
		writePowerReviewpage();
		if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
			logger.info("Power Reviews is currently Not in Activate Mode");
		}else {
		 Actionsss.randomElementFromList(PDP.getSelectrating());
		 Actionsss.sendKeys(PDP.getSelectheading(),TD.HeadLine_RP_IP_Data,TD.HeadLine_RP_IP_FieldName);
		 Actionsss.sendKeys(PDP.getSelectcomments(),TD.Comment_RP_IP_Data,TD.Comment_RP_IP_FieldName);
		 Actionsss.sendKeys(PDP.getSelectnickName(),TD.Nickname_RP_IP_FieldName,TD.Nickname_RP_IP_Data);
		 Actionsss.sendKeys(PDP.getSelectlocation(),TD.Location_RP_IP_Data,TD.Location_RP_IP_FieldName);
		 Actionsss.CombinedClick(PDP.getSelectforYes());
		 Thread.sleep(2000); 
		 Actionsss.CombinedClick(PDP.getSelectsubmitReview());
		 Thread.sleep(4000); 
		 ProductDetailPageValidation.validateReviewProduct();
		}
	}
	
	//write a raview with out entering all the details
	public static void writeaReviewwithoutEnteringDetails() throws Exception{		
		writePowerReviewpage();
		if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
			logger.info("Power Reviews is currently Not in Activate Mode");
		}else {
		Actionsss.CombinedClick(PDP.getSelectsubmitReview());
	    WriteaReviewValidation.verifywithOutEnteringDetails();
		}
    }
	//rating filed filled
	public static void writeaReviewwithRatingFieldFilled() throws Exception{		
		writePowerReviewpage();
		if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
			logger.info("Power Reviews is currently Not in Activate Mode");
		}else {
	    Actionsss.randomElementFromList(PDP.getSelectrating());
	    Thread.sleep(1000);
	    Actionsss.CombinedClick(PDP.getSelectsubmitReview());
	    WriteaReviewValidation.verifyRatingFieldfilledRemainingEmpty();
		}
    }
	
	
	public static void writeaReviewwithRatingandHeadingFieldsFilled() throws Exception{		
		writePowerReviewpage();
		if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
			logger.info("Power Reviews is currently Not in Activate Mode");
		}else {
	    Actionsss.randomElementFromList(PDP.getSelectrating());
	    Thread.sleep(1000);
	    Actionsss.sendKeys(PDP.getSelectheading(),TD.HeadLine_RP_IP_Data,TD.HeadLine_RP_IP_FieldName);
	    Actionsss.CombinedClick(PDP.getSelectsubmitReview());
	    WriteaReviewValidation.verifyRatingandHeadingFieldsfilledRemainingEmpty();
		}
    }
	
	public static void writeaReviewwithRatingHeadingandCommentsFieldsFilled() throws Exception{		
		writePowerReviewpage();
		if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
			logger.info("Power Reviews is currently Not in Activate Mode");
		}else {
	    Actionsss.randomElementFromList(PDP.getSelectrating());
	    Thread.sleep(1000);
	    Actionsss.sendKeys(PDP.getSelectheading(),TD.HeadLine_RP_IP_Data,TD.HeadLine_RP_IP_FieldName);
	    Actionsss.sendKeys(PDP.getSelectcomments(),TD.Comment_RP_IP_Data,TD.Comment_RP_IP_FieldName);
	    Actionsss.CombinedClick(PDP.getSelectsubmitReview());
	    WriteaReviewValidation.verifyRatingHeadingandcommentsFieldsfilledRemainingEmpty();
		}
    }
	
	public static void writeaReviewwithRatingHeadingCommentsandnickNameFieldsFilled() throws Exception{		
		writePowerReviewpage();
		if(Actionsss.countofElements(PDP.getReviewButtonlist())) {
			logger.info("Power Reviews is currently Not in Activate Mode");
		}else {
	    Actionsss.randomElementFromList(PDP.getSelectrating());
	    Thread.sleep(1000);
	    Actionsss.sendKeys(PDP.getSelectheading(),TD.HeadLine_RP_IP_Data,TD.HeadLine_RP_IP_FieldName);
	    Actionsss.sendKeys(PDP.getSelectcomments(),TD.Comment_RP_IP_Data,TD.Comment_RP_IP_FieldName);
	    Actionsss.sendKeys(PDP.getSelectnickName(),TD.Nickname_RP_IP_FieldName,TD.Nickname_RP_IP_Data);
	    Actionsss.CombinedClick(PDP.getSelectsubmitReview());
	    WriteaReviewValidation.verifyRatingHeadingcommentsandNickNameFieldsfilledRemainingEmpty();
		}
    }
	
	public static void ProductSpecifications() throws Exception {
		PdppageVeiw();
		Actionsss.scrollDown();
		ProductDetailPageValidation.verifyProductSpecifications();
	}
	
	public static void productRecommandations() throws Exception {
		PdppageVeiw();
		Actionsss.scrollDown();
		ProductDetailPageValidation.verifyRecommendations();
	}
	
	public static  void onlyAddtoCartForScorcherDeals() throws Exception {	
		allAttributesSelection.selectTheAttributesInPdp();
		Actionsss.CombinedClick(PDP.getSelectAddtoCartBtn());
		ProductListingPageValidations.validatingProductisAddtoCart();
		//Thread.sleep(2000);
	}
	
	//--------------page refresh in pdp---------------------
	public static void pageRefreshInPDP() throws Exception {
		PdppageVeiw();
		allAttributesSelection.selectTheAttributesInPdp();
		TestData.breadcrumbInPdpBeforeRefresh=Actionsss.getTextOfElement(PDP.getLastBreadcrumb());
		logger.info(TestData.breadcrumbInPdpBeforeRefresh);
		driver.navigate().refresh();
		TestData.breadcrumbInPdpAfterRefresh=Actionsss.getTextOfElement(PDP.getLastBreadcrumb());
		logger.info(TestData.breadcrumbInPdpAfterRefresh);
		ProductDetailPageValidation.verifyRefreshInPDP();
	}
	
	//------------------share link in PDP --------------------
	public static void shareLink() throws Exception {
		PdppageVeiw();
	//	allAttributesSelection.selectTheAttributesInPdp();
		Actionsss.click(PDP.getShareLink());
		Thread.sleep(2000);
		test.info("Verifying the pdp sharing by copying");
		// Open a new tab using keyboard shortcuts (Ctrl + T)
       
		// Get the copied link from the clipboard
        String copiedLink = getClipboardContents();
        
        logger.info(copiedLink);
        test.pass("Pdp link is copied " +copiedLink + " and sharing in social is restricted in automation as social media is third party" );
	}
	
	private static String getClipboardContents() {
        try {
            return (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

	//--------------RECOMMENDATIONS----------------
	public static void einsteinRecommendations() throws Exception {
		PdppageVeiw();
		Actionsss.scrollWindowsByPixel(1000);
		Actionsss.randomlyHover(PDP.getproductsInRecommendationsList());
	//	Thread.sleep(2000);
		ProductDetailPageValidation.verifyingRecomendationss();
	}
	
	public static void carouselInEinsteinRecommendations() throws Exception {
		PdppageVeiw();
		Actionsss.scrollWindowsByPixel(500);		
		ProductDetailPageValidation.verifyingCarouselsInRecomendationss();
	}
	
}
