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
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import io.appium.java_client.AppiumDriver
import io.appium.java_client.TouchAction
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.annotation.Keyword
import io.appium.java_client.touch.offset.PointOption
import io.appium.java_client.touch.offset.ElementOption
import internal.GlobalVariable
import io.appium.java_client.MobileElement

//Mobile.startApplication(GlobalVariable.appPath, false, FailureHandling.STOP_ON_FAILURE)
Mobile.delay(10)
//Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Accesso Screen/Popular Logo new'),GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)
//Mobile.tap(findTestObject('Object Repository/Non Login Functionality/SideMenuIcon'),GlobalVariable.timeOut_5_Sec , FailureHandling.STOP_ON_FAILURE)
		
VerifyContactScreen() //1
VerifyMobile()       //2
BackOnScreen()       //3

	

def VerifyContactScreen() {
	if (Mobile.verifyElementVisible(findTestObject('Object Repository/Non Login Functionality/digital logo'),GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)) 
	{	
		KeywordUtil.markPassed(' Antidad Auorizada Image is visible!!!')
		Mobile.tap(findTestObject('Object Repository/Non Login Functionality/Contctenos'), GlobalVariable.timeOut_2_Sec)
	
	    if(Mobile.verifyElementVisible(findTestObject('Object Repository/Non Login Functionality/android.widget.TextView - (809) 544-5110 phone No'),GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)) 
		    {
			
				VerifyMobile()
				
	         }
			
			    else {
				
				      Mobile.takeScreenshot(FailureHandling.CONTINUE_ON_FAILURE)
				      KeywordUtil.markFailed(' Phone No  Is Not Displaying...!!!')
					  
			        }
				
				
		
	}
	}	
	

def VerifyMobile() {
	String MobileNum
	
	if(Mobile.waitForElementPresent(findTestObject('Object Repository/Non Login Functionality/android.widget.TextView - (809) 544-5110 phone No'),
		GlobalVariable.timeOut_5_Sec, FailureHandling.CONTINUE_ON_FAILURE)) {
		MobileNum = Mobile.getText(findTestObject('Object Repository/Non Login Functionality/android.widget.TextView - (809) 544-5110 phone No'), GlobalVariable.timeOut_2_Sec, FailureHandling.CONTINUE_ON_FAILURE)
	} 
	
	String UpdatedMobile = MobileNum.replaceAll("[\\s\\-()]", "")
	long MobileNumber = Long.parseLong(UpdatedMobile)
	println "Mobile Number For Fraud Reporting Is : " + MobileNumber
	long Expected = GlobalVariable.Phone_No;

	if(MobileNumber.equals(Expected)) {
		KeywordUtil.markPassed(" Mobile Number Validation Sucessfull...!!!")
	} else {
		KeywordUtil.markFailed(" Mobile Number Validation Failed...!!!")
	}
} 

def BackOnScreen() {
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Non Login Functionality/android.widget.FrameLayout -Contact Screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.STOP_ON_FAILURE)) {
	Mobile.tap(findTestObject('Object Repository/Non Login Functionality/android.widget.Button - CANCELAR'),GlobalVariable.timeOut_4_Sec )
}
}