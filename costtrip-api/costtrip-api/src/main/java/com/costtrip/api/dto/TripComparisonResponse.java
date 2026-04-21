package com.costtrip.api.dto;

import java.util.List;

public class TripComparisonResponse {

    private List<TripSimulationResponse> scenarios;
    private String bestScenarioMessage;

    public List<TripSimulationResponse> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<TripSimulationResponse> scenarios) {
        this.scenarios = scenarios;
    }

    public String getBestScenarioMessage() {
        return bestScenarioMessage;
    }

    public void setBestScenarioMessage(String bestScenarioMessage) {
        this.bestScenarioMessage = bestScenarioMessage;
    }
}