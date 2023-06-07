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
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtDisponible', GlobalVariable.ID+':id/txtAccType', 'RD', 'Object Repository/Transferencias/InterBank/Cuentas Dashboard', 'Object Repository/Transferencias/InterBank/Cuenta Detail Heading', 'Object Repository/Transferencias/InterBank/Transfer in Cuenta', company)
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', desde, 'Object Repository/Transferencias/InterBank/Cuentas Dashboard', 'Object Repository/Transferencias/InterBank/Cuenta Detail Heading', 'Object Repository/Transferencias/InterBank/Transfer in Cuenta', company, 'RD', GlobalVariable.ID+':id/txtDisponible')

//tap interbancario
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/InterBank/Interbank in Cuenta', 'Object Repository/Transferencias/InterBank/Interbank in Cuenta')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/InterBank/Transfercias in Interbank Headings')

//tap beneficiario
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/InterBank/Interbank Beneficiary', 'Object Repository/Transferencias/InterBank/Interbank Beneficiary')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/InterBank/Buscar Field')

//select beneficiario
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
//search account
Mobile.setText(findTestObject('Object Repository/Transferencias/InterBank/Buscar Field'), beneficiario, 30)
if(driver.findElementsById(GlobalVariable.ID+':id/rel_cuenta').size() > 0) {
	//screenshot
	Mobile.takeScreenshot()
	//tap beneficiario
	CustomKeywords.'com.appEmpresarial.helperCommonAction.checkElementPresentTwo'(GlobalVariable.ID+':id/txtaccType')
} else {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/InterBank/Transfercias in Interbank Headings')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheckTwo'(GlobalVariable.ID+':id/txtToInterAccDetails')

//set amount
Mobile.setText(findTestObject('Object Repository/Transferencias/InterBank/Digite el monto Button'), amount, 30)

Mobile.takeScreenshot()

//scroll to continuar
Mobile.scrollToText('Continuar')

//tap ach
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/InterBank/ACH Button Interbank', 'Object Repository/Transferencias/InterBank/ACH Button Interbank')

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
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/InterBank/Verification Headings')

//data collect
//CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCollectForinterbank'(GlobalVariable.ID+':id/txtBeneficiary', GlobalVariable.ID+':id/txtDesdeAccountNumber', GlobalVariable.ID+':id/txtTipo', GlobalVariable.ID+':id/txtBalance', GlobalVariable.ID+':id/txtMontoComision', GlobalVariable.ID+':id/txtdebitar')

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//set token
Mobile.setText(findTestObject('Object Repository/Transferencias/InterBank/Enter Token Field'), GlobalVariable.token, 30)

Mobile.takeScreenshot()

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/InterBank/Popular Logo Receipt Screen')
//CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/deprecated/green tick temporory')

//data check
//CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheckForinterbank'(GlobalVariable.ID+':id/txtbeneficiry', GlobalVariable.ID+':id/txtdesdeCuenta', GlobalVariable.ID+':id/txttipodetransaction', GlobalVariable.ID+':id/txtfecha', GlobalVariable.ID+':id/txtImpeustos', GlobalVariable.ID+':id/txtRef')

//tap continuarv2
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Check Error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
