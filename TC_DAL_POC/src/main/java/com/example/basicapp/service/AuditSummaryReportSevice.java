/*package com.example.basicapp.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.basicapp.dao.SpringDAO;
import com.example.basicapp.model.AuditResultsSection;
import com.example.basicapp.model.AuditSelection;
import com.example.basicapp.model.AuditSummaryPage;
import com.example.basicapp.model.AuditSummaryReport;
import com.example.basicapp.model.CoverPage;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuditSummaryReportSevice {
	
	public SpringDAO dao = new SpringDAO();
	
public AuditSummaryReport getAuditSummaryReport(int poolInstanceId) throws JSONException, IOException, java.io.IOException {
		
//		String SQL = " select JSON_VALUE from ent_order where poolInstanceId ="+ poolInstanceId;
//		List<String> JsonValue = jdbcTemplate.queryForList(SQL, String.class);
		String json = dao.getAuditSummaryReport(poolInstanceId);
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObj = new JSONObject(json);
		CoverPage coverPage = mapper.readValue(jsonObj.toString(),CoverPage.class);
		
	
		AuditSelection auditSelection = mapper.readValue(jsonObj.toString(),AuditSelection.class);
		
		AuditResultsSection auditResultsSelection = mapper.readValue(jsonObj.toString(),AuditResultsSection.class);
		
		AuditSummaryPage auditSummaryPage = new AuditSummaryPage();
		auditSummaryPage.setAuditResultsSelection(auditResultsSelection);
		auditSummaryPage.setAuditSelection(auditSelection);
		
		if (auditSelection.getLoanCountAll() != 0) {
			//LoanCountAudited / LoanCountAll * 100
			auditSelection.setSamplingPercent(auditSelection.getLoanCountAudited() / auditSelection.getLoanCountAll() * 100);
		}
		
		AuditSummaryReport auditSummaryReport = new AuditSummaryReport(); 
		auditSummaryReport.setCoverPage(coverPage);
		auditSummaryReport.setAuditSummaryPage(auditSummaryPage);
		
		return auditSummaryReport;
	}
}
*/