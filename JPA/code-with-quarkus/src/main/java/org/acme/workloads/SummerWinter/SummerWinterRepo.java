package org.acme.workloads.SummerWinter;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class SummerWinterRepo implements PanacheRepository<SummerWinter> {

    private final EntityManager entityManager;

    public SummerWinterRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void update(SummerWinter summerWinter) {
        this.entityManager.merge(summerWinter);
    }

}