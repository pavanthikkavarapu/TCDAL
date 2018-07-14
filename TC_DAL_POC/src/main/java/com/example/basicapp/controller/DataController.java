package com.example.basicapp.controller;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.basicapp.LoanData;
import com.example.basicapp.dao.SpringDAO;
import com.example.basicapp.model.AuditSummaryReport;
import com.example.basicapp.model.CoverPage;
import com.example.basicapp.view.MyPdfView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DataController {

	@Autowired
	public SpringDAO dao;
	
	public MyPdfView pdfGenerator = new MyPdfView();

	@GetMapping("/getcustInfo")
	public void customerInformation(@RequestParam("loanNumber") String loanNumber) throws JSONException, JsonParseException, JsonMappingException, IOException, com.itextpdf.io.IOException, ParseException {
		String json = dao.getMlcReportDetails(loanNumber);
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObj = new JSONObject(json);
		LoanData loanData = mapper.readValue(jsonObj.toString(),LoanData.class);
		//return loanData;
		final String uri = "http://localhost:8090/generatePDF";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(uri, loanData, LoanData.class);
		
	}
	
	/*@GetMapping("/getcoverPage")
	public CoverPage coverPageInfo(@RequestParam("poolInstanceId") int poolInstanceId) throws JsonParseException, JsonMappingException, JSONException, IOException {
		return dao.getCoverPage(poolInstanceId);		
	}
*/
	
	
	@GetMapping("/getcoverPage")
	public AuditSummaryReport coverPageInfo(@RequestParam("poolInstanceId") int poolInstanceId,
			@RequestParam("reportType") String reportType) throws  JSONException, IOException {
		AuditSummaryReport ReportData = dao.getAuditSummaryReport(poolInstanceId, reportType);
		final String uri = "http://localhost:8090/generateAuditPdf";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(uri, ReportData, AuditSummaryReport.class);
		return ReportData;
		
	}
}
