package com.costtrip.api.controller;

import com.costtrip.api.dto.TripSimulationRequest;
import com.costtrip.api.dto.TripSimulationResponse;
import com.costtrip.api.service.TripSimulationService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trips")
public class TripSimulationController {

    private final TripSimulationService service;

    public TripSimulationController(TripSimulationService service) {
        this.service = service;
    }

    @PostMapping("/simulate")
    public TripSimulationResponse simulate(@Valid @RequestBody TripSimulationRequest request) {
        return service.simulate(request);
        }
    }