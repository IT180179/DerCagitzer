package org.acme.workloads.Room;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class RoomRepo implements PanacheRepository<Room> {

    private final EntityManager entityManager;

    public RoomRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void update(Room room) {
        this.entityManager.merge(room);
    }
}