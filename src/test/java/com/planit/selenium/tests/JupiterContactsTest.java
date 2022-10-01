package com.planit.selenium.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.plaint.selenium.pages.ContactsPage;
import com.plaint.selenium.pages.JupiterHomePage;
import com.planit.seleniium.base.BaseTest;
import com.planit.selenium.dataprovider.ContactsDataProvider;
import com.planit.selenium.page.components.Navigations;
import com.planit.selenium.pojos.Contact;
import com.planit.selenium.pojos.ContactsPageErrorMessages;
import com.planit.selenium.utils.JacksonUtils;


public class JupiterContactsTest extends BaseTest {
	

    @Test(dataProvider = "submissionDataOne", dataProviderClass = ContactsDataProvider.class)
    public void contactsSubmissionE2E(HashMap<String,Contact> contactMap) throws Exception {
    	ContactsPageErrorMessages contactsPageErrorMessage = JacksonUtils.deserializeJson("contacts_errorMessages.json", ContactsPageErrorMessages.class);
    	JupiterHomePage jupiterHomePage = new JupiterHomePage(getDriver());
    	jupiterHomePage.load();
    	Navigations navigations = jupiterHomePage.getNavigations();
    	ContactsPage contactsPage = navigations.clickContactsLink();
    	contactsPage.clickSubmitBtn();
    	Assert.assertEquals(contactsPage.getForeNameErrorMessage(), contactsPageErrorMessage.getForeNameRequired());
    	Assert.assertEquals(contactsPage.getEmailErrorMessage(), contactsPageErrorMessage.getEmailRequired());
    	Assert.assertEquals(contactsPage.getMessageErrorMessage(), contactsPageErrorMessage.getMessageRequired());
    	Contact contact = contactMap.get("contactObj");
    	contactsPage.enterTextInFirstNameField(contact.getFirstName());
    	contactsPage.enterTextInSurNameField(contact.getLastName());
    	contactsPage.enterTextInEmailField(contact.getMessage());
    	contactsPage.enterTextInTelephoneField(contact.getTelephone());
    	contactsPage.enterTextInMessageField(contact.getMessage());
    	contactsPage.clickSubmitBtn();
    	Assert.assertEquals(contact.getSuccessMessage(), contactsPage.getContactsSuccessMessage());
       	contactsPage.clickBackButton();
    }

	 
	
    @Test(dataProvider = "submissionData", dataProviderClass = ContactsDataProvider.class)
    public void contactsSubmissionPositive(HashMap<String,Contact> contactMap) throws Exception {
    	JupiterHomePage jupiterHomePage = new JupiterHomePage(getDriver());
    	jupiterHomePage.load();
    	Navigations navigations = jupiterHomePage.getNavigations();
    
    	ContactsPage contactsPage = navigations.clickContactsLink();
    	
    	Contact contact = contactMap.get("contactObj");
    	contactsPage.enterTextInFirstNameField(contact.getFirstName());
    	contactsPage.enterTextInSurNameField(contact.getLastName());
    	contactsPage.enterTextInEmailField(contact.getMessage());
    	contactsPage.enterTextInTelephoneField(contact.getTelephone());
    	contactsPage.enterTextInMessageField(contact.getMessage());
    	contactsPage.clickSubmitBtn();
    	Assert.assertEquals(contact.getSuccessMessage(), contactsPage.getContactsSuccessMessage());
    	contactsPage.clickBackButton();
    }

  

}
