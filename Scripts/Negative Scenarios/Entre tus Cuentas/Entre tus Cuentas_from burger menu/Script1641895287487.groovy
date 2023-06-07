import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

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

//tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()

//tap desde
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Entre Cuenta/Transfercias Entre Cuenta in Headings', 'Object Repository/Transferencias/Entre Cuenta/Desde Entre Cuenta')

//select desde
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

if (driver.findElementsById(GlobalVariable.ID + ':id/linFilter').size() > 0) {
	Mobile.setText(findTestObject('Object Repository/Common Objects/Search Account Field/Search Account Field - 2'), desde, GlobalVariable.timeOut_2_Sec)
	
     List<WebElement> element = driver.findElementsById(GlobalVariable.ID + ':id/imgarrowup')

    if (element.size() > 1) {
        //company selection code here
        //CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(GlobalVariable.Transaction_Company_One)
		CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_one)
		
        //check for no account
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        }
		CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','RD')
		
        //CustomKeywords.'com.appEmpresarial.helperCommonAction.checkElementPresent'(GlobalVariable.ID + ':id/txtBalancedisponible', 'RD', GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible')
    } else {
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        }
		CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','RD')
		
        //CustomKeywords.'com.appEmpresarial.helperCommonAction.checkElementPresent'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible')
    }
} else {
    CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Entre Cuenta/Transfercias Entre Cuenta in Headings')

//tap continuar
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickAfterRegistration'('Object Repository/Transferencias/Interbancario/android.widget.Button - Continuar', 'Object Repository/Transferencias/Interbancario/android.widget.Button - Continuar')
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()

//tap hasta
CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickAfterRegistration'('Object Repository/Transferencias/Entre Cuenta/Transfercias Entre Cuenta in Headings', 'Object Repository/Transferencias/Entre Cuenta/Entre Cuenta HASTA')

//select hasta
if (driver.findElementsById(GlobalVariable.ID + ':id/linFilter').size() > 0) {
	Mobile.setText(findTestObject('Object Repository/Common Objects/Search Account Field/Search Account Field - 2'), hasta, GlobalVariable.timeOut_2_Sec)
    List<WebElement> element = driver.findElementsById(GlobalVariable.ID + ':id/imgarrowup')

    if (element.size() > 1) {
        //company selection code here
        //CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(GlobalVariable.Transaction_Company_Two)
		CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company_two)
		
        //check for no account
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        }
		CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', hasta, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','RD')
		
       // CustomKeywords.'com.appEmpresarial.helperCommonAction.checkElementPresent'(GlobalVariable.ID + ':id/txtBalancedisponible', 'RD', GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible')
    } else {
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        }
		CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', hasta, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','RD')
		
        //CustomKeywords.'com.appEmpresarial.helperCommonAction.checkElementPresent'(GlobalVariable.ID + ':id/txtaccType', hasta, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible')
    }
} else {
    CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Entre Cuenta/Transfercias Entre Cuenta in Headings')


//tap continuar
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickAfterRegistration'('Object Repository/Transferencias/Interbancario/android.widget.Button - Continuar', 'Object Repository/Transferencias/Interbancario/android.widget.Button - Continuar')
//CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//handle error
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'()

//set amount
Mobile.setText(findTestObject('Object Repository/Transferencias/Entre Cuenta/Digital Monto Button'), '0', GlobalVariable.timeOut_2_Sec)
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
Mobile.setText(findTestObject('Object Repository/Transferencias/Entre Cuenta/Digital Monto Button'), Amount, GlobalVariable.timeOut_2_Sec)
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
CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID+':id/buttonContinue', 'Transferir', GlobalVariable.ID+':id/textValue', GlobalVariable.ID+':id/textValue','')

//set token
Mobile.setText(findTestObject('Object Repository/Transferencias/Entre Cuenta/Enter Token Field'), '321321', 30)
Mobile.takeScreenshot()

//tap continuar
//CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickAfterRegistration'('Object Repository/Transferencias/Interbancario/android.widget.Button - Continuar (2)', 'Object Repository/Transferencias/Interbancario/android.widget.Button - Continuar (2)')
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Entre Cuenta/Popular Logo Receipt Screen')

//data check
//CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtdesdeCuenta', GlobalVariable.ID+':id/txthastaCuenta')

//tap continuarv2
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Check Error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')


