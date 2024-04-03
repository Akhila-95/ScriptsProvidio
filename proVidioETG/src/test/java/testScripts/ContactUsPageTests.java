package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.ContactUsPageTasks;

public class ContactUsPageTests extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
    public void VerifyingContactUsFuncitonalityInContactUs() throws Exception {
		ContactUsPageTasks.contactuslinkClick();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifyingTheSubmissionOfCaseInContactUs() throws Exception {
		ContactUsPageTasks.submitCaseInContactUs();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifyingTheErrorMessagesInEmptyFieldSubmissionInContactUs() throws Exception {
		ContactUsPageTasks.emptyFieldsInContactUs();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifyingTheInvalidErrorMessageWhileSubmission_InContactUs() throws Exception {
		ContactUsPageTasks.invalidEmailInContactUs();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifyingTheCloseOfContactUsAfterSubmittingTheCase() throws Exception {
		ContactUsPageTasks.closeContactUsAfterSubmittingCase();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifyingTheCloseButtonOnContactUs() throws Exception {
		ContactUsPageTasks.closeContactUsForm();
    }

}
