package be.mmidia.light.service;

import be.mmidia.light.model.Light;
import be.mmidia.light.model.LightUsage;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

public interface LightService {
    List<Light> getAllLigths();

    Light getLightById(final long lightId) throws NotFoundException;

    void createOrUpdateLight(final Light light);

    void removeLightById(final long lightId);

    void switchOffAllLights();

    void switchGroupOfLights(final long groupId, final Light.State state);

    void switchLight(final Light light, final Light.State state);

    void switchLight(final long lightId, final Light.State state);

    List<LightUsage> getAllUsagesOfLight(final long lightId);

    List<Light> getActiveLigths();

    List<Light> getNonActiveLigths();
}
