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

Mobile.startApplication(GlobalVariable.appPath, false, FailureHandling.STOP_ON_FAILURE)
Mobile.delay(5)
//uncomment for single test case
Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Accesso Screen/Popular Logo new'),GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Non Login Functionality/SideMenuIcon'),GlobalVariable.timeOut_5_Sec , FailureHandling.STOP_ON_FAILURE)
	
Verify_Tasa_De_Cambio()
VerifyCurrency_Dollar()
VerifyCurrency_Euro()


def Verify_Tasa_De_Cambio() {
	if (Mobile.verifyElementVisible(findTestObject('Object Repository/Non Login Functionality/android.widget.TextView - Tasa de cambio'), GlobalVariable.timeOut_10_Sec, FailureHandling.STOP_ON_FAILURE)) {
		KeywordUtil.markPassed('Tasa de cambio Screen Is Displaying...!!!')
		Mobile.tap(findTestObject('Object Repository/Non Login Functionality/android.widget.TextView - Tasa de cambio'), 3)
		
		if (Mobile.waitForElementPresent(findTestObject('Object Repository/Non Login Functionality/android.widget.TextView - Tasa de cambio-Title'),30, FailureHandling.CONTINUE_ON_FAILURE)) {
			Mobile.takeScreenshot(FailureHandling.CONTINUE_ON_FAILURE)
			KeywordUtil.markPassed('Tasa de cambio Screen Is Displaying...!!!')
			VerifyCurrency_Dollar()
			VerifyCurrency_Euro()
			
			
		}  else {
			Mobile.takeScreenshot(FailureHandling.CONTINUE_ON_FAILURE)
			KeywordUtil.markWarning('Tasa de cambio Screen Is Not Displaying...!!!')
		}
		
	}  else {
		Mobile.takeScreenshot(FailureHandling.CONTINUE_ON_FAILURE)
		KeywordUtil.markWarning('Tasa de cambio Screen Is Not Displaying...!!!')
	}
		
		
		
	}

def VerifyCurrency_Dollar() {
	
	float Amount = 1.00
	String Dollar_Compra = Mobile.getText(findTestObject('Object Repository/Non Login Functionality/54.90'),GlobalVariable.timeOut_10_Sec )
	String Dollar_Venta = Mobile.getText(findTestObject('Object Repository/Non Login Functionality/56.60'), GlobalVariable.timeOut_10_Sec)
	
	String Dollar_Compra_Updated = Dollar_Compra.substring(3)
	String Dollar_Venta_Updated = Dollar_Venta.substring(3)
	
	float Final_Dollar_Compra = Float.parseFloat(Dollar_Compra_Updated)
	float Final_Dollar_Venta = Float.parseFloat(Dollar_Venta_Updated)
	
	println "Dollar Compra Value Is " + Final_Dollar_Compra
	println "Dollar Venta Value Is " + Final_Dollar_Venta
	
	Mobile.verifyNotEqual(Final_Dollar_Compra, Amount, FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.verifyNotEqual(Final_Dollar_Venta, Amount, FailureHandling.CONTINUE_ON_FAILURE)

	
}

def VerifyCurrency_Euro() {
	
	float Amount = 1.00
	String Euro_Compra = Mobile.getText(findTestObject('Object Repository/Non Login Functionality/57.40'), GlobalVariable.timeOut_10_Sec)
	String Euro_Venta = Mobile.getText(findTestObject('Object Repository/Non Login Functionality/61.00'), GlobalVariable.timeOut_10_Sec)
	
	String Euro_Compra_Updated = Euro_Compra.substring(3)
	String Euro_Venta_Updated = Euro_Venta.substring(3)
	
	float Final_Euro_Compra = Float.parseFloat(Euro_Compra_Updated)
	float Final_Euro_Venta = Float.parseFloat(Euro_Venta_Updated)
	
	println "Euro Compra Value Is " + Final_Euro_Compra
	println "Euro Venta Value Is " + Final_Euro_Venta
	
	Mobile.verifyNotEqual(Final_Euro_Compra, Amount,FailureHandling.CONTINUE_ON_FAILURE)
	Mobile.verifyNotEqual(Final_Euro_Venta, Amount,FailureHandling.CONTINUE_ON_FAILURE)
	
}
Mobile.pressBack()