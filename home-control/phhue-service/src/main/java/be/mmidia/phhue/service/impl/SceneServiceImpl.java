package be.mmidia.phhue.service.impl;

import be.mmidia.phhue.model.SceneDto;
import be.mmidia.phhue.service.SceneService;
import java.util.List;

public class SceneServiceImpl implements SceneService {
    @Override
    // /api/<username>/scenes (GET)
    public List<SceneDto> getAllScenes() {
        return null;
    }

    @Override
    // /api/<username>/scenes/<id> (GET)
    public SceneDto getScene(long sceneId) {
        return null;
    }

    @Override
    // /api/<username>/scenes/ (POST)
    public void createScene(SceneDto scene) {

    }

    @Override
    // /api/<username>/scenes/<id>/lightstates/<id> (PUT)
    public void modifyScene(SceneDto scene) {

    }

    @Override
    // /api/<username>/scenes/<id> (DELETE)
    public void deleteScene(long sceneId) {

    }
}
