package com.example.n11vakacalismasi.event.planner;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * @author : PC
 * @date : 05/06/2024
 */
@Data
@RequiredArgsConstructor
public class Track {
    List<EventResponse> events;

    public Track(List<EventResponse> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(events, track.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(events);
    }
}
