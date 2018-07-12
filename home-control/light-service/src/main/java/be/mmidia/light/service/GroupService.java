package be.mmidia.light.service;

import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

public interface GroupService {
    Group getGroupById(final long groupId);

    List<Group> getAllGroups();

    List<Group> getGroupsByLightId(final long lightId);

    void createOrUpdateGroup(final Group group);

    void removeGroupById(final long groupId);

    List<Light> getMembers(final long groupId);

    void addLightToGroup(final long lightId, final long groupId);

    void removeLightFromGroup(final long lightId, final long groupId);

    void switchGroupOfLigths(final long groupId, Light.State state);
}