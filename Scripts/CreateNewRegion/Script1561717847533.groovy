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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import java.util.ArrayList
import java.util.regex.Pattern.Loop
import java.time.LocalDateTime;
import java.util.Random;
import org.openqa.selenium.By as By

import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
  
  

String randomValue = CustomKeywords.'commonKeyword.CommonKeyword.RandomValue'(99999)
String RegionNameInput = 'Region ' + randomValue
println("Region name inputed: " + RegionNameInput) 

WebUI.click(findTestObject('RegionAndMarket/btn_NewRegion'))

WebUI.setText(findTestObject('RegionAndMarket/txt_RegionName'), RegionNameInput)

WebUI.setText(findTestObject('RegionAndMarket/txt_RegionDescription'), 'This is a description ' + randomValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/RegionAndMarket/btn_DoneRegion'), 4)
WebUI.click(findTestObject('Object Repository/RegionAndMarket/btn_DoneRegion'))
WebUI.refresh()
CustomKeywords.'commonKeyword.Table.verifyValueOfTable'(RegionNameInput)

@com.kms.katalon.core.annotation.SetUp
def SetUp() {
    CustomKeywords.'commonKeyword.Table.Login'(GlobalVariable.URL_Region)
}

@com.kms.katalon.core.annotation.TearDown
def tearDown() {
    WebUI.closeBrowser()
}

