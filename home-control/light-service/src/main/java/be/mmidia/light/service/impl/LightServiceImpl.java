package be.mmidia.light.service.impl;

import be.mmidia.light.model.Light;
import be.mmidia.light.model.LightUsage;
import be.mmidia.light.repository.LightRepository;
import be.mmidia.light.repository.LightUsageRepository;
import be.mmidia.light.service.LightService;
import java.sql.Timestamp;
import java.util.List;
import javassist.NotFoundException;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LightServiceImpl implements LightService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LightServiceImpl.class);

    private LightRepository lightRepository;
    private LightUsageRepository lightUsageRepository;

    public LightServiceImpl(final LightRepository lightRepository, final LightUsageRepository lightUsageRepository) {
        this.lightRepository = lightRepository;
        this.lightUsageRepository = lightUsageRepository;
    }

    @Override
    public List<Light> getAllLigths() {
        return lightRepository.findAll();
    }

    @Override
    public Light getLightById(final long lightId) throws NotFoundException {
        return lightRepository.findById(lightId).orElseThrow(() -> new NotFoundException("Light with id " + lightId + " not found"));
    }

    @Override
    public void createOrUpdateLight(Light light) {
        lightRepository.save(light);
    }

    @Override
    public void removeLightById(final long lightId) {
        lightRepository.deleteById(lightId);
    }

    @Override
    public void switchOffAllLights() {
        List<Light> activeLights = getActiveLigths();
        activeLights.forEach(light -> switchLight(light, Light.State.OFF));
    }

    @Override
    public void switchLight(final long lightId, final Light.State state) {
        switchLight(lightRepository.findById(lightId).orElse(null), state);
    }

    @Override
    public void switchLight(final Light light, final Light.State state) {
        startStopUsage(light, state);
    }

    @Override
    public List<LightUsage> getAllUsagesOfLight(final long lightId) {
        return lightUsageRepository.findByLightId(lightId);
    }

    @Override
    public List<Light> getActiveLigths() {
        List<Light> activeLights = lightRepository.findByState(Light.State.ON);
        return activeLights;
    }

    @Override
    public List<Light> getNonActiveLigths() {
        return lightRepository.findByState(Light.State.OFF);
    }

    private void startStopUsage(final Light light, final Light.State state) {
        // Todo: Update LightUsage anomalities
        if (light != null && !light.getState().equals(state)) {
            if (state == Light.State.OFF) {
                LightUsage lightUsage = lightUsageRepository.findLastUsageByLightId(light.getId()).orElse(null);
                if (lightUsage != null) {
                    lightUsage.setEndTime(new Timestamp(DateTime.now().getMillis()));
                    lightUsageRepository.save(lightUsage);
                    light.setState(state);
                    lightRepository.save(light);
                } else {
                    LOGGER.error("{} is recorded as ON while no record was found in database", light.getName());
                }
            } else if (state == Light.State.ON) {
                LightUsage lightUsage = new LightUsage();
                lightUsage.setLight(light);
                lightUsageRepository.save(lightUsage);

                light.setState(state);
                lightRepository.save(light);
            }
        }
    }
}
