package com.example.basicapp.controller;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicapp.LoanData;
import com.example.basicapp.dao.SpringDAO;
import com.example.basicapp.model.AuditSummaryReport;
import com.example.basicapp.view.AuditSummaryReports;
import com.example.basicapp.model.CoverPage;
import com.example.basicapp.view.MyPdfView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class ReportController {

	@Autowired
	public SpringDAO dao;
	
	//public MyPdfView pdfGenerator = new MyPdfView();
	
	 public AuditSummaryReport pdfviewer = new AuditSummaryReport();
	

	@PostMapping("/generatePDF")
	public void generatePDF(@RequestBody LoanData loanData) throws IOException, ParseException {
		MyPdfView myPdfView = new MyPdfView();
		System.out.println(loanData);
		myPdfView.generatePdf(loanData);
	}
	
	
	/*@GetMapping("/getcoverPage")
	public CoverPage coverPageInfo(@RequestParam("poolInstanceId") int poolInstanceId) throws JsonParseException, JsonMappingException, JSONException, IOException {
		return dao.getCoverPage(poolInstanceId);		
	}
*/
	
	
/*	@GetMapping("/getcoverPage")
	public AuditSummaryReport coverPageInfo(@RequestParam("poolInstanceId") int poolInstanceId) throws JsonParseException, JsonMappingException, JSONException, IOException {
	return dao.getAuditSummaryReport(poolInstanceId);
		
	}*/
	@PostMapping("/generateAuditPdf")
	public void generatePDF(@RequestBody AuditSummaryReport auditSummaryReport) throws IOException, ParseException {
		//MyPdfView myPdfView = new MyPdfView();
		
		AuditSummaryReports abc=new AuditSummaryReports();
		System.out.println(auditSummaryReport);
		abc.generatePdf(auditSummaryReport);
		
	}
	
}
