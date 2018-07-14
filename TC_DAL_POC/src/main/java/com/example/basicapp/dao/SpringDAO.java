package com.example.basicapp.dao;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.basicapp.EntOrder;
import com.example.basicapp.EntOrderCondition;
import com.example.basicapp.model.AuditResultsSection;
import com.example.basicapp.model.AuditSelection;
import com.example.basicapp.model.AuditSummaryPage;
import com.example.basicapp.model.AuditSummaryReport;
import com.example.basicapp.model.CoverPage;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class SpringDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate; 

	public String getMlcReportDetails(String loanNumber) {
		
		String SQL = " select JSON_VALUE from ent_loan where loanNumber = \"" + loanNumber + "\" limit 1";
		String JsonValue = jdbcTemplate.queryForObject(SQL, String.class);
		
		return JsonValue;
	}
	
	/*public CoverPage getCoverPage(int poolInstanceId) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
		String SQL = " select JSON_VALUE from ent_order where poolInstanceId ="+ poolInstanceId;
		List<String> JsonValue = jdbcTemplate.queryForList(SQL, String.class);
		String json = JsonValue.get(0);
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObj = new JSONObject(json);
		CoverPage coverPageData = mapper.readValue(jsonObj.toString(), CoverPage.class);
		if (coverPageData.getLoanCountAll() != 0) {
			coverPageData.setSamplingPercent((coverPageData.getLoanCountAudited() / coverPageData.getLoanCountAll()) * 100);
		}
		return coverPageData;
	}*/
	
public AuditSummaryReport getAuditSummaryReport(int poolInstanceId, String reportType) throws JSONException, IOException, java.io.IOException {
		
		String SQL = " select JSON_VALUE from ent_order where poolInstanceId ="+ poolInstanceId;
		
		////////
/*		String SqlQueryEntOrderCondition = "select JSON_VALUE from ent_order_condition where orderId= "+poolInstanceId;
		List<String> JsonValue1 = jdbcTemplate.queryForList(SqlQueryEntOrderCondition, String.class);
		ObjectMapper mapper1 = new ObjectMapper();
		EntOrderCondition auditResult = new EntOrderCondition();
		
		auditResult.setOrderWithNonCriticalEx(1000);*/
		/////////
		List<String> JsonValue = jdbcTemplate.queryForList(SQL, String.class);
		ObjectMapper mapper = new ObjectMapper();
		AuditSelection auditSelection = new AuditSelection();
		AuditResultsSection auditResultsSelection = new AuditResultsSection();
		CoverPage coverPage = new CoverPage();
		EntOrder entOrder = new EntOrder();
		for(String json: JsonValue){
			json = json.toString();
			JSONObject jsonObj = new JSONObject(json);
			entOrder = mapper.readValue(jsonObj.toString(),EntOrder.class);

			coverPage.setClientCompanyName(entOrder.getClientCompanyName());
			coverPage.setOrderDate(entOrder.getSubmittedDate());
			coverPage.setEffectiveDate(entOrder.getSubmittedDate());
			
			auditSelection.setLoanCountAll(entOrder.getLoanCountAll());
			auditSelection.setSamplingMethod(entOrder.getSamplingMethod());
			auditSelection.setLoanCountAudited(entOrder.getLoanCountAudited());
			auditSelection.setSamplingPercent((entOrder.getLoanCountAudited() / entOrder.getLoanCountAll()) * 100);
			
			auditResultsSelection.setLoanCountSelected(entOrder.getLoanCountAll());
			if(reportType.equalsIgnoreCase("Prelim")) {
				
			}
			auditResultsSelection.setLoanCountExceptions(1);
			int loancount = auditResultsSelection.getLoanCountSelected();
			int loanCountExceptions = auditResultsSelection.getLoanCountExceptions();
			auditResultsSelection.setCleanLoansCount(loancount-loanCountExceptions);
			auditResultsSelection.setTotalExceptions(1);
			auditResultsSelection.setCriticalExceptionsPercent(100);
			auditResultsSelection.setTotalExceptions(1);
			auditResultsSelection.setOrdersWithSomeEx(1);
			auditResultsSelection.setOrdersWithCriticalEx(1);
			auditResultsSelection.setOrderWithNonCriticalEx(1);
		}
		AuditSummaryPage auditSummaryPage = new AuditSummaryPage();
		auditSummaryPage.setAuditResultsSelection(auditResultsSelection);
		auditSummaryPage.setAuditSelection(auditSelection);
		
		AuditSummaryReport auditSummaryReport = new AuditSummaryReport();
		auditSummaryReport.setCoverPage(coverPage);
		auditSummaryReport.setAuditSummaryPage(auditSummaryPage);
		
		
	/*	String originalString = coverPage.getOrderDate();
	    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(originalString);
	    String newstring = new SimpleDateFormat("MMMM yyyy").format(date);
	    coverPage.setOrderDate(newstring);
	    
	    Date today = Calendar.getInstance().getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
	    String localdate = formatter.format(today);
	    coverPage.setEffectiveDate(localdate);*/
		
		
		
		
		
		return auditSummaryReport;
	}

private void setOrderWithNonCriticalEx(String string) {
	// TODO Auto-generated method stub
	
}
	
}

