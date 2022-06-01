package org.acme.workloads.Employee;

import org.acme.workloads.Drinks.Drinks;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class EmployeeRepoImpl implements EmployeeRepo{

    private final EntityManager entityManager;

    public EmployeeRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployee() {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e",
                Employee.class);
        return query.getResultList();
    }

    @Override
    public void add(Employee employee) {
        this.entityManager.persist(employee);
    }

    @Override
    public void update(Employee employee) {
        this.entityManager.merge(employee);
    }

    @Override
    public void delete(Employee employee) {
        this.entityManager.remove(employee);
    }

    @Override
    public List<Employee> getAllEmployeesByRestaurantId(Long id) {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.restaurant.id = :id",
                Employee.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}