package com.EmpReg.Controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmpReg.Converters.EmployeeConverter;
import com.EmpReg.DTOs.EmployeeDto;
import com.EmpReg.Entities.Employee;
import com.EmpReg.Exception.ResourceNotFoundException;
import com.EmpReg.Repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeDBController {
	
	final static Logger logger = Logger.getLogger(EmployeeDBController.class);
	
	@Autowired
	EmployeeRepository empRepository;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	@PostMapping(value = "/saveEmployee")
	public Employee createEmployee(@RequestBody EmployeeDto empDto) {
		logger.debug("Employee DTO information: " + empDto.getAge() + " " + empDto.getLastName() + " " + empDto.getEmail() + " " + empDto.getGender());
		Employee employee = EmployeeConverter.dtoToEntity(empDto);
		return empRepository.save(employee);
	}

	@GetMapping("/getEmployeeById/{id}")
	public Employee getNoteById(@PathVariable(value = "id") Long empId) {
		return empRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Emp Id", empId));
	}

	@PutMapping("/updateEmployeeDetails/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long empId, @RequestBody Employee empDetails) {

		Employee employee = empRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "emp id", empId));

		employee.setFirstName(empDetails.getFirstName());
		employee.setLastName(empDetails.getLastName());
		employee.setAge(empDetails.getAge());
		employee.setGender(empDetails.getGender());
		employee.setEmail(empDetails.getEmail());

		Employee updatedEmployee = empRepository.save(employee);
		logger.info("Employee details updated to DB successfully");
		return updatedEmployee;
	}

	@DeleteMapping("/removeEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long empId) {
		Employee employee = empRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "emp id", empId));

		empRepository.delete(employee);
		
		logger.info("Employee object deleted from DB successfully");

		return String.format("Employee with employee id - %s has been successfull deleted", empId);
	}

}
