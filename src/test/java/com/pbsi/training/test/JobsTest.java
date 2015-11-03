package com.pbsi.training.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.pbsi.training.entities.Employee;
import com.pbsi.training.entities.Job;
import com.pbsi.training.services.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContextTest.xml")
@WebAppConfiguration
public class JobsTest extends TestCase {

	MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private EmployeeService employeeService;
	
	

	Gson gson;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		gson = new Gson();

	}

	@Test
	public void getAllJobsTest() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(get("/getallJobs"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType("application/json;charset=UTF-8"))
				.andReturn();

		String value = mvcResult.getResponse().getContentAsString();
		Job job = gson.fromJson(value, Job.class);
		assertNotNull(job);

	}
	
	@Test
	public void getEmpByIdTest() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(post("/getEmpById").param("username", "johnsmith").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andReturn();

		String value = mvcResult.getResponse().getContentAsString();
		System.out.println(value);
		Employee employee = gson.fromJson(value, Employee.class);
		assertNotNull(employee);

	}
	

}
