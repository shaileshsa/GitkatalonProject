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

//tap consulta
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Salir/Salir Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard')

//tap burgermenu
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Salir/Salir Button Dashboard', 'Object Repository/Common Objects/Burger Menu/Burger Menu')

//tap desembolso
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Desembolsos/Desembolsos In Burger Menu', 'Object Repository/Desembolsos/Desembolsos In Burger Menu')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Desembolsos/Desembolsos Heading')

//tap desde
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Desembolsos/Desembolsos Heading', 'Object Repository/Desembolsos/Desde')

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
        
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible', 'RD')
    } else {
        if (driver.findElementsById(GlobalVariable.ID + ':id/txtaccType').size() == 0) {
            CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
        } 
        CustomKeywords.'com.appEmpresarial.helperCommonAction.collectData'(GlobalVariable.ID + ':id/txtaccType', desde, GlobalVariable.ID + ':id/txtaccType', GlobalVariable.ID + ':id/txtBalancedisponible', 'RD')
    }
} else {
    CustomKeywords.'com.appEmpresarial.helperCommonAction.goBackFromAccountSelectionScreen'()
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Desembolsos/Desembolsos Heading')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtDesdeAccDetail',GlobalVariable.ID+':id/txtDesdeBalance')

/*
//tap hasta
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Desembolsos/Desembolsos Heading', 'Object Repository/Desembolsos/Hasta')

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

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Desembolsos/Desembolsos Heading')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtHastaAccDetail',GlobalVariable.ID+':id/txtHastaBalance')
*/

//select amount
Mobile.takeScreenshot();
Mobile.setText(findTestObject('Object Repository/Desembolsos/Set Amounts'), amount, GlobalVariable.timeOut_4_Sec)

//select Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Desembolsos/Desembolsos Heading')

//select forma de pago
Mobile.takeScreenshot();
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Desembolsos/Forma De Pago', 'Object Repository/Desembolsos/Forma De Pago')

//select 3 meses
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

Mobile.takeScreenshot();

//Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Desembolsos/Popular Logo Receipt Screen')
//CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/deprecated/green tick temporory')

//Continuar
CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')

