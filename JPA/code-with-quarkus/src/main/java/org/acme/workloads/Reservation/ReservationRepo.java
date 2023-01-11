package org.acme.workloads.Reservation;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import net.bytebuddy.asm.Advice;

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

    public Boolean checkReservation(String date, Long table, String start_time, String end_time) {
        Query query = this.getEntityManager().createQuery("select r from Reservation r where r.reservation_date = :date and r.tableEntity.tableno = :table and r.start_time between :start_time and :end_time or r.end_time between :start_time and :end_time")
                .setParameter("date", date)
                .setParameter("table", table)
                .setParameter("start_time", start_time)
                .setParameter("end_time", end_time);
        if(query.getResultStream().count() > 0) {
            return true;
        }else{
            return false;
        }
    }

    public List<Reservation> getByDate(String date) {
        Query query = this.entityManager.createQuery("select r from Reservation r where r.reservation_date = :date", Reservation.class).setParameter("date", date);
        return query.getResultList();
    }

    public Long countReservationsPerDayNoon(String date) {
        Query query1 = this.entityManager.createQuery("select sum(r.person_amount) from Reservation r where r.reservation_date = :date and r.start_time = '11:00' or r.start_time = '13:00'", Long.class)
                .setParameter("date", date);
        Long reservations = (Long) query1.getSingleResult();
        return reservations;
    }

    public Long countReservationsPerDayEvening(String date) {
        Query query1 = this.entityManager.createQuery("select sum(r.person_amount) from Reservation r where r.reservation_date = :date and r.end_time = '19:00' or r.end_time = '21:00'", Long.class)
                .setParameter("date", date);
        Long reservations = (Long) query1.getSingleResult();
        return reservations;
    }

    public Long countReservationsPerWeek(String start_date, String end_date) {
        Query query1 = this.entityManager.createQuery("select sum(r.person_amount) from Reservation r where r.reservation_date between :start_date and :end_date", Long.class)
                .setParameter("start_date", start_date)
                .setParameter("end_date", end_date);
        Long reservations = (Long) query1.getSingleResult();
        if(reservations == null) {
            return 1L;
        }
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