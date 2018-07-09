package be.mmidia.light.service;

import be.mmidia.light.model.Light;
import be.mmidia.light.model.LightUsage;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;

public interface LightsService {
    Set<Light> getAllLigths();

    Light getLightById(final String lightId);

    void updateLight(final Light light);

    void addLight(final Light light);

    void removeLightById(final String lightId);

    void switchOffAllLights();

    void switchLight(final Light light, final Light.State state);

    void switchLight(final String lightId, final Light.State state);

    Set<LightUsage> getAllUsagesOfLight(final String lightId);

    Set<Light> getActiveLigths();
}