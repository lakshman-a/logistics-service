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
import java.util.Currency;
import java.util.Date;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID", unique = true)
	private String orderID;

	@Column(name = "OrderDesc", nullable = false)
	private String orderDesc;
	
	@NotBlank
	@Column(name = "OrderStatus")
	private String orderStatus;

	@NotBlank
	@Column(name = "TotalOrderAmt", nullable = false)
	private Double totalOrderAmt;

	@Column(name = "AddlCharges", nullable = false)
	private Double addlCharges;

	@NotBlank
	@Column(name = "FinalAmt", nullable = false)
	private Double finalAmt;
	
	@NotBlank
	@Column(name = "PaidDuringOrder", nullable = false)
	private Double paidDuringOrder;
	
	@NotBlank
	@Column(name = "BalancePayment", nullable = false)
	private Double balancePayment;
	
	@NotBlank
	@Column(name = "PaymentStatus", nullable = false)
	private String paymentStatus;

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

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getTotalOrderAmt() {
		return totalOrderAmt;
	}

	public void setTotalOrderAmt(Double totalOrderAmt) {
		this.totalOrderAmt = totalOrderAmt;
	}

	public Double getAddlCharges() {
		return addlCharges;
	}

	public void setAddlCharges(Double addlCharges) {
		this.addlCharges = addlCharges;
	}

	public Double getFinalAmt() {
		return finalAmt;
	}

	public void setFinalAmt(Double finalAmt) {
		this.finalAmt = finalAmt;
	}

	public Double getPaidDuringOrder() {
		return paidDuringOrder;
	}

	public void setPaidDuringOrder(Double paidDuringOrder) {
		this.paidDuringOrder = paidDuringOrder;
	}

	public Double getBalancePayment() {
		return balancePayment;
	}

	public void setBalancePayment(Double balancePayment) {
		this.balancePayment = balancePayment;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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
