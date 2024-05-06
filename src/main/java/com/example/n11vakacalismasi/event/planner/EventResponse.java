package com.example.n11vakacalismasi.event.planner;

import com.example.n11vakacalismasi.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalTime;
import java.util.Objects;

/**
 * @author : PC
 * @date : 05/06/2024
 */
@Value
@RequiredArgsConstructor
public class EventResponse {

    @JsonFormat(pattern = "hh:mma")
    private LocalTime time;

    private String title;

    private String duration;

    public EventResponse(LocalTime time, String title, long duration) {
        this.time = time;
        this.title = title;
        this.duration = Utils.convertMinutesToString(duration);
    }

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

