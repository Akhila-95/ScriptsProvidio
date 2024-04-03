package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.FooterSection;
import validations.FooterSectionValidation;

public class FooterSectionTasks extends baseClass{
	
	private static FooterSection footer = new FooterSection(driver);
	
    //gift card
    public static void verifyGiftCardLinkInFooter() throws Exception {
    	
    	Actionsss.scrollBottom();
        Thread.sleep(3000);
    	Actionsss.scrollBottom();
    	Thread.sleep(2000);
	    // Click on the "Gift Card" link
	    Actionsss.CombinedClick(footer.getGiftCardLink());
	    // Wait for 3 seconds to allow the action to complete
	    Thread.sleep(1000);
	    // Verify the result of clicking on the "Gift Card" link
	    FooterSectionValidation.verifyFooterGiftCardLink();
	}

}
