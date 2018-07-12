package be.mmidia.light.service.impl;

import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import be.mmidia.light.repository.GroupRepository;
import be.mmidia.light.repository.LightRepository;
import be.mmidia.light.service.GroupService;
import be.mmidia.light.service.LightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    /*@Autowired
    private LightService lightService;*/

    private GroupRepository groupRepository;
    private LightRepository lightRepository;

    public GroupServiceImpl(GroupRepository groupRepository, LightRepository lightRepository) {
        this.groupRepository = groupRepository;
        this.lightRepository = lightRepository;
    }

    @Override
    public Group getGroupById(final long groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    @Override
    public List<Group> getGroupsByLightId(final long lightId) {
        //return groupRepository.findAllByLightId(lightId);
        return null;
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
    public void removeGroupById(final long groupId) {
        groupRepository.deleteById(groupId);
    }

    @Override
    public List<Light> getMembers(long groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        List<Light> lights = null;
        if(group != null) {
            lights = group.getLights();
        }
        return lights;
    }

    @Override
    public void addLightToGroup(final long lightId, final long groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        Light light = lightRepository.findById(lightId).orElse(null);
        if(group != null && light != null) {
            group.addLight(light);
            groupRepository.save(group);
            lightRepository.save(light);
        }
    }

    @Override
    public void removeLightFromGroup(final long lightId, final long groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        Light light = lightRepository.findById(lightId).orElse(null);
        if(group != null && light != null) {
            group.removeLight(light);
            groupRepository.save(group);
            lightRepository.save(light);
        }

        /*Group group = groupDao.fetchGroupById(groupId);
        //group.removeMember(lightId);
        groupDao.updateGroup(group);*/
    }

    @Override
    public void switchGroupOfLigths(final long groupId, final Light.State state) {
        Group group = groupRepository.findById(groupId).orElse(null);

        /*if(group != null) {
            group.getMembers()
        }*/


        //Group group = this.getGroupById(groupId);
        //group.getMembers().forEach((id, light) -> lightService.switchLight(id, state));
        /*//groupDao.updateGroup(group);*/
    }
}