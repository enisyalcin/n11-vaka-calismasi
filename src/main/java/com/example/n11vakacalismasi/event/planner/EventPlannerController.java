package com.example.n11vakacalismasi.event.planner;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : PC
 * @date : 05/06/2024
 */

@RestController
@RequestMapping("${api.root}/event-planner")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class EventPlannerController {
    private final EventPlannerService eventPlannerService;

    @PostMapping
    public ResponseEntity<List<Track>> schedule(@RequestBody List<EventRequest> events) {
        List<Track> eventsPlanned = eventPlannerService.schedule(events);
        return new ResponseEntity<>(eventsPlanned, HttpStatus.OK);
    }
}
