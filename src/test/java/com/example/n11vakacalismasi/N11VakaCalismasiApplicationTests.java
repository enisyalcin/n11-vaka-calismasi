package com.example.n11vakacalismasi;

import com.example.n11vakacalismasi.event.planner.EventPlannerService;
import com.example.n11vakacalismasi.event.planner.EventRequest;
import com.example.n11vakacalismasi.event.planner.EventResponse;
import com.example.n11vakacalismasi.event.planner.Track;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class N11VakaCalismasiApplicationTests {
    private final EventPlannerService testClass = new EventPlannerService();

    private final List<EventRequest> input = new ArrayList<>() {{
        add(new EventRequest("Architecting Your Codebase", "60min"));
        add(new EventRequest("Overdoing it in Python", "45min"));
        add(new EventRequest("Flavors of Concurrency in Java", "30min"));
        add(new EventRequest("Ruby Errors from Mismatched Gem Versions", "45min"));
        add(new EventRequest("JUnit 5 - Shaping the Future of Testing on the JVM", "45min"));
        add(new EventRequest("Cloud Native Java", "lightning"));
        add(new EventRequest("Communicating Over Distance", "60min"));
        add(new EventRequest("AWS Technical Essentials", "45min"));
        add(new EventRequest("Continuous Delivery", "30min"));
        add(new EventRequest("Monitoring Reactive Applications", "30min"));
        add(new EventRequest("Pair Programming vs Noise", "45min"));
        add(new EventRequest("Rails Magic", "60min"));
        add(new EventRequest("Microservices \"Just Right\"", "60min"));
        add(new EventRequest("Clojure Ate Scala (on my project)", "45min"));
        add(new EventRequest("Perfect Scalability", "30min"));
        add(new EventRequest("Apache Spark", "30min"));
        add(new EventRequest("Async Testing on JVM", "60min"));
        add(new EventRequest("A World Without HackerNews", "30min"));
        add(new EventRequest("User Interface CSS in Apps", "30min"));
    }};

    private final List<Track> expected = new ArrayList<>() {{

//            "09:00AM","Ruby Errors from Mismatched Gem Versions","45min"
//            "09:45AM","Flavors of Concurrency in Java","30min"
//            "10:15AM","Overdoing it in Python","45min"
//            "11:00AM","Architecting Your Codebase","60min"
//            "12:00PM","Lunch",""
//            "01:00PM","Rails Magic","60min"
//            "02:00PM","Continuous Delivery","30min"
//            "02:30PM","AWS Technical Essentials","45min"
//            "03:15PM","Communicating Over Distance","60min"
//            "04:15PM","JUnit 5 - Shaping the Future of Testing on the JVM","45min"
        add(new Track(new ArrayList<EventResponse>() {{
            add(new EventResponse(LocalTime.of(9, 0), "Ruby Errors from Mismatched Gem Versions", 45));
            add(new EventResponse(LocalTime.of(9, 45), "Flavors of Concurrency in Java", 30));
            add(new EventResponse(LocalTime.of(10, 15), "Overdoing it in Python", 45));
            add(new EventResponse(LocalTime.of(11, 0), "Architecting Your Codebase", 60));
            add(new EventResponse(LocalTime.of(12, 0), "Lunch", ""));
            add(new EventResponse(LocalTime.of(13, 0), "Rails Magic", 60));
            add(new EventResponse(LocalTime.of(14, 0), "Continuous Delivery", 30));
            add(new EventResponse(LocalTime.of(14, 30), "AWS Technical Essentials", 45));
            add(new EventResponse(LocalTime.of(15, 15), "Communicating Over Distance", 60));
            add(new EventResponse(LocalTime.of(16, 15), "JUnit 5 - Shaping the Future of Testing on the JVM", 45));
        }}));
//            "09:00AM","Clojure Ate Scala (on my project)","45min"
//            "09:45AM","Microservices \"Just Right\"","60min"
//            "10:45AM","Pair Programming vs Noise","45min"
//            "11:30AM","Monitoring Reactive Applications","30min"
//            "12:00PM","Lunch",""
//            "01:00PM","User Interface CSS in Apps","30min"
//            "01:30PM","A World Without HackerNews","30min"
//            "02:00PM","Async Testing on JVM","60min"
//            "03:00PM","Apache Spark","30min"
//            "03:30PM","Perfect Scalability","30min"
//            "04:00PM","Cloud Native Java","lightning"
//            "04:05PM","Networking","55min"
        add(new Track(new ArrayList<EventResponse>() {{
            add(new EventResponse(LocalTime.of(9, 0), "Clojure Ate Scala (on my project)", 45));
            add(new EventResponse(LocalTime.of(9, 45), "Microservices \"Just Right\"", 60));
            add(new EventResponse(LocalTime.of(10, 45), "Pair Programming vs Noise", 45));
            add(new EventResponse(LocalTime.of(11, 30), "Monitoring Reactive Applications", 30));
            add(new EventResponse(LocalTime.of(12, 0), "Lunch", ""));
            add(new EventResponse(LocalTime.of(13, 0), "User Interface CSS in Apps", 30));
            add(new EventResponse(LocalTime.of(13, 30), "A World Without HackerNews", 30));
            add(new EventResponse(LocalTime.of(14, 0), "Async Testing on JVM", 60));
            add(new EventResponse(LocalTime.of(15, 0), "Apache Spark", 30));
            add(new EventResponse(LocalTime.of(15, 30), "Perfect Scalability", 30));
            add(new EventResponse(LocalTime.of(16, 0), "Cloud Native Java", 5));
            add(new EventResponse(LocalTime.of(16, 5), "Networking", 55));
        }}));
    }};

    @Test
    void contextLoads() {
        List<Track> tracks = testClass.schedule(input);
        assertThat(tracks).isEqualTo(expected);
    }

}
