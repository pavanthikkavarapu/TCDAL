package com.example.basicapp;

import java.io.Serializable;

import com.example.basicapp.model.LoanApplication;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("LOAN_APPLICATION")
	private LoanApplication loanAppliation;

	/**
	 * @return the loanAppliation
	 */
	public LoanApplication getLoanAppliation() {
		return loanAppliation;
	}

	/**
	 * @param loanAppliation the loanAppliation to set
	 */
	public void setLoanAppliation(LoanApplication loanAppliation) {
		this.loanAppliation = loanAppliation;
	} 

}
