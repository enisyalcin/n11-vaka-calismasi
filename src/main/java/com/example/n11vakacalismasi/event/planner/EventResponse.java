package com.example.n11vakacalismasi.event.planner;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalTime;
import java.util.Objects;

/**
 * @author : PC
 * @date : 05/06/2024
 */
@Value
public class EventResponse {

    @JsonFormat(pattern = "hh:mma")
    private LocalTime time;

    private String title;

    private String duration;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventResponse that = (EventResponse) o;
        return Objects.equals(time, that.time) && Objects.equals(title, that.title) && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, title, duration);
    }
}

