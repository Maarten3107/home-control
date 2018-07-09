package be.mmidia.light.dao.impl;

import be.mmidia.light.dao.ProfileDao;
import be.mmidia.light.model.Profile;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDaoImpl implements ProfileDao {
    @Override
    public List<Profile> fetchAllProfiles() {
        return null;
    }

    @Override
    public Profile fetchLightById(String profileId) {
        return null;
    }

    @Override
    public void updateProfile(Profile profile) {

    }

    @Override
    public void removeProfile(String profileId) {

    }
}
