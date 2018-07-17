package be.mmidia.phhue.service;

import be.mmidia.phhue.model.LightDto;
import java.util.List;

public interface LightService {
    List<LightDto> getAllLights();

    List<LightDto> getNewLights();

    List<LightDto> searchForNewLights();

    LightDto getLightAttributesAndState(final long lightId);

    void setLightAttributes(final LightDto lightDto);

    void setLightState(final LightDto lightDto);

    void deleteLights(final long lightId);
}
