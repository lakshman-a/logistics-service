package com.logistics.hennex.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerID;

	@NotBlank
	@Column(name = "customer_first_name", nullable = false)
	private String customerFirstName;
	
	@Column(name = "customer_middle_name")
	private String customerMiddleName;
	
	@NotBlank
	@Column(name = "customer_last_name", nullable = false)
	private String customerLastName;
	
	@NotBlank
	@Column(name = "phone_number", nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(name = "alt_phone_number", nullable = true )
	private String altPhonenumber;
	
	@NotBlank
	@Column(name = "email_id", nullable = false, unique = true)
	private String emailID;

//	@Column(name = "BillingSameAsPickUp")
//	private char billingSameAsPickUp;
//	
//	@Column(name = "BillingSameAsDelivery")
//	private char billingSameAsDelivery;	

	@NotBlank
	@Column(name = "preferred_payment_mode", nullable = false)
	private String preferredPaymentMode;
	
	@Column(name = "created_tmst", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdOn;

	//@NotBlank
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	
	@Column(name = "updated_tmst", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedOn;
	
	//@NotBlank
	@Column(name = "updated_by", nullable = false)
	private String updatedBy;
	
	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerMiddleName() {
		return customerMiddleName;
	}

	public void setCustomerMiddleName(String customerMiddleName) {
		this.customerMiddleName = customerMiddleName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAltPhonenumber() {
		return altPhonenumber;
	}

	public void setAltPhonenumber(String altPhonenumber) {
		this.altPhonenumber = altPhonenumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPreferredPaymentMode() {
		return preferredPaymentMode;
	}

	public void setPreferredPaymentMode(String preferredPaymentMode) {
		this.preferredPaymentMode = preferredPaymentMode;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}




}
