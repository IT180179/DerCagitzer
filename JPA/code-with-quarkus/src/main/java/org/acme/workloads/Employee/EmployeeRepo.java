package org.acme.workloads.Employee;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class EmployeeRepo implements PanacheRepository<Employee> {

    private final EntityManager entityManager;

    public EmployeeRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void update(Employee employee) {
        this.entityManager.merge(employee);
    }
}