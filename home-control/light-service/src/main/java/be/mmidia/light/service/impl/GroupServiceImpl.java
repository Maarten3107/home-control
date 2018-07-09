package be.mmidia.light.service.impl;

import be.mmidia.light.dao.GroupDao;
import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import be.mmidia.light.service.GroupService;
import be.mmidia.light.service.LightsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private LightsService lightsService;

    @Override
    public Group getGroupById(String groupId) {
        return groupDao.fetchGroupById(groupId);
    }

    @Override
    public List<Group> getGroupsByLightId(String lightId) {
        return groupDao.fetchGroupsByLightId(lightId);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDao.fetchAllGroups();
    }

    @Override
    public void addGroup(Group group) {
        groupDao.addGroup(group);
    }

    @Override
    public void updateGroup(Group group) {
        groupDao.updateGroup(group);
    }

    @Override
    public void removeGroupById(String groupId) {
        groupDao.removeGroup(groupId);
    }

    @Override
    public void addLightToGroup(String lightId, String groupId) {
        Group group = groupDao.fetchGroupById(groupId);
        Light light = lightsService.getLightById(lightId);
        if (light != null) {
            //group.addMember(light);
        }
        groupDao.updateGroup(group);
    }

    @Override
    public void removeLightFromGroup(String lightId, String groupId) {
        Group group = groupDao.fetchGroupById(groupId);
        //group.removeMember(lightId);
        groupDao.updateGroup(group);
    }

    @Override
    public void switchGroupOfLigths(String groupId, Light.State state) {
        Group group = this.getGroupById(groupId);
        //group.getMembers().forEach((id, light) -> lightsService.switchLight(id, state));
        /*//groupDao.updateGroup(group);*/
    }
}