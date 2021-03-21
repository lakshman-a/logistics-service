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
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long productId;

	@NotBlank
	@Column(name = "ProductName", nullable = false)
	private String productName;

	@NotBlank
	@Column(name = "ProductCategory", nullable = false)
	private String productCategory;

	@NotBlank
	@Column(name = "Qty", nullable = false)
	private Double qty;

	@NotBlank
	@Column(name = "ProductTotalWeight", nullable = false)
	private String productTotalWeight;

	@NotBlank
	@Column(name = "GoodTransitStatus", nullable = false)
	private String goodTransitStatus;
	
	@Column(name = "TransitMode", nullable = false)
	private String transitMode;

	@Column(name = "Urgency", nullable = false)
	private String urgency;
	
	@Column(name = "ProductUniqueID", nullable = false)
	private String productUniqueID;
	
	@Column(name = "HSN", nullable = false)
	private String hsn;
	
	@Column(name = "GSTIN", nullable = false)
	private String gstin;
	
	@Column(name = "AddlNotes", nullable = false)
	private String addlNotes;
	
	@Column(name = "IndvItemAmt", nullable = false)
	private Double indvItemAmt;

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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public String getProductTotalWeight() {
		return productTotalWeight;
	}

	public void setProductTotalWeight(String productTotalWeight) {
		this.productTotalWeight = productTotalWeight;
	}

	public String getGoodTransitStatus() {
		return goodTransitStatus;
	}

	public void setGoodTransitStatus(String goodTransitStatus) {
		this.goodTransitStatus = goodTransitStatus;
	}

	public String getTransitMode() {
		return transitMode;
	}

	public void setTransitMode(String transitMode) {
		this.transitMode = transitMode;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getProductUniqueID() {
		return productUniqueID;
	}

	public void setProductUniqueID(String productUniqueID) {
		this.productUniqueID = productUniqueID;
	}

	public String getHsn() {
		return hsn;
	}

	public void setHsn(String hsn) {
		this.hsn = hsn;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getAddlNotes() {
		return addlNotes;
	}

	public void setAddlNotes(String addlNotes) {
		this.addlNotes = addlNotes;
	}

	public Double getIndvItemAmt() {
		return indvItemAmt;
	}

	public void setIndvItemAmt(Double indvItemAmt) {
		this.indvItemAmt = indvItemAmt;
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
