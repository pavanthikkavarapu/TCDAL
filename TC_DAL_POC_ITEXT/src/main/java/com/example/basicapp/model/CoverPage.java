package com.example.basicapp.model;

import java.io.Serializable;

public class CoverPage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String clientCompanyname;
	private String submittedDate;
	private String OrderDate;
	
	public String getClientCompanyName() {
		return clientCompanyname;
	}

	public void setClientCompanyName(String clientCompanyName) {
		this.clientCompanyname = clientCompanyName;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
private String EffectiveDate;
	

	public String getEffectiveDate() {
		return EffectiveDate;
	}

	public void setEffectiveDate(String EffectiveDate) {
		this.EffectiveDate = EffectiveDate;
	}
	
}
