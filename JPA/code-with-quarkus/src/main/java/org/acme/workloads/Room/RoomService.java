package org.acme.workloads.Room;

import org.acme.model.JobDTO;
import org.acme.model.RoomDTO;
import org.acme.workloads.Job.Job;

import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();
    List<Room> getRoomsById(Long id);
    Room addRoom(RoomDTO roomDTO);
    Room updateRoom(RoomDTO roomDTO);
    Room deleteRoom(RoomDTO roomDTO);

}