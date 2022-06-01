package org.acme.workloads.Reservation;

import org.acme.workloads.Job.Job;
import org.acme.workloads.Restaurant.Restaurant;

import java.util.List;

public interface ReservationRepo {


    List<Reservation> getAllReservations();
    void add(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);
    List<Restaurant> getReservationByRestaurantId(Long id);
    List<Restaurant> getReservationById(Long id);

}