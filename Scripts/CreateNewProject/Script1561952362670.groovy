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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String projectNameColumn = ''

WebUI.verifyElementPresent(findTestObject('Project/icon_RegionDropdown'), 4)

WebUI.click(findTestObject('Project/icon_RegionDropdown'))

WebUI.verifyElementPresent(findTestObject('Project/region_Item', [('region_name') : regionName]), 2)

WebUI.click(findTestObject('Project/region_Item', [('region_name') : regionName]))

WebUI.verifyElementPresent(findTestObject('Object Repository/Project/icon_MarketDropdown'), 4)

WebUI.click(findTestObject('Object Repository/Project/icon_MarketDropdown'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Project/market_Item'), 2)

WebUI.click(findTestObject('Object Repository/Project/market_Item'))

WebUI.setText(findTestObject('Project/txt_ProjectName'), projectName)

WebUI.sendKeys(findTestObject('Project/txt_Location'), location)

WebUI.setText(findTestObject('Project/txt_CostCode'), costCode)

WebUI.click(findTestObject('Project/icon_ProjectOwner'))

WebUI.verifyElementPresent(findTestObject('Project/projectOwner_Item', [('project_Owner') : projectOwner]), 4)

WebUI.click(findTestObject('Project/projectOwner_Item', [('project_Owner') : projectOwner]))

WebUI.setText(findTestObject('Project/txt_EmergencyPhone'), emergencyPhone)

WebUI.click(findTestObject('Project/btn_Create'))

WebUI.setText(findTestObject('Project/txt_SearchBox'), projectName)

projectNameColumn = WebUI.getText(findTestObject('Project/column_NameOfProject'))

if (!(projectNameColumn.equals(projectName))) {
    KeywordUtil.markFailed('Can not find project name')
}

@com.kms.katalon.core.annotation.SetUp
def SetUp() {
    CustomKeywords.'commonKeyword.Table.Login'(GlobalVariable.URL_Project)
}

//@com.kms.katalon.core.annotation.SetUp
/*def TearDown() {
    //WebUI.closeBrowser()
}
*/ 