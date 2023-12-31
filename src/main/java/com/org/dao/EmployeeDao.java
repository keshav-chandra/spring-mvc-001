package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
     
     public static List<Employee> getAllEmployee(){
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
     public static Employee findById(int id) {
    	 EntityManager em=emf.createEntityManager();
    	 return em.find(Employee.class, id);
     }
     
     
     @RequestMapping("/get")
     public String getEmployee(HttpSession hs) {
    	 ModelAndView mav=new ModelAndView("Display.jsp");
    	 List<Employee> emps=EmployeeDao.getAllEmployee();
    	 hs.setAttribute("emps",emps);
    	 return "display.jsp";
     }
}
    	 

