package com.example.basicapp.model;

public class AuditSummaryPage {
	
	private AuditSelection auditSelection;

	private AuditResultsSection auditResultsSelection;

	public AuditSelection getAuditSelection() {
		return auditSelection;
	}

	public void setAuditSelection(AuditSelection auditSelection) {
		this.auditSelection = auditSelection;
	}

	public AuditResultsSection getAuditResultsSelection() {
		return auditResultsSelection;
	}

	public void setAuditResultsSelection(AuditResultsSection auditResultsSelection) {
		this.auditResultsSelection = auditResultsSelection;
	}
	
}
