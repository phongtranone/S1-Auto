package commonKeyword
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


class Table {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	public static int getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.tagName("tr"))
		int totalRows = selectedRows.size()
		println "Total rows: "+ totalRows
		return totalRows
	}
	@Keyword
	public static verifyValueOfTable(String textSearch){
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.verifyElementPresent(findTestObject('Object Repository/RegionAndMarket/tableRegion'), 4)
		WebElement Table = driver.findElement(By.xpath("//table/tbody"))
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		int rows_count = rows_table.size()
		Boolean checkData = false;
		Loop:
		for (int row = 0; row < rows_count; row++) {
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))
			int columns_count = Columns_row.size()

			println((('Number of cells In Row ' + row) + ' are ') + columns_count)

			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText().trim()
				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)
				if (celltext.equals(textSearch)) {
					WebUI.verifyEqual(celltext, textSearch)
					checkData = true
					println('Region searched: ' + Columns_row.get(column).getText())
					break Loop
				}
			}
		}
		if(checkData){
		}else{
			KeywordUtil.markFailed("Can not find data into this table")
		}
	}

	@Keyword
	public static Login(String URL){
		WebUI.openBrowser(URL)
		WebUI.maximizeWindow()
		WebUI.setText(findTestObject('Object Repository/Login/txt_Email'), GlobalVariable.email)
		WebUI.setText(findTestObject('Object Repository/Login/txt_Password'), GlobalVariable.password)
		WebUI.click(findTestObject('Object Repository/Login/btn_Sign in'))
	}
}