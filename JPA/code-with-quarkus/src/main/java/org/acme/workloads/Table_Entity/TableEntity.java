package org.acme.workloads.Table_Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.acme.workloads.Reservation.Reservation;
import org.acme.workloads.Room.Room;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TableEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableno;

    @Column(nullable = false)
    private int seats;



    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "tableEntity", orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getTableno() {
        return tableno;
    }

    public void setTableno(Long table_num) {
        this.tableno = table_num;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}