
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject


def static "commonKeyword.Email.clickElementByValue"(
    	String value	) {
    (new commonKeyword.Email()).clickElementByValue(
        	value)
}

def static "commonKeyword.Email.getLink_inEmail"(
    	String host	
     , 	String user	
     , 	String password	
     , 	String subject	) {
    (new commonKeyword.Email()).getLink_inEmail(
        	host
         , 	user
         , 	password
         , 	subject)
}

def static "commonKeyword.Email.delete_AllEmail"(
    	String user	
     , 	String password	) {
    (new commonKeyword.Email()).delete_AllEmail(
        	user
         , 	password)
}

def static "commonKeyword.CommonKeyword.RandomValue"(
    	int number	) {
    (new commonKeyword.CommonKeyword()).RandomValue(
        	number)
}

def static "commonKeyword.Table.refreshBrowser"() {
    (new commonKeyword.Table()).refreshBrowser()
}

def static "commonKeyword.Table.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new commonKeyword.Table()).getHtmlTableRows(
        	table
         , 	outerTagName)
}

def static "commonKeyword.Table.verifyValueOfTable"(
    	String textSearch	) {
    (new commonKeyword.Table()).verifyValueOfTable(
        	textSearch)
}

def static "commonKeyword.Table.Login"(
    	String URL	) {
    (new commonKeyword.Table()).Login(
        	URL)
}
