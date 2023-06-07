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
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterPrestamosoption', 'Préstamos')
 
//check permission prestamo and selection of account + tap pagar/transfer
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', account, 'Object Repository/Pagos/Prestamos/Prestamos Dashboard', 'Object Repository/Pagos/Prestamos/Prestamo Detail Heading', 'Object Repository/Pagos/Prestamos/Pagar In Prestamos', company, 'RD', GlobalVariable.ID+':id/txtDisponible')
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccNumber', GlobalVariable.ID+':id/txtAccNumber', account, 'Object Repository/Pagos/Prestamos/Prestamos Dashboard', 'Object Repository/Pagos/Prestamos/Prstamo Detail Headings', 'Object Repository/Pagos/Prestamos/Pagar in Presatamo1', company, 'RD', GlobalVariable.ID+':id/txtBalanceFecha')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Pagos/Prestamos/Prstamo Detail Headings')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtAccNumber',GlobalVariable.ID+':id/txtNextPaid')

//Tap button FilterIcon
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Prestamo/Presatmo FilterIcon', 'Object Repository/Consultas/Prestamo/Presatmo FilterIcon')

//GO back 2 year
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

//Tap button Fecha Filter
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Prestamo/Prestamo Fecha Filter', 'Object Repository/Consultas/Prestamo/Prestamo Fecha Filter')

	for (int i = 1 ; i<=6; i++)
	{
		Mobile.tap(findTestObject('Object Repository/Consultas/Entre Cuenta/LeftArrow'), 3, FailureHandling.OPTIONAL)
	}
	String date = new Date().format( 'dd' )
	ExpectedDate = date
	if(ExpectedDate.charAt(0) == '0')
	{
	  ExpectedDate = ExpectedDate.substring(1)
	  KeywordUtil.logInfo(ExpectedDate)
	  
	}
	driver.findElement(By.xpath("//*[@class = 'android.widget.TextView' and (@text = '${ExpectedDate}' or . = '${ExpectedDate}')]")).click()
	 Mobile.tap(findTestObject('Object Repository/Consultas/Entre Cuenta/ApplyFilter'), 2, FailureHandling.OPTIONAL)

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Entre Cuenta/New Historial Heading')

//no record
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Entre Cuenta/Historical Amount'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markPassed('*****Historical list Is Available*****')
}
else {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****No Record Found*****')
}
//Tap button Credito
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/New Historial Heading', 'Object Repository/Consultas/Prestamo/Prestamo Crdito Button')

//no record
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Entre Cuenta/Historical Amount'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markPassed('*****Historical list Is Available*****')
}
else {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****No Record Found*****')
}

//Tap button Debito
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/New Historial Heading', 'Object Repository/Consultas/Prestamo/Prestamo Dbito Button')

//no record
if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Entre Cuenta/Historical Amount'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)==true) {
	Mobile.takeScreenshot();
	KeywordUtil.markPassed('*****Historical list Is Available*****')
}
else {
	Mobile.takeScreenshot();
	KeywordUtil.markWarning('*****No Record Found*****')
}
//Tap Back
CustomKeywords.'com.appEmpresarial.helperCommonAction.BackButton'()

//Error check
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Common Objects/Salir/Salir Button Dashboard')
