package com.gan.wcare.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gan.wcare.common.LogUtil;
import com.gan.wcare.jpa.entity.WcUsers;

public class DaoBase {
	
	public EntityManager createEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wcareEJB");
		EntityManager em = emf.createEntityManager();
		return em;
 	}
	
	public List findAll(String sql) {
		
		EntityManager em = createEntityManager();

        // read the existing entries and write to console
        Query q = em.createQuery(sql);

        List list = q.getResultList();
        for (Object object : list) {
            System.out.println(object);
        }
        LogUtil.log("Size: " + list.size());
        
        em.close();
        return list;

    }
		
	public Object findOne(String sql) {
		EntityManager em = createEntityManager();

        // read the existing entries and write to console
        Query q = em.createQuery(sql);

        Object result = q.getSingleResult();
        LogUtil.log("find One : " + result);
        
        em.close();
        return result;
    }
	
	public Object findOne(String sql, String key1, Object value1) {
		EntityManager em = createEntityManager();

        LogUtil.log("find One 1: " + key1 + " -> "  + value1 );

        // read the existing entries and write to console
        Query q = em.createQuery(sql);
        q.setParameter(key1, value1);
        
        List list= q.getResultList();
        LogUtil.log("find One 2: " + list +  " : "  + list);

        
        Object result = null;
        if (list != null && list.size()>0) {
        	result = list.get(0);
            LogUtil.log("find One 3: " + result.getClass());
        }
        LogUtil.log("find One 4: " + result);
        
        em.close();
        return result;
    }
	
	public List findAll(String sql, String key1, Object value1) {
		EntityManager em = createEntityManager();

        LogUtil.log("findAll 1: " + key1 + " -> "  + value1 );

        // read the existing entries and write to console
        Query q = em.createQuery(sql);
        q.setParameter(key1, value1);
        
        List list= q.getResultList();
        LogUtil.log("findAll 2: " + list +  " : "  + list);
        
        em.close();
        return list;
    }


	protected Object findById(Class className, int id) {
		EntityManager em = createEntityManager();
        Object result = em.find(className, id);

        LogUtil.log("find by Id : " + id + " : " + result);
        em.close();
        return result;
    }
	
	protected boolean delete(Class className, int id) {
		EntityManager em = createEntityManager();
		em.getTransaction().begin();
		Object entity = em.find(className, id);

        boolean result = false;
        if (entity != null) {
        	em.remove(entity);
        	em.getTransaction().commit();
        	result = true;
        }
        
        LogUtil.log("delete : " + id + " : " + result);
        
        em.close();
        return result;
    }
	
	
	public void save(Object entity) {
		EntityManager em = createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
    }

}
 