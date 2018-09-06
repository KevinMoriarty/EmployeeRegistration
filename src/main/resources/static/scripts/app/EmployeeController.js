'use strict'

var module = angular.module('employee.controllers', []);

module.controller("EmployeeController", [
		"$scope",
		"EmployeeService",
		function($scope, EmployeeService) {
			
			$scope.employeeDto = {
				empId : null,
				firstName : null,
				lastName : null,
				age : null,
				gender : null,
				email : null
			}

			$scope.saveEmployee = function() {
				EmployeeService.saveEmployee($scope.employeeDto).then(
						function() {
							console.log("Employee Saved Successfully");
							EmployeeService.getAllEmployees().then(
									function(value) {
										$scope.allEmployees = value.data;
									}, function(reason) {
										console.log("There was an error");
									}, function(value) {
										console.log("no callback");
									});
						})
			}

			$scope.getEmployeeById = function() {
				EmployeeService.getEmployeeById($scope.employeeDto.empId).then(function(value) {
					$scope.employeeData = value.data;
					console.log(value.data);
				}, function(reason) {
					console.log("There was an error. Resource was not found with mentioned Id");
				}, function(value) {
					console.log("no callback");
				});
			}
			
			$scope.removeEmployee = function() {
				EmployeeService.removeEmployee($scope.employeeDto.empId).then(function(value) {
					$scope.response = value
					console.log(value);
				}, function(reason) {
					console.log("There was an error while deleting the employee");
				}, function(value) {
					console.log("no call back");
				});
			}

		}])
