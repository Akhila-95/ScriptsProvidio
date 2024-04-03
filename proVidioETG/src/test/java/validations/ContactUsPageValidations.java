package validations;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.ContactUsPage;

public class ContactUsPageValidations extends baseClass{
	
	private static ContactUsPage CU = new ContactUsPage(driver);
	
	public static void verifyContactUsheader() {
		test.info("Verify Contact us link click");
 		if(Actionsss.displayElement(CU.getSelectheaderContactus())) {
			test.pass("Successfully Clicked on Contact us link and Contact Us Form displayed");
			logger.info("Successfully Clicked on Contact us link and Contact Us Form displayed");
		}else {
			test.pass("Not clicked on contact us ");
			logger.info("Not clicked on contact us");
		}
	}

	public static void verifySubmissionOfCase() {
		test.info("Verify submission of case in contact us");
 		if(Actionsss.displayElement(CU.getcaseSubmittedInContactUs())) {
			test.pass("Successfully  submitted the case in contact us");
			logger.info("Successfully  submitted the case in contact us");
		}else {
			test.pass("Not submitted the case in contact us");
			logger.info("Not submitted the case in contact us");
		}
	}
	
	public static void verifyingTheCloseOfContactUsDiv() throws InterruptedException {
		test.info("Verify close of contact us div ");
 		if(!Actionsss.elementSize(CU.getmainDivInContactUs())) {
			test.pass("Successfully div is closed in contact us after submitting the case");
			logger.info("Successfully div is closed in contact us after submitting the case");
		}else {
			test.fail("No div is closed in contact us after submitting the case");
			logger.info("No div is closed in contact us after submitting the case ");
		}
	}
	
	public static void verifyingTheErrorMessageInEmptyFieldsInContactUs() throws InterruptedException {
		test.info("Verifying the  error messages are displaying when submitting the empty fileds in contact us ");
 		if(Actionsss.elementSize(CU.getErrorMessagesInContactUsList())) {
			test.pass("Successfully error messages are displayed when submitted the empty fileds " +Actionsss.getTextOfElement(CU.getErrorMessagesInContactUs()));
			logger.info("Successfully error messages are displayed when submitted the empty fileds" +Actionsss.getTextOfElement(CU.getErrorMessagesInContactUs()));
		}else {
			test.fail("No error messages are displayed when submitted the empty fileds");
			logger.info("No error messages are displayed when submitted the empty fileds");
		}
	}
	
	public static void verifyingTheErrorMessageInInvalidEmailInContactUs() throws InterruptedException {
		test.info("Verifying the invalid email error message in contact us ");
 		if(Actionsss.displayElement(CU.getInvalidErrorMessageInContactUs())) {
			test.pass("Successfully error messages is displayed when invalid mail is submitted in contact us is " + Actionsss.getTextOfElement(CU.getInvalidErrorMessageInContactUs()));
			logger.info("Successfully error messages is displayed when invalid mail is submitted in contact us" + Actionsss.getTextOfElement(CU.getInvalidErrorMessageInContactUs()));
		}else {
			test.fail("No error messages is displayed when invalid mail is submitted in contact us");
			logger.info("No error messages is displayed when invalid mail is submitted in contact us");
		}
	}
	
	public static void verifyingCloseButtonClickInContactUs() throws InterruptedException {
		test.info("Verifying the close button click in contact us ");
		if(!Actionsss.elementSize(CU.getmainDivInContactUs())) {
			test.pass("Successfully clicked on close button in contact us");
			logger.info("Successfully clicked on close button in contact us");
		}else {
			test.fail("Not clicked on close button in contact us");
			logger.info("Not clicked on close button in contact us");
		}
	}
}
