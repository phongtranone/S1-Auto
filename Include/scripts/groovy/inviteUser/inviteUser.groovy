package inviteUser
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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable


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
import commonKeyword.Table

class inviteUser {

	public Table table = new Table()
	Email e = new Email()
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I click Create user button")
	def I_Click_user_button() {
		WebUI.click(findTestObject("Object Repository/Home/btn_Create user"))
	}

	@When('I input First name "(.*)"')
	def I_input_First_name(String firstName) {

		WebUI.setText(findTestObject("Object Repository/Pop-up/Invite new user/txt_First name"), firstName)
		if (firstName.length()>39) {
			String firstName_sub=firstName.substring(0, 39)
			String firstName_actual= WebUI.getText(findTestObject("Object Repository/Pop-up/Invite new user/txt_First name"))
			if( (WebUI.verifyMatch(firstName_actual, firstName_sub, false))== false) {
				KeywordUtil.markFailed("First Name incorrect")
			}
		}
	}

	@When('I input Last name "(.*)"')
	def I_input_Last_name(String lastName) {
		WebUI.setText(findTestObject("Object Repository/Pop-up/Invite new user/txt_Last name"), lastName)
		if (lastName.length()>39) {
			String lastName_sub=lastName.substring(0, 39)
			String lastName_actual= WebUI.getText(findTestObject("Object Repository/Pop-up/Invite new user/txt_Last name"))
			if( (WebUI.verifyMatch(lastName_actual, lastName_sub, false))== false) {
				KeywordUtil.markFailed("Last Name incorrect")
			}
		}
	}

	@When('I input Email "(.*)"')
	def I_input_Email(String email) {
		WebUI.setText(findTestObject("Object Repository/Pop-up/Invite new user/txt_Email"), email)
		if (email.length()>253) {
			String email_sub=email.substring(0, 253)
			String email_actual= WebUI.getText(findTestObject("Object Repository/Pop-up/Invite new user/txt_Email"))
			if( (WebUI.verifyMatch(email_actual, email_sub, false))== false) {
				KeywordUtil.markFailed("Email incorrect")
			}
		}
	}

	@When('I input Role "(.*)"')
	def I_input_Role(String role) {
		if(role!='') {
			WebUI.click(findTestObject('Object Repository/Pop-up/Invite new user/el_Arrow_Role'))
			WebUI.click(findTestObject("Object Repository/Pop-up/Invite new user/cbo_Role",['Role': role]))
		}
	}

	@When('I click Invite button')
	def I_Invite_user_button() {
		WebUI.click(findTestObject("Object Repository/Pop-up/Invite new user/btn_Invite"))
	}

	@When('I click X button')
	def I_X_user_button() {
		WebUI.click(findTestObject("Object Repository/Pop-up/Invite new user/btn_Close"))
	}

	@When('I input space on First name field')
	def I_input_space_on_firstName() {
		WebUI.sendKeys(findTestObject('Object Repository/Pop-up/Invite new user/txt_First name'), Keys.chord(Keys.SPACE))
	}

	@When('I input space on Last name field')
	def I_input_space_on_lastName() {
		WebUI.sendKeys(findTestObject('Object Repository/Pop-up/Invite new user/txt_Last name'), Keys.chord(Keys.SPACE))
	}

	@When('I click resent invitation to email "(.*)"')
	def I_click_invitation(String email) {
		WebUI.click(findTestObject("Home/el_User list"))
		WebUI.waitForElementPresent(findTestObject('Home/el_pagination'), 20)
		WebUI.setText(findTestObject('Home/btn_Search'),'phong')
		WebUI.delay(1)
		int maxList= Table.getHtmlTableRows(findTestObject("Home/el_table"),'tbody')
		for(int i=1;i <= maxList;i++) {
			String email_temp = (WebUI.getText(findTestObject('Object Repository/Home/table_Email',['index':i]),FailureHandling.OPTIONAL)).toString()
			if(email_temp==email) {
				WebUI.click(findTestObject('Home/table_More action',['index':i]))
				Email.delete_AllEmail("phong.testautomation@gmail.com", "phong0902673536")
				WebUI.click( findTestObject('Home/btn_Resend invitation'))
				break
			}
		}
		String checkemail = e.getLink_inEmail('imap.gmail.com','phong.testautomation@gmail.com', 'phong0902673536', 'Activate your RapidOnBoarder account')
		WebUI.verifyNotMatch(checkemail,"" , false)
	}

	@When('I click resent invitation to email "(.*)" again')
	def I_click_invitation_again(String email){
		int maxList= Table.getHtmlTableRows(findTestObject("Home/el_table"),'tbody')
		for(int i=1;i <= maxList;i++) {
			String email_temp = WebUI.getText(findTestObject('Object Repository/Home/table_Email',['index':i]),FailureHandling.OPTIONAL)
			if(email_temp==email) {
				WebUI.click(findTestObject('Home/table_More action',['index':i]))
				Email.delete_AllEmail("phong.testautomation@gmail.com", "phong0902673536")
				WebUI.click( findTestObject('Home/btn_Resend invitation'))
				break
			}
		}
		String checkemail = e.getLink_inEmail('imap.gmail.com','phong.testautomation@gmail.com', 'phong0902673536', 'Activate your RapidOnBoarder account')
		WebUI.verifyNotMatch(checkemail,"" , false)
	}


	@Then('Display error message when First name"(.*)" or Last name"(.*)" or Email"(.*)" or Role"(.*)" equal blank')
	def I_verify_the_status_in_step(String firstName,String lastName,String email,String role) {

		if(firstName==""){
			String UI_firstName= WebUI.getText(findTestObject('Object Repository/Pop-up/Invite new user/lb_First name error message'))
			WebUI.verifyMatch(UI_firstName,"This information is required.", false, FailureHandling.CONTINUE_ON_FAILURE)
		}

		if(lastName==""){
			String UI_lastName= WebUI.getText(findTestObject('Object Repository/Pop-up/Invite new user/lb_Last name error message'))
			WebUI.verifyMatch(UI_lastName,"This information is required.", false, FailureHandling.CONTINUE_ON_FAILURE)
		}

		if(email==""){
			String UI_email= WebUI.getText(findTestObject('Object Repository/Pop-up/Invite new user/lb_Email address error message'))
			WebUI.verifyMatch(UI_email,"This information is required.", false, FailureHandling.CONTINUE_ON_FAILURE)
		}

		if(role==""){
			String UI_role= WebUI.getText(findTestObject('Object Repository/Pop-up/Invite new user/lb_Role error message'))
			WebUI.verifyMatch(UI_role,"This information is required.", false, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	@Then('Form invite is closed and not displayed message Invitation sent')
	def Form_invite_is_closed()	{
		WebUI.verifyElementNotPresent(findTestObject("Object Repository/Pop-up/Invite new user/form_invite"), 2)
		WebUI.verifyTextNotPresent("Invitation sent", false)
	}

	@Then("Display error message below First name and Last name")
	def Display_error_messeage_below_First_name_Last_name() {

		String UI_firstName= WebUI.getText(findTestObject('Object Repository/Pop-up/Invite new user/lb_First name error message'))
		WebUI.verifyMatch(UI_firstName,"This information is required.", false, FailureHandling.CONTINUE_ON_FAILURE)


		String UI_lastName= WebUI.getText(findTestObject('Object Repository/Pop-up/Invite new user/lb_Last name error message'))
		WebUI.verifyMatch(UI_lastName,"This information is required.", false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Then('Display successfully message "(.*)"')
	def Display_successfully_messeage(String mess) {
		WebUI.delay(3)
		WebUI.verifyTextPresent(mess, false)
	}
}