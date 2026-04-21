package com.costtrip.api.controller;

import com.costtrip.api.dto.ConfirmTripRequest;
import com.costtrip.api.dto.TripComparisonRequest;
import com.costtrip.api.dto.TripComparisonResponse;
import com.costtrip.api.dto.TripSimulationRequest;
import com.costtrip.api.dto.TripSimulationResponse;
import com.costtrip.api.model.ConfirmedTrip;
import com.costtrip.api.model.SimulationHistory;
import com.costtrip.api.service.ConfirmedTripService;
import com.costtrip.api.service.TripComparisonService;
import com.costtrip.api.service.TripSimulationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripSimulationController {

    private final TripSimulationService tripSimulationService;
    private final TripComparisonService tripComparisonService;
    private final ConfirmedTripService confirmedTripService;

    public TripSimulationController(TripSimulationService tripSimulationService,
                                    TripComparisonService tripComparisonService,
                                    ConfirmedTripService confirmedTripService) {
        this.tripSimulationService = tripSimulationService;
        this.tripComparisonService = tripComparisonService;
        this.confirmedTripService = confirmedTripService;
    }

    @PostMapping("/simulate")
    public TripSimulationResponse simulate(@Valid @RequestBody TripSimulationRequest request) {
        return tripSimulationService.simulate(request);
    }

    @PostMapping("/compare")
    public TripComparisonResponse compare(@Valid @RequestBody TripComparisonRequest request) {
        return tripComparisonService.compare(request);
    }

    @GetMapping("/simulations")
    public List<SimulationHistory> getSimulationHistory() {
        return tripSimulationService.getSimulationHistory();
    }

    @PostMapping("/confirm")
    public ConfirmedTrip confirmTrip(@Valid @RequestBody ConfirmTripRequest request) {
        return confirmedTripService.confirmTrip(request);
    }

    @GetMapping("/confirmed")
    public List<ConfirmedTrip> getConfirmedTrips() {
        return confirmedTripService.getConfirmedTrips();
    }
}