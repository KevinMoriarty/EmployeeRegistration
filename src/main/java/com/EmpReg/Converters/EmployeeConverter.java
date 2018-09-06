package com.EmpReg.Converters;

import org.apache.log4j.Logger;

import com.EmpReg.Controllers.EmployeeDBController;
import com.EmpReg.DTOs.EmployeeDto;
import com.EmpReg.Entities.Employee;

public class EmployeeConverter {
	
	final static Logger logger = Logger.getLogger(EmployeeConverter.class);
	
	
	public static Employee dtoToEntity(EmployeeDto empDto) {
		logger.info(empDto);
		Employee employee = new Employee(empDto.getFirstName(), empDto.getLastName(), empDto.getAge(),
				empDto.getEmail(), empDto.getGender());
		return employee;

	}

	public static EmployeeDto entityToDto(Employee employee) {

		EmployeeDto employeeDto = new EmployeeDto(employee.getFirstName(), employee.getLastName(), employee.getAge(),
				employee.getEmail(), employee.getGender());
		return employeeDto;

	}

}
