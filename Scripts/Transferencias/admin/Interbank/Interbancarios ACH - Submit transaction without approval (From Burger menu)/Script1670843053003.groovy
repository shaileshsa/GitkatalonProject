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

//tap burger menu
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')

//tap transfer
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/InterBank/Transfer in Burger Menu', 'Object Repository/Transferencias/InterBank/Transfer in Burger Menu')

//tap Interbancarios
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/InterBank/Interbank in Burger Menu', 'Object Repository/Transferencias/InterBank/Interbank in Burger Menu')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/InterBank/Transfercias in Interbank Headings')

//tap desde
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/InterBank/Desde Interbank', 'Object Repository/Transferencias/InterBank/Desde Interbank')

//select desde
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
if (driver.findElementsById(GlobalVariable.ID + ':id/linFilter').size() > 0) {
    //Search Account
    Mobile.setText(findTestObject('Object Repository/Common Objects/Search Account Field/Search Account Field - 2'), desde, GlobalVariable.timeOut_2_Sec)
    List<WebElement> element = driver.findElementsById(GlobalVariable.ID + ':id/imgarrowup')

    if (element.size() > 1) {
        //company selection code here
        CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company)

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
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/InterBank/Transfercias in Interbank Headings')

//tap beneficiario
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/InterBank/Interbank Beneficiary', 'Object Repository/Transferencias/InterBank/Interbank Beneficiary')
    
//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/InterBank/Buscar Field')

//select beneficiario
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
