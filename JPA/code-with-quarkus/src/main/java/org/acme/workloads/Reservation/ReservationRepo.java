package org.acme.workloads.Reservation;

import java.util.List;

public interface ReservationRepo {


    List<Reservation> getAllReservations();
    void add(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);

}