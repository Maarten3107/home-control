package be.mmidia.light.dao;

import be.mmidia.light.model.Light;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;

public interface LightDao {
    Set<Light> fetchAllLights();

    Light fetchLightById(String lightId);

    Set<Light> fetchLightsByState(Light.State state);

    void updateLight(Light light);

    void batchUpdateLight(Map<String, Light> lightList);

    void removeLight(String lightId);

    String addLight(Light light);
}
