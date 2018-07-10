package be.mmidia.light.controller;

import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import be.mmidia.light.service.GroupService;
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

    @Autowired
    private GroupService groupService;

    @RequestMapping("/")
    public List<Group> getAllGroups() {
        LOGGER.debug("Getting all groups");
        return groupService.getAllGroups();
    }

    @RequestMapping("/{groupId}")
    public Group getGroup(@PathVariable("groupId") String groupId) {
        LOGGER.debug("Getting group {}", groupId);
        return groupService.getGroupById(groupId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> addGroup(@RequestBody final Group group) {
        LOGGER.debug("Adding group {}", group);
        groupService.createOrUpdateGroup(group);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{groupId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeGroup(@PathVariable("groupId") String groupId) {
        LOGGER.debug("Removing group {}", groupId);
        groupService.removeGroupById(groupId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{groupId}/addMember")
    public ResponseEntity<?> addMember(@PathVariable("groupId") String groupId,
                                       @RequestParam String lightId) {
        LOGGER.debug("Adding member {} to group {}", lightId, groupId);
        groupService.addLightToGroup(lightId, groupId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{groupId}/removeMember")
    public ResponseEntity<?> removeMember(@PathVariable("groupId") String groupId,
                                          @RequestParam String lightId) {
        LOGGER.debug("Removing member {} from group {}", lightId, groupId);
        groupService.removeLightFromGroup(lightId, groupId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/{groupId}/switch")
    public ResponseEntity<?> switchGroupOfLigths(@PathVariable(value="groupId") String groupId,
                                      @RequestParam Light.State state) {
        LOGGER.debug("Switching group {} {}", groupId, state);
        groupService.switchGroupOfLigths(groupId, state);
        return ResponseEntity.ok().build();
    }
}
