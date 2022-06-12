package org.acme.workloads.Room;

import org.acme.workloads.Job.Job;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class RoomRepoImpl implements RoomRepo{

    private final EntityManager entityManager;

    public RoomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Room> getAllRooms() {
        TypedQuery<Room> query = entityManager.createQuery("select r from Room r",
                Room.class);
        return query.getResultList();
    }
    @Override
    public List<Room> getRoomsById(Long id){
        TypedQuery<Room> query = entityManager.createQuery("select r from Room r where r.room_id = :id", Room.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void add(Room room) {
        this.entityManager.persist(room);
    }

    @Override
    public void update(Room room) {
        this.entityManager.merge(room);
    }

    @Override
    public void delete(Room room) {
        this.entityManager.remove(room);
    }
}