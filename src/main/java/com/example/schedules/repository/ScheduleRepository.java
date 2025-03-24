package com.example.schedules.repository;

import com.example.schedules.dto.ScheduleResponseDto;
import com.example.schedules.entity.Schedule;

public interface ScheduleRepository {
    ScheduleResponseDto saveSchedule(Schedule schedule);
}
