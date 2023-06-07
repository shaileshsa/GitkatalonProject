import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

//take screenshot
Mobile.takeScreenshot()

//tap transfer
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Terceros/Transfer in Burger Menu', 'Object Repository/Transferencias/Terceros/Transfer in Burger Menu')

//tap terceros
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Terceros/Tercero in Burger Menu', 'Object Repository/Transferencias/Terceros/Tercero in Burger Menu')

//take screenshot
Mobile.takeScreenshot()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Transferencias A Tercero Headings')

//tap desde
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Terceros/Desde tercero', 'Object Repository/Transferencias/Terceros/Desde tercero')

//select desde
AppiumDriver<?> d = MobileDriverFactory.getDriver()

if (d.findElementsById(GlobalVariable.ID + ':id/linFilter').size() > 0) {
    //Search Account
    Mobile.setText(findTestObject('Object Repository/Common Objects/Search Account Field/Search Account Field - 2'), desde, GlobalVariable.timeOut_2_Sec)
    List<WebElement> element = d.findElementsById(GlobalVariable.ID + ':id/imgarrowup')

    if (element.size() > 1) {
        //company selection code here
        CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company)

        //check for no account
        if (d.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        }
        
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible','RD')
    } else {
        if (d.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
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

//tap beneficiario
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Transferencias/Terceros/Beneficiario in Tercero', 'Object Repository/Transferencias/Terceros/Beneficiario in Tercero')

//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Buscar Field')

//search account
Mobile.setText(findTestObject('Transferencias/Terceros/Buscar Field'), beneficiario, 30)

//select beneficiario
if (d.findElementsById(GlobalVariable.ID + ':id/rel_cuenta').size() > 0) {
    //screenshot
    Mobile.takeScreenshot()

    //tap beneficiario
    CustomKeywords.'com.appEmpresarial.helperCommonAction.checkElementPresentTwo'(GlobalVariable.ID + ':id/txtaccType')
} else {
    Mobile.takeScreenshot()

    AppiumDriver<?> driver = MobileDriverFactory.getDriver()

    ArrayList<String> tapElement = new ArrayList<String>()

    tapElement = driver.findElementsById(GlobalVariable.ID + ':id/imgBackArrow')

    (tapElement[0]).click()

    if (Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL) == true) {
        CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
    }
    
    tapElement = driver.findElementsById(GlobalVariable.ID + ':id/btnCancelar')

    (tapElement[0]).click()

    CustomKeywords.'com.appEmpresarial.helperCommonAction.AcceptButton'()

    CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')

    KeywordUtil.markFailedAndStop('*****NO ACCOUNT VISIBLE IN LIST*****')
}

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheckTwo'(GlobalVariable.ID + ':id/txtToAccDetails')

//set amount
Mobile.setText(findTestObject('Object Repository/Transferencias/Terceros/Digite el monto Button'), amount, 30)

//take screenshot
Mobile.takeScreenshot()

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

//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Verification Headings')

//take screenshot
Mobile.takeScreenshot()

//data save and tap continuar
//CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/btnContinuar', 'Continuar', GlobalVariable.ID + ':id/txtCuentaTerceros', GlobalVariable.ID + ':id/txtdesde','')
CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID+':id/buttonContinue', 'Transferir', GlobalVariable.ID+':id/textValue', GlobalVariable.ID+':id/textValue','')

//set token
Mobile.setText(findTestObject('Object Repository/Transferencias/Terceros/Enter Token Field'), GlobalVariable.token, 30)

//take screenshot
Mobile.takeScreenshot()

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//take screenshot
Mobile.takeScreenshot()

//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Transferencias/Terceros/Popular Logo Receipt Screen')

//tap continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
