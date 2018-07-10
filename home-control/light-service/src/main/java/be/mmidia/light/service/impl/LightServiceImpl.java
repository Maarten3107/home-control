package be.mmidia.light.service.impl;

import be.mmidia.light.dao.LightDao;
import be.mmidia.light.dao.LightUsageDao;
import be.mmidia.light.model.Light;
import be.mmidia.light.model.LightUsage;
import be.mmidia.light.service.LightService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.text.html.Option;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightServiceImpl implements LightService {
    @Autowired
    private LightDao lightDao;
    @Autowired
    private LightUsageDao lightUsageDao;

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Light> getAllLigths() {
        return lightDao.findAll();
    }

    @Override
    public Light getLightById(final String lightId) {
        return lightDao.getOne(lightId);
    }

    @Override
    public void addLight(final Light light) {
        lightDao.save(light);
        //lightDao.addLight(light);
    }

    @Override
    public void updateLight(final Light light) {
//        Light light1 = (Light)

        EntityManager entityManager = Persistence.createEntityManagerFactory("")

        Light light1 = lightDao.getOne(light.getId());
        if(light1 != null) {
            entit
            light.
            lightDao.
        }
        lightDao.save(light);
    }

    @Override
    public void removeLightById(final String lightId) {
        lightDao.removeLightById(lightId);
    }

    @Override
    public void switchOffAllLights() {
        Map<String, Light> lights = lightDao.findAll().stream().collect(Collectors.toMap(Light::getId, e -> e));
        lights.forEach((lightId, light) -> switchLight(light, Light.State.OFF));
    }

    @Override
    public void switchLight(final String lightId, final Light.State state) {
        if (lightId != null && state != null) {
            Light light = lightDao.getOne(lightId);
            if(light != null) {
                switchLight(light, state);
            }
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
        return lightDao.findByState(Light.State.ON);
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
        lightDao.save(light);
        //lightDao.updateLight(light);
    }
}
