package be.mmidia.light.dao.impl;

import be.mmidia.common.model.HueConnection;
import be.mmidia.light.dao.HueConnectionDao;
import org.springframework.stereotype.Repository;

@Repository
public class HueConnectionDaoImpl implements HueConnectionDao {
    @Override
    public HueConnection fetchLastConnectionForUsername(final String username) {
        return new HueConnection();
    }

    @Override
    public void createConnection(final HueConnection hueConnection) {

    }

    @Override
    public void updateConnection(final HueConnection hueConnection) {

    }
}
