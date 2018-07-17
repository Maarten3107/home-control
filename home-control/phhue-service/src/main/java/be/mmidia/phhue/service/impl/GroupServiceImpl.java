package be.mmidia.phhue.service.impl;

import be.mmidia.phhue.model.GroupDto;
import be.mmidia.phhue.service.GroupService;
import java.util.List;

public class GroupServiceImpl implements GroupService {

    @Override
    // /api/<username>/groups (GET)
    public List<GroupDto> getAllGroups() {
        return null;
    }

    @Override
    // /api/<username>/groups (POST)
    public void createGroup(GroupDto group) {

    }

    @Override
    // /api/<username>/groups/<id> (GET)
    public GroupDto getGroupAttributes(long groupId) {
        return null;
    }

    @Override
    // /api/<username>/groups/<id> (PUT)
    public void setGroupAttributes(GroupDto group) {

    }

    @Override
    // /api/<username>/groups/<id>/action (PUT)
    public void setGroupState(GroupDto group) {

    }

    @Override
    // /api/<username>/groups/<id> (DELETE)
    public void deleteGroup(long groupId) {

    }
}
