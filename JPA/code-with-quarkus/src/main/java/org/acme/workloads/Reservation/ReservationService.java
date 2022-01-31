package org.acme.workloads.Reservation;

import org.acme.model.ReservationDTO;

import java.util.List;

public interface ReservationService {

    boolean addReservation(Reservation newReservation);
    List<Reservation> getAllReservations();
    boolean updateReservation(Reservation updateReservation);
    boolean deleteReservation(Long id);
}
