package com.costtrip.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TripSimulationRequest {

    @NotBlank(message = "Destination is required")
    private String destination;

    @Min(value = 1, message = "Days must be at least 1")
    private int days;

    @Min(value = 1, message = "Travelers must be at least 1")
    private int travelers;

    @NotBlank(message = "Profile is required")
    private String profile;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTravelers() {
        return travelers;
    }

    public void setTravelers(int travelers) {
        this.travelers = travelers;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}