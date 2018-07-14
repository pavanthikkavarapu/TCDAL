package com.example.basicapp;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class EntOrderCondition implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	public int getOrderWithNonCriticalEx() {
		return OrderWithNonCriticalEx;
	}

	public void setOrderWithNonCriticalEx(int orderWithNonCriticalEx) {
		OrderWithNonCriticalEx = orderWithNonCriticalEx;
	}

	@JsonProperty(value = "conditionSeverityLevel", access = Access.WRITE_ONLY)
	private int OrderWithNonCriticalEx;
	

}
