package com.beitech.informamos.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.beitech.informamos.model.Order;

public class OrderDAO {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	
	public void save(Order Order1) {
		entity.getTransaction().begin();
		entity.persist(Order1);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}

	
	public void edit(Order Order1) {
		entity.getTransaction().begin();
		entity.merge(Order1);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}

	
	public Order find(Long id) {
		Order o = new Order();
		o = entity.find(Order.class, id);
		JPAUtil.shutdown();
		return o;
	}

	public void delete(Long id) {
		Order o = new Order();
		o = entity.find(Order.class, id);
		entity.getTransaction().begin();
		entity.remove(o);
		entity.getTransaction().commit();
	}

	
	


	@SuppressWarnings("unchecked")
	public static  List<Order> findByCliente(Integer customer_id) {
		List<Order> listOrders = new ArrayList<>();
		Query q = entity.createNativeQuery("select order_id, \n" + 
				"creation_date, delivery_address, \n" + 
				"total from `order` where customer_id='"+customer_id+"'");
		
		for (Object obj : q.getResultList()) {
            Object[] object = (Object[]) obj;
            Order o = new Order();
            o.setOrderId(Integer.valueOf(object[0].toString()));
            o.setCreationDateString(object[1].toString());
            o.setDeliveryAddress(object[2].toString());
            o.setTotal(Double.parseDouble(object[3].toString()));
            listOrders.add(o);
        }
		
		
		return listOrders;
	}
	
	

}
