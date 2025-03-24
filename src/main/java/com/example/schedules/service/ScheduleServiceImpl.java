package com.example.schedules.service;

import com.example.schedules.dto.ScheduleRequestDto;
import com.example.schedules.dto.ScheduleResponseDto;
import com.example.schedules.entity.Schedule;
import com.example.schedules.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto){
        Schedule schedule = new Schedule(requestDto.getTitle(), requestDto.getAuthor_name(), requestDto.getPassword());

        return scheduleRepository.saveSchedule(schedule);
    }
}
