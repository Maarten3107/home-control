package be.mmidia.light.service;

import be.mmidia.light.model.Profile;
import java.util.List;

public interface ProfileService {
    String addProfile(Profile profile);

    String updateProfile(Profile profile);

    void removeProfile(String profileId);

    Profile getProfileById(String profileId);

    List<Profile> getAllProfiles();

    String activateProfile(String profileId);
}
