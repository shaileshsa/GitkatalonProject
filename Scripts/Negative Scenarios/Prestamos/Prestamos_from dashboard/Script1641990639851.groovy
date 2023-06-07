import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//check for multiple company
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_one)

//tap prestamo
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterPrestamosoption', 'Préstamos')

//check permission prestamo and selection of account + tap pagar/transfer
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/lblTransitos', GlobalVariable.ID+':id/txtAccType', 'RD', 'Object Repository/Pagos/android.widget.TextView - Prstamos Dashboard', 'Object Repository/Pagos/android.widget.TextView - Detalle Prstamo', 'Object Repository/Pagos/android.widget.LinearLayout - Pagar', company_one)
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', hasta, 'Object Repository/Pagos/Prestamos/Prestamos Dashboard', 'Object Repository/Pagos/Prestamos/Prestamo Detail Heading', 'Object Repository/Pagos/Prestamos/Pagar In Prestamos', company_one, 'RD', GlobalVariable.ID+':id/txtDisponible')
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccNumber', GlobalVariable.ID+':id/txtAccNumber', hasta, 'Object Repository/Pagos/Prestamos/Prestamos Dashboard', 'Object Repository/Pagos/Prestamos/Prstamo Detail Headings', 'Object Repository/Pagos/Prestamos/Pagar in Presatamo1', company_one, 'RD', GlobalVariable.ID+':id/txtBalanceFecha')

//select prestamo
//CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Prestamos/Prestamo in Cuenta', 'Object Repository/Pagos/Prestamos/Prestamo in Cuenta')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Prestamos/Pago a Prestamo Heading')

//tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()

//tap desde
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickAfterRegistration'('Object Repository/Pagos/Prestamos/Pago a Prestamo Heading', 'Object Repository/Pagos/Prestamos/Desde')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Prestamos/Pago a Prestamo Heading', 'Object Repository/Pagos/Prestamos/Desde')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Search Account Field/Search Account Field - 2')

//select desde
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
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

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Prestamos/Pago a Prestamo Heading')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtDesdeAccDetail',GlobalVariable.ID+':id/txtDesdeBalance')

//tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()

//scroll to continuar
Mobile.scrollToText('Continuar')

//tap Radio Button - Otro Monto
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Prestamos/Select Other Amount', 'Object Repository/Pagos/Prestamos/Select Other Amount')

//Set amount -> 0
if(driver.findElementsById(GlobalVariable.ID+':id/otherRowEditText').size() > 0) {
ArrayList<String> elements = new ArrayList<String>();
elements = driver.findElementsById(GlobalVariable.ID+':id/otherRowEditText')
(elements[0]).sendKeys('0')
Mobile.takeScreenshot()
      if('false'.equals(Mobile.getAttribute(findTestObject('Object Repository/Common Objects/Continuar Button/continue button 12'), 'clickable', 2)))
	       {
		       KeywordUtil.markWarning('Continuar Button Is Enable...!!!')
	       }
      else
	       {
		       KeywordUtil.markPassed('Continuar Button Is Disable...!!!')
	       }
		      (elements[0]).clear();
		      (elements[0]).sendKeys(Amount)
		      Mobile.takeScreenshot()
	
}

//tap Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()
/*
//Set amount 
if(driver.findElementsById(GlobalVariable.ID+':id/editMonto').size() > 0) {
ArrayList<String> elements = new ArrayList<String>();
elements = driver.findElementsById(GlobalVariable.ID+':id/editMonto')
(elements[3]).click();
(elements[3]).clear();
(elements[3]).sendKeys(Amount)
Mobile.takeScreenshot()
}
*/
//tap Continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Prestamos/Verificacin Heading')

//data save and tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Set Token
Mobile.setText(findTestObject('Object Repository/Pagos/Prestamos/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)

//tap Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Prestamos/Popular Logo Receipt Screen')

//data check
//CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtdesdeCuenta', GlobalVariable.ID+':id/txthastaCuenta')

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Check Error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
