package be.mmidia.phhue.service.impl;

import be.mmidia.phhue.model.SensorDto;
import be.mmidia.phhue.service.SensorService;
import java.util.List;

public class SensorServiceImpl implements SensorService {

    @Override
    // /api/<username>/sensors (GET)
    public List<SensorDto> getAllSensors() {
        return null;
    }

    @Override
    // /api/<username>/sensors/<id> (GET)
    public SensorDto getSensor(long id) {
        return null;
    }

    @Override
    // /api/<username>/sensors (POST)
    public void createSensor(SensorDto sensor) {

    }

    @Override
    // /api/<username>/sensors (POST)
    public String findNewSensors() {
        return null;
    }

    @Override
    // /api/<username>/sensors/new (GET)
    public List<SensorDto> getNewSensors() {
        return null;
    }

    @Override
    // 	/api/<username>/sensors/<id> (PUT)
    public void updateSensor(SensorDto sensor) {

    }

    @Override
    // /api/<username>/sensors/<id> (DELETE)
    public void deleteSensor(long sensorId) {

    }

    @Override
    // /api/<username>/sensors/<id>/config (PUT)
    public void changeSensorConfig(SensorDto sensorDto) {

    }

    @Override
    // /api/<username>/sensors/<id>/state (PUT)
    public void changeSensorState(SensorDto sensorDto) {

    }
}
