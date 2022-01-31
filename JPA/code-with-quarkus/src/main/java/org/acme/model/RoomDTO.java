package org.acme.model;

import java.io.Serializable;
import java.util.Objects;

public class RoomDTO implements Serializable {
    private final Long room_id;
    private final String room_name;
    private final String summer_winter;

    public RoomDTO(Long room_id, String room_name, String summer_winter) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.summer_winter = summer_winter;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public String getSummer_winter() {
        return summer_winter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDTO entity = (RoomDTO) o;
        return Objects.equals(this.room_id, entity.room_id) &&
                Objects.equals(this.room_name, entity.room_name) &&
                Objects.equals(this.summer_winter, entity.summer_winter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_id, room_name, summer_winter);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "room_id = " + room_id + ", " +
                "room_name = " + room_name + ", " +
                "summer_winter = " + summer_winter + ")";
    }
}
