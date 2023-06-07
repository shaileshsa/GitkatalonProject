import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//tap Burger Menu
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')

//tap option Pagos
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Impuestos/Pagos In Burger Menu', 'Object Repository/Pagos/Impuestos/Pagos In Burger Menu')

//tap Sub Option Impuestos
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Impuestos/Impuestos in Burger Menu', 'Object Repository/Pagos/Impuestos/Impuestos in Burger Menu')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Impuestos/Pago De Impuestos Heading')

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()

//Tap Beneficiario
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickAfterRegistration'('Pagos/android.widget.TextView - Pago de Impuestos', 'Object Repository/Pagos/Seleccionar Beneficiario Impuestos')

//Select DGII
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

if (driver.findElementsById(GlobalVariable.ID + ':id/textLabel').size() > 0) {
	ArrayList<String> elements = new ArrayList<String>()

	elements = driver.findElementsById(GlobalVariable.ID + ':id/textLabel')

	(elements[0]).click()
}

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()

//scroll to ref number
Mobile.scrollToText('Ingresar número de referencia', FailureHandling.OPTIONAL)


//set ref number
Mobile.setText(findTestObject('Object Repository/Pagos/Impuestos/Referencia Number Field'), ref_number, GlobalVariable.timeOut_1_Sec)
//scroll to continuar
//Mobile.scrollToText('Continuar')

//tap continue
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Impuestos/Validation Heading')

//tap account selection button
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Impuestos/Account Selection Heading', 'Object Repository/Pagos/Impuestos/Account selector')

//select account
if (driver.findElementsById(GlobalVariable.ID + ':id/linFilter').size() > 0) {
	//Search Account
	Mobile.setText(findTestObject('Object Repository/Common Objects/Search Account Field/Search Account Field - 2'), desde, GlobalVariable.timeOut_2_Sec)
	List<WebElement> element = driver.findElementsById(GlobalVariable.ID + ':id/imgarrowup')

	if (element.size() > 1) {
		//company selection code here
		CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_two)

		//check for no account
		if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
			CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
		}
		
		CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','RD')
	} else {
		if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
			CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
		}
		CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','RD')
	}
} else {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}

//tap continue
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
//CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Selection Desde Impuestos')
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Impuestos/Validation Payment Heading')

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Set Token
Mobile.setText(findTestObject('Object Repository/Pagos/Impuestos/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)

//tap continue
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Impuestos/Popular Logo Receipt Screen')
//CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/deprecated/Su solicitud ha sido sometida temporory')

//tap continue
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')

def goBackFromAccountSelectionImpuestos(){
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	ArrayList<String> tapElement = new ArrayList<String>()
	Mobile.takeScreenshot();
	tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
	tapElement[0].click()
	CustomKeywords.'com.appEmpresarial.helperCommonAction.AcceptButton'()
	//error check
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
		Mobile.takeScreenshot();
		CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard')
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
		CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	}
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard')
	}
//mark fail
KeywordUtil.markFailedAndStop('*****NO GIVEN ACCOUNTS VISIBLE IN LIST*****')
}