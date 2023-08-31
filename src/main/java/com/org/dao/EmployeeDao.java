package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Employee;

public class EmployeeDao {
     static EntityManagerFactory emf=Persistence.createEntityManagerFactory("keshav");
     public static boolean saveEmp(Employee e) {
    	 try {
    		 EntityManager em=emf.createEntityManager();
    		 EntityTransaction et=em.getTransaction();
    		 et.begin();
    		 em.persist(e);
    		 et.commit();
    		 return true;
    	 }catch (Exception ex) {
    		 ex.printStackTrace();
    		 return false;
    	 }
     }
     
     public static List<Employee> getAllEmployees(){
    	 EntityManager em=emf.createEntityManager();
    	 Query q=em.createQuery("SELECT e FROM Employee e"); 	 
		return q.getResultList();
     }
     public static boolean updateEmployee(Employee e) {
    	try { EntityManager em=emf.createEntityManager();
    	 EntityTransaction et=em.getTransaction();
    	 et.begin();
    	 em.merge(e);
    	 et.commit();
		return true; 	 
     }catch(Exception ex) {
    	 ex.printStackTrace();
    	 return false;
     }
     }
     public static boolean deleteEmployee(int id) {
    	 EntityManager em=emf.createEntityManager();
    	 EntityTransaction et=em.getTransaction();
    	 
    	 Employee e=em.find(Employee.class, id);
    	 if(e==null) {
    		 return false;
    		 
    	 }else {
    		 et.begin();
    		 em.remove(e);
    		 et.commit();
    		 return true;
    	 }
    	 
     }
}
    	 

