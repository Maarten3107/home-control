package be.mmidia.light.service.impl;

import be.mmidia.light.dao.LightDao;
import be.mmidia.light.dao.LightUsageDao;
import be.mmidia.light.model.Light;
import be.mmidia.light.model.LightUsage;
import be.mmidia.light.service.LightsService;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightServiceImpl implements LightsService{
    @Autowired
    private LightDao lightDao;
    @Autowired
    private LightUsageDao lightUsageDao;

    @Override
    public Set<Light> getAllLigths() {
        return lightDao.fetchAllLights();
    }

    @Override
    public Light getLightById(final String lightId) {
        return lightDao.fetchLightById(lightId);
    }

    @Override
    public void addLight(final Light light) {
        lightDao.addLight(light);
    }

    @Override
    public void updateLight(final Light light) {
        lightDao.updateLight(light);
    }

    @Override
    public void removeLightById(final String lightId) {
        lightDao.removeLight(lightId);
    }

    @Override
    public void switchOffAllLights() {
        Map<String, Light> lights = lightDao.fetchAllLights().stream().collect(Collectors.toMap(Light::getId, e -> e));
        lights.forEach((lightId, light) -> switchLight(light, Light.State.OFF));
    }

    @Override
    public void switchLight(final String lightId, final Light.State state) {
        if (lightId != null && state != null) {
            Light light = lightDao.fetchLightById(lightId);
            switchLight(light, state);
        }
    }

    @Override
    public void switchLight(final Light light, final Light.State state) {
        if(light.getState() != state) {
            startStopUsage(light, state);
        }
    }

    @Override
    public Set<LightUsage> getAllUsagesOfLight(final String lightId) {
        return lightUsageDao.getUsagesByLightId(lightId);
    }

    @Override
    public Set<Light> getActiveLigths() {
        return lightDao.fetchLightsByState();
    }

    private void startStopUsage(final Light light, final Light.State state) {
        if(state == Light.State.ON) {
            LightUsage lightUsage = lightUsageDao.getUsageByLightUsageId(light.getLastUsage());
            lightUsage.setEndTime(DateTime.now());
            lightUsageDao.updateUsage(lightUsage);
        } else if (state == Light.State.OFF) {
            LightUsage lightUsage = new LightUsage(light.getId());
            lightUsageDao.createUsage(lightUsage);
            light.setLastUsage(lightUsage.getId());
        }

        light.setState(state);
        lightDao.updateLight(light);
    }
}
