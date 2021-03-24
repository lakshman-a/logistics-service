package com.logistics.hennex.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.logistics.hennex.enums.OrderIDFormat;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_data")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Orders implements Serializable {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id", unique = true)
	private String orderID;

	@Column(name = "order_desc", nullable = false)
	private String orderDesc;
	
	//@NotBlank
	@Column(name = "order_status")
	private String orderStatus;

	//@NotNull
	@Column(name = "total_order_amt", nullable = false)
	private Double totalOrderAmt;
	
	//@NotNull
	@Column(name = "addl_charges", nullable = false)
	private Double addlCharges;

	//@NotNull
	@Column(name = "final_amt", nullable = false)
	private Double finalAmt;
	
	//@NotNull
	@Column(name = "paid_during_order", nullable = false)
	private Double paidDuringOrder;
	
	//@NotNull
	@Column(name = "balance_payment", nullable = false)
	private Double balancePayment;
	
	//@NotBlank
	@Column(name = "payment_status", nullable = false)
	private String paymentStatus;

	@Column(name = "created_tmst", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdOn;

	//@NotBlank
	@Column(name = "created_by", nullable = false, updatable = false)
	private String createdBy;
	
	@Column(name = "updated_tmst", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedOn;
	
	//@NotBlank
	@Column(name = "updated_by", nullable = false)
	private String updatedBy;
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	//@JsonIgnore
	//@JsonManagedReference
	private List<Product> product=new ArrayList<Product>();
	
	public List<Product> getProducts() {
		return product;
	}

	public void setProducts(List<Product> products) {
		this.product = products;

        for(Product b : products) {
            b.setOrder(this);
        }
		//this.products = products;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		if(orderID.startsWith("HNX")) {
			this.orderID = orderID;
		}else {
		String orderIDPrefix = "";
		if(this.getCreatedBy().startsWith("ADMIN")) {
			orderIDPrefix = OrderIDFormat.ADMIN.getValue();
		}else {
			orderIDPrefix = OrderIDFormat.CUSTOMER.getValue();
		}
		this.orderID = orderIDPrefix+orderID;
		}
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
