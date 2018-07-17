package be.mmidia.phhue.service.impl;

import be.mmidia.phhue.model.ScheduleDto;
import be.mmidia.phhue.service.ScheduleService;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    @Override
    // /api/<username>/schedules (GET)
    public List<ScheduleDto> getAllSchedules() {
        return null;
    }

    @Override
    // /api/<username>/schedules (POST)
    public void createSchedule(ScheduleDto schedule) {

    }

    @Override
    // /api/<username>/schedules/<id> (GET)
    public ScheduleDto getScheduleAttributes(long scheduleId) {
        return null;
    }

    @Override
    // 	/api/<username>/schedules/<id> (PUT)
    public void setScheduleAttributes(ScheduleDto schedule) {

    }

    @Override
    // /api/<username>/schedules/<id> (DELETE)
    public void deleteSchedule(long scheduleId) {

    }
}
