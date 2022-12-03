package org.acme.workloads.Table_Entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TableEntityRepo implements PanacheRepository<TableEntity> {

    private final EntityManager entityManager;

    public TableEntityRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<TableEntity> getTablesPerRoom(Long room_id) {
        Query query = this.entityManager.createQuery("select t from TableEntity t where t.room.room_id = :room_id", TableEntity.class)
                .setParameter("room_id", room_id);
        return query.getResultList();
    }

    public void update(TableEntity tableEntity) {
        this.entityManager.merge(tableEntity);
    }
}