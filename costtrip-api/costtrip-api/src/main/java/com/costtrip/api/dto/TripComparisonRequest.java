package com.costtrip.api.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class TripComparisonRequest {

    @NotEmpty(message = "Lista de cenários não pode estar vazia")
    private List<TripSimulationRequest> scenarios;

    public List<TripSimulationRequest> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<TripSimulationRequest> scenarios) {
        this.scenarios = scenarios;
    }
}