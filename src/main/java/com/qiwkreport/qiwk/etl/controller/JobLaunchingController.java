package com.qiwkreport.qiwk.etl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobLaunchingController {

	@Autowired
	private JobOperator jobOperator;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(JobLaunchingController.class);

	@RequestMapping(value = "qiwk/etl/{batchJobType}", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void launch(@PathVariable String batchJobType)
			throws NoSuchJobException, JobInstanceAlreadyExistsException, JobParametersInvalidException {
		LOGGER.info("FR Job Started"+System.currentTimeMillis());
		jobOperator.start(batchJobType,null);
		LOGGER.info("FR Job Finished"+System.currentTimeMillis());
	}

}
