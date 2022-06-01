package org.acme.workloads.Table_Entity;

import org.acme.workloads.Job.Job;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TableEntityRepoImpl implements TableEntityRepo{

    private final EntityManager entityManager;

    public TableEntityRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<TableEntity> getAllTables() {
        TypedQuery<TableEntity> query = entityManager.createQuery("select t from TableEntity t",
                TableEntity.class);
        return query.getResultList();
    }

    @Override
    public void add(TableEntity tableEntity) {
        this.entityManager.persist(tableEntity);
    }

    @Override
    public void update(TableEntity tableEntity) {
        this.entityManager.merge(tableEntity);
    }

    @Override
    public void delete(TableEntity tableEntity) {
        this.entityManager.remove(tableEntity);
    }

    @Override
    public List<TableEntity> getAllTablesByRestaurantId(Long id) {
        TypedQuery<TableEntity> query = entityManager.createQuery("select t from TableEntity t where t.restaurant.id = :id",
                TableEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}