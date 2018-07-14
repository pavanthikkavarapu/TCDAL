package com.example.basicapp.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.example.basicapp.LoanData;
import com.example.basicapp.model.Borrower;
import com.itextpdf.io.IOException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MyPdfView {

       
        public void generatePdf(LoanData loanData) throws IOException, ParseException {
        	final String DEST = "D:\\dev\\DAL\\MyMLC" + loanData.getLoanNumber() + ".pdf";
            File file = new File(DEST);
            file.getParentFile().mkdirs();
            JSONParser parser = new JSONParser();
            try
            {
//                Object object = parser
//                        .parse(new FileReader("D:\\dev\\DAL\\itextapp\\sample.json"));
                
                //convert Object to JSONObject
//                JSONObject jsonObject = (JSONObject)object;
                
                //Reading the String
//                String loanNumber = (String) jsonObject.get("LoanNumber");
//                String toRecipient = (String) jsonObject.get("ToRecipient");
//                String address = (String) jsonObject.get("Address");
                
                String loanNumber = loanData.getLoanNumber();
                List<Borrower> borrowers = loanData.getContent().getLoanAppliation().getBorrower();
                Borrower borrower = borrowers.get(0);
                //String fullname = borrower. //concat all names
                String address = loanData.getContent().getLoanAppliation().getProperty().getCity();
                //concat full address and then pass to create pdf
                
                new MyPdfView().createPdf(DEST, loanNumber, borrower.getFirstName(), address);
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
        
      
        public void createPdf(String dest, String loanNumber, String toRecipient, String Address) throws IOException, java.io.IOException, ParseException {
            
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            // Create a PdfFont
            PdfFont fontBold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
            
            Date date = new Date();
            
            // Add a Paragraph
            document.add(new Paragraph("MORTGAGE LOAN COMMITMENT")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(fontBold).setFontSize(14));
            
            document.add(new Paragraph("HOMESTEAD MORTGAGE CORPORATION1 WIT")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font).setFontSize(10));

            document.add(new Paragraph("26400, LAHSER RD1, SOUTHFIELD OH 48071 ")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font).setFontSize(10));
        
            document.add(new Paragraph("Loan Number :" + " " + loanNumber)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font).setFontSize(10));
        
            document.add(new Paragraph("Date :" + " " + date)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font).setFontSize(10));

            document.add(new Paragraph("To :" + " " + toRecipient)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font).setFontSize(10));

            document.add(new Paragraph("Property Address :" + " " + Address)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font).setFontSize(10));
            
            document.add(new Paragraph("We are pleased to inform you that your mortgage loan application has been     Final Approved    , subject to the following terms and conditions")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font).setFontSize(10));
            
            /*TERMS:
                Loan Amount:200,000.00 Loan Term: 180 Appraised Value: 252,525.00
                Loan Type: FHA Amortization Type: Fixed Rate Purchase Price: 353,535.00
                Interest Rate: 10.000 %*/
            document.add(new Paragraph("TERMS:")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(fontBold).setFontSize(10));
            
            document.add(new Paragraph("Loan Amount:200,000.00 Loan Term: 180 Appraised Value: 252,525.00\r\n" + 
                                       "Loan Type: FHA Amortization Type: Fixed Rate Purchase Price: 353,535.00\r\n" + 
                                       "Interest Rate: 10.000")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font).setFontSize(10));
            
            document.close();
            
            System.out.println("Successfully created");
    }

}