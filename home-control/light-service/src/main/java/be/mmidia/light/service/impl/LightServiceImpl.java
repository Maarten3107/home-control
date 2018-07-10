package be.mmidia.light.service.impl;

import be.mmidia.light.model.Light;
import be.mmidia.light.model.LightUsage;
import be.mmidia.light.repository.LightRepository;
import be.mmidia.light.repository.LightUsageRepository;
import be.mmidia.light.service.LightService;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightServiceImpl implements LightService {
    @Autowired
    private LightRepository lightRepository;
    @Autowired
    private LightUsageRepository lightUsageRepository;


    @Override
    public List<Light> getAllLigths() {
        return lightRepository.findAll();
    }

    @Override
    public Light getLightById(final String lightId) {
        return lightRepository.findById(lightId).orElse(null);
    }

    @Override
    public void createOrUpdateLight(final Light light) {
        lightRepository.save(light);
    }

    @Override
    public void removeLightById(final String lightId) {
        lightRepository.deleteById(lightId);
    }

    @Override
    public void switchOffAllLights() {
        lightRepository.findAll().forEach(light -> switchLight(light, Light.State.OFF));
    }

    @Override
    public void switchLight(final String lightId, final Light.State state) {
        /*if (lightId != null && state != null) {
            Light light = lightDao.getOne(lightId);
            if(light != null) {
                switchLight(light, state);
            }
        }*/
    }

    @Override
    public void switchLight(final Light light, final Light.State state) {
        if(light.getState() != state) {
            startStopUsage(light, state);
        }
    }

    @Override
    public List<LightUsage> getAllUsagesOfLight(final String lightId) {
        return  lightUsageRepository.findByLightId(lightId);
    }

    @Override
    public List<Light> getActiveLigths() {
        return lightRepository.findByState(Light.State.ON);
    }

    private void startStopUsage(final Light light, final Light.State state) {
        if(state == Light.State.ON) {
            LightUsage lightUsage = lightUsageRepository.findById(light.getLastUsage()).orElse(null);
            lightUsage.setEndTime(DateTime.now());
            lightUsageRepository.save(lightUsage);
            light.setState(state);
            lightRepository.save(light);
        }

        /*if(state == Light.State.ON) {
            LightUsage lightUsage = lightUsageDao.getUsageByLightUsageId(light.getLastUsage());
            lightUsage.setEndTime(DateTime.now());
            lightUsageDao.updateUsage(lightUsage);
        } else if (state == Light.State.OFF) {
            LightUsage lightUsage = new LightUsage(light.getId());
            lightUsageDao.createUsage(lightUsage);
            light.setLastUsage(lightUsage.getId());
        }

        light.setState(state);
        lightDao.save(light);*/
        //lightDao.updateLight(light);
    }
}
