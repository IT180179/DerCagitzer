package org.acme.workloads.Room;

import org.acme.model.RoomDTO;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RoomServiceImpl implements RoomService{

    private final RoomRepo roomRepo;

    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public List<Room> getAllRooms() {
        return this.roomRepo.getAllRooms();
    }

    @Override
    public List<Room> getRoomsById(Long id) {
        return roomRepo.getRoomsById(id);
    }

    @Override
    public Room addRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoom_name(roomDTO.getRoom_name());
        room.setSummer_winter(roomDTO.getSummer_winter());
        this.roomRepo.add(room);
        return room;
    }

    @Override
    public Room updateRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoom_name(roomDTO.getRoom_name());
        room.setSummer_winter(roomDTO.getSummer_winter());
        this.roomRepo.update(room);
        return room;
    }

    @Override
    public Room deleteRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoom_name(roomDTO.getRoom_name());
        room.setSummer_winter(roomDTO.getSummer_winter());
        this.roomRepo.delete(room);
        return room;
    }
}