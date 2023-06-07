import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement


 AppiumDriver<?> driver = MobileDriverFactory.getDriver()
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
		//error check
		CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Credential Screen/Popular Logo')
	}
}

//check ad screen
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Maintenance screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
	//tap continue
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Credential Screen/Continue Image', 'Object Repository/Login/Credential Screen/Continue Image')
}



if (Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Popular Logo'), GlobalVariable.timeOut_4_Sec, FailureHandling.STOP_ON_FAILURE) == true) {
	//wrong business
	//Screen
	Mobile.takeScreenshot();
	//Wrong business
	Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/Company TextField'), 'A', GlobalVariable.timeOut_1_Sec)
	Mobile.takeScreenshot();
	//set text user
	Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/User TextField'), userName, GlobalVariable.timeOut_1_Sec)
	Mobile.takeScreenshot();
	//set text contrasea
	Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/Password TextField'), Password, GlobalVariable.timeOut_1_Sec)
	//Screen
	Mobile.takeScreenshot()
	//tap Acceder
	CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickForRegisterFlow'('Object Repository/Login/Credential Screen/Enter Button', 'Object Repository/Login/Credential Screen/Enter Button')
	//handle error
	CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'();
	Mobile.delay(2)
	//wrong user
	//Screen
	Mobile.takeScreenshot();
	//set text empresa
	ArrayList<String> business = new ArrayList<String>();
	business = driver.findElementsById(GlobalVariable.ID+':id/editBusinessName')
	business[0].click();
	business[0].clear();
	Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/Company TextField'), Business, GlobalVariable.timeOut_1_Sec)
	Mobile.takeScreenshot();
	//Wrong user
	ArrayList<String> user = new ArrayList<String>();
	user = driver.findElementsById(GlobalVariable.ID+':id/editUsername')
	user[0].click();
	user[0].clear();
	Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/User TextField'), 'A', GlobalVariable.timeOut_1_Sec)
	Mobile.takeScreenshot();
	//set text contrasea
	ArrayList<String> password = new ArrayList<String>();
	password = driver.findElementsById(GlobalVariable.ID+':id/editPassword')
	//Screen
	Mobile.takeScreenshot()
	//tap Acceder
	CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickForRegisterFlow'('Object Repository/Login/Credential Screen/Enter Button', 'Object Repository/Login/Credential Screen/Enter Button')
	//handle error
	CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'();
	Mobile.delay(2)
	//wrong password
	//Screen
	Mobile.takeScreenshot();
	//set text empresa
	Mobile.takeScreenshot();
	//set user
	user[0].click();
	user[0].clear();
	Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/User TextField'), userName, GlobalVariable.timeOut_1_Sec)
	Mobile.takeScreenshot();
	//wrong password
	password[0].click();
	password[0].clear();
	Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/Password TextField'), '1', GlobalVariable.timeOut_1_Sec)
	//Screen
	Mobile.takeScreenshot()
	//tap Acceder
	CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickForRegisterFlow'('Object Repository/Login/Credential Screen/Enter Button', 'Object Repository/Login/Credential Screen/Enter Button')
	//handle error
	CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'();
	Mobile.delay(2)
	// correct credentials
	//set password
	password[0].click();
	password[0].clear();
	Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/Password TextField'), Password, GlobalVariable.timeOut_1_Sec)
	//Screen
	Mobile.takeScreenshot()
	//tap Acceder
	CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.clickForRegisterFlow'('Object Repository/Login/Credential Screen/Enter Button', 'Object Repository/Login/Credential Screen/Enter Button')
	//handle error
	CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Token Screen/Token Field')
}

if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Token Screen/Token Field'), GlobalVariable.timeOut_20_Sec, FailureHandling.OPTIONAL)) {
	//Screen
	Mobile.takeScreenshot();
	//set text token
	Mobile.setText(findTestObject('Object Repository/Login/Token Screen/Token Field'), GlobalVariable.token, GlobalVariable.timeOut_1_Sec);
	//tap Acceder
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Token Screen/Enter Button', 'Object Repository/Login/Token Screen/Enter Button')
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
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 8'), '5', GlobalVariable.timeOut_1_Sec)
	//handle error
	CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'();
	Mobile.delay(2)
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
	Mobile.setText(findTestObject('Object Repository/Login/Set Pin Screen/Pin 8'), '5', GlobalVariable.timeOut_1_Sec)
	//handle error
	CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'();
	Mobile.delay(2)
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
CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/FingerPrint Screen/Skip Text')

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Login/FingerPrint Screen/Skip Text'), GlobalVariable.timeOut_4_Sec,FailureHandling.STOP_ON_FAILURE) == true) {
//Screen
Mobile.takeScreenshot()
//tap Lo har luego
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/FingerPrint Screen/Skip Text','Object Repository/Login/FingerPrint Screen/Skip Text')
}

//Screen
Mobile.takeScreenshot()
//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')
//enter pin
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
Mobile.takeScreenshot()
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Negative Secenarios Object/android.widget.Button - 5')
//Screen
Mobile.takeScreenshot()
Mobile.delay(2)
//handle error
CustomKeywords.'com.appEmpresarial.NegativeTestsKeyword.handleNegativeErrorMsg'();
//Screen
Mobile.takeScreenshot()
//enter pin
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')

//Screen
Mobile.takeScreenshot()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Common Objects/Salir/Salir Button Dashboard')

//login successful
GlobalVariable.login_check = true;
