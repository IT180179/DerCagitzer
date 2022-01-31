package org.acme.workloads.Reservation;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepo reservationRepo;

    public ReservationServiceImpl(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @Override
    public boolean addReservation(Reservation newReservation) {

        var existingReservation = reservationRepo.getReservationbyId(newReservation.getReservation_id());

        if (existingReservation == null){
            return false;
        }
        var reservation = new Reservation();
        reservation.setReservation_id(newReservation.getReservation_id());
        reservation.setCustomer(newReservation.getCustomer());
        reservation.setDate(newReservation.getDate());
        reservation.setEnd_time(newReservation.getEnd_time());
        reservation.setStart_time(newReservation.getStart_time());
        reservation.setTable_num(newReservation.getTable_num());
        reservation.setPerson_amount(newReservation.getPerson_amount());
        reservation.setTimestamp(newReservation.getTimestamp());
        reservationRepo.addReservation(reservation);
        return true;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.getAllReservations();
    }

    @Override
    public boolean updateReservation(Reservation updateReservation) {
        if (updateReservation == null){
            return false;
        }
        reservationRepo.updateReservation(updateReservation);
        return true;
    }

    @Override
    public boolean deleteReservation(Long id) {
        if (id == null){
            return false;
        }
        reservationRepo.deleteReservation(id);
        return true;

    }
}
