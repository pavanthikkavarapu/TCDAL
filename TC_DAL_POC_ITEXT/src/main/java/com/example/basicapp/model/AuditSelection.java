package com.example.basicapp.model;

import java.io.Serializable;

public class AuditSelection implements Serializable {

	private static final long serialVersionUID = 1L;

	private int LoanCountAudited;
	
	private float SamplingPercent;
	
	private int LoanCountAll;
	
	private String SamplingMethod;

	public int getLoanCountAudited() {
		return LoanCountAudited;
	}

	public void setLoanCountAudited(int loanCountAudited) {
		LoanCountAudited = loanCountAudited;
	}

	public float getSamplingPercent() {
		return SamplingPercent;
	}

	public void setSamplingPercent(float samplingPercent) {
		SamplingPercent = samplingPercent;
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
	
}
