package be.mmidia.light.dao.impl;

import be.mmidia.light.dao.LightDao;
import be.mmidia.light.model.Light;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class LightDaoImpl implements LightDao {
    @Override
    public Set<Light> fetchAllLights() {
        return null;
    }

    @Override
    public Light fetchLightById(String lightId) {
        return null;
    }

    @Override
    public Set<Light> fetchLightsByState(Light.State state) {
        // Where state == state
        return null;
    }

    @Override
    public void updateLight(Light light) {

    }

    @Override
    public void batchUpdateLight(Map<String, Light> lightList) {

    }

    @Override
    public void removeLight(String lightId) {

    }

    @Override
    public String addLight(Light light) {
        return null;
    }
}
