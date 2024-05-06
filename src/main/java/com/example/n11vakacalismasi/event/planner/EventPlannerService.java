package com.example.n11vakacalismasi.event.planner;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * @author : PC
 * @date : 05/06/2024
 */

@Service
public class EventPlannerService {

    private static final int beforeNoonDuration = (int) (3 * TimeUnit.HOURS.toMinutes(1));
    private static final int afterNoonDuration = (int) (4 * TimeUnit.HOURS.toMinutes(1));
    private static final LocalTime endTime = LocalTime.of(17, 0);

    public List<Track> schedule(List<EventRequest> request) {
        List<Event> events = convertEventRequestToEvent(request);
        List<Track> tracks = new ArrayList<>();
        while (!events.isEmpty()) {
            tracks.add(createTrack(events));
        }
        return tracks;
    }

    private Track createTrack(List<Event> events) {
        List<EventResponse> trackEvent = new ArrayList<>();
        LocalTime selectedEventTime = LocalTime.of(9, 0);

        List<Event> selectedEvents = selectEventsByDuration(events, beforeNoonDuration);
        events.removeAll(selectedEvents);
        selectedEvents.addAll(selectEventsByDuration(events, afterNoonDuration));
        events.removeAll(selectedEvents);

        for (Event event : selectedEvents) {
            trackEvent.add(new EventResponse(LocalTime.of(selectedEventTime.getHour(), selectedEventTime.getMinute()), event.getTitle(), event.getDuration()));
            selectedEventTime = selectedEventTime.plusMinutes(event.getDuration());

            if (selectedEventTime.equals(LocalTime.of(12, 0))) {
                trackEvent.add(new EventResponse(LocalTime.of(12, 0), "Lunch", ""));
                selectedEventTime = LocalTime.of(13, 0);
            }
        }

        if (selectedEventTime.isAfter(LocalTime.of(16, 0))) {
            long duration = MINUTES.between(selectedEventTime, endTime);
            if (duration > 0) {
                trackEvent.add(new EventResponse(LocalTime.of(selectedEventTime.getHour(), selectedEventTime.getMinute()), "Networking", duration));
            }
        }
        return new Track(trackEvent);
    }

    private List<Event> selectEventsByDuration(List<Event> events, int totalTime) {
        int n = events.size();

        int[][] dp = new int[n + 1][totalTime + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= totalTime; j++) {
                int beforeEventDuration = events.get(i - 1).getDuration();
                if (j >= beforeEventDuration) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - beforeEventDuration] + beforeEventDuration);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        List<Event> selectedEvents = new ArrayList<>();
        int remainingTime = totalTime;
        for (int i = n; i > 0 && remainingTime > 0; i--) {
            if (dp[i][remainingTime] != dp[i - 1][remainingTime]) {
                selectedEvents.add(events.get(i - 1));
                remainingTime -= events.get(i - 1).getDuration();
            }
        }

        return selectedEvents;
    }


    private static List<Event> convertEventRequestToEvent(List<EventRequest> requests) {
        return requests.stream()
                .map(Event::new)
                .collect(Collectors.toList());
    }
}
