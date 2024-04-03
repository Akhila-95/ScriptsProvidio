package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.MyAccountPageOrderHistoryTasks;

public class MyAccountPageOrderHistoryTests extends baseClass{
	
	@Test(groups = {"regression"})
    public void VerifingOrderHistoryPageInMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.orderHistoryPageView();
    }
	
	@Test(groups = {"regression"})
    public void VerifingHomeLinkInOrderHistoryPageOnMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.homelink();
    }
	
	@Test(groups = {"regression"})
    public void VerifingMyAccountLinkInOrderHistoryPageOnMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.myAccountedit();
    }
	
	@Test(groups = {"regression"})
    public void VerifingBackToMyAccountLinkInOrderHistoryPageOnMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.backtomyaccountlink();
    }
	
	@Test(groups = {"regression"})
    public void VerifingSelectFiltersInOrderHistoryPageOnMyAccountPage() throws Exception {
	//	MyAccountPageOrderHistoryTasks.filterOrderHistory();
    }

	//order details
	@Test(groups = {"regression"})
    public void VerifingViewLinkInOrderHistoryPageOnMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.orderDetailsView();
    }
	
	@Test(groups = {"regression"})
    public void VerifingHomeLinkInOrderDetailPageFromOrderHistoryPageInMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.orderDetailHomeLink();
    }
	
	@Test(groups = {"regression"})
    public void VerifingMyAccountLinkInOrderDetailPageFromOrderHistoryPageInMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.orderDetailmyAccountedit();
    }
    
    	@Test(groups = {"regression"})
    public void VerifingOrderHistoryLinkInOrderDetailPageFromOrderHistoryPageInMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.orderDetailOrderHistorylink();
    }
    
        	@Test(groups = {"regression"})
    public void VerifingProductLinkInOrderDetailPageFromOrderHistoryPageInMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.orderDetailProductlink();
    }
        	@Test(groups = {"regression"})
    public void VerifingBackToOrderHistoryLinkInOrderDetailPageFromOrderHistoryPageInMyAccountPage() throws Exception {
		//MyAccountPageOrderHistoryTasks.orderDetailbacktoMyOrderHistorylink();
    }
 
}
