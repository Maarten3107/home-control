package be.mmidia.light.controller;

import be.mmidia.light.model.Room;
import be.mmidia.light.model.Light;
import be.mmidia.light.model.LightUsage;
import be.mmidia.light.service.RoomService;
import be.mmidia.light.service.LightService;
import java.util.List;
import javassist.NotFoundException;
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
@RequestMapping("/light")
public class LightsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LightsController.class);

    private LightService lightService;

    public LightsController(LightService lightService) {
        this.lightService = lightService;
    }

    @RequestMapping("/")
    public List<Light> getAllLights() {
        LOGGER.debug("Getting all lights");
        return lightService.getAllLigths();
    }

    @RequestMapping("/{lightId}")
    public Light getLight(@PathVariable("lightId") final long lightId) throws NotFoundException {
        LOGGER.debug("Getting light {}", lightId);
        return lightService.getLightById(lightId);
    }

    /*@RequestMapping("/{lightId}/getGroup")
    public List<Room> getRoom(@PathVariable("lightId") final long lightId) {
        LOGGER.debug("Getting room for light {}", lightId);
        return roomService.getRoomsByLightId(lightId);
    }*/

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createOrUpdateLight(@RequestBody final Light light) {
        LOGGER.debug("Adding or updating light {}", light);
        lightService.createOrUpdateLight(light);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{lightId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeLight(@PathVariable("lightId") final long lightId){
        LOGGER.debug("Removing light {}", lightId);
        lightService.removeLightById(lightId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{lightId}/switch/{state}")
    public ResponseEntity<?> switchLight(@PathVariable("lightId") final long lightId,
                                         @PathVariable("state") Light.State state) {
        LOGGER.debug("Switching light {} {}", lightId, state);
        lightService.switchLight(lightId, state);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/switchAll")
    public ResponseEntity<?> switchOffAllLights() {
        LOGGER.debug("Switching of all lights");
        lightService.switchOffAllLights();
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{lightId}/usage")
    public List<LightUsage> getUsageOfLight(@PathVariable("lightId") final long lightId) {
        LOGGER.debug("Getting all usages of {}", lightId);
        return lightService.getAllUsagesOfLight(lightId);
    }

    @RequestMapping("/activity")
    public List<Light> getActiveLights() {
        LOGGER.debug("Getting all active lights");
        return lightService.getActiveLigths();
    }
}
