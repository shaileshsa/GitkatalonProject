import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

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
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Entre Cuenta/Transfer in Burger Menu', 'Object Repository/Transferencias/Entre Cuenta/Transfer in Burger Menu')

//tap entre cuenta
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Entre Cuenta/Entre Cuenta In Burger Menu', 'Object Repository/Transferencias/Entre Cuenta/Entre Cuenta In Burger Menu')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Entre Cuenta/Transfercias Entre Cuenta in Headings')

//tap desde
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Entre Cuenta/Transfercias Entre Cuenta in Headings', 'Object Repository/Transferencias/Entre Cuenta/Desde Entre Cuenta')

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
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Entre Cuenta/Transfercias Entre Cuenta in Headings')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtFromAccDetailsTBA',GlobalVariable.ID+':id/txtFromAccBalanceTBA')

//tap hasta
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Entre Cuenta/Transfercias Entre Cuenta in Headings', 'Object Repository/Transferencias/Entre Cuenta/Entre Cuenta HASTA')

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
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Entre Cuenta/Transfercias Entre Cuenta in Headings')

//set amount
Mobile.setText(findTestObject('Object Repository/Transferencias/Entre Cuenta/Digital Monto Button'), amount, 30)
Mobile.takeScreenshot()
	
//set Description
if(	Mobile.verifyElementVisible(findTestObject('Object Repository/Transferencias/Entre Cuenta/Entre cuenta Description heading'), GlobalVariable.timeOut_1_Sec,FailureHandling.OPTIONAL))
 {
	//tap on Checkbox
	Mobile.tap(findTestObject('Object Repository/Transferencias/Entre Cuenta/Entre cuenta CheckBox'), GlobalVariable.timeOut_1_Sec)
	//set Description TextField
	Mobile.setText(findTestObject('Object Repository/Transferencias/Entre Cuenta/Entre cuenta description box'), Description, 2)
	}
else {
	KeywordUtil.markWarning('*****Description Field Not Available*****')
}

//scroll to continuar
Mobile.scrollToText('Continuar')
	
//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	
//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Entre Cuenta/Entre Cuenta Verification Heading')

//data save and tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID+':id/btnContinuar', 'Continuar', GlobalVariable.ID+':id/txtCuentaTerceros', GlobalVariable.ID+':id/txtdesde','')
CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID+':id/buttonContinue', 'Someter', GlobalVariable.ID+':id/textValue', GlobalVariable.ID+':id/textValue','')

//set token
Mobile.setText(findTestObject('Object Repository/Transferencias/Entre Cuenta/Enter Token Field'), GlobalVariable.token, 30)
Mobile.takeScreenshot()

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Entre Cuenta/Popular Logo Receipt Screen')
//CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/deprecated/green tick temporory')

//tap continuarv2
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Check Error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
