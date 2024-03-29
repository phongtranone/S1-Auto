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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver

WebUI.click(findTestObject('CreateRFS/icon_ProjectDropdown'))

WebUI.click(findTestObject('CreateRFS/item_Project', [('project_name') : project]))

WebUI.click(findTestObject('CreateRFS/icon_LotDropdown'))

WebUI.click(findTestObject('CreateRFS/item_Lot', [('lot_id') : lot]))

WebUI.click(findTestObject('CreateRFS/icon_RequestTypeDropdown'))

WebUI.click(findTestObject('CreateRFS/item_RequestType', [('request_type') : requestType]))

WebUI.click(findTestObject('CreateRFS/icon_ManagedByDropdown'))

WebUI.click(findTestObject('CreateRFS/item_RFSManagedBy', [('rfs_managedBy') : managedBy]))

WebUI.click(findTestObject('CreateRFS/btn_ProceedToReportProblem'))

WebUI.waitForElementPresent(findTestObject('RFS Details/projectName'), 4) 

WebUI.verifyEqual(WebUI.getText(findTestObject('RFS Details/projectName')), project)

@com.kms.katalon.core.annotation.SetUp
def SetUp() {
    CustomKeywords.'commonKeyword.Table.Login'(GlobalVariable.URL_NewRFS)
}

@com.kms.katalon.core.annotation.TearDown
def TearDown() {
	WebUI.closeBrowser()
}

