package org.acme.workloads.Reservation;

import org.acme.model.ReservationDTO;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepo reservationRepo;

    public ReservationServiceImpl(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @Override
    public List<Reservation> getAllReservation() {
        return this.reservationRepo.getAllReservations();
    }

    @Override
    public Reservation addReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setCustomer(reservationDTO.getCustomer());
        reservation.setDate(reservationDTO.getDate());
        reservation.setEmployee(reservationDTO.getEmployee());
        reservation.setStart_time(reservationDTO.getStart_time());
        reservation.setEnd_time(reservationDTO.getEnd_time());
        reservation.setTimestamp(reservationDTO.getTimestamp());
        reservation.setPerson_amount(reservationDTO.getPerson_amount());
        this.reservationRepo.add(reservation);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setCustomer(reservationDTO.getCustomer());
        reservation.setDate(reservationDTO.getDate());
        reservation.setEmployee(reservationDTO.getEmployee());
        reservation.setStart_time(reservationDTO.getStart_time());
        reservation.setEnd_time(reservationDTO.getEnd_time());
        reservation.setTimestamp(reservationDTO.getTimestamp());
        reservation.setPerson_amount(reservationDTO.getPerson_amount());
        this.reservationRepo.update(reservation);
        return reservation;
    }

    @Override
    public Reservation deleteReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setCustomer(reservationDTO.getCustomer());
        reservation.setDate(reservationDTO.getDate());
        reservation.setEmployee(reservationDTO.getEmployee());
        reservation.setStart_time(reservationDTO.getStart_time());
        reservation.setEnd_time(reservationDTO.getEnd_time());
        reservation.setTimestamp(reservationDTO.getTimestamp());
        reservation.setPerson_amount(reservationDTO.getPerson_amount());
        this.reservationRepo.delete(reservation);
        return reservation;
    }

}