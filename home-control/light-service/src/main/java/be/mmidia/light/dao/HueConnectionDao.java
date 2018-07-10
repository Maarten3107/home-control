package be.mmidia.light.dao;

import be.mmidia.common.model.HueConnection;

public interface HueConnectionDao {
    HueConnection fetchLastConnectionForUsername(String username);

    void createConnection(HueConnection hueConnection);

    void updateConnection(HueConnection hueConnection);
}
