package com.appEmpresarial

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.offset.ElementOption
import io.appium.java_client.MobileElement as MobileElement
import org.openqa.selenium.By

public class helperCommonAction {
	//this method complete register/login flow
	@Keyword
	public void loginFirstAccess (String business, String userName, String password, String token) {
		def helperCommonAction = new helperCommonAction()

		//check ad screen
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Maintenance screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
			//tap continue
			helperCommonAction.tapForRegistration('Object Repository/Login/Credential Screen/Continue Image', 'Object Repository/Login/Credential Screen/Continue Image')
		}

		//check if user got registered then de - register
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)) {
			//error check
			helperCommonAction.errorCheckRegisteration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')
			//De - register
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Login_Pin Screen/Desvincular Button'), GlobalVariable.timeOut_1_Sec, FailureHandling.STOP_ON_FAILURE) == true) {
				//tap desvincular
				helperCommonAction.tapWithCheck('Object Repository/Login/Login_Pin Screen/Desvincular Button', 'Object Repository/Login/Login_Pin Screen/Desvincular Button')
				//tap aceptar
				helperCommonAction.AcceptButton();
				//error check
				helperCommonAction.errorCheckRegisteration('Object Repository/Login/Credential Screen/Popular Logo')
			}
		}

		//check ad screen
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Maintenance screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
			//tap continue
			helperCommonAction.tapForRegistration('Object Repository/Login/Credential Screen/Continue Image', 'Object Repository/Login/Credential Screen/Continue Image')
		}

		//check error
		helperCommonAction.errorCheckRegisteration('Object Repository/Login/Credential Screen/Popular Logo')
		//set text empresa
		Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/Company TextField'), business, GlobalVariable.timeOut_1_Sec);
		//set text usuario
		Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/User TextField'), userName, GlobalVariable.timeOut_1_Sec);
		//set text contrasea
		Mobile.setText(findTestObject('Object Repository/Login/Credential Screen/Password TextField'), password, GlobalVariable.timeOut_1_Sec);
		//tap Acceder
		helperCommonAction.tapForRegistration('Object Repository/Login/Credential Screen/Enter Button', 'Object Repository/Login/Credential Screen/Enter Button')
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Token Screen/Token Field'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)) {
			//error check
			helperCommonAction.errorCheckRegisteration('Object Repository/Login/Token Screen/Token Field')
			//Screen
			Mobile.takeScreenshot();
			//set text token
			Mobile.setText(findTestObject('Object Repository/Login/Token Screen/Token Field'), token, GlobalVariable.timeOut_1_Sec);
			//tap Acceder
			helperCommonAction.tapForRegistration('Object Repository/Login/Token Screen/Enter Button', 'Object Repository/Login/Token Screen/Enter Button')
			//error check
			helperCommonAction.errorCheckRegisteration('Object Repository/Login/Set Pin Screen/Pin 1')
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
		else if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Set Pin Screen/Pin 1'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)){
			//error check
			helperCommonAction.errorCheckRegisteration('Object Repository/Login/Set Pin Screen/Pin 1')
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

		//check error
		helperCommonAction.errorCheckRegisteration('Object Repository/Login/FingerPrint Screen/FingerPrint Logo')
		//scroll to skip button
		Mobile.scrollToText('Lo haré luego')
		//tap Lo har luego
		helperCommonAction.tapForRegistration('Object Repository/Login/FingerPrint Screen/Skip Text', 'Object Repository/Login/FingerPrint Screen/Skip Text')
		//Screen
		Mobile.takeScreenshot();
		//check ad screen
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Maintenance screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
			//tap continue
			helperCommonAction.tapForRegistration('Object Repository/Login/Credential Screen/Continue Image', 'Object Repository/Login/Credential Screen/Continue Image')
		}
		//error check
		helperCommonAction.errorCheckRegisteration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')
		//Login pin
		helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
		helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
		helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
		helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')

		//handle pin error bug
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/Incorrect Pin'), GlobalVariable.timeOut_4_Sec, FailureHandling.OPTIONAL) == true) {
			helperCommonAction.tapForRegistration('Object Repository/Common Objects/OK Button/OK Button', 'Object Repository/Common Objects/OK Button/OK Button')
			//check error
			helperCommonAction.errorCheckRegisteration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')
			//Login pin
			helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
			helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
			helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
			helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')
		}

		//error check
		helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
		//Screen
		Mobile.takeScreenshot();
		//successful login
		GlobalVariable.login_check = true;
	}

	//this method unlinks the associated or enrolled user in the app
	@Keyword
	public void unlinkApp () {
		def helperCommonAction = new helperCommonAction()
		//tap salir
		helperCommonAction.tapWithCheck('Object Repository/Common Objects/Salir/Salir Button Dashboard', 'Object Repository/Common Objects/Salir/Salir Button Dashboard')
		//tap aceptar
		helperCommonAction.AcceptButton();
		//AccessoScreen
		helperCommonAction.accessoScreen()

		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Login_Pin Screen/Desvincular Button'), GlobalVariable.timeOut_4_Sec, FailureHandling.STOP_ON_FAILURE) == true) {
			//tap desvincular
			helperCommonAction.tapWithCheck('Object Repository/Login/Login_Pin Screen/Desvincular Button', 'Object Repository/Login/Login_Pin Screen/Desvincular Button')
			//tap aceptar
			helperCommonAction.AcceptButton();
			//check ad screen
			if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Maintenance screen'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
				//tap continue
				helperCommonAction.tapForRegistration('Object Repository/Login/Credential Screen/Continue Image', 'Object Repository/Login/Credential Screen/Continue Image')
			}

			//AccessoScreen
			helperCommonAction.accessoScreen()
			//error check
			helperCommonAction.errorCheckRegisteration('Object Repository/Login/Credential Screen/Popular Logo')
			//close app
			Mobile.closeApplication()
		}
	}

	//validate data for transfer
	@Keyword
	public void collectData (String ID, String data, String ID1, String ID2, String accountType) {
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		ArrayList<String> account = new ArrayList<String>();
		ArrayList<String> checkDataOne = new ArrayList<String>();
		ArrayList<String> checkDataTwo = new ArrayList<String>();
		ArrayList<String> tapElement = new ArrayList<String>();
		ArrayList<String> balance = new ArrayList<String>();

		//check account visible
		if (driver.findElementsById(ID).size() == 1) {
			account = driver.findElementsById(ID)
			balance = driver.findElementsById(ID2)
			String actual_Text = (account[0]).getText()
			String bal = (balance[0]).getText()
			if(actual_Text.contains(data) && bal.contains(accountType)) {
				try {
					checkDataOne = driver.findElementsById(ID1)
					GlobalVariable.compare_data_one = (checkDataOne[GlobalVariable.index2]).getText().trim()
					GlobalVariable.compare_data_one = GlobalVariable.compare_data_one.replace(" ", "");
				} catch(Exception e) {
					GlobalVariable.index2=0
					def bottomElement = ElementOption.element(account[(account.size() - 1)])
					def topElement = ElementOption.element(account[0])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}
				try {
					checkDataTwo = driver.findElementsById(ID2)
					GlobalVariable.compare_data_two = (checkDataTwo[GlobalVariable.index2]).getText().trim()
					GlobalVariable.compare_data_two = GlobalVariable.compare_data_two.replace("\$", "");
					GlobalVariable.compare_data_two = GlobalVariable.compare_data_two.replace(" ", "");
				}	catch(Exception e) {
					GlobalVariable.index2=0
					def bottomElement = ElementOption.element(account[(account.size() - 1)])
					def topElement = ElementOption.element(account[0])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}
				if(data.equals('Continuar') || data.equals('Pagar') || data.equals('Someter') || data.equals('Transferir')) {
					helperCommonAction.ContinueButton()
				} else {
					(account[0]).click()
				}
				//no permission
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Esta cuenta no tiene ningn permiso'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton()
					ArrayList<String> clk = new ArrayList<String>();
					clk = driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow')
					try {
						clk[0].click()
					}catch(Exception e){
						int device_Height = Mobile.getDeviceHeight()
						int device_Width = Mobile.getDeviceWidth()
						int startX = device_Width / 2
						int endX = startX
						int startY = device_Height * 0.20
						int endY = device_Height * 0.90
						Mobile.swipe(startX, startY, endX, endY)
					}

					if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
						helperCommonAction.ContinueButton();
					}
					clk = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
					try {
						clk[0].click()
					}catch(Exception e){
						clk = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						clk[0].click()
					}
					helperCommonAction.AcceptButton();
					//Error check
					if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
						Mobile.takeScreenshot();
						helperCommonAction.ContinueButton()
						helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
						helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
							helperCommonAction.ContinueButton()
						}
					}
					//mark fail
					KeywordUtil.markFailedAndStop('*****ACCOUNT DOESNT HAVE PERMISSION*****')
				}
			} else {
				helperCommonAction.goBackFromAccountSelectionScreen()
			}
		} else if(driver.findElementsById(ID).size() > 1) {
			boolean check = false
			ArrayList<String> accountName = new ArrayList<String>();
			for (int a = 0; !(check) && (a < 5); a++) {
				account = driver.findElementsById(ID2)
				for (GlobalVariable.index2; GlobalVariable.index2 < account.size(); GlobalVariable.index2++) {
					String RD_USD = (account[GlobalVariable.index2]).getText().trim()
					accountName = driver.findElementsById(ID)
					String actual_Text = (accountName[GlobalVariable.index2]).getText().trim()
					if(RD_USD.contains(accountType) && actual_Text.contains(data)) {
						check = true;
						try {
							checkDataOne = driver.findElementsById(ID1)
							GlobalVariable.compare_data_one = (checkDataOne[GlobalVariable.index2]).getText().trim()
							GlobalVariable.compare_data_one = GlobalVariable.compare_data_one.replace(" ", "");
						} catch(Exception e) {
							GlobalVariable.index2=0
							def bottomElement = ElementOption.element(account[(account.size() - 1)])
							def topElement = ElementOption.element(account[0])
							touch.longPress(bottomElement).moveTo(topElement).release().perform()
						}
						try {
							checkDataTwo = driver.findElementsById(ID2)
							GlobalVariable.compare_data_two = (checkDataTwo[GlobalVariable.index2]).getText().trim()
							GlobalVariable.compare_data_two = GlobalVariable.compare_data_two.replace("\$", "");
							GlobalVariable.compare_data_two = GlobalVariable.compare_data_two.replace(" ", "");
						}	catch(Exception e) {
							GlobalVariable.index2=0
							def bottomElement = ElementOption.element(account[(account.size() - 1)])
							def topElement = ElementOption.element(account[0])
							touch.longPress(bottomElement).moveTo(topElement).release().perform()
						}
						if(data.equals('Continuar') || data.equals('Pagar') || data.equals('Someter') || data.equals('Transferir')) {
							helperCommonAction.ContinueButton()
							GlobalVariable.index2 = 0;
						} else {
							(account[GlobalVariable.index2]).click()
							GlobalVariable.index2 = 0;
						}
						//no permission
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Esta cuenta no tiene ningn permiso'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton()
							ArrayList<String> clk = new ArrayList<String>();
							clk = driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow')
							try {
								clk[0].click()
							}catch(Exception e){
								int device_Height = Mobile.getDeviceHeight()
								int device_Width = Mobile.getDeviceWidth()
								int startX = device_Width / 2
								int endX = startX
								int startY = device_Height * 0.20
								int endY = device_Height * 0.90
								Mobile.swipe(startX, startY, endX, endY)
							}

							if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
								helperCommonAction.ContinueButton();
							}
							clk = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
							try {
								clk[0].click()
							}catch(Exception e){
								tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
								clk[0].click()
							}
							helperCommonAction.AcceptButton();
							//Error check
							if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
								Mobile.takeScreenshot();
								helperCommonAction.ContinueButton()
								helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
								helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
								if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
									helperCommonAction.ContinueButton()
								}
							}
							//mark fail
							KeywordUtil.markFailedAndStop('*****ACCOUNT DOESNT HAVE PERMISSION*****')
						}
						break;
					}
				}
			}
			if(!(check)) {
				helperCommonAction.goBackFromAccountSelectionScreen()
			}
		} else {
			helperCommonAction.goBackFromAccountSelectionScreen()
		}
	}

	//validate data
	@Keyword
	public void dataCheck (String ID1, String ID2) {
		try {
			AppiumDriver<?> driver = MobileDriverFactory.getDriver()
			ArrayList<String> checkDataOne = new ArrayList<String>();
			ArrayList<String> checkDataTwo = new ArrayList<String>();

			checkDataOne = driver.findElementsById(ID1)
			checkDataTwo = driver.findElementsById(ID2)
			String dataOne = (checkDataOne[0]).getText().trim()
			dataOne = dataOne.replace(" ", "");
			String dataTwo = (checkDataTwo[0]).getText().trim()
			dataTwo = dataTwo.replace("\$", "");
			dataTwo = dataTwo.replace(" ", "");
			println('++++++'+dataOne)
			println('++++++'+GlobalVariable.compare_data_one)
			println('------'+dataTwo)
			println('------'+GlobalVariable.compare_data_two)
			if((dataOne.contains(GlobalVariable.compare_data_one) && dataTwo.contains(GlobalVariable.compare_data_two))==false) {
				KeywordUtil.markWarning('*****AMOUNT OR ACCOUNT NAME NOT MATCHING*****')
			}
		}
		catch(Exception e) {
			def helperCommonAction = new helperCommonAction()
			Mobile.takeScreenshot();
			helperCommonAction.startExisitingAPP()
			KeywordUtil.markFailedAndStop('***** ELEMENT ID MAYBE CHANGED *****')
		}
	}

	//collect data for beneficiario
	@Keyword
	public void checkElementPresentTwo (String ID) {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		ArrayList<String> checkData = driver.findElementsById(ID)
		GlobalVariable.transfer_string = (checkData[0]).getText().trim()
		GlobalVariable.transfer_string = GlobalVariable.transfer_string.replace(" ", "");
		(checkData[0]).click()
	}

	//validate data for beneficiario
	@Keyword
	public void dataCheckTwo (String ID1) {
		try {
			AppiumDriver<?> driver = MobileDriverFactory.getDriver()
			ArrayList<String> checkDataOne = new ArrayList<String>();
			checkDataOne = driver.findElementsById(ID1)
			String dataOne = (checkDataOne[0]).getText().trim()
			dataOne = dataOne.replace(" ", "");
			println('------'+dataOne)
			println('------'+GlobalVariable.transfer_string)
			if(dataOne.contains(GlobalVariable.transfer_string)==false) {
				KeywordUtil.markWarning('*****BENEFICIARIO NOT MATCHING*****')
			}
		} catch (Exception e) {
			def helperCommonAction = new helperCommonAction()
			Mobile.takeScreenshot();
			helperCommonAction.startExisitingAPP()
			KeywordUtil.markFailedAndStop('***** ELEMENT ID MAYBE CHANGED *****')
		}
	}

	//checking for error
	@Keyword
	public void checkError (String element) {
		int timer;
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		ArrayList<String> tapElement = new ArrayList<String>();
		for(timer = 0; timer<10000; timer++) {
			if(timer>6) {
				Mobile.takeScreenshot();
				helperCommonAction.startExisitingAPP()
				KeywordUtil.markFailedAndStop('***** '+element+' NOT FOUND OR STUCK ON PROCESS SCREEN *****')
			}
			if(Mobile.verifyElementVisible(findTestObject(element), GlobalVariable.timeOut_4_Sec, FailureHandling.OPTIONAL)==true) {
				break;
				//tap element
				//Mobile.tap(findTestObject(element), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)
			} else {
				//session Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Tu sesin ha expirado. Por favor ingresa nuevamente'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					//helperCommonAction.ContinueButton();
					Mobile.tap(findTestObject('Object Repository/Common Objects/Continuar Button/continue button session expire'), 1, FailureHandling.STOP_ON_FAILURE)
					//AccessoScreen
					helperCommonAction.accessoScreen()
					//error check
					helperCommonAction.errorCheckRegisteration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')
					//Login pin
					helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
					helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
					helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
					helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')
					//Screen
					Mobile.takeScreenshot()
					//check error
					helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
					KeywordUtil.markFailedAndStop('*****SESSION EXPIRED*****')
					break;
				}

				//Internet Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/no internet error'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****NO INTERNET*****')
					break;
				}
				//Service Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true || Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intenta ms tarde'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true || Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Tu requerimiento (msg)'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();
					//back from account selection screen
					if(driver.findElementsById(GlobalVariable.ID+':id/imgBack').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/imgBack')
						tapElement[0].click()
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow')
						tapElement[0].click()
						//error check
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_5_Sec, FailureHandling.OPTIONAL)==true) {
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton();
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
							if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_5_Sec, FailureHandling.OPTIONAL)==true) {
								Mobile.takeScreenshot();
								helperCommonAction.ContinueButton();
							}
						}
						//mark fail
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')

					} else if(driver.findElementsById(GlobalVariable.ID+':id/imageView6').size() > 0) {
						//swipe down
						helperCommonAction.swipeDown()
						/*
						 if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						 tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						 tapElement[0].click()
						 helperCommonAction.AcceptButton();
						 helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						 //mark fail
						 KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')
						 }
						 */
						//tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')

						//back to dashboard from history page
					} else if(driver.findElementsById(GlobalVariable.ID+':id/imageArrowBack').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/imageArrowBack')
						tapElement[0].click()
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow')
						tapElement[0].click()
						//error check
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton();
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
							if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
								Mobile.takeScreenshot();
								helperCommonAction.ContinueButton();
							}
						}
						//mark fail
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')

						//back to dashboard using cancel button
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						//error check
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton();
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
							if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
								Mobile.takeScreenshot();
								helperCommonAction.ContinueButton();
							}
						}
						//mark fail
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')

						//back to dashboard using cancel button
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						//error check
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton();
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
							if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
								Mobile.takeScreenshot();
								helperCommonAction.ContinueButton();
							}
						}
						//mark fail
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')

						//back to dashboard using cancel button
					} else if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						//error check
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton();
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
							if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
								Mobile.takeScreenshot();
								helperCommonAction.ContinueButton();
							}
						}
						//mark fail
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')

					} else if(driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow')
						tapElement[0].click()
						//tap cancelar if present
						Mobile.delay(5)
						if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
							tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
							tapElement[0].click()
							helperCommonAction.AcceptButton();
						}
						//error check
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton();
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
							if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
								Mobile.takeScreenshot();
								helperCommonAction.ContinueButton();
							}
						}
						//mark fail
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')

					} else if(driver.findElementsById(GlobalVariable.ID+':id/imgconsulta').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/imgconsulta')
						tapElement[0].click()
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
							helperCommonAction.ContinueButton();
						}
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow')
						tapElement[0].click()
						//error check
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton();
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
							helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
							if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
								Mobile.takeScreenshot();
								helperCommonAction.ContinueButton();
							}
						}
						//mark fail
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')

					} else if(driver.findElementsById(GlobalVariable.ID+':id/txtnombre').size() > 0) {
						helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
						helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton();
						}
						//mark fail
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/filterAlloption').size() > 0) {
						helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Consulta Button Dashboard')
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/pinText1').size() > 0) {
						//Login pin
						helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
						helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
						helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
						helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')
						//screen
						Mobile.takeScreenshot();
						//error check
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')
					} else {
						KeywordUtil.logInfo('Cant find way to dashboard')
						KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')
					}
					break;
				}

				//Wrong token Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/Incorrect Token Error'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****INCORRECT TOKEN*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****INCORRECT TOKEN*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				//No token Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/No Token Entered'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****ENTER TOKEN*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****ENTER TOKEN*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				//Incomplete Data
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/Incomplete Data'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****INCOMPLETE DATA ERROR*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****INCOMPLETE DATA ERROR*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				//Invalid amount
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Monto invlido. Por favor verifica e intenta de nuevo'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****INVALID AMOUNT ERROR*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****INVALID AMOUNT ERROR*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				//not enough amount
				if(Mobile.verifyElementVisible(findTestObject('Common Objects/Warning_Error Messages/android.widget.TextView - La cuenta origen no posee balance disponible para realizar esta transaccin'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				//not existen permission to carry out transaction
				if(Mobile.verifyElementVisible(findTestObject('Common Objects/Warning_Error Messages/No existen permisos error msg'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NO PERMISSION TO CARRY OUT TRANSACTION*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NO PERMISSION TO CARRY OUT TRANSACTION*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				//ACH/LBTR error of amount larger than source account
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Transferencias/InterBank/ACH_LBTR amount greater than source error'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****ACH LBTR AMOUNT GREATER THAN SOURCE AMOUNT ERROR*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****ACH LBTR AMOUNT GREATER THAN SOURCE AMOUNT ERROR*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				// to/from account amount type should be same
				if(Mobile.verifyElementVisible(findTestObject('Common Objects/Warning_Error Messages/To proceed with transaction amount must be same in from-to (msg)'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****THE AMOUNT TYPE OF TO/FROM ARE NOT SAME*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****THE AMOUNT TYPE OF TO/FROM ARE NOT SAME*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				// EUR/USD should be greater than 1 error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Transferencias/InterBank/Amount should be Greater than 1 USD or EUR'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****THE AMOUNT SHOULD BE GREATER THAN 1 EUR/1 USD EQ*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****THE AMOUNT SHOULD BE GREATER THAN 1 EUR/1 USD EQ*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****THE AMOUNT SHOULD BE GREATER THAN 1 EUR/1 USD EQ*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				//no account desembolso
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/No Account Available'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();
					//mark fail
					KeywordUtil.markFailedAndStop('*****NO DESEMBOLSO ACCOUNT*****')
					break;
				}

				//Invalid Ref Number
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Pagos/Impuestos/Invalid Ref number'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****INVALID REFERENCE NUMBER*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****INVALID REFERENCE NUMBER*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****NOT ENOUGH BALANCE TO CARRY OUT TRANSACTION*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}

				//Transaction Limit Exceed
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Pagos/Impuestos/Transaction amount exceeds'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();
					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****The Transaction amount exceed the authorization limit*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****The Transaction amount exceed the authorization limit*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****The Transaction amount exceed the authorization limit*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}
				// Insufficient Fund to carry Transaction
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/La cuenta origen insufficient balance'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();

					if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/buttonCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****The Source Account Doesnot Have Balance To carry Out This Transaction*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancelar')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****The Source Account Doesnot Have Balance To carry Out This Transaction*****')
					} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
						tapElement = driver.findElementsById(GlobalVariable.ID+':id/btnCancel')
						tapElement[0].click()
						helperCommonAction.AcceptButton();
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//mark fail
						KeywordUtil.markFailedAndStop('*****The Source Account Doesnot Have Balance To carry Out This Transaction*****')
					} else {
						//mark fail
						KeywordUtil.markFailedAndStop('*****Cancel button Object not found pls check*****')
					}
					break;
				}
			}
		}
	}

	//checking for list and select item with accept/reject button
	@Keyword
	public void listItemSelectButton (String ID1, String ID2, String ID3 ,String data) {

		AppiumDriver<?> driver = MobileDriverFactory.getDriver()

		TouchAction touch = new TouchAction(driver)

		boolean flag = false

		ArrayList<String> upper = new ArrayList<String>();

		ArrayList<String> lower = new ArrayList<String>();


		for (int a = 0; !(flag) && (a < 200); a++) {
			ArrayList<String> elements = driver.findElementsById(ID1)

			ArrayList<String> optionArrow = driver.findElementsById(ID2)

			ArrayList<String> acceptBtn = driver.findElementsById(ID3)

			//check if element present or not
			for (int i = 0; i < elements.size(); i++) {
				String actual_Text = (elements[i]).getText().trim()

				if (actual_Text.contains(data)) {
					flag = true
					if(elements.size() == optionArrow.size()) {
						if(acceptBtn.size()>elements.size()) {
							Mobile.takeScreenshot();
							(optionArrow[i]).click()
							Mobile.takeScreenshot();
							(acceptBtn[i+1]).click()
						}
						else {
							Mobile.takeScreenshot();
							(optionArrow[i]).click()
							Mobile.takeScreenshot();
							(acceptBtn[i]).click()
						}
					}
					else if(elements.size()<optionArrow.size()){
						Mobile.takeScreenshot();
						(optionArrow[i+1]).click()
						Mobile.takeScreenshot();
						(acceptBtn[i+1]).click()
					}
					else if(elements.size()>optionArrow.size()) {
						if(i == elements.size()-1) {
							flag=false
							break
						}
						else {
							Mobile.takeScreenshot();
							(optionArrow[i]).click()
							Mobile.takeScreenshot();
							(acceptBtn[i]).click()
						}
					}
					break
				}
			}
			Mobile.delay(5)
			//scroll
			if (!(flag)) {
				upper = driver.findElementsById(GlobalVariable.ID+':id/txtdata')
				lower = driver.findElementsById(GlobalVariable.ID+':id/txtmonto')
				def bottomElement = ElementOption.element(lower[(lower.size() - 1)])
				def topElement = ElementOption.element(upper[0])
				touch.longPress(bottomElement).moveTo(topElement).release().perform()
				Mobile.takeScreenshot();
			}
		}
	}

	@Keyword
	public void startExisitingAPP () {
		def helperCommonAction = new helperCommonAction()
		//close app
		Mobile.closeApplication()
		//start app
		String host = RunConfiguration.getExecutionProfile()
		if(host.contains("Remote")) {
			Mobile.startExistingApplication(GlobalVariable.ID)
		} else {
			Mobile.startApplication(GlobalVariable.appPath, false)
		}

		//accessoScreen
		helperCommonAction.accessoScreen();
		//error check
		helperCommonAction.errorCheckRegisteration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element')
		//Login pin
		helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
		helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
		helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
		helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')
		//screen
		Mobile.takeScreenshot();
		//error check
		helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
	}

	//custom tap
	@Keyword
	public void tapWithCheck (String verify, String element) {
		try {
			if(Mobile.verifyElementVisible(findTestObject(verify), GlobalVariable.timeOut_30_Sec) == true ) {
				//take screenshot
				Mobile.takeScreenshot();
				//tap element
				Mobile.tap(findTestObject(element), GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)
			}
		}
		catch(Exception e) {
			def helperCommonAction = new helperCommonAction()
			Mobile.takeScreenshot();
			helperCommonAction.startExisitingAPP()
			KeywordUtil.markFailedAndStop(element+' Not found')
		}
	}

	//custom tap v2 for continue after successful payment
	@Keyword
	public void tapWithCheckv2 (String verify, String text, String element) {
		try {
			if(Mobile.verifyElementVisible(findTestObject(verify), GlobalVariable.timeOut_30_Sec) == true ) {
				//take screenshot
				Mobile.takeScreenshot();
				//scroll to element
				Mobile.scrollToText(text, FailureHandling.OPTIONAL)
				//tap element
				Mobile.tap(findTestObject(element), GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)
			}
		}
		catch(Exception e) {
			def helperCommonAction = new helperCommonAction()
			Mobile.takeScreenshot();
			helperCommonAction.startExisitingAPP()
			KeywordUtil.markFailedAndStop(element+' Not found')
		}
	}

	//custom tap for registration
	@Keyword
	public void tapForRegistration (String verify, String element) {
		try {
			if(Mobile.verifyElementVisible(findTestObject(verify), GlobalVariable.timeOut_30_Sec) == true ) {
				//take screenshot
				Mobile.takeScreenshot();
				//tap element
				Mobile.tap(findTestObject(element), GlobalVariable.timeOut_15_sec, FailureHandling.STOP_ON_FAILURE)
			}
		}
		catch(Exception e) {
			Mobile.takeScreenshot();
			KeywordUtil.markFailedAndStop('****" '+element+' " not found****')
		}
	}

	//error check + handling for approve/reject
	@Keyword
	public void errorCheckApproveReject (String element) {
		int timer;
		def helperCommonAction = new helperCommonAction()
		for(timer = 0; timer<10000; timer++) {
			if(timer>25) {
				Mobile.takeScreenshot();
				KeywordUtil.markFailedAndStop('*****TAKING TO LONG*****')
			}
			if(Mobile.verifyElementVisible(findTestObject(element), GlobalVariable.timeOut_4_Sec, FailureHandling.OPTIONAL)==true) {
				break;
			} else {
				//Internet Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/no internet error'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****NO INTERNET*****')
					break;
				}
				//Service Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();
					helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
					helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard')
				}

				//No transaction
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/No Transaction Found'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****NO TRANSACTION*****')
				}
			}
		}

	}

	//error check for registration
	@Keyword
	public void errorCheckRegisteration (String element) {
		int timer;
		def helperCommonAction = new helperCommonAction()
		for(timer = 0; timer<10000; timer++) {
			if(timer>10) {
				Mobile.takeScreenshot();
				KeywordUtil.markFailedAndStop('*****NO ERROR POPUP BUT STUCK ON SAME SCREEN*****')
			}
			if(Mobile.verifyElementVisible(findTestObject(element), GlobalVariable.timeOut_4_Sec, FailureHandling.OPTIONAL)==true) {
				break;
			} else {
				//Internet Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/no internet error'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****NO INTERNET*****')
					break;
				}
				//Service Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true || Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Tu requerimiento (msg)'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****SERVICE ERROR*****')
					break;
				}
				//Incorrect username or password
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Por favor confirme su usuario yo contrasea y digtelos nuevamente'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****INCORRECT USERNAME OR PASSWORD*****')
					break;
				}
				//pin not correct
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/Incorrect Pin'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****PIN IS INCORRECT*****')
					break;
				}
				//Pin not matched Error
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/Pin Not Matched'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****PIN NOT MATCHED*****')
					break;
				}
				//Token not correct
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/Incorrect Token Error'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****INCORRECT TOKEN*****')
					break;
				}
				//Access not validated
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Credential Screen/Access not been validated error message'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					KeywordUtil.markFailedAndStop('*****ACCESS NOT VALIDATED ERROR*****')
					break;
				}
			}
		}

	}

	//checking for account have permission then click on it
	@Keyword
	public void lastElementInList () {
		def helperCommonAction = new helperCommonAction()

		//check error
		helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/First Transaction In List')

		//variables
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		ArrayList<String> accountName = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> listtwo = new ArrayList<String>();

		//getting account count
		boolean check = false
		for (int a = 0; !(check) && (a < 10000); a++) {
			list = driver.findElementsById(GlobalVariable.ID+':id/txtDateTime')
			for (GlobalVariable.index2; GlobalVariable.index2 < list.size(); GlobalVariable.index2++) {
				String actual_Text = (list[GlobalVariable.index2]).getText().trim()
				if(accountName.contains(actual_Text)==false) {
					accountName.add(actual_Text)
					GlobalVariable.counter = accountName.size();
				}
			}
			String lastElement = (list[list.size()-1]).getText().trim()
			if (GlobalVariable.index2.equals(list.size())) {
				GlobalVariable.index2 = 0;
				def bottomElement = ElementOption.element(list[(list.size() - 1)])
				def topElement = ElementOption.element(list[0])
				touch.longPress(bottomElement).moveTo(topElement).release().perform()
			}

			listtwo = driver.findElementsById(GlobalVariable.ID+':id/txtDateTime')
			String crosschecklastElement = (listtwo[listtwo.size()-1]).getText().trim()
			//println('----------'+crosschecklastElement)
			if(lastElement.equals(crosschecklastElement)) {
				check = true
				GlobalVariable.lastElement = crosschecklastElement
				println('+++++++++++++++'+(GlobalVariable.lastElement))
			}
		}
		GlobalVariable.index2 = 0;
		helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
		helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard')
	}

	//payment type access check
	@Keyword
	public void checkPermissionPaymentType (String ID, String msg) {
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		ArrayList<String> element = new ArrayList<String>();
		//error check
		helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
		element = driver.findElementsById(ID);
		String dataOne =  element[0].getAttribute("clickable");
		if(dataOne.contains('true')) {
			(element[0]).click()
			Mobile.delay(3)
			Mobile.takeScreenshot();
		} else {
			Mobile.delay(3)
			Mobile.takeScreenshot();
			//tap burger menu
			helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
			//tap dashboard in burger menu
			helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
			//check error
			helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
			KeywordUtil.markFailedAndStop('***** '+msg+' not accessible*****')
		}
	}

	//interbank data collect
	@Keyword
	public void dataCollectForinterbank (String one, String two, String three, String four, String five, String six) {
		try {
			def helperCommonAction = new helperCommonAction()
			AppiumDriver<?> driver = MobileDriverFactory.getDriver()
			ArrayList<String> dataone = new ArrayList<String>();
			ArrayList<String> datatwo = new ArrayList<String>();
			ArrayList<String> datathree = new ArrayList<String>();
			//ArrayList<String> datafour = new ArrayList<String>();
			//ArrayList<String> datafive = new ArrayList<String>();
			//ArrayList<String> datasix = new ArrayList<String>();

			dataone = driver.findElementsById(one)
			datatwo = driver.findElementsById(two)
			datathree = driver.findElementsById(three)
			//datafour = driver.findElementsById(four)
			//datafive = driver.findElementsById(five)
			//datasix = driver.findElementsById(six)

			GlobalVariable.compare_data_one = (dataone[0]).getText().trim()
			GlobalVariable.compare_data_two = (datatwo[0]).getText().trim()
			GlobalVariable.compare_data_three = (datathree[0]).getText().trim()
			//GlobalVariable.compare_data_four = (datafour[0]).getText().trim()
			//GlobalVariable.compare_data_five = (datafive[0]).getText().trim()
			//GlobalVariable.compare_data_six = (datasix[0]).getText().trim()
			Mobile.scrollToText('Continuar')
		} catch(Exception e) {
			def helperCommonAction = new helperCommonAction()
			Mobile.takeScreenshot();
			helperCommonAction.startExisitingAPP()
			KeywordUtil.markFailedAndStop('***** ELEMENT ID MAYBE CHANGED *****')
		}
	}

	//interbank data check
	@Keyword
	public void dataCheckForinterbank (String one, String two, String three, String four, String five, String six) {
		try {
			def helperCommonAction = new helperCommonAction()
			AppiumDriver<?> driver = MobileDriverFactory.getDriver()
			ArrayList<String> dataone = new ArrayList<String>();
			ArrayList<String> datatwo = new ArrayList<String>();
			ArrayList<String> datathree = new ArrayList<String>();
			//ArrayList<String> datafour = new ArrayList<String>();
			//ArrayList<String> datafive = new ArrayList<String>();
			//ArrayList<String> datasix = new ArrayList<String>();

			dataone = driver.findElementsById(one)
			datatwo = driver.findElementsById(two)
			datathree = driver.findElementsById(three)
			//datafour = driver.findElementsById(four)
			//datafive = driver.findElementsById(five)
			//datasix = driver.findElementsById(six)

			String dataOne = (dataone[0]).getText().trim()
			String dataTwo = (datatwo[0]).getText().trim()
			String dataThree = (datathree[0]).getText().trim()
			//String dataFour = (datafour[0]).getText().trim()
			//String dataFive = (datafive[0]).getText().trim()
			//String dataSix = (datasix[0]).getText().trim()

			println('---------'+dataOne)
			println('---------'+GlobalVariable.compare_data_one)
			println('---------'+dataTwo)
			println('---------'+GlobalVariable.compare_data_two)
			println('---------'+dataThree)
			println('---------'+GlobalVariable.compare_data_three)
			//println('---------'+dataFour)
			//println('---------'+GlobalVariable.compare_data_four)
			//println('---------'+dataFive)
			//println('---------'+GlobalVariable.compare_data_five)
			//println('---------'+dataSix)
			//println('---------'+GlobalVariable.compare_data_six)


			if((dataOne.contains(GlobalVariable.compare_data_one) && dataTwo.contains(GlobalVariable.compare_data_two) && dataThree.contains(GlobalVariable.compare_data_three) /*&& dataFour.contains(GlobalVariable.compare_data_four) && dataFive.contains(GlobalVariable.compare_data_five) && dataSix.contains(GlobalVariable.compare_data_six)*/)==false) {
				KeywordUtil.markWarning('*****DETAILS NOT MATCHING*****')
			}
		} catch(Exception e) {
			def helperCommonAction = new helperCommonAction()
			Mobile.takeScreenshot();
			helperCommonAction.startExisitingAPP()
			KeywordUtil.markFailedAndStop('***** ELEMENT ID MAYBE CHANGED *****')
		}
	}

	//Go back from internal account selection screen if no account is visible
	@Keyword
	public void goBackFromAccountSelectionScreen () {
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		Mobile.takeScreenshot();
		ArrayList<String> tapElement = new ArrayList<String>();

		try {
			tapElement = driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow')
			tapElement[0].click()
		}catch(Exception e){
			int device_Height = Mobile.getDeviceHeight()
			int device_Width = Mobile.getDeviceWidth()
			int startX = device_Width / 2
			int endX = startX
			int startY = device_Height * 0.20
			int endY = device_Height * 0.90
			Mobile.swipe(startX, startY, endX, endY)
		}

		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)==true) {
			helperCommonAction.ContinueButton();
		}

		try {
			Mobile.scrollToText('Cancelar', FailureHandling.CONTINUE_ON_FAILURE)
		}catch(Exception e){
			Mobile.takeScreenshot();
			KeywordUtil.logInfo("Cancelar not visible please check!!!")
		}

		if(driver.findElementsById(GlobalVariable.ID+':id/btnCancelar').size() > 0) {
			driver.findElementById(GlobalVariable.ID+':id/btnCancelar').click()
		} else if(driver.findElementsById(GlobalVariable.ID+':id/buttonCancel').size() > 0) {
			driver.findElementById(GlobalVariable.ID+':id/buttonCancel').click()
		} else if(driver.findElementsById(GlobalVariable.ID+':id/btnCancel').size() > 0) {
			driver.findElementById(GlobalVariable.ID+':id/btnCancel').click()
		} else {
			Mobile.takeScreenshot();
			helperCommonAction.startExisitingAPP()
			KeywordUtil.markFailedAndStop('Continuar Not found / Object maybe changed!')
		}

		helperCommonAction.AcceptButton();
		//Error check
		helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard')
		KeywordUtil.markFailedAndStop('*****NO ACCOUNT VISIBLE IN LIST/GIVEN COMPANY OR ACCOUNT NOT FOUND*****')
	}

	//custom account permission check
	@Keyword
	public void permissionCheckOfAccounts (String one, String two, String three, String four, String five, String six, String seven, String eight, String company, String Amounttype, String AmountTypeID) {
		//variables
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		ArrayList<String> accountName = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> listtwo = new ArrayList<String>();
		ArrayList<String> accountBalance = new ArrayList<String>();

		//getting account count
		boolean check = false
		for (int a = 0; !(check) && (a < 10000); a++) {
			list = driver.findElementsById(one)
			for (GlobalVariable.index2; GlobalVariable.index2 < list.size(); GlobalVariable.index2++) {
				String actual_Text = (list[GlobalVariable.index2]).getText().trim()
				if(accountName.contains(actual_Text)==false) {
					accountName.add(actual_Text)
					GlobalVariable.counter = accountName.size();
				}
			}
			String lastElement = (list[list.size()-1]).getText().trim()
			if(list.size()!=1) {
				if (GlobalVariable.index2.equals(list.size())) {
					GlobalVariable.index2 = 0;
					def bottomElement = ElementOption.element(list[(list.size() - 1)])
					def topElement = ElementOption.element(list[0])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}
			}
			listtwo = driver.findElementsById(one)
			String crosschecklastElement = (listtwo[listtwo.size()-1]).getText().trim()

			if(lastElement.equals(crosschecklastElement)) {
				check = true
				accountBalance = driver.findElementsById(two)
				GlobalVariable.lastBalance = (accountBalance[accountBalance.size()-1]).getText().trim()
				String lastAccountInList = crosschecklastElement.substring(crosschecklastElement.length() - 4);
				GlobalVariable.lastElement = lastAccountInList
				KeywordUtil.logInfo('Last Element '+GlobalVariable.lastElement)
				KeywordUtil.logInfo('Last Balance '+GlobalVariable.lastBalance)
			}
		}

		GlobalVariable.index2 = 0;

		//account checking starts from here

		//tap burger menu
		helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
		//tap dashboard in burger menu
		helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
		//check Error
		helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
		//check for multiple company
		helperCommonAction.checkAndSelectCompany(company)
		//Tap Cuentas/prestamo/tarjeta
		if(six.equals('Object Repository/Pagos/Tarjeta/Tarjeta Dashboard') || six.equals('Object Repository/Consultas/Certificado/Inversiones Dashboard')) {
			//tap prestamo
			//helperCommonAction.checkPermissionPaymentType(GlobalVariable.ID+':id/filterPrestamosoption', 'Préstamos')

			//swipe right to left
			MobileElement Element = driver.findElement(By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'Préstamos' or . = 'Préstamos') and @resource-id = 'com.popular.app.corp:id/filterPrestamosoption']"))

			int startX = Element.getLocation().getX()
			int startY = Element.getLocation().getY()
			int endX = 1
			int endY = startY
			Mobile.swipe(startX, startY, endX, endY, FailureHandling.OPTIONAL)


			helperCommonAction.tapWithCheck(six,six)
		} else {
			helperCommonAction.tapWithCheck(six,six)
		}

		//variables
		ArrayList<String> listhree = new ArrayList<String>();
		ArrayList<String> initialList = new ArrayList<String>();
		ArrayList<String> nameCheck = new ArrayList<String>();
		ArrayList<String> balCheck = new ArrayList<String>();
		ArrayList<String> currencyCheck = new ArrayList<String>();
		boolean checktwo = false
		String name = ''
		String balance = ''

		for (int b = 0; !(checktwo) && (b < 10); b++) {
			initialList = driver.findElementsById(two)
			for (GlobalVariable.index2; GlobalVariable.index2 < initialList.size(); GlobalVariable.index2++) {
				listhree = driver.findElementsById(two)
				KeywordUtil.logInfo('Total Visible on screen '+initialList.size())
				KeywordUtil.logInfo('clicking '+GlobalVariable.index2)
				KeywordUtil.logInfo('swipe '+GlobalVariable.count)
				Mobile.delay(5)
				(listhree[GlobalVariable.index2]).click()
				Mobile.delay(5)
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intente ms tarde'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true || Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Su requerimiento no pudo ser completado. Por favor intenta ms tarde'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true || Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Tu requerimiento (msg)'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true || Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Esta cuenta no tiene ningn permiso'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
					Mobile.takeScreenshot();
					helperCommonAction.ContinueButton();
					//AccessoScreen
					helperCommonAction.accessoScreen()
					if(driver.findElementsById(GlobalVariable.ID+':id/pinText1').size() > 0) {
						//Login pin
						helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 1')
						helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 2')
						helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 3')
						helperCommonAction.tapForRegistration('Object Repository/Login/Login_Pin Screen/Login_Pin Screen - Element', 'Object Repository/Login/Login_Pin Screen/android.widget.Button - 4')
						//screen
						Mobile.takeScreenshot();
						//error check
						helperCommonAction.errorCheckRegisteration('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//check for multiple company
						helperCommonAction.checkAndSelectCompany(company)
						//Tap Cuentas/prestamo/tarjeta
						if(six.equals('Object Repository/Pagos/Tarjeta/Tarjeta Dashboard') || six.equals('Object Repository/Consultas/Certificado/Inversiones Dashboard')) {
							//tap prestamo
							//helperCommonAction.checkPermissionPaymentType(GlobalVariable.ID+':id/filterPrestamosoption', 'Préstamos')

							//swipe right to left
							MobileElement Element = driver.findElement(By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'Préstamos' or . = 'Préstamos') and @resource-id = 'com.popular.app.corp:id/filterPrestamosoption']"))

							int startX = Element.getLocation().getX()
							int startY = Element.getLocation().getY()
							int endX = 1
							int endY = startY
							Mobile.swipe(startX, startY, endX, endY, FailureHandling.OPTIONAL)

							helperCommonAction.tapWithCheck(six,six)
						} else {
							helperCommonAction.tapWithCheck(six,six)
						}
						for(int swiper = 0; swiper < GlobalVariable.count; swiper++) {
							listhree = driver.findElementsById(two)
							def bottomElement = ElementOption.element(listhree[(listhree.size() - 1)])
							def topElement = ElementOption.element(listhree[0])
							touch.longPress(bottomElement).moveTo(topElement).release().perform()
						}
					}
					KeywordUtil.markWarning('*****ACCOUNT DOESNT HAVE PERMISSION OR SERVICE ERROR WHILE SELECTING*****')
				} else {
					KeywordUtil.logInfo('Entering else part where check error is present ')
					//check error
					helperCommonAction.checkError(seven)

					currencyCheck = driver.findElementsById(three)
					String currency = (currencyCheck[0]).getText().trim()
					ArrayList<String> amountType = new ArrayList<String>();
					amountType = driver.findElementsById(AmountTypeID)
					String amttype = (amountType[0]).getText().trim()

					if(currency.contains(five) && amttype.contains(Amounttype)) {
						//**//
						GlobalVariable.index2 = 0;
						GlobalVariable.count = 0;
						checktwo = true;
						//**//
						//test case name
						Mobile.comment(GlobalVariable.testCaseName)
						if((GlobalVariable.testCaseName).equals('APPEMP_ConsultaCuentasAhorro') || (GlobalVariable.testCaseName).equals('APPEMP_ConsultaCuentasCorrientes') || (GlobalVariable.testCaseName).equals('APPEMP_ConsultaPrestamos') || (GlobalVariable.testCaseName).equals('APPEMP_ConsultasCertificados') || (GlobalVariable.testCaseName).equals('APPEMP_ConsultaTarjetasCreditoFDR') || (GlobalVariable.testCaseName).equals('APPEMP_ConsultaTarjetasCreditoLocal')) {
							checktwo = true;
							break;
						}

						//tap transfer or pagar
						helperCommonAction.tapWithCheck(eight, eight)

						if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/android.widget.TextView - Esta cuenta no tiene ningn permiso'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
							/*Mobile.takeScreenshot();
							 helperCommonAction.ContinueButton();
							 KeywordUtil.markWarning('*****ACCOUNT DOESNT HAVE PERMISSION*****')
							 if(name.equalsIgnoreCase(GlobalVariable.lastElement)) {
							 GlobalVariable.index2 = 0;
							 GlobalVariable.lastElement = '';
							 GlobalVariable.count = 0;
							 helperCommonAction.BackButton()
							 KeywordUtil.markFailedAndStop('***** '+five+' TYPE OF ACCOUNT NOT FOUND WITH VALID PERMISSION/SERVICE ERROR FROM DASHBOARD*****')
							 }
							 //tap back button
							 helperCommonAction.BackButton()
							 //error check
							 helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
							 //check for multiple company
							 helperCommonAction.checkAndSelectCompany(company)
							 //Tap Cuentas/prestamo/tarjeta
							 if(six.equals('Object Repository/Pagos/Tarjeta/Tarjeta Dashboard')) {
							 //tap prestamo
							 helperCommonAction.checkPermissionPaymentType(GlobalVariable.ID+':id/filterPrestamosoption', 'Préstamos')
							 helperCommonAction.tapWithCheck(six,six)
							 } else {
							 helperCommonAction.tapWithCheck(six,six)
							 }
							 for(int i=0; i<GlobalVariable.count && checktwo == false; i++) {
							 listhree = driver.findElementsById(two)
							 def bottomElement = ElementOption.element(listhree[(listhree.size() - 1)])
							 def topElement = ElementOption.element(listhree[0])
							 touch.longPress(bottomElement).moveTo(topElement).release().perform()
							 }*/
							Mobile.takeScreenshot();
							helperCommonAction.ContinueButton();
							//tap back button
							helperCommonAction.BackButton()
							//error check
							helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
							KeywordUtil.markFailedAndStop('***** '+five+' TYPE OF ACCOUNT NOT FOUND WITH VALID PERMISSION/SERVICE ERROR FROM DASHBOARD*****')

							//pagar in Tarjeta
						} else if(driver.findElementsById(GlobalVariable.ID+':id/rel_pagos').size() > 0) {
							ArrayList<String> button = new ArrayList<String>();
							button = driver.findElementsById(GlobalVariable.ID+':id/rel_pagos');
							String dataOne =  button[0].getAttribute("enabled");
							if(dataOne.contains('true')) {
								(button[0]).click()
								Mobile.takeScreenshot();
							} else {
								Mobile.takeScreenshot();
								//tap back button
								helperCommonAction.BackButton()
								//error check
								helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
								KeywordUtil.markFailedAndStop('***** '+five+' TYPE OF ACCOUNT NOT FOUND WITH VALID PERMISSION/SERVICE ERROR FROM DASHBOARD*****')
							}
						} else {
							GlobalVariable.index2 = 0;
							GlobalVariable.count = 0;
							checktwo = true;
							break;
						}
					} else {
						nameCheck = driver.findElementsById(four)
						name = (nameCheck[0]).getText().trim()
						String res = name.substring(name.length() - 4)

						if(driver.findElementsById(GlobalVariable.ID+':id/txtBalanceFecha').size() > 0) {
							balCheck = driver.findElementsById(GlobalVariable.ID+':id/txtBalanceFecha')
						} else if(driver.findElementsById(GlobalVariable.ID+':id/txtDisponible').size() > 0) {
							balCheck = driver.findElementsById(GlobalVariable.ID+':id/txtDisponible')
						}
						else {
							balCheck = driver.findElementsById(GlobalVariable.ID+':id/balanceALaFecha')
						}

						balance = (balCheck[0]).getText().trim()
						if(res.equalsIgnoreCase(GlobalVariable.lastElement) && balance.equals(GlobalVariable.lastBalance)) {
							GlobalVariable.index2 = 0;
							GlobalVariable.lastElement = '';
							GlobalVariable.count = 0;
							helperCommonAction.BackButton()
							KeywordUtil.markFailedAndStop('***** '+five+' TYPE OF ACCOUNT NOT FOUND WITH VALID PERMISSION/SERVICE ERROR FROM DASHBOARD*****')
						}

						//tap back button
						helperCommonAction.BackButton()
						//error check
						helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
						//check for multiple company
						helperCommonAction.checkAndSelectCompany(company)
						//Tap Cuentas/prestamo/tarjeta
						if(six.equals('Object Repository/Pagos/Tarjeta/Tarjeta Dashboard')) {
							//tap prestamo
							//helperCommonAction.checkPermissionPaymentType(GlobalVariable.ID+':id/filterPrestamosoption', 'Préstamos')

							//swipe right to left
							MobileElement Element = driver.findElement(By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'Préstamos' or . = 'Préstamos') and @resource-id = 'com.popular.app.corp:id/filterPrestamosoption']"))

							int startX = Element.getLocation().getX()
							int startY = Element.getLocation().getY()
							int endX = 1
							int endY = startY
							Mobile.swipe(startX, startY, endX, endY, FailureHandling.OPTIONAL)

							helperCommonAction.tapWithCheck(six,six)
						} else {
							helperCommonAction.tapWithCheck(six,six)
						}

						for(int i=0; i<GlobalVariable.count && checktwo == false; i++) {
							listhree = driver.findElementsById(two)
							def bottomElement = ElementOption.element(listhree[(listhree.size() - 1)])
							def topElement = ElementOption.element(listhree[0])
							touch.longPress(bottomElement).moveTo(topElement).release().perform()
						}
					}
				}
			}

			if(!checktwo) {
				ArrayList<String> accountNameBefore = new ArrayList<String>();
				accountNameBefore = driver.findElementsById(one)

				ArrayList<String> accountBalBefore = new ArrayList<String>();
				accountBalBefore = driver.findElementsById(two)

				String beforeswipetop = (accountNameBefore[0]).getText().trim()
				String beforeswipebottom = (accountNameBefore[(accountNameBefore.size() - 1)]).getText().trim()
				String beforeSwipeBal = (accountBalBefore[0]).getText().trim()
				String beforeSwipeBalBottom = (accountBalBefore[(accountBalBefore.size() - 1)]).getText().trim()

				if (GlobalVariable.index2.equals(initialList.size()) && initialList.size()>1) {
					GlobalVariable.index2 = 0;
					GlobalVariable.count+=1
					listhree = driver.findElementsById(two)
					def bottomElement = ElementOption.element(listhree[(listhree.size() - 1)])
					def topElement = ElementOption.element(listhree[0])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}

				ArrayList<String> accountNameAfter = new ArrayList<String>();
				accountNameAfter = driver.findElementsById(one)

				ArrayList<String> accountBalAfter = new ArrayList<String>();
				accountBalAfter = driver.findElementsById(two)

				String afterswipetop = (accountNameAfter[0]).getText().trim()
				String afterswipebottom = (accountNameAfter[(accountNameAfter.size() - 1)]).getText().trim()
				String afterSwipeBal = (accountBalAfter[0]).getText().trim()
				String afterSwipeBalBottom = (accountBalAfter[(accountBalAfter.size() - 1)]).getText().trim()

				if(beforeswipetop.equals(afterswipetop) && beforeswipebottom.equals(afterswipebottom) && beforeSwipeBal.equals(afterSwipeBal) && beforeSwipeBalBottom.equals(afterSwipeBalBottom)) {
					//tap burger menu
					helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Burger Menu', 'Object Repository/Common Objects/Burger Menu/Burger Menu')
					//tap dashboard in burger menu
					helperCommonAction.tapWithCheck('Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu', 'Object Repository/Common Objects/Burger Menu/Dashboard in Burger Menu')
					//check error
					helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
					//check for multiple company
					KeywordUtil.markFailedAndStop('***** '+five+' TYPE OF ACCOUNT NOT FOUND WITH VALID PERMISSION/SERVICE ERROR FROM DASHBOARD*****')
				}
			}
		}
	}


	//Checks for multiple company if found select it
	@Keyword
	public void checkAndSelectCompany (String industry) {
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		ArrayList<String> selectAccount = new ArrayList<String>();

		//from dashboard
		if(driver.findElementsById(GlobalVariable.ID+':id/txtname').size() > 1) {
			selectAccount = driver.findElementsById(GlobalVariable.ID+':id/txtname')
			boolean flag = false
			for(int i = 0; !(flag) && (i < 100); i++) {
				String check = selectAccount[i].getText().trim()
				if(check.equals(industry)) {
					flag = true;
					selectAccount[i].click()
					if(Mobile.verifyElementVisible(findTestObject('Object Repository/Consultas/Entre Cuenta/CuentasOption'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==false)
					{
						selectAccount[i].click()

					}
					//Check for account
					if(Mobile.verifyElementVisible(findTestObject('Object Repository/Common Objects/Warning_Error Messages/no multiple account msg'), GlobalVariable.timeOut_1_Sec, FailureHandling.OPTIONAL)==true) {
						Mobile.takeScreenshot();
						selectAccount[i].click()
						KeywordUtil.markFailedAndStop('*****NO ACCOUNT IN LIST*****')
					}
					break;

				}
			}
		}

		//from inside payments
		if(driver.findElementsById(GlobalVariable.ID+':id/heading').size() > 1) {
			ArrayList<String> accountName = new ArrayList<String>();
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> listtwo = new ArrayList<String>();
			ArrayList<String> accountChecker = new ArrayList<String>();

			//get company count
			boolean stat = false
			for (int a = 0; !(stat) && (a < 10000); a++) {
				list = driver.findElementsById(GlobalVariable.ID+':id/heading')
				for (GlobalVariable.index2; GlobalVariable.index2 < list.size(); GlobalVariable.index2++) {
					String actual_Text = (list[GlobalVariable.index2]).getText().trim()
					if(accountName.contains(actual_Text)==false) {
						accountName.add(actual_Text)
						GlobalVariable.counter = accountName.size();
					}
				}
				String lastElement = (list[list.size()-1]).getText().trim()
				if (GlobalVariable.index2.equals(list.size())) {
					GlobalVariable.index2 = 0;
					def bottomElement = ElementOption.element(list[(list.size() - 1)])
					def topElement = ElementOption.element(list[0])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}

				listtwo = driver.findElementsById(GlobalVariable.ID+':id/heading')
				String crosschecklastElement = (listtwo[listtwo.size()-1]).getText().trim()
				if(lastElement.equals(crosschecklastElement)) {
					stat = true
					GlobalVariable.lastElement = crosschecklastElement
					println('+++++++++++++++'+(GlobalVariable.lastElement))
				}
			}
			GlobalVariable.index2 = 0;

			//swipe down
			helperCommonAction.swipeDown()

			//un-select not required company
			boolean flag = false
			for (int a = 0; !(flag) && (a < 200); a++) {
				selectAccount = driver.findElementsById(GlobalVariable.ID+':id/heading')
				for(GlobalVariable.index2; GlobalVariable.index2 < selectAccount.size(); GlobalVariable.index2++) {
					String check = selectAccount[GlobalVariable.index2].getText().trim()
					KeywordUtil.logInfo(check)
					if(!(check.equals(industry))) {
						if(accountChecker.contains(check)==false) {
							accountChecker.add(check)
							selectAccount[GlobalVariable.index2].click()
							selectAccount = driver.findElementsById(GlobalVariable.ID+':id/heading')
						} else if(check.equals(GlobalVariable.lastElement)){
							GlobalVariable.index2 = 0;
							flag = true
							break;
						}
					}
				}

				String lastElement = (selectAccount[selectAccount.size()-1]).getText().trim()

				if (GlobalVariable.index2.equals(selectAccount.size())) {
					GlobalVariable.index2 = 0;
					def bottomElement = ElementOption.element(selectAccount[(selectAccount.size() - 1)])
					def topElement = ElementOption.element(selectAccount[0])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}

				listtwo = driver.findElementsById(GlobalVariable.ID+':id/heading')
				String crosscheck = (listtwo[listtwo.size()-1]).getText().trim()
				if(lastElement.equals(crosscheck)) {
					GlobalVariable.index2 = 0;
					flag = true
				}

			}
		}
	}

	//Multiple Continue Button's
	@Keyword
	public void ContinueButton () {
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		Mobile.takeScreenshot();
		try {
			helperCommonAction.swipeUP()
		} catch(Exception e) {
			Mobile.comment('Could not perform swipe')
		}
		//try to tap with object
		if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 1 (service error)'), 3, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 1 (service error)'), 3, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 2'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 2'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 3'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 3'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 4'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 4'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 5'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 5'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 6'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 6'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 7'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 7'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 8'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 8'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/OK Button/OK Button'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/OK Button/OK Button'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 9'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 9'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Common Objects/Continuar Button/continue button 10'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Common Objects/Continuar Button/continue button 10'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Continuar Button/continue button 11'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Continuar Button/continue button 11'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Continuar Button/continue button 12'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Continuar Button/continue button 12'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Continuar Button/continue button 13'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Continuar Button/continue button 13'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Continuar Button/Continue button 14'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Continuar Button/Continue button 14'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Continuar Button/Continue button 16'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Continuar Button/Continue button 16'), 1, FailureHandling.OPTIONAL)
		}else {
			//try to tap with ID's
			if(driver.findElementsById(GlobalVariable.ID+':id/btnContinuar').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/btnContinuar').click()
			} else if(driver.findElementsById('android:id/button1').size() > 0) {
				driver.findElementById('android:id/button1').click()
			} else if(driver.findElementsById(GlobalVariable.ID+':id/btncontinue').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/btncontinue').click()
			}  else if(driver.findElementsById(GlobalVariable.ID+':id/btnCreatePin').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/btnCreatePin').click()
			} else if(driver.findElementsById(GlobalVariable.ID+':id/buttonContinue').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/buttonContinue').click()
			} else if(driver.findElementsById(GlobalVariable.ID+':id/btnContinue').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/btnContinue').click()
			} else if(driver.findElementsById(GlobalVariable.ID+':id/btnContinueActive').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/btnContinueActive').click()
			} else if(driver.findElementsById(GlobalVariable.ID+':id/txtContinue').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/txtContinue').click()
			}else {
				Mobile.takeScreenshot();
				helperCommonAction.startExisitingAPP()
				KeywordUtil.markFailedAndStop('Continuar Not found / Object maybe changed!')
			}
		}
	}

	//Multiple accept Button's
	@Keyword
	public void AcceptButton () {
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		//try to tap with object
		if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Acceptar Button/Accept Button 1'), 3, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Acceptar Button/Accept Button 1'), 3, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Acceptar Button/Accept Button 2'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Acceptar Button/Accept Button 2'), 1, FailureHandling.OPTIONAL)
		} else {
			//try to tap with ID's
			if(driver.findElementsById(GlobalVariable.ID+':id/btnaccept').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/btnaccept').click()
			} else if(driver.findElementsById('android:id/button1').size() > 0) {
				driver.findElementById('android:id/button1').click()
			} else {
				Mobile.takeScreenshot();
				helperCommonAction.startExisitingAPP()
				KeywordUtil.markFailedAndStop('Acceptar Not found / Object maybe changed!')
			}
		}
	}

	//Multiple back Button's
	@Keyword
	public void BackButton () {
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		//try to tap with object
		if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Back Button/Back Button 1'), 3, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Back Button/Back Button 1'), 3, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Back Button/Back Button 2'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Back Button/Back Button 2'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Back Button/Back Button 3'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Back Button/Back Button 3'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Back Button/Back Button 4'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Back Button/Back Button 4'), 1, FailureHandling.OPTIONAL)
		} else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Common Objects/Back Button/Back Button 5'), 1, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Common Objects/Back Button/Back Button 5'), 1, FailureHandling.OPTIONAL)
		} else {
			//try to tap with ID's
			if(driver.findElementsById(GlobalVariable.ID+':id/imgback').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/imgback').click()
			} else if(driver.findElementsById(GlobalVariable.ID+':id/imgBackArrow').size() > 0) {
				driver.findElementById(GlobalVariable.ID+':id/imgBackArrow').click()
			} else {
				Mobile.takeScreenshot();
				helperCommonAction.startExisitingAPP()
				KeywordUtil.markFailedAndStop('Back Button Not found / Object maybe changed!')
			}
		}
	}

	// new AccessoScreen
	@Keyword
	public void accessoScreen() {
		def helperCommonAction = new helperCommonAction()
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Accesso Screen/Popular Logo new'), GlobalVariable.timeOut_15_sec, FailureHandling.OPTIONAL))
		{
			Mobile.tap(findTestObject('Object Repository/Login/Accesso Screen/Acceso Empresarial Button'), GlobalVariable.timeOut_10_Sec, FailureHandling.OPTIONAL)
			KeywordUtil.markPassed('*****Accesso Screen found*****')
		}
	}

	//swipe down
	@Keyword
	public void swipeDown() {
		int device_Height = Mobile.getDeviceHeight()

		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2

		int endX = startX

		int startY = device_Height * 0.20

		int endY = device_Height * 0.80

		Mobile.swipe(startX, startY, endX, endY)
	}

	//swipe up
	@Keyword
	public void swipeUP() {
		int device_Height = Mobile.getDeviceHeight()

		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2

		int endX = startX

		int startY = device_Height * 0.30

		int endY = device_Height * 0.70

		Mobile.swipe(startX, endY, endX, startY)
	}

	//check for given aprobaciones account and expand it
	@Keyword
	public void extendAprobacionesAccount (String account) {
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		ArrayList<String> header = new ArrayList<String>()
		ArrayList<String> verMas = new ArrayList<String>()
		ArrayList<String> list = new ArrayList<String>()
		ArrayList<String> listtwo = new ArrayList<String>()

		//check error
		helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

		//check desde
		if (driver.findElementsById(GlobalVariable.ID + ':id/headerTitle').size() > 0) {
			header = driver.findElementsById(GlobalVariable.ID + ':id/headerTitle')
			String desde = (header[0]).getText()
			//check required account
			if(desde.contains(account)) {
				if(driver.findElementsById(GlobalVariable.ID + ':id/textDetail').size() > 0) {
					verMas = driver.findElementsById(GlobalVariable.ID + ':id/textDetail')
					(verMas[0]).click()
				} else {
					list = driver.findElementsById(GlobalVariable.ID + ':id/buttonReject')
					listtwo = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
					def bottomElement = ElementOption.element(list[0])
					def topElement = ElementOption.element(listtwo[0])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
					if(driver.findElementsById(GlobalVariable.ID + ':id/textDetail').size() > 0) {
						verMas = driver.findElementsById(GlobalVariable.ID + ':id/textDetail')
						(verMas[0]).click()
						//swipe up again
						ArrayList<String> swipeUp= new ArrayList<String>()
						swipeUp = driver.findElementsById(GlobalVariable.ID + ':id/buttonReject')
						def bottomaccount = ElementOption.element(swipeUp[1])
						def topaccount= ElementOption.element(swipeUp[0])
						touch.longPress(topaccount).moveTo(bottomaccount).release().perform()
					} else{
						Mobile.comment('maybe only 2 transaction for given account')
					}
				}
				//not found required desde account
			} else {
				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
				helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
				KeywordUtil.markFailedAndStop('*****NO GIVEN '+account+' DESDE ACCOUNT FOUND*****')
			}
		} else {
			helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
			helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
			KeywordUtil.markFailedAndStop('*****NO ACCOUNT IS VISIBLE*****')
		}
	}

	//aprobaciones getting list and last element
	@Keyword
	public void lastAccountInList (String account) {
		//variables
		def helperCommonAction = new helperCommonAction()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		ArrayList<String> accountName = new ArrayList<String>();
		ArrayList<String> AccountList = new ArrayList<String>();
		ArrayList<String> AccountConfirm = new ArrayList<String>();
		ArrayList<String> top = new ArrayList<String>();
		ArrayList<String> bottom = new ArrayList<String>();

		//expand aprobaciones
		helperCommonAction.extendAprobacionesAccount(account)

		//getting account count
		boolean check = false
		for (int a = 0; !(check) && (a < 10000); a++) {
			AccountList = driver.findElementsById(GlobalVariable.ID+':id/fechaSolcitude')
			//store first and last element on screen
			String first = (AccountList[0]).getText().trim()
			String last;
			if(AccountList.size()>2) {
				last = (AccountList[AccountList.size()-2]).getText().trim()
			} else {
				last = (AccountList[AccountList.size()-1]).getText().trim()
			}

			//swipe
			top = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
			bottom = driver.findElementsById(GlobalVariable.ID + ':id/fechaSolcitude')
			def topElement = ElementOption.element(top[0])
			if(AccountList.size()>2) {
				def bottomElement = ElementOption.element(bottom[(bottom.size() - 2)])
				touch.longPress(bottomElement).moveTo(topElement).release().perform()
			} else {
				def bottomElement = ElementOption.element(bottom[(bottom.size() - 1)])
				touch.longPress(bottomElement).moveTo(topElement).release().perform()
			}

			//check first - last again
			AccountList = driver.findElementsById(GlobalVariable.ID+':id/fechaSolcitude')
			String firsts = (AccountList[0]).getText().trim()
			String lasts;
			if(AccountList.size()>2) {
				lasts = (AccountList[AccountList.size()-2]).getText().trim()
			} else {
				lasts = (AccountList[AccountList.size()-1]).getText().trim()
			}

			if(first.equals(firsts) && last.equals(lasts) && GlobalVariable.count!=1) {
				GlobalVariable.count = 1;
				//Mobile.comment('CONTINUED')
				continue
			}

			if(first.equals(firsts) && last.equals(lasts)) {
				check = true
				GlobalVariable.count = 0;
				GlobalVariable.lastElement = (AccountList[AccountList.size()-1]).getText().trim()
				//Mobile.comment(GlobalVariable.lastElement)
			}
		}

		GlobalVariable.index2 = 0;
		GlobalVariable.count = 0;
		helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
		helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard', 'Object Repository/Aprobaciones y rechazos/Aprobaciones Pendientes Button Dashboard')

		//check error
		helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

		//expand aprobaciones
		helperCommonAction.extendAprobacionesAccount(account)
	}

	//aprobaciones approve inside
	@Keyword
	public void aprobacionesApproveInside (String account, String type) {
		//variables
		ArrayList<String> top = new ArrayList<String>();
		ArrayList<String> bottom = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> Transaction_Type = new ArrayList<String>();
		ArrayList<String> Buttons = new ArrayList<String>();
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		String actual_Text
		boolean check = false
		boolean swipeCheck
		def helperCommonAction = new helperCommonAction()


		//check error
		helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

		//check for no transaction avaiable msg

		if (Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Approve All Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
			//tap cerrar
			helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

			//Error check
			helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')

			//mark fail
			KeywordUtil.markFailedAndStop('*****NO TRANSACTION AVAILABLE IN LIST*****')
		}

		//get last payment in list
		helperCommonAction.lastAccountInList(account)

		for (int a = 0; !(check) && (a < 10000); a++) {
			swipeCheck = false
			date = driver.findElementsById(GlobalVariable.ID+':id/fechaSolcitude')
			for (int b = 0; b < date.size(); b++) {
				try {
					//check data
					actual_Text = (date[b]).getText().trim()
					Transaction_Type = driver.findElementsById(GlobalVariable.ID+':id/tipoTransaccion')
					Buttons = driver.findElementsById(GlobalVariable.ID+':id/buttonReject')
					String transaction = (Transaction_Type[b]).getText().trim()
					String btn = (Buttons[b]).getText().trim()
					if(transaction.equals(type) && btn.equals('')) {
						check = true
						(Transaction_Type[b]).click()
						break;
					}
				} catch(Exception e) {
					//swipe
					swipeCheck = true
					top = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
					bottom = driver.findElementsById(GlobalVariable.ID + ':id/fechaSolcitude')
					def topElement = ElementOption.element(top[0])
					//Mobile.comment(Integer.toString(bottom.size()))
					if(bottom.size()>2) {
						def bottomElement = ElementOption.element(bottom[(bottom.size() - 2)])
						touch.longPress(bottomElement).moveTo(topElement).release().perform()
					} else {
						def bottomElement = ElementOption.element(bottom[(bottom.size() - 1)])
						touch.longPress(bottomElement).moveTo(topElement).release().perform()
					}
					break;
				}
			}

			if(check) {
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Verificacin Heading')

				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Verificacin Heading', 'Object Repository/Aprobaciones y rechazos/Approve Button Inside')

				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Do you want to authorize transaction (msg)'), GlobalVariable.timeOut_2_Sec)){
					helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Do you want to authorize transaction (msg)', 'Object Repository/Aprobaciones y rechazos/Si button')
				}

				//Set Token
				Mobile.setText(findTestObject('Object Repository/Aprobaciones y rechazos/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)

				//tap Continuar
				helperCommonAction.ContinueButton()

				//check error
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Popular Logo Receipt Screen')

				//tap continuar
				helperCommonAction.ContinueButton()

				//check error
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

				//tap cerrar
				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

				//Error check
				helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
			}

			if(actual_Text.equals(GlobalVariable.lastElement) && !(swipeCheck) && !(check)) {
				check = true
				//tap cerrar
				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
				//Error check
				helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
				//mark failed
				KeywordUtil.markFailedAndStop(type+' not found in list!!!')
			} else if(!(check) && !(swipeCheck)) {
				//swipe
				top = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
				bottom = driver.findElementsById(GlobalVariable.ID + ':id/fechaSolcitude')
				def topElement = ElementOption.element(top[0])
				//Mobile.comment(Integer.toString(bottom.size()))
				if(bottom.size()>2) {
					def bottomElement = ElementOption.element(bottom[(bottom.size() - 2)])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				} else {
					def bottomElement = ElementOption.element(bottom[(bottom.size() - 1)])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}
			}
		}
	}


	//aprobaciones approve outside
	@Keyword
	public void aprobacionesApproveOutside (String account, String type) {
		//variables
		ArrayList<String> top = new ArrayList<String>();
		ArrayList<String> bottom = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> Transaction_Type = new ArrayList<String>();
		ArrayList<String> Buttons = new ArrayList<String>();
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		String actual_Text
		boolean check = false
		boolean swipeCheck
		def helperCommonAction = new helperCommonAction()

		//check error
		helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

		//check for no transaction avaiable msg
		if (Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Approve All Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
			//tap cerrar
			helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

			//Error check
			helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')

			//mark fail
			KeywordUtil.markFailedAndStop('*****NO TRANSACTION AVAILABLE IN LIST*****')
		}

		//get last payment in list
		helperCommonAction.lastAccountInList(account)

		for (int a = 0; !(check) && (a < 10000); a++) {
			swipeCheck = false
			date = driver.findElementsById(GlobalVariable.ID+':id/fechaSolcitude')
			for (int b = 0; b < date.size(); b++) {
				try {
					//check data
					actual_Text = (date[b]).getText().trim()
					Transaction_Type = driver.findElementsById(GlobalVariable.ID+':id/tipoTransaccion')
					Buttons = driver.findElementsById(GlobalVariable.ID+':id/buttonApprove')
					String transaction = (Transaction_Type[b]).getText().trim()
					String btn = (Buttons[b]).getText().trim()
					if(transaction.equals(type) && btn.equals('')) {
						check = true
						(Buttons[b]).click()
						break;
					}
				} catch(Exception e) {
					//swipe
					swipeCheck = true
					top = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
					bottom = driver.findElementsById(GlobalVariable.ID + ':id/fechaSolcitude')
					def topElement = ElementOption.element(top[0])
					//Mobile.comment(Integer.toString(bottom.size()))
					if(bottom.size()>2) {
						def bottomElement = ElementOption.element(bottom[(bottom.size() - 2)])
						touch.longPress(bottomElement).moveTo(topElement).release().perform()
					} else {
						def bottomElement = ElementOption.element(bottom[(bottom.size() - 1)])
						touch.longPress(bottomElement).moveTo(topElement).release().perform()
					}
					break;
				}
			}

			if(check) {
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Do you want to authorize transaction (msg)'), GlobalVariable.timeOut_2_Sec)){
					helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Do you want to authorize transaction (msg)', 'Object Repository/Aprobaciones y rechazos/Si button')
				}

				//Set Token
				Mobile.setText(findTestObject('Object Repository/Aprobaciones y rechazos/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)

				//tap Continuar
				helperCommonAction.ContinueButton()

				//check error
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Popular Logo Receipt Screen')

				//tap continuar
				helperCommonAction.ContinueButton()

				//check error
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

				//tap cerrar
				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

				//Error check
				helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
			}

			if(actual_Text.equals(GlobalVariable.lastElement) && !(swipeCheck) && !(check)) {
				check = true
				//tap cerrar
				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
				//Error check
				helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
				//mark failed
				KeywordUtil.markFailedAndStop(type+' not found in list!!!')
			} else if(!(check) && !(swipeCheck)) {
				//swipe
				top = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
				bottom = driver.findElementsById(GlobalVariable.ID + ':id/fechaSolcitude')
				def topElement = ElementOption.element(top[0])
				//Mobile.comment(Integer.toString(bottom.size()))
				if(bottom.size()>2) {
					def bottomElement = ElementOption.element(bottom[(bottom.size() - 2)])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				} else {
					def bottomElement = ElementOption.element(bottom[(bottom.size() - 1)])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}
			}
		}
	}

	//aprobaciones reject inside
	@Keyword
	public void aprobacionesRejectInside (String account, String type) {
		//variables
		ArrayList<String> top = new ArrayList<String>();
		ArrayList<String> bottom = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> Transaction_Type = new ArrayList<String>();
		ArrayList<String> Buttons = new ArrayList<String>();
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		String actual_Text
		boolean check = false
		boolean swipeCheck
		def helperCommonAction = new helperCommonAction()


		//check error
		helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

		//check for no transaction avaiable msg
		if (Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Approve All Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
			//tap cerrar
			helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

			//Error check
			helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')

			//mark fail
			KeywordUtil.markFailedAndStop('*****NO TRANSACTION AVAILABLE IN LIST*****')
		}

		//get last payment in list
		helperCommonAction.lastAccountInList(account)

		for (int a = 0; !(check) && (a < 10000); a++) {
			swipeCheck = false
			date = driver.findElementsById(GlobalVariable.ID+':id/fechaSolcitude')
			for (int b = 0; b < date.size(); b++) {
				try {
					//check data
					actual_Text = (date[b]).getText().trim()
					Transaction_Type = driver.findElementsById(GlobalVariable.ID+':id/tipoTransaccion')
					Buttons = driver.findElementsById(GlobalVariable.ID+':id/buttonReject')
					String transaction = (Transaction_Type[b]).getText().trim()
					String btn = (Buttons[b]).getText().trim()
					if(transaction.equals(type) && btn.equals('')) {
						check = true
						(Transaction_Type[b]).click()
						break;
					}
				} catch(Exception e) {
					//swipe
					swipeCheck = true
					top = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
					bottom = driver.findElementsById(GlobalVariable.ID + ':id/fechaSolcitude')
					def topElement = ElementOption.element(top[0])
					//Mobile.comment(Integer.toString(bottom.size()))
					if(bottom.size()>2) {
						def bottomElement = ElementOption.element(bottom[(bottom.size() - 2)])
						touch.longPress(bottomElement).moveTo(topElement).release().perform()
					} else {
						def bottomElement = ElementOption.element(bottom[(bottom.size() - 1)])
						touch.longPress(bottomElement).moveTo(topElement).release().perform()
					}
					break;
				}
			}

			if(check) {
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Verificacin Heading')

				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Verificacin Heading', 'Object Repository/Aprobaciones y rechazos/Reject Button Inside')

				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Do you want to reject transaction (msg)'), GlobalVariable.timeOut_2_Sec)){
					helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Do you want to reject transaction (msg)', 'Object Repository/Aprobaciones y rechazos/Si button')
				}

				//Set Token
				Mobile.setText(findTestObject('Object Repository/Aprobaciones y rechazos/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)

				//tap Continuar
				helperCommonAction.ContinueButton()

				//check error
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Transaction Declined (msg)')

				//tap continuar
				helperCommonAction.ContinueButton()

				//check error
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

				//tap cerrar
				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

				//Error check
				helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
			}

			if(actual_Text.equals(GlobalVariable.lastElement) && !(swipeCheck) && !(check)) {
				check = true
				//tap cerrar
				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
				//Error check
				helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
				//mark failed
				KeywordUtil.markFailedAndStop(type+' not found in list!!!')
			} else if(!(check) && !(swipeCheck)) {
				//swipe
				top = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
				bottom = driver.findElementsById(GlobalVariable.ID + ':id/fechaSolcitude')
				def topElement = ElementOption.element(top[0])
				//Mobile.comment(Integer.toString(bottom.size()))
				if(bottom.size()>2) {
					def bottomElement = ElementOption.element(bottom[(bottom.size() - 2)])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				} else {
					def bottomElement = ElementOption.element(bottom[(bottom.size() - 1)])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}
			}
		}
	}

	//aprobaciones reject outside
	@Keyword
	public void aprobacionesRejectOutside (String account, String type) {
		//variables
		ArrayList<String> top = new ArrayList<String>();
		ArrayList<String> bottom = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> Transaction_Type = new ArrayList<String>();
		ArrayList<String> Buttons = new ArrayList<String>();
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		TouchAction touch = new TouchAction(driver)
		String actual_Text
		boolean check = false
		boolean swipeCheck
		def helperCommonAction = new helperCommonAction()


		//check error
		helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

		//check for no transaction avaiable msg
		if (Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Approve All Transaction (msg)'), GlobalVariable.timeOut_2_Sec, FailureHandling.OPTIONAL)) {
			//tap cerrar
			helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

			//Error check
			helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')

			//mark fail
			KeywordUtil.markFailedAndStop('*****NO TRANSACTION AVAILABLE IN LIST*****')
		}

		//get last payment in list
		helperCommonAction.lastAccountInList(account)

		for (int a = 0; !(check) && (a < 10000); a++) {
			swipeCheck = false
			date = driver.findElementsById(GlobalVariable.ID+':id/fechaSolcitude')
			for (int b = 0; b < date.size(); b++) {
				try {
					//check data
					actual_Text = (date[b]).getText().trim()
					Transaction_Type = driver.findElementsById(GlobalVariable.ID+':id/tipoTransaccion')
					Buttons = driver.findElementsById(GlobalVariable.ID+':id/buttonReject')
					String transaction = (Transaction_Type[b]).getText().trim()
					String btn = (Buttons[b]).getText().trim()
					if(transaction.equals(type) && btn.equals('')) {
						check = true
						(Buttons[b]).click()
						break;
					}
				} catch(Exception e) {
					//swipe
					swipeCheck = true
					top = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
					bottom = driver.findElementsById(GlobalVariable.ID + ':id/fechaSolcitude')
					def topElement = ElementOption.element(top[0])
					//Mobile.comment(Integer.toString(bottom.size()))
					if(bottom.size()>2) {
						def bottomElement = ElementOption.element(bottom[(bottom.size() - 2)])
						touch.longPress(bottomElement).moveTo(topElement).release().perform()
					} else {
						def bottomElement = ElementOption.element(bottom[(bottom.size() - 1)])
						touch.longPress(bottomElement).moveTo(topElement).release().perform()
					}
					break;
				}
			}

			if(check) {
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Aprobaciones y rechazos/Do you want to reject transaction (msg)'), GlobalVariable.timeOut_2_Sec)){
					helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Do you want to reject transaction (msg)', 'Object Repository/Aprobaciones y rechazos/Si button')
				}

				//Set Token
				Mobile.setText(findTestObject('Object Repository/Aprobaciones y rechazos/Enter Token Field'), GlobalVariable.token, GlobalVariable.timeOut_15_sec)

				//tap Continuar
				helperCommonAction.ContinueButton()

				//check error
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Transaction Declined (msg)')

				//tap continuar
				helperCommonAction.ContinueButton()

				//check error
				helperCommonAction.checkError('Object Repository/Aprobaciones y rechazos/Cerrar Button')

				//tap cerrar
				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')

				//Error check
				helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
			}

			if(actual_Text.equals(GlobalVariable.lastElement) && !(swipeCheck) && !(check)) {
				check = true
				//tap cerrar
				helperCommonAction.tapWithCheck('Object Repository/Aprobaciones y rechazos/Cerrar Button', 'Object Repository/Aprobaciones y rechazos/Cerrar Button')
				//Error check
				helperCommonAction.checkError('Object Repository/Common Objects/Salir/Salir Button Dashboard')
				//mark failed
				KeywordUtil.markFailedAndStop(type+' not found in list!!!')
			} else if(!(check) && !(swipeCheck)) {
				//swipe
				top = driver.findElementsById(GlobalVariable.ID + ':id/txtdataView')
				bottom = driver.findElementsById(GlobalVariable.ID + ':id/fechaSolcitude')
				def topElement = ElementOption.element(top[0])
				//Mobile.comment(Integer.toString(bottom.size()))
				if(bottom.size()>2) {
					def bottomElement = ElementOption.element(bottom[(bottom.size() - 2)])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				} else {
					def bottomElement = ElementOption.element(bottom[(bottom.size() - 1)])
					touch.longPress(bottomElement).moveTo(topElement).release().perform()
				}
			}
		}
	}
}
