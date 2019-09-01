package com.beitech.informamos.controller;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.beitech.informamos.dao.CustomerDAO;
import com.beitech.informamos.dao.OrderDAO;
import com.beitech.informamos.dao.ProductDAO;
import com.beitech.informamos.model.Customer;
import com.beitech.informamos.model.Order;
import com.beitech.informamos.model.Product;

@ManagedBean(name = "customerBean")
@RequestScoped
public class CustomerBean {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@SuppressWarnings("unused")
	public String validateClient() {
		Customer c = (Customer) CustomerDAO.findByEmail(email);
		List<Order> orderList = OrderDAO.findByCliente(c.getCustomerId());
		List<Product> productList = ProductDAO.findByCliente(c.getCustomerId());

		c.setOrderList(orderList);
		c.setProductList(productList);
		if (c != null) {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("customer", c);
			return "index";

		} else {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
			return "login";
		}
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
	}
}
