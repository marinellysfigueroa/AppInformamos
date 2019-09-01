package com.beitech.informamos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.beitech.informamos.model.Product;

public class ProductDAO {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	
	public void save(Product product) {
		entity.getTransaction().begin();
		entity.persist(product);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}

	
	public void edit(Product product) {
		entity.getTransaction().begin();
		entity.merge(product);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}

	
	public Product find(Long id) {
		Product p = new Product();
		p = entity.find(Product.class, id);
		JPAUtil.shutdown();
		return p;
	}

	public void delete(Long id) {
		Product p = new Product();
		p = entity.find(Product.class, id);
		entity.getTransaction().begin();
		entity.remove(p);
		entity.getTransaction().commit();
	}

	
	@SuppressWarnings("unchecked")
	public List<Product> listAll() {
		List<Product> listProducts = new ArrayList<>();
		Query q = entity.createQuery("SELECT p FROM Product p where ");
		listProducts = q.getResultList();
		return listProducts;
	}


	@SuppressWarnings("unchecked")
	public static List<Product> findByCliente(Integer customerId) {
		List<Product> listProducts = new ArrayList<>();
		
		
		Query q = entity.createQuery("SELECT p FROM CustomerProduct cp, Product p where cp.productId=p.productId and cp.customerId="+customerId);
		
		listProducts = q.getResultList();
		return listProducts;
	}

}
