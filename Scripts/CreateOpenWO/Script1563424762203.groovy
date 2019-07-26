import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('CreateWO/icon_WOTypeDropdown'))

WebUI.click(findTestObject('CreateWO/item_WOType', [('WO_Type') : woType]))

WebUI.click(findTestObject('CreateWO/icon_LocationDropdown'))

WebUI.click(findTestObject('CreateWO/item_Location', [('location_value') : location]))

WebUI.click(findTestObject('CreateWO/icon_TradeDropdown'))

WebUI.click(findTestObject('CreateWO/item_Trade', [('trade_value') : trade]))

WebUI.click(findTestObject('CreateWO/icon_AssignedToDropdown'))

WebUI.click(findTestObject('CreateWO/item_AssignedTo', [('assignedTo_value') : assignedTo]))

WebUI.click(findTestObject('CreateWO/icon_ItemToRepairDropdown'))

WebUI.click(findTestObject('CreateWO/item_ItemToRepair', [('itemToRepair_value') : itemToRepair]))

WebUI.click(findTestObject('CreateWO/icon_ProblemDropdown'))

WebUI.click(findTestObject('CreateWO/item_Problem', [('problem_value') : problem]))

WebUI.setText(findTestObject('CreateWO/txt_Summary'), summary)

WebUI.setText(findTestObject('CreateWO/txt_Description'), description)

WebUI.sendKeys(findTestObject('CreateWO/txt_Appointment'), appointment)

WebUI.sendKeys(findTestObject('CreateWO/btn_Create'), Keys.chord(Keys.ENTER))

/*WebUI.verifyElementVisible(findTestObject('CreateWO/btn_Create'))
WebUI.waitForElementClickable(findTestObject('CreateWO/btn_Create'), 6)
WebUI.verifyElementClickable(findTestObject('CreateWO/btn_Create'))
WebUI.click(findTestObject('CreateWO/btn_Create'))*/

@com.kms.katalon.core.annotation.SetUp
def SetUp() {
    CustomKeywords.'commonKeyword.Table.Login'(GlobalVariable.URL_NewWO + '1015505')
}

@com.kms.katalon.core.annotation.TearDown
def TearDown() {
    WebUI.closeBrowser()
}

