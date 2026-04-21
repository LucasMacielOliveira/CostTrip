package com.costtrip.api.repository;

import com.costtrip.api.model.ConfirmedTrip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmedTripRepository extends JpaRepository<ConfirmedTrip, Long> {
}