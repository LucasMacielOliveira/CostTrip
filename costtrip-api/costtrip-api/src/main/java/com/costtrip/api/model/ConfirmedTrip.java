package com.costtrip.api.model;

import com.costtrip.api.enums.TravelProfile;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "confirmed_trip")
public class ConfirmedTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private int days;
    private int travelers;

    @Enumerated(EnumType.STRING)
    private TravelProfile profile;

    private double realBudget;
    private String checklistStatus;
    private LocalDateTime confirmedAt;

    public Long getId() {
        return id;
    }

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

    public TravelProfile getProfile() {
        return profile;
    }

    public void setProfile(TravelProfile profile) {
        this.profile = profile;
    }

    public double getRealBudget() {
        return realBudget;
    }

    public void setRealBudget(double realBudget) {
        this.realBudget = realBudget;
    }

    public String getChecklistStatus() {
        return checklistStatus;
    }

    public void setChecklistStatus(String checklistStatus) {
        this.checklistStatus = checklistStatus;
    }

    public LocalDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(LocalDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }
}