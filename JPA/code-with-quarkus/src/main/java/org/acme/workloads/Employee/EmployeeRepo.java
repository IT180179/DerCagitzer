package org.acme.workloads.Employee;

import org.acme.workloads.Drinks.Drinks;

import java.util.List;

public interface EmployeeRepo {

    List<Employee> getAllEmployee();
    void add(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
    List<Employee> getAllEmployeesByRestaurantId(Long id);

}