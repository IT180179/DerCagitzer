package org.acme.workloads.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class CustomerRepoImpl implements CustomerRepo {

    private final EntityManager entityManager;

    public CustomerRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c",
                Customer.class);
        return query.getResultList();
    }

    @Override
    public void add(Customer customer) {
        this.entityManager.persist(customer);
    }

    @Override
    public void update(Customer customer) {
        this.entityManager.merge(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.entityManager.remove(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.customer_id = :id", Customer.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }
}