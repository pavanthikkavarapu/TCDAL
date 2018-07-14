package com.example.basicapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


/*@Entity
@Table(name = "ent_loan")*/
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//        allowGetters = true)
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;*/

	@NotBlank
	private int ID;
	@NotBlank
	private int VERSION;
	@NotBlank
	private String CREATED_BY;
	@NotBlank
	private Date CREATED_DATE;
	@NotBlank
	private String MODIFIED_BY;
	@NotBlank
	private Date MODIFIED_DATE;
	@NotBlank
	private String JSON_VALUE;
	
	private Boolean DELETED;
	@NotBlank
	private String loanNumber;
	@NotBlank
	private int loanId;
	@NotBlank
	private String providerTenantId;
	@NotBlank
	private String bapId;
	@NotBlank
	private String clientTenantId;
	
	
	@Column(name = "ASPS_LoanCancelledDate")
	private String loanCancelledDate;
	
	
	@Column(name = "ASPS_LoanDeniedDate")
	private String loanDeniedDate;
	
	
	@Column(name = "ASPS_LoanFundingDate")
	private String loanFundingDate;

	
	@Column(name = "ASPS_LoanStatusDate")
	private String loanStatusDate;

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param  the iD to set
	 */
	public void setID(int id) {
		ID = id;
	}

	/**
	 * @return the vERSION
	 */
	public int getVERSION() {
		return VERSION;
	}

	/**
	 * @param vERSION the vERSION to set
	 */
	public void setVERSION(int vERSION) {
		VERSION = vERSION;
	}

	/**
	 * @return the cREATED_BY
	 */
	public String getCREATED_BY() {
		return CREATED_BY;
	}

	/**
	 * @param cREATED_BY the cREATED_BY to set
	 */
	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	/**
	 * @return the cREATED_DATE
	 */
	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}

	/**
	 * @param cREATED_DATE the cREATED_DATE to set
	 */
	public void setCREATED_DATE(Date cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}

	/**
	 * @return the mODIFIED_BY
	 */
	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	/**
	 * @param mODIFIED_BY the mODIFIED_BY to set
	 */
	public void setMODIFIED_BY(String mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	/**
	 * @return the mODIFIED_DATE
	 */
	public Date getMODIFIED_DATE() {
		return MODIFIED_DATE;
	}

	/**
	 * @param mODIFIED_DATE the mODIFIED_DATE to set
	 */
	public void setMODIFIED_DATE(Date mODIFIED_DATE) {
		MODIFIED_DATE = mODIFIED_DATE;
	}

	/**
	 * @return the jSON_VALUE
	 */
	public String getJSON_VALUE() {
		return JSON_VALUE;
	}

	/**
	 * @param jSON_VALUE the jSON_VALUE to set
	 */
	public void setJSON_VALUE(String jSON_VALUE) {
		JSON_VALUE = jSON_VALUE;
	}

	/**
	 * @return the dELETED
	 */
	public Boolean getDELETED() {
		return DELETED;
	}

	/**
	 * @param dELETED the dELETED to set
	 */
	public void setDELETED(Boolean dELETED) {
		DELETED = dELETED;
	}

	/**
	 * @return the loanNumber
	 */
	public String getLoanNumber() {
		return loanNumber;
	}

	/**
	 * @param loanNumber the loanNumber to set
	 */
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	/**
	 * @return the loanId
	 */
	public int getLoanId() {
		return loanId;
	}

	/**
	 * @param loanId the loanId to set
	 */
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	/**
	 * @return the providerTenantId
	 */
	public String getProviderTenantId() {
		return providerTenantId;
	}

	/**
	 * @param providerTenantId the providerTenantId to set
	 */
	public void setProviderTenantId(String providerTenantId) {
		this.providerTenantId = providerTenantId;
	}

	/**
	 * @return the bapId
	 */
	public String getBapId() {
		return bapId;
	}

	/**
	 * @param bapId the bapId to set
	 */
	public void setBapId(String bapId) {
		this.bapId = bapId;
	}

	/**
	 * @return the clientTenantId
	 */
	public String getClientTenantId() {
		return clientTenantId;
	}

	/**
	 * @param clientTenantId the clientTenantId to set
	 */
	public void setClientTenantId(String clientTenantId) {
		this.clientTenantId = clientTenantId;
	}

	/**
	 * @return the loanCancelledDate
	 */
	public String getLoanCancelledDate() {
		return loanCancelledDate;
	}

	/**
	 * @param loanCancelledDate the loanCancelledDate to set
	 */
	public void setLoanCancelledDate(String loanCancelledDate) {
		this.loanCancelledDate = loanCancelledDate;
	}

	/**
	 * @return the loanDeniedDate
	 */
	public String getLoanDeniedDate() {
		return loanDeniedDate;
	}

	/**
	 * @param loanDeniedDate the loanDeniedDate to set
	 */
	public void setLoanDeniedDate(String loanDeniedDate) {
		this.loanDeniedDate = loanDeniedDate;
	}

	/**
	 * @return the loanFundingDate
	 */
	public String getLoanFundingDate() {
		return loanFundingDate;
	}

	/**
	 * @param loanFundingDate the loanFundingDate to set
	 */
	public void setLoanFundingDate(String loanFundingDate) {
		this.loanFundingDate = loanFundingDate;
	}

	/**
	 * @return the loanStatusDate
	 */
	public String getLoanStatusDate() {
		return loanStatusDate;
	}

	/**
	 * @param loanStatusDate the loanStatusDate to set
	 */
	public void setLoanStatusDate(String loanStatusDate) {
		this.loanStatusDate = loanStatusDate;
	}

	/**
	 * @return the loanClosingStatusType
	 */
	public String getLoanClosingStatusType() {
		return loanClosingStatusType;
	}

	/**
	 * @param loanClosingStatusType the loanClosingStatusType to set
	 */
	public void setLoanClosingStatusType(String loanClosingStatusType) {
		this.loanClosingStatusType = loanClosingStatusType;
	}

	/**
	 * @return the loanScheduledClosingDate
	 */
	public String getLoanScheduledClosingDate() {
		return loanScheduledClosingDate;
	}

	/**
	 * @param loanScheduledClosingDate the loanScheduledClosingDate to set
	 */
	public void setLoanScheduledClosingDate(String loanScheduledClosingDate) {
		this.loanScheduledClosingDate = loanScheduledClosingDate;
	}

	@NotBlank
	@Column(name = "LoanClosingStatusType")
	private String loanClosingStatusType;

	@NotBlank
	@Column(name = "LoanScheduledClosingDate")
	private String loanScheduledClosingDate;

}
