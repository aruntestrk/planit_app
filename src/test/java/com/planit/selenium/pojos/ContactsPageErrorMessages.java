package com.planit.selenium.pojos;

import java.io.Serializable;

public class ContactsPageErrorMessages implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String foreNameRequired;
	private String emailRequired;
	private String messageRequired;
	
	public String getForeNameRequired() {
		return foreNameRequired;
	}

	public void setForeNameRequired(String foreNameRequired) {
		this.foreNameRequired = foreNameRequired;
	}

	public String getEmailRequired() {
		return emailRequired;
	}

	public void setEmailRequired(String emailRequired) {
		this.emailRequired = emailRequired;
	}

	public String getMessageRequired() {
		return messageRequired;
	}

	public void setMessageRequired(String messageRequired) {
		this.messageRequired = messageRequired;
	}

	

}
