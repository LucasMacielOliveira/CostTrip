package com.costtrip.api.repository;

import com.costtrip.api.model.SimulationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationHistoryRepository extends JpaRepository<SimulationHistory, Long> {
}