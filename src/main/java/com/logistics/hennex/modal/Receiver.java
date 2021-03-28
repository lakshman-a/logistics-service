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
@Table(name = "receiver_hnx")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt","deliveryAddress" }, allowGetters = true)

public class Receiver implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long receiverID;

	@NotBlank
	@Column(name = "first_name", nullable = false)
	private String receiverFirstName;
	
	@Column(name = "middle_name")
	private String receiverMiddleName;
	
	@NotBlank
	@Column(name = "last_name", nullable = false)
	private String receiverLastName;
	
	@NotBlank
	@Column(name = "firm_name")
	private String receiverFirmName;
	
	@NotBlank
	@Column(name = "phone_no", nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(name = "alt_phone_no")
	private String altPhonenumber;
	
	@NotBlank
	@Column(name = "email_id", nullable = false, unique = true)
	private String emailID;

	@Column(name = "address_id", nullable = false)
	private long addressId;
	
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

	public Long getReceiverID() {
		return receiverID;
	}

	public String getReceiverFirstName() {
		return receiverFirstName;
	}

	public String getReceiverMiddleName() {
		return receiverMiddleName;
	}

	public String getReceiverLastName() {
		return receiverLastName;
	}

	public String getReceiverFirmName() {
		return receiverFirmName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAltPhonenumber() {
		return altPhonenumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public long getAddressId() {
		return addressId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setReceiverID(Long receiverID) {
		this.receiverID = receiverID;
	}

	public void setReceiverFirstName(String receiverFirstName) {
		this.receiverFirstName = receiverFirstName;
	}

	public void setReceiverMiddleName(String receiverMiddleName) {
		this.receiverMiddleName = receiverMiddleName;
	}

	public void setReceiverLastName(String receiverLastName) {
		this.receiverLastName = receiverLastName;
	}

	public void setReceiverFirmName(String receiverFirmName) {
		this.receiverFirmName = receiverFirmName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAltPhonenumber(String altPhonenumber) {
		this.altPhonenumber = altPhonenumber;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	}
