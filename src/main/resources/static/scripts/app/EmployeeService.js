'use strict'

angular.module('employee.services', []).factory('EmployeeService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    
	var service = {};
    
	service.getAllEmployees = function(){
		var url = CONSTANTS.getAllEmployees;
		return $http.get(url);
	}
	
	service.saveEmployee = function(employeeDto){
		console.log(employeeDto.firstName);
		console.log(employeeDto.lastName);
		console.log(employeeDto.age);
		console.log(employeeDto.gender);
		console.log(employeeDto.email);
		return $http.post(CONSTANTS.saveEmployee, employeeDto);
	}
	
	service.getEmployeeById = function(empId) {
        var url = CONSTANTS.getEmployeeById + empId;
        return $http.get(url);
    }
   
	service.updateEmployeeDetails = function(empId, employeeDto) {
        return $http.put(CONSTANTS.updateEmployeeDetails, empId, employeeDto);
    }
    
	service.removeEmployee = function(empId) {
		var url = CONSTANTS.removeEmployee + empId;
        return $http.delete(url);
    }
    
	return service;
}]);