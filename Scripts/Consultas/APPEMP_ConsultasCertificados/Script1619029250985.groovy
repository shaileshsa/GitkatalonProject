import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
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

//check for multiple company
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkAndSelectCompany'(company)

//Tap Prestamos
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID + ':id/filterPrestamosoption', 'Préstamos')

//tap Tarjetas
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID + ':id/filterTarjetasoption', 'Tarjetas')

//tap Inversiones
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID + ':id/filterCertificateoption', 'Certificados')

//check permission prestamo and selection of account + tap pagar/transfer
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', account, 'Object Repository/Consultas/Certificado/Inversiones Dashboard', 'Object Repository/Consultas/Certificado/Detalle Cuenta Heading', 'Object Repository/Transferencias/Entre Cuenta/Transfer in Cuenta', company, 'RD', GlobalVariable.ID+':id/txtDisponible')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Certificado/Detalle Cuenta Heading')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID + ':id/txtAccType', GlobalVariable.ID + ':id/txtDisponible')

//Tap button Historial
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Certificado/Historial Button', 'Object Repository/Consultas/Certificado/Historial Button')

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Certificado/Fecha Initial Certificado')

//no result
if (Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Certificado/No Result Found (msg)'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL) == true) {
    Mobile.takeScreenshot()
    KeywordUtil.markWarning('*****NO TRANSACTION*****')
}

//Tap fecha initial
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Certificado/Fecha Initial Certificado', 'Object Repository/Consultas/Certificado/Fecha Initial Certificado')

//GO back 1 year
AppiumDriver<?> driver = MobileDriverFactory.getDriver()
driver.findElement(By.id(GlobalVariable.ID+':id/txtfromdate')).click();
if(driver.findElementsById('android:id/date_picker_header_year').size() > 0) {
driver.findElement(By.id('android:id/date_picker_header_year')).click();
ArrayList<String> year = new ArrayList<String>();
year = driver.findElementsById('android:id/text1')
year[4].click();
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Certificado/Accept Button Calender','Object Repository/Consultas/Certificado/Accept Button Calender')
}

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Certificado/Fecha Initial Certificado')

//tap Back
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Certificado/Historial Button')

//tap Back to Home
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()

//error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')