import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//tap burger menu
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')

//tap transfer
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Terceros/Transfer in Burger Menu', 'Object Repository/Transferencias/Terceros/Transfer in Burger Menu')

//tap terceros
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Terceros/Tercero in Burger Menu', 'Object Repository/Transferencias/Terceros/Tercero in Burger Menu')

//take screenshot
Mobile.takeScreenshot();
			
//tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
			
//handle error
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()
	
//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Transferencias A Tercero Headings')

//tap desde
CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickAfterRegistration'('Object Repository/Transferencias/Terceros/Desde tercero', 'Object Repository/Transferencias/Terceros/Desde tercero')
			
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
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Transferencias A Tercero Headings')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtFromAccDetails',GlobalVariable.ID+':id/txtFromAccBalance')

//take screenshot
Mobile.takeScreenshot();
			
//tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()
			
//tap beneficiario
CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickAfterRegistration'('Object Repository/Transferencias/Terceros/Beneficiario in Tercero', 'Object Repository/Transferencias/Terceros/Beneficiario in Tercero')
			
//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Buscar Field')

//select beneficiario
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
		
//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheckTwo'(GlobalVariable.ID+':id/txtToAccDetails')
			
//tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()
			
//set amount
Mobile.setText(findTestObject('Object Repository/Transferencias/Terceros/Digite el monto Button'), '0', GlobalVariable.timeOut_2_Sec)
Mobile.takeScreenshot()
			
//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()
			
//clear amount
ArrayList<String> amount = new ArrayList<String>();
amount = driver.findElementsById(GlobalVariable.ID+':id/editTextAmount')
amount[0].click();
amount[0].clear();

//set amount
Mobile.setText(findTestObject('Object Repository/Transferencias/Terceros/Digite el monto Button'), Amount, 30);
Mobile.takeScreenshot();

//set Description
if(	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Description Box/Description Heading Tercero'), GlobalVariable.timeOut_1_Sec,FailureHandling.OPTIONAL))
 {
	    //tap on Checkbox
	    Mobile.tap(findTestObject('Object Repository/Common Objects/Description Box/Description Checkbox Tercero'), GlobalVariable.timeOut_1_Sec)
	    //set Description TextField
	    Mobile.setText(findTestObject('Object Repository/Common Objects/Description Box/Description Box Tercero'), Description, 2)
  }
else
	 {
	     KeywordUtil.markWarning('*****Description Field Not Available*****')
     }

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
			
//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Verification Headings')

//take screenshot
Mobile.takeScreenshot();
			
//data save and tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//set token
Mobile.setText(findTestObject('Object Repository/Transferencias/Terceros/Enter Token Field'), GlobalVariable.token, 30)

//take screenshot
Mobile.takeScreenshot();
			
//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//take screenshot
Mobile.takeScreenshot();
			
//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Popular Logo Receipt Screen')

//data check
//CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtdesdeCuenta', GlobalVariable.ID+':id/txthastaCuenta')
			
//scroll to continue
Mobile.scrollToText('Continuar')
			
//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
