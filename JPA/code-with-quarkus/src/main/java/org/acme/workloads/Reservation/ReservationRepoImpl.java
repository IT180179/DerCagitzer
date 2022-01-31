package org.acme.workloads.Reservation;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ReservationRepoImpl implements ReservationRepo {
    private final EntityManager entityManager;

    public ReservationRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addReservation(Reservation reservation) {
        entityManager.persist(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        var query = entityManager.createQuery("select r from Reservation r", Reservation.class);
        return query.getResultStream().collect(Collectors.toList());
    }

    @Override
    public Reservation getReservationbyId(Long id) {
        var query = entityManager.createQuery("select r from Reservation r where r.reservation_id = :id", Reservation.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void updateReservation(Reservation reservation) {

    }

    @Override
    public boolean deleteReservation(Long id) {

        var query = entityManager.createQuery("delete from Reservation r where r.reservation_id = :id", Reservation.class);
        query.setParameter("id", id);
        int a = query.executeUpdate();
        return a == 1;
    }
}
