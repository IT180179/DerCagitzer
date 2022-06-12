package org.acme.workloads.Employee;

import org.acme.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllDrinks();
    Employee addEmployee(EmployeeDTO employeeDTO);
    Employee updateEmployee(EmployeeDTO employeeDTO);
    Employee deleteEmployee(EmployeeDTO employeeDTO);
    List<Employee> getAllEmployeesByRestaurantId(Long id);

}