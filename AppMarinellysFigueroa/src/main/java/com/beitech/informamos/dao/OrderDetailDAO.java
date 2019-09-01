package com.beitech.informamos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.beitech.informamos.model.OrderDetail;

public class OrderDetailDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	
	public void save(OrderDetail OrderDetail) {
		entity.getTransaction().begin();
		entity.persist(OrderDetail);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}

	
	public void edit(OrderDetail OrderDetail) {
		entity.getTransaction().begin();
		entity.merge(OrderDetail);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}

	
	public OrderDetail find(Long id) {
		OrderDetail od = new OrderDetail();
		od = entity.find(OrderDetail.class, id);
		JPAUtil.shutdown();
		return od;
	}

	public void delete(Long id) {
		OrderDetail od = new OrderDetail();
		od = entity.find(OrderDetail.class, id);
		entity.getTransaction().begin();
		entity.remove(od);
		entity.getTransaction().commit();
	}

	
	@SuppressWarnings("unchecked")
	public List<OrderDetail> listAll() {
		List<OrderDetail> listOrderDetails = new ArrayList<>();
		Query q = entity.createQuery("SELECT od FROM OrderDetail od");
		listOrderDetails = q.getResultList();
		return listOrderDetails;
	}

}
