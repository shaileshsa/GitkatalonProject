import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.ProcessBuilder.Redirect
import java.text.SimpleDateFormat

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable

//check ad screen
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Maintenance screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
	//tap continue
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Credential Screen/Continue Image', 'Object Repository/Login/Credential Screen/Continue Image')
}

//AccessoScreen
CustomKeywords.'com.appEmpresarial.helperCommonAction.accessoScreen'();

//check if user got registered then de - register
if(Mobile.verifyElementVisible(findTestObject('Login/Login_Pin Screen/Login_Pin Screen - Element'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)) {
	//error check
	CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')
	//De - register
	if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Login_Pin Screen/Desvincular Button'), GlobalVariable.timeOut_1_Sec, FailureHandling.STOP_ON_FAILURE) == true) {
		//tap desvincular
		CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Desvincular Button', 'Object Repository/Login/Login_Pin Screen/Desvincular Button')
		//tap aceptar
		CustomKeywords.'com.appEmpresarial.helperCommonAction.AcceptButton'()
		//check ad screen
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Maintenance screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
			//tap continue
			CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Credential Screen/Continue Image', 'Object Repository/Login/Credential Screen/Continue Image')
		}
		//error check
		CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Accesso Screen/Popular Logo new')
		//AccessoScreen
		CustomKeywords.'com.appEmpresarial.helperCommonAction.accessoScreen'();
	}
}

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Popular Logo'), GlobalVariable.timeOut_1_Sec, 
    FailureHandling.STOP_ON_FAILURE) == true) {
	Mobile.takeScreenshot();
	//set text empresa
    Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/Company TextField'), business, GlobalVariable.timeOut_1_Sec)
	Mobile.takeScreenshot();
	//set text user
    Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/User TextField'), userName, GlobalVariable.timeOut_1_Sec)
	Mobile.takeScreenshot();
	//set text contrasea
    Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/Password TextField'), password, GlobalVariable.timeOut_1_Sec)
    //Screen
    Mobile.takeScreenshot()
    //tap Acceder
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Credential Screen/Enter Button', 'Object Repository/Login/Credential Screen/Enter Button')
}

if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Token Screen/Token Field'), GlobalVariable.timeOut_30_Sec, FailureHandling.OPTIONAL)) {
	//error check
	CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Token Screen/Token Field')
	//Screen
	Mobile.takeScreenshot();
	//set text token
	Mobile.setText(findTestObject('Object Repository/Login/Token Screen/Token Field'), GlobalVariable.token, GlobalVariable.timeOut_1_Sec);
	//tap Acceder
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Token Screen/Enter Button', 'Object Repository/Login/Token Screen/Enter Button')
	//error check
	CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Set Pin Screen/Pin 1')
	//Screen
	Mobile.takeScreenshot();
	//set pin
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 1'), '1', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 2'), '2', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 3'), '3', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 4'), '4', GlobalVariable.timeOut_1_Sec)
	//Screen
	Mobile.takeScreenshot();
	//confirm pin
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 5'), '1', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 6'), '2', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 7'), '3', GlobalVariable.timeOut_1_Sec)
	//Screen
	Mobile.takeScreenshot();
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 8'), '4', GlobalVariable.timeOut_1_Sec)
	
} else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Set Pin Screen/Pin 1'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)){
	//error check
	CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Set Pin Screen/Pin 1')
	//Screen
	Mobile.takeScreenshot();
	//set pin
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 1'), '1', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 2'), '2', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 3'), '3', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 4'), '4', GlobalVariable.timeOut_1_Sec)
	//Screen
	Mobile.takeScreenshot();
	//confirm pin
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 5'), '1', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 6'), '2', GlobalVariable.timeOut_1_Sec)
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 7'), '3', GlobalVariable.timeOut_1_Sec)
	//Screen
	Mobile.takeScreenshot();
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 8'), '4', GlobalVariable.timeOut_1_Sec)
}

//Screen
Mobile.takeScreenshot()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/FingerPrint Screen/FingerPrint Logo')
//scroll to skip button
Mobile.scrollToText('Lo haré luego')

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Login/FingerPrint Screen/Skip Text'), GlobalVariable.timeOut_4_Sec, 
    FailureHandling.STOP_ON_FAILURE) == true) {
	//Screen
	Mobile.takeScreenshot()
	//tap Lo har luego
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/FingerPrint Screen/Skip Text', 'Object Repository/Login/FingerPrint Screen/Skip Text')
}

//check ad screen
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Maintenance screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
	//tap continue
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Credential Screen/Continue Image', 'Object Repository/Login/Credential Screen/Continue Image')
}

//Screen
Mobile.takeScreenshot()
//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')
//Login pin
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')
//Screen
Mobile.takeScreenshot()

//handle pin error bug
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/Incorrect Pin'), GlobalVariable.timeOut_4_Sec, FailureHandling.OPTIONAL) == true) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Common Objects/OK Button/OK Button', 'Object Repository/Common Objects/OK Button/OK Button')
	//check error
	CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')
	//Login pin
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')
}

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Common Objects/Salir/Salir Button Dashboard')

//login successful
GlobalVariable.login_check = true;

