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

//check permission tarjeta and selection of account + tap pagar/transfer
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', account, 'Object Repository/Transferencias/Entre Cuenta/Cuentas Dashboard', 'Object Repository/Transferencias/Entre Cuenta/Cuenta Detail Heading', 'Object Repository/Transferencias/Entre Cuenta/Cuenta Detail Heading', company, 'RD', GlobalVariable.ID+':id/txtDisponible')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Entre Cuenta/Detalle Cuenta Heading')

//Tap button Estados
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Despus del corte')

//Tap Trans. despus del corte
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Despus del corte', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Despus del corte')

//error check
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_20_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	KeywordUtil.markWarning('*****SERVICE ERROR*****')
	//tap back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
	//check screen
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
		//Tap button Estados
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button')
	}
} else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/No Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****NO TRANSACTION*****')
	//Tap Back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
} else {
	KeywordUtil.markPassed('*****Historical list Is Available*****')
}

//Tap button Estados
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button')

//Tap ltimo estado
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/ltimo estado Button', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/ltimo estado Button')

//error check
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_20_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	KeywordUtil.markWarning('*****SERVICE ERROR*****')
	//check screen
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
		//Tap button Estados
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button')
	}
} else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/No Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****NO TRANSACTION*****')
	//Tap Back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
} else {
	KeywordUtil.markPassed('*****Historical list Is Available*****')
}

//Tap button Estados
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button')

//Tap Penltimo estado
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Penltimo estado', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Penltimo estado')

//error check
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_20_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	KeywordUtil.markWarning('*****SERVICE ERROR*****')
	//check screen
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
		//Tap button Estados
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button')
	}
} else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/No Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****NO TRANSACTION*****')
	//Tap Back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
} else {
	KeywordUtil.markPassed('*****Historical list Is Available*****')
}

//Tap button Estados
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button')

//Tap Antepenltimo estado
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Antepenltimo estado', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Antepenltimo estado')

//error check
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_20_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	KeywordUtil.markWarning('*****SERVICE ERROR*****')
	//check screen
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
		//Tap button Estados
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button', 'Object Repository/Consultas/Entre Cuenta/Cuenta Status/Ver ltimos Status Button')
	}
} else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Tarjeta/No Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****NO TRANSACTION*****')
	//Tap Back
	CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
} else {
	KeywordUtil.markPassed('*****Historical list Is Available*****')
}

//Tap Back to home
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')


