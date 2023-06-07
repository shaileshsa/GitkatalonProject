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

//Tap Cuentas
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkPermissionPaymentType'(GlobalVariable.ID+':id/filterCuentaoption', 'Cuentas')

//check permission cuenta and selection of account + tap pagar/transfer
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtDisponible', GlobalVariable.ID+':id/txtAccType', 'RD', 'Object Repository/Transferencias/Entre Cuenta/Cuentas Dashboard', 'Object Repository/Transferencias/Entre Cuenta/Cuenta Detail Heading', 'Object Repository/Transferencias/Entre Cuenta/Transfer in Cuenta', company)
//CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponibles', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', account, 'Object Repository/Transferencias/Entre Cuenta/Cuentas Dashboard', 'Object Repository/Transferencias/Entre Cuenta/Cuenta Detail Heading', 'Object Repository/Transferencias/Entre Cuenta/Transfer in Cuenta', company, 'RD', GlobalVariable.ID+':id/txtDisponible')
CustomKeywords.'com.appEmpresarial.helperCommonAction.permissionCheckOfAccounts'(GlobalVariable.ID+':id/txtaccType', GlobalVariable.ID+':id/txtBalancedisponible', GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtAccType', account, 'Object Repository/Transferencias/Entre Cuenta/Cuentas Dashboard', 'Object Repository/Transferencias/Entre Cuenta/Cuenta Detail Heading', 'Object Repository/Transferencias/Entre Cuenta/Transfer in cuenta (1)', company, 'RD', GlobalVariable.ID+':id/txtDisponible')

//check error
CustomKeywords.'com.appEmpresarial.helperCommonAction.checkError'('Object Repository/Consultas/Entre Cuenta/Detalle Cuenta Heading')

//data check
CustomKeywords.'com.appEmpresarial.helperCommonAction.dataCheck'(GlobalVariable.ID+':id/txtAccType', GlobalVariable.ID+':id/txtDisponible')

//Tap button FilterIcon
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/FilterIcon', 'Object Repository/Consultas/Entre Cuenta/FilterIcon')

//GO back 2 year
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

//Tap button Fecha Filter
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/FechaFilter', 'Object Repository/Consultas/Entre Cuenta/FechaFilter')

	for (int i = 1 ; i<=5; i++)
	{
		Mobile.tap(findTestObject('Object Repository/Consultas/Entre Cuenta/LeftArrow'), 3, FailureHandling.OPTIONAL)
	}
	String date = new Date().format( 'dd' )
	ExpectedDate = date
	KeywordUtil.logInfo(ExpectedDate)
	if(ExpectedDate.charAt(0) == '0')
	{
	  ExpectedDate = ExpectedDate.substring(1)
	  KeywordUtil.logInfo(ExpectedDate)
	  
	}
	KeywordUtil.logInfo(ExpectedDate)
	driver.findElement(By.xpath("//*[@class = 'android.widget.TextView' and (@text = '${ExpectedDate}' or . = '${ExpectedDate}')]")).click()
	//driver.findElement(By.xpath("//*[@class = 'android.widget.TextView' and (@text = '${ExpectedDate}' or . = '${ExpectedDate}')]")).click();
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
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/New Historial Heading', 'Object Repository/Consultas/Entre Cuenta/Crdito')

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
CustomKeywords.'com.appEmpresarial.helperCommonAction.tapWithCheck'('Object Repository/Consultas/Entre Cuenta/New Historial Heading', 'Object Repository/Consultas/Entre Cuenta/Dbito')

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
