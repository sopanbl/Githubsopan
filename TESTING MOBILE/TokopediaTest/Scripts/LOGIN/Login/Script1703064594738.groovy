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

Mobile.startExistingApplication('com.tokopedia.tkpd', FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Home/ButtonMasuk'), 0)

Mobile.setText(findTestObject('LOGIN/MenuLogin/TextBoxNomorhpAtauEmail'), 'cobainajacobaindulu@gmail.com', 0)

Mobile.tap(findTestObject('LOGIN/MenuLogin/ButtonLanjut'), 0)

Mobile.tap(findTestObject('LOGIN/MetodeVerifikasiLogin/MetodeVerifikasiPassword'), 0)

Mobile.setEncryptedText(findTestObject('LOGIN/MetodeVerifikasiLogin/TextBoxPassword'), 'B1ntkxHX8y0CWPPiAzS4qQ==', 0)

Mobile.tap(findTestObject('LOGIN/MetodeVerifikasiLogin/ButtonLanjutkan'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

verify = Mobile.getText(findTestObject('Verifikasi 2 Langkah/Tambah nomor HP untukkeamanan akunmu'), 0)

println(verify)

if (verify.contains('Tambah nomor HP untuk')) {
    Mobile.doubleTap(findTestObject('Verifikasi 2 Langkah/ButtonBack'), 0, FailureHandling.STOP_ON_FAILURE)
}

Mobile.verifyElementVisible(findTestObject('ValidateLogin'), 0)

Mobile.checkElement(findTestObject(null), 0)

