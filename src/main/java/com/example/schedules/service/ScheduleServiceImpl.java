package com.example.schedules.service;

import com.example.schedules.dto.ScheduleRequestDto;
import com.example.schedules.dto.ScheduleResponseDto;
import com.example.schedules.entity.Schedule;
import com.example.schedules.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
    @Override
    public List<ScheduleResponseDto> findAllSchedules(){
        return scheduleRepository.findAllSchedules();
    }
    @Override
    public ScheduleResponseDto findScheduleById(Long id){
        Optional<Schedule> optionalSchedule = scheduleRepository.findScheduleById(id);
        if(optionalSchedule.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        return new ScheduleResponseDto(optionalSchedule.get());

    }
    @Override
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto){
        if (requestDto.getTitle() == null || requestDto.getAuthor_name() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }

        int updatedRow = scheduleRepository.updateSchedule(id, requestDto);

        if (updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data has been modified.");
        }

        return new ScheduleResponseDto(scheduleRepository.findScheduleById(id).get());
    }
}
