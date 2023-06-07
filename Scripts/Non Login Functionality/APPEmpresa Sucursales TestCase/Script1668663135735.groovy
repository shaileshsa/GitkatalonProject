import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Mobile.delay(5)
Mobile.startApplication(GlobalVariable.appPath, false, FailureHandling.STOP_ON_FAILURE)
Mobile.delay(5)

//uncomment for single test case Run
Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Accesso Screen/Popular Logo new'),GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Non Login Functionality/SideMenuIcon'),GlobalVariable.timeOut_5_Sec , FailureHandling.STOP_ON_FAILURE)
 
Screen()
VerifyWebSite_URL()

def Screen() {
if (Mobile.verifyElementVisible(findTestObject('Object Repository/Non Login Functionality/Oficinas, Cajeros y SAB'),GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE))
	{
		
		Mobile.tap(findTestObject('Object Repository/Non Login Functionality/Oficinas, Cajeros y SAB'), GlobalVariable.timeOut_15_sec)
		Mobile.delay(20)
		if(Mobile.waitForElementPresent(findTestObject('Object Repository/Non Login Functionality/EditText - popularenlinea.com'), GlobalVariable.timeOut_10_Sec, FailureHandling.STOP_ON_FAILURE)) 
			{   
				
				    VerifyWebSite_URL()
					
			}
		else 
			{
			                
				        KeywordUtil.markFailed('URL Heading  Not Found')
			
		     }	
	}
	
	
}	
	


def VerifyWebSite_URL() {
	
	if (Mobile.waitForElementPresent(findTestObject('Object Repository/Non Login Functionality/EditText - popularenlinea.com'),30, FailureHandling.CONTINUE_ON_FAILURE)) {
		Mobile.takeScreenshot(FailureHandling.CONTINUE_ON_FAILURE)
		
		String URL = Mobile.getText(findTestObject('Object Repository/Non Login Functionality/EditText - popularenlinea.com'), 5,FailureHandling.OPTIONAL)
	
		println('URL IS ' + URL)
	
		String Expected = 'https://www.popularenlinea.com/personas/Paginas/branches.aspx'
		
		
		if (URL.equals(Expected)) {
			KeywordUtil.markPassed('URL Is Matching...!!!')
		}
		 else  {
			KeywordUtil.markWarning('URL Is Not Matching...!!!')
		}
		
		
	} else {
		Mobile.takeScreenshot(FailureHandling.CONTINUE_ON_FAILURE)
		KeywordUtil.markFailed('Popular en linea Screen Not Available - Terminating The Test Case...!!!')
		
		
	}

	}
Mobile.pressBack()

//def BackOnScreen1()
// {
//	 if(Mobile.verifyElementVisible(findTestObject('Object Repository/Non Login Functionality/android.widget.ImageViewArrow'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
//		Mobile.tap(findTestObject('Object Repository/Non Login Functionality/android.widget.ImageViewArrow'),GlobalVariable.timeOut_2_Sec , FailureHandling.OPTIONAL)
//		
//			KeywordUtil.markPassed('Successfully Back on Swipeble Screen !!!')
//			 
//	 }
//	
//}








