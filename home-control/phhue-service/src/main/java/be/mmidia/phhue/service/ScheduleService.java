package be.mmidia.phhue.service;

import be.mmidia.phhue.model.ScheduleDto;
import java.util.List;

public interface ScheduleService {
    List<ScheduleDto> getAllSchedules();

    void createSchedule(final ScheduleDto schedule);

    ScheduleDto getScheduleAttributes(final long scheduleId);

    void setScheduleAttributes(final ScheduleDto schedule);

    void deleteSchedule(final long scheduleId);
}
