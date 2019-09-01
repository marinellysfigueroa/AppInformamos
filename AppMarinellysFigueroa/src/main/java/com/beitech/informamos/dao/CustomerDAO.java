package com.beitech.informamos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.beitech.informamos.model.Customer;

public class CustomerDAO {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	public static Customer find(Integer id) {
		Customer c = new Customer();
		c = entity.find(Customer.class, id);
		JPAUtil.shutdown();
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> listAll() {
		List<Customer> listCustomers = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Customer c");
		listCustomers = q.getResultList();
		return listCustomers;
	}

	public static Customer findByEmail(String email) {
		Customer c = null;
		Query q = entity.createQuery("SELECT c FROM Customer c where email='"+email+"'");
		if(!q.getResultList().isEmpty())
		{
			c = new Customer();
			c=(Customer) q.getResultList().get(0);
		}		
		return c;
	}

	

}
