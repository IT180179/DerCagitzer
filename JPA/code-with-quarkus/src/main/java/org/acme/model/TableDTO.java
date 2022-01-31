package org.acme.model;

import java.io.Serializable;
import java.util.Objects;

public class TableDTO implements Serializable {
    private final Long table_num;
    private final int seats;
    private final RoomDTO room_id;

    public TableDTO(Long table_num, int seats, RoomDTO room_id) {
        this.table_num = table_num;
        this.seats = seats;
        this.room_id = room_id;
    }

    public Long getTable_num() {
        return table_num;
    }

    public int getSeats() {
        return seats;
    }

    public RoomDTO getRoom_id() {
        return room_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableDTO entity = (TableDTO) o;
        return Objects.equals(this.table_num, entity.table_num) &&
                Objects.equals(this.seats, entity.seats) &&
                Objects.equals(this.room_id, entity.room_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table_num, seats, room_id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "table_num = " + table_num + ", " +
                "seats = " + seats + ", " +
                "room_id = " + room_id + ")";
    }
}
