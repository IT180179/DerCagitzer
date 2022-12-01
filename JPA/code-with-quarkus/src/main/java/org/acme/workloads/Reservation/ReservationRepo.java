package org.acme.workloads.Reservation;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ReservationRepo implements PanacheRepository<Reservation> {

    private final EntityManager entityManager;

    public ReservationRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void update(Reservation reservation) {
        this.entityManager.merge(reservation);
    }

    public List<Reservation> getByDate(String date) {
        Query query = this.entityManager.createQuery("select r from Reservation r where r.reservation_date = :date", Reservation.class).setParameter("date", date);
        return query.getResultList();
    }

    public Long countReservationsPerRoomNoon(String date, Long room_id) {
        Query query1 = this.entityManager.createQuery("select count(r) from Reservation r where r.tableEntity.room.room_id = :room_id and r.reservation_date = :date and r.start_time = '11:00' or r.start_time = '13:00'", Long.class)
                .setParameter("date", date)
                .setParameter("room_id", room_id);
        Query query2 = this.entityManager.createQuery("select count(t) from TableEntity t where t.room.room_id = :room_id", Long.class)
                .setParameter("room_id", room_id);
        Long reservations = (Long) query1.getSingleResult();
        Long tables = (Long) query2.getSingleResult();
        return reservations;
    }

    public Long countReservationsPerRoomEvening(String date, Long room_id) {
        Query query1 = this.entityManager.createQuery("select count(r) from Reservation r where r.tableEntity.room.room_id = :room_id and r.reservation_date = :date and r.end_time = '19:00' or r.end_time = '21:00'", Long.class)
                .setParameter("date", date)
                .setParameter("room_id", room_id);
        Query query2 = this.entityManager.createQuery("select count(t) from TableEntity t where t.room.room_id = :room_id", Long.class)
                .setParameter("room_id", room_id);
        Long reservations = (Long) query1.getSingleResult();
        Long tables = (Long) query2.getSingleResult();
        return reservations;
    }

    public Long countReservationsPerTimeslot(String start_time, String end_time, String date) {
        Query query = this.entityManager.createQuery("select count(r) from Reservation r where r.reservation_date = :date and r.start_time = :start_time and r.end_time = :end_time", Long.class)
                .setParameter("date", date)
                .setParameter("start_time", start_time)
                .setParameter("end_time", end_time);
        return (Long) query.getSingleResult();
    }

    public Long countReservationsPerDay(String date) {
        Query query = this.entityManager.createQuery("select count(r) from Reservation r where r.reservation_date = :date", Long.class)
                .setParameter("date", date);
        return (Long) query.getSingleResult();
    }

    public Long countPersonsPerDay(String date) {
        Query query = this.entityManager.createQuery("select sum(r.person_amount) from Reservation r where r.reservation_date = :date", Long.class)
                .setParameter("date", date);
        return (Long) query.getSingleResult();
    }
}