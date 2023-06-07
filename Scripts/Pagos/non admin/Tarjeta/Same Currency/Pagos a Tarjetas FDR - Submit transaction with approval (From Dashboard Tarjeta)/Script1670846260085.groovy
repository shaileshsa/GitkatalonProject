import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import io.appium.java_client.MobileElement as MobileElement

import org.openqa.selenium.WebElement
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
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
//CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterPrestamosoption', 'Préstamos')

//swipe right to left
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

MobileElement Element = driver.findElement(By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'Préstamos' or . = 'Préstamos') and @resource-id = 'com.popular.app.corp:id/filterPrestamosoption']"))

int startX = Element.getLocation().getX()
int startY = Element.getLocation().getY()
int endX = 1
int endY = startY
Mobile.swipe(startX, startY, endX, endY, FailureHandling.OPTIONAL)

//tap cards
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterTarjetasoption', 'Tarjetas')

//check permission tarjeta and selection of account + tap pagar/transfer
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtDisponible', GlobalVariable.ID+':id/txtAccType', 'USD', 'Object Repository/Pagos/Tarjeta/Tarjeta Dashboard', 'Object Repository/Pagos/Tarjeta/Tarjeta Detail Heading', 'Object Repository/Pagos/Tarjeta/Pagar in Tarjeta', company_one)
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', hasta, 'Object Repository/Pagos/Tarjeta/Tarjeta Dashboard', 'Object Repository/Pagos/Tarjeta/Tarjeta Detail Heading', 'Object Repository/Pagos/Tarjeta/Pagar in Tarjeta', company_one, 'US', GlobalVariable.ID+':id/balanceALaFecha')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Tarjeta/Pago a Tarjeta Heading')

//tap desde
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Tarjeta/Pago a Tarjeta Heading', 'Object Repository/Pagos/Tarjeta/Desde')
	
//select desde
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
        
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','US')
    } else {
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        } 
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','US')
    }
} else {
    CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Tarjeta/Pago a Tarjeta Heading')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtDesdeAccDetail',GlobalVariable.ID+':id/txtDesdeBalance')
	
//scroll to continuar
Mobile.scrollToText('Continuar')

//Set Monto Pagar Amount
if(Mobile.waitForElementPresent(findTestObject('Object Repository/Pagos/Tarjeta/Select Other Amount'), GlobalVariable.timeOut_5_Sec, FailureHandling.OPTIONAL))
{
	  Mobile.tap(findTestObject('Object Repository/Pagos/Tarjeta/Select Other Amount'), GlobalVariable.timeOut_5_Sec, FailureHandling.OPTIONAL)

	  //Set amount
	  if(driver.findElementsById(GlobalVariable.ID+':id/textAmountFour').size() > 0) {
	  ArrayList<String> elements = new ArrayList<String>();
	  elements = driver.findElementsById(GlobalVariable.ID+':id/textAmountFour')
	  (elements[0]).sendKeys(amount)
	   Mobile.takeScreenshot()
	  }
 
}

else
{
	 Mobile.waitForElementPresent(findTestObject('Object Repository/Pagos/Tarjeta/RD New'), GlobalVariable.timeOut_5_Sec, FailureHandling.OPTIONAL)
	 if(driver.findElementsById(GlobalVariable.ID+':id/textAmountFour').size() > 0) {
	 ArrayList<String> elements = new ArrayList<String>();
	 elements = driver.findElementsById(GlobalVariable.ID+':id/textAmountFour')
	 (elements[0]).sendKeys(amount)
	 Mobile.takeScreenshot()
	 }
}

//tap Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Tarjeta/Verificacin Heading')

//data save and tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID+':id/btnContinuar', 'Someter', GlobalVariable.ID+':id/txtDesdeCuenta', GlobalVariable.ID+':id/txtBeneficiario','')

//tap Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Set Token
Mobile.setText(findTestObject('Object Repository/Pagos/Tarjeta/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)

//tap Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Tarjeta/Popular Logo Receipt Screen')
//CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/deprecated/Su solicitud ha sido sometida temporory')

//tap continuarv2
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
