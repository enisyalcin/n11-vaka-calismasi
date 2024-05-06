package com.example.n11vakacalismasi.event.planner;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
