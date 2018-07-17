package be.mmidia.light.service.impl;

import be.mmidia.light.model.Room;
import be.mmidia.light.model.Light;
import be.mmidia.light.repository.RoomRepository;
import be.mmidia.light.repository.LightRepository;
import be.mmidia.light.service.LightService;
import be.mmidia.light.service.RoomService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private LightRepository lightRepository;
    private LightService lightService;

    public RoomServiceImpl(final RoomRepository roomRepository, final LightRepository lightRepository, final LightService lightService) {
        this.roomRepository = roomRepository;
        this.lightRepository = lightRepository;
        this.lightService = lightService;
    }

    @Override
    public Room getRoomById(final long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void createOrUpdateRoom(final Room room) {
        roomRepository.save(room);
    }

    @Override
    public void removeRoomById(final long roomId) {
        roomRepository.deleteById(roomId);
    }

    @Override
    public List<Light> getLightsForRoom(final long roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        return room != null ? room.getLights() : null;
    }

    @Override
    public void addLightToRoom(final long lightId, final long roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        Light light = lightRepository.findById(lightId).orElse(null);
        if(room != null && light != null) {
            room.getLights().add(light);
            roomRepository.save(room);
        }
    }

    @Override
    public void removeLightFromRoom(final long lightId, final long roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        Light light = lightRepository.findById(lightId).orElse(null);
        if(room != null && light != null) {
            room.getLights().remove(light);
            roomRepository.save(room);
        }
    }

    @Override
    public void switchRoom(final long roomId, final Light.State state) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room != null) {
            room.getLights().forEach(light -> lightService.switchLight(light, state));
        }
    }
}