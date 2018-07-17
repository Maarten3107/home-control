package be.mmidia.light.controller;

import be.mmidia.light.model.Room;
import be.mmidia.light.model.Light;
import be.mmidia.light.service.RoomService;
import be.mmidia.light.service.LightService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping("/")
    public List<Room> getAllrooms() {
        LOGGER.debug("Getting all rooms");
        return roomService.getAllRooms();
    }

    @RequestMapping("/{roomId}")
    public Room getRoom(@PathVariable("roomId") final long roomId) {
        LOGGER.debug("Getting room {}", roomId);
        return roomService.getRoomById(roomId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createOrUpdateRoom(@RequestBody final Room room) {
        LOGGER.debug("Adding room {}", room);
        roomService.createOrUpdateRoom(room);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{roomId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeRoom(@PathVariable("roomId") final long roomId) {
        LOGGER.debug("Removing room {}", roomId);
        roomService.removeRoomById(roomId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{roomId}/lights")
    public List<Light> getLightsForRoom(@PathVariable("roomId") final long roomId) {
        LOGGER.debug("Get lights for room {}", roomId);
        return roomService.getLightsForRoom(roomId);
    }

    @RequestMapping("/{roomId}/addLight/{lightId}")
    public ResponseEntity<?> addLight(@PathVariable("roomId") final long roomId,
                                       @PathVariable("lightId") final long lightId) {
        LOGGER.debug("Adding light {} to room {}", lightId, roomId);
        roomService.addLightToRoom(lightId, roomId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{roomId}/removeLight/{lightId}")
    public ResponseEntity<?> removeLight(@PathVariable("roomId") final long roomId,
                                          @PathVariable("lightId") final long lightId) {
        LOGGER.debug("Removing light {} from room {}", lightId, roomId);
        roomService.removeLightFromRoom(lightId, roomId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{roomId}/switch/{state}")
    public ResponseEntity<?> switchRoom(@PathVariable("roomId") final long roomId,
                                                 @PathVariable("state") final Light.State state) {
        LOGGER.debug("Switching room {} {}", roomId, state);
        roomService.switchRoom(roomId, state);
        return ResponseEntity.ok().build();
    }
}
