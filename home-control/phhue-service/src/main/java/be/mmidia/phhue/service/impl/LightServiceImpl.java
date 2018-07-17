package be.mmidia.phhue.service.impl;

import be.mmidia.phhue.model.LightDto;
import be.mmidia.phhue.service.LightService;
import java.util.List;

public class LightServiceImpl implements LightService {

    @Override
    // /api/<username>/lights (GET)
    public List<LightDto> getAllLights() {
        return null;
    }

    @Override
    // /api/<username>/lights/new (GET)
    public List<LightDto> getNewLights() {
        return null;
    }

    @Override
    // /api/<username>/lights (POST)
    public List<LightDto> searchForNewLights() {
        return null;
    }

    @Override
    // /api/<username>/lights/<id> (GET)
    public LightDto getLightAttributesAndState(long lightId) {
        return null;
    }

    @Override
    // /api/<username>/lights/<id> (POST)
    public void setLightAttributes(LightDto lightDto) {
        //LightDto.builder().state(LightDto.State.builder().build())

    }

    @Override
    // 	/api/<username>/lights/<id>/state (PUT)
    public void setLightState(LightDto lightDto) {

    }

    @Override
    // /api/<username>/lights/<id> (DELETE)
    public void deleteLights(long lightId) {

    }
}
