import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

try {
	Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Salir/Salir Button Dashboard'), GlobalVariable.timeOut_1_Sec)
} catch (Exception e) {
	CustomKeywords.'com.appEmpresarial.helperCommonAction.startExisitingAPP'()
}

//tap burgermenu
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Common Objects/Salir/Salir Button Dashboard', 'Object Repository/Common Objects/Burger Menu/Burger Menu')

//tap pending approve
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Burger Menu', 'Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Burger Menu')

//Check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Aprobaciones y rechazos/Cerrar Button')

if(Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/No Transaction Found (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markFailedAndStop('*****NO TRANSACTION VISIBLE IN LIST*****')
}else{
//validate data
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
ArrayList<String> listDate = new ArrayList<String>();
ArrayList<String> listBeneficiario = new ArrayList<String>();
ArrayList<String> listAmount = new ArrayList<String>();
ArrayList<String> typeOfTransaction = new ArrayList<String>();
ArrayList<String> submittedBy = new ArrayList<String>();

listDate = driver.findElementsById(GlobalVariable.ID+':id/fechaSolcitude')
String dateOne = (listDate[0]).getText().trim().replace(" ", "");

listBeneficiario = driver.findElementsById(GlobalVariable.ID+':id/beneficiary')
String beneficiarioOne = (listBeneficiario[0]).getText().trim().replace(" ", "");

listAmount = driver.findElementsById(GlobalVariable.ID+':id/monto')
String amountOne = (listAmount[0]).getText().trim().replace(" ", "");

typeOfTransaction = driver.findElementsById(GlobalVariable.ID+':id/tipoTransaccion')
String typeOne = (typeOfTransaction[0]).getText().trim().replace(" ", "");

submittedBy = driver.findElementsById(GlobalVariable.ID+':id/submittedFor')
String sumbitOne = (submittedBy[0]).getText().trim().replace(" ", "");

//select any payment
ArrayList<String> elements = new ArrayList<String>();
elements = driver.findElementsById(GlobalVariable.ID+':id/fechaSolcitude')
(elements[0]).click()

//Check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Aprobaciones y rechazos/Verificacin Heading')

//validate data
ArrayList<String> paymentDate = new ArrayList<String>();
ArrayList<String> paymentBeneficiario = new ArrayList<String>();
ArrayList<String> paymentAmount = new ArrayList<String>();
ArrayList<String> paymentTypeOfTransaction = new ArrayList<String>();
ArrayList<String> paymentSubmittedBy = new ArrayList<String>();

paymentDate = driver.findElementsById(GlobalVariable.ID+':id/txtApplicationDate')
String dateTwo = (paymentDate[0]).getText().trim().replace(" ", "");

paymentBeneficiario = driver.findElementsById(GlobalVariable.ID+':id/txtbenificiario')
String beneficiarioTwo = (paymentBeneficiario[0]).getText().trim().replace(" ", "");

paymentAmount = driver.findElementsById(GlobalVariable.ID+':id/monto')
String amountTwo = (paymentAmount[0]).getText().trim().replace(" ", "");

paymentTypeOfTransaction = driver.findElementsById(GlobalVariable.ID+':id/txtAccType')
String typeTwo = (paymentTypeOfTransaction[0]).getText().trim().replace(" ", "");

paymentSubmittedBy = driver.findElementsById(GlobalVariable.ID+':id/txtSubmittedBy')
String sumbitTwo = (paymentSubmittedBy[0]).getText().trim().replace(" ", "");

if((dateOne.equals(dateTwo) && beneficiarioOne.equals(beneficiarioTwo) && amountOne.equals(amountTwo) && typeOne.equals(typeTwo) && sumbitOne.equals(sumbitTwo))==false) {
	KeywordUtil.logInfo(dateOne)
	KeywordUtil.logInfo(dateTwo)
	KeywordUtil.logInfo(beneficiarioOne)
	KeywordUtil.logInfo(beneficiarioTwo)
	KeywordUtil.logInfo(typeOne)
	KeywordUtil.logInfo(typeTwo)
	KeywordUtil.logInfo(amountOne)
	KeywordUtil.logInfo(amountTwo)
	KeywordUtil.logInfo(sumbitOne)
	KeywordUtil.logInfo(sumbitTwo)
	KeywordUtil.markWarning('Data is not same - amount/beneficiario/date - time/submitted by/type of transaction')
}

//tap back button
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()
}

//Check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Aprobaciones y rechazos/Cerrar Button')

//tap cerrar
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')

