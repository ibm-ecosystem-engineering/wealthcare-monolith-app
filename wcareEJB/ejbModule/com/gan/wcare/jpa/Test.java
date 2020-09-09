package com.gan.wcare.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gan.wcare.jpa.entity.WcUsers;

public class Test {
	 
	public static void main(String[] args) {
 
		//test2();
		test5();
		test4();
	}
	
	public static void test2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wcareEJB");
		EntityManager em = emf.createEntityManager();
		WcUsers wcUsers = em.find(WcUsers.class, 1);
		System.out.println("User after removal :- " + wcUsers);
 
	}
	public static void test4() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wcareEJB");
		EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select a FROM WcUsers a");

        List<WcUsers> list = q.getResultList();
        for (WcUsers object : list) {
            System.out.println(object);
        }
        System.out.println("Size: " + list.size());

    }
	public static void test5() {
        System.out.println("test5 completed -----: ");

	}

}