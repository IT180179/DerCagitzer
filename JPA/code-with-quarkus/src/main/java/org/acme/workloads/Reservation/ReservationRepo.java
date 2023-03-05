package org.acme.workloads.Reservation;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import net.bytebuddy.asm.Advice;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class ReservationRepo implements PanacheRepository<Reservation> {

    private final EntityManager entityManager;

    public ReservationRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void update(Reservation reservation) {
        this.entityManager.merge(reservation);
    }

    public Long getMaxId() {
        Query query = this.entityManager.createQuery("select max(r.reservation_id) from Reservation r");
        return (Long) query.getSingleResult();
    }

    public Boolean checkReservation(String date, Long table, String start_time, String end_time) {
        String[] startArray = start_time.split(":");
        String[] endArray = end_time.split(":");
        int startMinutes = Integer.parseInt(startArray[1]);
        int endMinutes = Integer.parseInt(endArray[1]);
        int endHours = Integer.parseInt(endArray[0]);
        if(Objects.equals(endArray[1], "00")) {
            endMinutes = 60;
        }
        if(Objects.equals(endArray[1], "00")) {
            endHours = endHours - 1;
        }
        Query query = this.getEntityManager().createQuery("select r from Reservation r where r.reservation_date = :date and r.tableEntity.tableno = :table and (:start_time between r.start_time and r.end_time or :end_time between r.start_time and r.end_time)")
                .setParameter("date", date)
                .setParameter("table", table)
                .setParameter("start_time", String.valueOf(startArray[0] + ":" + (startMinutes + 1)))
                .setParameter("end_time", String.valueOf(endHours + ":" + (endMinutes - 1)));
        if(query.getResultStream().findAny().isPresent()) {
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkReservationUpdate(Long id, String date, Long table, String start_time, String end_time) {
        String[] startArray = start_time.split(":");
        String[] endArray = end_time.split(":");
        int startMinutes = Integer.parseInt(startArray[1]);
        int endMinutes = Integer.parseInt(endArray[1]);
        int endHours = Integer.parseInt(endArray[0]);
        if(Objects.equals(endArray[1], "00")) {
            endMinutes = 60;
        }
        if(Objects.equals(endArray[1], "00")) {
            endHours = endHours - 1;
        }
        Query query = this.getEntityManager().createQuery("select r from Reservation r where r.reservation_id <> :id and r.reservation_date = :date and r.tableEntity.tableno = :table and (:start_time between r.start_time and r.end_time or :end_time between r.start_time and r.end_time)")
                .setParameter("id", id)
                .setParameter("date", date)
                .setParameter("table", table)
                .setParameter("start_time", String.valueOf(startArray[0] + ":" + (startMinutes + 1)))
                .setParameter("end_time", String.valueOf(endHours + ":" + (endMinutes - 1)));
        if(query.getResultStream().findAny().isPresent()) {
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
        Query query1 = this.entityManager.createQuery("select sum(r.person_amount) from Reservation r where r.reservation_date = :date and (r.start_time = '11:00' or r.start_time = '13:00')", Long.class)
                .setParameter("date", date);
        if(query1.getSingleResult() == null) {
            return 0L;
        }
        return (Long) query1.getSingleResult();
    }

    public Long countReservationsPerDayEvening(String date) {
        Query query1 = this.entityManager.createQuery("select sum(r.person_amount) from Reservation r where r.reservation_date = :date and (r.end_time = '19:00' or r.end_time = '21:00')", Long.class)
                .setParameter("date", date);
        if(query1.getSingleResult() == null) {
            return 0L;
        }
        return (Long) query1.getSingleResult();
    }

    public Long countReservationsPerWeek(String start_date, String end_date) {
        Query query1 = this.entityManager.createQuery("select sum(r.person_amount) from Reservation r where r.reservation_date between :start_date and :end_date", Long.class)
                .setParameter("start_date", start_date)
                .setParameter("end_date", end_date);
        if(query1.getSingleResult() == null) {
            return 0L;
        }
        return (Long) query1.getSingleResult();
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