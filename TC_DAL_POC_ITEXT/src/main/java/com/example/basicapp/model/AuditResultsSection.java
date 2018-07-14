package com.example.basicapp.model;

import java.io.Serializable;

public class AuditResultsSection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int LoanCountSelected;
	private int LoanCountExceptions;
	private int CleanLoansCount;
	private int totalExceptions;
	private int CriticalExceptionsPercent; 
	private int NonCriticalExceptionsPercent; 
	private int OrdersWithSomeEx;
	private int OrdersWithCriticalEx;
	private int OrderWithNonCriticalEx;
	
	public int getLoanCountSelected() {
		return LoanCountSelected;
	}
	public void setLoanCountSelected(int loanCountSelected) {
		LoanCountSelected = loanCountSelected;
	}
	public int getLoanCountExceptions() {
		return LoanCountExceptions;
	}
	public void setLoanCountExceptions(int loanCountExceptions) {
		LoanCountExceptions = loanCountExceptions;
	}
	public int getCleanLoansCount() {
		return CleanLoansCount;
	}
	public void setCleanLoansCount(int cleanLoansCount) {
		CleanLoansCount = cleanLoansCount;
	}
	public int getTotalExceptions() {
		return totalExceptions;
	}
	public void setTotalExceptions(int totalExceptions) {
		this.totalExceptions = totalExceptions;
	}
	public int getCriticalExceptionsPercent() {
		return CriticalExceptionsPercent;
	}
	public void setCriticalExceptionsPercent(int criticalExceptionsPercent) {
		CriticalExceptionsPercent = criticalExceptionsPercent;
	}
	public int getNonCriticalExceptionsPercent() {
		return NonCriticalExceptionsPercent;
	}
	public void setNonCriticalExceptionsPercent(int nonCriticalExceptionsPercent) {
		NonCriticalExceptionsPercent = nonCriticalExceptionsPercent;
	}
	public int getOrdersWithSomeEx() {
		return OrdersWithSomeEx;
	}
	public void setOrdersWithSomeEx(int ordersWithSomeEx) {
		OrdersWithSomeEx = ordersWithSomeEx;
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
	
}