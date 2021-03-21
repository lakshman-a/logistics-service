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
@Table(name = "user_data")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerID")
	private Long customerID;

	@NotBlank
	@Column(name = "CustomerFirstName", nullable = false)
	private String customerFirstName;
	
	@NotBlank
	@Column(name = "CustomeLastName", nullable = false)
	private String customerLastName;
	
	@Column(name = "CustomerMiddleName")
	private String lastName;

	@NotBlank
	@Column(name = "PhoneNumber", nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(name = "AltPhonenumber")
	private String altPhonenumber;
	
	@NotBlank
	@Column(name = "EmailID", nullable = false, unique = true)
	private String emailID;

	@Column(name = "BillingSameAsPickUp")
	private char billingSameAsPickUp;
	
	@Column(name = "BillingSameAsDelivery")
	private char billingSameAsDelivery;	

	@NotBlank
	@Column(name = "PreferredPaymentMode", nullable = false)
	private String preferredPaymentMode;

	@Column(name = "created_tmst", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdOn;

	@NotBlank
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	
	@Column(name = "updated_tmst", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedOn;
	
	@NotBlank
	@Column(name = "updated_by", nullable = false)
	private String updatedBy;


}
