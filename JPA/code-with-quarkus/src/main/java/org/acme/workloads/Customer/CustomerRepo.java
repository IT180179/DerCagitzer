package org.acme.workloads.Customer;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class CustomerRepo implements PanacheRepository<Customer> {

    private final EntityManager entityManager;

    public CustomerRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void update(Customer customer) {
        this.entityManager.merge(customer);
    }
}