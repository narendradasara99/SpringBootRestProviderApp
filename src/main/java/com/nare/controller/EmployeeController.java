package com.nare.controller;



import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nare.bean.Employee;
import com.nare.entity.EmployeeEntity;
import com.nare.exception.EmployeeNotFoundException;
import com.nare.exception.ErrorHanlingClass;
import com.nare.service.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@Api(value="employee details",description="this is sendind data to employee controller ")
public class EmployeeController {
	public EmployeeController() {
		System.out.println("rest controller");	}
	@Autowired
private IEmployeeService s;
	@ApiResponses(value = {

	        @ApiResponse(code = 200, message = "Successfully retrieved added"),

	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),

	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),

	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")

	}

	)
@ApiOperation(value="this is used to add the details of employee")
@GetMapping(value="/added/{id}/{name}")
	@ApiParam("send id and name")

public String  add(@PathVariable Integer id,@PathVariable String name){
	System.out.println("add method");
	String msg=s.save(id, name);
	return msg;
	}
@ApiOperation(value="this is used toget the details of employee")
@GetMapping(value="/get/{id}",produces= {"application/json"})
public Employee g(@PathVariable Integer id) throws EmployeeNotFoundException{
	Employee m=s.get(id);
	return m;
}
@GetMapping(value="/insert",produces= {"application/json"})
public Employee addEmpby() {
	Employee e=new Employee();
	e.setId(100);
	e.setName("nare");
	String s="employee added Succesfully";
	return e;
	
}
@PostMapping(value="/add",consumes= {"application/json"})
public ResponseEntity <String> addEmp(@RequestBody Employee e) {
	String msg="employee added Succesfully";
	s.save(e);
	return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	
}
@GetMapping(
	value="getemp/{id}",
	produces= {"application/json"}
)
public Employee getEmployee(@PathVariable Integer id) {
	EmployeeEntity e=s.getData(id);
	Employee emp= new Employee();
	BeanUtils.copyProperties(e,emp);
	return emp;
}
@GetMapping(
		value="getname",
		produces= {"application/json"}
	)
public List<String> getName() {
	List<String> e=s.findAllEmpNames();
	
	return e;
}
@ExceptionHandler(value = EmployeeNotFoundException.class)
public ResponseEntity<ErrorHanlingClass> handleCustomerNotFoundException() {
	ErrorHanlingClass e=new ErrorHanlingClass(400,"employye id  not found");
	return new ResponseEntity<ErrorHanlingClass>(e,HttpStatus.BAD_REQUEST);

}
}
