package com.example.schedules.controller;

import com.example.schedules.dto.ScheduleRequestDto;
import com.example.schedules.dto.ScheduleResponseDto;
import com.example.schedules.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto){
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ScheduleResponseDto> findAllSchedules(){
        return scheduleService.findAllSchedules();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id){
        return new ResponseEntity<>(scheduleService.findScheduleById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateScheduleById(@PathVariable Long id,@RequestBody ScheduleRequestDto requestDto){
        return new ResponseEntity<>(scheduleService.updateSchedule(id,requestDto),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheduleById(@PathVariable Long id,@RequestBody String password){
        scheduleService.deleteSchedule(id,password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
