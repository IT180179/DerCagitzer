package org.acme.model;

import org.acme.workloads.Reservation.Reservation;
import org.acme.workloads.Room.Room;

import java.io.Serializable;
import java.util.Objects;

public class TableEntityDTO implements Serializable {
    private final Long table_num;
    private final int seats;
    private final Room room;
    private final Reservation reservation;

    public TableEntityDTO(Long table_num, int seats, Room room, Reservation reservation) {
        this.table_num = table_num;
        this.seats = seats;
        this.room = room;
        this.reservation = reservation;
    }

    public Long getTable_num() {
        return table_num;
    }

    public int getSeats() {
        return seats;
    }

    public Room getRoom() {
        return room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableEntityDTO entity = (TableEntityDTO) o;
        return Objects.equals(this.table_num, entity.table_num) &&
                Objects.equals(this.seats, entity.seats) &&
                Objects.equals(this.room, entity.room) &&
                Objects.equals(this.reservation, entity.reservation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table_num, seats, room, reservation);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "table_num = " + table_num + ", " +
                "seats = " + seats + ", " +
                "room = " + room + ", " +
                "reservation = " + reservation + ")";
    }
}
