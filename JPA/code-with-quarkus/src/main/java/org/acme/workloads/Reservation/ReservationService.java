package org.acme.workloads.Reservation;

import org.acme.model.ReservationDTO;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservation();
    Reservation addReservation(ReservationDTO reservationDTO);
    Reservation updateReservation(ReservationDTO reservationDTO);
    Reservation deleteReservation(ReservationDTO reservationDTO);

}