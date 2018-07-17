package be.mmidia.phhue.service;

import be.mmidia.phhue.model.ConfigDto;
import be.mmidia.phhue.model.HueObjectDto;
import be.mmidia.phhue.model.SceneDto;
import java.util.List;

public interface ConfigurationService {
    void createUser();

    ConfigDto getConfiguration();

    void modifyConfiguration(final ConfigDto config);

    void deleteUserFromWhitelist(final String username);

    HueObjectDto getFullState();
}
