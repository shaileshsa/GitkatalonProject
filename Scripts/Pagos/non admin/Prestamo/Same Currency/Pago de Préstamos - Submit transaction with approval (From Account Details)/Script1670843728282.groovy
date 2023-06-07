import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//check for multiple company
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_one)

//tap accounts
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterCuentaoption', 'Cuentas')

//check permission cuenta and selection of account + tap pagar/transfer
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtDisponible', GlobalVariable.ID+':id/txtAccType', 'RD', 'Object Repository/Login/android.widget.TextView - Cuentas', 'Object Repository/Pagos/android.widget.TextView - Detalle Cuenta', 'Object Repository/Pagos/Pagar in Cuenta', company_one)
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', desde, 'Object Repository/Pagos/Prestamos/Cuentas Dashboard', 'Object Repository/Pagos/Prestamos/Cuenta Detail Heading', 'Object Repository/Pagos/Prestamos/Pagar in Cuenta', company_one, 'RD', GlobalVariable.ID+':id/txtDisponible')
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', desde, 'Object Repository/Pagos/Prestamos/Cuentas Dashboard', 'Object Repository/Pagos/Prestamos/Cuenta Detail Heading', 'Object Repository/Pagos/Prestamos/Pagar in Cuenta', company_one, 'US', GlobalVariable.ID+':id/txtDisponible')

//select prestamo
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Prestamos/Prestamo in Cuenta', 'Object Repository/Pagos/Prestamos/Prestamo in Cuenta')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Prestamos/Pago a Prestamo Heading')

//tap hasta
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Prestamos/Pago a Prestamo Heading', 'Object Repository/Pagos/Prestamos/Hasta')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Search Account Field/Search Account Field - 2')

//select hasta
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
if (driver.findElementsById(GlobalVariable.ID + ':id/linFilter').size() > 0) {
    //Search Account
    Mobile.setText(findTestObject('Object Repository/Common Objects/Search Account Field/Search Account Field - 2'), hasta, GlobalVariable.timeOut_2_Sec)
    List<WebElement> element = driver.findElementsById(GlobalVariable.ID + ':id/imgarrowup')

    if (element.size() > 1) {
        //company selection code here
        CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_two)

        //check for no account
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        }
        
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', hasta, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','RD')
    } else {
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        } 
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', hasta, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','RD')
    }
} else {
    CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Prestamos/Pago a Prestamo Heading')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtPresamoAccdetails',GlobalVariable.ID+':id/txtLoanBalance')

//scroll to continuar
Mobile.scrollToText('Continuar')

//tap Radio Button - Otro Monto
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Prestamos/Select Other Amount', 'Object Repository/Pagos/Prestamos/Select Other Amount')

//Set amount
if(driver.findElementsById(GlobalVariable.ID+':id/otherRowEditText').size() > 0) {
ArrayList<String> elements = new ArrayList<String>();
elements = driver.findElementsById(GlobalVariable.ID+':id/otherRowEditText')
(elements[0]).sendKeys(amount)
Mobile.takeScreenshot()
}

//tap Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

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

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Check Error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
