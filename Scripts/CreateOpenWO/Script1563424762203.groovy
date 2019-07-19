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

WebUI.click(findTestObject('CreateWO/item_WOType', [('WO_Type') : WOType]))

WebUI.click(findTestObject('CreateWO/icon_LocationDropdown'))

WebUI.click(findTestObject('CreateWO/item_Location',[('location_value') : Location]))

WebUI.delay(5)

@com.kms.katalon.core.annotation.SetUp
def SetUp() {
    CustomKeywords.'commonKeyword.Table.Login'(GlobalVariable.URL_NewWO + '1015505')
}

@com.kms.katalon.core.annotation.TearDown
def TearDown() {
    WebUI.closeBrowser()
}

