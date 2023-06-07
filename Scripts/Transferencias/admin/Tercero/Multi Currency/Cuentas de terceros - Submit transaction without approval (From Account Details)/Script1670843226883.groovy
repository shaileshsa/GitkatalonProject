import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//check for multiple company
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company)

//Tap Cuentas
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterCuentaoption', 'Cuentas')

//check permission cuenta and selection of account + tap pagar/transfer
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtDisponible', GlobalVariable.ID+':id/txtAccType', 'RD', 'Object Repository/Transferencias/Terceros/Cuentas Dashboard', 'Object Repository/Transferencias/Terceros/Cuenta Detail Heading', 'Object Repository/Transferencias/Terceros/Transfer in Cuenta', company)
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', desde, 'Object Repository/Transferencias/Terceros/Cuentas Dashboard', 'Object Repository/Transferencias/Terceros/Cuenta Detail Heading', 'Object Repository/Transferencias/Terceros/Transfer in Cuenta', company, 'US', GlobalVariable.ID+':id/txtDisponible')

//tap tercero
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Terceros/Tercero in Cuenta', 'Object Repository/Transferencias/Terceros/Tercero in Cuenta')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Transferencias A Tercero Headings')

//tap beneficiario
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Terceros/Beneficiario in Tercero', 'Object Repository/Transferencias/Terceros/Beneficiario in Tercero')
	
//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Buscar Field')

//select beneficiario
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
//search account
Mobile.setText(findTestObject('Transferencias/Terceros/Buscar Field'), beneficiario, 30)
if(driver.findElementsById(GlobalVariable.ID+':id/rel_cuenta').size() > 0) {
	//screenshot
	Mobile.takeScreenshot()
	//tap beneficiario
	CustomKeywords.'com.appEmpresarial.helperCommonAction.checkElementPresentTwo'(GlobalVariable.ID+':id/txtaccType')
} else {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Transferencias A Tercero Headings')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheckTwo'(GlobalVariable.ID+':id/txtToAccDetails')

//scroll to continuar
Mobile.scrollToText('Continuar')

//set amount
Mobile.setText(findTestObject('Object Repository/Transferencias/Terceros/Digite el monto Button'), amount, 30);
Mobile.takeScreenshot();

//set Description
if(	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Description Box/Description Heading Tercero'), GlobalVariable.timeOut_1_Sec,FailureHandling.OPTIONAL))
 {
	//tap on Checkbox
	Mobile.tap(findTestObject('Object Repository/Common Objects/Description Box/Description Checkbox Tercero'), GlobalVariable.timeOut_1_Sec)
	//set Description TextField
	Mobile.setText(findTestObject('Object Repository/Common Objects/Description Box/Description Box Tercero'), Description, 2)
	}
else {
	KeywordUtil.markWarning('*****Description Field Not Available*****')
}

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Verification Headings')

//data save and tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID+':id/btnContinuar', 'Continuar', GlobalVariable.ID+':id/txtCuentaTerceros', GlobalVariable.ID+':id/txtdesde','')
CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID+':id/buttonContinue', 'Transferir', GlobalVariable.ID+':id/textValue', GlobalVariable.ID+':id/textValue','')

//set token
Mobile.setText(findTestObject('Object Repository/Transferencias/Terceros/Enter Token Field'), GlobalVariable.token, 30)
Mobile.takeScreenshot()

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Popular Logo Receipt Screen')

//tap continuarv2
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Check Error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
