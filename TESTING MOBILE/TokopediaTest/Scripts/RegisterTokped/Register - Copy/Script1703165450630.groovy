import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement



Mobile.startExistingApplication('com.tokopedia.tkpd', FailureHandling.STOP_ON_FAILURE)

AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
Mobile.tap(findTestObject('Home/NavbarTiga1'), 0)

Mobile.tap(findTestObject('MenuNavbar/ButtonDaftar'), 0)

//Mobile.tap(findTestObject('MenuNavbar/ButtonDaftar'), 0)
//
Mobile.setText(findTestObject('LOGIN/MenuLogin/TextBoxNomorhpAtauEmail'), 'cobaindulu1310@gmail.com', 0)

Mobile.tap(findTestObject('LOGIN/MenuLogin/ButtonLanjut'), 0)

//Mobile.verifyElementNotExist(findTestObject('Metode Verifaksi Register/Gambar Email Ke'), 0)
if(Mobile.verifyElementExist(findTestObject('Metode Verifaksi Register/Gambar Email Ke'), 0,FailureHandling.OPTIONAL)) {
	
	Mobile.tap(findTestObject('Metode Verifaksi Register/Gambar Email Ke'), 0)
	
	Mobile.startExistingApplication('com.google.android.gm', FailureHandling.STOP_ON_FAILURE)
	
	Mobile.tap(findTestObject('Gmail/OTPEmail'), 0)
	
	def message = Mobile.getText(findTestObject('Gmail/KodeOTPGmail'), 0)
	
	println(message)
	
	Mobile.startExistingApplication('com.tokopedia.tkpd', FailureHandling.STOP_ON_FAILURE)
	
	Mobile.setText(findTestObject('Metode Verifaksi Register/InputKodeVerifikasiEmail'), message, 0)
	
	Mobile.delay(5)
	
	Mobile.setText(findTestObject('Menu Daftar Dengan Email/Nama Lengkap'), Nama, 0)
	
	Mobile.setText(findTestObject('Menu Daftar Dengan Email/Password'), Password, 0)
	
	ValueAttribute = Mobile.getAttribute(findTestObject('Menu Daftar Dengan Email/ButtonDaftar'), 'enabled', 0)
	
	
	if(ValueAttribute == 'false') {
		Mobile.takeScreenshot('D:\\screenshot.png')
		
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
		
		Mobile.tap(findTestObject('CLEAR ALL'), 0)
	}else {
	
	Mobile.tap(findTestObject('Menu Daftar Dengan Email/ButtonDaftar'), 0)
	
	
	Mobile.verifyElementVisible(findTestObject('ValidateLogin'), 0)
	}
}else {
	Mobile.takeScreenshot()
	
	driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
		
	Mobile.tap(findTestObject('CLEAR ALL'), 0)
}
