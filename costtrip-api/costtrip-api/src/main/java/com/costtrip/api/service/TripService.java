package com.costtrip.api.service;

import com.costtrip.api.model.Trip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    private final List<Trip> trips = new ArrayList<>();
    private Long nextId = 1L;

    public Trip createTrip(Trip trip) {
        trip.setId(nextId);
        nextId++;

        trips.add(trip);
        return trip;
    }

    public List<Trip> listTrips() {
        return trips;
    }
}

