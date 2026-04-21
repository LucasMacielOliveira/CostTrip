package com.costtrip.api.service;

import com.costtrip.api.dto.ConfirmTripRequest;
import com.costtrip.api.model.ConfirmedTrip;
import com.costtrip.api.repository.ConfirmedTripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConfirmedTripService {

    private final ConfirmedTripRepository confirmedTripRepository;

    public ConfirmedTripService(ConfirmedTripRepository confirmedTripRepository) {
        this.confirmedTripRepository = confirmedTripRepository;
    }

    public ConfirmedTrip confirmTrip(ConfirmTripRequest request) {
        ConfirmedTrip confirmedTrip = new ConfirmedTrip();
        confirmedTrip.setDestination(request.getDestination());
        confirmedTrip.setDays(request.getDays());
        confirmedTrip.setTravelers(request.getTravelers());
        confirmedTrip.setProfile(request.getProfile());
        confirmedTrip.setRealBudget(request.getRealBudget());
        confirmedTrip.setChecklistStatus("PENDENTE");
        confirmedTrip.setConfirmedAt(LocalDateTime.now());

        return confirmedTripRepository.save(confirmedTrip);
    }

    public List<ConfirmedTrip> getConfirmedTrips() {
        return confirmedTripRepository.findAll();
    }
}