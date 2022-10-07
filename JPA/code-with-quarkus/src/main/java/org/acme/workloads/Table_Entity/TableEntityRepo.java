package org.acme.workloads.Table_Entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TableEntityRepo implements PanacheRepository<TableEntity> {

    private final EntityManager entityManager;

    public TableEntityRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void update(TableEntity tableEntity) {
        this.entityManager.merge(tableEntity);
    }
}