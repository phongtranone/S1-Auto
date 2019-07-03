package commonKeyword
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Flags;

import org.jsoup.Jsoup as Jsoup;

class Email {

	/**
	 * Click element by 
	 * @param value
	 */
	@Keyword
	public void clickElementByValue(String value) {
		String dynamicIdPath = '//li[.="%s"]'
		TestObject to = new TestObject()
		String xpath = String.format(dynamicIdPath, value)
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		WebUI.click(to)
	}

	@Keyword
	public static String getLink_inEmail(String host, String user,String password,String subject) {
		try {

			//create properties field
			Properties properties = new Properties();
			properties.put("mail.imap.host",host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			properties.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			properties.setProperty("mail.imap.socketFactory.fallback", "false");
			properties.setProperty("mail.imap.socketFactory.port",String.valueOf(993));
			Session emailSession = Session.getDefaultInstance(properties);

			//create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("imap");

			store.connect(host, user, password);

			//create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);
			int n=messages.length;
			for (int i = 0; i<n; i++) {
				Message message = messages[i];
				ArrayList<String> links = new ArrayList<String>();
				if(message.getSubject().contains(subject))
				{
					String desc=message.getContent().toString();

					// System.out.println(desc);
					Pattern urlPattern = Pattern.compile("href=\"([^\"]*)", Pattern.CASE_INSENSITIVE|Pattern.DOTALL)
					Matcher matcher = urlPattern.matcher(desc)

					while (matcher.find())
					{
						String address = matcher.group(1)

						println('Got URL: ' + address)
						return address
						break
					}
				}
				else{
					System.out.println("Email:"+ i + " is not a wanted email");
				}
				for(String temp:links)
				{
					if(temp.contains("user-register"))
					{
						System.out.println(temp);
					}
				}

				/*System.out.println("---------------------------------");
				 System.out.println("Email Number " + (i + 1));
				 System.out.println("Subject: " + message.getSubject());
				 System.out.println("From: " + message.getFrom()[0]);
				 System.out.println("Text: " + message.getContent().toString());*/

			}
			//close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Keyword
	public static delete_AllEmail(String user,String password)
	{
		try {

			//create properties field
			Properties properties = new Properties();
			properties.put("mail.imap.host","imap.gmail.com");
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			properties.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			properties.setProperty("mail.imap.socketFactory.fallback", "false");
			properties.setProperty("mail.imap.socketFactory.port",String.valueOf(993));
			Session emailSession = Session.getDefaultInstance(properties);

			//create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("imap");

			store.connect("imap.gmail.com", user, password);

			//create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);
			int n=messages.length;
			for (int i = 0; i<n; i++)
			{
				Message message = messages[i];
				message.setFlag(Flags.Flag.DELETED, true)

			}

			/*System.out.println("---------------------------------");
			 System.out.println("Email Number " + (i + 1));
			 System.out.println("Subject: " + message.getSubject());
			 System.out.println("From: " + message.getFrom()[0]);
			 System.out.println("Text: " + message.getContent().toString());*/

			//close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}





}


