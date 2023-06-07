import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

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

//tap burger menu
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')

//tap option Pagos
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Tarjeta/Pagos In Burger Menu', 'Object Repository/Pagos/Tarjeta/Pagos In Burger Menu')

//tap Sub Option Tarjeta
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Tarjeta/Tarjetas in Burger Menu', 'Object Repository/Pagos/Tarjeta/Tarjetas in Burger Menu')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Tarjeta/Pago a Tarjeta Heading')

//tap desde
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Tarjeta/Pago a Tarjeta Heading', 'Object Repository/Pagos/Tarjeta/Desde')

//select desde
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
if (driver.findElementsById(GlobalVariable.ID + ':id/linFilter').size() > 0) {
    //Search Account
    Mobile.setText(findTestObject('Object Repository/Common Objects/Search Account Field/Search Account Field - 2'), desde, GlobalVariable.timeOut_2_Sec)
    List<WebElement> element = driver.findElementsById(GlobalVariable.ID + ':id/imgarrowup')

    if (element.size() > 1) {
        //company selection code here
        CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_one)

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
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Tarjeta/Pago a Tarjeta Heading')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtDesdeAccDetail',GlobalVariable.ID+':id/txtDesdeBalance')

//tap hasta
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Pagos/Tarjeta/Pago a Tarjeta Heading', 'Object Repository/Pagos/Tarjeta/Hasta')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Search Account Field/Search Account Field - 2')

//select hasta
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
        
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', hasta, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','US')
    } else {
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        } 
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', hasta, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','US')
    }
} else {
    CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Tarjeta/Pago a Tarjeta Heading')

//data check
//CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtPresamoAccdetails',GlobalVariable.ID+':id/txtCCBalance')

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
//CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID+':id/btnContinuar', 'Pagar', GlobalVariable.ID+':id/txtDesdeCuenta', GlobalVariable.ID+':id/txtBeneficiario','')

//tap Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Set Token
Mobile.setText(findTestObject('Object Repository/Pagos/Tarjeta/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)

//tap Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Tarjeta/Popular Logo Receipt Screen')
//CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/deprecated/green tick temporory')

//tap continuarv2
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')

