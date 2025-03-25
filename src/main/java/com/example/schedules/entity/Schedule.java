package com.example.schedules.entity;

import com.example.schedules.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String title;
    private String author_name;
    private String password;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Schedule(String title,String author_name,String password){
        this.title = title;
        this.author_name = author_name;
        this.password = password;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }
}
