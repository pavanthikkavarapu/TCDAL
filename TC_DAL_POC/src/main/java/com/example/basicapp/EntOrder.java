package com.example.basicapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("clientCompanyName")
	private String clientCompanyName;
	
	@JsonProperty("submittedDate")
	private String submittedDate;
	
	@JsonProperty(value = "countOfReviewedLoans", access = Access.WRITE_ONLY)
	private int LoanCountAudited;
	
	@JsonProperty(value = "countOfLoans", access = Access.WRITE_ONLY)
	private int LoanCountAll;
	
	@JsonProperty(value = "contractedServiceSamplingMethod", access = Access.WRITE_ONLY)	
	private String SamplingMethod;
	
	private String initialLoanRating;
	private String currentLoanRating;
	
	
	public String getClientCompanyName() {
		return clientCompanyName;
	}

	public void setClientCompanyName(String clientCompanyName) {
		this.clientCompanyName = clientCompanyName;
	}

	public int getLoanCountAudited() {
		return LoanCountAudited;
	}

	public void setLoanCountAudited(int loanCountAudited) {
		LoanCountAudited = loanCountAudited;
	}
	
	public int getLoanCountAll() {
		return LoanCountAll;
	}

	public void setLoanCountAll(int loanCountAll) {
		LoanCountAll = loanCountAll;
	}

	public String getSamplingMethod() {
		return SamplingMethod;
	}

	public void setSamplingMethod(String samplingMethod) {
		SamplingMethod = samplingMethod;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getInitialLoanRating() {
		return initialLoanRating;
	}

	public void setInitialLoanRating(String initialLoanRating) {
		this.initialLoanRating = initialLoanRating;
	}

	public String getCurrentLoanRating() {
		return currentLoanRating;
	}

	public void setCurrentLoanRating(String currentLoanRating) {
		this.currentLoanRating = currentLoanRating;
	}
	
}
