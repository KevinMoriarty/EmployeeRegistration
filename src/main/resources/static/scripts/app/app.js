'use strict'

var employeeApp = angular.module('employee', [ 'ui.bootstrap', 'employee.controllers',
		'employee.services' ]);

employeeApp.constant("CONSTANTS", {
	getAllEmployees : "/employee/getAllEmployees",
	saveEmployee : "/employee/saveEmployee",
	getEmployeeById : "/employee/getEmployeeById/",
	updateEmployeeDetails : "/employee/updateEmployeeDetails",
	removeEmployee : "/employee/removeEmployee/"
});