package org.acme.workloads.Room;

import org.acme.workloads.Job.Job;

import java.util.List;

public interface RoomRepo {

    List<Room> getAllRooms();
    List<Room> getRoomsById(Long id);
    void add(Room room);
    void update(Room room);
    void delete(Room room);

}