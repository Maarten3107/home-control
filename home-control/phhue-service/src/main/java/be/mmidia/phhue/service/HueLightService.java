package be.mmidia.phhue.service;

import be.mmidia.phhue.model.HueLight;
import java.util.Set;

public interface HueLightService {
    Set<HueLight> getPHHueLights();
}
