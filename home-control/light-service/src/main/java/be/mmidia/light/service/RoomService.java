package be.mmidia.light.service;

import be.mmidia.light.model.Room;
import be.mmidia.light.model.Light;
import java.util.List;

public interface RoomService {
    Room getRoomById(final long groupId);

    List<Room> getAllRooms();

    void createOrUpdateRoom(final Room room);

    void removeRoomById(final long groupId);

    List<Light> getLightsForRoom(final long groupId);

    void addLightToRoom(final long lightId, final long groupId);

    void removeLightFromRoom(final long lightId, final long groupId);

    void switchRoom(final long groupId, Light.State state);
}