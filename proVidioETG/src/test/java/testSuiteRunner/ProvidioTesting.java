package testSuiteRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import baseClass.baseClass;
import data.TestData;

public class ProvidioTesting extends baseClass{
	
	TestData TD = new TestData();
	
	
	@Test
	public void testsuitRunner() {
	    // Check if the browser has crashed
	    if (TD.TestSuiteType == "Smoke") {
	    	logger.info("This is smoke test suite");
	        // Specify the suite file paths in an array
	        String[] suiteFiles = {"C:\\Users\\Upendra Reddy\\git\\ProvidioLatestCode\\proVidioETG\\src\\test\\java\\testSuiteRunner\\smokeTestSuite.xml"};
	        // Execute the test suite with the specified suite files
	        executeTestSuite(suiteFiles);
	    }else {
	    	logger.info("This is regression test suite");
	    	String[] suiteFiles = {"C:\\Users\\Upendra Reddy\\git\\ProvidioLatestCode\\proVidioETG\\src\\test\\java\\testSuiteRunner\\RegressionTestSuite.xml"};
	        // Execute the test suite with the specified suite files
	        executeTestSuite(suiteFiles);
	    }
	}

		public void executeTestSuite(String... suiteFiles) {
		    // Create a new TestNG instance
		    TestNG testng = new TestNG();
		    // Create a new XmlSuite instance
		    XmlSuite suite = new XmlSuite();
		    // Create a list to store suite file names
		    List<String> suiteFileList = new ArrayList<>();
		    // Add suite files to the list
		    Collections.addAll(suiteFileList, suiteFiles);
		    // Set the suite files for the XmlSuite
		    suite.setSuiteFiles(suiteFileList);
		    // Set the XmlSuites for the TestNG instance
		    testng.setXmlSuites(Collections.singletonList(suite));
		    // Run the TestNG instance, executing the specified test suite
		    testng.run();
		}

		   
		
}
