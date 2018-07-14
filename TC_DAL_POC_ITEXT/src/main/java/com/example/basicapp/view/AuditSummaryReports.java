package com.example.basicapp.view;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.example.basicapp.model.AuditSummaryReport;
import com.example.basicapp.model.CoverPage;
//import com.example.basicapp.LoanData;
//import com.example.basicapp.model.Borrower;
import com.itextpdf.io.IOException;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AuditSummaryReports {

   // public final String IMAGE1 = "D:\\dev\\DAL\\Trelix.jpg";
    public final String DEST = "D:\\dev\\DAL\\AuditSummary.pdf";
    public static final String LABEL2 = "A bunch of stuff: ";
    public static final String CONTENT2 = "test 1, test 2, coconut 3, coconut, watermelons, apple, oranges, many more " +
        "fruites, carshow, monstertrucks thing, everything is startting on the " +
        "same point in the line now";
    public final String imgPath = "D:\\dev\\DAL\\Trelix.JPG";
       
        public void generatePdf(AuditSummaryReport auditSummaryReport) throws IOException, ParseException {
            
            File file = new File(DEST);
            file.getParentFile().mkdirs();
            JSONParser parser = new JSONParser();
            try
            {        
               
//                String effectiveDate = coverPageData.;
                this.createPdf(DEST, auditSummaryReport);
            }
            catch(FileNotFoundException fe)
            {
                fe.printStackTrace();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        public void createPdf(String dest, AuditSummaryReport auditSummaryReport) throws IOException, java.io.IOException, ParseException {
            
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            // Create a PdfFont
            PdfFont fontBold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
            Date date = new Date();
            
            PdfFont fontBold1 = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            PdfFont font1 = PdfFontFactory.createFont(FontConstants.HELVETICA);
            
            String clientCompanyName = auditSummaryReport.getCoverPage().getClientCompanyName();
            String orderDate = auditSummaryReport.getCoverPage().getOrderDate();
            String AuditSelection = "Audit Selection: There were"+auditSummaryReport.getAuditSummaryPage().getAuditResultsSelection().getLoanCountSelected()+"loan(s)"
            		+ " reviewed for this audit. This represents a sample of"+auditSummaryReport.getAuditSummaryPage().getAuditSelection().getSamplingPercent()+ "% of"
            		+ " the\r\n" + "total" +auditSummaryReport.getAuditSummaryPage().getAuditResultsSelection().getLoanCountSelected()+ "loans provided by 123 Mortgage"
            		+ " Company to Trelix for"+auditSummaryReport.getAuditSummaryPage().getAuditSelection().getSamplingMethod()+"These loans were closed or funded "
            		+ "between January 01,2018 and January 31,2018.";
            
            document.add(new Paragraph(clientCompanyName)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(fontBold).setFontSize(14));
            
            document.add(new Paragraph("Preliminary Audit Report")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font).setFontSize(10));

            document.add(new Paragraph("Post Close Random Audit Report -" + "" + orderDate)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font).setFontSize(10));
        
            document.add(new Paragraph("Effective Date" + "" + new Date())
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font).setFontSize(10));
           
            document.add(new Paragraph("\n\n"));
            document.add(new Paragraph("Private and Confidential\r\n" + 
                    "For 123 Mortgage Company Internal Use Only\r\n\n\n")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(fontBold1).setFontSize(8));

            document.add(new Paragraph("\n\n"));
            document.add(new Paragraph("(c) 2018 Altisource. All Rights Reserved.\r\n" + 
                    "13736 Riverport Drive, Suite 420 Maryland Heights, MO 63043")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font).setFontSize(10));
            
            document.add(new AreaBreak());
            
            document.add(new Paragraph("Audit Summary")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(fontBold).setFontSize(14));
            
            document.add(new Paragraph("Note:Trelix review all loans files in accordance with the executed statements of work,"
            		+ "as further supplemented by any customer requests or layouts.")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font).setFontSize(12));
            
            document.add(new Paragraph("Summary of Audit Findings")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(fontBold).setFontSize(14));
            document.add(new Paragraph("Audit Selection:"+AuditSelection)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font).setFontSize(14));
            
            
            document.add(new Paragraph("Audit Results: Based on our initial review, 14 of the 16 loan(s) selected for this audit had at least one" + 
            		"exception from at least one event grade. Consequently 2 loan(s) had no exceptionsnoted." + 
            		"In total, 84 exception(s) were noted across all loans and all event grades. Critical" + 
            		"exceptions accounted for 35.71% of the exceptions, which include EV4 and EV5 event" + 
            		"grades. Non-critical exceptions, those rated as EV2 and EV3, accounted for 64.29% of" + 
            		"all exceptions noted.Of the 14 loan(s) with exceptions, 9 loan(s) were rated as EV4 or EV5 "+
            		"and 5 loan(s) were rated as EV2 or EV3.")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font).setFontSize(14));
            document.add(new Paragraph("Audit Notes: Note: At the customer's request,Trelix has not audited these loans for the presence of\r\n" + 
            		"the Privacy Policy Notice as this document is not delivered with the loan package for\r\n" + 
            		"quality control.")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font).setFontSize(14));
            
            
            
            document.add(new AreaBreak());
            
            

            document.close();
            
            System.out.println("Successfully created");
    }

}