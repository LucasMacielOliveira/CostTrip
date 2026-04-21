package com.costtrip.api.service;

import com.costtrip.api.dto.TripComparisonRequest;
import com.costtrip.api.dto.TripComparisonResponse;
import com.costtrip.api.dto.TripSimulationRequest;
import com.costtrip.api.dto.TripSimulationResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TripComparisonService {

    private final TripSimulationService tripSimulationService;

    public TripComparisonService(TripSimulationService tripSimulationService) {
        this.tripSimulationService = tripSimulationService;
    }

    public TripComparisonResponse compare(TripComparisonRequest request) {
        List<TripSimulationResponse> simulatedScenarios = new ArrayList<>();

        for (TripSimulationRequest scenario : request.getScenarios()) {
            TripSimulationResponse simulation = tripSimulationService.simulate(scenario);
            simulatedScenarios.add(simulation);
        }

        TripSimulationResponse bestScenario = simulatedScenarios.stream()
                .min(Comparator.comparingDouble(TripSimulationResponse::getEstimatedTotal))
                .orElseThrow(() -> new IllegalArgumentException("Nenhum cenário informado."));

        TripComparisonResponse response = new TripComparisonResponse();
        response.setScenarios(simulatedScenarios);
        response.setBestScenarioMessage(
                "Melhor cenário encontrado: "
                        + bestScenario.getDestination()
                        + " no perfil "
                        + bestScenario.getProfile()
                        + " com total estimado de "
                        + bestScenario.getCurrency()
                        + " "
                        + bestScenario.getEstimatedTotal()
        );

        return response;
    }
}