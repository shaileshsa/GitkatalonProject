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

//Select DGII
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

if (driver.findElementsById(GlobalVariable.ID + ':id/textLabel').size() > 0) {
    ArrayList<String> elements = new ArrayList<String>()

    elements = driver.findElementsById(GlobalVariable.ID + ':id/textLabel')

    (elements[0]).click()

    Mobile.takeScreenshot()
}

//scroll to ref number
Mobile.scrollToText('Ingresar número de referencia', FailureHandling.OPTIONAL)

//set ref number
Mobile.setText(findTestObject('Object Repository/Pagos/Impuestos/Referencia Number Field'), ref_number, GlobalVariable.timeOut_1_Sec)

//tap continue
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Impuestos/Validation Heading')

/*//select desde
if(driver.findElementsById(GlobalVariable.ID+':id/textLabel').size() > 0) {
boolean flag = false
TouchAction touch = new TouchAction(driver)
ArrayList<String> elements = new ArrayList<String>();
	for (int a = 0; !(flag) && (a < 10000); a++) {
		elements = driver.findElementsById(GlobalVariable.ID+':id/textLabel')
		for(GlobalVariable.index2; GlobalVariable.index2 < elements.size(); (GlobalVariable.index2)++) {
			String value = elements[GlobalVariable.index2].getText();
			if(value.contains(desde)) {
				flag = true
				(elements[GlobalVariable.index2]).click()
				Mobile.takeScreenshot();
				break;
			}
		}
		
		if(!flag) {
			ArrayList<String> accountNameBefore = new ArrayList<String>();
			accountNameBefore = driver.findElementsById(GlobalVariable.ID+':id/textLabel')
			String beforeswipetop = (accountNameBefore[0]).getText().trim()
			String beforeswipebottom = (accountNameBefore[(accountNameBefore.size() - 1)]).getText().trim()
			
			if (GlobalVariable.index2.equals(elements.size())) {
				GlobalVariable.index2 = 0
				def bottomElement = ElementOption.element(elements[(elements.size() - 1)])
				def topElement = ElementOption.element(elements[0])
				touch.longPress(bottomElement).moveTo(topElement).release().perform()
			}
			
			ArrayList<String> accountNameAfter = new ArrayList<String>();
			accountNameAfter = driver.findElementsById(GlobalVariable.ID+':id/textLabel')
			String afterswipetop = (accountNameAfter[0]).getText().trim()
			String afterswipebottom = (accountNameAfter[(accountNameAfter.size() - 1)]).getText().trim()
	
			if(beforeswipetop.equals(afterswipetop) && beforeswipebottom.equals(afterswipebottom)) {
				goBackFromAccountSelectionImpuestos()
			}
		}
	}
} else {
	goBackFromAccountSelectionImpuestos()
}*/

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

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Impuestos/Validation Payment Heading')

//tap continue
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