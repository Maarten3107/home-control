package be.mmidia.light.service;

import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

public interface GroupService {
    Group getGroupById(final String groupId);

    List<Group> getAllGroups();

    List<Group> getGroupsByLightId(final String lightId);

    void createOrUpdateGroup(final Group group);

    void removeGroupById(final String groupId);

    void addLightToGroup(final String lightId, final String groupId);

    void removeLightFromGroup(final String lightId, final String groupId);

    void switchGroupOfLigths(final String groupId, Light.State state);
}