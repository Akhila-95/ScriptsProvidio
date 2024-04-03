package tasks;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.ContactUsPage;
import validations.ContactUsPageValidations;

public class ContactUsPageTasks extends baseClass{
	
	private static ContactUsPage CU = new ContactUsPage(driver);
	
	public static void contactus() throws Exception {
		if(Actionsss.elementSize(CU.getmainDivInContactUs())) {
			logger.info("Contact us link is clicked");
		}else {
			contactuslinkClick();
		}
	}
	
	public static void emptyFieldsInContactUs() throws Exception {
		contactus();
		Actionsss.click(CU.getSubmitButtonInContactUs());
		Thread.sleep(2000);
		ContactUsPageValidations.verifyingTheErrorMessageInEmptyFieldsInContactUs();
	}
	
	public static void invalidEmailInContactUs() throws Exception {
		contactus();
		Actionsss.sendKeys(CU.getsubjectInContactus(), "Order issue", "subject in contact us");
		Actionsss.sendKeys(CU.getemailInContactus(),TestData.invalidEmailInContactUs, "email in contact us");
		Actionsss.sendKeys(CU.getNameInputInContactUs(), "Akhila", "web name");
	//	Actionsss.randomElementFromListfordropdown(CU.getTypeDropdownInContactUsList());
		Thread.sleep(2000);
		Actionsss.click(CU.getSubmitButtonInContactUs());
		ContactUsPageValidations.verifyingTheErrorMessageInInvalidEmailInContactUs();		
	}
	
	public static void contactuslinkClick() throws Exception {
		Thread.sleep(2000);
		Actionsss.CombinedClick(CU.getSelectcontactusLink());
		Thread.sleep(10000);
		ContactUsPageValidations.verifyContactUsheader();				
	}

	public static void submitCaseInContactUs() throws Exception {
		contactus();
		Actionsss.sendKeys(CU.getsubjectInContactus(), "Order issue", "subject in contact us");
		Actionsss.sendKeys(CU.getemailInContactus(),TestData.webEmailInContactUs, "email in contact us");
		Actionsss.sendKeys(CU.getNameInputInContactUs(), "Akhila", "web name");
	//	Actionsss.randomElementFromListfordropdown(CU.getTypeDropdownInContactUsList());
		Actionsss.click(CU.getSubmitButtonInContactUs());
		Thread.sleep(4000);
		Actionsss.displayElement(CU.getcaseSubmittedInContactUs());
		ContactUsPageValidations.verifySubmissionOfCase();
		Actionsss.click(CU.getDoneInContactUs());
		Thread.sleep(2000);	
	}
	
	public static void closeContactUsAfterSubmittingCase() throws Exception {
		contactus();
		Actionsss.sendKeys(CU.getsubjectInContactus(), "Order issue", "subject in contact us");
		Actionsss.sendKeys(CU.getemailInContactus(),TestData.webEmailInContactUs, "email in contact us");
		Actionsss.sendKeys(CU.getNameInputInContactUs(), "Akhila", "web name");
		//Actionsss.randomElementFromListfordropdown(CU.getTypeDropdownInContactUsList());
		Actionsss.click(CU.getSubmitButtonInContactUs());
		Thread.sleep(4000);
		Actionsss.displayElement(CU.getcaseSubmittedInContactUs());
		ContactUsPageValidations.verifySubmissionOfCase();
		Actionsss.click(CU.getDoneInContactUs());
		Thread.sleep(2000);	
		ContactUsPageValidations.verifyingTheCloseOfContactUsDiv();
	}
	
	public static void closeContactUsForm() throws Exception {
		contactus();
		Actionsss.CombinedClick(CU.getcloseButtonInContactUs());
		ContactUsPageValidations.verifyingCloseButtonClickInContactUs();
	}
}
