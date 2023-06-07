import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling

//check ad screen
//if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Maintenance screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
//	//tap continue
	//CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Credential Screen/Continue Image', 'Object Repository/Login/Credential Screen/Continue Image')
//}


//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
//tap salir
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Common Objects/Salir/Salir Button Dashboard', 'Object Repository/Common Objects/Salir/Salir Button Dashboard')
//tap aceptar
CustomKeywords.'com.appEmpresarial.helperCommonAction.AcceptButton'();
//AccessoScreen
CustomKeywords.'com.appEmpresarial.helperCommonAction.accessoScreen'();

//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')

//Login pin
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapForRegistration'('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')
//screen
Mobile.takeScreenshot();
//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.errorCheckRegisteration'('Object Repository/Common Objects/Salir/Salir Button Dashboard')