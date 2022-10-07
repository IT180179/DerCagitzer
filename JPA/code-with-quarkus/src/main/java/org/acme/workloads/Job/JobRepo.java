package org.acme.workloads.Job;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class JobRepo implements PanacheRepository<Job> {

    private final EntityManager entityManager;

    public JobRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void update(Job job) {
        this.entityManager.merge(job);
    }
}