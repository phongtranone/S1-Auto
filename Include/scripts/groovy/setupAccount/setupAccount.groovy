package setupAccount
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable as GV

import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By


import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import commonKeyword.Email

class setupAccount {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	/* Error message */
	String message_missRequiredFied= "This information is required."
	String message_PasswordInvalid= "Please choose a password that is 8-40 characters long."
	String message_PasswordnotmatchConfirmPassword= "These passwords don't match."
	@Given('I clink on email')
	def I_clink_on_email(){
		//(new "commonKeyword"."Email"())."getLink_inEmail"()
		//String URL=WebUI.callTestCase(findTestCase('getLink_inEmail'), [:], FailureHandling.STOP_ON_FAILURE)

		Email e = new Email()
		String email = (e.getLink_inEmail('imap.gmail.com','phong.testautomation@gmail.com', 'phong0902673536', 'Activate your RapidOnBoarder account')).toString()
		WebUI.navigateToUrl(email)
	}

	@When('I input Password "(.*)"')
	def I_input_Password(String pass) {
		WebUI.setText(findTestObject("Set up account/txt_Password"), pass)
	}

	@When('I input Confirm Password "(.*)"')
	def I_input_confirmPassword(String confirmPass) {
		//WebUI.sendKeys(findTestObject, confirmPass)

		WebUI.setText(findTestObject("Set up account/txt_confirmPassword"), confirmPass)
	}

	@When('I click continue button')
	def I_click_continue() {
		WebUI.delay(1)
		//WebUI.waitForElementVisible(findTestObject("Object Repository/Set up account/btn_Continue"), GV.timeOut)
		//WebUI.waitForElementClickable(findTestObject("Object Repository/Set up account/btn_Continue"),GV.timeOut )
		WebUI.click(findTestObject('Object Repository/Set up account/btn_Continue'))
	}

	@Then('Display error message when Password "(.*)" or Confirm Password "(.*)" equal blank')
	def Display_error_messeage_when_password_or_confirm_password_blank(String password, String confirmPassword) {
		if(password== ""){
			String UI_password= WebUI.getText(findTestObject('Object Repository/Set up account/lb_Password error message'))
			WebUI.verifyMatch(UI_password,message_missRequiredFied, false, FailureHandling.CONTINUE_ON_FAILURE)
		}

		if(confirmPassword== ""){
			String UI_confirmPassword= WebUI.getText(findTestObject('Object Repository/Set up account/lb_confirmPassword error message'))
			WebUI.verifyMatch(UI_confirmPassword,message_missRequiredFied, false, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	@Then('Display error message when Password "(.*)" lower than minlength or greater than maxlength')
	def Display_error_message_when_Password_invalid(String password) {
		if(password.length()<8 || password.length()>40){
			String UI_password= WebUI.getText(findTestObject('Object Repository/Set up account/lb_Password error message'))
			WebUI.verifyMatch(UI_password,message_PasswordInvalid, false, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	@Then('Display error message when Password "(.*)" and Confirm Password "(.*)" not match')
	def Display_error_message_when_Password_not_match_Confirmpass(String password,String confirmPassword) {
		if ( (password.equals(confirmPassword)) != true ) {
			String UI_confirmPassword= WebUI.getText(findTestObject('Object Repository/Set up account/lb_confirmPassword error message'))
			WebUI.verifyMatch(UI_confirmPassword,message_PasswordnotmatchConfirmPassword, false, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	@Then('I can log in admin page with Password "(.*)" was set up')
	def I_can_log_in_with_new_Password_and_ConfirmPassword(String password) {
		WebUI.setText(findTestObject("Object Repository/Login/txt_Password"), password, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject("Object Repository/Login/btn_Sign in"), FailureHandling.STOP_ON_FAILURE)
	}
}