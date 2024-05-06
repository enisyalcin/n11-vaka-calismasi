package com.example.n11vakacalismasi.event.planner;

import com.example.n11vakacalismasi.utils.Utils;
import lombok.Value;

/**
 * @author : PC
 * @date : 05/06/2024
 */
@Value
public class Event {

    private String title;

    private int duration;

    public Event(EventRequest eventRequest) {
        this.title = eventRequest.getTitle();
        this.duration = Utils.convertDurationToMinutes(eventRequest.getDuration());
    }
}