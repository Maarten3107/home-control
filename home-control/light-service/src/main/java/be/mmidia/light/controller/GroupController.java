package be.mmidia.light.controller;

import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import be.mmidia.light.service.GroupService;
import be.mmidia.light.service.LightService;
import java.util.List;
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
@RequestMapping("/group")
public class GroupController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

    private GroupService groupService;
    private LightService lightService;

    public GroupController(GroupService groupService, LightService lightService) {
        this.groupService = groupService;
        this.lightService = lightService;
    }

    @RequestMapping("/")
    public List<Group> getAllGroups() {
        LOGGER.debug("Getting all groups");
        return groupService.getAllGroups();
    }

    @RequestMapping("/{groupId}")
    public Group getGroup(@PathVariable("groupId") final long groupId) {
        LOGGER.debug("Getting group {}", groupId);
        return groupService.getGroupById(groupId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createOrUpdateGroup(@RequestBody final Group group) {
        LOGGER.debug("Adding group {}", group);
        groupService.createOrUpdateGroup(group);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{groupId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeGroup(@PathVariable("groupId") final long groupId) {
        LOGGER.debug("Removing group {}", groupId);
        groupService.removeGroupById(groupId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{groupId}/addMember/{lightId}")
    public ResponseEntity<?> addMember(@PathVariable("groupId") final long groupId,
                                       @PathVariable("lightId") final long lightId) {
        LOGGER.debug("Adding member {} to group {}", lightId, groupId);
        groupService.addLightToGroup(lightId, groupId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{groupId}/removeMember/{lightId}")
    public ResponseEntity<?> removeMember(@PathVariable("groupId") final long groupId,
                                          @PathVariable("lightId") final long lightId) {
        LOGGER.debug("Removing member {} from group {}", lightId, groupId);
        groupService.removeLightFromGroup(lightId, groupId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{groupId}/switch/{state}")
    public ResponseEntity<?> switchGroupOfLigths(@PathVariable("groupId") final long groupId,
                                                 @PathVariable("state") final Light.State state) {
        LOGGER.debug("Switching group {} {}", groupId, state);
        //groupService.switchGroupOfLigths(groupId, state);
        lightService.switchGroupOfLights(groupId, state);
        return ResponseEntity.ok().build();
    }
}
