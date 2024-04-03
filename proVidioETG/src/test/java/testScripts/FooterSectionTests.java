package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.FooterSectionTasks;

public class FooterSectionTests extends baseClass{

    @Test(groups = {"regression"})
    public void VerifingGiftCardLinkInFooter() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	FooterSectionTasks.verifyGiftCardLinkInFooter();
    }
}
