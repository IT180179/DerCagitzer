package org.acme.workloads.Employee;

import org.acme.model.EmployeeDTO;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllDrinks() {
        return this.employeeRepo.getAllEmployee();
    }

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirst_name(employeeDTO.getFirst_name());
        employee.setLast_name(employeeDTO.getLast_name());
        employee.setUsername(employeeDTO.getUsername());
        employee.setPassword(employeeDTO.getPassword());
        employee.setJob(employeeDTO.getJob());
        this.employeeRepo.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirst_name(employeeDTO.getFirst_name());
        employee.setLast_name(employeeDTO.getLast_name());
        employee.setUsername(employeeDTO.getUsername());
        employee.setPassword(employeeDTO.getPassword());
        employee.setJob(employeeDTO.getJob());
        this.employeeRepo.update(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirst_name(employeeDTO.getFirst_name());
        employee.setLast_name(employeeDTO.getLast_name());
        employee.setUsername(employeeDTO.getUsername());
        employee.setPassword(employeeDTO.getPassword());
        employee.setJob(employeeDTO.getJob());
        this.employeeRepo.delete(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployeesByRestaurantId(Long id) {
        return employeeRepo.getAllEmployeesByRestaurantId(id);
    }
}