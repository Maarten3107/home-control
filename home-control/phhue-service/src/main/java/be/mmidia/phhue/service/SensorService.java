package be.mmidia.phhue.service;

import be.mmidia.phhue.model.SensorDto;
import java.util.List;

public interface SensorService {
    List<SensorDto> getAllSensors();

    SensorDto getSensor(final long id);

    void createSensor(final SensorDto sensor);

    String findNewSensors();

    List<SensorDto> getNewSensors();

    void updateSensor(final SensorDto sensor);

    void deleteSensor(final long sensorId);

    void changeSensorConfig(final SensorDto sensorDto);

    void changeSensorState(final SensorDto sensorDto);
}
