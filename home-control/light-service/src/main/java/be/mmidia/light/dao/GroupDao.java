package be.mmidia.light.dao;

import be.mmidia.light.model.Group;
import java.util.Set;

public interface GroupDao {
    Set<Group> fetchAllGroups();

    Group fetchGroupById(String groupId);

    Set<Group> fetchGroupsByLightId(String lightId);

    void addGroup(Group group);

    void updateGroup(Group group);

    void removeGroup(String groupId);
}
