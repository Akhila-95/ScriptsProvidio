package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.LogOutTasks;

public class LogOutTest extends baseClass{

	@Test
	public void verifyLogout() throws Exception {
		LogOutTasks.verifyLogout();
	}
}
