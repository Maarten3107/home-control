package be.mmidia.phhue.service;

import be.mmidia.phhue.model.SceneDto;
import java.util.List;

public interface SceneService {
    List<SceneDto> getAllScenes();

    SceneDto getScene(final long sceneId);

    void createScene(final SceneDto scene);

    void modifyScene(final SceneDto scene);

    void deleteScene(final long sceneId);
}
