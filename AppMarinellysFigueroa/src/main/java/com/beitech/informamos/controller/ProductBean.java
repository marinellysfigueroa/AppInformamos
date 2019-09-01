package com.beitech.informamos.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.beitech.informamos.dao.CustomerDAO;
import com.beitech.informamos.dao.OrderDAO;
import com.beitech.informamos.dao.OrderDetailDAO;
import com.beitech.informamos.dao.ProductDAO;
import com.beitech.informamos.model.Customer;
import com.beitech.informamos.model.Order;
import com.beitech.informamos.model.OrderDetail;
import com.beitech.informamos.model.Product;

@ManagedBean (name="product")
@RequestScoped
public class ProductBean {
	
	public List<Customer> listCustomer(){
		CustomerDAO customerDAO= new CustomerDAO();
		return customerDAO.listAll();
		
		
	}
	public List<OrderDetail> listOrderDetail(){
		OrderDetailDAO orderDetailDAO= new OrderDetailDAO();
		return orderDetailDAO.listAll();
		
		
	}
	
	
	
	/*
	public String nuevo() {
		Product c= new Product();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("product", c);
		return  "/faces/nuevo.xhtml";
	}
	
	public String guardar (Product product) {
		//guarda la fecha de registro
		Date fechaActual= new Date();
		product.setFregistro(new java.sql.Date(fechaActual.getTime()));
		
		ProductDAO productDAO= new ProductDAO();
		productDAO.guardar(product);
		return  "/faces/index.xhtml";
	}
*/
	public List<Product> obtenerProducts() {
		ProductDAO productDAO = new ProductDAO();

		/*
		 * List<Product> listaProducts = new ArrayList<>(); Product c1 = new Product();
		 * c1.setId(1L); c1.setNombres("Elivar"); c1.setApellidos("Largo");
		 * c1.setDireccion("Loja");
		 * 
		 * Product c2 = new Product(); c2.setId(1L); c2.setNombres("Elivar1");
		 * c2.setApellidos("Largo1"); c2.setDireccion("Loja1"); listaProducts.add(c1);
		 * listaProducts.add(c2);
		 * 
		 * return listaProducts;
		 */
		return productDAO.listAll();
	}
	/*
	public String editar(Long id) {
		ProductDAO productDAO = new ProductDAO();
		Product c = new Product();
		c = productDAO.buscar(id);
		System.out.println("******************************************");
		System.out.println(c);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("product", c);
		return "/faces/editar.xhtml";
	}

	public String actualizar(Product product) {
		//guarda la fecha de actualizacion
		Date fechaActual= new Date();
		product.setFactualizar(new java.sql.Date(fechaActual.getTime()));
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.editar(product);
		return "/faces/index.xhtml";
	}

	
	public String eliminar(Long id) {
		ProductDAO productDAO = new ProductDAO();
		productDAO.eliminar(id);
		System.out.println("Product eliminado..");
		return "/faces/index.xhtml";
	}
*/
}
