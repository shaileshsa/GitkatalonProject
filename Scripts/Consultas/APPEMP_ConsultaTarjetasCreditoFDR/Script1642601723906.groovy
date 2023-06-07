import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//check for multiple company
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company)

//tap cuentas
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterCuentaoption', 'Cuentas')

//Tap Prestamos
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterPrestamosoption', 'Préstamos')

//tap Tarjetas
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterTarjetasoption', 'Tarjetas')

//check permission tarjeta and selection of account + tap pagar/transfer
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', account, 'Object Repository/Pagos/Tarjeta/Tarjeta Dashboard', 'Object Repository/Pagos/Tarjeta/Tarjeta Detail Heading', 'Object Repository/Pagos/Tarjeta/Pagar in Tarjeta', company, 'US', GlobalVariable.ID+':id/balanceALaFecha')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Tarjeta/Status Button')

//Tap button Estados
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Tarjeta/Status Button', 'Object Repository/Consultas/Tarjeta/Status Button')

//Tap Trans. despus del corte
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Tarjeta/Trans. despus del corte Button', 'Object Repository/Consultas/Tarjeta/Trans. despus del corte Button')

//error check
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_20_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	KeywordUtil.markWarning('*****SERVICE ERROR*****')
	//tap back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
	//check screen
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/Status Button'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
		//Tap button Estados
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Tarjeta/Status Button', 'Object Repository/Consultas/Tarjeta/Status Button')
	}
} else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/No Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****NO TRANSACTION*****')
	//Tap Back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
} else {
//Tap Back
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
}

//Tap ltimo estado
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Tarjeta/Ltimo Estado Button', 'Object Repository/Consultas/Tarjeta/Ltimo Estado Button')

//error check
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_20_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	KeywordUtil.markWarning('*****SERVICE ERROR*****')
	//tap back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
	//check screen
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/Status Button'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
		//Tap button Estados
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Tarjeta/Status Button', 'Object Repository/Consultas/Tarjeta/Status Button')
	}
} else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/No Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****NO TRANSACTION*****')
	//Tap Back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
} else {
//Tap Back
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
}

//Tap Penltimo estado
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Tarjeta/Penltimo estado Button', 'Object Repository/Consultas/Tarjeta/Penltimo estado Button')

//error check
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_20_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	KeywordUtil.markWarning('*****SERVICE ERROR*****')
	//tap back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
	//check screen
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/Status Button'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
		//Tap button Estados
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Tarjeta/Status Button', 'Object Repository/Consultas/Tarjeta/Status Button')
	}
} else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/No Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****NO TRANSACTION*****')
	//Tap Back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
} else {
//Tap Back
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
}

//Tap Antepenltimo estado
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Tarjeta/Antepenltimo estado Button', 'Object Repository/Consultas/Tarjeta/Antepenltimo estado Button')

//error check
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_20_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	KeywordUtil.markWarning('*****SERVICE ERROR*****')
	//Tap Back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
	//check screen
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/Status Button'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
		//Tap button Estados
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Tarjeta/Status Button', 'Object Repository/Consultas/Tarjeta/Status Button')
	}
} else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/No Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****NO TRANSACTION*****')
	//Tap Back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
} else {
//Tap Back
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
}
	
//Tap Back
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Tarjeta/Status Button')
	
//Tap Back to home 
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')


