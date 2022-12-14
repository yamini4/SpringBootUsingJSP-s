package com.example;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class Empdao {
	HibernateTemplate temp;

	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}
	
	
	public int insert(Employee e) {
		return (Integer) temp.save(e);
	}
	
	//update and delete
	
	
	@SuppressWarnings("unchecked")
	public List<Employee> getall(){
		String sql="from Employee";
		return (List<Employee>)temp.find(sql);
	}
	//update
	public void update(Employee e) {
		temp.update(e);
	}
	
	public void delete(Employee e) {
		temp.delete(e);
	}

}
