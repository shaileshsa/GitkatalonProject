import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.TouchAction as TouchAction
import io.appium.java_client.touch.offset.ElementOption as ElementOption
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.xpath.internal.compiler.Keywords

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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//tap consulta
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard')

//tap aprobanciones pendientes
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Salir/Salir Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Aprobaciones y rechazos/Cerrar Button')

//check for no transaction avaiable msg
if (Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/No Transaction Found (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
	//tap cerrar
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
	
	//Error check
	CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
	
	//mark fail
	KeywordUtil.markPassed('*****NO TRANSACTION AVAILABLE IN LIST*****')
}else{
	//call reject function
	boolean validate = false
	
	for(int i = 0; i<10 && !(validate); i++) {
		rejectProcess()
		
		if (Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/No Transaction Found (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
			validate = true
			//tap cerrar
			CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

			//Error check
			CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
		}
		
	}
}

def rejectProcess() {
	//tap seleccionar
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Multiple Transaction Select Button', 'Object Repository/Aprobaciones y rechazos/Multiple Transaction Select Button')
	
	//tap seleccionar todas button
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Seleccionar Todas Button', 'Object Repository/Aprobaciones y rechazos/Seleccionar Todas Button')
	
	//tap ver seleccionados button
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Ver seleccionados Button', 'Object Repository/Aprobaciones y rechazos/Ver seleccionados Button')
	
	//check error
	CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Aprobaciones y rechazos/Verificacin Heading')
	
	//tap reject all
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Reject All Button', 'Object Repository/Aprobaciones y rechazos/Reject All Button')
	
	if (Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Reject All Transaction (msg)'), GlobalVariable.timeOut_2_Sec)) {
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Reject All Transaction (msg)', 'Object Repository/Aprobaciones y rechazos/Si button')
	}
	
	//Set Token
	Mobile.setText(findTestObject('Object Repository/Aprobaciones y rechazos/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)
	
	//tap Continuar
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	
	//check error
	CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Aprobaciones y rechazos/Transaction Declined for Multiple Transaction (msg)')
	
	//tap continuar
	CustomKeywords.'com.appEmpresarial.helperCommonAction.ContinueButton'()
	
	//check error
	CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Aprobaciones y rechazos/Cerrar Button')
}