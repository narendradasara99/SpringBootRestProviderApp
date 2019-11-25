package com.nare.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nare.bean.Employee;
import com.nare.entity.EmployeeEntity;
import com.nare.exception.EmployeeNotFoundException;
@Service
public interface IEmployeeService {
	public String  save(Integer i, String s);
	public  Employee get(Integer i) throws EmployeeNotFoundException;
	public EmployeeEntity save(Employee e);
	public  EmployeeEntity getData(Integer i);
	public List<String> findAllEmpNames();
}
