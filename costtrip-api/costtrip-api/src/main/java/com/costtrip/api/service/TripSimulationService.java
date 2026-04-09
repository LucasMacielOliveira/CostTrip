package com.costtrip.api.service;

import com.costtrip.api.dto.TripSimulationRequest;
import com.costtrip.api.dto.TripSimulationResponse;
import org.springframework.stereotype.Service;

@Service
public class TripSimulationService {

    public TripSimulationResponse simulate(TripSimulationRequest request) {

        double basePerDay = switch (request.getProfile()) {
            case "ECONOMICO" -> 200;
            case "CONFORTO" -> 400;
            case "LUXO" -> 800;
            default -> 300;
        };

        double total = basePerDay * request.getDays() * request.getTravelers();

        TripSimulationResponse response = new TripSimulationResponse();
        response.setDestination(request.getDestination());
        response.setDays(request.getDays());
        response.setTravelers(request.getTravelers());
        response.setProfile(request.getProfile());
        response.setEstimatedTotal(total);

        return response;
    }
}