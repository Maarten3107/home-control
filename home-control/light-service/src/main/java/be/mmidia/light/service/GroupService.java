package be.mmidia.light.service;

import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import java.util.List;
import org.springframework.stereotype.Service;

public interface GroupService {
    Group getGroupById(final String groupId);

    List<Group> getAllGroups();

    List<Group> getGroupsByLightId(final String lightId);

    void addGroup(final Group group);

    void updateGroup(final Group group);

    void removeGroupById(final String groupId);

    void addLightToGroup(final String lightId, final String groupId);

    void removeLightFromGroup(final String lightId, final String groupId);

    void switchGroupOfLigths(final String groupId, Light.State state);
}