package com.appEmpresarial

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class NegativeTestsKeyword {
	//custom tap for registration
	@Keyword
	public void clickForRegisterFlow (String verify, String element) {
		try {
			if(Mobile.verifyElementVisible(findTestObject(verify), GlobalVariable.timeOut_50_Sec) == true ) {
				//take screenshot
				Mobile.takeScreenshot()
				//tap element
				Mobile.tap(findTestObject(element), GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)
			}
		}
		catch(Exception e) {
			KeywordUtil.markFailedAndStop('****" '+element+' " not found****')
		}
	}

	//custom tap after registration
	@Keyword
	public void clickAfterRegistration (String verify, String element) {
		try {
			if(Mobile.verifyElementVisible(findTestObject(verify), GlobalVariable.timeOut_50_Sec) == true ) {
				//take screenshot
				Mobile.takeScreenshot()
				//tap element
				Mobile.tap(findTestObject(element), GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)
			}
		}
		catch(Exception e) {
			def helperCommonAction = new helperCommonAction()
			helperCommonAction.startExisitingAPP()
			KeywordUtil.markFailedAndStop(element+' Not found')
		}
	}

	//error check for registration
	@Keyword
	public void handleNegativeErrorMsg () {
		int timer
		def NegativeTestsKeyword = new NegativeTestsKeyword()
		def helperCommonAction = new helperCommonAction()
		for(timer = 0; timer<10000; timer++) {
			if(timer>10) {
				Mobile.takeScreenshot()
				KeywordUtil.markFailedAndStop('*****NO ERROR POPUP BUT STUCK ON SAME SCREEN*****')
			}
			//Incorrect username or password
			if(Mobile.verifyElementVisible(findTestObject('Login/android.widget.TextView - Por favor confirme su usuario yo contrasea y digtelos nuevamente'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				helperCommonAction.ContinueButton()
				KeywordUtil.markPassed('*****INCORRECT USERNAME OR PASSWORD POPUP FOUND*****')
				break
			}
			//Pin not matched Error
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/Pin Not Matched'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				NegativeTestsKeyword.clickForRegisterFlow('Object Repository/Common Objects/OK Button/OK Button', 'Object Repository/Common Objects/OK Button/OK Button')
				KeywordUtil.markPassed('*****PIN NOT MATCHED POPUP FOUND*****')
				break
			}
			//pin not correct
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/Incorrect Pin'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				NegativeTestsKeyword.clickForRegisterFlow('Object Repository/Common Objects/OK Button/OK Button', 'Object Repository/Common Objects/OK Button/OK Button')
				KeywordUtil.markPassed('*****PIN IS INCORRECT POPUP FOUND*****')
				break
			}
			//Incomplete Data
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Negative Secenarios Object/android.widget.TextView - Existen data not foundimpueteos'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				helperCommonAction.ContinueButton()
				KeywordUtil.markPassed('*****INCOMPLETE DATA POPUP FOUND*****')
				break
			}
			//Invalid amount
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Monto invlido. Por favor verifica e intenta de nuevo'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				helperCommonAction.ContinueButton()
				//NegativeTestsKeyword.clickAfterRegistration('Object Repository/Common Objects/Continuar Button/continue button 1 (service error)', 'Object Repository/Common Objects/Continuar Button/continue button 1 (service error)')
				KeywordUtil.markPassed('*****INVALID AMOUNT POPUP FOUND*****')
				break
			}
			//select type of transaction
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Transferencias/Interbancario/please select transaction type msg'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				helperCommonAction.ContinueButton()
				//NegativeTestsKeyword.clickAfterRegistration('Object Repository/Aprobaciones y rechazos/CONTINUAR for service error', 'Object Repository/Aprobaciones y rechazos/CONTINUAR for service error')
				KeywordUtil.markPassed('*****NO TRANSACTION SELECTED POPUP FOUND*****')
				break
			}
			//Call to Back Office  Error
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Negative Secenarios Object/android.widget.TextView - Call To Back Office Error'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				helperCommonAction.ContinueButton()
				KeywordUtil.markPassed('*****CALL TO BACK OFFICE POPUP FOUND*****')
				break
			}
			//select beneficiary error
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Pagos/select beneficiary msg Impuestos'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				NegativeTestsKeyword.clickAfterRegistration('Object Repository/Login/android.widget.Button - OK', 'Object Repository/Login/android.widget.Button - OK')
				KeywordUtil.markPassed('*****SELECT BENEFICIARY POPUP FOUND*****')
				break
			}
			//Incomplete Data
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Negative Secenarios Object/android.widget.TextView - Existen datos requeridos incomplete for Interbank'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				helperCommonAction.ContinueButton()
				KeywordUtil.markPassed('*****INCOMPLETE DATA POPUP FOUND*****')
				break

			}
			//Invalid amount
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Negative Secenarios Object/android.widget.TextView - Por favor seleccione una va de pago Select Type of interbank'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				helperCommonAction.ContinueButton()
				KeywordUtil.markPassed('*****INVALID AMOUNT POPUP FOUND*****')
				break
			}
			//Invalid Amount{0}
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Negative Secenarios Object/Entre sus Cuenta/El monto digitado Wrong Monto'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
				Mobile.takeScreenshot()
				helperCommonAction.ContinueButton()
				KeywordUtil.markPassed('*****INVALID AMOUNT[0] POPUP FOUND*****')
				break
			}
		}

	}
}