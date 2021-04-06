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
@Table(name = "sender_hnx")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Sender implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long senderID;

	@NotBlank
	@Column(name = "first_name", nullable = false)
	private String senderFirstName;
	
	@Column(name = "middle_name")
	private String senderMiddleName;
	
	@NotBlank
	@Column(name = "last_name", nullable = false)
	private String senderLastName;
	
	@NotBlank
	@Column(name = "firm_name", nullable = false)
	private String senderFirmName;
	
	@NotBlank
	@Column(name = "phone_no", nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(name = "alt_phone_no", nullable = true )
	private String altPhonenumber;
	
	@NotBlank
	@Column(name = "email_id", nullable = false, unique = true)
	private String emailID;
	
	@Column(name = "client_index", nullable = false, unique = true)
	private String clientIndex;
	
	@Column(name = "active_shipments")
	private String activeShipments;
	
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

	public Long getSenderID() {
		return senderID;
	}

	public void setSenderID(Long senderID) {
		this.senderID = senderID;
	}

	public String getSenderFirstName() {
		return senderFirstName;
	}

	public void setSenderFirstName(String senderFirstName) {
		this.senderFirstName = senderFirstName;
	}

	public String getSenderMiddleName() {
		return senderMiddleName;
	}

	public void setSenderMiddleName(String senderMiddleName) {
		this.senderMiddleName = senderMiddleName;
	}

	public String getSenderLastName() {
		return senderLastName;
	}

	public void setSenderLastName(String senderLastName) {
		this.senderLastName = senderLastName;
	}

	public String getSenderFirmName() {
		return senderFirmName;
	}

	public void setSenderFirmName(String senderFirmName) {
		this.senderFirmName = senderFirmName;
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

	public String getClientIndex() {
		return clientIndex;
	}

	public void setClientIndex(String clientIndex) {
		this.clientIndex = clientIndex;
	}

	public String getActiveShipments() {
		return activeShipments;
	}

	public void setActiveShipments(String activeShipments) {
		this.activeShipments = activeShipments;
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
