package com.EmpReg.Exception;

import org.apache.log4j.Logger;

@SuppressWarnings("unused")
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(ResourceNotFoundException.class);
	
	private String resource;
	private String id;
	private Object idNumber;
	
	public ResourceNotFoundException(String resource, String id, Object idNumber) {
		logger.error("There was an error while trying to fetch the employee information");
		logger.error(resource + " is not found with " + id +  " '"+ idNumber +"'");
		this.resource = resource;
		this.id = id;
		this.idNumber = idNumber;
	}

}
