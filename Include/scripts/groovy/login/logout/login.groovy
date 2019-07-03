package login.logout
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@Given("I am in Login page")
	def I_am_in_Login_page() {
	}

	@When('I input email "(.*)" and password "(.*)"')
	def I_input_email_and_password(String email,String password) {
		WebUI.setText(findTestObject("Object Repository/Login/txt_Email"), email, FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(findTestObject("Object Repository/Login/txt_Password"), password, FailureHandling.STOP_ON_FAILURE)
	}

	@When("I click Sign in")
	def I_click_Sign_in() {
		WebUI.waitForElementClickable(findTestObject("Object Repository/Login/btn_Sign in"), 5)
		WebUI.click(findTestObject("Object Repository/Login/btn_Sign in"), FailureHandling.STOP_ON_FAILURE)
	}

	@Then('Error message "(.*)" is displayed')
	def Error_messeage_is_displayed(String mess) {
		WebUI.delay(2)
		WebUI.verifyTextPresent(mess, false)
	}

	@Then('Home page is displayed')
	def Home_page_is_displayed(){
		//WebUI.delay(5)
		WebUI.verifyElementPresent((findTestObject("Object Repository/Home/img_Logo")),5)

	}
}