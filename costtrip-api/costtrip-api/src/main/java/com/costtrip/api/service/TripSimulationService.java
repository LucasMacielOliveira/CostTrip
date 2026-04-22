package com.costtrip.api.service;

import com.costtrip.api.dto.TripSimulationRequest;
import com.costtrip.api.dto.TripSimulationResponse;
import com.costtrip.api.model.SimulationHistory;
import com.costtrip.api.repository.SimulationHistoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripSimulationService {

    private final SimulationHistoryRepository simulationHistoryRepository;
    private final DestinationCurrencyMapper destinationCurrencyMapper;
    private final ExchangeRateService exchangeRateService;

    public TripSimulationService(SimulationHistoryRepository simulationHistoryRepository,
                                 DestinationCurrencyMapper destinationCurrencyMapper,
                                 ExchangeRateService exchangeRateService) {
        this.simulationHistoryRepository = simulationHistoryRepository;
        this.destinationCurrencyMapper = destinationCurrencyMapper;
        this.exchangeRateService = exchangeRateService;
    }

    public TripSimulationResponse simulate(TripSimulationRequest request) {

        ProfileCosts profileCosts = getProfileCosts(request);

        String destinationCurrency = destinationCurrencyMapper.getCurrencyByDestination(request.getDestination());
        BigDecimal exchangeRate = exchangeRateService.getExchangeRate(destinationCurrency);

        double flightCost = profileCosts.getFlightBase() * request.getTravelers();
        double lodgingCost = profileCosts.getLodgingPerNight() * request.getDays();
        double foodCost = profileCosts.getFoodPerDay() * request.getDays() * request.getTravelers();
        double localTransportCost = profileCosts.getTransportPerDay() * request.getDays() * request.getTravelers();
        double extraCost = profileCosts.getExtraBase() * request.getTravelers();

        double total = flightCost + lodgingCost + foodCost + localTransportCost + extraCost;

        TripSimulationResponse response = new TripSimulationResponse();
        response.setDestination(request.getDestination());
        response.setDays(request.getDays());
        response.setTravelers(request.getTravelers());
        response.setProfile(request.getProfile());
        response.setFlightCost(flightCost);
        response.setLodgingCost(lodgingCost);
        response.setFoodCost(foodCost);
        response.setLocalTransportCost(localTransportCost);
        response.setExtraCost(extraCost);
        response.setEstimatedTotal(total);
        response.setCostPerTraveler(total / request.getTravelers());
        response.setCostPerDay(total / request.getDays());
        response.setCurrency("BRL");
        response.setDestinationCurrency(destinationCurrency);
        response.setExchangeRateUsed(exchangeRate.doubleValue());
        response.setRecommendation(
                buildRecommendation(
                        total / request.getDays(),
                        request.getDays(),
                        request.getTravelers()
                )
        );

        saveSimulationHistory(response);

        return response;
    }

    public List<SimulationHistory> getSimulationHistory() {
        return simulationHistoryRepository.findAll();
    }

    private void saveSimulationHistory(TripSimulationResponse response) {
        SimulationHistory history = new SimulationHistory();
        history.setDestination(response.getDestination());
        history.setDays(response.getDays());
        history.setTravelers(response.getTravelers());
        history.setProfile(response.getProfile());
        history.setFlightCost(response.getFlightCost());
        history.setLodgingCost(response.getLodgingCost());
        history.setFoodCost(response.getFoodCost());
        history.setLocalTransportCost(response.getLocalTransportCost());
        history.setExtraCost(response.getExtraCost());
        history.setEstimatedTotal(response.getEstimatedTotal());
        history.setCostPerTraveler(response.getCostPerTraveler());
        history.setCostPerDay(response.getCostPerDay());
        history.setCurrency(response.getCurrency());
        history.setRecommendation(response.getRecommendation());
        history.setCreatedAt(LocalDateTime.now());

        simulationHistoryRepository.save(history);
    }

    private ProfileCosts getProfileCosts(TripSimulationRequest request) {
        return switch (request.getProfile()) {
            case ECONOMICO -> new ProfileCosts(1200, 180, 70, 30, 150);
            case CONFORTO -> new ProfileCosts(1800, 350, 120, 55, 300);
            case LUXO -> new ProfileCosts(3200, 750, 250, 120, 700);
        };
    }

    private String buildRecommendation(double costPerDay, int days, int travelers) {
        if (costPerDay <= 350) {
            return "Boa opção de custo-benefício para uma viagem enxuta.";
        }

        if (days >= 10 && travelers >= 2) {
            return "Viagem mais robusta: vale comparar cenários para reduzir hospedagem e transporte.";
        }

        return "Orçamento mais elevado: vale testar um perfil abaixo para comparar economia.";
    }

    private static class ProfileCosts {
        private final double flightBase;
        private final double lodgingPerNight;
        private final double foodPerDay;
        private final double transportPerDay;
        private final double extraBase;

        public ProfileCosts(double flightBase, double lodgingPerNight, double foodPerDay,
                            double transportPerDay, double extraBase) {
            this.flightBase = flightBase;
            this.lodgingPerNight = lodgingPerNight;
            this.foodPerDay = foodPerDay;
            this.transportPerDay = transportPerDay;
            this.extraBase = extraBase;
        }

        public double getFlightBase() {
            return flightBase;
        }

        public double getLodgingPerNight() {
            return lodgingPerNight;
        }

        public double getFoodPerDay() {
            return foodPerDay;
        }

        public double getTransportPerDay() {
            return transportPerDay;
        }

        public double getExtraBase() {
            return extraBase;
        }
    }
    public static class LocalCosts{
        private double foodPerDayLocal;
        private double transportPerDayLocal;
        private double extraBaseLocal;

        public LocalCosts() {
        }

        public double getFoodPerDayLocal() {
            return foodPerDayLocal;
        }

        public double getTransportPerDayLocal () {
            return transportPerDayLocal;
        }

        public double getExtraBaseLocal () {
            return extraBaseLocal;
        }

    }
    private LocalCosts getLocalCosts(TripSimulationRequest request) {
        return switch (request.getProfile()) {
            case ECONOMICO -> {
                LocalCosts costs = new LocalCosts();
                costs.foodPerDayLocal = 2000;
                costs.transportPerDayLocal = 1200;
                costs.extraBaseLocal = 500;
                yield costs;
            }
            case CONFORTO -> {
                LocalCosts costs = new LocalCosts();
                costs.foodPerDayLocal = 3500;
                costs.transportPerDayLocal = 2000;
                costs.extraBaseLocal = 800;
                yield costs;
            }
            case LUXO -> {
                LocalCosts costs = new LocalCosts();
                costs.foodPerDayLocal = 5000;
                costs.transportPerDayLocal = 3500;
                costs.extraBaseLocal = 1500;
                yield costs;
            }

        };
    };


    }





