package com.example.basicapp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditSelection implements Serializable {
	
	@JsonProperty(value = "countOfReviewedLoans", access = Access.WRITE_ONLY)
	private int LoanCountAudited;
	
	private float SamplingPercent;
	
	@JsonProperty(value = "countOfLoans", access = Access.WRITE_ONLY)
	private int LoanCountAll;
	
	@JsonProperty(value = "contractedServiceSamplingMethod", access = Access.WRITE_ONLY)	
	private String SamplingMethod;
	
	
	
	public String getSamplingMethod() {
		return SamplingMethod;
	}

	public void setSamplingMethod(String samplingMethod) {
		SamplingMethod = samplingMethod;
	}

	/**
	 * @return the loanCountAudited
	 */
	public int getLoanCountAudited() {
		return LoanCountAudited;
	}

	/**
	 * @param loanCountAudited the loanCountAudited to set
	 */
	public void setLoanCountAudited(int loanCountAudited) {
		LoanCountAudited = loanCountAudited;
	}

	/**
	 * @return the samplingPercent
	 */
	public float getSamplingPercent() {
		return SamplingPercent;
	}

	/**
	 * @param samplingPercent the samplingPercent to set
	 */
	public void setSamplingPercent(float samplingPercent) {
		SamplingPercent = samplingPercent;
	}
	
	/**
	 * @return the loanCountAll
	 */
	public int getLoanCountAll() {
		return LoanCountAll;
	}

	/**
	 * @param loanCountAll the loanCountAll to set
	 */
	public void setLoanCountAll(int loanCountAll) {
		LoanCountAll = loanCountAll;
	}


	

	
	

}
