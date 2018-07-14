package com.example.basicapp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverallSection implements Serializable {
	
	@JsonProperty(value = "countOfReviewedLoans", access = Access.WRITE_ONLY)
	private int LoanCountAudited;
	
	@JsonProperty(value = "countOfOpenExceptions", access = Access.WRITE_ONLY)
	private int OrdersWithCriticalEx;
	
	@JsonProperty(value = "poolOrderCountOfLoans", access = Access.WRITE_ONLY)
	private int OrderWithNonCriticalEx;
	
	@JsonProperty(value = "countOfCompletedLoans", access = Access.WRITE_ONLY)
	private int GrossCriticalDefectPercent;
	
	@JsonProperty(value = "countOfFinalExceptions", access = Access.WRITE_ONLY)
	private int GrossNonCriticalDefectPercent;
	
	public int getLoanCountAudited() {
		return LoanCountAudited;
	}
	public void setLoanCountAudited(int loanCountAudited) {
		LoanCountAudited = loanCountAudited;
	}
	
	public int getOrdersWithCriticalEx() {
		return OrdersWithCriticalEx;
	}
	public void setOrdersWithCriticalEx(int ordersWithCriticalEx) {
		OrdersWithCriticalEx = ordersWithCriticalEx;
	}
	
	public int getOrderWithNonCriticalEx() {
		return OrderWithNonCriticalEx;
	}
	public void setOrderWithNonCriticalEx(int orderWithNonCriticalEx) {
		OrderWithNonCriticalEx = orderWithNonCriticalEx;
	}
	
	public int getGrossCriticalDefectPercent() {
		return GrossCriticalDefectPercent;
	}
	public void setGrossCriticalDefectPercent(int grossCriticalDefectPercent) {
		GrossCriticalDefectPercent = grossCriticalDefectPercent;
	}
	
	public int getGrossNonCriticalDefectPercent() {
		return GrossNonCriticalDefectPercent;
	}
	public void setGrossNonCriticalDefectPercent(int grossNonCriticalDefectPercent) {
		GrossNonCriticalDefectPercent = grossNonCriticalDefectPercent;
	}
}
