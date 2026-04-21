package com.costtrip.api.dto;

import com.costtrip.api.enums.TravelProfile;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TripSimulationRequest {


    @NotBlank(message = "Destino é obrigatório")
    private String destination;

    @Min(value = 1, message = "Dias deve ser no mínimo 1")
    private int days;

    @Min(value = 1, message = "Viajantes deve ser no mínimo 1")
    private int travelers;

    @NotNull(message = "Perfil é obrigatório")
    private TravelProfile profile;

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

}

