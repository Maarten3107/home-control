package be.mmidia.phhue.service;

import be.mmidia.phhue.model.GroupDto;
import java.util.List;

public interface GroupService {
    List<GroupDto> getAllGroups();

    void createGroup(final GroupDto group);

    GroupDto getGroupAttributes(final long groupId);

    void setGroupAttributes(final GroupDto group);

    void setGroupState(final GroupDto group);

    void deleteGroup(final long groupId);
}
