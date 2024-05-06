package com.example.n11vakacalismasi.event.planner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

/**
 * @author : PC
 * @date : 05/06/2024
 */
@Value
public class Event {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Duration is required")
    @Pattern(regexp = "^(\\d+min|lightning)$", message = "Invalid duration format")
    private String duration; // event duration minute


}