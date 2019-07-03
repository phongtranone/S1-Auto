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

import internal.GlobalVariable as GV

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


class logout {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I am stay Home page")
	def I_am_stay_home_page() {
		WebUI.setText(findTestObject("Object Repository/Login/txt_Email"), "anhphong.tran@codestringers.com", FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(findTestObject("Object Repository/Login/txt_Password"), "123456", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject("Object Repository/Login/btn_Sign in"), FailureHandling.STOP_ON_FAILURE)
	}

	@When("I click sign out button")
	def I_click_sign_out_button() {

		WebUI.click(findTestObject("Object Repository/Home/menu_user"))

		WebUI.click(findTestObject("Object Repository/Home/btn_sign out",))
	}

	@Then("I am navigated to Login page")
	def I_am_navigated_to_Login_page() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/Login/btn_Sign in"), GV.timeOut)
	}
}