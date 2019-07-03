package forgotPassword
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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class forgotPassword {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@And("I click on the Forgot link")
	def I_click_on_the_Forgot_link() {
		WebUI.click(findTestObject("Object Repository/Login/link_Forgot"), FailureHandling.STOP_ON_FAILURE)
	}

	@When("I input email '(.*)'")
	def I_input_email(String email) {
		WebUI.setText(findTestObject("Object Repository/Forgot password/txt_Email"), email, FailureHandling.STOP_ON_FAILURE)
	}

	@And("I clear all")
	def I_clear_all() {
		WebUI.sendKeys(findTestObject('Forgot password/txt_Email'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Forgot password/txt_Email'), Keys.chord(Keys.DELETE))
		
//		println email
//		
//		while(email!="")
//		{	WebUI.sendKeys(findTestObject('Forgot password/txt_Email'), Keys.chord(Keys.DELETE))	
//			WebUI.delay(1)
//				
//		}
		//WebUI.clearText(findTestObject("Object Repository/Forgot password/txt_Email"), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		//WebUI.click
		WebUI.sendKeys(findTestObject("Object Repository/Forgot password/txt_Email"),"" )
		//WebUI.focus(findTestObject("Object Repository/Forgot password/txt_Email"))
		
		//WebUI.click(findTestObject("Object Repository/Forgot password/txt_Email"))
		//WebUI.setText(findTestObject("Object Repository/Forgot password/txt_Email"), "", FailureHandling.STOP_ON_FAILURE)
	}

	@Then("The Continue button is disabled")
	def The_Continue_button_is_disabled() {
		//WebUI.verifyElementClickable(findTestObject("Object Repository/Forgot password/btn_Continue"), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementNotClickable(findTestObject("Object Repository/Forgot password/btn_Continue"))
		//WebUI.click(findTestObject("Object Repository/Forgot password/btn_Continue"))
	}
}