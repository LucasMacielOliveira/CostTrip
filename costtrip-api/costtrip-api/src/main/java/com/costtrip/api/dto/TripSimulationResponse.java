package com.costtrip.api.dto;

public class TripSimulationResponse {

    private String destination;
    private int days;
    private int travelers;
    private String profile;
    private double estimatedTotal;

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

    public double getEstimatedTotal() {
        return estimatedTotal;
    }

    public void setEstimatedTotal(double estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }
}