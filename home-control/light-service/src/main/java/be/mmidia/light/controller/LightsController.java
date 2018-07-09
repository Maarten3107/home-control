package be.mmidia.light.controller;

import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import be.mmidia.light.model.LightUsage;
import be.mmidia.light.service.GroupService;
import be.mmidia.light.service.LightsService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/light")
public class LightsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LightsController.class);

    @Autowired
    private LightsService lightsService;
    @Autowired
    private GroupService groupService;

    @RequestMapping("/")
    public Set<Light> getAllLights() {
        LOGGER.debug("Getting all lights");
        return lightsService.getAllLigths();
    }

    @RequestMapping("/{lightId}")
    public Light getLight(@PathVariable String lightId) {
        LOGGER.debug("Getting light {}", lightId);
        return lightsService.getLightById(lightId);
    }

    @RequestMapping("/{lightId}/getGroups")
    public List<Group> getMemberships(@PathVariable("lightId") String lightId) {
        LOGGER.debug("Getting groups for light {}", lightId);
        return groupService.getGroupsByLightId(lightId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> addLight(@RequestBody Light light) {
        LOGGER.debug("Adding light {}", light);
        lightsService.addLight(light);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{lightId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeLight(@PathVariable(value="lightId") String lightId){
        LOGGER.debug("Removing light {}", lightId);
        lightsService.removeLightById(lightId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{lightId}/switch")
    public ResponseEntity<?> switchLight(@PathVariable(value="lightId") String lightId,
                                         @RequestParam Light.State state) {
        LOGGER.debug("Switching light {} {}", lightId, state);
        lightsService.switchLight(lightId, state);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/switchAll")
    public ResponseEntity<?> switchOffAllLights() {
        LOGGER.debug("Switching of all lights");
        lightsService.switchOffAllLights();
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{lightId}/usage")
    public Set<LightUsage> getUsageOfLight(@PathVariable("lightId") String lightId) {
        LOGGER.debug("Getting all usages of {}", lightId);
        return lightsService.getAllUsagesOfLight(lightId);
    }

    @RequestMapping("/Activity")
    public Set<Light> getActiveLights() {
        LOGGER.debug("Getting all active lights");
        return lightsService.getActiveLigths();
    }
}
