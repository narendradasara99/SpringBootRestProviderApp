package com.nare.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nare.bean.Employee;
import com.nare.dao.IEmployeeRepository;
import com.nare.entity.EmployeeEntity;
import com.nare.exception.EmployeeNotFoundException;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private Employee e;
	@Autowired
	private IEmployeeRepository emp;
	
	Map<Integer,Employee> m=new HashMap();
	public Object save;

	public String save(Integer i,String s) {
		System.out.println("save");
		if (!m.containsKey(i)) {
		e.setId(i);
		e.setName(s);
		m.put(i,e);
		}else
		{
			return "employee already added";
		}
		return " employee added succces fully";
	}

	@Override
	public Employee get(Integer i) throws EmployeeNotFoundException {
		if(m.containsKey(i)) {
		Employee e=m.get(i);
		return e;
		} else {
			throw new EmployeeNotFoundException("Employee not found");
		}
	}

	@Override
	public EmployeeEntity save(Employee e) {
		EmployeeEntity e1=new EmployeeEntity();
		BeanUtils.copyProperties(e,e1);
		//BeanUtils.copyProperties(source, target);
		  EmployeeEntity entity=emp.save(e1);
		  if(entity==null) {
			  return null;
		  }
		return entity;
	}

	@Override
	public EmployeeEntity getData(Integer i) {
		// TODO Auto-generated method stub
	Optional<EmployeeEntity> o=emp.findById(i);
	if(o.isPresent()) {
		return o.get();
	}else {
		throw new EmployeeNotFoundException();
	}
	}

	@Override
	public List<String> findAllEmpNames() {
		List<String> e= emp.findAllEmpNames();
		if(e==null) {
			return null;
		}
		return e;
	}
	
	

}
