package org.acme.workloads.Job;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class JobRepoImpl implements JobRepo{

    private final EntityManager entityManager;

    public JobRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Job> getAllJobs() {
        TypedQuery<Job> query = entityManager.createQuery("select j from Job j",
                Job.class);
        return query.getResultList();
    }

    @Override
    public void add(Job job) {
        this.entityManager.persist(job);
    }

    @Override
    public void update(Job job) {
        this.entityManager.merge(job);
    }

    @Override
    public void delete(Job job) {
        this.entityManager.remove(job);
    }
}