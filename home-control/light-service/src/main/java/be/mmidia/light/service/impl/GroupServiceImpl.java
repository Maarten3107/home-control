package be.mmidia.light.service.impl;

import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import be.mmidia.light.repository.GroupRepository;
import be.mmidia.light.service.GroupService;
import be.mmidia.light.service.LightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    /*@Autowired
    private LightService lightService;*/
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group getGroupById(String groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    @Override
    public List<Group> getGroupsByLightId(String lightId) {
        return groupRepository.findAllByLightId(lightId);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void createOrUpdateGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void removeGroupById(String groupId) {
        groupRepository.deleteById(groupId);
    }

    @Override
    public void addLightToGroup(String lightId, String groupId) {
        /*Group group = groupDao.fetchGroupById(groupId);
        Light light = lightService.getLightById(lightId);
        if (light != null) {
            //group.addMember(light);
        }
        groupDao.updateGroup(group);*/
    }

    @Override
    public void removeLightFromGroup(String lightId, String groupId) {
        /*Group group = groupDao.fetchGroupById(groupId);
        //group.removeMember(lightId);
        groupDao.updateGroup(group);*/
    }

    @Override
    public void switchGroupOfLigths(String groupId, Light.State state) {
        Group group = groupRepository.findById(groupId).orElse(null);

        /*if(group != null) {
            group.getMembers()
        }*/


        //Group group = this.getGroupById(groupId);
        //group.getMembers().forEach((id, light) -> lightService.switchLight(id, state));
        /*//groupDao.updateGroup(group);*/
    }
}