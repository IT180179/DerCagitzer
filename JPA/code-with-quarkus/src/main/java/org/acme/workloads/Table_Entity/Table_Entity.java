package org.acme.workloads.Table_Entity;

import org.acme.workloads.Room.Room;

import javax.persistence.*;

@Entity
public class Table_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long table_num;

    @Column(nullable = false)
    private int seats;

    @ManyToOne
    private Room room_id;

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

    public Room getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Room room_id) {
        this.room_id = room_id;
    }
}