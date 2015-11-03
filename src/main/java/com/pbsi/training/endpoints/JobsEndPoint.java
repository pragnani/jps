package com.pbsi.training.endpoints;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.pbsi.training.entities.Job;
import com.pbsi.training.generated.GetAllJobsResponse;
import com.pbsi.training.services.EmployeeService;

@Endpoint
public class JobsEndPoint {

	private static final String NAMESPACE_URI = "http://www.javaspringtutorial.com/ws/jobs";

	@Autowired
	EmployeeService employeeService;

	// private ObjectFactory OBJ_FACTORY = new ObjectFactory();

	// @PayloadRoot(localPart="getAllJobsRequest" ,namespace=NAMESPACE_URI)
	// @ResponsePayload
	// public Element getAllJobsRequest() throws RuntimeException
	// {
	// List<Job> jobsList=employeeService.findAllJobs();
	//
	// Element mainElement=new Element("getAllJobsResponse");
	// for(int i=0;i<jobsList.size();i++)
	// {
	// Job job=jobsList.get(i);
	// Element jobElement=new Element("job");
	// jobElement.addContent(new Element("id").addContent(job.getId()+""));
	// jobElement.addContent(new
	// Element("jobTitle").addContent(job.getJobTitle()));
	// jobElement.addContent(new
	// Element("jobDescription").addContent(job.getJobDescription()));
	// jobElement.addContent(new
	// Element("postedBy").addContent(job.getPostedBy()));
	// mainElement.addContent(jobElement);
	// }
	// return mainElement;
	// }

	@PayloadRoot(localPart = "getAllJobsRequest", namespace = NAMESPACE_URI)
	@ResponsePayload
	public GetAllJobsResponse getAllJobsRequest()
			throws RuntimeException {

		List<Job> jobsList = employeeService.findAllJobs();
		GetAllJobsResponse response = new GetAllJobsResponse();
		for (Job job : jobsList) {
			com.pbsi.training.generated.Job job1 = new com.pbsi.training.generated.Job();
			job1.setId(BigInteger.valueOf(job.getId()));
			job1.setJobDescription(job.getJobDescription());
			job1.setJobTitle(job.getJobTitle());
			job1.setJobTitle(job.getJobTitle());
			response.getJob().add(job1);
		}

		
		return response;
	}

}
