package com.planit.selenium.dataprovider;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

import com.planit.selenium.pojos.Contact;

public class ContactsDataProvider {

	@DataProvider(name = "submissionData")
	public Object[] getContactsData() {
		Object[][] data = prepareContactsData();
		return data;
	}

	private Object[][] prepareContactsData() {
		Contact contact1 = new Contact();
		contact1.setFirstName("Aligen");
		contact1.setLastName("Polaci");
		contact1.setEmail("prasath@gmail.com");
		contact1.setMessage("How are you?");
		contact1.setSuccessMessage("Thanks Aligen, we appreciate your feedback.");
		contact1.setTelephone("090909");

		HashMap<String, Contact> dataMap1 = new HashMap<String, Contact>();
		dataMap1.put("contactObj", contact1);

		Contact contact2 = new Contact();
		contact2.setFirstName("Adam");
		contact2.setLastName("Butcher");
		contact2.setEmail("prasath@gmail.com");
		contact2.setMessage("How are you?");
		contact2.setSuccessMessage("Thanks Adam, we appreciate your feedback.");
		contact2.setTelephone("090909");

		HashMap<String, Contact> dataMap2 = new HashMap<String, Contact>();
		dataMap2.put("contactObj", contact2);

		Contact contact3 = new Contact();
		contact3.setFirstName("John");
		contact3.setLastName("Cheng");
		contact3.setEmail("prasath@gmail.com");
		contact3.setMessage("How are you?");
		contact3.setSuccessMessage("Thanks John, we appreciate your feedback.");
		contact3.setTelephone("090909");

		HashMap<String, Contact> dataMap3 = new HashMap<String, Contact>();
		dataMap3.put("contactObj", contact3);

		Contact contact4 = new Contact();
		contact4.setFirstName("Robert");
		contact4.setLastName("Chris");
		contact4.setEmail("prasath@gmail.com");
		contact4.setMessage("How are you?");
		contact4.setSuccessMessage("Thanks Robert, we appreciate your feedback.");
		contact4.setTelephone("090909");

		HashMap<String, Contact> dataMap4 = new HashMap<String, Contact>();
		dataMap4.put("contactObj", contact4);

		Contact contact5 = new Contact();
		contact5.setFirstName("Smith");
		contact5.setLastName("Chris");
		contact5.setEmail("prasath@gmail.com");
		contact5.setMessage("How are you?");
		contact5.setSuccessMessage("Thanks Smith, we appreciate your feedback.");
		contact5.setTelephone("090909");

		HashMap<String, Contact> dataMap5 = new HashMap<String, Contact>();
		dataMap5.put("contactObj", contact4);

		Object data[][] = { { dataMap1 }, { dataMap2 }, { dataMap3 }, { dataMap4 }, { dataMap5 } };
		return data;
	}

	@DataProvider(name = "submissionDataOne")
	private Object[][] prepareOneContactsData() {
		Contact contact1 = new Contact();
		contact1.setFirstName("Aligen");
		contact1.setLastName("Polaci");
		contact1.setEmail("prasath@gmail.com");
		contact1.setMessage("How are you?");
		contact1.setSuccessMessage("Thanks Aligen, we appreciate your feedback.");
		contact1.setTelephone("090909");

		HashMap<String, Contact> dataMap1 = new HashMap<String, Contact>();
		dataMap1.put("contactObj", contact1);

		Object data[][] = { { dataMap1 } };
		return data;
	}

}
