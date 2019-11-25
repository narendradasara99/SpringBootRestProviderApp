package com.nare.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nare.entity.EmployeeEntity;
@Repository
@Component
public interface IEmployeeRepository  extends CrudRepository<EmployeeEntity,Integer>{
	@Query(value = "select name from EmployeeEntity")
	public List<String> findAllEmpNames();
}
