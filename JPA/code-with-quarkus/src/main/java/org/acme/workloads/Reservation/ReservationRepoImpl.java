package org.acme.workloads.Reservation;

import org.acme.workloads.Job.Job;
import org.acme.workloads.Restaurant.Restaurant;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ReservationRepoImpl implements ReservationRepo{

    private final EntityManager entityManager;

    public ReservationRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Reservation> getAllReservations() {
        TypedQuery<Reservation> query = entityManager.createQuery("select r from Reservation r",
                Reservation.class);
        return query.getResultList();
    }

    @Override
    public List<Restaurant> getReservationById(Long id){
        TypedQuery<Restaurant> query = entityManager.createQuery("select r from Restaurant r where r.id = :id", Restaurant.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void add(Reservation reservation) {
        this.entityManager.persist(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        this.entityManager.merge(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        this.entityManager.remove(reservation);
    }

    @Override
    public List<Restaurant> getReservationByRestaurantId(Long id) {
        TypedQuery<Restaurant> query = entityManager.createQuery("select r from Restaurant r join r.reservations rr where rr.reservation_id = :id", Restaurant.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}