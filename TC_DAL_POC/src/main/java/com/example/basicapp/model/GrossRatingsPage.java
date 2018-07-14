package com.example.basicapp.model;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public class GrossRatingsPage<OverallSection> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("OverallSection")
	private OverallSection overallSection;

	
	
	public OverallSection getOverallSection() {
		return overallSection;
	}

	public void setOverallSection(OverallSection overallSection) {
		this.overallSection = overallSection;
	}

	
}
