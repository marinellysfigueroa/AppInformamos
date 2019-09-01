package com.beitech.informamos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "order_id")
	private Integer orderId;
	@Basic(optional = false)
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	@Basic(optional = false)
	@Transient
	@Column(name = "creation_date")
	private String creationDateString;
	@Column(name = "delivery_address")
	private String deliveryAddress;
	@Basic(optional = false)
	@Column(name = "total")
	private double total;
	@Transient
	private List<OrderDetail> orderDetailList;
	@Transient
	@Column(name = "customer_id")
	private Customer customerId;

	public Order() {
	}

	public Order(Integer orderId) {
		this.orderId = orderId;
	}

	public Order(Integer orderId, Date creationDate, String deliveryAddress, double total) {
		this.orderId = orderId;
		this.creationDate = creationDate;
		this.deliveryAddress = deliveryAddress;
		this.total = total;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public String getCreationDateString() {
		return creationDateString;
	}

	public void setCreationDateString(String creationDateString) {
		this.creationDateString = creationDateString;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", creationDate=" + creationDate + ", creationDateString="
				+ creationDateString + ", deliveryAddress=" + deliveryAddress + ", total=" + total
				+ ", orderDetailList=" + orderDetailList + ", customerId=" + customerId + "]";
	}

}
