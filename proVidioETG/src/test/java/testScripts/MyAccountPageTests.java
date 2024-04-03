package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageTasks;

public class MyAccountPageTests extends baseClass{
	
	
	//my account page
	@Test(groups = {"smoke", "regression"})
    public void VerifingMyAccount() throws Exception {
        
		MyAccountPageTasks.myAccoutView();
    }
	

	@Test(groups = {"smoke", "regression"})
    public void VerifingMyOrder() throws Exception {
        
		MyAccountPageTasks.myOrderLink();
    }

}
