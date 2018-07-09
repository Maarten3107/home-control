package be.mmidia.light.dao;

import be.mmidia.light.model.HueConnection;

public interface HueConnectionDao {
    void createConnection(HueConnection hueConnection);

    void updateConnection(HueConnection hueConnection);
}
