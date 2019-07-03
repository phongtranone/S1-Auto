package hook

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import cucumber.api.java.Before
import cucumber.api.java.After
import cucumber.api.Scenario
import java.nio.file.Files

public class Hook {
	@Before()
	def Open_browser_login() {
		WebUI.openBrowser(null)
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.URL)
	}

	//@Before( )
	//def Open_browser_and_log_in() {
	//	WebUI.openBrowser(null)
	//	WebUI.maximizeWindow()
	//	WebUI.navigateToUrl(GlobalVariable.URL)
	//	WebUI.setText(findTestObject("Object Repository/Login/txt_Email"), "anhphong.tran@codestringers.com", FailureHandling.STOP_ON_FAILURE)
	//	WebUI.setText(findTestObject("Object Repository/Login/txt_Password"), "123456", FailureHandling.STOP_ON_FAILURE)
	//	WebUI.click(findTestObject("Object Repository/Login/btn_Sign in"), FailureHandling.STOP_ON_FAILURE)
	//}


	@After
	def Close_browser(Scenario scenario) {
		//if(scenario.isFailed()) {
		//	String filePath = WebUI.takeScreenshot()
		//	File file = new File(filePath)
		//	scenario.embed(Files.readAllBytes(file.toPath()), "image/png")
		//}

		WebUI.delay(2)
		WebUI.closeBrowser()
	}

}
