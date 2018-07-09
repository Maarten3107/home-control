package be.mmidia.light.dao;

import be.mmidia.light.model.Profile;
import java.util.List;
import org.springframework.stereotype.Repository;

public interface ProfileDao {
    List<Profile> fetchAllProfiles();

    Profile fetchLightById(String profileId);

    void updateProfile(Profile profile);

    void removeProfile(String profileId);
}
