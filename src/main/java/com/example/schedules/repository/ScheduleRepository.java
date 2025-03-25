package com.example.schedules.repository;

import com.example.schedules.dto.ScheduleRequestDto;
import com.example.schedules.dto.ScheduleResponseDto;
import com.example.schedules.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {


    ScheduleResponseDto saveSchedule(Schedule schedule);
    List<ScheduleResponseDto> findAllSchedules();
    Optional<Schedule> findScheduleById(Long id);
    int updateSchedule(Long id, ScheduleRequestDto requestDto);
    int deleteSchedule(Long id,String password);
}
