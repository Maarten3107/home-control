package be.mmidia.light.service.impl;

import be.mmidia.light.model.Group;
import be.mmidia.light.model.Light;
import be.mmidia.light.model.LightUsage;
import be.mmidia.light.repository.LightRepository;
import be.mmidia.light.repository.LightUsageRepository;
import be.mmidia.light.service.GroupService;
import be.mmidia.light.service.LightService;
import java.util.List;
import java.util.ListIterator;
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
    private GroupService groupService;

    public LightServiceImpl(final LightRepository lightRepository, final LightUsageRepository lightUsageRepository, final GroupService groupService) {
        this.lightRepository = lightRepository;
        this.lightUsageRepository = lightUsageRepository;
        this.groupService = groupService;
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
        //lightRepository.findAll().forEach(light -> switchLight(light, Light.State.OFF));
        getActiveLigths().forEach(light -> switchLight(light, Light.State.OFF));
    }

    @Override
    public void switchGroupOfLights(long groupId, Light.State state) {
        groupService.getMembers(groupId).forEach(member -> switchLight(member, state));
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
        return lightRepository.findByState(Light.State.ON);
    }

    @Override
    public List<Light> getNonActiveLigths() {
        return lightRepository.findByState(Light.State.OFF);
    }

    private void startStopUsage(final Light light, final Light.State state) {
        // Todo: Update LightUsage anomalities
        if (light != null && !light.getState().equals(state)) {
            if (state == Light.State.ON) {
                //LightUsage lightUsage = lightUsageRepository.findById(light.getLastUsage().getId()).orElse(null);
                LightUsage lightUsage = lightUsageRepository.findLastUsageById(light.getId()).orElse(null);
                if (lightUsage != null) {
                    lightUsage.setEndTime(DateTime.now());
                    lightUsageRepository.save(lightUsage);
                    light.setState(state);
                    lightRepository.save(light);
                } else {
                    LOGGER.error("{} is recorded as ON while no record was found in database", light.getName());
                }
            } else if (state == Light.State.OFF) {
                lightUsageRepository.save(new LightUsage());
                light.setState(state);
                lightRepository.save(light);
            }
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
