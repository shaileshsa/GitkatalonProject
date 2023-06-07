import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

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
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/lblTransitos', GlobalVariable.ID+':id/txtAccType', 'RD', 'Object Repository/Pagos/android.widget.TextView - Prstamos Dashboard', 'Object Repository/Pagos/android.widget.TextView - Detalle Prstamo', 'Desembolsos/android.widget.LinearLayout', company_one)
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', desde, 'Object Repository/Desembolsos/Prestamos Dashboard', 'Object Repository/Desembolsos/Detalle Prstamo Heading', 'Object Repository/Desembolsos/Desembolso In Prestamo', company_one, 'RD', GlobalVariable.ID+':id/txtDisponible')
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccNumber', GlobalVariable.ID+':id/txtAccNumber', desde, 'Object Repository/Desembolsos/Prestamos Dashboard', 'Object Repository/Desembolsos/Prstamo Detail Headings', 'Object Repository/Desembolsos/Desembolsos in presatamos flow', company_one, 'RD', GlobalVariable.ID+':id/txtBalanceFecha')

//check desembolso accessible or not
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
if(driver.findElementsById(GlobalVariable.ID+':id/disbursementLayout').size() > 0) {
	ArrayList<String> element = new ArrayList<String>();
	element = driver.findElementsById(GlobalVariable.ID + ':id/disbursementLayout');
	String dataOne =  element[0].getAttribute("enabled");
	if(dataOne.contains('false')) {
		CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
		Mobile.delay(5)
		Mobile.takeScreenshot();
		//error check
		CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
		KeywordUtil.markFailedAndStop('***** Desembolso is not accessible*****')
	}
}

//tap hasta
/*CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Desembolsos/Desembolsos Heading', 'Object Repository/Desembolsos/Hasta')

//select hasta
if (driver.findElementsById(GlobalVariable.ID + ':id/linFilter').size() > 0) {
    //Search Account
    Mobile.setText(findTestObject('Object Repository/Common Objects/Search Account Field/Search Account Field'), hasta, GlobalVariable.timeOut_2_Sec)
    List<WebElement> element = driver.findElementsById(GlobalVariable.ID + ':id/imgarrowup')

    if (element.size() > 1) {
        //company selection code here
        CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_two)

        //check for no account
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        }
        
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', hasta, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible')
    } else {
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        } 
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', hasta, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible')
    }
} else {
    CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}
*/
Mobile.takeScreenshot();

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Desembolsos/Desembolsos Heading')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtHastaAccDetail',GlobalVariable.ID+':id/txtHastaBalance')

//set amount
Mobile.setText(findTestObject('Object Repository/Desembolsos/Set Amounts'), amount, GlobalVariable.timeOut_4_Sec)

//select Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Desembolsos/Desembolsos Heading')

//select forma de pago
Mobile.takeScreenshot();
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Desembolsos/Forma De Pago', 'Object Repository/Desembolsos/Forma De Pago')

//select 12 meses
Mobile.takeScreenshot();
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Desembolsos/3 meses', 'Object Repository/Desembolsos/3 meses')

//select Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Desembolsos/Verificacin Heading')

//Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Set Token
Mobile.takeScreenshot();
Mobile.setText(findTestObject('Object Repository/Desembolsos/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)

//Continuar
Mobile.takeScreenshot();
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Desembolsos/Popular Logo Receipt Screen')

//Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
