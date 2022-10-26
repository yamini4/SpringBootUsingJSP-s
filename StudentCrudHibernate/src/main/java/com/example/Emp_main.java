package com.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Emp_main 
{
    public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
    	Employee e=ac.getBean(Employee.class);
    	Empdao dao=ac.getBean(Empdao.class);
    	//insert
    	if(dao.insert(e)>0) {
    	System.out.println("insertion done");	
    	}
    	else {
    		System.out.println("insertion failed");
    	}
    	//retrieve
    	List<Employee> list=dao.getall();
    	for(Employee e1:list) {
    		System.out.println(e1.getEid()+"  "+e1.getEname()+" "+e1.getEemail());
    	}
    	
    	//update
    	Employee e2=ac.getBean(Employee.class);
    	e2.setEid(6);
    	e2.setEemail("t@m.c");
    	e2.setEname("tamanna");
    	dao.update(e2);
    	
    	//retrieve
    	List<Employee> list1=dao.getall();
    	for(Employee e1:list1) {
    		System.out.println(e1.getEid()+"  "+e1.getEname()+" "+e1.getEemail());
    	}
    	
    	//delete
    	Employee e3=ac.getBean(Employee.class);
    	e3.setEid(7);
    	dao.delete(e3);
    	
    	//retrieve
    	List<Employee> list2=dao.getall();
    	for(Employee e1:list2) {
    		System.out.println(e1.getEid()+"  "+e1.getEname()+" "+e1.getEemail());
    	}
    }
}
