package org.acme.workloads.Table_Entity;

import org.acme.workloads.Reservation.Reservation;
import org.acme.workloads.Room.Room;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;

@Entity
public class Table_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long table_num;

    @Column(nullable = false)
    private int seats;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getTable_num() {
        return table_num;
    }

    public void setTable_num(Long table_num) {
        this.table_num = table_num;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}