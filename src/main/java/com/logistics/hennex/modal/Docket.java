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
@Table(name = "docket_hnx")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Docket implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long docketId;

	@Column(name = "docket_desc")
	private float docketDesc;

	@Column(name = "length")
	private float length;

	@Column(name = "breadth")
	private float breadth;

	@Column(name = "height")
	private float height;

	@Column(name = "volume")
	private float volume;

	@NotBlank
	@Column(name = "weight", nullable = false)
	private float weight;

	@NotBlank
	@Column(name = "docket_no", nullable = false)
	private String docketNo;

	@NotBlank
	@Column(name = "transit_status", nullable = true)
	private String transitStatus;

	@NotBlank
	@Column(name = "curr_location", nullable = false)
	private String location;

	@Column(name = "transit_mode", nullable = false)
	private String transitMode;

	@Column(name = "pkg_status", nullable = false)
	private String pkgStatus;

	@Column(name = "action_notes")
	private String actionNotes;

	@Column(name = "shipment_id")
	private String shipmentId;

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

	public Long getDocketId() {
		return docketId;
	}

	public void setDocketId(Long docketId) {
		this.docketId = docketId;
	}

	public float getDocketDesc() {
		return docketDesc;
	}

	public void setDocketDesc(float docketDesc) {
		this.docketDesc = docketDesc;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getBreadth() {
		return breadth;
	}

	public void setBreadth(float breadth) {
		this.breadth = breadth;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getVolume() {
		return volume;
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getDocketNo() {
		return docketNo;
	}

	public void setDocketNo(String docketNo) {
		this.docketNo = docketNo;
	}

	public String getTransitStatus() {
		return transitStatus;
	}

	public void setTransitStatus(String transitStatus) {
		this.transitStatus = transitStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTransitMode() {
		return transitMode;
	}

	public void setTransitMode(String transitMode) {
		this.transitMode = transitMode;
	}

	public String getPkgStatus() {
		return pkgStatus;
	}

	public void setPkgStatus(String pkgStatus) {
		this.pkgStatus = pkgStatus;
	}

	public String getActionNotes() {
		return actionNotes;
	}

	public void setActionNotes(String actionNotes) {
		this.actionNotes = actionNotes;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
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
