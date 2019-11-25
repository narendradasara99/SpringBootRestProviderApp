package com.nare.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import com.nare.entity.EmployeeEntity;
import com.nare.service.EmployeeServiceImpl;
@WebMvcTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmployeeEntity.class)
@WebAppConfiguration
public class ControllerTest {
	@Autowired
	private Mock m;
	@MockBean
	private EmployeeServiceImpl s;
	@Autowired
	private MockMvc mvc;
	//@Test
	public void getEmployee(@PathVariable Integer id) throws Exception {
		String uri="/get/101";
		EmployeeEntity e= new EmployeeEntity();
		e.setId(109);
		e.setName("narasimha");
		when(s.getData(id)).thenReturn(e);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/get/20");
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);



	}
}
