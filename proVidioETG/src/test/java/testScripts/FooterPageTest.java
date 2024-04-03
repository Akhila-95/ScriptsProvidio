package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.FooterPage;
import tasks.FooterPageTasks;

public class FooterPageTest extends baseClass{
	
	
	@Test
	public static void VerifyingResourceFooterLinks() throws Exception {
		FooterPageTasks.resourceFooterLinks();
	}
	
	@Test
	public static void VerifyingValidEmailInSighUpBoxInFooter() throws Exception {		
		 FooterPageTasks.validEmailInSignUpBoxInFooter();
	}
	
	//@Test
	public static void VerifyingWithoutEnteringEmailInSignupBoxInFooter() throws Exception {		
		 FooterPageTasks.withoutEnteringEmailInSignupBoxInFooter();
	}
	
	@Test
	public static void VerifyinginvalidEmailInEmailSignUpBox()  throws Exception {		 
		// FooterPageTasks.invalidEmailInEmailSignUpBox();
	}
	
	@Test
	public static void VerifyingDisplayOfComponentsInFooter()  throws Exception {		 
		 FooterPageTasks.displayOfComponentsInFooter();
	}
	
	
}
