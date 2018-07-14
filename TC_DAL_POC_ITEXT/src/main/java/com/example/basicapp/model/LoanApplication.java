package com.example.basicapp.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanApplication implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("BORROWER")
	private List<Borrower> borrower;
	
	@JsonProperty("PROPERTY")
	private Property property;

	/**
	 * @return the borrower
	 */
	public List<Borrower> getBorrower() {
		return borrower;
	}

	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(List<Borrower> borrower) {
		this.borrower = borrower;
	}

	/**
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}

}
