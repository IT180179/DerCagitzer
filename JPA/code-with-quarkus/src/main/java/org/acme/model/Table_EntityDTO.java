package org.acme.model;

import java.io.Serializable;
import java.util.Objects;

public class Table_EntityDTO implements Serializable {
    private final Long table_num;
    private final int seats;
    private final RoomDTO room;
    private final ReservationDTO reservation;

    public Table_EntityDTO(Long table_num, int seats, RoomDTO room, ReservationDTO reservation) {
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

    public RoomDTO getRoom() {
        return room;
    }

    public ReservationDTO getReservation() {
        return reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table_EntityDTO entity = (Table_EntityDTO) o;
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
