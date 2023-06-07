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

//tap estatus de transacciones
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Salir/Salir Button Dashboard', 'Object Repository/Estatus de transacciones/Estatus De Transacciones Button')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Estatus de transacciones/Aprobadas por mi Button')

//tap Completadas
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Estatus de transacciones/Aprobadas por mi Button', 'Object Repository/Estatus de transacciones/Completadas Button')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Estatus de transacciones/Completadas Button')

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Estatus de transacciones/No Registered Payee (msg)'), GlobalVariable.timeOut_4_Sec, FailureHandling.OPTIONAL) == true) {
    Mobile.takeScreenshot()
    KeywordUtil.markWarning('*****YOU DONT HAVE ANY REGISTERD BENEFICIARIES*****')
	//tap consulta
	CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard')
} else {

//validate data
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

ArrayList<String> listDate = new ArrayList<String>()

ArrayList<String> listBeneficiario = new ArrayList<String>()

ArrayList<String> listAmount = new ArrayList<String>()

listDate = driver.findElementsById(GlobalVariable.ID + ':id/txtDateTime')

String dateOne = (listDate[0]).getText().trim()

listBeneficiario = driver.findElementsById(GlobalVariable.ID + ':id/benificirioName')

String beneficiarioOne = (listBeneficiario[0]).getText().trim()

listAmount = driver.findElementsById(GlobalVariable.ID + ':id/txtBalancedisponible')

String amountOne = (listAmount[0]).getText().trim()

//tap status
ArrayList<String> elements = new ArrayList<String>()

elements = driver.findElementsById(GlobalVariable.ID + ':id/txtDateTime')

(elements[0]).click()

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Estatus de transacciones/Transaction Details Heading')

//validate data
ArrayList<String> paymentDate = new ArrayList<String>()

ArrayList<String> paymentBeneficiario = new ArrayList<String>()

ArrayList<String> paymentAmount = new ArrayList<String>()

paymentDate = driver.findElementsById(GlobalVariable.ID + ':id/txtActual')

String dateTwo = (paymentDate[0]).getText().trim()

paymentBeneficiario = driver.findElementsById(GlobalVariable.ID + ':id/txtAccType')

String beneficiarioTwo = (paymentBeneficiario[0]).getText().trim()

paymentAmount = driver.findElementsById(GlobalVariable.ID + ':id/txtAmount')

String amountTwo = (paymentAmount[0]).getText().trim()

if (((dateOne.equals(dateTwo) && beneficiarioOne.equals(beneficiarioTwo)) && amountOne.equals(amountTwo)) == false) {
    KeywordUtil.markWarning('Data is not same - amount/beneficiario/date-time')
}

//tap back button    
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()

//tap consulta
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard')

}