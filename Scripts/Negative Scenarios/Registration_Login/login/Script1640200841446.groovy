import com.kms.katalon.core.util.KeywordUtil
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.configuration.RunConfiguration

//close app
Mobile.closeApplication()
//start app
String host = RunConfiguration.getExecutionProfile()
if(host.contains("Remote")) {
	Mobile.startExistingApplication(GlobalVariable.ID)
} else {
	Mobile.startApplication(GlobalVariable.appPath, false)
}
//Screen
Mobile.takeScreenshot()

//AccessoScreen
CustomKeywords.'com.appEmpresarial.helperCommonAction.accessoScreen'();

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