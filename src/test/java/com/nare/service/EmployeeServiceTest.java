package com.nare.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito.Then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nare.bean.Employee;
import com.nare.dao.IEmployeeRepository;
import com.nare.entity.EmployeeEntity;
import com.nare.exception.EmployeeNotFoundException;

@SpringBootTest
public class EmployeeServiceTest {
/*
 * where u perform testing is a inject Mock we r injecting dummy objec
*/
	@InjectMocks
	private EmployeeServiceImpl se;
	@Mock
	private IEmployeeRepository repo;
	//@Test
	public void saveTestPositive() {
		EmployeeEntity e=new EmployeeEntity();
		e.setId(100);
		e.setName("narendra");
		when(repo.save(Mockito.any(EmployeeEntity.class))).thenReturn(e);
		Employee emp=new Employee();
		BeanUtils.copyProperties(e,emp );
		EmployeeEntity entity=se.save(emp);
	assertTrue(entity!=null);
	}
	//@Test
	public void saveTestNegative() {
		EmployeeEntity e=new EmployeeEntity();
		when(repo.save(Mockito.any(EmployeeEntity.class))).thenReturn(null);
		Employee emp=new Employee();
		BeanUtils.copyProperties(e,emp );
		EmployeeEntity entity=se.save(emp);
	assertTrue(entity==null);
	}
	//@Test
	public void findAllEmpNamesTEstpositive() {
		List<String> l=new ArrayList<>();
		l.add("naren @gmail.com");
		l.add("narendasara@gmail.com");
		when(se.findAllEmpNames()).thenReturn(l);
		 List<String> list=repo.findAllEmpNames();
		 assertNotNull(list);
				
	}
	//@Test
	public void findAllEmpNamesTEstNegative() {
	
		when(se.findAllEmpNames()).thenReturn(null);
		 List<String> list=repo.findAllEmpNames();
		 assertNull(list);
				
	
	}

}
