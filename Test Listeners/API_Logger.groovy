import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

class API_Logger {
	
		 @BeforeTestSuite
		 private static UninstallAppAtStart (TestCaseContext testCaseContext) {
		 	//uninstall app
		 	//get device id
		 	String myDeviceId = RunConfiguration.getExecutionProperties().drivers.system.Mobile.deviceId.toLowerCase()
		 	try {
		 		//def baseCommand = ["adb", "-s", myDeviceId, "uninstall", "com.popular.app.corp"] as String[]
		 		//Process clear = Runtime.getRuntime().exec(baseCommand)
		 	} catch (Exception e) {
		 		System.err.println(e);
		 		e.printStackTrace();
		 	}
		 }
	
		@BeforeTestCase
		private static logcat (TestCaseContext testCaseContext) {
			//make global variable value to default
			GlobalVariable.index = 0;	
			GlobalVariable.index2 = 0;
			GlobalVariable.index3 = 0;
			GlobalVariable.index4 = 0;
			GlobalVariable.count = 0;
			GlobalVariable.count2 = 0;
			GlobalVariable.compare_data_one = '';
			GlobalVariable.compare_data_two = '';
			GlobalVariable.compare_data_three = '';
			GlobalVariable.compare_data_four = '';
			GlobalVariable.compare_data_five = '';
			GlobalVariable.compare_data_six = '';
			GlobalVariable.transfer_string = '';
			GlobalVariable.counter = 0;
			GlobalVariable.lastElement = '';
			GlobalVariable.Company_Account = '';
			
			//get test case name
			String testCaseId = testCaseContext.getTestCaseId()
			String testCaseName = testCaseId.substring((testCaseId.lastIndexOf("/").toInteger()) + 1)
			GlobalVariable.testCaseName = testCaseName
			
			//skip register tc's
			if(testCaseName.equals('APPEMP_Registration_Admin') == false && testCaseName.equals('APPEMP_Registration_NonAdmin') == false && testCaseName.equals('Registration') == false) {
				if(!GlobalVariable.login_check){
					testCaseContext.skipThisTestCase()
				} 
				//uncomment for single test case run
//				else {
//					GlobalVariable.login_check= false;
//					Mobile.startApplication(GlobalVariable.appPath, false)
//				}
			} else {
				GlobalVariable.login_check= false;
				String host = RunConfiguration.getExecutionProfile()
				if(host.contains("Remote")) {
					Mobile.startExistingApplication(GlobalVariable.ID)
				} else {
					Mobile.startApplication(GlobalVariable.appPath, false)
				}
			}
		}
		
		@AfterTestSuite
		private static UninstallAppAtEnd (TestCaseContext testCaseContext) {
			AppiumDriver<?> driver = MobileDriverFactory.getDriver()
			boolean appExist = driver.isAppInstalled("com.popular.app.corp");
			if(!appExist){
			  System.out.println("app is does not exist");
			}else{
			  driver.removeApp("com.popular.app.corp");
			}
		}
}