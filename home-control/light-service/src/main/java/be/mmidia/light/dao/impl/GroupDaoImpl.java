package be.mmidia.light.dao.impl;

import be.mmidia.light.dao.GroupDao;
import be.mmidia.light.model.Group;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl implements GroupDao {
    @Override
    public Set<Group> fetchAllGroups() {
        return null;
    }

    @Override
    public Group fetchGroupById(String groupId) {
        return null;
    }

    @Override
    public Set<Group> fetchGroupsByLightId(String lightId) {
        return null;
    }

    @Override
    public void addGroup(Group group) {

    }

    @Override
    public void updateGroup(Group group) {

    }

    @Override
    public void removeGroup(String groupId) {

    }
}
