import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//tap Burger Menu
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')

//tap cheque depsoit
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Cheque Deposit/DEPSITO DE CHEQUES Button', 'Object Repository/Cheque Deposit/DEPSITO DE CHEQUES Button')

//intial tutorial
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Cheque Deposit/Seleccione la cuenta a la cual desea depositar su cheque y digite el monto del mismo'), GlobalVariable.timeOut_15_sec, FailureHandling.OPTIONAL)==true) {
	//check error
	CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Cheque Deposit/Seleccione la cuenta a la cual desea depositar su cheque y digite el monto del mismo')
	
	//tap skip
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Cheque Deposit/Skip', 'Object Repository/Cheque Deposit/Skip')
	
	//check error
	CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Cheque Deposit/Terms and Condition Page')
	
	//tap checkbox
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Cheque Deposit/CheckBox', 'Object Repository/Cheque Deposit/CheckBox')
	
	//tap acepto
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Cheque Deposit/Acepto Button', 'Object Repository/Cheque Deposit/Acepto Button')
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Cheque Deposit/DEPSITO DE CHEQUES Heading')

//select depositar
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Cheque Deposit/Depositar Button', 'Object Repository/Cheque Deposit/Depositar Button')

//select account
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
if (driver.findElementsById(GlobalVariable.ID + ':id/linFilter').size() > 0) {
	//Search Account
	Mobile.setText(findTestObject('Object Repository/Cheque Deposit/Search Account Cheque Deposit'), desde, GlobalVariable.timeOut_2_Sec)
	List<WebElement> element = driver.findElementsById(GlobalVariable.ID + ':id/imgarrowup')

	if (element.size() > 1) {
		//company selection code here
		CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_one)

		//check for no account
		if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
			goBack()
		}
		
		CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible')
	} else {
		if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
			goBack()
		}
		CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible')
	}
} else {
	goBack()
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Cheque Deposit/DEPSITO DE CHEQUES Heading')

//set amount
Mobile.setText(findTestObject('Object Repository/Cheque Deposit/Set Amount'), amount, 30)
Mobile.takeScreenshot()
	
//capture image
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Cheque Deposit/DEPSITO DE CHEQUES Heading', 'Object Repository/Cheque Deposit/Capture Image')




def goBack() { 
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	ArrayList<String> tapElement = new ArrayList<String>();
	tapElement = driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow')
	tapElement[0].click()
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
		CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	}
	tapElement = driver.findElementsById(GlobalVariable.ID+':id/txtcancel')
	tapElement[0].click()
	//Error check
	CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard')
	KeywordUtil.markFailedAndStop('*****NO ACCOUNT VISIBLE IN LIST/GIVEN COMPANY OR ACCOUNT NOT FOUND*****')
}