package com.logistics.hennex.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.logistics.hennex.enums.OrderIDFormat;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "shipment_hnx")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Shipment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String shipmentId;

	@Column(name = "shipment_desc")
	private String shipmentDesc;
	@NotBlank	
	@Column(name = "invoice_no", nullable = false)
	private String invoiceNo;
	@NotNull	
	@Column(name = "invoice_amt", nullable = false)
	private float invoiceAmt;
	@NotBlank	
	@Column(name = "invoice_date", nullable = false)
	private String invoiceDate;
	
	@Column(name = "package_type")
	private String packageType;
	
	@Column(name = "material_type", nullable = false)
	private String materialType;
	
	@Column(name = "awb_no")
	private String awbNo;
	
	@Column(name = "spl_instrxn")
	private String splInstrxn;
	
	@Column(name = "docket_qty", nullable = false)
	private long docketQty;
	
	@Column(name = "total_weight", nullable = false)
	private float totalWeight;
	
	@Column(name = "total_volume")
	private float totalVolume;
	
	@Column(name = "shipment_status", nullable = false)
	private String shipmentStatus;
	
	@Column(name = "docket_ids")
	private String docketIDs;
	
	@Column(name = "sender_id", nullable = false)
	private long senderID;
	
	@Column(name = "pk_up_addr_id", nullable = false)
	private long pkUpAddrId;
	
	@Column(name = "receiver_id", nullable = false)
	private long receiverId;
	
	@Column(name = "del_addr_id", nullable = false)
	private long delAddrId;
	
	@Column(name = "created_tmst", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdOn;

	// @NotBlank
	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "updated_tmst", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedOn;

	// @NotBlank
	@Column(name = "updated_by", nullable = false)
	private String updatedBy;

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		if (shipmentId.startsWith("HNX")) {
			this.shipmentId = shipmentId;
		} else {
			String shipmentIdPrefix = "";
			if (this.getCreatedBy().startsWith("ADMIN")) {
				shipmentIdPrefix = OrderIDFormat.ADMIN.getValue();
			} else {
				shipmentIdPrefix = OrderIDFormat.CUSTOMER.getValue();
			}
			this.shipmentId = shipmentIdPrefix + shipmentId;
		}
	}

	public String getShipmentDesc() {
		return shipmentDesc;
	}

	public void setShipmentDesc(String shipmentDesc) {
		this.shipmentDesc = shipmentDesc;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public float getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(float invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getAwbNo() {
		return awbNo;
	}

	public void setAwbNo(String awbNo) {
		this.awbNo = awbNo;
	}

	public String getSplInstrxn() {
		return splInstrxn;
	}

	public void setSplInstrxn(String splInstrxn) {
		this.splInstrxn = splInstrxn;
	}

	public long getDocketQty() {
		return docketQty;
	}

	public void setDocketQty(long docketQty) {
		this.docketQty = docketQty;
	}

	public float getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(float totalWeight) {
		this.totalWeight = totalWeight;
	}

	public float getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(float totalVolume) {
		this.totalVolume = totalVolume;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getDocketIDs() {
		return docketIDs;
	}

	public void setDocketIDs(String docketIDs) {
		this.docketIDs = docketIDs;
	}

	public long getSenderID() {
		return senderID;
	}

	public void setSenderID(long senderID) {
		this.senderID = senderID;
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

	public long getPkUpAddrId() {
		return pkUpAddrId;
	}

	public void setPkUpAddrId(long pkUpAddrId) {
		this.pkUpAddrId = pkUpAddrId;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public long getDelAddrId() {
		return delAddrId;
	}

	public void setDelAddrId(long delAddrId) {
		this.delAddrId = delAddrId;
	}

}
