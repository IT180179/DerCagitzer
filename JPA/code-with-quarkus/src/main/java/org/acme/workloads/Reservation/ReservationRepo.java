package org.acme.workloads.Reservation;

import java.util.List;

public interface ReservationRepo {

    void addReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationbyId(Long id);
    void updateReservation(Reservation reservation);
    boolean deleteReservation(Long id);
}
