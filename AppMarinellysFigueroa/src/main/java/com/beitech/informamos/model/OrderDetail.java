package com.beitech.informamos.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="order_detail")
public class OrderDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;
    @Basic(optional = false)
    @Column(name = "product_description")
    private String productDescription;
    @Basic(optional = false)
    private double price;
    @Basic(optional = false)
    private int quantity;
    @Transient
    @Column(name = "product_id")
    private Product productId;
    @Transient
    @Column(name = "order_id")
    private Order orderId;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDetail(Integer orderDetailId, String productDescription, double price, int quantity) {
        this.orderDetailId = orderDetailId;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
    }

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", productDescription=" + productDescription + ", price="
				+ price + ", quantity=" + quantity + ", productId=" + productId + ", orderId=" + orderId + "]";
	}
    
    
}
