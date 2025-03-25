package com.example.schedules.dto;

import com.example.schedules.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String author_name;
    private String password;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.author_name = schedule.getAuthor_name();
        this.password = schedule.getPassword();
        this.created_at = schedule.getCreated_at();
        this.updated_at = schedule.getUpdated_at();
    }

}
