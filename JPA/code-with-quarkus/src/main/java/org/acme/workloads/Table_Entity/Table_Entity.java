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
    @JoinColumn(name = "room_id")
    private Room room;

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