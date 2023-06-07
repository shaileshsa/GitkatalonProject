import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.offset.ElementOption

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//check for multiple company
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_one)

//Tap Cuentas
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterCuentaoption', 'Cuentas')
		
//check permission cuenta and selection of account + tap pagar/transfer
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtDisponible', GlobalVariable.ID+':id/txtAccType', 'RD', 'Object Repository/Transferencias/Entre Cuenta/Cuentas Dashboard', 'Object Repository/Pagos/android.widget.TextView - Detalle Cuenta', 'Object Repository/Transferencias/Entre Cuenta/Transfer in Cuenta', company_one)
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', desde, 'Object Repository/Pagos/Impuestos/Cuentas Dashboard', 'Object Repository/Pagos/Impuestos/Cuenta Detail Heading', 'Object Repository/Pagos/Impuestos/Pagar in Cuenta', company_one, 'RD', GlobalVariable.ID+':id/txtDisponible')
		
//tap Impuestos
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Impuestos/Impuestos in Cuenta', 'Object Repository/Pagos/Impuestos/Impuestos in Cuenta')

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